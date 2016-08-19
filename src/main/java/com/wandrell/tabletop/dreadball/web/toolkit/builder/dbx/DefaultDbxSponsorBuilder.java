
package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.AffinityLevel;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.web.toolkit.factory.DbxModelFactory;
import com.wandrell.tabletop.dreadball.web.toolkit.model.form.SponsorForm;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.availability.SponsorAffinityGroupAvailabilityRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityUnitRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.rules.DbxRules;

@Service("dbxSponsorCreationService")
public class DefaultDbxSponsorBuilder
        implements DbxSponsorBuilder {

    /**
     * Sponsor affinity groups availabilities repository.
     */
    private final SponsorAffinityGroupAvailabilityRepository affinityAvasRepository;

    /**
     * Initial rank.
     */
    private final Integer                                    initialRank;

    /**
     * DBX model factory
     */
    private final DbxModelFactory                            modelFactory;

    /**
     * DBX rules.
     */
    private final DbxRules                                   rulesService;

    /**
     * Affinity units repository.
     */
    private final AffinityUnitRepository                     unitRepository;

    public DefaultDbxSponsorBuilder(
            final AffinityUnitRepository unitRepo,
            final SponsorAffinityGroupAvailabilityRepository affinityAvasRepo,
            @Value("${sponsor.rank.initial}") final Integer rank,
            final DbxRules rulesServ, final DbxModelFactory dbxModelFact) {
        super();

        unitRepository = checkNotNull(unitRepo,
                "Received a null pointer as units repository");
        affinityAvasRepository = checkNotNull(affinityAvasRepo,
                "Received a null pointer as affinity availabilities repository");

        initialRank = checkNotNull(rank,
                "Received a null pointer as initial rank");

        rulesService = checkNotNull(rulesServ,
                "Received a null pointer as rules service");
        modelFactory = checkNotNull(dbxModelFact,
                "Received a null pointer as model factory");
    }

    @Override
    public final Integer getInitialRank() {
        return initialRank;
    }

    @Override
    public final Sponsor getSponsor(final SponsorForm form) {
        return getDbxModelFactory().getSponsor(form);
    }

    @Override
    public final Iterable<? extends SponsorAffinityGroupAvailability>
            getSponsorAffinityGroups() {
        return getSponsorAffinityGroupAvailabilityRepository().findAll();
    }

    @Override
    public final SponsorTeam getSponsorTeam(final Sponsor sponsor) {
        return getDbxModelFactory().getSponsorTeam(sponsor);
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

            unit = getDbxModelFactory().getUnit(affUnit.getTemplateName(), cost,
                    affUnit.getRole(), affUnit.getAttributes(),
                    affUnit.getAbilities(), affUnit.getMvp(),
                    affUnit.getGiant());

            units.add(unit);
        }

        return units;
    }

    private final DbxModelFactory getDbxModelFactory() {
        return modelFactory;
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
