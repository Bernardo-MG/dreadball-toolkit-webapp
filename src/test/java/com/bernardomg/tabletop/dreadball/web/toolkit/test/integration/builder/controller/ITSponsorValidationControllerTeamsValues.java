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

package com.bernardomg.tabletop.dreadball.web.toolkit.test.integration.builder.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bernardomg.tabletop.dreadball.build.controller.SponsorValidationController;
import com.bernardomg.tabletop.dreadball.web.toolkit.test.configuration.TestValues;
import com.bernardomg.tabletop.dreadball.web.toolkit.test.configuration.UrlDbxTeamBuilderConfig;

/**
 * Integration tests for {@link SponsorValidationController}, checking the
 * results of REST requests.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(
        locations = { "classpath:context/test-servlet-dreadball.xml" })
@WebAppConfiguration
public class ITSponsorValidationControllerTeamsValues
        extends AbstractJUnit4SpringContextTests {

    /**
     * Application context.
     */
    @Autowired
    private WebApplicationContext context;

    /**
     * Mocked MVC context.
     */
    private MockMvc               mockMvc;

    /**
     * Default constructor;
     */
    public ITSponsorValidationControllerTeamsValues() {
        super();
    }

    /**
     * Sets up the mocked MVC context.
     */
    @BeforeEach
    public final void setUpMockContext() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .alwaysExpect(MockMvcResultMatchers.status().isOk())
                .alwaysExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .build();
    }

    /**
     * Verifies that when the controller receives no data it returns the
     * expected fields.
     */
    @Test
    public final void testValidateTeam_Empty_ReturnsValues() throws Exception {
        final ResultActions result;

        result = mockMvc.perform(getGetRequest());

        result.andExpect(MockMvcResultMatchers
                .jsonPath("$.additionalAffinityGroups").isEmpty());
        result.andExpect(
                MockMvcResultMatchers.jsonPath("$.baseRank").isNotEmpty());
        result.andExpect(
                MockMvcResultMatchers.jsonPath("$.cheerleaders").isNotEmpty());
        result.andExpect(
                MockMvcResultMatchers.jsonPath("$.coachingDice").isNotEmpty());
        result.andExpect(
                MockMvcResultMatchers.jsonPath("$.currentRank").isNotEmpty());
        result.andExpect(
                MockMvcResultMatchers.jsonPath("$.mediBots").isNotEmpty());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.nastySurpriseCards")
                .isNotEmpty());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.players").isEmpty());
        result.andExpect(
                MockMvcResultMatchers.jsonPath("$.rankCost").isNotEmpty());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.specialMoveCards")
                .isNotEmpty());
        result.andExpect(
                MockMvcResultMatchers.jsonPath("$.sponsor").isNotEmpty());
        result.andExpect(
                MockMvcResultMatchers.jsonPath("$.totalCost").isNotEmpty());
        result.andExpect(
                MockMvcResultMatchers.jsonPath("$.wagers").isNotEmpty());
    }

    /**
     * Verifies that the player received as parameter is sent to the service.
     */
    @Test
    public final void testValidateTeam_Multiple_Players() throws Exception {
        final ResultActions result;

        result = mockMvc.perform(
                getGetRequest(TestValues.PLAYER_A, TestValues.PLAYER_C));

        result.andExpect(MockMvcResultMatchers.jsonPath("$.players",
                Matchers.aMapWithSize(2)));
    }

    /**
     * Verifies that the player received as parameter is sent to the service.
     */
    @Test
    public final void testValidateTeam_Repeated_Players() throws Exception {
        final ResultActions result;

        result = mockMvc.perform(
                getGetRequest(TestValues.PLAYER_A, TestValues.PLAYER_A));

        result.andExpect(MockMvcResultMatchers.jsonPath("$.players",
                Matchers.aMapWithSize(2)));
    }

    /**
     * Returns a request builder with no parameters.
     * 
     * @return a request builder with no parameters
     */
    private final RequestBuilder getGetRequest() {
        return MockMvcRequestBuilders
                .get(UrlDbxTeamBuilderConfig.URL_VALIDATE_TEAM);
    }

    /**
     * Returns a request builder prepared for validating the specified player.
     * 
     * @return a request builder prepared for validating the specified player
     */
    private final RequestBuilder getGetRequest(final String player1,
            final String player2) {
        // TODO: Check why this won't work with an array of strings
        return MockMvcRequestBuilders
                .get(UrlDbxTeamBuilderConfig.URL_VALIDATE_TEAM
                        + "?teamPlayers={u}&teamPlayers={u}", player1, player2);
    }

}
