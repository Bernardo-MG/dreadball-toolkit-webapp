
package com.wandrell.tabletop.dreadball.web.toolkit.test.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.DbxTeamBuilderRestController;

@ContextConfiguration(locations = { "classpath:context/servlet-dreadball.xml",
        "classpath:context/persistence.xml" })
@TestPropertySource({ "classpath:config/servlet-dreadball.properties",
        "classpath:config/persistence-access.properties",
        "classpath:config/persistence-h2.properties",
        "classpath:config/persistence-access.properties",
        "classpath:config/service-dreadball.properties",
        "classpath:config/builder-team-dbx.properties" })
@WebAppConfiguration
public class ITDbxTeamBuilderRestController
        extends AbstractTestNGSpringContextTests {

    @Autowired
    private DbxTeamBuilderRestController controller;

    private MockMvc                      mockMvc;

    public ITDbxTeamBuilderRestController() {
        super();
    }

    @BeforeTest
    public void setup() {}

    @Test
    public void testSetAssets() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // TODO: Make this work
        // mockMvc.perform(MockMvcRequestBuilders.put("/builder/team/dbx/assets")
        // .contentType(MediaType.APPLICATION_JSON)
        // .content("{dice:1}".getBytes("UTF-8")))
        // .andExpect(MockMvcResultMatchers.content()
        // .contentType(MediaType.APPLICATION_JSON));
    }

}
