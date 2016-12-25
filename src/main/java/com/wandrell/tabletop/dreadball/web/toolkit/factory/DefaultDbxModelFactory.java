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
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.wandrell.tabletop.dreadball.factory.DbxModelFactory;
import com.wandrell.tabletop.dreadball.model.availability.unit.DefaultSponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.persistence.availability.unit.PersistentSponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.calculator.RankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.AffinityLevel;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.DefaultAffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.DefaultUnit;
import com.wandrell.tabletop.dreadball.model.unit.Role;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.Attributes;
import com.wandrell.tabletop.dreadball.rules.DbxRules;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorForm;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityGroupRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityUnitRepository;

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
    private final AffinityGroupRepository         affinitiesRepository;

    /**
     * DBX rules service.
     */
    private final DbxRules                        dbxRules;

    /**
     * Initial rank.
     */
    @Value("${sponsor.rank.initial}")
    private Integer                               initialRank;

    /**
     * Rank cost calculator.
     */
    private RankCostCalculator                    rankCostCalculator;

    /**
     * Affinity units repository.
     */
    private final AffinityUnitRepository          unitRepository;

    /**
     * Team valoration calculator.
     */
    private TeamValorationCalculator<SponsorTeam> valorationCalculator;

    /**
     * Default constructor.
     * 
     * @param rules
     *            DBX rules service
     * @param unitRepo
     *            affinity units repository
     * @param affinitiesRepo
     *            affinities repository
     */
    @Autowired
    public DefaultDbxModelFactory(final DbxRules rules,
            final AffinityUnitRepository unitRepo,
            final AffinityGroupRepository affinitiesRepo) {
        super();
        dbxRules = checkNotNull(rules,
                "Received a null pointer as rules service");

        unitRepository = checkNotNull(unitRepo,
                "Received a null pointer as units repository");
        affinitiesRepository = checkNotNull(affinitiesRepo,
                "Received a null pointer as affinities repository");
    }

    @Override
    public final Sponsor getSponsor(final SponsorForm form) {
        final Sponsor sponsor;               // Created sponsor
        final Collection<String> affinities; // Affinities list

        checkNotNull(form, "Received a null pointer as sponsor form");

        sponsor = new DefaultSponsor();

        sponsor.setName(form.getSponsorName());

        sponsor.setRank(getInitialRank());

        // TODO: The affinities should come as a list
        // Loads affinities
        affinities = new LinkedList<String>();
        affinities.add(form.getAffinityA());
        affinities.add(form.getAffinityB());
        affinities.add(form.getAffinityC());
        affinities.add(form.getAffinityD());
        affinities.add(form.getAffinityE());

        // Searchs for rank increase tags
        while (affinities.contains("rank")) {
            sponsor.setRank(sponsor.getRank() + 1);
            affinities.remove("rank");
        }

        // TODO: Maybe the factory should not use the repository
        // Creates the affinities
        for (final String affinity : affinities) {
            sponsor.addAffinityGroup(
                    getAffinityGroupRepository().findByName(affinity));
        }

        return sponsor;
    }

    @Override
    public final SponsorAffinityGroupAvailability
            getSponsorAffinityGroupAvailability(
                    final PersistentSponsorAffinityGroupAvailability aff) {
        final Collection<AffinityGroup> affinities;

        // TODO: This may be better inside the factory

        affinities = new ArrayList<>();
        for (final AffinityGroup affinity : aff.getAffinityGroups()) {
            affinities.add(new DefaultAffinityGroup(affinity.getName()));
        }

        return new DefaultSponsorAffinityGroupAvailability(aff.getName(),
                affinities, aff.isIncludingRankIncrease());
    }

    @Override
    public final SponsorTeam getSponsorTeam(final Sponsor sponsor) {
        final SponsorTeam team; // Created team

        checkNotNull(sponsor, "Received a null pointer as sponsor");

        team = new DefaultSponsorTeam(sponsor,
                getSponsorTeamValorationCalculator(), getRankCostCalculator());

        return team;
    }

    @Override
    public final Unit getUnit(final String nameTemplate, final Integer cost,
            final Role role, final Attributes attributes,
            final Collection<Ability> abilities, final Boolean mvp,
            final Boolean giant) {
        final DefaultUnit unit;

        unit = new DefaultUnit(nameTemplate, cost, role, attributes, abilities,
                mvp, giant);
        unit.setName(nameTemplate);

        return unit;
    }

    @Override
    public final Unit getUnit(final String templateName,
            final Iterable<AffinityGroup> affinities) {
        final AffinityUnit affUnit;  // Unit from the repository
        final Integer cost;          // Unit cost
        final Unit unit;             // Unit to add
        AffinityLevel affinityLevel; // Affinity level relationship

        checkNotNull(templateName, "Received a null pointer as template name");
        checkNotNull(affinities, "Received a null pointer as affinities");

        affUnit = getAffinityUnitRepository()
                .findOneByTemplateName(templateName);

        if (affUnit != null) {
            affinityLevel = getDbxRules().getAffinityLevel(affUnit, affinities);
            cost = getDbxRules().getUnitCost(affinityLevel, affUnit);

            unit = getUnit(affUnit.getTemplateName(), cost, affUnit.getRole(),
                    affUnit.getAttributes(), affUnit.getAbilities(),
                    affUnit.getMvp(), affUnit.getGiant());
        } else {
            unit = null;
        }

        return unit;
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
     * Returns the affinity unit repository.
     * 
     * @return the affinity unit repository
     */
    private final AffinityUnitRepository getAffinityUnitRepository() {
        return unitRepository;
    }

    /**
     * Returns the DBX rules.
     * 
     * @return the DBX rules
     */
    private final DbxRules getDbxRules() {
        return dbxRules;
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
