
package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean;

import java.util.ArrayList;
import java.util.Collection;

import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.DefaultAffinityGroup;

public class SponsorAffinitiesOptions {

    private Collection<? extends AffinityGroup> affinities = new ArrayList<>();

    public SponsorAffinitiesOptions() {
        super();
    }

    public final Collection<? extends AffinityGroup> getAffinities() {
        return affinities;
    }

    public final void
            setAffinities(final Collection<DefaultAffinityGroup> affinities) {
        this.affinities = affinities;
    }

}
