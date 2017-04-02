/**
 * Copyright 2015-2016 the original author or authors
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

package com.wandrell.tabletop.dreadball.web.toolkit.factory;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.wandrell.tabletop.dreadball.factory.DbxModelFactory;
import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.calculator.RankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.DefaultAffinityGroup;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorForm;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityGroupRepository;

/**
 * Default implementation of {@code DbxModelFactory}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Component
public class DefaultDbxModelFactory implements DbxModelFactory {

    /**
     * Affinity groups repository.
     */
    private final AffinityGroupRepository               affinitiesRepository;

    /**
     * Initial rank.
     */
    @Value("${sponsor.rank.initial}")
    private Integer                                     initialRank;

    /**
     * Rank cost calculator.
     */
    private final RankCostCalculator                    rankCostCalculator;

    /**
     * Team valoration calculator.
     */
    private final TeamValorationCalculator<SponsorTeam> valorationCalculator;

    /**
     * Default constructor.
     * 
     * @param rules
     *            DBX rules service
     * @param unitRepo
     *            affinity units repository
     * @param affinitiesRepo
     *            affinities repository
     * @param valorationCalc
     *            valoration calculator
     * @param rankCostCalc
     *            rank cost calculator
     */
    @Autowired
    public DefaultDbxModelFactory(final AffinityGroupRepository affinitiesRepo,
            final TeamValorationCalculator<SponsorTeam> valorationCalc,
            final RankCostCalculator rankCostCalc) {
        super();

        affinitiesRepository = checkNotNull(affinitiesRepo,
                "Received a null pointer as affinities repository");
        valorationCalculator = checkNotNull(valorationCalc,
                "Received a null pointer as valoration calculator");
        rankCostCalculator = checkNotNull(rankCostCalc,
                "Received a null pointer as valoration calculator");
    }

    @Override
    public final Sponsor getSponsor(final SponsorForm form) {
        final Sponsor sponsor;               // Created sponsor
        final Collection<String> affinities; // Affinities list
        AffinityGroup affinityGroup;

        checkNotNull(form, "Received a null pointer as sponsor form");

        sponsor = new DefaultSponsor();

        sponsor.setName(form.getSponsorName());

        sponsor.setRank(getInitialRank());

        // Loads affinities
        affinities = new ArrayList<>();
        if (form.getAffinityA() != null) {
            affinities.add(form.getAffinityA());
        }
        if (form.getAffinityB() != null) {
            affinities.add(form.getAffinityB());
        }
        if (form.getAffinityC() != null) {
            affinities.add(form.getAffinityC());
        }
        if (form.getAffinityD() != null) {
            affinities.add(form.getAffinityD());
        }
        if (form.getAffinityE() != null) {
            affinities.add(form.getAffinityE());
        }

        // Searchs for rank increase tags
        while (affinities.contains("rank")) {
            sponsor.setRank(sponsor.getRank() + 1);
            affinities.remove("rank");
        }

        // Creates the affinities
        for (final String affinity : affinities) {
            affinityGroup = getAffinityGroupRepository().findByName(affinity);
            checkNotNull(affinityGroup,
                    String.format("Affinity %s not found", affinity));
            sponsor.addAffinityGroup(getAffinityGroup(affinityGroup));
        }

        return sponsor;
    }

    @Override
    public final SponsorTeam getSponsorTeam(final Sponsor sponsor) {
        final SponsorTeam team; // Created team

        checkNotNull(sponsor, "Received a null pointer as sponsor");

        team = new DefaultSponsorTeam(sponsor,
                getSponsorTeamValorationCalculator(), getRankCostCalculator());

        return team;
    }

    private final AffinityGroup getAffinityGroup(final AffinityGroup affinity) {
        return new DefaultAffinityGroup(affinity.getName());
    }

    /**
     * Returns the affinity groups repository.
     * 
     * @return the affinity groups repository
     */
    private final AffinityGroupRepository getAffinityGroupRepository() {
        return affinitiesRepository;
    }

    /**
     * Returns the initial rank.
     * 
     * @return the initial rank
     */
    private final Integer getInitialRank() {
        return initialRank;
    }

    /**
     * Returns the rank cost calculator.
     * 
     * @return the rank cost calculator
     */
    private final RankCostCalculator getRankCostCalculator() {
        return rankCostCalculator;
    }

    /**
     * Returns the team valoration calculator.
     * 
     * @return the team valoration calculator
     */
    private final TeamValorationCalculator<SponsorTeam>
            getSponsorTeamValorationCalculator() {
        return valorationCalculator;
    }

}
