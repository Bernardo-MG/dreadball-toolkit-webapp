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

package com.wandrell.tabletop.dreadball.web.toolkit.service.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.RankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.DefaultUnit;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.web.toolkit.model.AffinityLevel;
import com.wandrell.tabletop.dreadball.web.toolkit.model.form.SponsorForm;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.availability.SponsorAffinityGroupAvailabilityRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityGroupRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityUnitRepository;

/**
 * Default implementation of the DBX team builder service.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Service("dbxTeamBuilderService")
public final class DefaultDbxTeamBuilderService
        implements DbxTeamBuilderService {

    /**
     * Sponsor affinity groups availabilities repository.
     */
    private final SponsorAffinityGroupAvailabilityRepository affinityAvasRepository;

    /**
     * Affinity groups repository.
     */
    private final AffinityGroupRepository                    affinitiesRepository;

    /**
     * Affinity units repository.
     */
    private final AffinityUnitRepository                     unitRepository;

    /**
     * DBX values service.
     */
    private final DbxValuesService                           valuesService;

    /**
     * Rank cost calculator.
     */
    private final RankCostCalculator                         rankCostCalculator;

    /**
     * Team valoration calculator.
     */
    private final TeamValorationCalculator<SponsorTeam>      valorationCalculator;

    /**
     * Message source.
     */
    private final MessageSource                              messageSource;

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
    public DefaultDbxTeamBuilderService(
            final SponsorAffinityGroupAvailabilityRepository affinityAvasRepo,
            final AffinityGroupRepository affinitiesRepo,
            final AffinityUnitRepository unitRepo,
            final DbxValuesService valuesServ,
            final TeamValorationCalculator<SponsorTeam> valorationCalc,
            final RankCostCalculator rankCalc, final MessageSource ms) {
        super();

        affinityAvasRepository = checkNotNull(affinityAvasRepo,
                "Received a null pointer as affinity availabilities repository");
        affinitiesRepository = checkNotNull(affinitiesRepo,
                "Received a null pointer as affinities repository");
        unitRepository = checkNotNull(unitRepo,
                "Received a null pointer as units repository");
        valuesService = checkNotNull(valuesServ,
                "Received a null pointer as units repository");
        valorationCalculator = checkNotNull(valorationCalc,
                "Received a null pointer as valoration calculator");
        rankCostCalculator = checkNotNull(rankCalc,
                "Received a null pointer as rank cost calculator");
        messageSource = checkNotNull(ms,
                "Received a null pointer as message source");
    }

    @Override
    public final void addUnit(final SponsorTeam team,
            final String templateName) {
        final AffinityUnit affUnit; // Unit from the repository
        final Integer cost;         // Unit cost
        final Unit unit;            // Unit to add
        final String name;          // Unit name

        affUnit = getUnitRepository().findByTemplateName(templateName);

        if (affUnit != null) {
            name = getMessageSource().getMessage(affUnit.getTemplateName(),
                    null, LocaleContextHolder.getLocale());
            cost = getUnitCost(team.getSponsor(), affUnit);

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
        final Sponsor sponsor;               // Created sponsor
        final Collection<String> affinities; // Affinities list

        sponsor = new DefaultSponsor();

        sponsor.setName(form.getSponsorName());

        sponsor.setRank(getInitialRank());

        // TODO: The affinities should come as a list
        // Loads affinities
        affinities = new LinkedList<String>();
        affinities.add(form.getAffinityA());
        affinities.add(form.getAffinityB());
        affinities.add(form.getAffinityC());
        affinities.add(form.getAffinityD());
        affinities.add(form.getAffinityE());

        // Searchs for rank increase tags
        while (affinities.contains("rank")) {
            sponsor.setRank(sponsor.getRank() + 1);
            affinities.remove("rank");
        }

        // Creates the affinities
        for (final String affinity : affinities) {
            sponsor.addAffinityGroup(
                    getAffinityGroupRepository().findByName(affinity));
        }

        return sponsor;
    }

    @Override
    public final Iterable<? extends SponsorAffinityGroupAvailability>
            getSponsorAffinityGroups() {
        return getSponsorAffinityGroupAvailabilityRepository().findAll();
    }

    @Override
    public final SponsorTeam getSponsorTeam(final Sponsor sponsor) {
        final SponsorTeam team; // Created team

        team = new DefaultSponsorTeam(sponsor,
                getSponsorTeamValorationCalculator(), getRankCostCalculator());

        return team;
    }

    @Override
    public final Iterable<? extends Unit>
            getSponsorTeamAvailableUnits(final SponsorTeam team) {
        final Collection<Unit> units; // Available units
        Integer cost;                 // Unit cost
        Unit unit;                    // Available unit

        units = new LinkedList<Unit>();
        for (final AffinityUnit repoUnit : getUnitRepository().findAll()) {
            cost = getUnitCost(team.getSponsor(), repoUnit);

            unit = new DefaultUnit(repoUnit.getTemplateName(), cost,
                    repoUnit.getRole(), repoUnit.getAttributes(),
                    repoUnit.getAbilities(), repoUnit.getMvp(),
                    repoUnit.getGiant());

            units.add(unit);
        }

        return units;
    }

    /**
     * Returns the affinity groups repository.
     * 
     * @return the affinity groups repository
     */
    private final AffinityGroupRepository getAffinityGroupRepository() {
        return affinitiesRepository;
    }

    /**
     * Returns the affinity level between a Sponsor and a unit.
     * 
     * @param sponsor
     *            Sponsor to find out the affinity level
     * @param unit
     *            unit to find out the affinity level
     * @return the affinity level between the Sponsor and the unit
     */
    private final AffinityLevel getAffinityLevel(final Sponsor sponsor,
            final AffinityUnit unit) {
        final AffinityLevel level; // Affinity level
        final Collection<AffinityGroup> sponsorAffinities; // Affinities
        Integer coincidences;      // Affinity coincidences

        sponsorAffinities = sponsor.getAffinityGroups();
        coincidences = 0;
        for (final AffinityGroup affinityGroup : unit.getAffinityGroups()) {
            if (sponsorAffinities.contains(affinityGroup)) {
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

    /**
     * Returns the DBX values service.
     * 
     * @return the DBX values service
     */
    private final DbxValuesService getDbxValuesService() {
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
     * Returns the rank cost calculator.
     * 
     * @return the rank cost calculator
     */
    private final RankCostCalculator getRankCostCalculator() {
        return rankCostCalculator;
    }

    /**
     * Returns the Sponsor affinity groups availabilities repository.
     * 
     * @return the Sponsor affinity groups availabilities repository
     */
    private final SponsorAffinityGroupAvailabilityRepository
            getSponsorAffinityGroupAvailabilityRepository() {
        return affinityAvasRepository;
    }

    /**
     * Returns the team valoration calculator.
     * 
     * @return the team valoration calculator
     */
    private final TeamValorationCalculator<SponsorTeam>
            getSponsorTeamValorationCalculator() {
        return valorationCalculator;
    }

    /**
     * Returns the unit cost.
     * 
     * @param sponsor
     *            Sponsor to find out the unit cost
     * @param unit
     *            unt to find out the cost
     * @return the cost of the unit for the Sponsor
     */
    private final Integer getUnitCost(final Sponsor sponsor,
            final AffinityUnit unit) {
        final AffinityLevel affinityLevel; // Affinity level
        final Integer cost;                // Unit cost

        affinityLevel = getAffinityLevel(sponsor, unit);

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

    /**
     * Returns the affinity unit repository.
     * 
     * @return the affinity unit repository
     */
    private final AffinityUnitRepository getUnitRepository() {
        return unitRepository;
    }

}
