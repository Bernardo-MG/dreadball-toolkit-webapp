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
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bernardomg.tabletop.dreadball.build.controller.SponsorValidationController;
import com.bernardomg.tabletop.dreadball.web.toolkit.test.configuration.UrlDbxTeamBuilderConfig;

/**
 * Integration tests for {@link SponsorValidationController}, checking the
 * results of REST requests.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@ContextConfiguration(
        locations = { "classpath:context/test-servlet-dreadball.xml" })
@WebAppConfiguration
public class ITSponsorValidationControllerAffinities
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
    public ITSponsorValidationControllerAffinities() {
        super();
    }

    /**
     * Sets up the mocked MVC context.
     */
    @Before
    public final void setUpMockContext() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .alwaysExpect(MockMvcResultMatchers.status().isOk())
                .alwaysExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .build();
    }

    /**
     * Verifies that when the controller receives affinities it returns the
     * expected data.
     */
    @Test
    public final void testValidateAffinities_Affinities_ReturnsAffinities()
            throws Exception {
        final ResultActions result;

        result = mockMvc.perform(getGetRequest("[affinity_1,affinity_2]"));

        result.andExpect(MockMvcResultMatchers.jsonPath("$.affinities",
                Matchers.hasSize(2)));
    }

    /**
     * Verifies that when the controller receives no data it returns the
     * expected fields.
     */
    @Test
    public final void testValidateAffinities_Empty_ReturnsValues()
            throws Exception {
        final ResultActions result;

        result = mockMvc.perform(getGetRequest());

        result.andExpect(
                MockMvcResultMatchers.jsonPath("$.affinities").isEmpty());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.rank").isNotEmpty());
    }

    /**
     * Verifies that when the controller receives repeated affinities it returns
     * the expected data.
     */
    @Test
    public final void
            testValidateAffinities_RepeatedAffinities_ReturnsAffinities()
                    throws Exception {
        final ResultActions result;

        result = mockMvc.perform(getGetRequest("[affinity_1,affinity_1]"));

        result.andExpect(MockMvcResultMatchers.jsonPath("$.affinities",
                Matchers.hasSize(2)));
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
     * Returns a request builder prepared for validating the specified affinity.
     * 
     * @return a request builder prepared for validating the specified affinity
     */
    private final RequestBuilder getGetRequest(final String affinity) {
        return MockMvcRequestBuilders
                .get(UrlDbxTeamBuilderConfig.URL_VALIDATE_AFFINITIES
                        + "?affinities={aff}", affinity);
    }

}
