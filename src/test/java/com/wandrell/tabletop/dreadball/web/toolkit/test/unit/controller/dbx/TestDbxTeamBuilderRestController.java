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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wandrell.tabletop.dreadball.build.dbx.DbxTeamBuilder;
import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.calculator.RankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.DbxTeamBuilderRestController;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorTeamAssets;

/**
 * Unit tests for {@link DbxTeamBuilderRestController}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li></li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestDbxTeamBuilderRestController {

    /**
     * The name of the team bean.
     */
    private static final String TEAM_BEAN  = "team";

    /**
     * Form view URL.
     */
    private static final String URL_ASSETS = "/builder/team/dbx/assets";

    /**
     * Mocked MVC context.
     */
    private MockMvc             mockMvc;

    /**
     * Default constructor.
     */
    public TestDbxTeamBuilderRestController() {
        super();
    }

    /**
     * Sets up the mocked MVC context.
     */
    @BeforeTest
    public final void setUpMockContext() {
        mockMvc = MockMvcBuilders.standaloneSetup(getController()).build();
    }

    @Test
    public final void testSetAssets() throws Exception {
        final SponsorTeamAssets assets;

        assets = new SponsorTeamAssets();

        assets.setCoachingDice(1);

        mockMvc.perform(getRequest(assets)).andExpect(MockMvcResultMatchers
                .content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    /**
     * Returns a mocked controller.
     * <p>
     * It can create mocked sponsor, sponsor team and units.
     * 
     * @return a mocked controller
     */
    private final DbxTeamBuilderRestController getController() {
        final DbxTeamBuilder builder;

        builder = Mockito.mock(DbxTeamBuilder.class);

        return new DbxTeamBuilderRestController(builder);
    }

    /**
     * Returns a request builder for posting the specified assets.
     * 
     * @param assets
     *            assets for the request
     * @return a request builder with the specified assets
     */
    private final RequestBuilder getRequest(final SponsorTeamAssets assets)
            throws IOException {
        final byte[] content;

        content = new ObjectMapper().writeValueAsBytes(assets);

        return MockMvcRequestBuilders.put(URL_ASSETS)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .sessionAttrs(getSessionAttributes()).content(content);
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
        // sessionAttrs.put("team", Mockito.mock(SponsorTeam.class));
        // TODO: Mock this better
        sessionAttrs.put(TEAM_BEAN,
                new DefaultSponsorTeam(new DefaultSponsor(),
                        Mockito.mock(TeamValorationCalculator.class),
                        Mockito.mock(RankCostCalculator.class)));

        return sessionAttrs;
    }

}
