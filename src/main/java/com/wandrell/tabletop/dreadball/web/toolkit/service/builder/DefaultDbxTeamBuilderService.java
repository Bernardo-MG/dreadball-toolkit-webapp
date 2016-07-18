
package com.wandrell.tabletop.dreadball.web.toolkit.service.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.wandrell.tabletop.dreadball.model.unit.Unit;
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

    private final Integer                                    initialRank;

    private final Integer                                    maxPlayers;

    @Autowired
    public DefaultDbxTeamBuilderService(
            final SponsorAffinityGroupAvailabilityRepository affinityAvasRepo,
            final AffinityGroupRepository affinitiesRepo,
            final AffinityUnitRepository unitRepo,
            @Value("${sponsor.rank.initial}") final Integer rank,
            @Value("${sponsor.players.max}") final Integer playersMax) {
        super();

        affinityAvasRepository = checkNotNull(affinityAvasRepo,
                "Received a null pointer as affinity availabilities repository");
        affinitiesRepository = checkNotNull(affinitiesRepo,
                "Received a null pointer as affinities repository");
        unitRepository = checkNotNull(unitRepo,
                "Received a null pointer as units repository");

        initialRank = checkNotNull(rank, "Received a null pointer as rank");
        maxPlayers = checkNotNull(playersMax,
                "Received a null pointer as maximum number of players");
    }

    @Override
    public final Integer getInitialRank() {
        return initialRank;
    }

    @Override
    public final Integer getMaxTeamUnits() {
        return maxPlayers;
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
        return getUnitRepository().findAll();
    }

    @Override
    public final Unit getUnit(final String templateName) {
        return getUnitRepository().findByTemplateName(templateName);
    }

    private final AffinityGroupRepository getAffinityGroupRepository() {
        return affinitiesRepository;
    }

    private final RankCostCalculator getRankCostCalculator() {
        final RankCostCalculator calculator;

        calculator = new DefaultRankCostCalculator(1, 2, 3, 4, 5, 6);

        return calculator;
    }

    private final SponsorAffinityGroupAvailabilityRepository getRepository() {
        return affinityAvasRepository;
    }

    private final TeamValorationCalculator<SponsorTeam>
            getSponsorTeamValorationCalculator() {
        final TeamValorationCalculator<SponsorTeam> calculator;

        // TODO: Load the actual values from somewhere
        calculator = new SponsorTeamValorationCalculator(1, 2, 3, 4, 5, 6);

        return calculator;
    }

    private final AffinityUnitRepository getUnitRepository() {
        return unitRepository;
    }

}
