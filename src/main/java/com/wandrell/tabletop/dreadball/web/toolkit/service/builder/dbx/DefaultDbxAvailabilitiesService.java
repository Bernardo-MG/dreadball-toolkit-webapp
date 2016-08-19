
package com.wandrell.tabletop.dreadball.web.toolkit.service.builder.dbx;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.AffinityLevel;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.DefaultUnit;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.availability.SponsorAffinityGroupAvailabilityRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityUnitRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.rules.DbxRules;

@Service("dbxAvailabilitiesService")
public class DefaultDbxAvailabilitiesService
        implements DbxAvailabilitiesService {

    /**
     * Sponsor affinity groups availabilities repository.
     */
    private final SponsorAffinityGroupAvailabilityRepository affinityAvasRepository;

    /**
     * DBX rules.
     */
    private final DbxRules                                   rulesService;

    /**
     * Affinity units repository.
     */
    private final AffinityUnitRepository                     unitRepository;

    public DefaultDbxAvailabilitiesService(
            final SponsorAffinityGroupAvailabilityRepository affinityAvasRepo,
            final DbxRules rulesServ, final AffinityUnitRepository unitRepo) {
        super();

        affinityAvasRepository = checkNotNull(affinityAvasRepo,
                "Received a null pointer as affinity availabilities repository");
        rulesService = checkNotNull(rulesServ,
                "Received a null pointer as rules service");

        unitRepository = checkNotNull(unitRepo,
                "Received a null pointer as units repository");
    }

    @Override
    public final Iterable<? extends SponsorAffinityGroupAvailability>
            getSponsorAffinityGroups() {
        return getSponsorAffinityGroupAvailabilityRepository().findAll();
    }

    @Override
    public final Iterable<? extends Unit>
            getSponsorTeamAvailableUnits(final SponsorTeam team) {
        final Collection<Unit> units; // Available units
        Integer cost;                 // Unit cost
        Unit unit;                    // Available unit
        AffinityLevel affinityLevel;  // Affinity level relationship

        checkNotNull(team, "Received a null pointer as team");

        units = new LinkedList<Unit>();
        for (final AffinityUnit affUnit : getUnitRepository().findAll()) {
            affinityLevel = getDbxRulesService()
                    .getAffinityLevel(team.getSponsor(), affUnit);
            cost = getDbxRulesService().getUnitCost(affinityLevel, affUnit);

            // TODO: Move to the model service
            unit = new DefaultUnit(affUnit.getTemplateName(), cost,
                    affUnit.getRole(), affUnit.getAttributes(),
                    affUnit.getAbilities(), affUnit.getMvp(),
                    affUnit.getGiant());

            units.add(unit);
        }

        return units;
    }

    private final DbxRules getDbxRulesService() {
        return rulesService;
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
     * Returns the affinity unit repository.
     * 
     * @return the affinity unit repository
     */
    private final AffinityUnitRepository getUnitRepository() {
        return unitRepository;
    }

}
