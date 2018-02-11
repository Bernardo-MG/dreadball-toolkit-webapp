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
import com.bernardomg.tabletop.dreadball.model.Option;
import com.bernardomg.tabletop.dreadball.model.OptionGroup;
import com.bernardomg.tabletop.dreadball.model.availability.unit.DefaultSponsorAffinityGroupAvailability;
import com.bernardomg.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.bernardomg.tabletop.dreadball.model.service.SponsorAffinityGroupAvailabilityService;
import com.bernardomg.tabletop.dreadball.model.service.SponsorBuilderAssemblerService;
import com.bernardomg.tabletop.dreadball.model.service.SponsorUnitsService;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.unit.DefaultAffinityGroup;
import com.bernardomg.tabletop.dreadball.rules.SponsorDefaults;
import com.google.common.collect.Iterables;

/**
 * Unit tests for {@link DefaultSponsorBuilderService}, verifying the affinity
 * options read method.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public class TestDefaultSponsorBuilderServiceAffOptions {

    /**
     * Default constructor.
     */
    public TestDefaultSponsorBuilderServiceAffOptions() {
        super();
    }

    /**
     * Verifies that an option is created for each affinity.
     */
    @Test
    public final void testGetAffinityOptions_Affinities_OptionForEach() {
        final SponsorBuilderService service; // Tested service
        final Iterable<OptionGroup> options; // Returned data

        service = getAffinitiesSponsorBuilderService();

        options = service.getAffinityOptions();

        Assert.assertEquals(4,
                Iterables.size(options.iterator().next().getOptions()));
    }

    /**
     * Verifies that when there is a rank option then an additional option is
     * returned.
     */
    @Test
    public final void
            testGetAffinityOptions_AffinitiesAndRank_AddsAdditionalOption() {
        final SponsorBuilderService service; // Tested service
        final Iterable<OptionGroup> options; // Returned data

        service = getAffinitiesAndRankSponsorBuilderService();

        options = service.getAffinityOptions();

        Assert.assertEquals(5,
                Iterables.size(options.iterator().next().getOptions()));
    }

    /**
     * Verifies that when there is an affinity group then an option group is
     * returned.
     */
    @Test
    public final void testGetAffinityOptions_AffinityGroup_ReturnsGroup() {
        final SponsorBuilderService service;   // Tested service
        final Collection<OptionGroup> options; // Returned data

        service = getAffinitiesAndRankSponsorBuilderService();

        options = service.getAffinityOptions();

        Assert.assertEquals(1, options.size());
    }

    /**
     * Verifies that the option group contains the affinity group name.
     */
    @Test
    public final void testGetAffinityOptions_Name() {
        final SponsorBuilderService service;   // Tested service
        final Collection<OptionGroup> options; // Returned data

        service = getAffinitiesAndRankSponsorBuilderService();

        options = service.getAffinityOptions();

        Assert.assertEquals("A", options.iterator().next().getName());
    }

    /**
     * Verifies that when there are no affinities the result is empty.
     */
    @Test
    public final void testGetAffinityOptions_NoAffinities_Empty() {
        final SponsorBuilderService service;   // Tested service
        final Collection<OptionGroup> options; // Returned data

        service = getNoAffinitiesSponsorBuilderService();

        options = service.getAffinityOptions();

        Assert.assertEquals(0, options.size());
    }

    /**
     * Verifies that when the group does not include a rank none is returned as
     * an option.
     */
    @Test
    public final void testGetAffinityOptions_NoRank_ContainsNoRank() {
        final SponsorBuilderService service;   // Tested service
        final Collection<OptionGroup> options; // Returned data
        final Boolean found;

        service = getAffinitiesSponsorBuilderService();

        options = service.getAffinityOptions();

        found = options.stream().flatMap((o) -> o.getOptions().stream())
                .map(Option::getValue)
                .anyMatch((v) -> v.equals("rank_increase"));
        Assert.assertFalse(found);
    }

    /**
     * Verifies that when the group includes rank it is returned as an option.
     */
    @Test
    public final void testGetAffinityOptions_Rank_ContainsRank() {
        final SponsorBuilderService service;   // Tested service
        final Collection<OptionGroup> options; // Returned data
        final Boolean found;

        service = getAffinitiesAndRankSponsorBuilderService();

        options = service.getAffinityOptions();

        found = options.stream().flatMap((o) -> o.getOptions().stream())
                .map(Option::getValue)
                .anyMatch((v) -> v.equals("rank_increase"));
        Assert.assertTrue(found);
    }

    /**
     * Returns a service with affinities and rank option.
     * <p>
     * All the dependencies are mocked.
     * 
     * @return service with affinities
     */
    private final SponsorBuilderService
            getAffinitiesAndRankSponsorBuilderService() {
        final SponsorBuilderAssemblerService sponsorBuilderAssemblerService;
        final SponsorUnitsService sponsorUnitsService;
        final SponsorDefaults defaults;
        final SponsorAffinityGroupAvailabilityService sponsorAffinityGroupAvailabilityService;
        final Collection<SponsorAffinityGroupAvailability> avas;
        final Collection<AffinityGroup> affinities;

        sponsorBuilderAssemblerService = Mockito
                .mock(SponsorBuilderAssemblerService.class);
        sponsorUnitsService = Mockito.mock(SponsorUnitsService.class);
        defaults = Mockito.mock(SponsorDefaults.class);

        sponsorAffinityGroupAvailabilityService = Mockito
                .mock(SponsorAffinityGroupAvailabilityService.class);

        affinities = new ArrayList<>();
        affinities.add(new DefaultAffinityGroup("aff1"));
        affinities.add(new DefaultAffinityGroup("aff2"));
        affinities.add(new DefaultAffinityGroup("aff3"));
        affinities.add(new DefaultAffinityGroup("aff4"));

        avas = new ArrayList<>();
        avas.add(new DefaultSponsorAffinityGroupAvailability("A", affinities,
                true));

        Mockito.when(sponsorAffinityGroupAvailabilityService
                .getAllSponsorAffinityGroupAvailabilities()).thenReturn(avas);

        return new DefaultSponsorBuilderService(sponsorBuilderAssemblerService,
                sponsorUnitsService, sponsorAffinityGroupAvailabilityService,
                defaults);
    }

    /**
     * Returns a service with affinities, but no rank option.
     * <p>
     * All the dependencies are mocked.
     * 
     * @return service with affinities
     */
    private final SponsorBuilderService getAffinitiesSponsorBuilderService() {
        final SponsorBuilderAssemblerService sponsorBuilderAssemblerService;
        final SponsorUnitsService sponsorUnitsService;
        final SponsorDefaults defaults;
        final SponsorAffinityGroupAvailabilityService sponsorAffinityGroupAvailabilityService;
        final Collection<SponsorAffinityGroupAvailability> avas;
        final Collection<AffinityGroup> affinities;

        sponsorBuilderAssemblerService = Mockito
                .mock(SponsorBuilderAssemblerService.class);
        sponsorUnitsService = Mockito.mock(SponsorUnitsService.class);
        defaults = Mockito.mock(SponsorDefaults.class);

        sponsorAffinityGroupAvailabilityService = Mockito
                .mock(SponsorAffinityGroupAvailabilityService.class);

        affinities = new ArrayList<>();
        affinities.add(new DefaultAffinityGroup("aff1"));
        affinities.add(new DefaultAffinityGroup("aff2"));
        affinities.add(new DefaultAffinityGroup("aff3"));
        affinities.add(new DefaultAffinityGroup("aff4"));

        avas = new ArrayList<>();
        avas.add(new DefaultSponsorAffinityGroupAvailability("A", affinities,
                false));

        Mockito.when(sponsorAffinityGroupAvailabilityService
                .getAllSponsorAffinityGroupAvailabilities()).thenReturn(avas);

        return new DefaultSponsorBuilderService(sponsorBuilderAssemblerService,
                sponsorUnitsService, sponsorAffinityGroupAvailabilityService,
                defaults);
    }

    /**
     * Returns a service with no affinities.
     * <p>
     * All the dependencies are mocked.
     * 
     * @return service with no affinities
     */
    private final SponsorBuilderService getNoAffinitiesSponsorBuilderService() {
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
