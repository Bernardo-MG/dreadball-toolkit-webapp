
package com.wandrell.tabletop.dreadball.build.dbx.model;

import com.wandrell.tabletop.dreadball.build.dbx.SponsorCosts;

public class DefaultSponsorCosts implements SponsorCosts {

    private Integer cheerleaderCost;

    private Integer cheerleaderRank;

    private Integer dieCost;

    private Integer dieRank;

    /**
     * Initial rank.
     */
    private Integer initialRank;

    private Integer medibotCost;

    private Integer medibotRank;

    private Integer moveCost;

    private Integer moveRank;

    private Integer sabotageCost;

    private Integer sabotageRank;

    private Integer wagerCost;

    private Integer wagerRank;

    public DefaultSponsorCosts() {
        super();
    }

    @Override
    public Integer getCheerleaderCost() {
        return cheerleaderCost;
    }

    @Override
    public Integer getCheerleaderRank() {
        return cheerleaderRank;
    }

    @Override
    public Integer getDieCost() {
        return dieCost;
    }

    @Override
    public Integer getDieRank() {
        return dieRank;
    }

    @Override
    public Integer getInitialRank() {
        return initialRank;
    }

    @Override
    public Integer getMediBotCost() {
        return medibotCost;
    }

    @Override
    public Integer getMediBotRank() {
        return medibotRank;
    }

    @Override
    public Integer getMoveCost() {
        return moveCost;
    }

    @Override
    public Integer getMoveRank() {
        return moveRank;
    }

    @Override
    public Integer getSabotageCost() {
        return sabotageCost;
    }

    @Override
    public Integer getSabotageRank() {
        return sabotageRank;
    }

    @Override
    public Integer getWagerCost() {
        return wagerCost;
    }

    @Override
    public Integer getWagerRank() {
        return wagerRank;
    }

    public void setCheerleaderCost(Integer cheerleaderCost) {
        this.cheerleaderCost = cheerleaderCost;
    }

    public void setCheerleaderRank(Integer cheerleaderRank) {
        this.cheerleaderRank = cheerleaderRank;
    }

    public void setDieCost(Integer dieCost) {
        this.dieCost = dieCost;
    }

    public void setDieRank(Integer dieRank) {
        this.dieRank = dieRank;
    }

    public void setInitialRank(Integer initialRank) {
        this.initialRank = initialRank;
    }

    public void setMedibotCost(Integer medibotCost) {
        this.medibotCost = medibotCost;
    }

    public void setMedibotRank(Integer medibotRank) {
        this.medibotRank = medibotRank;
    }

    public void setMoveCost(Integer moveCost) {
        this.moveCost = moveCost;
    }

    public void setMoveRank(Integer moveRank) {
        this.moveRank = moveRank;
    }

    public void setSabotageCost(Integer sabotageCost) {
        this.sabotageCost = sabotageCost;
    }

    public void setSabotageRank(Integer sabotageRank) {
        this.sabotageRank = sabotageRank;
    }

    public void setWagerCost(Integer wagerCost) {
        this.wagerCost = wagerCost;
    }

    public void setWagerRank(Integer wagerRank) {
        this.wagerRank = wagerRank;
    }

}
