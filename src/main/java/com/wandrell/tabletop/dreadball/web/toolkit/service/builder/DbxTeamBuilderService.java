
package com.wandrell.tabletop.dreadball.web.toolkit.service.builder;

import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.web.toolkit.model.form.SponsorForm;

public interface DbxTeamBuilderService {

    public void addUnit(final SponsorTeam team, final String templateName);

    public Integer getInitialRank();

    public Integer getMaxTeamUnits();

    public Sponsor getSponsor(final SponsorForm form);

    public Iterable<? extends SponsorAffinityGroupAvailability>
            getSponsorAffinityGroups();

    public SponsorTeam getSponsorTeam(final Sponsor sponsor);

    public Iterable<? extends Unit>
            getSponsorTeamAvailableUnits(final SponsorTeam team);

}
