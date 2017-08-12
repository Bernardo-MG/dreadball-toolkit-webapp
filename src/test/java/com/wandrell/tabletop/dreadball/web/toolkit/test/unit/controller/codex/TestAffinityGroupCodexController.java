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

package com.wandrell.tabletop.dreadball.web.toolkit.test.unit.controller.codex;

import java.util.ArrayList;
import java.util.Collection;

import org.hamcrest.Matchers;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.json.unit.AffinityGroupMixIn;
import com.wandrell.tabletop.dreadball.service.model.AffinityGroupService;
import com.wandrell.tabletop.dreadball.web.toolkit.controller.codex.AffinityGroupCodexController;
import com.wandrell.tabletop.dreadball.web.toolkit.test.configuration.UrlUnitCodexConfig;

/**
 * Unit tests for {@link AffinityGroupCodexController}, checking the results of
 * REST requests.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestAffinityGroupCodexController {

    /**
     * Mocked MVC context.
     */
    private MockMvc mockMvc;

    /**
     * Default constructor;
     */
    public TestAffinityGroupCodexController() {
        super();
    }

    /**
     * Sets up the mocked MVC context.
     */
    @BeforeTest
    public final void setUpMockContext() {
        mockMvc = MockMvcBuilders.standaloneSetup(getController()).build();
    }

    /**
     * Tests that a get request returns the expected data.
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
     * Returns a mocked controller.
     * <p>
     * It has all the dependencies stubbed.
     * 
     * @return a mocked controller
     */
    private final AffinityGroupCodexController getController() {
        final AffinityGroupService codex; // Mocked unit codex
        final Collection groups;

        codex = Mockito.mock(AffinityGroupService.class);

        groups = new ArrayList<>();
        groups.add(Mockito.mock(AffinityGroupMixIn.class));
        groups.add(Mockito.mock(AffinityGroupMixIn.class));
        groups.add(Mockito.mock(AffinityGroupMixIn.class));

        Mockito.when(codex.getAllAffinityGroups()).thenReturn(groups);

        return new AffinityGroupCodexController(codex);
    }

    /**
     * Returns a request builder for getting the tested form view.
     * 
     * @return a request builder for the form view
     */
    private final RequestBuilder getGetRequest() {
        return MockMvcRequestBuilders
                .get(UrlUnitCodexConfig.URL_AFFINITY_GROUPS);
    }

}
