
package com.wandrell.tabletop.dreadball.build.dbx.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.build.dbx.assembler.AffinitiesSelectionAssembler;
import com.wandrell.tabletop.dreadball.build.dbx.assembler.SponsorTeamSelectionAssembler;
import com.wandrell.tabletop.dreadball.build.dbx.model.SponsorAffinities;
import com.wandrell.tabletop.dreadball.build.dbx.model.SponsorTeamAssets;
import com.wandrell.tabletop.dreadball.build.dbx.model.SponsorTeamSelection;
import com.wandrell.tabletop.dreadball.build.dbx.rules.SponsorDefaults;

@Service
public final class DefaultSponsorBuilderAssemblerService
        implements SponsorBuilderAssemblerService {

    private final AffinitiesSelectionAssembler  affAssembler;

    private final SponsorTeamSelectionAssembler teamAssembler;

    @Autowired
    public DefaultSponsorBuilderAssemblerService(
            final SponsorTeamSelectionAssembler sponsorTeamAssembler,
            final AffinitiesSelectionAssembler affinitiesAssembler,
            final SponsorDefaults sponsorDefaults) {
        super();

        teamAssembler = checkNotNull(sponsorTeamAssembler,
                "Received a null pointer as team selection assembler");
        affAssembler = checkNotNull(affinitiesAssembler,
                "Received a null pointer as affinities selection assembler");
    }

    @Override
    public final SponsorAffinities
            assembleSponsorAffinities(final Collection<String> affinities) {
        final Integer rank;
        final Iterable<String> valid;

        rank = getRank(affinities);
        // TODO: Ensure these are existing affinities
        valid = getValidAffinities(affinities);

        return getAffinitiesSelectionAssembler().assemble(valid, rank);
    }

    @Override
    public final SponsorTeamSelection assembleSponsorTeamSelection(
            final Collection<String> affinities, final Collection<String> units,
            final SponsorTeamAssets assets, final Integer baseRank) {
        return getSponsorTeamSelectionAssembler().assemble(affinities, units,
                assets, baseRank);
    }

    private final AffinitiesSelectionAssembler
            getAffinitiesSelectionAssembler() {
        return affAssembler;
    }

    private final Integer getRank(final Collection<String> affinities) {
        final Integer rank;

        // TODO: This doesn't look like a good solution
        rank = affinities.stream()
                .filter(affinity -> affinity.equals("rank_increase"))
                .collect(Collectors.toList()).size();

        return rank;
    }

    private final SponsorTeamSelectionAssembler
            getSponsorTeamSelectionAssembler() {
        return teamAssembler;
    }

    private final Iterable<String>
            getValidAffinities(final Collection<String> affinities) {
        return affinities.stream()
                .filter(affinity -> !affinity.equals("rank_increase"))
                .collect(Collectors.toSet());
    }

}
