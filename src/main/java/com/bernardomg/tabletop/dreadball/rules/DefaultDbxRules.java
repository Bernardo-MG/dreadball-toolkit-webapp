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

package com.bernardomg.tabletop.dreadball.rules;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bernardomg.tabletop.dreadball.model.player.AffinityLevel;
import com.bernardomg.tabletop.dreadball.model.player.AffinityTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.stats.AffinityGroup;

/**
 * Default implementation of the DBX rules service.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public class DefaultDbxRules implements DbxRules {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(DefaultDbxRules.class);

    /**
     * Default constructor.
     */
    public DefaultDbxRules() {
        super();
    }

    @Override
    public final AffinityLevel getAffinityLevel(final AffinityTeamPlayer player,
            final Iterable<? extends AffinityGroup> affinities) {
        final AffinityLevel level; // Affinity level
        final Set<String> affs;    // TeamPlayer affinities
        Integer matches;      // Affinity coincidences

        checkNotNull(affinities, "Received a null pointer as affinities");
        checkNotNull(player, "Received a null pointer as player");

        LOGGER.debug("Calculating affinity level for {}",
                player.getTemplateName());

        matches = 0;
        affs = player.getAffinityGroups().stream().map(AffinityGroup::getName)
                .collect(Collectors.toSet());
        for (final AffinityGroup affinityGroup : affinities) {
            if (affs.contains(affinityGroup.getName())) {
                matches++;
            }
        }

        if (matches >= 2) {
            level = AffinityLevel.FRIEND;
        } else if (matches == 1) {
            level = AffinityLevel.ALLY;
        } else {
            level = AffinityLevel.STRANGER;
        }

        LOGGER.debug("Affinity matches: {}", matches);
        LOGGER.debug("Affinity level: {}", level);

        return level;
    }

    @Override
    public final Integer getTeamPlayerCost(final AffinityLevel affinityLevel,
            final AffinityTeamPlayer player) {
        final Integer cost;                // TeamPlayer cost

        checkNotNull(affinityLevel,
                "Received a null pointer as affinity level");
        checkNotNull(player, "Received a null pointer as player");

        LOGGER.debug("Calculating cost for {}", player.getTemplateName());
        LOGGER.debug("Affinity level: {}", affinityLevel);

        switch (affinityLevel) {
            case FRIEND:
                cost = player.getFriendCost();
                break;
            case ALLY:
                cost = player.getAllyCost();
                break;
            default:
                cost = player.getStrangerCost();
                break;
        }

        LOGGER.debug("Cost: {}", cost);

        return cost;
    }

}
