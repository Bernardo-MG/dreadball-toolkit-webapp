
package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean;

import static com.google.common.base.Preconditions.checkNotNull;

import com.wandrell.tabletop.dreadball.model.unit.DefaultAffinityGroup;

public class SponsorAffinitiesSelection {

    private final Iterable<DefaultAffinityGroup> affinities;

    private final Integer                        rank;

    public SponsorAffinitiesSelection(
            final Iterable<DefaultAffinityGroup> affinities,
            final Integer rank) {
        super();

        this.affinities = checkNotNull(affinities,
                "Received a null pointer as affinities");
        this.rank = checkNotNull(rank, "Received a null pointer as rank");
    }

    public Iterable<DefaultAffinityGroup> getAffinities() {
        return affinities;
    }

    public Integer getRank() {
        return rank;
    }

}
