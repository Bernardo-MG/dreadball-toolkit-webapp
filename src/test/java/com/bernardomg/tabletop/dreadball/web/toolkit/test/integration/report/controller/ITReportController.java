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

package com.bernardomg.tabletop.dreadball.web.toolkit.test.integration.report.controller;

import org.junit.Assert;
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
public class ITReportController extends AbstractJUnit4SpringContextTests {

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
    public ITReportController() {
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
                        .contentType(MediaType.APPLICATION_PDF))
                .build();
    }

    /**
     * Verifies that when the controller receives no data it returns the
     * expected content.
     */
    @Test
    public final void testReport_Empty_ExpectedContent() throws Exception {
        mockMvc.perform(getGetRequest());
    }

    /**
     * Verifies that the PDF view sets the expected attributes.
     */
    @Test
    public final void testReport_Empty_ExpectedHeader() throws Exception {
        final ResultActions result; // Request result
        final String content;       // Content header

        result = mockMvc.perform(getGetRequest());

        content = result.andReturn().getResponse()
                .getHeader("Content-disposition");

        Assert.assertEquals("inline; filename=EntityReport.pdf", content);
    }

    /**
     * Returns a request builder with no parameters.
     * 
     * @return a request builder with no parameters
     */
    private final RequestBuilder getGetRequest() {
        return MockMvcRequestBuilders.get(UrlDbxTeamBuilderConfig.URL_REPORT);
    }

}
