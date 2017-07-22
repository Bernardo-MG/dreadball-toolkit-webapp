
package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean;

import java.util.ArrayList;
import java.util.Collection;

import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.DefaultAffinityGroup;

public class SponsorTeamOptions {

    private Collection<? extends AffinityGroup> affinities         = new ArrayList<>();

    private Integer                             baseRank           = 0;

    private Integer                             cheerleaders       = 0;

    private Integer                             coachingDice       = 0;

    private Integer                             mediBots           = 0;

    private Integer                             nastySurpriseCards = 0;

    private Integer                             specialMoveCards   = 0;

    private Integer                             wagers             = 0;

    public SponsorTeamOptions() {
        super();
    }

    public final Collection<? extends AffinityGroup> getAffinities() {
        return affinities;
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

    public final void
            setAffinities(final Collection<DefaultAffinityGroup> affinities) {
        this.affinities = affinities;
    }

    public void setBaseRank(Integer baseRank) {
        this.baseRank = baseRank;
    }

    public void setCheerleaders(Integer cheerleaders) {
        this.cheerleaders = cheerleaders;
    }

    public void setCoachingDice(Integer coachingDice) {
        this.coachingDice = coachingDice;
    }

    public void setMediBots(Integer mediBot) {
        this.mediBots = mediBot;
    }

    public void setNastySurpriseCards(Integer nastySurpriseCard) {
        this.nastySurpriseCards = nastySurpriseCard;
    }

    public void setSpecialMoveCards(Integer specialMoveCard) {
        this.specialMoveCards = specialMoveCard;
    }

    public void setWagers(Integer wager) {
        this.wagers = wager;
    }

}
