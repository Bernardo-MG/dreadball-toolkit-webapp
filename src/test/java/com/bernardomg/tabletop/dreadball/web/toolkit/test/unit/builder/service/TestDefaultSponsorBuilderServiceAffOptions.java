
package com.bernardomg.tabletop.dreadball.web.toolkit.test.unit.builder.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
import com.google.common.collect.Iterables;

public class TestDefaultSponsorBuilderServiceAffOptions {

    public TestDefaultSponsorBuilderServiceAffOptions() {
        super();
    }

    @Test
    public final void
            testGetAffinityOptionGroups_AffinitiesAndRank_AddsAdditionalOption() {
        final SponsorBuilderService service;
        final Iterable<OptionGroup> options;

        service = getAffinitiesAndRankSponsorBuilderService();

        options = service.getAffinityOptions();

        Assert.assertEquals(5,
                Iterables.size(options.iterator().next().getOptions()));
    }

    @Test
    public final void
            testGetAffinityOptionGroups_AffinitiesAndRank_ContainsRank() {
        final SponsorBuilderService service;
        final Iterable<OptionGroup> options;
        final Collection<String> values;

        service = getAffinitiesAndRankSponsorBuilderService();

        options = service.getAffinityOptions();

        values = StreamSupport
                .stream(options.iterator().next().getOptions().spliterator(),
                        false)
                .map(Option::getValue).collect(Collectors.toList());
        Assert.assertTrue(values.contains("rank_increase"));
    }

    @Test
    public final void
            testGetAffinityOptionGroups_AffinitiesAndRank_ReturnsGroup() {
        final SponsorBuilderService service;
        final Iterable<OptionGroup> options;

        service = getAffinitiesAndRankSponsorBuilderService();

        options = service.getAffinityOptions();

        Assert.assertEquals(1, Iterables.size(options));
    }

    @Test
    public final void testGetAffinityOptionGroups_NoAffinities_Empty() {
        final SponsorBuilderService service;
        final Iterable<OptionGroup> options;

        service = getNoAffinitiesSponsorBuilderService();

        options = service.getAffinityOptions();

        Assert.assertEquals(0, Iterables.size(options));
    }

    private final SponsorBuilderService
            getAffinitiesAndRankSponsorBuilderService() {
        final SponsorBuilderAssemblerService sponsorBuilderAssemblerService;
        final SponsorUnitsService sponsorUnitsService;
        final SponsorAffinityGroupAvailabilityService sponsorAffinityGroupAvailabilityService;
        final Collection<SponsorAffinityGroupAvailability> avas;
        final Collection<AffinityGroup> affinities;

        sponsorBuilderAssemblerService = Mockito
                .mock(SponsorBuilderAssemblerService.class);
        sponsorUnitsService = Mockito.mock(SponsorUnitsService.class);

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
                sponsorUnitsService, sponsorAffinityGroupAvailabilityService);
    }

    private final SponsorBuilderService getNoAffinitiesSponsorBuilderService() {
        final SponsorBuilderAssemblerService sponsorBuilderAssemblerService;
        final SponsorUnitsService sponsorUnitsService;
        final SponsorAffinityGroupAvailabilityService sponsorAffinityGroupAvailabilityService;

        sponsorBuilderAssemblerService = Mockito
                .mock(SponsorBuilderAssemblerService.class);
        sponsorUnitsService = Mockito.mock(SponsorUnitsService.class);

        sponsorAffinityGroupAvailabilityService = Mockito
                .mock(SponsorAffinityGroupAvailabilityService.class);
        Mockito.when(sponsorAffinityGroupAvailabilityService
                .getAllSponsorAffinityGroupAvailabilities())
                .thenReturn(Collections.emptyList());

        return new DefaultSponsorBuilderService(sponsorBuilderAssemblerService,
                sponsorUnitsService, sponsorAffinityGroupAvailabilityService);
    }

}
