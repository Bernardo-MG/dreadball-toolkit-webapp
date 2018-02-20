
package com.bernardomg.tabletop.dreadball.build.service;

import java.util.Collection;

import org.springframework.data.domain.Pageable;

import com.bernardomg.tabletop.dreadball.model.DefaultSponsorTeamValidationSelection;
import com.bernardomg.tabletop.dreadball.model.OptionGroup;
import com.bernardomg.tabletop.dreadball.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.unit.Unit;

public interface SponsorBuilderService {

    /**
     * Returns all the available affinities for a Sponsor.
     * <p>
     * These will be stored into options, allowing these affinities to be
     * selectable.
     * 
     * @return all the available affinities for a Sponsor
     */
    public Collection<OptionGroup> getAffinityOptions();

    public Iterable<? extends Unit> getUnitOptions(
            final Collection<? extends AffinityGroup> affinities,
            final Pageable pageable);

    /**
     * Validates a set of Sponsor affinities.
     * <p>
     * This is meant to be used for validating the affinities selected when
     * creating a Sponsor.
     * <p>
     * The valid affinities are returned inside a new object.
     * 
     * @param affinities
     *            affinities to validate
     * @return the valid affinities
     */
    public SponsorAffinities
            validateSponsorAffinities(final Collection<String> affinities);

    /**
     * Validates a team.
     * <p>
     * This is meant for validating the team while building it.
     * 
     * @param selection
     *            the team values
     * @return a valid team
     */
    public SponsorTeam
            validateTeam(final DefaultSponsorTeamValidationSelection selection);

}
