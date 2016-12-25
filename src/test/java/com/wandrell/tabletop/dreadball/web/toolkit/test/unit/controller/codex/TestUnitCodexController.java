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

import java.util.Collection;
import java.util.LinkedList;

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

import com.wandrell.tabletop.dreadball.codex.UnitCodex;
import com.wandrell.tabletop.dreadball.model.json.unit.AffinityUnitMixIn;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.SponsorCreationController;
import com.wandrell.tabletop.dreadball.web.toolkit.codex.controller.UnitCodexController;
import com.wandrell.tabletop.dreadball.web.toolkit.test.configuration.UrlUnitCodexConfig;

/**
 * Unit tests for {@link SponsorCreationController}, checking the methods for
 * showing the form.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestUnitCodexController {

    /**
     * Mocked MVC context.
     */
    private MockMvc mockMvc;

    /**
     * Default constructor;
     */
    public TestUnitCodexController() {
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
     * Tests that the form view loads the expected attributes into the model.
     * <p>
     * The form requires a bean which will contain all its data.
     */
    @Test
    public final void testShowForm_ExpectedAttributeModel() throws Exception {
        final ResultActions result; // Request result

        result = mockMvc.perform(getViewRequest());

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
    private final UnitCodexController getController() {
        final UnitCodex codex; // Mocked unit codex
        final Collection<AffinityUnit> units;

        codex = Mockito.mock(UnitCodex.class);

        units = new LinkedList<AffinityUnit>();
        units.add(Mockito.mock(AffinityUnitMixIn.class));
        units.add(Mockito.mock(AffinityUnitMixIn.class));
        units.add(Mockito.mock(AffinityUnitMixIn.class));

        Mockito.when(codex.getAllAffinityUnits()).thenReturn(units);

        return new UnitCodexController(codex);
    }

    /**
     * Returns a request builder for getting the tested form view.
     * 
     * @return a request builder for the form view
     */
    private final RequestBuilder getViewRequest() {
        return MockMvcRequestBuilders.get(UrlUnitCodexConfig.URL_UNITS);
    }

}
