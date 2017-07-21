
package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean;

import static com.google.common.base.Preconditions.checkNotNull;

public class SponsorAffinitiesSelection {

    private final Iterable<String> affinities;

    private final Integer          baseRank;

    private final Integer          rank;

    private final Integer          teamValue;

    public SponsorAffinitiesSelection(final Iterable<String> affinities,
            final Integer rank, final Integer baseRank,
            final Integer teamValue) {
        super();

        this.affinities = checkNotNull(affinities,
                "Received a null pointer as affinities");
        this.rank = checkNotNull(rank, "Received a null pointer as rank");
        this.baseRank = checkNotNull(baseRank,
                "Received a null pointer as base rank");
        this.teamValue = checkNotNull(teamValue,
                "Received a null pointer as team value");
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

    public Integer getTeamValue() {
        return teamValue;
    }

}
