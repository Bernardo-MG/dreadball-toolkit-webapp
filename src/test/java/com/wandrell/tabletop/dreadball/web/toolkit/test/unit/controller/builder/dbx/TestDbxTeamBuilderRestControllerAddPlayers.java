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
import org.springframework.validation.Validator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wandrell.tabletop.dreadball.build.dbx.DbxTeamBuilder;
import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.json.unit.UnitMixIn;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.calculator.RankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.TeamValorationCalculator;
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
        mockMvc = MockMvcBuilders.standaloneSetup(getController())
                .alwaysExpect(MockMvcResultMatchers.status().isOk())
                .alwaysExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .build();
    }

    /**
     * Tests that when adding multiple players these are added one after the
     * other.
     */
    @Test
    public final void testAddPlayer_MultiplePlayers_Accepted()
            throws Exception {
        final ResultActions result;   // Request result
        final RequestBuilder request; // Request

        request = getRequest();

        mockMvc.perform(request);
        mockMvc.perform(request);
        result = mockMvc.perform(request);

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

        // There are no more entries
        result.andExpect(MockMvcResultMatchers.jsonPath("$.players",
                Matchers.aMapWithSize(3)));
    }

    /**
     * Tests that when the data and the context is correct players can be added.
     */
    @Test
    public final void testAddPlayer_ValidData_Accepted() throws Exception {
        final ResultActions result;     // Request result

        result = mockMvc.perform(getRequest());

        // The assets were set correctly
        result.andExpect(MockMvcResultMatchers.jsonPath("$.players.1",
                Matchers.anything()));

        // TODO: Should be
        // result.andExpect(MockMvcResultMatchers.jsonPath("$.players",
        // Matchers.hasKey(1)));

        // There are no more entries
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
        final Integer maxUnits;
        final Validator teamValidator;

        builder = Mockito.mock(DbxTeamBuilder.class);

        Mockito.when(builder.getUnit(org.mockito.Matchers.anyString(),
                org.mockito.Matchers.anyCollection()))
                .thenReturn(Mockito.mock(UnitMixIn.class),
                        Mockito.mock(UnitMixIn.class),
                        Mockito.mock(UnitMixIn.class));

        maxUnits = Integer.MAX_VALUE;

        Mockito.when(builder.getMaxTeamUnits()).thenReturn(maxUnits);

        teamValidator = Mockito.mock(Validator.class);
        Mockito.when(teamValidator.supports(Mockito.any())).thenReturn(true);

        return new DbxTeamBuilderRestController(builder, teamValidator);
    }

    /**
     * Returns a request builder for posting a player.
     * 
     * @return a request builder with a valid player
     */
    private final RequestBuilder getRequest() throws IOException {
        final byte[] content;
        final SponsorTeamPlayer player; // Assets for the team

        player = new SponsorTeamPlayer();

        player.setTemplateName("template");

        content = new ObjectMapper().writeValueAsBytes(player);

        return MockMvcRequestBuilders.post(UrlConfig.URL_PLAYERS)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .sessionAttrs(getSessionAttributes()).content(content);
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
        sessionAttrs.put(BeanConfig.TEAM_BEAN,
                new DefaultSponsorTeam(new DefaultSponsor(),
                        Mockito.mock(TeamValorationCalculator.class),
                        Mockito.mock(RankCostCalculator.class)));

        return sessionAttrs;
    }

}
