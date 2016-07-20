
package com.wandrell.tabletop.dreadball.web.toolkit.service.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultRankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.RankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeamValorationCalculator;
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

@Service("dbxTeamBuilderService")
public final class DefaultDbxTeamBuilderService
        implements DbxTeamBuilderService {

    private final SponsorAffinityGroupAvailabilityRepository affinityAvasRepository;

    private final AffinityGroupRepository                    affinitiesRepository;

    private final AffinityUnitRepository                     unitRepository;

    private final DbxValuesService                           valuesService;

    @Autowired
    public DefaultDbxTeamBuilderService(
            final SponsorAffinityGroupAvailabilityRepository affinityAvasRepo,
            final AffinityGroupRepository affinitiesRepo,
            final AffinityUnitRepository unitRepo,
            final DbxValuesService valuesServ) {
        super();

        affinityAvasRepository = checkNotNull(affinityAvasRepo,
                "Received a null pointer as affinity availabilities repository");
        affinitiesRepository = checkNotNull(affinitiesRepo,
                "Received a null pointer as affinities repository");
        unitRepository = checkNotNull(unitRepo,
                "Received a null pointer as units repository");
        valuesService = checkNotNull(valuesServ,
                "Received a null pointer as units repository");
    }

    @Override
    public final void addUnit(final SponsorTeam team,
            final String templateName) {
        final AffinityUnit repoUnit;
        final Integer cost;
        final Unit unit;

        repoUnit = getUnitRepository().findByTemplateName(templateName);

        if (repoUnit != null) {
            cost = getUnitCost(team.getSponsor(), repoUnit);

            unit = new DefaultUnit(repoUnit.getTemplateName(), cost,
                    repoUnit.getRole(), repoUnit.getAttributes(),
                    repoUnit.getAbilities(), repoUnit.getMvp(),
                    repoUnit.getGiant());

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
        final Sponsor sponsor;
        final Collection<String> affinities = new LinkedList<String>();

        sponsor = new DefaultSponsor();

        sponsor.setName(form.getSponsorName());

        sponsor.setRank(getInitialRank());

        // TODO: The affinities should come as a list
        // Loads affinities
        affinities.add(form.getAffinityA());
        affinities.add(form.getAffinityB());
        affinities.add(form.getAffinityC());
        affinities.add(form.getAffinityD());
        affinities.add(form.getAffinityE());

        while (affinities.contains("rank")) {
            sponsor.setRank(sponsor.getRank() + 1);
            affinities.remove("rank");
        }

        for (final String affinity : affinities) {
            sponsor.addAffinityGroup(
                    getAffinityGroupRepository().findByName(affinity));
        }

        return sponsor;
    }

    @Override
    public final Iterable<? extends SponsorAffinityGroupAvailability>
            getSponsorAffinityGroups() {
        return getRepository().findAll();
    }

    @Override
    public final SponsorTeam getSponsorTeam(final Sponsor sponsor) {
        final SponsorTeam team;

        team = new DefaultSponsorTeam(sponsor,
                getSponsorTeamValorationCalculator(), getRankCostCalculator());

        return team;
    }

    @Override
    public final Iterable<? extends Unit>
            getSponsorTeamAvailableUnits(final SponsorTeam team) {
        final Collection<Unit> units;
        Integer cost;
        Unit unit;

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

    private final AffinityGroupRepository getAffinityGroupRepository() {
        return affinitiesRepository;
    }

    private final AffinityLevel getAffinityLevel(final Sponsor sponsor,
            final AffinityUnit unit) {
        final AffinityLevel affinity;
        final Collection<AffinityGroup> sponsorAffinities;
        Integer coincidences;

        sponsorAffinities = sponsor.getAffinityGroups();
        coincidences = 0;
        for (final AffinityGroup affinityGroup : unit.getAffinityGroups()) {
            if (sponsorAffinities.contains(affinityGroup)) {
                coincidences++;
            }
        }

        if (coincidences >= 2) {
            affinity = AffinityLevel.FRIEND;
        } else if (coincidences == 1) {
            affinity = AffinityLevel.ALLY;
        } else {
            affinity = AffinityLevel.STRANGER;
        }

        return affinity;
    }

    private final DbxValuesService getDbxValuesService() {
        return valuesService;
    }

    private final RankCostCalculator getRankCostCalculator() {
        final RankCostCalculator calculator;

        calculator = new DefaultRankCostCalculator(
                getDbxValuesService().getDreadballDieRankCost(),
                getDbxValuesService().getSabotageCardRankCost(),
                getDbxValuesService().getSpecialMoveCardRankCost(),
                getDbxValuesService().getCheerleaderRankCost(),
                getDbxValuesService().getWagerRankCost(),
                getDbxValuesService().getMediBotRankCost());

        return calculator;
    }

    private final SponsorAffinityGroupAvailabilityRepository getRepository() {
        return affinityAvasRepository;
    }

    private final TeamValorationCalculator<SponsorTeam>
            getSponsorTeamValorationCalculator() {
        final TeamValorationCalculator<SponsorTeam> calculator;

        calculator = new SponsorTeamValorationCalculator(
                getDbxValuesService().getDreadballDieCost(),
                getDbxValuesService().getSabotageCardCost(),
                getDbxValuesService().getSpecialMoveCardCost(),
                getDbxValuesService().getCheerleaderCost(),
                getDbxValuesService().getWagerCost(),
                getDbxValuesService().getMediBotCost());

        return calculator;
    }

    private final Integer getUnitCost(final Sponsor sponsor,
            final AffinityUnit unit) {
        final AffinityLevel affinityLevel;
        final Integer cost;

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
        }

        return cost;
    }

    private final AffinityUnitRepository getUnitRepository() {
        return unitRepository;
    }

}
