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

package com.bernardomg.tabletop.dreadball.web.toolkit.test.integration.builder.service;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.bernardomg.tabletop.dreadball.build.service.SponsorBuilderService;
import com.bernardomg.tabletop.dreadball.model.SponsorAffinities;
import com.google.common.collect.Iterables;

/**
 * Integration tests for {@link SponsorBuilderService}, verifying affinity
 * options validation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@ContextConfiguration(
        locations = { "classpath:context/test-service-context.xml" })
public class ITSponsorBuilderServiceValidateAffs
        extends AbstractJUnit4SpringContextTests {

    @Autowired
    private SponsorBuilderService service;

    public ITSponsorBuilderServiceValidateAffs() {
        super();
    }

    @Test
    public final void
            testValidateAffinities_AffinitiesAndRank_AddsAdditionalOption() {
        final Collection<String> affinities;
        final SponsorAffinities result;

        affinities = new ArrayList<>();
        affinities.add("affinity_1");
        affinities.add("affinity_2");
        affinities.add("affinity_3");
        affinities.add("affinity_4");
        affinities.add("rank_increase");
        result = service.validateSponsorAffinities(affinities);

        Assert.assertEquals(6, result.getRank().intValue());
        Assert.assertEquals(4, Iterables.size(result.getAffinities()));
    }

    /**
     * Verifies that when no affinities are received the default rank is
     * returned.
     */
    @Test
    public final void testValidateAffinities_NoAffinities_DefaultRank() {
        final Collection<String> affinities;
        final SponsorAffinities result;

        affinities = new ArrayList<>();
        result = service.validateSponsorAffinities(affinities);

        Assert.assertEquals(5, result.getRank().intValue());
    }

    @Test
    public final void testValidateAffinities_NoAffinities_EmptyResult() {
        final Collection<String> affinities;
        final SponsorAffinities result;

        affinities = new ArrayList<>();
        result = service.validateSponsorAffinities(affinities);

        Assert.assertEquals(0, Iterables.size(result.getAffinities()));
    }

}
