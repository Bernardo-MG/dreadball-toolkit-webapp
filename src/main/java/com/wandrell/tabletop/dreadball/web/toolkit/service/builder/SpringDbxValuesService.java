
package com.wandrell.tabletop.dreadball.web.toolkit.service.builder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("dbxValuesService")
public class SpringDbxValuesService implements DbxValuesService {

    @Value("${sponsor.rank.initial}")
    private Integer initialRank;

    @Value("${sponsor.players.max}")
    private Integer maxTeamUnits;

    @Value("${sponsor.asset.die.rank}")
    private Integer dreadballDieRankCost;

    @Value("${sponsor.asset.sabotage.rank}")
    private Integer sabotageCardRankCost;

    @Value("${sponsor.asset.move.rank}")
    private Integer specialMoveCardRankCost;

    @Value("${sponsor.asset.cheerleader.rank}")
    private Integer cheerleaderRankCost;

    @Value("${sponsor.asset.wager.rank}")
    private Integer wagerRankCost;

    @Value("${sponsor.asset.medibot.rank}")
    private Integer mediBotRankCost;

    @Value("${sponsor.asset.die.cost}")
    private Integer dreadballDieCost;

    @Value("${sponsor.asset.sabotage.cost}")
    private Integer sabotageCardCost;

    @Value("${sponsor.asset.move.cost}")
    private Integer specialMoveCardCost;

    @Value("${sponsor.asset.cheerleader.cost}")
    private Integer cheerleaderCost;

    @Value("${sponsor.asset.wager.cost}")
    private Integer wagerCost;

    @Value("${sponsor.asset.medibot.cost}")
    private Integer mediBotCost;

    public SpringDbxValuesService() {
        super();
    }

    @Override
    public final Integer getCheerleaderCost() {
        return cheerleaderCost;
    }

    @Override
    public final Integer getCheerleaderRankCost() {
        return cheerleaderRankCost;
    }

    @Override
    public final Integer getDreadballDieCost() {
        return dreadballDieCost;
    }

    @Override
    public final Integer getDreadballDieRankCost() {
        return dreadballDieRankCost;
    }

    @Override
    public final Integer getInitialRank() {
        return initialRank;
    }

    @Override
    public final Integer getMaxTeamUnits() {
        return maxTeamUnits;
    }

    @Override
    public final Integer getMediBotCost() {
        return mediBotCost;
    }

    @Override
    public final Integer getMediBotRankCost() {
        return mediBotRankCost;
    }

    @Override
    public final Integer getSabotageCardCost() {
        return sabotageCardCost;
    }

    @Override
    public final Integer getSabotageCardRankCost() {
        return sabotageCardRankCost;
    }

    @Override
    public final Integer getSpecialMoveCardCost() {
        return specialMoveCardCost;
    }

    @Override
    public final Integer getSpecialMoveCardRankCost() {
        return specialMoveCardRankCost;
    }

    @Override
    public final Integer getWagerCost() {
        return wagerCost;
    }

    @Override
    public final Integer getWagerRankCost() {
        return wagerRankCost;
    }

}
