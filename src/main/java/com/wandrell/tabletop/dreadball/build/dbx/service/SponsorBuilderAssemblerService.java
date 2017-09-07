
package com.wandrell.tabletop.dreadball.build.dbx.service;

import java.util.Collection;

import com.wandrell.tabletop.dreadball.build.dbx.model.SponsorAffinities;
import com.wandrell.tabletop.dreadball.build.dbx.model.SponsorTeamAssets;
import com.wandrell.tabletop.dreadball.build.dbx.model.SponsorTeamSelection;

public interface SponsorBuilderAssemblerService {

    public SponsorAffinities
            assembleSponsorAffinities(final Collection<String> affinities);

    public SponsorTeamSelection assembleSponsorTeamSelection(
            final Collection<String> affinities, final Collection<String> units,
            final SponsorTeamAssets assets, final Integer baseRank);

}
