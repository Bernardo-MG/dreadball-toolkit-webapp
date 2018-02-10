
package com.bernardomg.tabletop.dreadball.model.service;

import java.util.Collection;

import com.bernardomg.tabletop.dreadball.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.model.SponsorTeamAssets;
import com.bernardomg.tabletop.dreadball.model.SponsorTeamSelection;

public interface SponsorBuilderAssemblerService {

    public SponsorAffinities
            assembleSponsorAffinities(final Iterable<String> affinities);

    public SponsorTeamSelection assembleSponsorTeamSelection(
            final Collection<String> affinities, final Collection<String> units,
            final SponsorTeamAssets assets, final Integer baseRank);

}
