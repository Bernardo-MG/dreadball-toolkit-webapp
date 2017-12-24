
package com.bernardomg.tabletop.dreadball.build.dbx.service;

import java.util.Collection;

import org.springframework.data.domain.Pageable;

import com.bernardomg.tabletop.dreadball.build.dbx.model.OptionGroup;
import com.bernardomg.tabletop.dreadball.build.dbx.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.build.dbx.model.SponsorTeamAssets;
import com.bernardomg.tabletop.dreadball.build.dbx.model.SponsorTeamSelection;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.unit.Unit;

public interface SponsorBuilderService {

    public Iterable<OptionGroup> getAffinityOptionGroups();

    public Iterable<? extends Unit> getAffinityUnits(
            final Iterable<? extends AffinityGroup> affinities,
            final Pageable pageable);

    public SponsorAffinities
            selectAffinities(final Collection<String> affinities);

    public SponsorTeamSelection selectTeam(final Collection<String> affinities,
            final Collection<String> units, final SponsorTeamAssets assets,
            final Integer baseRank);

}
