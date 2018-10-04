/**
 * Copyright 2018 the original author or authors
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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.model.player.AffinityLevel;
import com.bernardomg.tabletop.dreadball.model.player.AffinityTeamPlayer;
import com.bernardomg.tabletop.dreadball.rules.DbxRules;
import com.bernardomg.tabletop.dreadball.rules.DefaultDbxRules;
import com.bernardomg.tabletop.dreadball.rules.SponsorConstraints;

/**
 * TeamPlayer tests for {@link SponsorConstraints} testing the
 * {@code getTeamPlayerCost} method.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestDefaultDbxRulesTeamPlayerCost {

    /**
     * Service being tested.
     */
    private final DbxRules dbxTeamBuilderService = new DefaultDbxRules();

    /**
     * Default constructor.
     */
    public TestDefaultDbxRulesTeamPlayerCost() {
        super();
    }

    /**
     * Tests that when the affinity is 'ally' then the cost is the ally cost.
     */
    @Test
    public final void testTeamPlayerCost_Ally_AllyCost() {
        final AffinityTeamPlayer player;
        final Integer cost;

        // Mocks player
        player = Mockito.mock(AffinityTeamPlayer.class);

        // Mocks player costs
        Mockito.when(player.getAllyCost()).thenReturn(1);
        Mockito.when(player.getFriendCost()).thenReturn(2);
        Mockito.when(player.getStrangerCost()).thenReturn(3);

        cost = dbxTeamBuilderService.getTeamPlayerCost(AffinityLevel.ALLY,
                player);

        Assertions.assertEquals((Integer) 1, cost);
    }

    /**
     * Tests that when the affinity is 'friend' then the cost is the friend
     * cost.
     */
    @Test
    public final void testTeamPlayerCost_Friend_FriendCost() {
        final AffinityTeamPlayer player;
        final Integer cost;

        // Mocks player
        player = Mockito.mock(AffinityTeamPlayer.class);

        // Mocks player costs
        Mockito.when(player.getAllyCost()).thenReturn(1);
        Mockito.when(player.getFriendCost()).thenReturn(2);
        Mockito.when(player.getStrangerCost()).thenReturn(3);

        cost = dbxTeamBuilderService.getTeamPlayerCost(AffinityLevel.FRIEND,
                player);

        Assertions.assertEquals((Integer) 2, cost);
    }

    /**
     * Tests that when the affinity is 'stranger' then the cost is the stranger
     * cost.
     */
    @Test
    public final void testTeamPlayerCost_Stranger_StrangerCost() {
        final AffinityTeamPlayer player;
        final Integer cost;

        // Mocks player
        player = Mockito.mock(AffinityTeamPlayer.class);

        // Mocks player costs
        Mockito.when(player.getAllyCost()).thenReturn(1);
        Mockito.when(player.getFriendCost()).thenReturn(2);
        Mockito.when(player.getStrangerCost()).thenReturn(3);

        cost = dbxTeamBuilderService.getTeamPlayerCost(AffinityLevel.STRANGER,
                player);

        Assertions.assertEquals((Integer) 3, cost);
    }

}
