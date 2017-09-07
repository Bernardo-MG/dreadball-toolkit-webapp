
package com.wandrell.tabletop.dreadball.build.dbx.service;

import java.util.Collection;

import org.springframework.data.domain.Pageable;

import com.wandrell.tabletop.dreadball.build.dbx.model.SponsorAffinities;
import com.wandrell.tabletop.dreadball.build.dbx.model.SponsorTeamAssets;
import com.wandrell.tabletop.dreadball.build.dbx.model.SponsorTeamSelection;
import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.Unit;

public interface SponsorBuilderService {

    public Iterable<SponsorAffinityGroupAvailability>
            getAffinityGroupAvailabilities();

    public Iterable<? extends Unit> getAffinityUnits(
            final Iterable<? extends AffinityGroup> affinities,
            final Pageable pageable);

    public SponsorAffinities
            selectAffinities(final Collection<String> affinities);

    public SponsorTeamSelection selectTeam(final Collection<String> affinities,
            final Collection<String> units, final SponsorTeamAssets assets,
            final Integer baseRank);

}
