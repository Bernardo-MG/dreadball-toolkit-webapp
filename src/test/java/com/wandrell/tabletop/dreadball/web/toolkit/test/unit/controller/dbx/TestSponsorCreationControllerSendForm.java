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

import java.util.LinkedList;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.build.dbx.DbxSponsorBuilder;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.SponsorCreationController;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorForm;

/**
 * Unit tests for {@link SponsorCreationController}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestSponsorCreationControllerSendForm {

    /**
     * The name of the sponsor form bean.
     */
    private static final String FORM_BEAN = "form";

    /**
     * Form view URL.
     */
    private static final String URL_FORM  = "/builder/team/dbx";

    /**
     * The sponsor form view.
     */
    private static final String VIEW_FORM = "builder/dbx/sponsor";

    /**
     * The view after the form.
     */
    private static final String VIEW_NEXT = "builder/dbx/players";

    /**
     * Mocked MVC context.
     */
    private MockMvc             mockMvc;

    /**
     * Default constructor;
     */
    public TestSponsorCreationControllerSendForm() {
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
     * Tests that after receiving form data missing an affinity the expected
     * attributes are loaded into the model.
     */
    @Test
    public final void testSendFormData_MissingAffinity_ExpectedAttributeModel()
            throws Exception {
        final ResultActions result; // Request result

        result = mockMvc.perform(getMissingAffinityFormRequest());

        // The operation was accepted
        result.andExpect(MockMvcResultMatchers.status().isOk());

        // The response model contains the expected attributes
        result.andExpect(
                MockMvcResultMatchers.model().attributeExists(FORM_BEAN));

        // The response contains the expected errors
        result.andExpect(MockMvcResultMatchers.model()
                .attributeHasFieldErrors(FORM_BEAN, "affinityA"));
    }

    /**
     * Tests that after receiving form data missing an affinity the view is
     * again the form view.
     */
    @Test
    public final void testSendFormData_MissingAffinity_NoViewChange()
            throws Exception {
        final ResultActions result; // Request result

        result = mockMvc.perform(getMissingAffinityFormRequest());

        // The view is valid
        result.andExpect(MockMvcResultMatchers.view().name(VIEW_FORM));
    }

    /**
     * Tests that after receiving form data missing the sponsor name the
     * expected attributes are loaded into the model.
     */
    @Test
    public final void testSendFormData_NoSponsorName_ExpectedAttributeModel()
            throws Exception {
        final ResultActions result; // Request result

        result = mockMvc.perform(getNoSponsorNameFormRequest());

        // The operation was accepted
        result.andExpect(MockMvcResultMatchers.status().isOk());

        // The response model contains the expected attributes
        result.andExpect(
                MockMvcResultMatchers.model().attributeExists(FORM_BEAN));

        // The response contains the expected errors
        result.andExpect(MockMvcResultMatchers.model()
                .attributeHasFieldErrors(FORM_BEAN, "sponsorName"));
    }

    /**
     * Tests that after receiving form data missing an affinity the view is
     * again the form view.
     */
    @Test
    public final void testSendFormData_NoSponsorName_NoViewChange()
            throws Exception {
        final ResultActions result; // Request result

        result = mockMvc.perform(getNoSponsorNameFormRequest());

        // The view is valid
        result.andExpect(MockMvcResultMatchers.view().name(VIEW_FORM));
    }

    /**
     * Tests that after receiving valid form data the expected attributes are
     * loaded into the model.
     */
    @Test
    public final void testSendFormData_Valid_ExpectedAttributeModel()
            throws Exception {
        final ResultActions result; // Request result

        result = mockMvc.perform(getValidFormRequest());

        // The operation was accepted
        result.andExpect(MockMvcResultMatchers.status().isOk());

        // The response model contains the expected attributes
        result.andExpect(MockMvcResultMatchers.model().attributeExists("team"));
        result.andExpect(
                MockMvcResultMatchers.model().attributeExists("sponsor"));
        result.andExpect(MockMvcResultMatchers.model()
                .attributeExists("availablePlayers"));
    }

    /**
     * Tests that after received valid form data the expected view is returned.
     */
    @Test
    public final void testSendFormData_Valid_ExpectedView() throws Exception {
        final ResultActions result; // Request result

        // TODO: Just verify it is not this same view
        result = mockMvc.perform(getValidFormRequest());

        // The operation was accepted
        result.andExpect(MockMvcResultMatchers.status().isOk());

        // The view is valid
        result.andExpect(MockMvcResultMatchers.view().name(VIEW_NEXT));
    }

    /**
     * Returns a mocked controller.
     * <p>
     * It can create mocked sponsor, sponsor team and units.
     * 
     * @return a mocked controller
     */
    private final SponsorCreationController getController() {
        final DbxSponsorBuilder service; // Mocked service
        final Sponsor sponsor;           // Mocked sponsor
        final SponsorTeam team;          // Mocked sponsor team
        final Iterable<Unit> units;      // Mocked units

        service = Mockito.mock(DbxSponsorBuilder.class);

        // Mocks the sponsor
        sponsor = Mockito.mock(Sponsor.class);
        Mockito.when(service.getSponsor(Matchers.any(SponsorForm.class)))
                .thenReturn(sponsor);

        // Mocks the team
        team = Mockito.mock(SponsorTeam.class);
        Mockito.when(service.getSponsorTeam(Matchers.any(Sponsor.class)))
                .thenReturn(team);

        // Mocks the units
        units = new LinkedList<Unit>();
        Mockito.when(
                service.getSponsorAvailableUnits(Matchers.any(Sponsor.class)))
                .thenReturn(units);

        return new SponsorCreationController(service);
    }

    /**
     * Returns a request builder for posting form data with a missing affinity.
     * 
     * @return a request builder with form data missing an affinity
     */
    private final RequestBuilder getMissingAffinityFormRequest() {
        return MockMvcRequestBuilders.post(URL_FORM)
                .param("sponsorName", "sponsor").param("affinityB", "aff")
                .param("affinityC", "aff").param("affinityD", "aff")
                .param("affinityE", "aff");
    }

    /**
     * Returns a request builder for posting form data without a sponsor name.
     * 
     * @return a request builder with form data without a sponsor name
     */
    private final RequestBuilder getNoSponsorNameFormRequest() {
        return MockMvcRequestBuilders.post(URL_FORM).param("affinityA", "aff")
                .param("affinityB", "aff").param("affinityC", "aff")
                .param("affinityD", "aff").param("affinityE", "aff");
    }

    /**
     * Returns a request builder for posting valid form data.
     * 
     * @return a request builder with valid form data
     */
    private final RequestBuilder getValidFormRequest() {
        return MockMvcRequestBuilders.post(URL_FORM)
                .param("sponsorName", "sponsor").param("affinityA", "aff")
                .param("affinityB", "aff").param("affinityC", "aff")
                .param("affinityD", "aff").param("affinityE", "aff");
    }

}
