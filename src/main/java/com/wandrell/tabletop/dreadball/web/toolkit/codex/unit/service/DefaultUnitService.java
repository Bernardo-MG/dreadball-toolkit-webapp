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

package com.wandrell.tabletop.dreadball.web.toolkit.codex.unit.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.AffinityLevel;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.DefaultUnit;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.repository.availability.SponsorAffinityGroupAvailabilityRepository;
import com.wandrell.tabletop.dreadball.repository.unit.AffinityUnitRepository;
import com.wandrell.tabletop.dreadball.rules.DbxRules;

/**
 * Default implementation of the unit codex service.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Service("unitService")
public final class DefaultUnitService implements UnitService {

    /**
     * Affinity units repository.
     */
    private final AffinityUnitRepository affinityUnitRepository;

    /**
     * DBX rules.
     */
    private final DbxRules               dbxRules;

    /**
     * Constructs a service with the specified arguments.
     */
    public DefaultUnitService(final AffinityUnitRepository repository,
            final DbxRules rules,
            final SponsorAffinityGroupAvailabilityRepository affinityAvasRepo) {
        super();

        affinityUnitRepository = checkNotNull(repository,
                "Received a null pointer as affinity units repository");
        dbxRules = checkNotNull(rules,
                "Received a null pointer as rules service");
    }

    @Override
    public final Iterable<? extends Unit> getAllAffinityUnits(
            final Iterable<? extends AffinityGroup> affinities,
            final Pageable pageReq) {
        final Collection<Unit> units;          // Available units
        final Iterable<? extends AffinityUnit> filtered; // Filtered units

        checkNotNull(affinities, "Received a null pointer as affinities");
        checkNotNull(pageReq, "Received a null pointer as pagination data");

        // Only units not hating any affinity are acquired
        filtered = getUnitsNotHatingAffinities(affinities, pageReq);

        // The received units are adapted and configured
        units = new ArrayList<>();
        for (final AffinityUnit affUnit : filtered) {
            units.add(generateUnit(affUnit, affinities));
        }

        return units;
    }

    @Override
    public final Unit getUnit(final String templateName,
            final Iterable<AffinityGroup> affinities) {
        final AffinityUnit affUnit;  // Unit from the repository
        final Unit unit;             // Unit to add

        checkNotNull(templateName, "Received a null pointer as template name");
        checkNotNull(affinities, "Received a null pointer as affinities");

        affUnit = getAffinityUnitRepository()
                .findOneByTemplateName(templateName);

        if (affUnit != null) {
            unit = generateUnit(affUnit, affinities);
        } else {
            unit = null;
        }

        return unit;
    }

    private final Unit generateUnit(final AffinityUnit affUnit,
            final Iterable<? extends AffinityGroup> affinities) {
        final Integer cost; // Unit cost
        final DefaultUnit unit;

        cost = getUnitCost(affUnit, affinities);

        unit = new DefaultUnit(affUnit.getTemplateName(), cost,
                affUnit.getRole(), affUnit.getAttributes(),
                affUnit.getAbilities(), affUnit.getMvp(), affUnit.getGiant());
        unit.setName(affUnit.getName());

        return unit;
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

    private final Iterable<? extends AffinityUnit> getUnitsNotHatingAffinities(
            final Iterable<? extends AffinityGroup> affinities,
            final Pageable pageReq) {
        final Iterable<? extends AffinityUnit> filtered; // Filtered units
        final Collection<String> affNames;     // Affinity names
        final Collection<AffinityGroup> affs;     // Affinity names

        // The affinities names are acquired
        affs = new ArrayList<>();
        affinities.iterator().forEachRemaining(affs::add);
        affNames = affs.stream().map(a -> a.getName())
                .collect(Collectors.toList());

        if (affNames.isEmpty()) {
            // There are no affinities, there is no need to filter
            filtered = getAffinityUnitRepository().findAll(pageReq);
        } else {
            // Only units not hating any affinity are acquired
            filtered = getAffinityUnitRepository()
                    .findAllFilteredByHatedAffinities(affNames, pageReq);
        }

        return filtered;
    }

}
