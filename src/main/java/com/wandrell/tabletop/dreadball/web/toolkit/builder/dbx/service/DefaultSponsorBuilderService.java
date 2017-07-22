
package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.build.dbx.SponsorCosts;
import com.wandrell.tabletop.dreadball.build.dbx.SponsorDefaults;
import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.calculator.CostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.DefaultRankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.SponsorTeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorAffinitiesOptions;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorAffinitiesSelection;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorTeamOptions;

@Service
public class DefaultSponsorBuilderService implements SponsorBuilderService {

    private final SponsorCosts    costs;

    private final SponsorCosts    rankCosts;

    private final SponsorDefaults sponsorDefaults;

    @Autowired
    public DefaultSponsorBuilderService(final SponsorDefaults defaults,
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

    @Override
    public SponsorAffinitiesSelection
            getAffinitiesSelectionResult(SponsorAffinitiesOptions affinities) {
        final Integer rankAdd;
        final Integer rank;
        final Iterable<String> filtered;

        rankAdd = affinities.getAffinities().stream()
                .filter(affinity -> affinity.getName().equals("rank_increase"))
                .collect(Collectors.toList()).size();
        filtered = affinities.getAffinities().stream()
                .filter(affinity -> !affinity.getName().equals("rank_increase"))
                .map(affinity -> affinity.getName())
                .collect(Collectors.toList());

        rank = getSponsorDefaults().getInitialRank() + rankAdd;

        return new SponsorAffinitiesSelection(filtered, rank, rank, 0);
    }

    @Override
    public SponsorAffinitiesSelection
            getSelectionResult(SponsorTeamOptions team) {
        final Integer rank;
        final Iterable<String> affinityNames;
        final Integer assetCost;
        final Integer assetRankCost;
        final Integer teamValue;
        final SponsorTeam sponsorTeam;
        final Sponsor sponsor;

        sponsor = new DefaultSponsor();

        sponsorTeam = new DefaultSponsorTeam(sponsor,
                getTeamValorationCalculator(), getRankCostCalculator());
        sponsorTeam.getSponsor().setAffinityGroups(
                (Collection<AffinityGroup>) team.getAffinities());

        affinityNames = team.getAffinities().stream()
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

        rank = team.getBaseRank() - assetRankCost;
        teamValue = assetCost;

        return new SponsorAffinitiesSelection(affinityNames, rank,
                team.getBaseRank(), teamValue);
    }

    private final CostCalculator<SponsorTeam> getRankCostCalculator() {
        return new DefaultRankCostCalculator(getSponsorRankCosts().getDieCost(),
                getSponsorRankCosts().getSabotageCost(),
                getSponsorRankCosts().getSpecialMoveCost(),
                getSponsorRankCosts().getCheerleaderCost(),
                getSponsorRankCosts().getWagerCost(),
                getSponsorRankCosts().getMediBotCost());
    }

    private final SponsorCosts getSponsorCosts() {
        return costs;
    }

    private final SponsorDefaults getSponsorDefaults() {
        return sponsorDefaults;
    }

    private final SponsorCosts getSponsorRankCosts() {
        return rankCosts;
    }

    private final CostCalculator<SponsorTeam> getTeamValorationCalculator() {
        return new SponsorTeamValorationCalculator(
                getSponsorCosts().getDieCost(),
                getSponsorCosts().getSabotageCost(),
                getSponsorCosts().getSpecialMoveCost(),
                getSponsorCosts().getCheerleaderCost(),
                getSponsorCosts().getWagerCost(),
                getSponsorCosts().getMediBotCost());
    }

}
