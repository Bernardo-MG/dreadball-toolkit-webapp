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

package com.wandrell.tabletop.dreadball.web.toolkit.test.integration.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.factory.DbxModelFactory;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorForm;

/**
 * Integration tests for {@link DbxModelFactory}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@ContextConfiguration(locations = { "classpath:context/builder-dbx.xml",
        "classpath:context/test-db-context.xml" })
@TestPropertySource({ "classpath:config/service-dreadball.properties",
        "classpath:config/builder-team-dbx.properties" })
@ComponentScan({ "com.wandrell.tabletop.dreadball.web.toolkit.builder.service",
        "com.wandrell.tabletop.dreadball.web.toolkit.builder.factory" })
public final class ITDbxModelFactory
        extends AbstractTransactionalTestNGSpringContextTests {

    /**
     * Factory to test.
     */
    @Autowired
    private DbxModelFactory factory;

    /**
     * Default constructor.
     */
    public ITDbxModelFactory() {
        super();
    }

    /**
     * Tests that a Sponsor can be created from the Sponsor form.
     */
    @Test
    public final void testGetSponsor() {
        final SponsorForm form;  // Sponsor form to transform
        final Sponsor sponsor;   // Sponsor from the form

        form = new SponsorForm();

        form.setSponsorName("name");

        form.setAffinityA("affinity_1");
        form.setAffinityB("affinity_2");
        form.setAffinityC("affinity_3");
        form.setAffinityD("affinity_4");
        form.setAffinityE("affinity_5");

        sponsor = factory.getSponsor(form);

        Assert.assertEquals(form.getSponsorName(), "name");
        Assert.assertEquals(sponsor.getAffinityGroups().size(), 5);
    }

}
