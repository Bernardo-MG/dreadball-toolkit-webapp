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

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bernardomg.tabletop.dreadball.build.controller.SponsorValidationController;
import com.bernardomg.tabletop.dreadball.build.service.SponsorBuilderService;
import com.bernardomg.tabletop.dreadball.model.ImmutableSponsorAffinities;
import com.bernardomg.tabletop.dreadball.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.web.toolkit.test.configuration.UrlDbxTeamBuilderConfig;

/**
 * Unit tests for {@link SponsorValidationController}, checking the results of
 * REST requests.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestSponsorValidationControllerAffinities {

    /**
     * Default constructor;
     */
    public TestSponsorValidationControllerAffinities() {
        super();
    }

    /**
     * Verifies that when there is no data the controller returns the expected
     * fields.
     */
    @Test
    public final void testGet_Empty_ReturnsValues() throws Exception {
        final ResultActions result;

        result = getMockContextEmpty().perform(getGetRequest());

        result.andExpect(
                MockMvcResultMatchers.jsonPath("$.affinities").isEmpty());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.rank").isNotEmpty());
    }

    /**
     * Verifies that when there is data the controller returns the expected
     * fields.
     */
    @Test
    public final void testGet_NotEmpty_ReturnsValues() throws Exception {
        final ResultActions result;

        result = getMockContextNotEmpty().perform(getGetRequest());

        result.andExpect(
                MockMvcResultMatchers.jsonPath("$.affinities").isNotEmpty());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.rank").isNotEmpty());
    }

    /**
     * Returns a mocked controller.
     * <p>
     * It has all the dependencies stubbed.
     * 
     * @return a mocked controller
     */
    private final SponsorValidationController getController() {
        final SponsorBuilderService sponsorBuilderService;
        final SponsorAffinities result;

        sponsorBuilderService = Mockito.mock(SponsorBuilderService.class);

        result = new ImmutableSponsorAffinities(Arrays.asList("aff"), 0);

        Mockito.when(sponsorBuilderService
                .validateSponsorAffinities(ArgumentMatchers.any()))
                .thenReturn(result);

        return new SponsorValidationController(sponsorBuilderService);
    }

    /**
     * Returns a mocked controller.
     * <p>
     * It has all the dependencies stubbed.
     * 
     * @return a mocked controller
     */
    private final SponsorValidationController getControllerEmpty() {
        final SponsorBuilderService sponsorBuilderService;
        final SponsorAffinities result;

        sponsorBuilderService = Mockito.mock(SponsorBuilderService.class);

        result = new ImmutableSponsorAffinities(Collections.emptyList(), 0);

        Mockito.when(sponsorBuilderService
                .validateSponsorAffinities(ArgumentMatchers.any()))
                .thenReturn(result);

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
                .get(UrlDbxTeamBuilderConfig.URL_VALIDATE_AFFINITIES);
    }

    /**
     * Creates a mocked MVC context with no data.
     */
    private final MockMvc getMockContextEmpty() {
        return MockMvcBuilders.standaloneSetup(getControllerEmpty())
                .alwaysExpect(MockMvcResultMatchers.status().isOk())
                .alwaysExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .build();
    }

    /**
     * Creates a mocked MVC context with data.
     */
    private final MockMvc getMockContextNotEmpty() {
        return MockMvcBuilders.standaloneSetup(getController())
                .alwaysExpect(MockMvcResultMatchers.status().isOk())
                .alwaysExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .build();
    }

}
