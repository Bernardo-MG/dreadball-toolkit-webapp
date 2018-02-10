
package com.bernardomg.tabletop.dreadball.build.dbx.model;

import static com.google.common.base.Preconditions.checkNotNull;

public final class ImmutableSponsorTeamSelection
        implements SponsorTeamSelection {

    private final Iterable<String>     affinities;

    private final SponsorTeamAssets    assets;

    private final Integer              baseRank;

    private final Integer              rank;

    private final Integer              teamValue;

    private final Iterable<TeamPlayer> units;

    public ImmutableSponsorTeamSelection(final Iterable<String> affinities,
            final Iterable<TeamPlayer> units, final Integer rank,
            final Integer baseRank, final Integer teamValue,
            final SponsorTeamAssets assets) {
        super();

        this.affinities = checkNotNull(affinities,
                "Received a null pointer as affinities");
        this.units = checkNotNull(units, "Received a null pointer as units");
        this.rank = checkNotNull(rank, "Received a null pointer as rank");
        this.baseRank = checkNotNull(baseRank,
                "Received a null pointer as base rank");
        this.teamValue = checkNotNull(teamValue,
                "Received a null pointer as team value");
        this.assets = checkNotNull(assets,
                "Received a null pointer as team assets");
    }

    @Override
    public final Iterable<String> getAffinities() {
        return affinities;
    }

    @Override
    public final SponsorTeamAssets getAssets() {
        return assets;
    }

    @Override
    public final Integer getBaseRank() {
        return baseRank;
    }

    @Override
    public final Integer getRank() {
        return rank;
    }

    @Override
    public final Integer getTeamValue() {
        return teamValue;
    }

    @Override
    public final Iterable<TeamPlayer> getUnits() {
        return units;
    }

}
