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

package com.wandrell.tabletop.dreadball.web.toolkit.test.integration.builder.dbx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.build.dbx.DbxTeamBuilder;
import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.unit.Unit;

/**
 * Integration tests for {@link DbxTeamBuilder}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Adding an existing unit works as expected</li>
 * <li>Adding a not existing unit does nothing</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@ContextConfiguration(locations = { "classpath:context/builder-dbx.xml",
        "classpath:context/persistence.xml" })
@TestPropertySource({ "classpath:config/persistence-access.properties",
        "classpath:config/persistence-h2.properties",
        "classpath:config/persistence-access.properties",
        "classpath:config/service-dreadball.properties",
        "classpath:config/builder-team-dbx.properties" })
public class ITDbxTeamBuilder
        extends AbstractTransactionalTestNGSpringContextTests {

    /**
     * Builder to test.
     */
    @Autowired
    private DbxTeamBuilder builder;

    /**
     * Default constructor.
     */
    public ITDbxTeamBuilder() {
        super();
    }

    /**
     * Tests that adding an existing unit works as expected.
     */
    @Test
    public final void testGetSponsorAvailableUnits_GetUnit_Existing_Created() {
        final Sponsor sponsor; // Sponsor for the team
        final Unit unit;       // Created unit

        sponsor = new DefaultSponsor();

        unit = builder.getUnit(sponsor, "ada-lorana_guard_affinity");

        Assert.assertEquals(unit.getTemplateName(),
                "ada-lorana_guard_affinity");
    }

    /**
     * Tests that adding a not existing unit does nothing.
     */
    @Test
    public final void testGetSponsorAvailableUnits_GetUnit_NotExisting_Null() {
        final Sponsor sponsor; // Sponsor for the team
        final Unit unit;       // Created unit

        sponsor = new DefaultSponsor();

        unit = builder.getUnit(sponsor, "-");

        Assert.assertNull(unit);
    }

}
