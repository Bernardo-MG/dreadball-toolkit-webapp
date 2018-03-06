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

import com.bernardomg.tabletop.dreadball.model.player.AffinityLevel;
import com.bernardomg.tabletop.dreadball.model.player.AffinityTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.stats.AffinityGroup;

/**
 * Rules for the DBX team builder.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface DbxRules {

    /**
     * Returns the affinity level for a player and a specific group of
     * affinities.
     * <p>
     * The number of affinities from the list owned by the player will mark the
     * affinity level.
     * 
     * @param player
     *            player to find out the affinity level
     * @param affinities
     *            affinities to find out the affinity level
     * @return the affinity level between the Sponsor and the player
     */
    public AffinityLevel getAffinityLevel(final AffinityTeamPlayer player,
            final Iterable<? extends AffinityGroup> affinities);

    /**
     * Returns the player cost.
     * 
     * @param affinityLevel
     *            affinity level to search the cost for
     * @param player
     *            player to find out the cost
     * @return the cost of the player for the affinity level
     */
    public Integer getTeamPlayerCost(final AffinityLevel affinityLevel,
            final AffinityTeamPlayer player);

}
