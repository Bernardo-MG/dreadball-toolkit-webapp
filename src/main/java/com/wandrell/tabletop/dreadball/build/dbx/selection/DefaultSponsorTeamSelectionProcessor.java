
package com.wandrell.tabletop.dreadball.build.dbx.selection;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.build.dbx.model.DefaultSponsorTeamSelection;
import com.wandrell.tabletop.dreadball.build.dbx.model.SponsorTeamAssets;
import com.wandrell.tabletop.dreadball.build.dbx.model.SponsorTeamSelection;
import com.wandrell.tabletop.dreadball.build.dbx.model.TeamPlayer;
import com.wandrell.tabletop.dreadball.build.dbx.rules.SponsorCosts;
import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.calculator.CostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.DefaultRankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.SponsorTeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.AffinityLevel;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.DefaultAffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.DefaultUnit;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.repository.unit.AffinityUnitRepository;
import com.wandrell.tabletop.dreadball.rules.DbxRules;

@Service
public class DefaultSponsorTeamSelectionProcessor
        implements SponsorTeamSelectionProcessor {

    private static final Logger          LOGGER = LoggerFactory
            .getLogger(DefaultSponsorTeamSelectionProcessor.class);

    /**
     * Affinity units repository.
     */
    private final AffinityUnitRepository affinityUnitRepository;

    private final SponsorCosts           costs;

    /**
     * DBX rules.
     */
    private final DbxRules               dbxRules;

    private final SponsorCosts           rankCosts;

    @Autowired
    public DefaultSponsorTeamSelectionProcessor(
            @Qualifier("SponsorCosts") final SponsorCosts sponsorCosts,
            @Qualifier("SponsorRankCosts") final SponsorCosts sponsorRankCosts,
            final AffinityUnitRepository unitsRepository,
            final DbxRules rules) {
        super();

        costs = checkNotNull(sponsorCosts,
                "Received a null pointer as Sponsor costs");
        rankCosts = checkNotNull(sponsorRankCosts,
                "Received a null pointer as Sponsor rank costs");
        affinityUnitRepository = checkNotNull(unitsRepository,
                "Received a null pointer as units repository");
        dbxRules = checkNotNull(rules, "Received a null pointer as DBX rules");
    }

    @Override
    public final SponsorTeamSelection selectTeam(
            final Collection<String> affinities,
            final Collection<String> unitNames, final SponsorTeamAssets assets,
            final Integer baseRank) {
        final Integer rank;
        final Integer assetRankCost;
        final Integer teamValue;
        final SponsorTeam sponsorTeam;
        final Collection<AffinityGroup> affGroups;
        final Collection<? extends AffinityUnit> units;
        final Collection<TeamPlayer> acceptedUnits;

        checkNotNull(affinities, "Received a null pointer as affinities");
        checkNotNull(unitNames, "Received a null pointer as unit names");
        checkNotNull(assets, "Received a null pointer as assets");
        checkNotNull(baseRank, "Received a null pointer as base rank");

        LOGGER.info("Units {}", unitNames);

        affGroups = getAffinityGroups(affinities);

        if (unitNames.isEmpty()) {
            units = Collections.emptyList();
        } else {
            units = getAffinityUnitRepository().findByTemplateNameIn(unitNames);
        }

        sponsorTeam = getSponsorTeam(assets, units, affGroups);

        teamValue = sponsorTeam.getValoration();
        assetRankCost = sponsorTeam.getRankCost();

        rank = baseRank - assetRankCost;

        acceptedUnits = sponsorTeam.getPlayers().entrySet().stream()
                .map(unit -> new TeamPlayer(unit.getKey(),
                        unit.getValue().getTemplateName()))
                .collect(Collectors.toList());

        return new DefaultSponsorTeamSelection(affinities, acceptedUnits, rank,
                baseRank, teamValue);
    }

    private final Collection<AffinityGroup>
            getAffinityGroups(final Collection<String> affinities) {
        return affinities.stream()
                .map(affinity -> new DefaultAffinityGroup(affinity))
                .collect(Collectors.toList());
    }

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

    private final SponsorCosts getSponsorRankCosts() {
        return rankCosts;
    }

    private final SponsorTeam getSponsorTeam(final SponsorTeamAssets assets,
            final Collection<? extends AffinityUnit> units,
            final Collection<AffinityGroup> affinities) {
        final Sponsor sponsor;
        final SponsorTeam sponsorTeam;
        Unit unitSetUp;
        Integer cost;
        AffinityLevel affinityLevel;  // Affinity level relationship

        sponsor = new DefaultSponsor();

        sponsorTeam = new DefaultSponsorTeam(sponsor,
                getTeamValorationCalculator(), getRankCostCalculator());

        sponsorTeam.getSponsor().setAffinityGroups(affinities);

        for (final AffinityUnit unit : units) {
            affinityLevel = getDbxRules().getAffinityLevel(unit, affinities);
            cost = getDbxRules().getUnitCost(affinityLevel, unit);
            unitSetUp = new DefaultUnit(unit.getTemplateName(), cost,
                    unit.getRole(), unit.getAttributes(), unit.getAbilities(),
                    unit.getMvp(), unit.getGiant());
            sponsorTeam.addPlayer(unitSetUp);
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
