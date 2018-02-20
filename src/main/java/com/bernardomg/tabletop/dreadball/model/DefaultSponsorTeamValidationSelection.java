
package com.bernardomg.tabletop.dreadball.model;

import java.util.Collection;
import java.util.Collections;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public final class DefaultSponsorTeamValidationSelection
        implements SponsorTeamValidationSelection {

    private Collection<String> affinities         = Collections.emptyList();

    private Integer            baseRank           = 0;

    /**
     * Number of cheerleaders.
     */
    @NotNull
    @Min(0)
    private Integer            cheerleaders       = 0;

    /**
     * Number of coaching dice.
     */
    @NotNull
    @Min(0)
    private Integer            coachingDice       = 0;

    /**
     * Number of medi-bots.
     */
    @NotNull
    @Min(0)
    private Integer            mediBots           = 0;

    /**
     * Number of sabotage cards.
     */
    @NotNull
    @Min(0)
    private Integer            nastySurpriseCards = 0;

    private Integer            rank               = 0;

    /**
     * Number of special move cards.
     */
    @NotNull
    @Min(0)
    private Integer            specialMoveCards   = 0;

    private Integer            teamValue          = 0;

    private Collection<String> units              = Collections.emptyList();

    /**
     * Number of wagers.
     */
    @NotNull
    @Min(0)
    private Integer            wagers             = 0;

    public DefaultSponsorTeamValidationSelection() {
        super();
    }

    @Override
    public final Collection<String> getAffinities() {
        return affinities;
    }

    @Override
    public final Integer getBaseRank() {
        return baseRank;
    }

    @Override
    public final Integer getCheerleaders() {
        return cheerleaders;
    }

    @Override
    public final Integer getCoachingDice() {
        return coachingDice;
    }

    @Override
    public final Integer getMediBots() {
        return mediBots;
    }

    @Override
    public final Integer getNastySurpriseCards() {
        return nastySurpriseCards;
    }

    @Override
    public final Integer getRank() {
        return rank;
    }

    @Override
    public final Integer getSpecialMoveCards() {
        return specialMoveCards;
    }

    @Override
    public final Integer getTeamValue() {
        return teamValue;
    }

    @Override
    public final Collection<String> getUnits() {
        return units;
    }

    @Override
    public final Integer getWagers() {
        return wagers;
    }

    public final void setAffinities(final Collection<String> affinities) {
        this.affinities = affinities;
    }

    public final void setBaseRank(final Integer baseRank) {
        this.baseRank = baseRank;
    }

    public final void setCheerleaders(final Integer value) {
        cheerleaders = value;
    }

    public final void setCoachingDice(final Integer value) {
        coachingDice = value;
    }

    public final void setMediBots(final Integer value) {
        mediBots = value;
    }

    public final void setNastySurpriseCards(final Integer value) {
        nastySurpriseCards = value;
    }

    public final void setRank(final Integer rank) {
        this.rank = rank;
    }

    public final void setSpecialMoveCards(final Integer value) {
        specialMoveCards = value;
    }

    public final void setTeamValue(final Integer teamValue) {
        this.teamValue = teamValue;
    }

    public final void setUnits(final Collection<String> units) {
        this.units = units;
    }

    public final void setWagers(final Integer value) {
        wagers = value;
    }

}
