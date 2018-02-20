
package com.bernardomg.tabletop.dreadball.web.toolkit.test.integration.codex.service;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.bernardomg.tabletop.dreadball.build.service.SponsorBuilderService;
import com.bernardomg.tabletop.dreadball.model.DefaultSponsorTeamValidationSelection;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.google.common.collect.Iterables;

/**
 * Integration tests for {@link SponsorBuilderService}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@ContextConfiguration(
        locations = { "classpath:context/test-service-context.xml" })
public final class ITDefaultSponsorBuilderServiceValidateTeam {

    /**
     * Tested service.
     */
    @Autowired
    private SponsorBuilderService service;

    /**
     * Default constructor.
     */
    public ITDefaultSponsorBuilderServiceValidateTeam() {
        super();
    }

    /**
     * Verifies that valid affinities are returned.
     */
    @Test
    public final void testAssemble_Affinities_ReturnsExpectedAffinities() {
        final DefaultSponsorTeamValidationSelection selection;
        final SponsorTeam result;

        selection = new DefaultSponsorTeamValidationSelection();

        selection.setAffinities(
                Arrays.asList("affinity_1", "affinity_2", "affinity_3"));

        result = service.validateTeam(selection);

        Assert.assertEquals(3,
                Iterables.size(result.getSponsor().getAffinityGroups()));
    }

    /**
     * Verifies that when there are no affinities then none is returned.
     */
    @Test
    public final void testAssemble_NoAffinities_NoReturnedAffinities() {
        final DefaultSponsorTeamValidationSelection selection;
        final SponsorTeam result;

        selection = new DefaultSponsorTeamValidationSelection();

        result = service.validateTeam(selection);

        Assert.assertEquals(0,
                Iterables.size(result.getSponsor().getAffinityGroups()));
    }

    /**
     * Verifies that when there are no units then none is returned.
     */
    @Test
    public final void testAssemble_NoUnits_NoReturnedUnits() {
        final DefaultSponsorTeamValidationSelection selection;
        final SponsorTeam result;

        selection = new DefaultSponsorTeamValidationSelection();

        result = service.validateTeam(selection);

        Assert.assertEquals(0, result.getPlayers().size());
    }

    /**
     * Verifies that when there are repeated affinities the returned ones do not
     * include repeated affinities.
     */
    @Test
    public final void
            testAssemble_RepeatedAffinities_ReturnsExpectedAffinities() {
        final DefaultSponsorTeamValidationSelection selection;
        final SponsorTeam result;

        selection = new DefaultSponsorTeamValidationSelection();

        selection.setAffinities(
                Arrays.asList("affinity_1", "affinity_2", "affinity_1"));

        result = service.validateTeam(selection);

        Assert.assertEquals(2,
                Iterables.size(result.getSponsor().getAffinityGroups()));
    }

    /**
     * Verifies that when there are repeated units the returned ones do not
     * include repeated units.
     */
    @Test
    public final void testAssemble_RepeatedUnits_ReturnsExpectedUnits() {
        final DefaultSponsorTeamValidationSelection selection;
        final SponsorTeam result;

        selection = new DefaultSponsorTeamValidationSelection();

        selection.setUnits(Arrays.asList("unit_1", "unit_2", "unit_1"));

        result = service.validateTeam(selection);

        Assert.assertEquals(3, result.getPlayers().size());
    }

    /**
     * Verifies that valid units are returned.
     */
    @Test
    public final void testAssemble_Units_ReturnsExpectedUnits() {
        final DefaultSponsorTeamValidationSelection selection;
        final SponsorTeam result;

        selection = new DefaultSponsorTeamValidationSelection();

        selection.setUnits(Arrays.asList("unit_1", "unit_2", "unit_3"));

        result = service.validateTeam(selection);

        Assert.assertEquals(3, result.getPlayers().size());
    }

}
