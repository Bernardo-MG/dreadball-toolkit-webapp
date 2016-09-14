
package com.wandrell.tabletop.dreadball.web.toolkit.test.unit.controller.dbx;

import java.util.LinkedList;

import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.build.dbx.DbxSponsorBuilder;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.SponsorCreationController;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorForm;

public class TestSponsorCreationController {

    public TestSponsorCreationController() {
        super();
    }

    @Test
    public void testSendFormData() throws Exception {
        final MockMvc mockMvc;
        final SponsorCreationController controller;
        final DbxSponsorBuilder service;
        final Sponsor sponsor;
        final SponsorTeam team;
        final Iterable<Unit> units;

        service = Mockito.mock(DbxSponsorBuilder.class);

        sponsor = Mockito.mock(Sponsor.class);
        Mockito.when(service.getSponsor(Mockito.any(SponsorForm.class)))
                .thenReturn(sponsor);

        team = Mockito.mock(SponsorTeam.class);
        Mockito.when(service.getSponsorTeam(Mockito.any(Sponsor.class)))
                .thenReturn(team);

        units = new LinkedList<Unit>();
        Mockito.when(
                service.getSponsorAvailableUnits(Mockito.any(Sponsor.class)))
                .thenReturn(units);

        controller = new SponsorCreationController(service);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/builder/team/dbx")
                .param("sponsorName", "sponsor").param("affinityA", "aff")
                .param("affinityB", "aff").param("affinityC", "aff")
                .param("affinityD", "aff").param("affinityE", "aff"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(
                        MockMvcResultMatchers.view().name("build/dbx/players"))
                .andExpect(
                        MockMvcResultMatchers.model().attributeExists("team"))
                .andExpect(MockMvcResultMatchers.model()
                        .attributeExists("sponsor"))
                .andExpect(MockMvcResultMatchers.model()
                        .attributeExists("availablePlayers"));
    }

    @Test
    public void testShowForm() throws Exception {
        final MockMvc mockMvc;
        final SponsorCreationController controller;
        final DbxSponsorBuilder service;

        service = Mockito.mock(DbxSponsorBuilder.class);

        controller = new SponsorCreationController(service);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/builder/team/dbx"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(
                        MockMvcResultMatchers.view().name("build/dbx/sponsor"))
                .andExpect(
                        MockMvcResultMatchers.model().attributeExists("form"));
    }

}
