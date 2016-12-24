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

package com.wandrell.tabletop.dreadball.build.dbx;

import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.Unit;

/**
 * Facade service for the DBX team builder.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface DbxSponsorBuilder {

    /**
     * Returns all the Sponsor affinity groups sets.
     * 
     * @return the Sponsor affinity groups sets
     */
    public Iterable<SponsorAffinityGroupAvailability>
            getAvailableAffinityGroups();

    /**
     * Returns all the units available for the specified Sponsor team.
     * 
     * @param affinities
     *            sponsor affinities
     * @return the units available to the Sponsor
     */
    public Iterable<Unit>
            getAvailableUnits(final Iterable<AffinityGroup> affinities);

    /**
     * Returns the initial rank.
     * 
     * @return the initial rank
     */
    public Integer getInitialRank();

    /**
     * Creates an Sponsor team from the specified Sponsor.
     * 
     * @param sponsor
     *            Sponsor for the team
     * @return a Sponsor team for the specified Sponsor
     */
    public SponsorTeam getSponsorTeam(final Sponsor sponsor);

}
