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

package com.wandrell.tabletop.dreadball.web.toolkit.test.unit.controller.report;

import java.util.LinkedHashMap;
import java.util.Map;

import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.calculator.RankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.report.dbx.DbxTeamReporter;
import com.wandrell.tabletop.dreadball.web.toolkit.report.dbx.controller.DbxReportController;
import com.wandrell.tabletop.dreadball.web.toolkit.report.dbx.service.DefaultDbxTeamReporter;
import com.wandrell.tabletop.dreadball.web.toolkit.test.configuration.BeanConfig;
import com.wandrell.tabletop.dreadball.web.toolkit.test.configuration.UrlReportConfig;

/**
 * Unit tests for {@link SponsorCreationController}, checking the methods for
 * showing the form.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestReportController {

    /**
     * Mocked MVC context.
     */
    private MockMvc mockMvc;

    /**
     * Default constructor;
     */
    public TestReportController() {
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
     * Tests that the PDF view sets the expected attributes.
     */
    @Test
    public final void testPdf_ExpectedAttributeModel() throws Exception {
        final ResultActions result; // Request result

        result = mockMvc.perform(getRequest());

        // The operation was accepted
        result.andExpect(MockMvcResultMatchers.status().isOk());

        // The response indicates it is a PDF
        result.andExpect(MockMvcResultMatchers.content()
                .contentType(MediaType.APPLICATION_PDF));
    }

    /**
     * Returns a mocked controller.
     * <p>
     * It has all the dependencies stubbed.
     * 
     * @return a mocked controller
     */
    private final DbxReportController getController() {
        final DbxTeamReporter reporter; // Mocked unit codex

        reporter = new DefaultDbxTeamReporter();

        return new DbxReportController(reporter);
    }

    /**
     * Returns a request builder for getting the PDF view.
     * 
     * @return a request builder for the PDF view
     */
    private final RequestBuilder getRequest() {
        return MockMvcRequestBuilders.get(UrlReportConfig.URL_PDF)
                .sessionAttrs(getSessionAttributes());
    }

    /**
     * Returns the session attributes required for the controller to work.
     * 
     * @return the session attributes required by the controller
     */
    @SuppressWarnings("unchecked")
    private final Map<String, Object> getSessionAttributes() {
        final Map<String, Object> sessionAttrs;

        sessionAttrs = new LinkedHashMap<>();
        sessionAttrs.put(BeanConfig.TEAM_BEAN,
                new DefaultSponsorTeam(new DefaultSponsor(),
                        Mockito.mock(TeamValorationCalculator.class),
                        Mockito.mock(RankCostCalculator.class)));

        return sessionAttrs;
    }

}
