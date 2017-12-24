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

package com.bernardomg.tabletop.dreadball.web.toolkit.test.unit.rules;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.build.dbx.rules.SponsorConstraints;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityLevel;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityUnit;
import com.bernardomg.tabletop.dreadball.rules.DbxRules;
import com.bernardomg.tabletop.dreadball.rules.DefaultDbxRules;

/**
 * Unit tests for {@link SponsorConstraints} testing the
 * {@code getAffinityLevel} method.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestDefaultDbxRulesAffinityLevel {

    /**
     * Service being tested.
     */
    private final DbxRules dbxTeamBuilderService = new DefaultDbxRules();

    /**
     * Default constructor.
     */
    public TestDefaultDbxRulesAffinityLevel() {
        super();
    }

    /**
     * Tests that when there are no affinities the level is 'stranger'.
     */
    @Test
    public final void testAffinityLevel_NoAffinities_Stranger() {
        final AffinityUnit unit; // Unit to find the affinity for
        final AffinityLevel aff; // Affinity level

        // Mocks sponsor and unit
        unit = Mockito.mock(AffinityUnit.class);

        aff = dbxTeamBuilderService.getAffinityLevel(unit, new ArrayList<>());

        Assert.assertEquals(AffinityLevel.STRANGER, aff);
    }

    /**
     * Tests that when the sponsor has no affinities the level is 'stranger'.
     */
    @Test
    public final void testAffinityLevel_NoSponsorAffinities_Stranger() {
        final AffinityUnit unit; // Unit to find the affinity for
        final AffinityLevel aff; // Affinity level
        final Collection<AffinityGroup> affs; // Affinities

        // Mocks sponsor and unit
        unit = Mockito.mock(AffinityUnit.class);

        // Mocks unit affinities
        affs = getAffinities();
        Mockito.when(unit.getAffinityGroups()).thenReturn(affs);

        aff = dbxTeamBuilderService.getAffinityLevel(unit, new ArrayList<>());

        Assert.assertEquals(AffinityLevel.STRANGER, aff);
    }

    /**
     * Tests that when the unit has no affinities the level is 'stranger'.
     */
    @Test
    public final void testAffinityLevel_NoUnitAffinities_Stranger() {
        final AffinityUnit unit; // Unit to find the affinity for
        final AffinityLevel aff; // Affinity level

        // Mocks sponsor and unit
        unit = Mockito.mock(AffinityUnit.class);

        aff = dbxTeamBuilderService.getAffinityLevel(unit, getAffinities());

        Assert.assertEquals(AffinityLevel.STRANGER, aff);
    }

    /**
     * Tests that when only one affinity is shared the level is 'ally'.
     */
    @Test
    public final void testAffinityLevel_OneShared_Ally() {
        final AffinityUnit unit; // Unit to find the affinity for
        final AffinityLevel aff; // Affinity level
        final Collection<AffinityGroup> unitAffs; // Unit affinities
        final Collection<AffinityGroup> spnsAffs; // Sponsor affinities

        // Mocks sponsor and unit
        unit = Mockito.mock(AffinityUnit.class);

        // Mocks unit affinities
        unitAffs = getAffinities();
        Mockito.when(unit.getAffinityGroups()).thenReturn(unitAffs);

        // Mocks sponsor affinities
        spnsAffs = new ArrayList<>();
        spnsAffs.add(unitAffs.iterator().next());

        aff = dbxTeamBuilderService.getAffinityLevel(unit, spnsAffs);

        Assert.assertEquals(AffinityLevel.ALLY, aff);
    }

    /**
     * Tests that when three affinities are shared the level is 'friend'.
     */
    @Test
    public final void testAffinityLevel_ThreeAffinities_Friend() {
        final AffinityUnit unit; // Unit to find the affinity for
        final AffinityLevel aff; // Affinity level
        final Collection<AffinityGroup> affs; // Affinities

        // Mocks sponsor and unit
        unit = Mockito.mock(AffinityUnit.class);

        // Mocks affinities
        affs = getAffinities();
        Mockito.when(unit.getAffinityGroups()).thenReturn(affs);

        aff = dbxTeamBuilderService.getAffinityLevel(unit, affs);

        Assert.assertEquals(AffinityLevel.FRIEND, aff);
    }

    /**
     * Returns the full affinities collection.
     * 
     * @return the full affinities collection
     */
    private final Collection<AffinityGroup> getAffinities() {
        final Collection<AffinityGroup> affs; // Affinities
        final AffinityGroup aff1; // First affinity
        final AffinityGroup aff2; // Second affinity
        final AffinityGroup aff3; // Third affinity

        affs = new ArrayList<>();
        aff1 = Mockito.mock(AffinityGroup.class);
        Mockito.when(aff1.getName()).thenReturn("aff1");

        aff2 = Mockito.mock(AffinityGroup.class);
        Mockito.when(aff1.getName()).thenReturn("aff2");

        aff3 = Mockito.mock(AffinityGroup.class);
        Mockito.when(aff1.getName()).thenReturn("aff3");

        affs.add(aff1);
        affs.add(aff2);
        affs.add(aff3);

        return affs;
    }

}
