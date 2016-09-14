
package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.build.dbx.DbxSponsorBuilder;
import com.wandrell.tabletop.dreadball.factory.DbxModelFactory;
import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.AffinityLevel;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.rules.DbxRules;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorForm;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.availability.SponsorAffinityGroupAvailabilityRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityUnitRepository;

@Service("dbxSponsorCreationService")
public class DefaultDbxSponsorBuilder implements DbxSponsorBuilder {

    /**
     * Sponsor affinity groups availabilities repository.
     */
    private final SponsorAffinityGroupAvailabilityRepository affinityAvasRepository;

    /**
     * DBX model factory
     */
    private final DbxModelFactory                            dbxModelFact;

    /**
     * DBX rules.
     */
    private final DbxRules                                   dbxRules;

    /**
     * Initial rank.
     */
    @Value("${sponsor.rank.initial}")
    private final Integer                                    initialRank;

    /**
     * Affinity units repository.
     */
    private final AffinityUnitRepository                     unitRepository;

    @Autowired
    public DefaultDbxSponsorBuilder(final DbxModelFactory modelFact,
            final DbxRules rules,
            final SponsorAffinityGroupAvailabilityRepository affinityAvasRepo,
            final AffinityUnitRepository unitRepo,
            @Value("${sponsor.rank.initial}") final Integer rank) {
        super();

        dbxModelFact = checkNotNull(modelFact,
                "Received a null pointer as model factory");
        dbxRules = checkNotNull(rules,
                "Received a null pointer as rules service");

        affinityAvasRepository = checkNotNull(affinityAvasRepo,
                "Received a null pointer as affinities availabilities repository");
        unitRepository = checkNotNull(unitRepo,
                "Received a null pointer as units repository");

        initialRank = checkNotNull(rank,
                "Received a null pointer as initial rank");
    }

    @Override
    public final Iterable<SponsorAffinityGroupAvailability>
            getAvailableAffinityGroups() {
        final Collection<SponsorAffinityGroupAvailability> affs;

        affs = new LinkedList<SponsorAffinityGroupAvailability>();
        for (final SponsorAffinityGroupAvailability aff : getSponsorAffinityGroupAvailabilityRepository()
                .findAll()) {
            // TODO: Copy these to new beans
            affs.add(aff);
        }

        return affs;
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
    public final Iterable<Unit>
            getSponsorAvailableUnits(final Sponsor sponsor) {
        final Collection<Unit> units; // Available units
        Integer cost;                 // Unit cost
        Unit unit;                    // Available unit

        checkNotNull(sponsor, "Received a null pointer as sponsor");

        units = new LinkedList<Unit>();
        for (final AffinityUnit affUnit : getAffinityUnitRepository()
                .findAll()) {
            cost = getUnitCost(sponsor, affUnit);

            unit = getDbxModelFactory().getUnit(affUnit.getTemplateName(), cost,
                    affUnit.getRole(), affUnit.getAttributes(),
                    affUnit.getAbilities(), affUnit.getMvp(),
                    affUnit.getGiant());

            units.add(unit);
        }

        return units;
    }

    @Override
    public final SponsorTeam getSponsorTeam(final Sponsor sponsor) {
        return getDbxModelFactory().getSponsorTeam(sponsor);
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
        return dbxModelFact;
    }

    private final DbxRules getDbxRules() {
        return dbxRules;
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
     * Returns the actual cost for a unit for a sponsor.
     * 
     * @param sponsor
     *            sponsor to set the cost
     * @param unit
     *            unit to find the cost for
     * @return the cost of the unit for the sponsor
     */
    private final Integer getUnitCost(final Sponsor sponsor,
            final AffinityUnit unit) {
        final AffinityLevel affinityLevel;  // Affinity level relationship

        affinityLevel = getDbxRules().getAffinityLevel(unit,
                sponsor.getAffinityGroups());

        return getDbxRules().getUnitCost(affinityLevel, unit);
    }
}
