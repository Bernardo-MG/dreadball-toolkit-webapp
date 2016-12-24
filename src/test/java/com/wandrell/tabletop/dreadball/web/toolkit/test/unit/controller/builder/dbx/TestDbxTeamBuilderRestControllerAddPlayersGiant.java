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
import org.springframework.validation.Validator;
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
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.TeamPlayer;
import com.wandrell.tabletop.dreadball.web.toolkit.test.configuration.BeanConfig;
import com.wandrell.tabletop.dreadball.web.toolkit.test.configuration.UrlConfig;

/**
 * Unit tests for {@link DbxTeamBuilderRestController}, checking the methods for
 * adding players, using giant players.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestDbxTeamBuilderRestControllerAddPlayersGiant {

    /**
     * Default constructor.
     */
    public TestDbxTeamBuilderRestControllerAddPlayersGiant() {
        super();
    }

    /**
     * Tests that multiple giants can be added.
     */
    @Test
    public final void testAddPlayer_MultipleGiants_Accepted() throws Exception {
        final ResultActions result; // Request result
        final RequestBuilder post;  // Request
        final MockMvc mockMvc;      // Mocked context

        mockMvc = MockMvcBuilders.standaloneSetup(getController())
                .alwaysExpect(MockMvcResultMatchers.status().isOk())
                .alwaysExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .build();

        // The request is created
        post = getRequest();

        mockMvc.perform(post);
        mockMvc.perform(post);
        result = mockMvc.perform(post);

        // The assets were set correctly
        result.andExpect(MockMvcResultMatchers.jsonPath("$.players.1",
                Matchers.anything()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.players.2",
                Matchers.anything()));

        // TODO: Should be
        // result.andExpect(MockMvcResultMatchers.jsonPath("$.players",
        // Matchers.hasKey(1)));

        // There are no more entries
        result.andExpect(MockMvcResultMatchers.jsonPath("$.players",
                Matchers.aMapWithSize(2)));
    }

    /**
     * Tests that repeated giants are rejected.
     */
    @Test
    public final void testAddPlayer_RepeatedGiant_Rejected() throws Exception {
        final ResultActions result; // Request result
        final RequestBuilder post;  // Request
        final MockMvc mockMvc;      // Mocked context

        mockMvc = MockMvcBuilders.standaloneSetup(getController())
                .alwaysExpect(MockMvcResultMatchers.status().isOk())
                .alwaysExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .build();

        // The request is created
        post = getRequest();

        mockMvc.perform(post);
        mockMvc.perform(post);
        result = mockMvc.perform(post);

        // The assets were set correctly
        result.andExpect(MockMvcResultMatchers.jsonPath("$.players.1",
                Matchers.anything()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.players.2",
                Matchers.anything()));
        result.andExpect(
                MockMvcResultMatchers.jsonPath("$.players.3").doesNotExist());

        // TODO: Should be
        // result.andExpect(MockMvcResultMatchers.jsonPath("$.players",
        // Matchers.hasKey(1)));

        // There are no more entries
        result.andExpect(MockMvcResultMatchers.jsonPath("$.players",
                Matchers.aMapWithSize(2)));
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
        final Unit unit2;
        final Validator teamValidator;

        builder = Mockito.mock(DbxTeamBuilder.class);

        // TODO: Mock this better
        // TODO: The template should be received as a parameter in the mock
        unit = new DefaultUnit("1", 0, Role.GUARD, new MutableAttributes(),
                new LinkedList<Ability>(), false, true);
        unit2 = new DefaultUnit("2", 0, Role.GUARD, new MutableAttributes(),
                new LinkedList<Ability>(), false, true);

        Mockito.when(builder.getUnit(org.mockito.Matchers.anyString(),
                org.mockito.Matchers.anyCollection()))
                .thenReturn(unit, unit2, unit);

        teamValidator = Mockito.mock(Validator.class);

        return new DbxTeamBuilderRestController(builder, teamValidator);
    }

    /**
     * Returns a request builder for posting a player.
     * 
     * @return a request builder with a valid player
     */
    private final RequestBuilder getRequest() throws IOException {
        final byte[] content;
        final TeamPlayer player; // Assets for the team

        player = new TeamPlayer();

        // TODO: The received template name is being ignored
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
