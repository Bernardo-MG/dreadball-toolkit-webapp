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

package com.bernardomg.tabletop.dreadball.web.toolkit.test.unit.builder.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.build.service.DefaultSponsorBuilderService;
import com.bernardomg.tabletop.dreadball.build.service.SponsorBuilderService;
import com.bernardomg.tabletop.dreadball.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.model.service.SponsorAffinityGroupAvailabilityService;
import com.bernardomg.tabletop.dreadball.model.service.SponsorBuilderAssemblerService;
import com.bernardomg.tabletop.dreadball.model.service.SponsorUnitsService;
import com.bernardomg.tabletop.dreadball.rules.SponsorDefaults;
import com.google.common.collect.Iterables;

/**
 * Unit tests for {@link DefaultSponsorBuilderService}, verifying the affinity
 * validation method.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestDefaultSponsorBuilderServiceValidateAffs {

    /**
     * Default constructor.
     */
    public TestDefaultSponsorBuilderServiceValidateAffs() {
        super();
    }

    /**
     * Verifies that an affinity is returned for each valid affinity.
     */
    @Test
    public final void
            testValidateSponsorAffinities_Affinities_ExpectedAffinitiesResult() {
        final SponsorBuilderService service; // Tested service
        final Collection<String> affinities;
        final SponsorAffinities result;

        service = getSponsorBuilderService();

        affinities = new ArrayList<>();
        affinities.add("affinity_1");
        affinities.add("affinity_2");

        result = service.validateSponsorAffinities(affinities);

        Assert.assertEquals(2, Iterables.size(result.getAffinities()));
    }

    /**
     * Verifies that if there is no rank increase among the received affinities,
     * then no rank is returned.
     */
    @Test
    public final void
            testValidateSponsorAffinities_Affinities_NoRankIncrease_NoReturnedRank() {
        final SponsorBuilderService service; // Tested service
        final Collection<String> affinities;
        final SponsorAffinities result;

        service = getSponsorBuilderService();

        affinities = new ArrayList<>();
        affinities.add("affinity_1");
        affinities.add("affinity_2");

        result = service.validateSponsorAffinities(affinities);

        Assert.assertEquals(0, result.getRank().intValue());
    }

    /**
     * Verifies that if there is a rank increase among the received affinities,
     * then only the affinities are returned.
     */
    @Test
    public final void
            testValidateSponsorAffinities_Affinities_RankIncrease_ExpectedAffinitiesResult() {
        final SponsorBuilderService service; // Tested service
        final Collection<String> affinities;
        final SponsorAffinities result;

        service = getSponsorBuilderService();

        affinities = new ArrayList<>();
        affinities.add("affinity_1");
        affinities.add("affinity_2");
        affinities.add("rank_increase");

        result = service.validateSponsorAffinities(affinities);

        Assert.assertEquals(2, Iterables.size(result.getAffinities()));
    }

    /**
     * Verifies that if no affinities are received then no affinities are
     * returned.
     */
    @Test
    public final void
            testValidateSponsorAffinities_NoAffinities_NoAffinitiesResult() {
        final SponsorBuilderService service; // Tested service
        final Collection<String> affinities;
        final SponsorAffinities result;

        service = getSponsorBuilderService();

        affinities = new ArrayList<>();

        result = service.validateSponsorAffinities(affinities);

        Assert.assertEquals(0, Iterables.size(result.getAffinities()));
    }

    /**
     * Verifies that if no affinities are received then no rank is returned.
     */
    @Test
    public final void
            testValidateSponsorAffinities_NoAffinities_NoReturnedRank() {
        final SponsorBuilderService service; // Tested service
        final Collection<String> affinities;
        final SponsorAffinities result;

        service = getSponsorBuilderService();

        affinities = new ArrayList<>();

        result = service.validateSponsorAffinities(affinities);

        Assert.assertEquals(new Integer(0), result.getRank());
    }

    /**
     * Verifies that if only a rank increase option is received then no
     * affinities are returned.
     */
    @Test
    public final void
            testValidateSponsorAffinities_RankIncrease_NoAffinities() {
        final SponsorBuilderService service; // Tested service
        final Collection<String> affinities;
        final SponsorAffinities result;

        service = getSponsorBuilderService();

        affinities = new ArrayList<>();
        affinities.add("rank_increase");

        result = service.validateSponsorAffinities(affinities);

        Assert.assertEquals(0, Iterables.size(result.getAffinities()));
    }

    /**
     * Verifies that if only a rank increase option is received then a rank
     * value is returned.
     */
    @Test
    public final void testValidateSponsorAffinities_RankIncrease_Rank() {
        final SponsorBuilderService service; // Tested service
        final Collection<String> affinities;
        final SponsorAffinities result;

        service = getSponsorBuilderService();

        affinities = new ArrayList<>();
        affinities.add("rank_increase");

        result = service.validateSponsorAffinities(affinities);

        Assert.assertEquals(1, result.getRank().intValue());
    }

    /**
     * Verifies that if there repeated affinities are received then no repeated
     * affinities are returned.
     */
    @Test
    public final void
            testValidateSponsorAffinities_RepeatedAffinities_NoRepeatedAffinitiesResult() {
        final SponsorBuilderService service; // Tested service
        final Collection<String> affinities;
        final SponsorAffinities result;

        service = getSponsorBuilderService();

        affinities = new ArrayList<>();
        affinities.add("affinity_1");
        affinities.add("affinity_2");
        affinities.add("affinity_1");

        result = service.validateSponsorAffinities(affinities);

        Assert.assertEquals(2, Iterables.size(result.getAffinities()));
    }

    /**
     * Returns a service.
     * <p>
     * All the dependencies are mocked.
     * 
     * @return service to test
     */
    private final SponsorBuilderService getSponsorBuilderService() {
        final SponsorBuilderAssemblerService sponsorBuilderAssemblerService;
        final SponsorUnitsService sponsorUnitsService;
        final SponsorDefaults defaults;
        final SponsorAffinityGroupAvailabilityService sponsorAffinityGroupAvailabilityService;

        sponsorBuilderAssemblerService = Mockito
                .mock(SponsorBuilderAssemblerService.class);
        sponsorUnitsService = Mockito.mock(SponsorUnitsService.class);
        defaults = Mockito.mock(SponsorDefaults.class);

        sponsorAffinityGroupAvailabilityService = Mockito
                .mock(SponsorAffinityGroupAvailabilityService.class);
        Mockito.when(sponsorAffinityGroupAvailabilityService
                .getAllSponsorAffinityGroupAvailabilities())
                .thenReturn(Collections.emptyList());

        return new DefaultSponsorBuilderService(sponsorBuilderAssemblerService,
                sponsorUnitsService, sponsorAffinityGroupAvailabilityService,
                defaults);
    }

}
