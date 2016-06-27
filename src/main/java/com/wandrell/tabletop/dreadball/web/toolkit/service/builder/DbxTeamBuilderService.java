
package com.wandrell.tabletop.dreadball.web.toolkit.service.builder;

import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;

public interface DbxTeamBuilderService {

    public Iterable<? extends SponsorAffinityGroupAvailability>
            getSponsorAffinityGroups();

}
