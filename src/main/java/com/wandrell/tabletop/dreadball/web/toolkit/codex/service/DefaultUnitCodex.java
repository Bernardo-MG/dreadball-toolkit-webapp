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

package com.wandrell.tabletop.dreadball.web.toolkit.codex.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.codex.UnitCodex;
import com.wandrell.tabletop.dreadball.factory.DbxModelFactory;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.AffinityLevel;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.rules.DbxRules;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.availability.SponsorAffinityGroupAvailabilityRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityUnitRepository;

/**
 * Default implementation of the unit codex service.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Service("unitCodexService")
public final class DefaultUnitCodex implements UnitCodex {

    /**
     * Affinity units repository.
     */
    private final AffinityUnitRepository affinityUnitRepository;

    /**
     * DBX model factory.
     */
    private final DbxModelFactory        dbxModelFact;

    /**
     * DBX rules.
     */
    private final DbxRules               dbxRules;

    /**
     * Constructs a service with the specified arguments.
     */
    public DefaultUnitCodex(final AffinityUnitRepository repository,
            final DbxModelFactory modelFact, final DbxRules rules,
            final SponsorAffinityGroupAvailabilityRepository affinityAvasRepo) {
        super();

        affinityUnitRepository = checkNotNull(repository,
                "Received a null pointer as affinity units repository");
        dbxModelFact = checkNotNull(modelFact,
                "Received a null pointer as model factory");
        dbxRules = checkNotNull(rules,
                "Received a null pointer as rules service");
    }

    @Override
    public final Iterable<AffinityUnit> getAllAffinityUnits() {
        final Collection<AffinityUnit> units;

        // TODO: There may be a better way to do this
        units = new ArrayList<>();
        for (final AffinityUnit unit : getAffinityUnitRepository().findAll()) {
            units.add(unit);
        }

        return units;
    }

    @Override
    public final Iterable<Unit> getAllAffinityUnits(
            final Iterable<? extends AffinityGroup> affinities) {
        final Collection<Unit> units;          // Available units
        final Iterable<? extends AffinityUnit> filtered; // Filtered units

        checkNotNull(affinities, "Received a null pointer as affinities");

        // Only units not hating any affinity are acquired
        filtered = getUnitsFilteredByAffinities(affinities);

        // The received units are adapted and configured
        units = new ArrayList<>();
        for (final AffinityUnit affUnit : filtered) {
            units.add(generateUnit(affUnit, affinities));
        }

        return units;
    }

    private final Unit generateUnit(final AffinityUnit affUnit,
            final Iterable<? extends AffinityGroup> affinities) {
        final Integer cost; // Unit cost

        cost = getUnitCost(affUnit, affinities);

        return getDbxModelFactory().getUnit(affUnit.getTemplateName(),
                affUnit.getName(), cost, affUnit.getRole(),
                affUnit.getAttributes(), affUnit.getAbilities(),
                affUnit.getMvp(), affUnit.getGiant());
    }

    /**
     * Returns the affinity unit repository.
     * 
     * @return the affinity unit repository
     */
    private final AffinityUnitRepository getAffinityUnitRepository() {
        return affinityUnitRepository;
    }

    /**
     * Returns the model factory.
     * 
     * @return the model factory
     */
    private final DbxModelFactory getDbxModelFactory() {
        return dbxModelFact;
    }

    /**
     * Returns the DBX rules.
     * 
     * @return the DBX rules
     */
    private final DbxRules getDbxRules() {
        return dbxRules;
    }

    /**
     * Returns the actual cost for a unit for a sponsor.
     * 
     * @param unit
     *            unit to find the cost for
     * @param affinities
     *            sponsor affinities
     * @return the cost of the unit for the sponsor
     */
    private final Integer getUnitCost(final AffinityUnit unit,
            final Iterable<? extends AffinityGroup> affinities) {
        final AffinityLevel affinityLevel;  // Affinity level relationship

        affinityLevel = getDbxRules().getAffinityLevel(unit, affinities);

        return getDbxRules().getUnitCost(affinityLevel, unit);
    }

    private final Iterable<? extends AffinityUnit> getUnitsFilteredByAffinities(
            final Iterable<? extends AffinityGroup> affinities) {
        final Iterable<? extends AffinityUnit> filtered; // Filtered units
        final Collection<String> affNames;     // Affinity names

        // The affinities names are acquired
        affNames = new ArrayList<>();
        for (final AffinityGroup affinity : affinities) {
            affNames.add(affinity.getName());
        }

        if (affNames.isEmpty()) {
            // There are no affinities, there is no need to filter
            filtered = getAffinityUnitRepository().findAll();
        } else {
            // Only units not hating any affinity are acquired
            filtered = getAffinityUnitRepository()
                    .findAllFilteredByHatedAffinities(affNames);
        }

        return filtered;
    }

}
