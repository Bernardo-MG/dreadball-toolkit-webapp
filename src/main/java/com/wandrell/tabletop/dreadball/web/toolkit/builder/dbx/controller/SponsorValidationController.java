/**
 * Copyright 2016 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wandrell.tabletop.dreadball.build.dbx.SponsorCosts;
import com.wandrell.tabletop.dreadball.build.dbx.SponsorDefaults;
import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.calculator.DefaultRankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.RankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.SponsorTeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorAffinitiesSelection;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorTeamOptions;

/**
 * Controller for the affinity groups codex views.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RestController
@RequestMapping("/rest/builder/validation")
public class SponsorValidationController {

    private final SponsorCosts    rankCosts;

    private final SponsorCosts    costs;

    private final SponsorDefaults sponsorDefaults;

    /**
     * Constructs a controller with the specified dependencies.
     * 
     */
    @Autowired
    public SponsorValidationController(final SponsorDefaults defaults,
            @Qualifier("SponsorCosts") final SponsorCosts sponsorCosts,
            @Qualifier("SponsorRankCosts") final SponsorCosts sponsorRankCosts) {
        super();

        sponsorDefaults = checkNotNull(defaults,
                "Received a null pointer as Sponsor defaults service");
        costs = checkNotNull(sponsorCosts,
                "Received a null pointer as Sponsor costs");
        rankCosts = checkNotNull(sponsorRankCosts,
                "Received a null pointer as Sponsor rank costs");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final SponsorAffinitiesSelection
            getSelectionResult(final SponsorTeamOptions team) {
        final Integer rankAdd;
        final Integer rank;
        final Iterable<String> filtered;
        final Integer assetCost;
        final Integer assetRankCost;
        final Integer teamValue;
        final SponsorTeam sponsorTeam;
        final Sponsor sponsor;

        sponsor = new DefaultSponsor();

        sponsorTeam = new DefaultSponsorTeam(sponsor,
                getTeamValorationCalculator(), getRankCostCalculator());

        // TODO: This should be handled inside a service
        rankAdd = team.getAffinities().stream()
                .filter(affinity -> affinity.getName().equals("rank_increase"))
                .collect(Collectors.toList()).size();
        filtered = team.getAffinities().stream()
                .filter(affinity -> !affinity.getName().equals("rank_increase"))
                .map(affinity -> affinity.getName())
                .collect(Collectors.toList());

        sponsorTeam.setCheerleaders(team.getCheerleaders());
        sponsorTeam.setCoachingDice(team.getCoachingDice());
        sponsorTeam.setMediBots(team.getMediBots());
        sponsorTeam.setSpecialMoveCards(team.getSpecialMoveCards());
        sponsorTeam.setSabotageCards(team.getNastySurpriseCards());
        sponsorTeam.setWagers(team.getWagers());

        assetCost = sponsorTeam.getValoration();
        assetRankCost = sponsorTeam.getRankCost();

        rank = getSponsorDefaults().getInitialRank() + rankAdd - assetRankCost;
        teamValue = assetCost;

        return new SponsorAffinitiesSelection(filtered, rank, rankAdd,
                teamValue);
    }

    private final RankCostCalculator getRankCostCalculator() {
        return new DefaultRankCostCalculator(getSponsorRankCosts().getDieCost(),
                getSponsorRankCosts().getSabotageCost(),
                getSponsorRankCosts().getSpecialMoveCost(),
                getSponsorRankCosts().getCheerleaderCost(),
                getSponsorRankCosts().getWagerCost(),
                getSponsorRankCosts().getMediBotCost());
    }

    private final SponsorDefaults getSponsorDefaults() {
        return sponsorDefaults;
    }

    private final SponsorCosts getSponsorRankCosts() {
        return rankCosts;
    }

    private final SponsorCosts getSponsorCosts() {
        return costs;
    }

    private final TeamValorationCalculator<SponsorTeam>
            getTeamValorationCalculator() {
        return new SponsorTeamValorationCalculator(
                getSponsorCosts().getDieCost(),
                getSponsorCosts().getSabotageCost(),
                getSponsorCosts().getSpecialMoveCost(),
                getSponsorCosts().getCheerleaderCost(),
                getSponsorCosts().getWagerCost(),
                getSponsorCosts().getMediBotCost());
    }

}
