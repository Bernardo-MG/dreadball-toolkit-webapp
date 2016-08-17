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

import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.team.RankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.TeamValorationCalculator;
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
 * Unit tests for {@link DbxTeamBuilderService} testing the {@code getUnitCost}
 * method.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>When the affinity is 'stranger' then the cost is the stranger cost</li>
 * <li>When the affinity is 'ally' then the cost is the ally cost</li>
 * <li>When the affinity is 'friend' then the cost is the friend cost</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public class TestDefaultDbxTeamBuilderServiceUnitCost {

    /**
     * Service being tested.
     */
    private DbxTeamBuilderService dbxTeamBuilderService;

    /**
     * Default constructor.
     */
    public TestDefaultDbxTeamBuilderServiceUnitCost() {
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
     * Tests that when the affinity is 'ally' then the cost is the ally cost.
     */
    @Test
    public final void testUnitCost_Ally_AllyCost() {
        final AffinityUnit unit;
        final Integer cost;

        // Mocks unit
        unit = Mockito.mock(AffinityUnit.class);

        // Mocks unit costs
        Mockito.when(unit.getAllyCost()).thenReturn(1);
        Mockito.when(unit.getFriendCost()).thenReturn(2);
        Mockito.when(unit.getStrangerCost()).thenReturn(3);

        cost = dbxTeamBuilderService.getUnitCost(AffinityLevel.ALLY, unit);

        Assert.assertEquals((Integer) 1, cost);
    }

    /**
     * Tests that when the affinity is 'friend' then the cost is the friend
     * cost.
     */
    @Test
    public final void testUnitCost_Friend_FriendCost() {
        final AffinityUnit unit;
        final Integer cost;

        // Mocks unit
        unit = Mockito.mock(AffinityUnit.class);

        // Mocks unit costs
        Mockito.when(unit.getAllyCost()).thenReturn(1);
        Mockito.when(unit.getFriendCost()).thenReturn(2);
        Mockito.when(unit.getStrangerCost()).thenReturn(3);

        cost = dbxTeamBuilderService.getUnitCost(AffinityLevel.FRIEND, unit);

        Assert.assertEquals((Integer) 2, cost);
    }

    /**
     * Tests that when the affinity is 'stranger' then the cost is the stranger
     * cost.
     */
    @Test
    public final void testUnitCost_Stranger_StrangerCost() {
        final AffinityUnit unit;
        final Integer cost;

        // Mocks unit
        unit = Mockito.mock(AffinityUnit.class);

        // Mocks unit costs
        Mockito.when(unit.getAllyCost()).thenReturn(1);
        Mockito.when(unit.getFriendCost()).thenReturn(2);
        Mockito.when(unit.getStrangerCost()).thenReturn(3);

        cost = dbxTeamBuilderService.getUnitCost(AffinityLevel.STRANGER, unit);

        Assert.assertEquals((Integer) 3, cost);
    }

}
