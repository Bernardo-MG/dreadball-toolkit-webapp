
package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean;

import java.util.Collection;

import com.wandrell.tabletop.dreadball.model.unit.DefaultAffinityGroup;

public class SponsorTeamOptions {

    private Collection<DefaultAffinityGroup> affinities;

    public SponsorTeamOptions() {
        super();
    }

    public final Collection<DefaultAffinityGroup> getAffinities() {
        return affinities;
    }

    public final void
            setAffinities(final Collection<DefaultAffinityGroup> affinities) {
        this.affinities = affinities;
    }

}
