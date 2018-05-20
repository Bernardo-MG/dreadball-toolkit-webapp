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

package com.bernardomg.tabletop.dreadball.build.service;

import java.util.Collection;

import org.springframework.data.domain.Pageable;

import com.bernardomg.tabletop.dreadball.model.OptionGroup;
import com.bernardomg.tabletop.dreadball.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.model.SponsorTeamSelection;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.stats.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;

/**
 * Service for building Sponsor teams.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public interface SponsorBuilderService {

    /**
     * Returns all the affinities available to a Sponsor.
     * <p>
     * These will be stored into options, allowing these affinities to be
     * selectable.
     * 
     * @return all the affinities available to a Sponsor
     */
    public Collection<OptionGroup> getAffinityOptions();

    /**
     * Returns all the players available to a Sponsor.
     * 
     * @param affinities
     *            sponsor affinities
     * @param pageable
     *            pagination data
     * @return all the players available to a Sponsor
     */
    public Iterable<? extends TeamPlayer> getTeamPlayerOptions(
            final Collection<? extends AffinityGroup> affinities,
            final Pageable pageable);

    /**
     * Validates a set of Sponsor affinities.
     * <p>
     * This is meant to be used for validating the affinities selected when
     * creating a Sponsor.
     * <p>
     * The valid affinities are returned inside a new object.
     * 
     * @param affinities
     *            affinities to validate
     * @return the valid affinities
     */
    public SponsorAffinities
            validateSponsorAffinities(final Collection<String> affinities);

    /**
     * Validates a team.
     * <p>
     * This is meant for validating the team while building it.
     * 
     * @param selection
     *            the team values
     * @return a valid team
     */
    public SponsorTeam validateTeam(final SponsorTeamSelection selection);

}
