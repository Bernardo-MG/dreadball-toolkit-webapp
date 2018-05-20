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

package com.bernardomg.tabletop.dreadball.rules;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Service implementation of the {@code SponsorConstraints}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Component("SponsorConstraints")
public final class AutowiredSponsorConstraints implements SponsorConstraints {

    /**
     * Maximum number of players a Sponsor may have.
     */
    private final Integer maxTeamPlayers;

    /**
     * Maximum recommended team valoration.
     */
    private final Integer maxTeamValoration;

    /**
     * Minimum number of players a Sponsor may have.
     */
    private final Integer minTeamPlayers;

    /**
     * Minimum team valoration.
     */
    private final Integer minTeamValoration;

    /**
     * Creates a DBX team builder with the specified dependencies.
     * 
     * 
     * @param minPlayers
     *            minimum allowed players
     * @param maxPlayers
     *            maximum allowed players
     * @param minValoration
     *            minimum allowed valoration
     * @param maxValoration
     *            maximum allowed valoration
     */
    @Autowired
    public AutowiredSponsorConstraints(
            @Value("${sponsor.players.min}") final Integer minPlayers,
            @Value("${sponsor.players.max}") final Integer maxPlayers,
            @Value("${sponsor.team.valoration.min}") final Integer minValoration,
            @Value("${sponsor.team.valoration.max}") final Integer maxValoration) {
        super();

        minTeamPlayers = checkNotNull(minPlayers,
                "Received a null pointer as team players minimum");
        maxTeamPlayers = checkNotNull(maxPlayers,
                "Received a null pointer as team players maximum");

        minTeamValoration = checkNotNull(minValoration,
                "Received a null pointer as maximum valoration");
        maxTeamValoration = checkNotNull(maxValoration,
                "Received a null pointer as minimum valoration");
    }

    @Override
    public final Integer getMaxTeamPlayers() {
        return maxTeamPlayers;
    }

    @Override
    public final Integer getMaxTeamValoration() {
        return maxTeamValoration;
    }

    @Override
    public final Integer getMinTeamPlayers() {
        return minTeamPlayers;
    }

    @Override
    public final Integer getMinTeamValoration() {
        return minTeamValoration;
    }

}
