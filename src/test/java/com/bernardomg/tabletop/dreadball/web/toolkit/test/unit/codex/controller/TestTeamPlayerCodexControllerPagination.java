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

package com.bernardomg.tabletop.dreadball.web.toolkit.test.unit.codex.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bernardomg.tabletop.dreadball.codex.controller.TeamPlayerCodexController;
import com.bernardomg.tabletop.dreadball.codex.service.CodexService;
import com.bernardomg.tabletop.dreadball.model.json.player.AffinityTeamPlayerMixIn;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;
import com.bernardomg.tabletop.dreadball.web.toolkit.test.configuration.UrlTeamPlayerCodexConfig;

/**
 * TeamPlayer tests for {@link TeamPlayerCodexController}, validating the
 * results of REST requests.
 * <p>
 * The tested controller gives support only for GET requests.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestTeamPlayerCodexControllerPagination {

    /**
     * Argument captor for pagination data.
     */
    private ArgumentCaptor<Pageable> captor;

    /**
     * Mocked MVC context.
     */
    private MockMvc                  mockMvc;

    /**
     * Mocked service.
     */
    private final CodexService       service;

    /**
     * Default constructor;
     */
    public TestTeamPlayerCodexControllerPagination() {
        super();

        service = getCodexService();
    }

    /**
     * Sets up the mocked MVC context.
     */
    @Before
    public final void setUpMockContext() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(new TeamPlayerCodexController(service))
                .setCustomArgumentResolvers(
                        new PageableHandlerMethodArgumentResolver())
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

        Assert.assertEquals(20, pageable.getPageSize());
        Assert.assertEquals(0, pageable.getPageNumber());
    }

    /**
     * Returns a mocked service.
     * <p>
     * It is prepared for using the pagination data argument captor.
     * 
     * @return a mocked service
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private final CodexService getCodexService() {
        final CodexService service;   // Mocked service
        final Collection<TeamPlayer> players; // Returned players

        service = Mockito.mock(CodexService.class);

        players = new ArrayList<>();
        players.add(Mockito.mock(AffinityTeamPlayerMixIn.class));
        players.add(Mockito.mock(AffinityTeamPlayerMixIn.class));
        players.add(Mockito.mock(AffinityTeamPlayerMixIn.class));

        captor = ArgumentCaptor.forClass(Pageable.class);

        Mockito.when(service.getAffinityTeamPlayers(captor.capture()))
                .thenReturn((Iterable) players);

        return service;
    }

    /**
     * Returns a request builder prepared for reading players.
     * 
     * @return a request builder prepared for reading players
     */
    private final RequestBuilder getGetRequest() {
        return MockMvcRequestBuilders.get(UrlTeamPlayerCodexConfig.URL_PLAYERS);
    }

    /**
     * Returns a request builder prepared for reading players and a page set.
     * 
     * @return a request builder prepared for reading players
     */
    private final RequestBuilder getGetRequestWithPage() {
        return MockMvcRequestBuilders
                .get(UrlTeamPlayerCodexConfig.URL_PLAYERS + "?page=10");
    }

}
