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

package com.wandrell.tabletop.dreadball.web.toolkit.test.unit.controller.builder.dbx;

import java.io.IOException;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wandrell.tabletop.dreadball.build.dbx.DbxSponsorBuilder;
import com.wandrell.tabletop.dreadball.factory.DbxModelFactory;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.json.team.SponsorTeamMixIn;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.SponsorCreationController;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorForm;
import com.wandrell.tabletop.dreadball.web.toolkit.test.configuration.UrlDbxTeamBuilderConfig;

/**
 * Unit tests for {@link SponsorCreationController}, checking the methods for
 * sending the form data with missing data.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestSponsorCreationControllerSetSponsorMissingData {

    /**
     * Mocked MVC context.
     */
    private MockMvc mockMvc;

    /**
     * Default constructor;
     */
    public TestSponsorCreationControllerSetSponsorMissingData() {
        super();
    }

    /**
     * Sets up the mocked MVC context.
     */
    @BeforeTest
    public final void setUpMockContext() {
        mockMvc = MockMvcBuilders.standaloneSetup(getController())
                .alwaysExpect(MockMvcResultMatchers.status().isBadRequest())
                .build();
    }

    /**
     * Tests that after receiving form data missing an affinity the expected
     * attributes are loaded into the model.
     */
    @Test
    public final void testSendFormData_MissingAffinity_ExpectedAttributeModel()
            throws Exception {
        mockMvc.perform(getMissingAffinityFormRequest());

        // TODO: Verify error message
    }

    /**
     * Tests that after receiving form data missing the sponsor name the
     * expected attributes are loaded into the model.
     */
    @Test
    public final void testSendFormData_NoSponsorName_ExpectedAttributeModel()
            throws Exception {
        mockMvc.perform(getNoSponsorNameFormRequest());

        // TODO: Verify error message
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
        final DbxModelFactory factory;   // Mocked model factory

        service = Mockito.mock(DbxSponsorBuilder.class);

        factory = Mockito.mock(DbxModelFactory.class);

        // Mocks the sponsor
        sponsor = Mockito.mock(Sponsor.class);
        Mockito.when(factory.getSponsor(Matchers.any(SponsorForm.class)))
                .thenReturn(sponsor);

        // Mocks the team
        team = Mockito.mock(SponsorTeamMixIn.class);
        Mockito.when(factory.getSponsorTeam(Matchers.any(Sponsor.class)))
                .thenReturn(team);

        return new SponsorCreationController(service, factory);
    }

    /**
     * Returns a request builder for posting form data with a missing affinity.
     * 
     * @return a request builder with form data missing an affinity
     */
    private final RequestBuilder getMissingAffinityFormRequest()
            throws IOException {
        final SponsorForm sponsor;
        final byte[] content;

        sponsor = new SponsorForm();
        sponsor.setSponsorName("sponsor");
        sponsor.setAffinityB("aff");
        sponsor.setAffinityC("aff");
        sponsor.setAffinityD("aff");
        sponsor.setAffinityE("aff");

        content = new ObjectMapper().writeValueAsBytes(sponsor);

        return MockMvcRequestBuilders.post(UrlDbxTeamBuilderConfig.URL_SPONSOR)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(content);
    }

    /**
     * Returns a request builder for posting form data without a sponsor name.
     * 
     * @return a request builder with form data without a sponsor name
     * @throws IOException
     */
    private final RequestBuilder getNoSponsorNameFormRequest()
            throws IOException {
        final SponsorForm sponsor;
        final byte[] content;

        sponsor = new SponsorForm();
        sponsor.setAffinityA("aff");
        sponsor.setAffinityB("aff");
        sponsor.setAffinityC("aff");
        sponsor.setAffinityD("aff");
        sponsor.setAffinityE("aff");

        content = new ObjectMapper().writeValueAsBytes(sponsor);

        return MockMvcRequestBuilders.post(UrlDbxTeamBuilderConfig.URL_SPONSOR)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(content);
    }

}
