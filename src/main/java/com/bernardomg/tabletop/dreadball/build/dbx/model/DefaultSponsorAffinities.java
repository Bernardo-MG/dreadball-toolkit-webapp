
package com.bernardomg.tabletop.dreadball.build.dbx.model;

import static com.google.common.base.Preconditions.checkNotNull;

public final class DefaultSponsorAffinities implements SponsorAffinities {

    private final Iterable<String> affinities;

    private final Integer          baseRank;

    private final Integer          rank;

    public DefaultSponsorAffinities(final Iterable<String> affinities,
            final Integer baseRank, final Integer rank) {
        super();

        this.affinities = checkNotNull(affinities,
                "Received a null pointer as affinities");
        this.baseRank = checkNotNull(baseRank,
                "Received a null pointer as base rank");
        this.rank = checkNotNull(rank, "Received a null pointer as rank");
    }

    @Override
    public Iterable<String> getAffinities() {
        return affinities;
    }

    @Override
    public final Integer getBaseRank() {
        return baseRank;
    }

    @Override
    public final Integer getRank() {
        return rank;
    }

}
