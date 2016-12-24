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

package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.build.dbx.DbxTeamBuilder;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.Unit;

/**
 * Default implementation of the DBX team builder service.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Service("dbxTeamBuilderService")
public final class DefaultDbxTeamBuilder implements DbxTeamBuilder {

    /**
     * Maximum number of units a Sponsor may have.
     */
    private final Integer maxTeamUnits;

    /**
     * Maximum recommended team valoration.
     */
    private final Integer maxTeamValoration;

    /**
     * Minimum number of units a Sponsor may have.
     */
    private final Integer minTeamUnits;

    /**
     * Minimum team valoration.
     */
    private final Integer minTeamValoration;

    /**
     * Creates a DBX team builder with the specified dependencies.
     * 
     * @param modelFact
     *            model factory
     * @param rules
     *            rules service
     * @param unitRepo
     *            units repository
     * @param maxUnits
     *            maximum allowed units
     */
    @Autowired
    public DefaultDbxTeamBuilder(
            @Value("${sponsor.players.min}") final Integer minUnits,
            @Value("${sponsor.players.max}") final Integer maxUnits,
            @Value("${sponsor.team.valoration.min}") final Integer minValoration,
            @Value("${sponsor.team.valoration.max}") final Integer maxValoration) {
        super();

        minTeamUnits = checkNotNull(minUnits,
                "Received a null pointer as team units minimum");
        maxTeamUnits = checkNotNull(maxUnits,
                "Received a null pointer as team units maximum");

        minTeamValoration = checkNotNull(minValoration,
                "Received a null pointer as maximum valoration");
        maxTeamValoration = checkNotNull(maxValoration,
                "Received a null pointer as minimum valoration");
    }

    @Override
    public final void addPlayer(final SponsorTeam team, final Unit unit) {
        final Boolean unique;
        final Iterator<Unit> units;
        Boolean uniqueFound;

        if ((unit.getGiant()) || (unit.getMvp())) {
            unique = true;
        } else {
            unique = false;
        }

        if (unique) {
            uniqueFound = false;
            units = team.getPlayers().values().iterator();
            while ((!uniqueFound) && (units.hasNext())) {
                uniqueFound = units.next().getTemplateName()
                        .equals(unit.getTemplateName());
            }

            if (!uniqueFound) {
                team.addPlayer(unit);
            }
        } else {
            team.addPlayer(unit);
        }
    }

    @Override
    public final Integer getMaxTeamUnits() {
        return maxTeamUnits;
    }

    @Override
    public final Integer getMaxTeamValoration() {
        return maxTeamValoration;
    }

    @Override
    public final Integer getMinTeamUnits() {
        return minTeamUnits;
    }

    @Override
    public final Integer getMinTeamValoration() {
        return minTeamValoration;
    }

}
