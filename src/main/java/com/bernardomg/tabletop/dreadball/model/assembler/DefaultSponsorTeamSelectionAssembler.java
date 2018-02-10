
package com.bernardomg.tabletop.dreadball.model.assembler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bernardomg.tabletop.dreadball.model.DefaultSponsorTeamAssets;
import com.bernardomg.tabletop.dreadball.model.ImmutableSponsorTeamSelection;
import com.bernardomg.tabletop.dreadball.model.SponsorTeamSelection;
import com.bernardomg.tabletop.dreadball.model.TeamPlayer;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.unit.Unit;

@Component
public final class DefaultSponsorTeamSelectionAssembler
        implements SponsorTeamSelectionAssembler {

    @Autowired
    public DefaultSponsorTeamSelectionAssembler() {
        super();
    }

    @Override
    public final SponsorTeamSelection assemble(final SponsorTeam team) {
        final Integer rank;
        final Integer assetRankCost;
        final Integer teamValue;
        final Iterable<TeamPlayer> acceptedUnits;
        final Iterable<String> affNames;
        final DefaultSponsorTeamAssets assets;

        checkNotNull(team, "Received a null pointer as team");

        teamValue = team.getValoration();
        assetRankCost = team.getRankCost();

        rank = team.getSponsor().getRank() - assetRankCost;

        acceptedUnits = getTeamPlayers(team.getPlayers());
        affNames = getNames(team.getSponsor().getAffinityGroups());

        assets = new DefaultSponsorTeamAssets();
        assets.setCheerleaders(team.getCheerleaders());
        assets.setCoachingDice(team.getCoachingDice());
        assets.setMediBots(team.getMediBots());
        assets.setNastySurpriseCards(team.getSabotageCards());
        assets.setSpecialMoveCards(team.getSpecialMoveCards());
        assets.setWagers(team.getWagers());

        return new ImmutableSponsorTeamSelection(affNames, acceptedUnits, rank,
                team.getSponsor().getRank(), teamValue, assets);
    }

    private final Iterable<String>
            getNames(final Iterable<AffinityGroup> affinities) {
        return StreamSupport.stream(affinities.spliterator(), false)
                .map(AffinityGroup::getName).collect(Collectors.toSet());
    }

    private final Iterable<TeamPlayer>
            getTeamPlayers(final Map<Integer, Unit> units) {
        return units.entrySet().stream()
                .map(unit -> new TeamPlayer(unit.getKey(),
                        unit.getValue().getTemplateName()))
                .collect(Collectors.toList());
    }

}
