
package com.wandrell.tabletop.dreadball.build.dbx.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.build.dbx.assembler.AffinitiesSelectionAssembler;
import com.wandrell.tabletop.dreadball.build.dbx.assembler.SponsorTeamSelectionAssembler;
import com.wandrell.tabletop.dreadball.build.dbx.model.SponsorAffinities;
import com.wandrell.tabletop.dreadball.build.dbx.model.SponsorTeamAssets;
import com.wandrell.tabletop.dreadball.build.dbx.model.SponsorTeamSelection;

@Service
public final class DefaultSponsorBuilderAssemblerService
        implements SponsorBuilderAssemblerService {

    private final AffinitiesSelectionAssembler  affAssembler;

    private final SponsorTeamSelectionAssembler teamAssembler;

    public DefaultSponsorBuilderAssemblerService(
            final SponsorTeamSelectionAssembler sponsorTeamAssembler,
            final AffinitiesSelectionAssembler affinitiesAssembler) {
        super();

        teamAssembler = checkNotNull(sponsorTeamAssembler,
                "Received a null pointer as team selection assembler");
        affAssembler = checkNotNull(affinitiesAssembler,
                "Received a null pointer as affinities selection assembler");
    }

    @Override
    public final SponsorAffinities
            assembleSponsorAffinities(final Collection<String> affinities) {
        return getAffinitiesSelectionAssembler().assemble(affinities);
    }

    @Override
    public SponsorTeamSelection assembleSponsorTeamSelection(
            final Collection<String> affinities, final Collection<String> units,
            final SponsorTeamAssets assets, final Integer baseRank) {
        return getSponsorTeamSelectionAssembler().assemble(affinities, units,
                assets, baseRank);
    }

    private final AffinitiesSelectionAssembler
            getAffinitiesSelectionAssembler() {
        return affAssembler;
    }

    private final SponsorTeamSelectionAssembler
            getSponsorTeamSelectionAssembler() {
        return teamAssembler;
    }

}
