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

package com.bernardomg.tabletop.dreadball.web.toolkit.test.unit.builder.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bernardomg.tabletop.dreadball.build.controller.SponsorValidationController;
import com.bernardomg.tabletop.dreadball.build.service.SponsorBuilderService;
import com.bernardomg.tabletop.dreadball.model.SponsorTeamSelection;
import com.bernardomg.tabletop.dreadball.model.json.team.SponsorTeamMixIn;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.bernardomg.tabletop.dreadball.web.toolkit.test.configuration.UrlDbxTeamBuilderConfig;
import com.google.common.collect.Iterables;

/**
 * TeamPlayer tests for {@link SponsorValidationController}, checking the
 * results of REST requests.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestSponsorValidationControllerTeamsValues {

    /**
     * Argument captor for the team parameter.
     */
    private ArgumentCaptor<SponsorTeamSelection> captor;

    /**
     * Mocked MVC context.
     */
    private MockMvc                              mockMvc;

    /**
     * Mocked service.
     */
    private SponsorBuilderService                service;

    /**
     * Default constructor;
     */
    public TestSponsorValidationControllerTeamsValues() {
        super();
    }

    /**
     * Sets up the mocked MVC context.
     */
    @BeforeEach
    public final void setUpMockContext() {
        service = getSponsorBuilderService();
        mockMvc = MockMvcBuilders.standaloneSetup(getController(service))
                .alwaysExpect(MockMvcResultMatchers.status().isOk())
                .alwaysExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .build();
    }

    /**
     * Verifies that the player received as parameter is sent to the service.
     */
    @Test
    public final void testValidateTeam_Multiple_TeamPlayers() throws Exception {
        mockMvc.perform(getGetRequest("[player1,player2]"));

        Assertions.assertEquals(2,
                Iterables.size(captor.getValue().getTeamPlayers()));
    }

    /**
     * Verifies that if no players are received then an empty collection is sent
     * to the service.
     */
    @Test
    public final void testValidateTeam_NoParams_NoTeamPlayers()
            throws Exception {
        mockMvc.perform(getGetRequest());

        Assertions.assertEquals(0,
                Iterables.size(captor.getValue().getTeamPlayers()));
    }

    /**
     * Verifies that the player received as parameter is sent to the service.
     */
    @Test
    public final void testValidateTeam_Repeated_TeamPlayers() throws Exception {
        mockMvc.perform(getGetRequest("[player1,player1]"));

        Assertions.assertEquals(2,
                Iterables.size(captor.getValue().getTeamPlayers()));
    }

    /**
     * Verifies that the player received as parameter is sent to the service.
     */
    @Test
    public final void testValidateTeam_TeamPlayerParam_TeamPlayers()
            throws Exception {
        mockMvc.perform(getGetRequest("player"));

        Assertions.assertEquals(1,
                Iterables.size(captor.getValue().getTeamPlayers()));
    }

    /**
     * Returns a mocked controller.
     * <p>
     * It has all the dependencies stubbed.
     * 
     * @return a mocked controller
     */
    private final SponsorValidationController
            getController(final SponsorBuilderService sponsorBuilderService) {
        return new SponsorValidationController(sponsorBuilderService);
    }

    /**
     * Returns a request builder prepared for validating affinities with no
     * affinities.
     * 
     * @return a request builder with no affinities
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
    private final RequestBuilder getGetRequest(final String player) {
        return MockMvcRequestBuilders.get(
                UrlDbxTeamBuilderConfig.URL_VALIDATE_TEAM + "?teamPlayers={u}",
                player);
    }

    /**
     * Returns a mocked service.
     * <p>
     * It is prepared for using the pagination data argument captor.
     * 
     * @return a mocked service
     */
    private final SponsorBuilderService getSponsorBuilderService() {
        final SponsorBuilderService sponsorBuilderService;
        final SponsorTeam result;

        sponsorBuilderService = Mockito.mock(SponsorBuilderService.class);

        result = Mockito.mock(SponsorTeamMixIn.class);

        captor = ArgumentCaptor.forClass(SponsorTeamSelection.class);
        Mockito.when(sponsorBuilderService.validateTeam(captor.capture()))
                .thenReturn(result);

        return sponsorBuilderService;
    }

}
