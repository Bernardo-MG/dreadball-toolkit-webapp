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

/**
 * Unit tests for {@link SponsorCreationController}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li></li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
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
        Mockito.when(service.getSponsor(Matchers.any(SponsorForm.class)))
                .thenReturn(sponsor);

        team = Mockito.mock(SponsorTeam.class);
        Mockito.when(service.getSponsorTeam(Matchers.any(Sponsor.class)))
                .thenReturn(team);

        units = new LinkedList<Unit>();
        Mockito.when(
                service.getSponsorAvailableUnits(Matchers.any(Sponsor.class)))
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
