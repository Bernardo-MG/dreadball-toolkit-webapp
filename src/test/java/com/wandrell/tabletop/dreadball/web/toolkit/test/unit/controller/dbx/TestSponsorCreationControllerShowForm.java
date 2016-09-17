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

package com.wandrell.tabletop.dreadball.web.toolkit.test.unit.controller.dbx;

import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.build.dbx.DbxSponsorBuilder;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.SponsorCreationController;

/**
 * Unit tests for {@link SponsorCreationController}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The form view loads the expected attributes into the model</li>
 * <li>The form view uses the expected view</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestSponsorCreationControllerShowForm {

    /**
     * Mocked MVC context.
     */
    private MockMvc mockMvc;

    /**
     * Default constructor;
     */
    public TestSponsorCreationControllerShowForm() {
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
     */
    @Test
    public final void testShowForm_ExpectedAttributeModel() throws Exception {
        mockMvc.perform(getViewRequest())
                .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(
                        MockMvcResultMatchers.model().attributeExists("form"));
    }

    /**
     * Tests that the form view uses the expected view.
     */
    @Test
    public final void testShowForm_ExpectedView() throws Exception {
        mockMvc.perform(getViewRequest())
                .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(
                        MockMvcResultMatchers.view().name("build/dbx/sponsor"));
    }

    /**
     * Returns a mocked controller.
     * <p>
     * It has all the dependencies stubbed.
     * 
     * @return a mocked controller
     */
    private final SponsorCreationController getController() {
        final DbxSponsorBuilder service; // Mocked sponsor builder service

        service = Mockito.mock(DbxSponsorBuilder.class);

        return new SponsorCreationController(service);
    }

    /**
     * Returns a request builder for getting the tested form view.
     * 
     * @return a request builder for the form view
     */
    private final RequestBuilder getViewRequest() {
        return MockMvcRequestBuilders.get("/builder/team/dbx");
    }

}
