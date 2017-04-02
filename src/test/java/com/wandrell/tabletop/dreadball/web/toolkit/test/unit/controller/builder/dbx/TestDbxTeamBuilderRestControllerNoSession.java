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

import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wandrell.tabletop.dreadball.build.dbx.DbxTeamBuilder;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.DbxTeamBuilderController;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorTeamAssets;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.TeamPlayer;
import com.wandrell.tabletop.dreadball.web.toolkit.codex.service.UnitService;
import com.wandrell.tabletop.dreadball.web.toolkit.test.configuration.UrlDbxTeamBuilderConfig;

/**
 * Unit tests for {@link DbxTeamBuilderController}, checking that operations are
 * rejected when there is no team in session.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestDbxTeamBuilderRestControllerNoSession {

    /**
     * Mocked MVC context.
     */
    private MockMvc mockMvc;

    /**
     * Default constructor.
     */
    public TestDbxTeamBuilderRestControllerNoSession() {
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
     * Tests that when the data and the context is correct the assets can be
     * set.
     */
    @Test
    public final void testAddPlayer_Rejected() throws Exception {
        mockMvc.perform(getAddPlayerRequest());
    }

    /**
     * Tests that when there is no team in session players can't be removed.
     */
    @Test
    public final void testRemovePlayer_Rejected() throws Exception {
        mockMvc.perform(getDeletePlayersRequest());
    }

    /**
     * Tests that when the data and the context is correct the assets can be
     * set.
     */
    @Test
    public final void testSetAssets_Rejected() throws Exception {
        mockMvc.perform(getPutAssetsRequest());
    }

    /**
     * Returns a request builder for posting the specified assets with an
     * invalid context.
     * <p>
     * The created request will be missing session data.
     * 
     * @return a request builder with the specified player data
     */
    private final RequestBuilder getAddPlayerRequest() throws IOException {
        final byte[] content;
        final TeamPlayer player; // Assets for the team

        player = new TeamPlayer();

        player.setTemplateName("template");

        content = new ObjectMapper().writeValueAsBytes(player);

        return MockMvcRequestBuilders.post(UrlDbxTeamBuilderConfig.URL_PLAYERS)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(content);
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
        final UnitService unitModelService;
        final Validator teamValidator;

        builder = Mockito.mock(DbxTeamBuilder.class);

        teamValidator = Mockito.mock(Validator.class);

        unitModelService = Mockito.mock(UnitService.class);

        return new DbxTeamBuilderController(builder, unitModelService,
                teamValidator);
    }

    /**
     * Returns a request builder for deleting a player.
     * 
     * @param player
     *            player data for the request
     * @return a request builder with the specified player data
     */
    private final RequestBuilder getDeletePlayersRequest() throws IOException {
        final byte[] content;
        final TeamPlayer player; // Assets for the team

        player = new TeamPlayer();

        player.setPosition(1);

        content = new ObjectMapper().writeValueAsBytes(player);

        return MockMvcRequestBuilders
                .delete(UrlDbxTeamBuilderConfig.URL_PLAYERS)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(content);
    }

    /**
     * Returns a request builder for putting assets.
     * 
     * @param assets
     *            assets for the request
     * @return a request builder with the specified assets
     */
    private final RequestBuilder getPutAssetsRequest() throws IOException {
        final byte[] content;
        final SponsorTeamAssets assets; // Assets for the team

        assets = new SponsorTeamAssets();

        assets.setCheerleaders(1);
        assets.setCoachingDice(2);
        assets.setMediBots(3);
        assets.setSabotageCards(4);
        assets.setSpecialMoveCards(5);
        assets.setWagers(6);

        content = new ObjectMapper().writeValueAsBytes(assets);

        return MockMvcRequestBuilders.put(UrlDbxTeamBuilderConfig.URL_ASSETS)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(content);
    }

}
