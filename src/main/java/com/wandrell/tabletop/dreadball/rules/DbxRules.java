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

package com.wandrell.tabletop.dreadball.rules;

import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.AffinityLevel;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;

/**
 * Rules for the DBX team builder.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface DbxRules {

    /**
     * Returns the affinity level for a unit and a specific group of affinities.
     * <p>
     * The number of affinities from the list owned by the unit will mark the
     * affinity level.
     * 
     * @param unit
     *            unit to find out the affinity level
     * @param affinities
     *            affinities to find out the affinity level
     * @return the affinity level between the Sponsor and the unit
     */
    public AffinityLevel getAffinityLevel(final AffinityUnit unit,
            final Iterable<AffinityGroup> affinities);

    /**
     * Returns the unit cost.
     * 
     * @param affinityLevel
     *            affinity level to search the cost for
     * @param unit
     *            unit to find out the cost
     * @return the cost of the unit for the affinity level
     */
    public Integer getUnitCost(final AffinityLevel affinityLevel,
            final AffinityUnit unit);

}
