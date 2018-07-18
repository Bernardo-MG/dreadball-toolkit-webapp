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

package com.bernardomg.tabletop.dreadball.web.toolkit.test.unit.calculator;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.calculator.SponsorTeamRankCostCalculator;
import com.bernardomg.tabletop.dreadball.model.player.AdvancementTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.bernardomg.tabletop.dreadball.model.team.calculator.CostCalculator;
import com.bernardomg.tabletop.dreadball.model.team.calculator.DefaultRankCostCalculator;

/**
 * Unit tests for {@link DefaultRankCostCalculator}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestSponsorTeamRankCostCalculator {

    /**
     * Default constructor.
     */
    public TestSponsorTeamRankCostCalculator() {
        super();
    }

    /**
     * Tests that the rank cost is calculated correctly.
     */
    @Test
    public final void testRankCost() {
        final CostCalculator<SponsorTeam> calculator; // Tested class
        final SponsorTeam team;              // Team to valorate
        final Map<Integer, TeamPlayer> players;    // Team players
        final TeamPlayer player;                   // Mocked player

        // Mocks team
        team = Mockito.mock(SponsorTeam.class);
        Mockito.when(team.getCoachingDice()).thenReturn(2);
        Mockito.when(team.getNastySurpriseCards()).thenReturn(4);
        Mockito.when(team.getSpecialMoveCards()).thenReturn(5);
        Mockito.when(team.getCheerleaders()).thenReturn(1);
        Mockito.when(team.getMediBots()).thenReturn(2);
        Mockito.when(team.getWagers()).thenReturn(3);

        // Mocks players
        players = new HashMap<>();
        player = Mockito.mock(AdvancementTeamPlayer.class);
        players.put(1, player);

        Mockito.when(team.getPlayers()).thenReturn(players);

        // Creates calculator
        calculator = new SponsorTeamRankCostCalculator(1, 2, 3, 4, 5, 6);

        Assertions.assertEquals(calculator.getCost(team), (Integer) 56);
    }

    /**
     * Tests that the rank cost is calculated correctly when there are multiple
     * cheerleaders.
     */
    @Test
    public final void testRankCost_MultipleCheerleaders() {
        final CostCalculator<SponsorTeam> calculator; // Tested class
        final SponsorTeam team;                       // Team to valorate
        final Map<Integer, TeamPlayer> players;       // Team players
        final TeamPlayer player;                      // Mocked player

        // Mocks team
        team = Mockito.mock(SponsorTeam.class);
        Mockito.when(team.getCoachingDice()).thenReturn(0);
        Mockito.when(team.getNastySurpriseCards()).thenReturn(0);
        Mockito.when(team.getSpecialMoveCards()).thenReturn(0);
        Mockito.when(team.getCheerleaders()).thenReturn(5);
        Mockito.when(team.getMediBots()).thenReturn(0);
        Mockito.when(team.getWagers()).thenReturn(0);

        // Mocks players
        players = new HashMap<>();
        player = Mockito.mock(AdvancementTeamPlayer.class);
        players.put(1, player);

        Mockito.when(team.getPlayers()).thenReturn(players);

        // Creates calculator
        calculator = new SponsorTeamRankCostCalculator(1, 2, 3, 4, 5, 6);

        Assertions.assertEquals(calculator.getCost(team), (Integer) 4);
    }

    /**
     * Tests that the rank cost is calculated correctly when there is only a
     * single cheerleader.
     */
    @Test
    public final void testRankCost_SingleCheerleader() {
        final CostCalculator<SponsorTeam> calculator; // Tested class
        final SponsorTeam team;                       // Team to valorate
        final Map<Integer, TeamPlayer> players;       // Team players
        final TeamPlayer player;                      // Mocked player

        // Mocks team
        team = Mockito.mock(SponsorTeam.class);
        Mockito.when(team.getCoachingDice()).thenReturn(0);
        Mockito.when(team.getNastySurpriseCards()).thenReturn(0);
        Mockito.when(team.getSpecialMoveCards()).thenReturn(0);
        Mockito.when(team.getCheerleaders()).thenReturn(1);
        Mockito.when(team.getMediBots()).thenReturn(0);
        Mockito.when(team.getWagers()).thenReturn(0);

        // Mocks players
        players = new HashMap<>();
        player = Mockito.mock(AdvancementTeamPlayer.class);
        players.put(1, player);

        Mockito.when(team.getPlayers()).thenReturn(players);

        // Creates calculator
        calculator = new SponsorTeamRankCostCalculator(1, 2, 3, 4, 5, 6);

        Assertions.assertEquals(calculator.getCost(team), (Integer) 4);
    }

}
