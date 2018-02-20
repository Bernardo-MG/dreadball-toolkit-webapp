
package com.bernardomg.tabletop.dreadball.web.toolkit.test.unit.builder.service;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.build.service.DefaultSponsorBuilderService;
import com.bernardomg.tabletop.dreadball.build.service.SponsorBuilderService;
import com.bernardomg.tabletop.dreadball.model.DefaultSponsorTeamValidationSelection;
import com.bernardomg.tabletop.dreadball.model.service.SponsorAffinityGroupAvailabilityService;
import com.bernardomg.tabletop.dreadball.model.service.SponsorUnitsService;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.bernardomg.tabletop.dreadball.repository.unit.AffinityGroupRepository;
import com.bernardomg.tabletop.dreadball.repository.unit.AffinityUnitRepository;
import com.bernardomg.tabletop.dreadball.rules.DbxRules;
import com.bernardomg.tabletop.dreadball.rules.SponsorCosts;
import com.bernardomg.tabletop.dreadball.rules.SponsorDefaults;
import com.google.common.collect.Iterables;

@Ignore
public final class TestDefaultSponsorBuilderServiceValidateTeam {

    public TestDefaultSponsorBuilderServiceValidateTeam() {
        super();
        // TODO: This may work better as an integration test
    }

    @Test
    public final void testAssemble_Affinities_ReturnsExpectedAffinities() {
        final DefaultSponsorTeamValidationSelection selection;
        final SponsorTeam result;

        selection = new DefaultSponsorTeamValidationSelection();

        selection.setAffinities(Arrays.asList("aff1", "aff2", "aff3"));

        result = getSponsorBuilderService().validateTeam(selection);

        Assert.assertEquals(3,
                Iterables.size(result.getSponsor().getAffinityGroups()));
    }

    @Test
    public final void testAssemble_NoAffinities_NoReturnedAffinities() {
        final DefaultSponsorTeamValidationSelection selection;
        final SponsorTeam result;

        selection = new DefaultSponsorTeamValidationSelection();

        result = getSponsorBuilderService().validateTeam(selection);

        Assert.assertEquals(0,
                Iterables.size(result.getSponsor().getAffinityGroups()));
    }

    @Test
    public final void testAssemble_NoUnits_NoReturnedUnits() {
        final DefaultSponsorTeamValidationSelection selection;
        final SponsorTeam result;

        selection = new DefaultSponsorTeamValidationSelection();

        result = getSponsorBuilderService().validateTeam(selection);

        Assert.assertEquals(0, result.getPlayers().size());
    }

    @Test
    public final void
            testAssemble_RepeatedAffinities_ReturnsExpectedAffinities() {
        final DefaultSponsorTeamValidationSelection selection;
        final SponsorTeam result;

        selection = new DefaultSponsorTeamValidationSelection();

        selection.setAffinities(Arrays.asList("aff1", "aff2", "aff1"));

        result = getSponsorBuilderService().validateTeam(selection);

        Assert.assertEquals(2,
                Iterables.size(result.getSponsor().getAffinityGroups()));
    }

    @Test
    public final void testAssemble_RepeatedUnits_ReturnsExpectedUnits() {
        final DefaultSponsorTeamValidationSelection selection;
        final SponsorTeam result;

        selection = new DefaultSponsorTeamValidationSelection();

        selection.setUnits(Arrays.asList("unit1", "unit2", "unit1"));

        result = getSponsorBuilderService().validateTeam(selection);

        Assert.assertEquals(3, result.getPlayers().size());
    }

    @Test
    public final void testAssemble_Units_ReturnsExpectedUnits() {
        final DefaultSponsorTeamValidationSelection selection;
        final SponsorTeam result;

        selection = new DefaultSponsorTeamValidationSelection();

        selection.setUnits(Arrays.asList("unit1", "unit2", "unit3"));

        result = getSponsorBuilderService().validateTeam(selection);

        Assert.assertEquals(3, result.getPlayers().size());
    }

    /**
     * Returns a service.
     * <p>
     * All the dependencies are mocked.
     * 
     * @return service
     */
    private final SponsorBuilderService getSponsorBuilderService() {
        final SponsorUnitsService sponsorUnitsService;
        final SponsorDefaults defaults;
        final SponsorAffinityGroupAvailabilityService sponsorAffinityGroupAvailabilityService;
        final AffinityUnitRepository affUnitRepository;
        final AffinityGroupRepository affGroupRepository;
        final SponsorCosts costsRank;
        final SponsorCosts costs;
        final DbxRules rules;

        affUnitRepository = Mockito.mock(AffinityUnitRepository.class);
        affGroupRepository = Mockito.mock(AffinityGroupRepository.class);
        sponsorUnitsService = Mockito.mock(SponsorUnitsService.class);
        costsRank = Mockito.mock(SponsorCosts.class);
        costs = Mockito.mock(SponsorCosts.class);
        rules = Mockito.mock(DbxRules.class);

        defaults = Mockito.mock(SponsorDefaults.class);
        Mockito.when(defaults.getInitialRank()).thenReturn(0);

        sponsorAffinityGroupAvailabilityService = Mockito
                .mock(SponsorAffinityGroupAvailabilityService.class);
        Mockito.when(sponsorAffinityGroupAvailabilityService
                .getAllSponsorAffinityGroupAvailabilities())
                .thenReturn(Collections.emptyList());

        return new DefaultSponsorBuilderService(sponsorUnitsService,
                sponsorAffinityGroupAvailabilityService, defaults,
                affUnitRepository, affGroupRepository, costsRank, costs, rules);
    }

}
