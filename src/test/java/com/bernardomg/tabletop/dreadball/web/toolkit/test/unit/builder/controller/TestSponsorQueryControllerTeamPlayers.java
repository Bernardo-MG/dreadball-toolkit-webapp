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

package com.bernardomg.tabletop.dreadball.web.toolkit.test.unit.builder.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bernardomg.tabletop.dreadball.build.controller.SponsorPlayersController;
import com.bernardomg.tabletop.dreadball.build.service.SponsorBuilderService;
import com.bernardomg.tabletop.dreadball.model.json.player.AffinityTeamPlayerMixIn;
import com.bernardomg.tabletop.dreadball.web.toolkit.test.configuration.UrlDbxTeamBuilderConfig;

/**
 * TeamPlayer tests for {@link SponsorPlayersController}, validating the results
 * of REST requests for players.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestSponsorQueryControllerTeamPlayers {

    /**
     * Mocked MVC context.
     */
    private MockMvc mockMvc;

    /**
     * Default constructor;
     */
    public TestSponsorQueryControllerTeamPlayers() {
        super();
    }

    /**
     * Sets up the mocked MVC context.
     */
    @Before
    public final void setUpMockContext() {
        mockMvc = MockMvcBuilders.standaloneSetup(getController())
                .alwaysExpect(MockMvcResultMatchers.status().isOk())
                .alwaysExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .build();
    }

    /**
     * Verifies that the data read from the service is returned.
     */
    @Test
    public final void testGet_ExpectedResults() throws Exception {
        final ResultActions result; // Request result

        result = mockMvc.perform(getGetRequest());

        // The operation was accepted
        result.andExpect(MockMvcResultMatchers.status().isOk());

        // The response model contains the expected attributes
        result.andExpect(
                MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)));
    }

    /**
     * Returns a controller with mocked dependencies.
     * 
     * @return a controller with mocked dependencies
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private final SponsorPlayersController getController() {
        final SponsorBuilderService service;  // Mocked service
        final Collection players; // Returned players

        service = Mockito.mock(SponsorBuilderService.class);

        players = new ArrayList<>();
        players.add(Mockito.mock(AffinityTeamPlayerMixIn.class));
        players.add(Mockito.mock(AffinityTeamPlayerMixIn.class));
        players.add(Mockito.mock(AffinityTeamPlayerMixIn.class));

        Mockito.when(service.getTeamPlayerOptions(org.mockito.Matchers.any(),
                org.mockito.Matchers.any())).thenReturn(players);

        return new SponsorPlayersController(service);
    }

    /**
     * Returns a request builder prepared for reading players.
     * 
     * @return a request builder prepared for reading players
     */
    private final RequestBuilder getGetRequest() {
        return MockMvcRequestBuilders.get(UrlDbxTeamBuilderConfig.URL_PLAYERS);
    }

}
