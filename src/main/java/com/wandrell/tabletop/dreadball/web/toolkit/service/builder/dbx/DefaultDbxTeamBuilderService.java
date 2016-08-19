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

package com.wandrell.tabletop.dreadball.web.toolkit.service.builder.dbx;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.AffinityLevel;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.DefaultUnit;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.web.toolkit.factory.DbxModelFactory;
import com.wandrell.tabletop.dreadball.web.toolkit.factory.DbxValuesFactory;
import com.wandrell.tabletop.dreadball.web.toolkit.model.form.SponsorForm;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityUnitRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.rules.DbxRules;

/**
 * Default implementation of the DBX team builder service.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Service("dbxTeamBuilderService")
public final class DefaultDbxTeamBuilderService
        implements DbxTeamBuilderService {

    /**
     * DBX availabilities service.
     */
    private final DbxAvailabilitiesService avasService;

    /**
     * Message source.
     */
    private final MessageSource            messageSource;

    /**
     * DBX model service
     */
    private final DbxModelFactory          modelService;

    /**
     * DBX rules service.
     */
    private final DbxRules                 rulesService;

    /**
     * Affinity units repository.
     */
    private final AffinityUnitRepository   unitRepository;

    /**
     * DBX values service.
     */
    private final DbxValuesFactory         valuesService;

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
    public DefaultDbxTeamBuilderService(final DbxRules rulesServ,
            final DbxModelFactory dbxModelServ,
            final DbxAvailabilitiesService avasServ,
            final AffinityUnitRepository unitRepo,
            final DbxValuesFactory valuesServ, final MessageSource ms) {
        super();

        rulesService = checkNotNull(rulesServ,
                "Received a null pointer as rules service");
        modelService = checkNotNull(dbxModelServ,
                "Received a null pointer as model service");
        avasService = checkNotNull(avasServ,
                "Received a null pointer as availabilities service");

        unitRepository = checkNotNull(unitRepo,
                "Received a null pointer as units repository");
        valuesService = checkNotNull(valuesServ,
                "Received a null pointer as units repository");

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

            // TODO: Move to the model service
            unit = new DefaultUnit(affUnit.getTemplateName(), cost,
                    affUnit.getRole(), affUnit.getAttributes(),
                    affUnit.getAbilities(), affUnit.getMvp(),
                    affUnit.getGiant());

            ((DefaultUnit) unit).setName(name);

            team.addPlayer(unit);
        }
    }

    @Override
    public final Integer getInitialRank() {
        return getDbxValuesService().getInitialRank();
    }

    @Override
    public final Integer getMaxTeamUnits() {
        return getDbxValuesService().getMaxTeamUnits();
    }

    @Override
    public final Sponsor getSponsor(final SponsorForm form) {
        return getDbxModelService().getSponsor(form);
    }

    @Override
    public final Iterable<? extends SponsorAffinityGroupAvailability>
            getSponsorAffinityGroups() {
        return getDbxAvailabilitiesService().getSponsorAffinityGroups();
    }

    @Override
    public final SponsorTeam getSponsorTeam(final Sponsor sponsor) {
        return getDbxModelService().getSponsorTeam(sponsor);
    }

    @Override
    public final Iterable<? extends Unit>
            getSponsorTeamAvailableUnits(final SponsorTeam team) {
        return getDbxAvailabilitiesService().getSponsorTeamAvailableUnits(team);
    }

    private final DbxAvailabilitiesService getDbxAvailabilitiesService() {
        return avasService;
    }

    private final DbxModelFactory getDbxModelService() {
        return modelService;
    }

    private final DbxRules getDbxRulesService() {
        return rulesService;
    }

    /**
     * Returns the DBX values service.
     * 
     * @return the DBX values service
     */
    private final DbxValuesFactory getDbxValuesService() {
        return valuesService;
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
