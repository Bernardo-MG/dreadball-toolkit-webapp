
package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx;

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
import com.wandrell.tabletop.dreadball.web.toolkit.model.form.SponsorForm;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.availability.SponsorAffinityGroupAvailabilityRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityUnitRepository;

@Service("dbxSponsorCreationService")
public class DefaultDbxSponsorBuilder implements DbxSponsorBuilder {

    /**
     * Sponsor affinity groups availabilities repository.
     */
    @Autowired
    private SponsorAffinityGroupAvailabilityRepository affinityAvasRepository;

    /**
     * DBX model factory
     */
    @Autowired
    private DbxModelFactory                            dbxModelFact;

    /**
     * DBX rules.
     */
    @Autowired
    private DbxRules                                   dbxRules;

    /**
     * Initial rank.
     */
    @Value("${sponsor.rank.initial}")
    private Integer                                    initialRank;

    /**
     * Affinity units repository.
     */
    @Autowired
    private AffinityUnitRepository                     unitRepository;

    public DefaultDbxSponsorBuilder() {
        super();
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
        for (final AffinityUnit affUnit : getAffinityUnitRepository()
                .findAll()) {
            affinityLevel = getDbxRules().getAffinityLevel(team.getSponsor(),
                    affUnit);
            cost = getDbxRules().getUnitCost(affinityLevel, affUnit);

            unit = getDbxModelFactory().getUnit(affUnit.getTemplateName(), cost,
                    affUnit.getRole(), affUnit.getAttributes(),
                    affUnit.getAbilities(), affUnit.getMvp(),
                    affUnit.getGiant());

            units.add(unit);
        }

        return units;
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
}
