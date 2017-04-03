
package com.wandrell.tabletop.dreadball.web.toolkit.test.integration.controller;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.calculator.RankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorForm;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorTeamAssets;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.TeamPlayer;
import com.wandrell.tabletop.dreadball.web.toolkit.test.configuration.BeanConfig;
import com.wandrell.tabletop.dreadball.web.toolkit.test.configuration.UrlDbxTeamBuilderConfig;
import com.wandrell.tabletop.dreadball.web.toolkit.test.configuration.UrlReportConfig;

@ContextConfiguration(locations = { "classpath:context/application-context.xml",
        "classpath:context/servlet-dreadball.xml" })
@TestPropertySource({ "classpath:config/builder-team-dbx.properties",
        "classpath:config/service-dreadball.properties",
        "classpath:config/servlet-dreadball.properties",
        "classpath:config/view.properties" })
@WebAppConfiguration
@Deprecated
public abstract class ITDbxTeamCreationController
        extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext                 context;

    @Autowired
    private RankCostCalculator                    rankCalc;

    @Autowired
    private MockHttpSession                       session;

    @Autowired
    private TeamValorationCalculator<SponsorTeam> valCalc;

    public ITDbxTeamCreationController() {
        super();
    }

    @Test
    public final void test_fullFlow() throws Exception {
        final MockMvc mockMvc;

        mockMvc = getMockMvc();

        setSponsor(mockMvc);

        addPlayer(mockMvc);

        setAssets(mockMvc);

        // TODO: Enable when the session is correctly kept
        // validateTeam(mockMvc);

        getReport(mockMvc);
    }

    private final void addPlayer(final MockMvc mockMvc) throws Exception {
        final ResultActions result;     // Request result

        result = mockMvc.perform(getAddPlayerRequest());

        // There are no more entries
        result.andExpect(MockMvcResultMatchers.jsonPath("$.players",
                Matchers.aMapWithSize(1)));

        // The assets were set correctly
        result.andExpect(MockMvcResultMatchers.jsonPath("$.players.1",
                Matchers.anything()));

        // TODO: Should be
        // result.andExpect(MockMvcResultMatchers.jsonPath("$.players",
        // Matchers.hasKey(1)));

    }

    private final RequestBuilder getAddPlayerRequest() throws IOException {
        final byte[] content;
        final TeamPlayer player; // Assets for the team

        player = new TeamPlayer();

        player.setTemplateName("unit_1_affinity");

        content = new ObjectMapper().writeValueAsBytes(player);

        // TODO: The session should be set with the first request
        return MockMvcRequestBuilders.post(UrlDbxTeamBuilderConfig.URL_PLAYERS)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(content)
                .session(session).sessionAttr(BeanConfig.TEAM_BEAN,
                        new DefaultSponsorTeam(new DefaultSponsor(), valCalc,
                                rankCalc));
    }

    private final MockMvc getMockMvc() {
        // TODO: Make it expect JSON once all the controllers are REST
        return MockMvcBuilders.webAppContextSetup(context)
                .alwaysExpect(MockMvcResultMatchers.status().isOk()).build();
    }

    private final void getReport(final MockMvc mockMvc) throws Exception {
        final ResultActions result; // Request result

        result = mockMvc.perform(getReportRequest());

        // The operation was accepted
        result.andExpect(MockMvcResultMatchers.status().isOk());

        // The response indicates it is a PDF
        result.andExpect(MockMvcResultMatchers.content()
                .contentType(MediaType.APPLICATION_PDF));
    }

    private final RequestBuilder getReportRequest() {
        // TODO: The session should be set with the first request
        return MockMvcRequestBuilders.get(UrlReportConfig.URL_PDF)
                .session(session).sessionAttr(BeanConfig.TEAM_BEAN,
                        new DefaultSponsorTeam(new DefaultSponsor(), valCalc,
                                rankCalc));
    }

    private final RequestBuilder getSetAssetsRequest(
            final SponsorTeamAssets assets) throws IOException {
        final byte[] content;

        content = new ObjectMapper().writeValueAsBytes(assets);

        // TODO: The session should be set with the first request
        return MockMvcRequestBuilders.put(UrlDbxTeamBuilderConfig.URL_ASSETS)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(content)
                .session(session).sessionAttr(BeanConfig.TEAM_BEAN,
                        new DefaultSponsorTeam(new DefaultSponsor(), valCalc,
                                rankCalc));
    }

    private final RequestBuilder getSetSponsorRequest() throws IOException {
        final SponsorForm sponsor;
        final byte[] content;

        sponsor = new SponsorForm();
        sponsor.setSponsorName("sponsor");
        sponsor.setAffinityA("affinity_1");
        sponsor.setAffinityB("affinity_2");
        sponsor.setAffinityC("affinity_3");
        sponsor.setAffinityD("affinity_4");
        sponsor.setAffinityE("affinity_5");

        content = new ObjectMapper().writeValueAsBytes(sponsor);

        return MockMvcRequestBuilders.post(UrlDbxTeamBuilderConfig.URL_SPONSOR)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(content);
    }

    private final RequestBuilder getValidateTeamRequest() throws IOException {
        // TODO: The session should be set with the first request
        return MockMvcRequestBuilders.get(UrlDbxTeamBuilderConfig.URL_VALIDATE)
                .contentType(MediaType.APPLICATION_JSON_VALUE).session(session)
                .sessionAttr(BeanConfig.TEAM_BEAN, new DefaultSponsorTeam(
                        new DefaultSponsor(), valCalc, rankCalc));
    }

    private final void setAssets(final MockMvc mockMvc) throws Exception {
        final ResultActions result;     // Request result
        final SponsorTeamAssets assets; // Assets for the team

        assets = new SponsorTeamAssets();

        assets.setCheerleaders(1);
        assets.setCoachingDice(2);
        assets.setMediBots(3);
        assets.setSabotageCards(4);
        assets.setSpecialMoveCards(5);
        assets.setWagers(6);

        result = mockMvc.perform(getSetAssetsRequest(assets));

        // The assets were set correctly
        result.andExpect(MockMvcResultMatchers.jsonPath("$.cheerleaders",
                Matchers.is(assets.getCheerleaders())));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.coachingDice",
                Matchers.is(assets.getCoachingDice())));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.mediBots",
                Matchers.is(assets.getMediBots())));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.sabotageCards",
                Matchers.is(assets.getSabotageCards())));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.specialMoveCards",
                Matchers.is(assets.getSpecialMoveCards())));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.wagers",
                Matchers.is(assets.getWagers())));
    }

    private final void setSponsor(final MockMvc mockMvc) throws Exception {
        final ResultActions result; // Request result

        result = mockMvc.perform(getSetSponsorRequest());

        // The response model contains the expected attributes
        result.andExpect(MockMvcResultMatchers.jsonPath("$.sponsor",
                org.hamcrest.Matchers.notNullValue()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.sponsor.name",
                org.hamcrest.Matchers.is("sponsor")));
        result.andExpect(MockMvcResultMatchers.jsonPath(
                "$.sponsor.affinityGroups", org.hamcrest.Matchers.hasSize(5)));
    }

    private final void validateTeam(final MockMvc mockMvc) throws Exception {
        mockMvc.perform(getValidateTeamRequest());
    }

}
