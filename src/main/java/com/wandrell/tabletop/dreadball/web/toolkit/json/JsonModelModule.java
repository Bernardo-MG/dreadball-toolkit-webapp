
package com.wandrell.tabletop.dreadball.web.toolkit.json;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.json.faction.SponsorMixIn;
import com.wandrell.tabletop.dreadball.model.json.team.SponsorTeamMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.AffinityGroupMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.AffinityUnitMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.UnitMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AbilityMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AttributesMixIn;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.Attributes;

public final class JsonModelModule extends SimpleModule {

    private static final long serialVersionUID = 1405374344133040810L;

    public JsonModelModule() {
        super();
    }

    @Override
    public final void setupModule(final SetupContext context) {
        context.setMixInAnnotations(Sponsor.class, SponsorMixIn.class);

        context.setMixInAnnotations(AffinityGroup.class,
                AffinityGroupMixIn.class);

        context.setMixInAnnotations(SponsorTeam.class, SponsorTeamMixIn.class);

        context.setMixInAnnotations(Unit.class, UnitMixIn.class);
        context.setMixInAnnotations(AffinityUnit.class,
                AffinityUnitMixIn.class);

        context.setMixInAnnotations(Ability.class, AbilityMixIn.class);
        context.setMixInAnnotations(Attributes.class, AttributesMixIn.class);
    }

}
