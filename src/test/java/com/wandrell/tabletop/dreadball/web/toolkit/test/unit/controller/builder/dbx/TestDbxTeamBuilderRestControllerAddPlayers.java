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
import java.util.LinkedList;
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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wandrell.tabletop.dreadball.build.dbx.DbxTeamBuilder;
import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.calculator.RankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.DefaultUnit;
import com.wandrell.tabletop.dreadball.model.unit.Role;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.MutableAttributes;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.DbxTeamBuilderRestController;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorTeamPlayer;
import com.wandrell.tabletop.dreadball.web.toolkit.test.configuration.BeanConfig;
import com.wandrell.tabletop.dreadball.web.toolkit.test.configuration.UrlConfig;

/**
 * Unit tests for {@link DbxTeamBuilderRestController}, checking the methods for
 * adding players.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestDbxTeamBuilderRestControllerAddPlayers {

    /**
     * Mocked MVC context.
     */
    private MockMvc mockMvc;

    /**
     * Default constructor.
     */
    public TestDbxTeamBuilderRestControllerAddPlayers() {
        super();
    }

    /**
     * Sets up the mocked MVC context.
     */
    @BeforeTest
    public final void setUpMockContext() {
        mockMvc = MockMvcBuilders.standaloneSetup(getController()).build();
    }

    /**
     * Tests that when adding multiple players these are added one after the
     * other.
     */
    @Test
    public final void testAddPlayer_MultiplePlayers_Accepted()
            throws Exception {
        final ResultActions result;     // Request result
        final SponsorTeamPlayer player; // Assets for the team
        final RequestBuilder post;      // Request

        player = new SponsorTeamPlayer();

        player.setTemplateName("template");

        // The request is created
        post = getValidRequest(player);

        mockMvc.perform(post).andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(post).andExpect(MockMvcResultMatchers.status().isOk());
        result = mockMvc.perform(post)
                .andExpect(MockMvcResultMatchers.status().isOk());

        // The assets were set correctly
        result.andExpect(MockMvcResultMatchers.jsonPath("$.players.1",
                Matchers.anything()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.players.2",
                Matchers.anything()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.players.3",
                Matchers.anything()));

        // TODO: Should be
        // result.andExpect(MockMvcResultMatchers.jsonPath("$.players",
        // Matchers.hasKey(1)));

        result.andExpect(MockMvcResultMatchers.jsonPath("$.players",
                Matchers.aMapWithSize(3)));
    }

    /**
     * Tests that when the data and the context is correct the assets can be
     * set.
     */
    @Test
    public final void testAddPlayer_NoSessionTeam_ValidData_Rejected()
            throws Exception {
        final ResultActions result;     // Request result
        final SponsorTeamPlayer player; // Assets for the team

        player = new SponsorTeamPlayer();

        player.setTemplateName("template");

        result = mockMvc.perform(getNoSessionRequest(player));

        // The operation was rejected
        result.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    /**
     * Tests that when the data and the context is correct players can be added.
     */
    @Test
    public final void testAddPlayer_ValidContext_ValidData_Accepted()
            throws Exception {
        final ResultActions result;     // Request result
        final SponsorTeamPlayer player; // Assets for the team

        player = new SponsorTeamPlayer();

        player.setTemplateName("template");

        result = mockMvc.perform(getValidRequest(player));

        // The operation was accepted
        result.andExpect(MockMvcResultMatchers.status().isOk());

        // The response is a JSON message
        result.andExpect(MockMvcResultMatchers.content()
                .contentType(MediaType.APPLICATION_JSON_UTF8));

        // TODO: Check that there are no more entries
        // The assets were set correctly
        result.andExpect(MockMvcResultMatchers.jsonPath("$.players.1",
                Matchers.anything()));

        // TODO: Should be
        // result.andExpect(MockMvcResultMatchers.jsonPath("$.players",
        // Matchers.hasKey(1)));

        result.andExpect(MockMvcResultMatchers.jsonPath("$.players",
                Matchers.aMapWithSize(1)));
    }

    /**
     * Returns a mocked controller.
     * <p>
     * It can create mocked sponsor, sponsor team and units.
     * 
     * @return a mocked controller
     */
    @SuppressWarnings("unchecked")
    private final DbxTeamBuilderRestController getController() {
        final DbxTeamBuilder builder;
        final Unit unit;
        final Integer maxUnits;

        builder = Mockito.mock(DbxTeamBuilder.class);

        // TODO: Mock this better
        unit = new DefaultUnit("", 0, Role.GUARD, new MutableAttributes(),
                new LinkedList<Ability>(), false, false);

        Mockito.when(builder.getUnit(org.mockito.Matchers.anyString(),
                org.mockito.Matchers.anyCollection())).thenReturn(unit);

        maxUnits = Integer.MAX_VALUE;

        Mockito.when(builder.getMaxTeamUnits()).thenReturn(maxUnits);

        return new DbxTeamBuilderRestController(builder);
    }

    /**
     * Returns a request builder for posting the specified assets with an
     * invalid context.
     * <p>
     * The created request will be missing session data.
     * 
     * @param player
     *            player data for the request
     * @return a request builder with the specified player data
     */
    private final RequestBuilder getNoSessionRequest(
            final SponsorTeamPlayer player) throws IOException {
        final byte[] content;

        content = new ObjectMapper().writeValueAsBytes(player);

        return MockMvcRequestBuilders.post(UrlConfig.URL_PLAYERS)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(content);
    }

    /**
     * Returns the session attributes required for the controller to work.
     * 
     * @return the session attributes required by the controller
     */
    @SuppressWarnings("unchecked")
    private final Map<String, Object> getSessionAttributes() {
        final Map<String, Object> sessionAttrs;

        sessionAttrs = new LinkedHashMap<>();
        // sessionAttrs.put("team", Mockito.mock(SponsorTeam.class));
        // TODO: Mock this better
        sessionAttrs.put(BeanConfig.TEAM_BEAN,
                new DefaultSponsorTeam(new DefaultSponsor(),
                        Mockito.mock(TeamValorationCalculator.class),
                        Mockito.mock(RankCostCalculator.class)));

        return sessionAttrs;
    }

    /**
     * Returns a request builder for posting the specified assets.
     * <p>
     * The created request will contain the valid context.
     * 
     * @param player
     *            player data for the request
     * @return a request builder with the specified player data
     */
    private final RequestBuilder getValidRequest(final SponsorTeamPlayer player)
            throws IOException {
        final byte[] content;

        content = new ObjectMapper().writeValueAsBytes(player);

        return MockMvcRequestBuilders.post(UrlConfig.URL_PLAYERS)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .sessionAttrs(getSessionAttributes()).content(content);
    }

}
