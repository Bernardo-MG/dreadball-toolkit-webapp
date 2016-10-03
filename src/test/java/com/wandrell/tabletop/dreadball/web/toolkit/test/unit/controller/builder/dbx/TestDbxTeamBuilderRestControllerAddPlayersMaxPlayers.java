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

package com.wandrell.tabletop.dreadball.web.toolkit.test.unit.controller.builder.dbx;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wandrell.tabletop.dreadball.build.dbx.DbxTeamBuilder;
import com.wandrell.tabletop.dreadball.model.json.team.SponsorTeamMixIn;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.DbxTeamBuilderRestController;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorTeamPlayer;

/**
 * Unit tests for {@link DbxTeamBuilderRestController}, checking the methods for
 * adding players with invalid data.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestDbxTeamBuilderRestControllerAddPlayersMaxPlayers {

    /**
     * The name of the team bean.
     */
    private static final String TEAM_BEAN  = "team";

    /**
     * Form view URL.
     */
    private static final String URL_ASSETS = "/builder/team/dbx/players";

    /**
     * Default constructor.
     */
    public TestDbxTeamBuilderRestControllerAddPlayersMaxPlayers() {
        super();
    }

    /**
     * Tests that it is not possible adding a player when the maximum is
     * surpassed.
     */
    @Test
    public final void testAddPlayer_AboveMaximumPlayers_NotAdded()
            throws Exception {
        final ResultActions result;     // Request result
        final SponsorTeamPlayer player; // Assets for the team
        final RequestBuilder post;      // Request
        final MockMvc mockMvc;          // Mocked context
        final Integer players;          // Number of players in the team

        players = 10;

        mockMvc = MockMvcBuilders
                .standaloneSetup(getMaxUnitsController(players)).build();

        player = new SponsorTeamPlayer();

        player.setTemplateName("template");

        // The request is created
        post = getValidRequest(player, players + 1);

        mockMvc.perform(post).andExpect(MockMvcResultMatchers.status().isOk());
        result = mockMvc.perform(post)
                .andExpect(MockMvcResultMatchers.status().isOk());

        // No player was added
        // TODO: It is using mocks, this will be always empty
        result.andExpect(MockMvcResultMatchers.jsonPath("$.players",
                Matchers.anEmptyMap()));
    }

    /**
     * Tests that it is not possible adding a player when the maximum is
     * negative.
     */
    @Test
    public final void testAddPlayer_NegativeMaximumPlayers_NotAdded()
            throws Exception {
        final ResultActions result;     // Request result
        final SponsorTeamPlayer player; // Assets for the team
        final RequestBuilder post;      // Request
        final MockMvc mockMvc;          // Mocked context

        mockMvc = MockMvcBuilders.standaloneSetup(getMaxUnitsController(-1))
                .build();

        player = new SponsorTeamPlayer();

        player.setTemplateName("template");

        // The request is created
        post = getValidRequest(player, 0);

        result = mockMvc.perform(post)
                .andExpect(MockMvcResultMatchers.status().isOk());

        // The assets were set correctly
        // TODO: It is using mocks, this will be always empty
        result.andExpect(MockMvcResultMatchers.jsonPath("$.players",
                Matchers.anEmptyMap()));
    }

    /**
     * Tests that it is not possible adding a player when the maximum is
     * reached.
     */
    @Test
    public final void testAddPlayer_ReachedMaximumPlayers_NotAdded()
            throws Exception {
        final ResultActions result;     // Request result
        final SponsorTeamPlayer player; // Assets for the team
        final RequestBuilder post;      // Request
        final MockMvc mockMvc;          // Mocked context
        final Integer players;          // Number of players in the team

        players = 10;

        mockMvc = MockMvcBuilders
                .standaloneSetup(getMaxUnitsController(players)).build();

        player = new SponsorTeamPlayer();

        player.setTemplateName("template");

        // The request is created
        post = getValidRequest(player, players);

        mockMvc.perform(post).andExpect(MockMvcResultMatchers.status().isOk());
        result = mockMvc.perform(post)
                .andExpect(MockMvcResultMatchers.status().isOk());

        // The assets were set correctly
        // TODO: It is using mocks, this will be always empty
        result.andExpect(MockMvcResultMatchers.jsonPath("$.players",
                Matchers.anEmptyMap()));
    }

    /**
     * Tests that it is not possible adding a player when the maximum is zero.
     */
    @Test
    public final void testAddPlayer_ZeroMaximumPlayers_NotAdded()
            throws Exception {
        final ResultActions result;     // Request result
        final SponsorTeamPlayer player; // Assets for the team
        final RequestBuilder post;      // Request
        final MockMvc mockMvc;          // Mocked context

        mockMvc = MockMvcBuilders.standaloneSetup(getMaxUnitsController(0))
                .build();

        player = new SponsorTeamPlayer();

        player.setTemplateName("template");

        // The request is created
        post = getValidRequest(player, 0);

        result = mockMvc.perform(post)
                .andExpect(MockMvcResultMatchers.status().isOk());

        // The assets were set correctly
        // TODO: It is using mocks, this will be always empty
        result.andExpect(MockMvcResultMatchers.jsonPath("$.players",
                Matchers.anEmptyMap()));
    }

    /**
     * Returns a mocked controller.
     * 
     * @param max
     *            maximum number of units allowed
     * @return a mocked controller
     */
    private final DbxTeamBuilderRestController
            getMaxUnitsController(final Integer max) {
        final DbxTeamBuilder builder;

        // Mocks the builder
        builder = Mockito.mock(DbxTeamBuilder.class);

        // Sets max units
        Mockito.when(builder.getMaxTeamUnits()).thenReturn(max);

        return new DbxTeamBuilderRestController(builder);
    }

    /**
     * Returns the session attributes required for the controller to work.
     * 
     * @param players
     *            number of players in the team
     * @return the session attributes required by the controller
     */
    @SuppressWarnings("unchecked")
    private final Map<String, Object>
            getSessionAttributes(final Integer players) {
        final Map<String, Object> sessionAttrs; // Session attributes
        final SponsorTeam team;                 // Mocked team
        final Map<Integer, Unit> units;         // Mocked units

        // Mocks the units
        units = Mockito.mock(Map.class);
        Mockito.when(units.size()).thenReturn(players);

        // Mocks the team
        team = Mockito.mock(SponsorTeamMixIn.class);
        Mockito.when(team.getPlayers()).thenReturn(units);

        // Creates the session attributes
        sessionAttrs = new LinkedHashMap<>();
        sessionAttrs.put(TEAM_BEAN, team);

        return sessionAttrs;
    }

    /**
     * Returns a request builder for posting the specified assets.
     * <p>
     * The created request will contain the valid context.
     * 
     * @param player
     *            player data for the request
     * @param players
     *            number of players in the team
     * @return a request builder with the specified player data
     */
    private final RequestBuilder getValidRequest(final SponsorTeamPlayer player,
            final Integer players) throws IOException {
        final byte[] content; // Data to send

        // Converts the data to bytes
        content = new ObjectMapper().writeValueAsBytes(player);

        // Creates the request
        return MockMvcRequestBuilders.post(URL_ASSETS)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .sessionAttrs(getSessionAttributes(players)).content(content);
    }

}
