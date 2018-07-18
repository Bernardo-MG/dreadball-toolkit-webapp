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

import java.util.Collection;
import java.util.Collections;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
import com.bernardomg.tabletop.dreadball.model.ImmutableSponsorAffinities;
import com.bernardomg.tabletop.dreadball.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.web.toolkit.test.configuration.UrlDbxTeamBuilderConfig;
import com.google.common.collect.Iterables;

/**
 * Unit tests for {@link SponsorValidationController}, checking the results of
 * REST requests.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestSponsorValidationControllerAffinitiesValues {

    /**
     * Argument captor for the affinities parameter.
     */
    @SuppressWarnings("rawtypes")
    private ArgumentCaptor<Collection> captor;

    /**
     * Mocked MVC context.
     */
    private MockMvc                    mockMvc;

    /**
     * Mocked service.
     */
    private SponsorBuilderService      service;

    /**
     * Default constructor;
     */
    public TestSponsorValidationControllerAffinitiesValues() {
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
     * Verifies that the affinity received as parameter is sent to the service.
     */
    @Test
    public final void testValidateAffinities_AffParam_Affinity()
            throws Exception {
        mockMvc.perform(getGetRequest("aff"));

        Assert.assertEquals(1, Iterables.size(captor.getValue()));
        Assert.assertEquals("aff", captor.getValue().iterator().next());
    }

    /**
     * Verifies that multiple affinities are sent to the service.
     */
    @Test
    public final void testValidateAffinities_AffParam_Multiple_Affinities()
            throws Exception {
        mockMvc.perform(getGetRequest("[aff1,aff2]"));

        Assert.assertEquals(2, Iterables.size(captor.getValue()));
    }

    /**
     * Verifies that repeated affinities are sent to the service.
     */
    @Test
    public final void testValidateAffinities_AffParam_Repeated_Affinities()
            throws Exception {
        mockMvc.perform(getGetRequest("[aff,aff]"));

        Assert.assertEquals(2, Iterables.size(captor.getValue()));
    }

    /**
     * Verifies that if no affinities are received then an empty collection is
     * sent to the service.
     */
    @Test
    public final void testValidateAffinities_NoParams_NoAffinities()
            throws Exception {
        mockMvc.perform(getGetRequest());

        Assert.assertEquals(0, Iterables.size(captor.getValue()));
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

    /**
     * Returns a mocked service.
     * <p>
     * It is prepared for using the pagination data argument captor.
     * 
     * @return a mocked service
     */
    @SuppressWarnings("unchecked")
    private final SponsorBuilderService getSponsorBuilderService() {
        final SponsorBuilderService sponsorBuilderService;
        final SponsorAffinities result;

        sponsorBuilderService = Mockito.mock(SponsorBuilderService.class);

        result = new ImmutableSponsorAffinities(Collections.emptyList(), 0);

        captor = ArgumentCaptor.forClass(Collection.class);
        Mockito.when(sponsorBuilderService
                .validateSponsorAffinities(captor.capture()))
                .thenReturn(result);

        return sponsorBuilderService;
    }

}
