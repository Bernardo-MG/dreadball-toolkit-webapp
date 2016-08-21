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

package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.build.dbx.DbxTeamBuilder;
import com.wandrell.tabletop.dreadball.factory.DbxModelFactory;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.AffinityLevel;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.DefaultUnit;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.rules.DbxRules;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityUnitRepository;

/**
 * Default implementation of the DBX team builder service.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Service("dbxTeamBuilderService")
public final class DefaultDbxTeamBuilder
        implements DbxTeamBuilder {

    /**
     * Maximum number of units a Sponsor may have.
     */
    private final Integer                maxTeamUnits;

    /**
     * Message source.
     */
    private final MessageSource          messageSource;

    /**
     * DBX model factory
     */
    private final DbxModelFactory        modelFactory;

    /**
     * DBX rules service.
     */
    private final DbxRules               rulesService;

    /**
     * Affinity units repository.
     */
    private final AffinityUnitRepository unitRepository;

    /**
     * Creates a DBX team builder with the specified dependencies.
     * 
     * @param affinityAvasRepo
     *            sponsor affinity groups availabilities repository
     * @param affinitiesRepo
     *            affinity groups repository
     * @param unitRepo
     *            affinity units repository
     * @param valuesServ
     *            DBX values service
     * @param valorationCalc
     *            team valoration calculator
     * @param rankCalc
     *            rank cost calculator
     * @param ms
     *            message source
     */
    @Autowired
    public DefaultDbxTeamBuilder(final DbxRules rulesServ,
            final AffinityUnitRepository unitRepo,
            final DbxModelFactory dbxModelFact,
            @Value("${sponsor.players.max}") final Integer maxTeam,
            final MessageSource ms) {
        super();

        rulesService = checkNotNull(rulesServ,
                "Received a null pointer as rules service");

        unitRepository = checkNotNull(unitRepo,
                "Received a null pointer as units repository");
        modelFactory = checkNotNull(dbxModelFact,
                "Received a null pointer as model factory");

        maxTeamUnits = checkNotNull(maxTeam,
                "Received a null pointer as max team units");

        messageSource = checkNotNull(ms,
                "Received a null pointer as message source");
    }

    @Override
    public final void addUnit(final SponsorTeam team,
            final String templateName) {
        final AffinityUnit affUnit;  // Unit from the repository
        final Integer cost;          // Unit cost
        final Unit unit;             // Unit to add
        final String name;           // Unit name
        AffinityLevel affinityLevel; // Affinity level relationship

        checkNotNull(team, "Received a null pointer as team");
        checkNotNull(templateName, "Received a null pointer as template name");

        affUnit = getUnitRepository().findByTemplateName(templateName);

        if (affUnit != null) {
            // TODO: Is this internationalization step really needed here?
            name = getMessageSource().getMessage(affUnit.getTemplateName(),
                    null, LocaleContextHolder.getLocale());
            affinityLevel = getDbxRulesService()
                    .getAffinityLevel(team.getSponsor(), affUnit);
            cost = getDbxRulesService().getUnitCost(affinityLevel, affUnit);

            unit = getDbxModelFactory().getUnit(affUnit.getTemplateName(), cost,
                    affUnit.getRole(), affUnit.getAttributes(),
                    affUnit.getAbilities(), affUnit.getMvp(),
                    affUnit.getGiant());

            ((DefaultUnit) unit).setName(name);

            team.addPlayer(unit);
        }
    }

    @Override
    public final Integer getMaxTeamUnits() {
        return maxTeamUnits;
    }

    private final DbxModelFactory getDbxModelFactory() {
        return modelFactory;
    }

    private final DbxRules getDbxRulesService() {
        return rulesService;
    }

    /**
     * Returns the message source.
     * 
     * @return the message source
     */
    private final MessageSource getMessageSource() {
        return messageSource;
    }

    /**
     * Returns the affinity unit repository.
     * 
     * @return the affinity unit repository
     */
    private final AffinityUnitRepository getUnitRepository() {
        return unitRepository;
    }

}
