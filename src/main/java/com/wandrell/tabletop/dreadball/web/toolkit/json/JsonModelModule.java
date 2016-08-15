/**
 * Copyright 2016 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

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

/**
 * Contains all the Jackson configuration needed to set up a JSON mapper for
 * Dreadball.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class JsonModelModule extends SimpleModule {

    /**
     * Serialization id.
     */
    private static final long   serialVersionUID = 1405374344133040810L;

    /**
     * Message source.
     */
    private final MessageSource messageSource;

    /**
     * Constructs the module with the specified parameters.
     * 
     * @param ms
     *            the message source
     */
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

    /**
     * Returns the message source.
     * 
     * @return the message source
     */
    private final MessageSource getMessageSource() {
        return messageSource;
    }

    /**
     * Sets the mix-ins into the received context.
     * 
     * @param context
     *            the context where the mix-ins will be set
     */
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
