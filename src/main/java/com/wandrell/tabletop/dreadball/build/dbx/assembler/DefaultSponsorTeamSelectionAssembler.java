
package com.wandrell.tabletop.dreadball.build.dbx.assembler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.build.dbx.model.DefaultSponsorTeamSelection;
import com.wandrell.tabletop.dreadball.build.dbx.model.SponsorTeamSelection;
import com.wandrell.tabletop.dreadball.build.dbx.model.TeamPlayer;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;

@Service
public class DefaultSponsorTeamSelectionAssembler
        implements SponsorTeamSelectionAssembler {

    @Autowired
    public DefaultSponsorTeamSelectionAssembler() {
        super();
    }

    @Override
    public final SponsorTeamSelection assemble(final SponsorTeam team,
            final Integer baseRank) {
        final Integer rank;
        final Integer assetRankCost;
        final Integer teamValue;
        final Iterable<TeamPlayer> acceptedUnits;
        final Iterable<String> affNames;

        checkNotNull(team, "Received a null pointer as team");
        checkNotNull(baseRank, "Received a null pointer as base rank");

        teamValue = team.getValoration();
        assetRankCost = team.getRankCost();

        // TODO: Receive the rank increase instead of the base rank
        rank = baseRank - assetRankCost;

        acceptedUnits = getTeamPlayers(team);
        affNames = getNames(team.getSponsor().getAffinityGroups());

        return new DefaultSponsorTeamSelection(affNames, acceptedUnits, rank,
                baseRank, teamValue);
    }

    private final Iterable<String>
            getNames(final Iterable<AffinityGroup> affinities) {
        return StreamSupport.stream(affinities.spliterator(), false)
                .map(AffinityGroup::getName).collect(Collectors.toList());
    }

    private final Iterable<TeamPlayer>
            getTeamPlayers(final SponsorTeam sponsorTeam) {
        return sponsorTeam.getPlayers().entrySet().stream()
                .map(unit -> new TeamPlayer(unit.getKey(),
                        unit.getValue().getTemplateName()))
                .collect(Collectors.toList());
    }

}
