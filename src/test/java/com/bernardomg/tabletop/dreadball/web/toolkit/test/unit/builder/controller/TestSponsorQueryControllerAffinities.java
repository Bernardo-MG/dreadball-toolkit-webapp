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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bernardomg.tabletop.dreadball.build.controller.SponsorInitialAffinityOptionsController;
import com.bernardomg.tabletop.dreadball.build.controller.SponsorPlayersController;
import com.bernardomg.tabletop.dreadball.build.service.SponsorBuilderService;
import com.bernardomg.tabletop.dreadball.model.Option;
import com.bernardomg.tabletop.dreadball.model.OptionGroup;
import com.bernardomg.tabletop.dreadball.web.toolkit.test.configuration.UrlDbxTeamBuilderConfig;

/**
 * Unit tests for {@link SponsorPlayersController}, validating the results of
 * REST requests for affinity groups.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestSponsorQueryControllerAffinities {

    /**
     * Mocked MVC context.
     */
    private MockMvc mockMvc;

    /**
     * Default constructor;
     */
    public TestSponsorQueryControllerAffinities() {
        super();
    }

    /**
     * Sets up the mocked MVC context.
     */
    @BeforeEach
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
                MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)));
    }

    /**
     * Returns a controller with mocked dependencies.
     * 
     * @return a controller with mocked dependencies
     */
    private final SponsorInitialAffinityOptionsController getController() {
        final SponsorBuilderService service;  // Mocked service
        final Collection<OptionGroup> groups; // Returned option groups
        final OptionGroup group;              // Returned option group
        final Option option;                  // Returned option group

        service = Mockito.mock(SponsorBuilderService.class);

        groups = new ArrayList<>();

        option = Mockito.mock(Option.class);

        group = Mockito.mock(OptionGroup.class);
        Mockito.when(group.getOptions()).thenReturn(Arrays.asList(option));

        groups.add(group);

        Mockito.when(service.getAffinityOptions()).thenReturn(groups);

        return new SponsorInitialAffinityOptionsController(service);
    }

    /**
     * Returns a request builder prepared for reading players.
     * 
     * @return a request builder prepared for reading players
     */
    private final RequestBuilder getGetRequest() {
        return MockMvcRequestBuilders
                .get(UrlDbxTeamBuilderConfig.URL_AFFINITIES);
    }

}
