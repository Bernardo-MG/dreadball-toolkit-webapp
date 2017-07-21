
package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean;

import java.util.ArrayList;
import java.util.Collection;

import com.wandrell.tabletop.dreadball.model.unit.DefaultAffinityGroup;

public class SponsorTeamOptions {

    private Collection<DefaultAffinityGroup> affinities         = new ArrayList<>();

    private Integer                          cheerleaders       = 0;

    private Integer                          coachingDice       = 0;

    private Integer                          mediBots           = 0;

    private Integer                          specialMoveCards   = 0;

    private Integer                          nastySurpriseCards = 0;

    private Integer                          wagers             = 0;

    public SponsorTeamOptions() {
        super();
    }

    public final Collection<DefaultAffinityGroup> getAffinities() {
        return affinities;
    }

    public final void
            setAffinities(final Collection<DefaultAffinityGroup> affinities) {
        this.affinities = affinities;
    }

    public Integer getCheerleaders() {
        return cheerleaders;
    }

    public void setCheerleaders(Integer cheerleaders) {
        this.cheerleaders = cheerleaders;
    }

    public Integer getCoachingDice() {
        return coachingDice;
    }

    public void setCoachingDice(Integer coachingDice) {
        this.coachingDice = coachingDice;
    }

    public Integer getMediBots() {
        return mediBots;
    }

    public void setMediBots(Integer mediBot) {
        this.mediBots = mediBot;
    }

    public Integer getSpecialMoveCards() {
        return specialMoveCards;
    }

    public void setSpecialMoveCards(Integer specialMoveCard) {
        this.specialMoveCards = specialMoveCard;
    }

    public Integer getNastySurpriseCards() {
        return nastySurpriseCards;
    }

    public void setNastySurpriseCards(Integer nastySurpriseCard) {
        this.nastySurpriseCards = nastySurpriseCard;
    }

    public Integer getWagers() {
        return wagers;
    }

    public void setWagers(Integer wager) {
        this.wagers = wager;
    }

}
