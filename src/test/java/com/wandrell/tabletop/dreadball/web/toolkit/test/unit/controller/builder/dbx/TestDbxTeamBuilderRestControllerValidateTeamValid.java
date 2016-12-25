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
import java.util.LinkedHashMap;
import java.util.Map;

import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.build.dbx.DbxTeamBuilder;
import com.wandrell.tabletop.dreadball.factory.DbxModelFactory;
import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.calculator.RankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.DbxTeamBuilderController;
import com.wandrell.tabletop.dreadball.web.toolkit.test.configuration.BeanConfig;
import com.wandrell.tabletop.dreadball.web.toolkit.test.configuration.UrlDbxTeamBuilderConfig;

/**
 * Unit tests for {@link DbxTeamBuilderController}, checking the methods for
 * setting the team assets.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestDbxTeamBuilderRestControllerValidateTeamValid {

    /**
     * Default constructor.
     */
    public TestDbxTeamBuilderRestControllerValidateTeamValid() {
        super();
        // TODO: Check the test without a team in session
    }

    /**
     * Tests that when the data and the context is correct the assets can be
     * set.
     */
    @Test
    public final void testValidateTeam_ValidData_Accepted() throws Exception {
        final MockMvc mockMvc;

        mockMvc = getMockContext();

        mockMvc.perform(getRequest());
    }

    /**
     * Returns a mocked controller.
     * <p>
     * It can create mocked sponsor, sponsor team and units.
     * 
     * @return a mocked controller
     */
    private final DbxTeamBuilderController getController() {
        final DbxTeamBuilder builder;
        final Validator teamValidator;
        final DbxModelFactory factory;

        builder = Mockito.mock(DbxTeamBuilder.class);

        teamValidator = getValidator();

        factory = Mockito.mock(DbxModelFactory.class);

        return new DbxTeamBuilderController(builder, factory, teamValidator);
    }

    /**
     * Sets up the mocked MVC context.
     */
    private final MockMvc getMockContext() {
        return MockMvcBuilders.standaloneSetup(getController())
                .alwaysExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .alwaysExpect(MockMvcResultMatchers.status().isOk()).build();
    }

    /**
     * Returns a request builder for posting the specified assets.
     * <p>
     * The created request will contain the valid context.
     * 
     * @param assets
     *            assets for the request
     * @return a request builder with the specified assets
     */
    private final RequestBuilder getRequest() throws IOException {
        return MockMvcRequestBuilders.get(UrlDbxTeamBuilderConfig.URL_VALIDATE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
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

    private final Validator getValidator() {
        final Validator validator;

        validator = Mockito.mock(Validator.class);

        return validator;
    }

}
