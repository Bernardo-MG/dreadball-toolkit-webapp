/**
 * Copyright 2018 the original author or authors
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

package com.bernardomg.tabletop.dreadball.json;

import org.springframework.stereotype.Component;

import com.bernardomg.tabletop.dreadball.model.availability.affinity.SponsorAffinityGroupAvailability;
import com.bernardomg.tabletop.dreadball.model.faction.Sponsor;
import com.bernardomg.tabletop.dreadball.model.json.availability.affinity.SponsorAffinityGroupAvailabilityMixIn;
import com.bernardomg.tabletop.dreadball.model.json.faction.SponsorMixIn;
import com.bernardomg.tabletop.dreadball.model.json.player.AffinityTeamPlayerMixIn;
import com.bernardomg.tabletop.dreadball.model.json.player.TeamPlayerMixIn;
import com.bernardomg.tabletop.dreadball.model.json.player.stats.AbilityMixIn;
import com.bernardomg.tabletop.dreadball.model.json.player.stats.AffinityGroupMixIn;
import com.bernardomg.tabletop.dreadball.model.json.player.stats.AttributesMixIn;
import com.bernardomg.tabletop.dreadball.model.json.team.SponsorTeamMixIn;
import com.bernardomg.tabletop.dreadball.model.player.AffinityTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.stats.Ability;
import com.bernardomg.tabletop.dreadball.model.player.stats.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.player.stats.Attributes;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * Contains all the Jackson configuration needed to set up a JSON mapper for
 * Dreadball.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Component
public final class JsonDreadballModelModule extends SimpleModule {

    /**
     * Serialization id.
     */
    private static final long serialVersionUID = 1405374344133040810L;

    /**
     * Constructs the module with the specified parameters.
     */
    public JsonDreadballModelModule() {
        super();
    }

    @Override
    public final void setupModule(final SetupContext context) {
        super.setupModule(context);

        setupMixIns(context);
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

        // TeamPlayers
        context.setMixInAnnotations(TeamPlayer.class, TeamPlayerMixIn.class);
        context.setMixInAnnotations(AffinityTeamPlayer.class,
                AffinityTeamPlayerMixIn.class);

        // Availabilities
        context.setMixInAnnotations(SponsorAffinityGroupAvailability.class,
                SponsorAffinityGroupAvailabilityMixIn.class);
    }

}
