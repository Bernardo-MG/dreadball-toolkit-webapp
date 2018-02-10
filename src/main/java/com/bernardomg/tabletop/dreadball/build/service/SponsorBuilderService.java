
package com.bernardomg.tabletop.dreadball.build.service;

import java.util.Collection;

import org.springframework.data.domain.Pageable;

import com.bernardomg.tabletop.dreadball.model.OptionGroup;
import com.bernardomg.tabletop.dreadball.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.model.SponsorTeamAssets;
import com.bernardomg.tabletop.dreadball.model.SponsorTeamSelection;
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
            final Iterable<? extends AffinityGroup> affinities,
            final Pageable pageable);

    public SponsorAffinities
            validateAffinities(final Iterable<String> affinities);

    public SponsorTeamSelection validateTeam(
            final Collection<String> affinities, final Collection<String> units,
            final SponsorTeamAssets assets, final Integer baseRank);

}
