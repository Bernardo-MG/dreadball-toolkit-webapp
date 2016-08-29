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

import com.wandrell.tabletop.dreadball.build.dbx.DbxSponsorBuilder;
import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityGroupRepository;

/**
 * Integration tests for {@link DbxSponsorBuilder}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Acquiring the available units returns the expected values</li>
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
public class ITDbxSponsorBuilder
        extends AbstractTransactionalTestNGSpringContextTests {

    /**
     * Affinity groups repository.
     */
    @Autowired
    private AffinityGroupRepository affinitiesRepository;

    /**
     * Builder to test.
     */
    @Autowired
    private DbxSponsorBuilder       builder;

    /**
     * Default constructor.
     */
    public ITDbxSponsorBuilder() {
        super();
    }

    /**
     * Tests that acquiring the available units returns the expected values.
     */
    @Test
    public final void testGetSponsorAvailableUnits() {
        final Iterable<? extends Unit> units; // Sponsor units
        final Sponsor sponsor;                // Sponsor to get the units for

        sponsor = new DefaultSponsor();
        sponsor.addAffinityGroup(affinitiesRepository.findByName("alien"));
        sponsor.addAffinityGroup(affinitiesRepository.findByName("dreadball"));
        sponsor.addAffinityGroup(affinitiesRepository.findByName("insectoid"));
        sponsor.addAffinityGroup(affinitiesRepository.findByName("psycho"));
        sponsor.addAffinityGroup(affinitiesRepository.findByName("vicious"));

        units = builder.getSponsorAvailableUnits(sponsor);

        // TODO: Verify it returns the expected costs
        Assert.assertNotNull(units);
    }

}
