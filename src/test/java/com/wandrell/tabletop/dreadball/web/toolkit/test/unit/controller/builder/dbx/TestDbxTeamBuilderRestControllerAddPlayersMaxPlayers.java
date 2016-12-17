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

import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
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
import com.wandrell.tabletop.dreadball.web.toolkit.test.configuration.BeanConfig;
import com.wandrell.tabletop.dreadball.web.toolkit.test.configuration.UrlConfig;

/**
 * Unit tests for {@link DbxTeamBuilderRestController}, checking the methods for
 * adding players with invalid data.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestDbxTeamBuilderRestControllerAddPlayersMaxPlayers {

    /**
     * Default constructor.
     */
    public TestDbxTeamBuilderRestControllerAddPlayersMaxPlayers() {
        super();
        // TODO: Validate the actual messages being sent in the exception, which
        // should be message codes
        // TODO: Test that the exception thrown is the correct one
    }

    /**
     * Tests that it is not possible adding a player when the maximum is
     * surpassed.
     */
    @Test(expectedExceptions = Exception.class)
    public final void testAddPlayer_AboveMaximumPlayers_NotAdded()
            throws Exception {
        testCantAddPlayer(10, 11);
    }

    /**
     * Tests that it is not possible adding a player when the maximum is
     * negative.
     */
    @Test(expectedExceptions = Exception.class)
    public final void testAddPlayer_NegativeMaximumPlayers_NotAdded()
            throws Exception {
        testCantAddPlayer(-1, 0);
    }

    /**
     * Tests that it is not possible adding a player when the maximum is
     * reached.
     */
    @Test(expectedExceptions = Exception.class)
    public final void testAddPlayer_ReachedMaximumPlayers_NotAdded()
            throws Exception {
        testCantAddPlayer(10, 10);
    }

    /**
     * Tests that it is not possible adding a player when the maximum is
     * surpassed.
     */
    public final void testAddPlayer_ReachesAboveMaximumPlayers_Added()
            throws Exception {
        final RequestBuilder post;  // Request
        final MockMvc mockMvc;      // Mocked context

        // Creates mocked context
        mockMvc = getMockMvc(10);

        // The request is created
        post = getValidRequest(9);

        // TODO: Make this test work
        // The request is sent
        mockMvc.perform(post);

        // TODO: Test the result
    }

    /**
     * Tests that it is not possible adding a player when the maximum is zero.
     */
    @Test(expectedExceptions = Exception.class)
    public final void testAddPlayer_ZeroMaximumPlayers_NotAdded()
            throws Exception {
        testCantAddPlayer(0, 0);
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
     * Creates a mocked context.
     * 
     * @param players
     *            the maximum number of players
     * @return a mocked context
     */
    private final MockMvc getMockMvc(final Integer players) {
        return MockMvcBuilders.standaloneSetup(getMaxUnitsController(players))
                .alwaysExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .alwaysExpect(MockMvcResultMatchers.status().isBadRequest())
                .build();
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
        sessionAttrs.put(BeanConfig.TEAM_BEAN, team);

        return sessionAttrs;
    }

    /**
     * Returns a request builder for posting the specified assets.
     * <p>
     * The created request will contain the valid context.
     * 
     * @param players
     *            number of players in the team
     * @return a request builder with the specified player data
     */
    private final RequestBuilder getValidRequest(final Integer players)
            throws IOException {
        final SponsorTeamPlayer player; // Player to add
        final byte[] content; // Data to send

        // New player bean
        player = new SponsorTeamPlayer();
        player.setTemplateName("template");

        // Converts the data to bytes
        content = new ObjectMapper().writeValueAsBytes(player);

        // Creates the request
        return MockMvcRequestBuilders.post(UrlConfig.URL_PLAYERS)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .sessionAttrs(getSessionAttributes(players)).content(content);
    }

    /**
     * Verifies that a player can't be added under the set conditions.
     * 
     * @param maxPlayers
     *            maximum number of players allowed in a team
     * @param teamPlayers
     *            number of players currently in the team
     * @throws Exception
     *             if any problem occurs while running the test
     */
    private final void testCantAddPlayer(final Integer maxPlayers,
            final Integer teamPlayers) throws Exception {
        final RequestBuilder post;  // Request
        final MockMvc mockMvc;      // Mocked context

        // Creates mocked context
        mockMvc = getMockMvc(maxPlayers);

        // The request is created
        post = getValidRequest(teamPlayers);

        // The request is sent
        mockMvc.perform(post);
    }

}
