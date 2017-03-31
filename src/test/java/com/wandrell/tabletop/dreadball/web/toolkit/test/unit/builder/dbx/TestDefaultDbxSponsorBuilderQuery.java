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

package com.wandrell.tabletop.dreadball.web.toolkit.test.unit.builder.dbx;

import java.util.ArrayList;
import java.util.Collection;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.build.dbx.DbxSponsorBuilder;
import com.wandrell.tabletop.dreadball.factory.DbxModelFactory;
import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.persistence.availability.unit.PersistentSponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.persistence.unit.PersistentAffinityUnit;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.AffinityLevel;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.DefaultUnit;
import com.wandrell.tabletop.dreadball.model.unit.Role;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.Attributes;
import com.wandrell.tabletop.dreadball.rules.DbxRules;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorForm;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.service.DefaultDbxSponsorBuilder;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.availability.SponsorAffinityGroupAvailabilityRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityUnitRepository;

/**
 * Unit tests for {@link DbxSponsorBuilder}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestDefaultDbxSponsorBuilderQuery {

    /**
     * Default constructor.
     */
    public TestDefaultDbxSponsorBuilderQuery() {
        super();
    }

    /**
     * Tests that acquiring the available units works with the dependencies and
     * their data correctly, and returns the expected values.
     */
    @Test
    public final void testGetAvailableUnits() {
        final DbxSponsorBuilder builder;      // Builder to test
        final Iterable<? extends Unit> units; // Sponsor units
        final Iterable<AffinityGroup> affinities; // Sponsor affinities
        Integer cost;                         // Resulting cost

        // Creates the builder with the mocked dependencies
        builder = getDbxSponsorBuilder();

        // The actual contents of affinities does not matter
        // This is because the test data is received through the mocked
        // dependencies
        affinities = new ArrayList<>();

        // Calls the method to test
        units = builder.getAvailableUnits(affinities);

        // Calculates the final cost
        // The cost of the units come from the mocked service and are 1, 2 and 3
        cost = 0;
        for (final Unit unit : units) {
            cost += unit.getCost();
        }

        Assert.assertEquals(cost, (Integer) 6);
    }

    /**
     * Returns the mocked affinity units repository.
     * <p>
     * This repository will contain three units. The actual values contained in
     * these units does not matter, only their number.
     * 
     * @return the mocked affinity units repository
     */
    @SuppressWarnings("unchecked")
    private final AffinityUnitRepository getAffinityUnitRepository() {
        final AffinityUnitRepository unitRepo;
        final Collection<PersistentAffinityUnit> units;

        unitRepo = Mockito.mock(AffinityUnitRepository.class);

        // Only the number of units matters
        units = new ArrayList<>();
        units.add(new PersistentAffinityUnit());
        units.add(new PersistentAffinityUnit());
        units.add(new PersistentAffinityUnit());

        Mockito.when(unitRepo
                .findAllFilteredByHatedAffinities(Matchers.anyCollection()))
                .thenReturn(units);
        Mockito.when(unitRepo.findAll()).thenReturn(units);

        return unitRepo;
    }

    /**
     * Returns the mocked DBX rules service.
     * <p>
     * It is prepared to handle three units, and will return values as if these
     * units were a friend, and ally and a stranger, in that order.
     * 
     * @return the mocked DBX rules service
     */
    @SuppressWarnings("unchecked")
    private final DbxRules getDbxRules() {
        final DbxRules rules;

        rules = Mockito.mock(DbxRules.class);

        // Remember: the test is prepared for three units

        // The affinities will be: friend, ally and stranger
        Mockito.when(rules.getAffinityLevel(Matchers.any(AffinityUnit.class),
                Matchers.any(Iterable.class))).thenReturn(AffinityLevel.FRIEND,
                        AffinityLevel.ALLY, AffinityLevel.STRANGER);

        // The costs will be: 1, 2 and 3
        Mockito.when(rules.getUnitCost(Matchers.any(AffinityLevel.class),
                Matchers.any(AffinityUnit.class))).thenReturn(1, 2, 3);

        return rules;
    }

    /**
     * Returns the DBX sponsor builder to test, with mocked dependencies.
     * 
     * @return the DBX sponsor builder with mocked dependencies
     */
    private final DbxSponsorBuilder getDbxSponsorBuilder() {
        final DbxModelFactory modelFact;       // Model factory
        final DbxRules rules;                  // Rules service
        final SponsorAffinityGroupAvailabilityRepository affinityAvasRepo;
        final AffinityUnitRepository unitRepo; // Units repository
        final Integer rank;                    // Initial rank

        modelFact = new DbxModelFactory() {

            @Override
            public final Sponsor getSponsor(final SponsorForm form) {
                return null;
            }

            @Override
            public final SponsorAffinityGroupAvailability
                    getSponsorAffinityGroupAvailability(
                            final PersistentSponsorAffinityGroupAvailability aff) {
                return null;
            }

            @Override
            public final SponsorTeam getSponsorTeam(final Sponsor sponsor) {
                return null;
            }

            @Override
            public final Unit getUnit(final String nameTemplate,
                    final String name, final Integer cost, final Role role,
                    final Attributes attributes,
                    final Collection<Ability> abilities, final Boolean mvp,
                    final Boolean giant) {
                // TODO: Mock this
                return new DefaultUnit(nameTemplate, cost, role, attributes,
                        abilities, mvp, giant);
            }

            @Override
            public final Unit getUnit(final String templateName,
                    final Iterable<AffinityGroup> affinities) {
                return null;
            }

        };

        rules = getDbxRules();
        affinityAvasRepo = Mockito
                .mock(SponsorAffinityGroupAvailabilityRepository.class);
        unitRepo = getAffinityUnitRepository();
        rank = 0;

        return new DefaultDbxSponsorBuilder(modelFact, rules, affinityAvasRepo,
                unitRepo, rank);
    }

}
