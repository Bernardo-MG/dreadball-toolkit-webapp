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
public final class DefaultDbxTeamBuilder implements DbxTeamBuilder {

    /**
     * DBX rules service.
     */
    @Autowired
    private DbxRules               dbxRules;

    /**
     * Maximum number of units a Sponsor may have.
     */
    @Value("${sponsor.players.max}")
    private Integer                maxTeamUnits;

    /**
     * Message source.
     */
    @Autowired
    private MessageSource          messageSource;

    /**
     * DBX model factory
     */
    @Autowired
    private DbxModelFactory        modelFactory;

    /**
     * Affinity units repository.
     */
    @Autowired
    private AffinityUnitRepository unitRepository;

    /**
     * Creates a DBX team builder with the specified dependencies.
     */
    public DefaultDbxTeamBuilder() {
        super();
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

        affUnit = getAffinityUnitRepository().findByTemplateName(templateName);

        if (affUnit != null) {
            // TODO: Is this internationalization step really needed here?
            name = getMessageSource().getMessage(affUnit.getTemplateName(),
                    null, LocaleContextHolder.getLocale());
            affinityLevel = getDbxRules().getAffinityLevel(team.getSponsor(),
                    affUnit);
            cost = getDbxRules().getUnitCost(affinityLevel, affUnit);

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

    /**
     * Returns the affinity unit repository.
     * 
     * @return the affinity unit repository
     */
    private final AffinityUnitRepository getAffinityUnitRepository() {
        return unitRepository;
    }

    private final DbxModelFactory getDbxModelFactory() {
        return modelFactory;
    }

    private final DbxRules getDbxRules() {
        return dbxRules;
    }

    /**
     * Returns the message source.
     * 
     * @return the message source
     */
    private final MessageSource getMessageSource() {
        return messageSource;
    }

}
