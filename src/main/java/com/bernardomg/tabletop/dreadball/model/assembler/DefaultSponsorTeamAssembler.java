
package com.bernardomg.tabletop.dreadball.model.assembler;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bernardomg.tabletop.dreadball.model.SponsorTeamAssets;
import com.bernardomg.tabletop.dreadball.model.faction.DefaultSponsor;
import com.bernardomg.tabletop.dreadball.model.faction.Sponsor;
import com.bernardomg.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.bernardomg.tabletop.dreadball.model.team.calculator.CostCalculator;
import com.bernardomg.tabletop.dreadball.model.team.calculator.DefaultRankCostCalculator;
import com.bernardomg.tabletop.dreadball.model.team.calculator.SponsorTeamValorationCalculator;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityLevel;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityUnit;
import com.bernardomg.tabletop.dreadball.model.unit.DefaultUnit;
import com.bernardomg.tabletop.dreadball.model.unit.Unit;
import com.bernardomg.tabletop.dreadball.rules.DbxRules;
import com.bernardomg.tabletop.dreadball.rules.SponsorCosts;
import com.google.common.collect.Lists;

@Component
public final class DefaultSponsorTeamAssembler implements SponsorTeamAssembler {

    private final SponsorCosts costs;

    /**
     * DBX rules.
     */
    private final DbxRules     dbxRules;

    private final SponsorCosts rankCosts;

    @Autowired
    public DefaultSponsorTeamAssembler(
            @Qualifier("SponsorCosts") final SponsorCosts sponsorCosts,
            @Qualifier("SponsorRankCosts") final SponsorCosts sponsorRankCosts,
            final DbxRules rules) {
        super();

        costs = checkNotNull(sponsorCosts,
                "Received a null pointer as Sponsor costs");
        rankCosts = checkNotNull(sponsorRankCosts,
                "Received a null pointer as Sponsor rank costs");
        dbxRules = checkNotNull(rules, "Received a null pointer as DBX rules");
    }

    @Override
    public final SponsorTeam assemble(final Iterable<AffinityGroup> affinities,
            final Iterable<AffinityUnit> units, final SponsorTeamAssets assets,
            final Integer rank) {
        final SponsorTeam sponsorTeam;

        checkNotNull(affinities, "Received a null pointer as affinities");
        checkNotNull(units, "Received a null pointer as units");
        checkNotNull(assets, "Received a null pointer as assets");
        checkNotNull(rank, "Received a null pointer as rank");

        sponsorTeam = getDefaultSponsorTeam();

        sponsorTeam.getSponsor().setRank(rank);
        sponsorTeam.getSponsor()
                .setAffinityGroups(Lists.newArrayList(affinities));

        setPlayers(sponsorTeam, affinities, units);

        sponsorTeam.setCheerleaders(assets.getCheerleaders());
        sponsorTeam.setCoachingDice(assets.getCoachingDice());
        sponsorTeam.setMediBots(assets.getMediBots());
        sponsorTeam.setSpecialMoveCards(assets.getSpecialMoveCards());
        sponsorTeam.setSabotageCards(assets.getNastySurpriseCards());
        sponsorTeam.setWagers(assets.getWagers());

        return sponsorTeam;
    }

    /**
     * Returns the DBX rules.
     * 
     * @return the DBX rules
     */
    private final DbxRules getDbxRules() {
        return dbxRules;
    }

    private final SponsorTeam getDefaultSponsorTeam() {
        final Sponsor sponsor;

        sponsor = new DefaultSponsor();

        return new DefaultSponsorTeam(sponsor, getTeamValorationCalculator(),
                getRankCostCalculator());
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

    private final CostCalculator<SponsorTeam> getTeamValorationCalculator() {
        return new SponsorTeamValorationCalculator(
                getSponsorCosts().getDieCost(),
                getSponsorCosts().getSabotageCost(),
                getSponsorCosts().getSpecialMoveCost(),
                getSponsorCosts().getCheerleaderCost(),
                getSponsorCosts().getWagerCost(),
                getSponsorCosts().getMediBotCost());
    }

    private final void setPlayers(final SponsorTeam sponsorTeam,
            final Iterable<AffinityGroup> affinities,
            final Iterable<AffinityUnit> units) {
        Unit unitSetUp;
        Integer cost;
        AffinityLevel affinityLevel; // Affinity level relationship

        for (final AffinityUnit unit : units) {
            affinityLevel = getDbxRules().getAffinityLevel(unit, affinities);
            cost = getDbxRules().getUnitCost(affinityLevel, unit);

            unitSetUp = new DefaultUnit(unit.getTemplateName(), cost,
                    unit.getRole(), unit.getAttributes(), unit.getAbilities(),
                    unit.getMvp(), unit.getGiant());

            sponsorTeam.addPlayer(unitSetUp);
        }
    }

}
