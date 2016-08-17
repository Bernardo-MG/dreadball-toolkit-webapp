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

package com.wandrell.tabletop.dreadball.web.toolkit.test.unit.service.builder;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.RankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.AffinityLevel;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.availability.SponsorAffinityGroupAvailabilityRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityGroupRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityUnitRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.service.builder.DbxTeamBuilderService;
import com.wandrell.tabletop.dreadball.web.toolkit.service.builder.DbxValuesService;
import com.wandrell.tabletop.dreadball.web.toolkit.service.builder.DefaultDbxTeamBuilderService;

import junit.framework.Assert;

/**
 * Unit tests for {@link DbxTeamBuilderService} testing the
 * {@code getAffinityLevel} method.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>When there are no affinities the level is 'stranger'</li>
 * <li>When the sponsor has no affinities the level is 'stranger'</li>
 * <li>When the unit has no affinities the level is 'stranger'</li>
 * <li>When one affinity is shared the level is 'ally'</li>
 * <li>When three affinities are shared the level is 'friend'</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestDefaultDbxTeamBuilderServiceAffinityLevel {

    /**
     * Service being tested.
     */
    private DbxTeamBuilderService dbxTeamBuilderService;

    /**
     * Default constructor.
     */
    public TestDefaultDbxTeamBuilderServiceAffinityLevel() {
        super();
    }

    /**
     * Sets up the tested service.
     */
    @SuppressWarnings("unchecked")
    @BeforeTest
    public final void setUpService() {
        final SponsorAffinityGroupAvailabilityRepository sponsorAffinityGroupAvailabilityRepository;
        final AffinityGroupRepository affinityGroupRepository;
        final AffinityUnitRepository affinityUnitRepository;
        final DbxValuesService dbxValuesService;
        final TeamValorationCalculator<SponsorTeam> teamValorationCalculator;
        final RankCostCalculator rankCostCalculator;
        final MessageSource messageSource;

        sponsorAffinityGroupAvailabilityRepository = Mockito
                .mock(SponsorAffinityGroupAvailabilityRepository.class);
        affinityGroupRepository = Mockito.mock(AffinityGroupRepository.class);
        affinityUnitRepository = Mockito.mock(AffinityUnitRepository.class);
        dbxValuesService = Mockito.mock(DbxValuesService.class);
        teamValorationCalculator = Mockito.mock(TeamValorationCalculator.class);
        rankCostCalculator = Mockito.mock(RankCostCalculator.class);
        messageSource = Mockito.mock(MessageSource.class);

        dbxTeamBuilderService = new DefaultDbxTeamBuilderService(
                sponsorAffinityGroupAvailabilityRepository,
                affinityGroupRepository, affinityUnitRepository,
                dbxValuesService, teamValorationCalculator, rankCostCalculator,
                messageSource);
    }

    /**
     * Tests that when there are no affinities the level is 'stranger'.
     */
    @Test
    public final void testAffinityLevel_NoAffinities_Stranger() {
        final Sponsor sponsor;   // Sponsor to find the affinity for
        final AffinityUnit unit; // Unit to find the affinity for
        final AffinityLevel aff; // Affinity level

        // Mocks sponsor and unit
        sponsor = Mockito.mock(Sponsor.class);
        unit = Mockito.mock(AffinityUnit.class);

        aff = dbxTeamBuilderService.getAffinityLevel(sponsor, unit);

        Assert.assertEquals(AffinityLevel.STRANGER, aff);
    }

    /**
     * Tests that when the sponsor has no affinities the level is 'stranger'.
     */
    @Test
    public final void testAffinityLevel_NoSponsorAffinities_Stranger() {
        final Sponsor sponsor;   // Sponsor to find the affinity for
        final AffinityUnit unit; // Unit to find the affinity for
        final AffinityLevel aff; // Affinity level
        final Collection<AffinityGroup> affs; // Affinities

        // Mocks sponsor and unit
        sponsor = Mockito.mock(Sponsor.class);
        unit = Mockito.mock(AffinityUnit.class);

        // Mocks unit affinities
        affs = getAffinities();
        Mockito.when(unit.getAffinityGroups()).thenReturn(affs);

        aff = dbxTeamBuilderService.getAffinityLevel(sponsor, unit);

        Assert.assertEquals(AffinityLevel.STRANGER, aff);
    }

    /**
     * Tests that when the unit has no affinities the level is 'stranger'.
     */
    @Test
    public final void testAffinityLevel_NoUnitAffinities_Stranger() {
        final Sponsor sponsor;   // Sponsor to find the affinity for
        final AffinityUnit unit; // Unit to find the affinity for
        final AffinityLevel aff; // Affinity level
        final Collection<AffinityGroup> affs; // Affinities

        // Mocks sponsor and unit
        sponsor = Mockito.mock(Sponsor.class);
        unit = Mockito.mock(AffinityUnit.class);

        // Mocks sponsor affinities
        affs = getAffinities();
        Mockito.when(sponsor.getAffinityGroups()).thenReturn(affs);

        aff = dbxTeamBuilderService.getAffinityLevel(sponsor, unit);

        Assert.assertEquals(AffinityLevel.STRANGER, aff);
    }

    /**
     * Tests that when only one affinity is shared the level is 'ally'.
     */
    @Test
    public final void testAffinityLevel_OneShared_Ally() {
        final Sponsor sponsor;   // Sponsor to find the affinity for
        final AffinityUnit unit; // Unit to find the affinity for
        final AffinityLevel aff; // Affinity level
        final Collection<AffinityGroup> unitAffs; // Unit affinities
        final Collection<AffinityGroup> spnsAffs; // Sponsor affinities

        // Mocks sponsor and unit
        sponsor = Mockito.mock(Sponsor.class);
        unit = Mockito.mock(AffinityUnit.class);

        // Mocks unit affinities
        unitAffs = getAffinities();
        Mockito.when(unit.getAffinityGroups()).thenReturn(unitAffs);

        // Mocks sponsor affinities
        spnsAffs = new LinkedList<AffinityGroup>();
        spnsAffs.add(unitAffs.iterator().next());
        Mockito.when(sponsor.getAffinityGroups()).thenReturn(spnsAffs);

        aff = dbxTeamBuilderService.getAffinityLevel(sponsor, unit);

        Assert.assertEquals(AffinityLevel.ALLY, aff);
    }

    /**
     * Tests that when three affinities are shared the level is 'friend'.
     */
    @Test
    public final void testAffinityLevel_ThreeAffinities_Friend() {
        final Sponsor sponsor;   // Sponsor to find the affinity for
        final AffinityUnit unit; // Unit to find the affinity for
        final AffinityLevel aff; // Affinity level
        final Collection<AffinityGroup> affs; // Affinities

        // Mocks sponsor and unit
        sponsor = Mockito.mock(Sponsor.class);
        unit = Mockito.mock(AffinityUnit.class);

        // Mocks affinities
        affs = getAffinities();
        Mockito.when(unit.getAffinityGroups()).thenReturn(affs);
        Mockito.when(sponsor.getAffinityGroups()).thenReturn(affs);

        aff = dbxTeamBuilderService.getAffinityLevel(sponsor, unit);

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

        affs = new LinkedList<AffinityGroup>();
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
