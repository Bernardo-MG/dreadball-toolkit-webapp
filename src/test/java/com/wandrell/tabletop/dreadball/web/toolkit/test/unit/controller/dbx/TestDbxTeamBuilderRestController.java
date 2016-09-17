
package com.wandrell.tabletop.dreadball.web.toolkit.test.unit.controller.dbx;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wandrell.tabletop.dreadball.build.dbx.DbxTeamBuilder;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.calculator.RankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.DbxTeamBuilderRestController;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorTeamAssets;

public class TestDbxTeamBuilderRestController {

    private static byte[] convertObjectToJsonBytes(Object object)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsBytes(object);
    }

    public TestDbxTeamBuilderRestController() {
        super();
    }

    @BeforeTest
    public void setup() {}

    @Test
    public void testSetAssets() throws Exception {
        final MockMvc mockMvc;
        final DbxTeamBuilderRestController controller;
        final DbxTeamBuilder builder;
        final SponsorTeamAssets assets;
        final Map<String, Object> sessionAttrs;

        builder = Mockito.mock(DbxTeamBuilder.class);

        controller = new DbxTeamBuilderRestController(builder);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        assets = new SponsorTeamAssets();

        assets.setCoachingDice(1);

        sessionAttrs = new LinkedHashMap<>();
        // sessionAttrs.put("team", Mockito.mock(SponsorTeam.class));
        // TODO: Mock this better
        sessionAttrs.put("team",
                new DefaultSponsorTeam(Mockito.mock(Sponsor.class),
                        Mockito.mock(TeamValorationCalculator.class),
                        Mockito.mock(RankCostCalculator.class)));

        mockMvc.perform(MockMvcRequestBuilders.put("/builder/team/dbx/assets")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .sessionAttrs(sessionAttrs)
                .content(convertObjectToJsonBytes(assets)))
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8));
    }

}
