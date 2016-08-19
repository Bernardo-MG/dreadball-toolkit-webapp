
package com.wandrell.tabletop.dreadball.web.toolkit.service.builder.dbx;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.LinkedList;

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
import com.wandrell.tabletop.dreadball.web.toolkit.repository.availability.SponsorAffinityGroupAvailabilityRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityUnitRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.rules.DbxRules;

@Service("dbxSponsorCreationService")
public class DefaultDbxSponsorCreationService
        implements DbxSponsorCreationService {

    /**
     * Sponsor affinity groups availabilities repository.
     */
    private final SponsorAffinityGroupAvailabilityRepository affinityAvasRepository;

    /**
     * DBX model service
     */
    private final DbxModelFactory                            modelService;

    /**
     * DBX rules.
     */
    private final DbxRules                                   rulesService;

    /**
     * Affinity units repository.
     */
    private final AffinityUnitRepository                     unitRepository;

    /**
     * DBX values service.
     */
    private final DbxValuesFactory                           valuesService;

    public DefaultDbxSponsorCreationService(
            final AffinityUnitRepository unitRepo,
            final SponsorAffinityGroupAvailabilityRepository affinityAvasRepo,
            final DbxRules rulesServ, final DbxModelFactory dbxModelServ,
            final DbxValuesFactory valuesServ) {
        super();

        unitRepository = checkNotNull(unitRepo,
                "Received a null pointer as units repository");
        affinityAvasRepository = checkNotNull(affinityAvasRepo,
                "Received a null pointer as affinity availabilities repository");

        rulesService = checkNotNull(rulesServ,
                "Received a null pointer as rules service");
        modelService = checkNotNull(dbxModelServ,
                "Received a null pointer as model factory");
        valuesService = checkNotNull(valuesServ,
                "Received a null pointer as units factory");
    }

    @Override
    public final Integer getInitialRank() {
        return getDbxValuesService().getInitialRank();
    }

    @Override
    public final Sponsor getSponsor(final SponsorForm form) {
        return getDbxModelService().getSponsor(form);
    }

    @Override
    public final Iterable<? extends SponsorAffinityGroupAvailability>
            getSponsorAffinityGroups() {
        return getSponsorAffinityGroupAvailabilityRepository().findAll();
    }

    @Override
    public final SponsorTeam getSponsorTeam(final Sponsor sponsor) {
        return getDbxModelService().getSponsorTeam(sponsor);
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
