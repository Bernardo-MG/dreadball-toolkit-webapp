
package com.wandrell.tabletop.dreadball.web.toolkit.service.builder;

import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.web.toolkit.model.form.SponsorForm;

public interface DbxTeamBuilderService {

    public Integer getInitialRank();

    public Sponsor getSponsor(final SponsorForm form);

    public Iterable<? extends SponsorAffinityGroupAvailability>
            getSponsorAffinityGroups();

    public Iterable<? extends Unit>
            getSponsorAvailableUnits(final Sponsor sponsor);

}
