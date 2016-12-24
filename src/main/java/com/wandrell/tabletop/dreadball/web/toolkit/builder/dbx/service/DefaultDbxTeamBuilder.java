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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.build.dbx.DbxTeamBuilder;
import com.wandrell.tabletop.dreadball.factory.DbxModelFactory;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.AffinityLevel;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.rules.DbxRules;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityUnitRepository;

/**
 * Default implementation of the DBX team builder service.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Service("dbxTeamBuilderService")
public final class DefaultDbxTeamBuilder implements DbxTeamBuilder {

    /**
     * DBX rules service.
     */
    private final DbxRules               dbxRules;

    /**
     * Maximum number of units a Sponsor may have.
     */
    private final Integer                maxTeamUnits;

    /**
     * Maximum recommended team valoration.
     */
    private final Integer                maxTeamValoration;

    /**
     * Minimum number of units a Sponsor may have.
     */
    private final Integer                minTeamUnits;

    /**
     * Minimum team valoration.
     */
    private final Integer                minTeamValoration;

    /**
     * DBX model factory.
     */
    private final DbxModelFactory        modelFactory;

    /**
     * Affinity units repository.
     */
    private final AffinityUnitRepository unitRepository;

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
    public DefaultDbxTeamBuilder(final DbxModelFactory modelFact,
            final DbxRules rules, final AffinityUnitRepository unitRepo,
            @Value("${sponsor.players.min}") final Integer minUnits,
            @Value("${sponsor.players.max}") final Integer maxUnits,
            @Value("${sponsor.team.valoration.min}") final Integer minValoration,
            @Value("${sponsor.team.valoration.max}") final Integer maxValoration) {
        super();

        modelFactory = checkNotNull(modelFact,
                "Received a null pointer as model factory");
        dbxRules = checkNotNull(rules,
                "Received a null pointer as rules service");

        unitRepository = checkNotNull(unitRepo,
                "Received a null pointer as units repository");

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

    @Override
    public final Unit getUnit(final String templateName,
            final Iterable<AffinityGroup> affinities) {
        final AffinityUnit affUnit;  // Unit from the repository
        final Integer cost;          // Unit cost
        final Unit unit;             // Unit to add
        AffinityLevel affinityLevel; // Affinity level relationship

        checkNotNull(templateName, "Received a null pointer as template name");
        checkNotNull(affinities, "Received a null pointer as affinities");

        affUnit = getAffinityUnitRepository()
                .findOneByTemplateName(templateName);

        if (affUnit != null) {
            affinityLevel = getDbxRules().getAffinityLevel(affUnit, affinities);
            cost = getDbxRules().getUnitCost(affinityLevel, affUnit);

            unit = getDbxModelFactory().getUnit(affUnit.getTemplateName(), cost,
                    affUnit.getRole(), affUnit.getAttributes(),
                    affUnit.getAbilities(), affUnit.getMvp(),
                    affUnit.getGiant());
        } else {
            unit = null;
        }

        return unit;
    }

    /**
     * Returns the affinity unit repository.
     * 
     * @return the affinity unit repository
     */
    private final AffinityUnitRepository getAffinityUnitRepository() {
        return unitRepository;
    }

    /**
     * Returns the DBX model factory.
     * 
     * @return the DBX model factory
     */
    private final DbxModelFactory getDbxModelFactory() {
        return modelFactory;
    }

    /**
     * Returns the DBX rules.
     * 
     * @return the DBX rules
     */
    private final DbxRules getDbxRules() {
        return dbxRules;
    }

}
