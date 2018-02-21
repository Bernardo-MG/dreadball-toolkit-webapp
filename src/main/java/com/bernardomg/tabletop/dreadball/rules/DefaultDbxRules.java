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

import com.bernardomg.tabletop.dreadball.model.unit.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityLevel;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityUnit;

/**
 * Default implementation of the DBX rules service.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public class DefaultDbxRules implements DbxRules {

    /**
     * Default constructor.
     */
    public DefaultDbxRules() {
        super();
    }

    @Override
    public final AffinityLevel getAffinityLevel(final AffinityUnit unit,
            final Iterable<? extends AffinityGroup> affinities) {
        final AffinityLevel level; // Affinity level
        final Set<String> affs;    // Unit affinities
        Integer coincidences;      // Affinity coincidences

        checkNotNull(affinities, "Received a null pointer as affinities");
        checkNotNull(unit, "Received a null pointer as unit");

        coincidences = 0;
        affs = unit.getAffinityGroups().stream().map(AffinityGroup::getName)
                .collect(Collectors.toSet());
        for (final AffinityGroup affinityGroup : affinities) {
            if (affs.contains(affinityGroup.getName())) {
                coincidences++;
            }
        }

        if (coincidences >= 2) {
            level = AffinityLevel.FRIEND;
        } else if (coincidences == 1) {
            level = AffinityLevel.ALLY;
        } else {
            level = AffinityLevel.STRANGER;
        }

        return level;
    }

    @Override
    public final Integer getUnitCost(final AffinityLevel affinityLevel,
            final AffinityUnit unit) {
        final Integer cost;                // Unit cost

        checkNotNull(affinityLevel,
                "Received a null pointer as affinity level");
        checkNotNull(unit, "Received a null pointer as unit");

        switch (affinityLevel) {
            case FRIEND:
                cost = unit.getFriendCost();
                break;
            case ALLY:
                cost = unit.getAllyCost();
                break;
            default:
                cost = unit.getStrangerCost();
                break;
        }

        return cost;
    }

}
