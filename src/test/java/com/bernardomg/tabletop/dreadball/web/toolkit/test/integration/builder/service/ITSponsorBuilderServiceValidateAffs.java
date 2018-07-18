/**
 * Copyright 2018 the original author or authors
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

package com.bernardomg.tabletop.dreadball.web.toolkit.test.integration.builder.service;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.bernardomg.tabletop.dreadball.build.service.SponsorBuilderService;
import com.bernardomg.tabletop.dreadball.model.SponsorAffinities;
import com.google.common.collect.Iterables;

/**
 * Integration tests for {@link SponsorBuilderService}, verifying affinity
 * options validation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(
        locations = { "classpath:context/test-service-context.xml" })
public class ITSponsorBuilderServiceValidateAffs
        extends AbstractJUnit4SpringContextTests {

    /**
     * Tested service.
     */
    @Autowired
    private SponsorBuilderService service;

    /**
     * Default constructor.
     */
    public ITSponsorBuilderServiceValidateAffs() {
        super();
    }

    /**
     * Verifies that the affinities are validated correctly.
     */
    @Test
    public final void testValidateAffinities_ExpectedResult() {
        final Collection<String> affinities;
        final SponsorAffinities result;

        affinities = new ArrayList<>();
        affinities.add("affinity_1");
        affinities.add("affinity_2");
        affinities.add("affinity_3");
        affinities.add("affinity_4");
        affinities.add("rank_increase");
        result = service.validateSponsorAffinities(affinities);

        Assertions.assertEquals(6, result.getRank().intValue());
        Assertions.assertEquals(4, Iterables.size(result.getAffinities()));
    }

}
