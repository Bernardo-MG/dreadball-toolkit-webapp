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

package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.build.dbx.DbxSponsorBuilder;
import com.wandrell.tabletop.dreadball.factory.DbxModelFactory;
import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.persistence.unit.PersistentAffinityUnit;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.AffinityLevel;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.rules.DbxRules;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorForm;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.availability.SponsorAffinityGroupAvailabilityRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityUnitRepository;

/**
 * Default implementation of the {@code DbxSponsorBuilder}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Service
public class DefaultDbxSponsorBuilder implements DbxSponsorBuilder {

    /**
     * Sponsor affinity groups availabilities repository.
     */
    private final SponsorAffinityGroupAvailabilityRepository affinityAvasRepository;

    /**
     * DBX model factory.
     */
    private final DbxModelFactory                            dbxModelFact;

    /**
     * DBX rules.
     */
    private final DbxRules                                   dbxRules;

    /**
     * Initial rank.
     */
    @Value("${sponsor.rank.initial}")
    private final Integer                                    initialRank;

    /**
     * Affinity units repository.
     */
    private final AffinityUnitRepository                     unitRepository;

    /**
     * Constructs a builder with the specified dependencies.
     * 
     * @param modelFact
     *            model factory
     * @param rules
     *            ruleset
     * @param affinityAvasRepo
     *            affinity availabilities repository
     * @param unitRepo
     *            units repository
     * @param rank
     *            initial rank
     */
    @Autowired
    public DefaultDbxSponsorBuilder(final DbxModelFactory modelFact,
            final DbxRules rules,
            final SponsorAffinityGroupAvailabilityRepository affinityAvasRepo,
            final AffinityUnitRepository unitRepo,
            @Value("${sponsor.rank.initial}") final Integer rank) {
        super();

        dbxModelFact = checkNotNull(modelFact,
                "Received a null pointer as model factory");
        dbxRules = checkNotNull(rules,
                "Received a null pointer as rules service");

        affinityAvasRepository = checkNotNull(affinityAvasRepo,
                "Received a null pointer as affinities availabilities repository");
        unitRepository = checkNotNull(unitRepo,
                "Received a null pointer as units repository");

        initialRank = checkNotNull(rank,
                "Received a null pointer as initial rank");
    }

    @Override
    public final Iterable<SponsorAffinityGroupAvailability>
            getAvailableAffinityGroups() {
        final Collection<SponsorAffinityGroupAvailability> affs;

        affs = new LinkedList<SponsorAffinityGroupAvailability>();
        for (final SponsorAffinityGroupAvailability aff : getSponsorAffinityGroupAvailabilityRepository()
                .findAll()) {
            // TODO: Copy these to new beans
            affs.add(aff);
        }

        return affs;
    }

    @Override
    public final Iterable<Unit>
            getAvailableUnits(final Iterable<AffinityGroup> affinities) {
        final Collection<Unit> units;          // Available units
        final Iterable<PersistentAffinityUnit> filtered; // Filtered units
        final Collection<String> affNames;     // Filtered units
        Integer cost;                          // Unit cost
        Unit unit;                             // Available unit

        checkNotNull(affinities, "Received a null pointer as affinities");

        affNames = new ArrayList<>();
        for (final AffinityGroup affinity : affinities) {
            affNames.add(affinity.getName());
        }

        filtered = getAffinityUnitRepository()
                .findAllFilteredByHatedAffinities(affNames);
        units = new LinkedList<Unit>();
        for (final AffinityUnit affUnit : filtered) {
            cost = getUnitCost(affUnit, affinities);

            unit = getDbxModelFactory().getUnit(affUnit.getTemplateName(), cost,
                    affUnit.getRole(), affUnit.getAttributes(),
                    affUnit.getAbilities(), affUnit.getMvp(),
                    affUnit.getGiant());

            units.add(unit);
        }

        return units;
    }

    @Override
    public final Integer getInitialRank() {
        return initialRank;
    }

    @Override
    public final Sponsor getSponsor(final SponsorForm form) {
        return getDbxModelFactory().getSponsor(form);
    }

    @Override
    public final SponsorTeam getSponsorTeam(final Sponsor sponsor) {
        return getDbxModelFactory().getSponsorTeam(sponsor);
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
     * Returns the model factory.
     * 
     * @return the model factory
     */
    private final DbxModelFactory getDbxModelFactory() {
        return dbxModelFact;
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
     * Returns the Sponsor affinity groups availabilities repository.
     * 
     * @return the Sponsor affinity groups availabilities repository
     */
    private final SponsorAffinityGroupAvailabilityRepository
            getSponsorAffinityGroupAvailabilityRepository() {
        return affinityAvasRepository;
    }

    /**
     * Returns the actual cost for a unit for a sponsor.
     * 
     * @param unit
     *            unit to find the cost for
     * @param affinities
     *            sponsor affinities
     * @return the cost of the unit for the sponsor
     */
    private final Integer getUnitCost(final AffinityUnit unit,
            final Iterable<AffinityGroup> affinities) {
        final AffinityLevel affinityLevel;  // Affinity level relationship

        affinityLevel = getDbxRules().getAffinityLevel(unit, affinities);

        return getDbxRules().getUnitCost(affinityLevel, unit);
    }

}
