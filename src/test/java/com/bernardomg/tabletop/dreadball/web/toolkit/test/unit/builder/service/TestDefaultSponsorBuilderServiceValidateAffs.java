
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

public final class TestDefaultSponsorBuilderServiceValidateAffs {

    public TestDefaultSponsorBuilderServiceValidateAffs() {
        super();
    }

    @Test
    public final void testAssemble_Affinities_ExpectedAffinitiesResult() {
        final SponsorBuilderService service; // Tested service
        final Collection<String> affinities;
        final SponsorAffinities result;

        service = getSponsorBuilderService();

        affinities = new ArrayList<>();
        affinities.add("affinity_1");
        affinities.add("affinity_2");

        result = service.validateSponsorAffinities(affinities);

        Assert.assertEquals(Iterables.size(result.getAffinities()), 2);
    }

    @Test
    public final void testAssemble_Affinities_NoRankIncrease_NoReturnedRank() {
        final SponsorBuilderService service; // Tested service
        final Collection<String> affinities;
        final SponsorAffinities result;

        service = getSponsorBuilderService();

        affinities = new ArrayList<>();
        affinities.add("affinity_1");
        affinities.add("affinity_2");

        result = service.validateSponsorAffinities(affinities);

        Assert.assertEquals(result.getRank().intValue(), 0);
    }

    @Test
    public final void
            testAssemble_Affinities_RankIncrease_ExpectedAffinitiesResult() {
        final SponsorBuilderService service; // Tested service
        final Collection<String> affinities;
        final SponsorAffinities result;

        service = getSponsorBuilderService();

        affinities = new ArrayList<>();
        affinities.add("affinity_1");
        affinities.add("affinity_2");
        affinities.add("rank_increase");

        result = service.validateSponsorAffinities(affinities);

        Assert.assertEquals(Iterables.size(result.getAffinities()), 2);
    }

    @Test
    public final void testAssemble_NoAffinities_NoAffinitiesResult() {
        final SponsorBuilderService service; // Tested service
        final Collection<String> affinities;
        final SponsorAffinities result;

        service = getSponsorBuilderService();

        affinities = new ArrayList<>();

        result = service.validateSponsorAffinities(affinities);

        Assert.assertEquals(Iterables.size(result.getAffinities()), 0);
    }

    @Test
    public final void testAssemble_NoAffinities_NoReturnedRank() {
        final SponsorBuilderService service; // Tested service
        final Collection<String> affinities;
        final SponsorAffinities result;

        service = getSponsorBuilderService();

        affinities = new ArrayList<>();

        result = service.validateSponsorAffinities(affinities);

        Assert.assertEquals(result.getRank(), new Integer(0));
    }

    @Test
    public final void testAssemble_RankIncrease_NoAffinities() {
        final SponsorBuilderService service; // Tested service
        final Collection<String> affinities;
        final SponsorAffinities result;

        service = getSponsorBuilderService();

        affinities = new ArrayList<>();
        affinities.add("rank_increase");

        result = service.validateSponsorAffinities(affinities);

        Assert.assertEquals(Iterables.size(result.getAffinities()), 0);
    }

    @Test
    public final void testAssemble_RankIncrease_Rank() {
        final SponsorBuilderService service; // Tested service
        final Collection<String> affinities;
        final SponsorAffinities result;

        service = getSponsorBuilderService();

        affinities = new ArrayList<>();
        affinities.add("rank_increase");

        result = service.validateSponsorAffinities(affinities);

        Assert.assertEquals(result.getRank().intValue(), 1);
    }

    @Test
    public final void
            testAssemble_RepeatedAffinities_NoRepeatedAffinitiesResult() {
        final SponsorBuilderService service; // Tested service
        final Collection<String> affinities;
        final SponsorAffinities result;

        service = getSponsorBuilderService();

        affinities = new ArrayList<>();
        affinities.add("affinity_1");
        affinities.add("affinity_2");
        affinities.add("affinity_1");

        result = service.validateSponsorAffinities(affinities);

        Assert.assertEquals(Iterables.size(result.getAffinities()), 2);
    }

    /**
     * Returns a service with no affinities.
     * <p>
     * All the dependencies are mocked.
     * 
     * @return service with no affinities
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
