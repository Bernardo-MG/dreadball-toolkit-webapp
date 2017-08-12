
package com.wandrell.tabletop.dreadball.web.toolkit.controller.builder.dbx.bean;

import static com.google.common.base.Preconditions.checkNotNull;

public class SponsorAffinities {

    private final Iterable<String> affinities;

    private final Integer          baseRank;

    private final Integer          rank;

    public SponsorAffinities(final Iterable<String> affinities,
            final Integer baseRank, final Integer rank) {
        super();

        this.affinities = checkNotNull(affinities,
                "Received a null pointer as affinities");
        this.baseRank = checkNotNull(baseRank,
                "Received a null pointer as base rank");
        this.rank = checkNotNull(rank, "Received a null pointer as rank");
    }

    public Iterable<String> getAffinities() {
        return affinities;
    }

    public Integer getBaseRank() {
        return baseRank;
    }

    public Integer getRank() {
        return rank;
    }

}
