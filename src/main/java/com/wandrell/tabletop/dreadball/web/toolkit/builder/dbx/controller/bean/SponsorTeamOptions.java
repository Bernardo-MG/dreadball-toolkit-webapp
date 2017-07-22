
package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean;

public class SponsorTeamOptions {

    private Integer baseRank           = 0;

    private Integer cheerleaders       = 0;

    private Integer coachingDice       = 0;

    private Integer mediBots           = 0;

    private Integer nastySurpriseCards = 0;

    private Integer specialMoveCards   = 0;

    private Integer wagers             = 0;

    public SponsorTeamOptions() {
        super();
    }

    public Integer getBaseRank() {
        return baseRank;
    }

    public Integer getCheerleaders() {
        return cheerleaders;
    }

    public Integer getCoachingDice() {
        return coachingDice;
    }

    public Integer getMediBots() {
        return mediBots;
    }

    public Integer getNastySurpriseCards() {
        return nastySurpriseCards;
    }

    public Integer getSpecialMoveCards() {
        return specialMoveCards;
    }

    public Integer getWagers() {
        return wagers;
    }

    public void setBaseRank(final Integer baseRank) {
        this.baseRank = baseRank;
    }

    public void setCheerleaders(final Integer cheerleaders) {
        this.cheerleaders = cheerleaders;
    }

    public void setCoachingDice(final Integer coachingDice) {
        this.coachingDice = coachingDice;
    }

    public void setMediBots(final Integer mediBot) {
        mediBots = mediBot;
    }

    public void setNastySurpriseCards(final Integer nastySurpriseCard) {
        nastySurpriseCards = nastySurpriseCard;
    }

    public void setSpecialMoveCards(final Integer specialMoveCard) {
        specialMoveCards = specialMoveCard;
    }

    public void setWagers(final Integer wager) {
        wagers = wager;
    }

}
