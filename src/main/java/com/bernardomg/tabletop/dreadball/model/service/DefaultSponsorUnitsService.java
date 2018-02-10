
package com.bernardomg.tabletop.dreadball.model.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bernardomg.tabletop.dreadball.model.unit.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityLevel;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityUnit;
import com.bernardomg.tabletop.dreadball.model.unit.DefaultUnit;
import com.bernardomg.tabletop.dreadball.model.unit.Unit;
import com.bernardomg.tabletop.dreadball.repository.availability.SponsorAffinityGroupAvailabilityRepository;
import com.bernardomg.tabletop.dreadball.repository.unit.AffinityUnitRepository;
import com.bernardomg.tabletop.dreadball.rules.DbxRules;

@Service
public class DefaultSponsorUnitsService implements SponsorUnitsService {

    /**
     * Affinity units repository.
     */
    private final AffinityUnitRepository affinityUnitRepository;

    /**
     * DBX rules.
     */
    private final DbxRules               dbxRules;

    @Autowired
    public DefaultSponsorUnitsService(final AffinityUnitRepository repository,
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
        final List<Unit> units;          // Available units
        final Page<? extends AffinityUnit> filtered; // Filtered units

        checkNotNull(affinities, "Received a null pointer as affinities");
        checkNotNull(pageReq, "Received a null pointer as pagination data");

        // Only units not hating any affinity are acquired
        filtered = getUnitsNotHatingAffinities(affinities, pageReq);

        // The received units are adapted and configured
        units = new ArrayList<>();
        for (final AffinityUnit affUnit : filtered) {
            units.add(generateUnit(affUnit, affinities));
        }

        return new PageImpl<>(units, pageReq, filtered.getTotalElements());
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

    private final Page<? extends AffinityUnit> getUnitsNotHatingAffinities(
            final Iterable<? extends AffinityGroup> affinities,
            final Pageable pageReq) {
        final Page<? extends AffinityUnit> filtered; // Filtered units
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
