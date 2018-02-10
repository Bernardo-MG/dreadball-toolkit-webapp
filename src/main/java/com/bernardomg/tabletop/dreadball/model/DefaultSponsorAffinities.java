
package com.bernardomg.tabletop.dreadball.model;

import static com.google.common.base.Preconditions.checkNotNull;

public final class DefaultSponsorAffinities implements SponsorAffinities {

    private final Iterable<String> affinities;

    private final Integer          rank;

    public DefaultSponsorAffinities(final Iterable<String> affinities,
            final Integer rank) {
        super();

        this.affinities = checkNotNull(affinities,
                "Received a null pointer as affinities");
        this.rank = checkNotNull(rank, "Received a null pointer as rank");
    }

    @Override
    public Iterable<String> getAffinities() {
        return affinities;
    }

    @Override
    public final Integer getRank() {
        return rank;
    }

}
