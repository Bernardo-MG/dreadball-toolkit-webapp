
package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean;

import static com.google.common.base.Preconditions.checkNotNull;

public class SponsorAffinitiesSelection {

    private final Iterable<String> affinities;

    private final Integer          rank;

    public SponsorAffinitiesSelection(final Iterable<String> affinities,
            final Integer rank) {
        super();

        this.affinities = checkNotNull(affinities,
                "Received a null pointer as affinities");
        this.rank = checkNotNull(rank, "Received a null pointer as rank");
    }

    public Iterable<String> getAffinities() {
        return affinities;
    }

    public Integer getRank() {
        return rank;
    }

}
