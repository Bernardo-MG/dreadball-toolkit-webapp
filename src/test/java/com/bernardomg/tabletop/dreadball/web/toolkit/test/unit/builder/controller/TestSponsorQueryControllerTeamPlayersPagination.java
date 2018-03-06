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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bernardomg.tabletop.dreadball.build.controller.SponsorQueryController;
import com.bernardomg.tabletop.dreadball.build.service.SponsorBuilderService;
import com.bernardomg.tabletop.dreadball.codex.controller.TeamPlayerCodexController;
import com.bernardomg.tabletop.dreadball.model.json.player.AffinityTeamPlayerMixIn;
import com.bernardomg.tabletop.dreadball.web.toolkit.test.configuration.UrlDbxTeamBuilderConfig;

/**
 * TeamPlayer tests for {@link TeamPlayerCodexController}, validating the
 * results of REST requests.
 * <p>
 * The tested controller gives support only for GET requests.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestSponsorQueryControllerTeamPlayersPagination {

    /**
     * Argument captor for pagination data.
     */
    private ArgumentCaptor<Pageable>    captor;

    /**
     * Mocked MVC context.
     */
    private MockMvc                     mockMvc;

    /**
     * Mocked service.
     */
    private final SponsorBuilderService service;

    /**
     * Default constructor;
     */
    public TestSponsorQueryControllerTeamPlayersPagination() {
        super();

        service = getSponsorBuilderService();
    }

    /**
     * Sets up the mocked MVC context.
     */
    @Before
    public final void setUpMockContext() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(new SponsorQueryController(service))
                .alwaysExpect(MockMvcResultMatchers.status().isOk())
                .alwaysExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .build();
    }

    /**
     * Verifies that the page received as parameter is used for pagination.
     */
    @Test
    public final void testGet_Page_SetInPagination() throws Exception {
        final Pageable pageable;

        mockMvc.perform(getGetRequestWithPage());

        pageable = captor.getValue();

        Assert.assertEquals(10, pageable.getPageNumber());
    }

    /**
     * Verifies that default pagination values are used when no pagination
     * parameters are received.
     */
    @Test
    public final void testGet_WithoutPagination_DefaultValues()
            throws Exception {
        final Pageable pageable;

        mockMvc.perform(getGetRequest());

        pageable = captor.getValue();

        Assert.assertEquals(10, pageable.getPageSize());
        Assert.assertEquals(0, pageable.getPageNumber());
    }

    /**
     * Returns a request builder prepared for reading players.
     * 
     * @return a request builder prepared for reading players
     */
    private final RequestBuilder getGetRequest() {
        return MockMvcRequestBuilders.get(UrlDbxTeamBuilderConfig.URL_PLAYERS);
    }

    /**
     * Returns a request builder prepared for reading players and a page set.
     * 
     * @return a request builder prepared for reading players
     */
    private final RequestBuilder getGetRequestWithPage() {
        return MockMvcRequestBuilders
                .get(UrlDbxTeamBuilderConfig.URL_PLAYERS + "?page=10");
    }

    /**
     * Returns a mocked service.
     * <p>
     * It is prepared for using the pagination data argument captor.
     * 
     * @return a mocked service
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private final SponsorBuilderService getSponsorBuilderService() {
        final SponsorBuilderService service;   // Mocked service
        final Collection players; // Returned players

        service = Mockito.mock(SponsorBuilderService.class);

        players = new ArrayList<>();
        players.add(Mockito.mock(AffinityTeamPlayerMixIn.class));
        players.add(Mockito.mock(AffinityTeamPlayerMixIn.class));
        players.add(Mockito.mock(AffinityTeamPlayerMixIn.class));

        captor = ArgumentCaptor.forClass(Pageable.class);

        Mockito.when(
                service.getTeamPlayerOptions(Matchers.any(), captor.capture()))
                .thenReturn(players);

        return service;
    }

}
