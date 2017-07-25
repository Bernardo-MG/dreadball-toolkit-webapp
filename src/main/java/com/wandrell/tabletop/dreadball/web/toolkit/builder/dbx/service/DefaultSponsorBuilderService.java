
package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.build.dbx.SponsorCosts;
import com.wandrell.tabletop.dreadball.build.dbx.SponsorDefaults;
import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.calculator.CostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.DefaultRankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.SponsorTeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.DefaultAffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.repository.unit.AffinityUnitRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorAffinities;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorAffinitiesSelection;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorTeamAssets;

@Service
public class DefaultSponsorBuilderService implements SponsorBuilderService {

    private static final Logger          LOGGER = LoggerFactory
            .getLogger(DefaultSponsorBuilderService.class);

    /**
     * Affinity units repository.
     */
    private final AffinityUnitRepository affinityUnitRepository;

    private final SponsorCosts           costs;

    private final SponsorCosts           rankCosts;

    private final SponsorDefaults        sponsorDefaults;

    @Autowired
    public DefaultSponsorBuilderService(final SponsorDefaults defaults,
            @Qualifier("SponsorCosts") final SponsorCosts sponsorCosts,
            @Qualifier("SponsorRankCosts") final SponsorCosts sponsorRankCosts,
            final AffinityUnitRepository unitsRepository) {
        super();

        sponsorDefaults = checkNotNull(defaults,
                "Received a null pointer as Sponsor defaults service");
        costs = checkNotNull(sponsorCosts,
                "Received a null pointer as Sponsor costs");
        rankCosts = checkNotNull(sponsorRankCosts,
                "Received a null pointer as Sponsor rank costs");
        affinityUnitRepository = checkNotNull(unitsRepository,
                "Received a null pointer as units repository");
    }

    @Override
    public SponsorAffinitiesSelection getSelectionResult(
            final Collection<String> affinities,
            final Collection<String> unitNames, final SponsorTeamAssets assets,
            final Integer baseRank) {
        final Integer rank;
        final Integer assetRankCost;
        final Integer teamValue;
        final SponsorTeam sponsorTeam;
        final Collection<AffinityGroup> affGroups;
        final Collection<? extends Unit> units;
        final Collection<String> acceptedUnits;

        checkNotNull(affinities, "Received a null pointer as affinities");
        checkNotNull(unitNames, "Received a null pointer as unit names");
        checkNotNull(assets, "Received a null pointer as assets");
        checkNotNull(baseRank, "Received a null pointer as base rank");

        affGroups = affinities.stream()
                .map(affinity -> new DefaultAffinityGroup(affinity))
                .collect(Collectors.toList());

        units = getAffinityUnitRepository().findByTemplateName(unitNames);

        sponsorTeam = getSponsorTeam(assets, units, affGroups);

        teamValue = sponsorTeam.getValoration();
        assetRankCost = sponsorTeam.getRankCost();

        rank = baseRank - assetRankCost;

        acceptedUnits = sponsorTeam.getPlayers().values().stream()
                .map(unit -> unit.getTemplateName())
                .collect(Collectors.toList());

        return new SponsorAffinitiesSelection(affinities, acceptedUnits, rank,
                baseRank, teamValue);
    }

    @Override
    public SponsorAffinities
            selectAffinities(final Collection<String> affinities) {
        final Integer rankAdd;
        final Integer rank;
        final Iterable<String> filtered;

        checkNotNull(affinities, "Received a null pointer as affinities");

        rankAdd = affinities.stream()
                .filter(affinity -> affinity.equals("rank_increase"))
                .collect(Collectors.toList()).size();
        filtered = affinities.stream()
                .filter(affinity -> !affinity.equals("rank_increase"))
                .collect(Collectors.toList());

        rank = getSponsorDefaults().getInitialRank() + rankAdd;

        return new SponsorAffinities(filtered, rank, rank);
    }

    private final AffinityUnitRepository getAffinityUnitRepository() {
        return affinityUnitRepository;
    }

    private final CostCalculator<SponsorTeam> getRankCostCalculator() {
        return new DefaultRankCostCalculator(getSponsorRankCosts().getDieCost(),
                getSponsorRankCosts().getSabotageCost(),
                getSponsorRankCosts().getSpecialMoveCost(),
                getSponsorRankCosts().getCheerleaderCost(),
                getSponsorRankCosts().getWagerCost(),
                getSponsorRankCosts().getMediBotCost());
    }

    private final SponsorCosts getSponsorCosts() {
        return costs;
    }

    private final SponsorDefaults getSponsorDefaults() {
        return sponsorDefaults;
    }

    private final SponsorCosts getSponsorRankCosts() {
        return rankCosts;
    }

    private final SponsorTeam getSponsorTeam(final SponsorTeamAssets assets,
            final Collection<? extends Unit> units,
            final Collection<AffinityGroup> affinities) {
        final Sponsor sponsor;
        final SponsorTeam sponsorTeam;

        sponsor = new DefaultSponsor();

        sponsorTeam = new DefaultSponsorTeam(sponsor,
                getTeamValorationCalculator(), getRankCostCalculator());

        sponsorTeam.getSponsor().setAffinityGroups(affinities);

        for (final Unit unit : units) {
            // TODO: Set costs
            sponsorTeam.addPlayer(unit);
        }

        sponsorTeam.setCheerleaders(assets.getCheerleaders());
        sponsorTeam.setCoachingDice(assets.getCoachingDice());
        sponsorTeam.setMediBots(assets.getMediBots());
        sponsorTeam.setSpecialMoveCards(assets.getSpecialMoveCards());
        sponsorTeam.setSabotageCards(assets.getNastySurpriseCards());
        sponsorTeam.setWagers(assets.getWagers());

        return sponsorTeam;
    }

    private final CostCalculator<SponsorTeam> getTeamValorationCalculator() {
        return new SponsorTeamValorationCalculator(
                getSponsorCosts().getDieCost(),
                getSponsorCosts().getSabotageCost(),
                getSponsorCosts().getSpecialMoveCost(),
                getSponsorCosts().getCheerleaderCost(),
                getSponsorCosts().getWagerCost(),
                getSponsorCosts().getMediBotCost());
    }

}
