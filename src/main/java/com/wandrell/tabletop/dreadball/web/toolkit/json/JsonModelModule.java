
package com.wandrell.tabletop.dreadball.web.toolkit.json;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.context.MessageSource;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
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

    private static final long   serialVersionUID = 1405374344133040810L;

    private final MessageSource messageSource;

    public JsonModelModule(final MessageSource ms) {
        super();

        messageSource = checkNotNull(ms,
                "Received a null pointer as message source");
    }

    @Override
    public final void setupModule(final SetupContext context) {
        super.setupModule(context);

        setupMixIns(context);

        context.addBeanSerializerModifier(new BeanSerializerModifier() {

            @Override
            public final JsonSerializer<?> modifySerializer(
                    final SerializationConfig config,
                    final BeanDescription beanDesc,
                    final JsonSerializer<?> serializer) {
                if (serializer instanceof BeanSerializerBase) {
                    return new UnitInternationalizationSerializer(
                            (BeanSerializerBase) serializer,
                            getMessageSource());
                }
                return serializer;

            }
        });
    }

    private final MessageSource getMessageSource() {
        return messageSource;
    }

    private final void setupMixIns(final SetupContext context) {
        // Factions
        context.setMixInAnnotations(Sponsor.class, SponsorMixIn.class);

        // Stats
        context.setMixInAnnotations(Ability.class, AbilityMixIn.class);
        context.setMixInAnnotations(Attributes.class, AttributesMixIn.class);
        context.setMixInAnnotations(AffinityGroup.class,
                AffinityGroupMixIn.class);

        // Teams
        context.setMixInAnnotations(SponsorTeam.class, SponsorTeamMixIn.class);

        // Units
        context.setMixInAnnotations(Unit.class, UnitMixIn.class);
        context.setMixInAnnotations(AffinityUnit.class,
                AffinityUnitMixIn.class);
    }

}
