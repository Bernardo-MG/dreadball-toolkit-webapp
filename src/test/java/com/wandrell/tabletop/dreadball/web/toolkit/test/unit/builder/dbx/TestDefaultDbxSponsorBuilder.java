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

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.build.dbx.DbxSponsorBuilder;
import com.wandrell.tabletop.dreadball.factory.DbxModelFactory;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.persistence.unit.PersistentAffinityUnit;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.DefaultUnit;
import com.wandrell.tabletop.dreadball.model.unit.Role;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.Attributes;
import com.wandrell.tabletop.dreadball.rules.DbxRules;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.DefaultDbxSponsorBuilder;
import com.wandrell.tabletop.dreadball.web.toolkit.model.form.SponsorForm;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.availability.SponsorAffinityGroupAvailabilityRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityUnitRepository;

/**
 * Integration tests for {@link DbxSponsorBuilder}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Acquiring the available units returns the expected values</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public class TestDefaultDbxSponsorBuilder {

    /**
     * Default constructor.
     */
    public TestDefaultDbxSponsorBuilder() {
        super();
    }

    private final DbxSponsorBuilder getDbxSponsorBuilder() {
        final DbxModelFactory modelFact;
        final DbxRules rules;
        final SponsorAffinityGroupAvailabilityRepository affinityAvasRepo;
        final AffinityUnitRepository unitRepo;
        final Integer rank;
        final DbxSponsorBuilder builder;
        final Collection<PersistentAffinityUnit> units;
        PersistentAffinityUnit unit;

        modelFact = new DbxModelFactory() {

            @Override
            public Sponsor getSponsor(SponsorForm form) {
                return null;
            }

            @Override
            public SponsorTeam getSponsorTeam(Sponsor sponsor) {
                return null;
            }

            @Override
            public Unit getUnit(String nameTemplate, Integer cost, Role role,
                    Attributes attributes, Collection<Ability> abilities,
                    Boolean mvp, Boolean giant) {
                // TODO: Mock this
                return new DefaultUnit(nameTemplate, cost, role, attributes,
                        abilities, mvp, giant);
            }

        };

        rules = Mockito.mock(DbxRules.class);
        affinityAvasRepo = Mockito
                .mock(SponsorAffinityGroupAvailabilityRepository.class);

        unitRepo = Mockito.mock(AffinityUnitRepository.class);

        units = new LinkedList<PersistentAffinityUnit>();

        unit = new PersistentAffinityUnit();
        unit.setFriendCost(1);
        unit.setAllyCost(2);
        unit.setStrangerCost(3);
        units.add(unit);

        unit = new PersistentAffinityUnit();
        unit.setFriendCost(1);
        unit.setAllyCost(2);
        unit.setStrangerCost(3);
        units.add(unit);

        unit = new PersistentAffinityUnit();
        unit.setFriendCost(1);
        unit.setAllyCost(2);
        unit.setStrangerCost(3);
        units.add(unit);

        Mockito.when(unitRepo.findAll()).thenReturn(units);

        rank = 0;

        builder = new DefaultDbxSponsorBuilder(modelFact, rules,
                affinityAvasRepo, unitRepo, rank);

        return builder;
    }

    /**
     * Tests that acquiring the available units returns the expected values.
     */
    @Test
    public final void testGetSponsorAvailableUnits() {
        final Iterable<? extends Unit> units; // Sponsor units
        final Sponsor sponsor;                // Sponsor to get the units for
        final Collection<AffinityGroup> affs;
        final DbxSponsorBuilder builder;
        AffinityGroup affinity;

        builder = getDbxSponsorBuilder();

        sponsor = Mockito.mock(Sponsor.class);
        affs = new LinkedList<AffinityGroup>();

        affinity = Mockito.mock(AffinityGroup.class);
        Mockito.when(affinity.getName()).thenReturn("alien");
        affs.add(affinity);

        affinity = Mockito.mock(AffinityGroup.class);
        Mockito.when(affinity.getName()).thenReturn("dreadball");
        affs.add(affinity);

        affinity = Mockito.mock(AffinityGroup.class);
        Mockito.when(affinity.getName()).thenReturn("insectoid");
        affs.add(affinity);

        affinity = Mockito.mock(AffinityGroup.class);
        Mockito.when(affinity.getName()).thenReturn("psycho");
        affs.add(affinity);

        affinity = Mockito.mock(AffinityGroup.class);
        Mockito.when(affinity.getName()).thenReturn("vicious");
        affs.add(affinity);

        Mockito.when(sponsor.getAffinityGroups()).thenReturn(affs);

        units = builder.getSponsorAvailableUnits(sponsor);

        // TODO: Verify it returns the expected costs
        Assert.assertNotNull(units);
    }

}
