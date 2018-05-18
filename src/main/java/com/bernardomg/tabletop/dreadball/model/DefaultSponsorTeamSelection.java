/**
 * Copyright 2018 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.bernardomg.tabletop.dreadball.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Default implementation of the Sponsor team selection data.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultSponsorTeamSelection implements SponsorTeamSelection {

    /**
     * Team affinities.
     */
    private Collection<String> affinities         = Collections.emptyList();

    /**
     * Sponsor base rank.
     */
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

    /**
     * Number of special move cards.
     */
    @NotNull
    @Min(0)
    private Integer            specialMoveCards   = 0;

    /**
     * Team players.
     */
    private Collection<String> teamPlayers        = Collections.emptyList();

    /**
     * Team value.
     */
    private Integer            teamValue          = 0;

    /**
     * Number of wagers.
     */
    @NotNull
    @Min(0)
    private Integer            wagers             = 0;

    /**
     * Constructs a team selection.
     */
    public DefaultSponsorTeamSelection() {
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
    public final Integer getSpecialMoveCards() {
        return specialMoveCards;
    }

    @Override
    public final Collection<String> getTeamPlayers() {
        return teamPlayers;
    }

    @Override
    public final Integer getTeamValue() {
        return teamValue;
    }

    @Override
    public final Integer getWagers() {
        return wagers;
    }

    @Override
    public final void setAffinities(final Collection<String> affs) {
        affinities = affs;
    }

    @Override
    public final void setBaseRank(final Integer value) {
        baseRank = value;
    }

    @Override
    public final void setCheerleaders(final Integer value) {
        cheerleaders = value;
    }

    @Override
    public final void setCoachingDice(final Integer value) {
        coachingDice = value;
    }

    @Override
    public final void setMediBots(final Integer value) {
        mediBots = value;
    }

    @Override
    public final void setNastySurpriseCards(final Integer value) {
        nastySurpriseCards = value;
    }

    @Override
    public final void setSpecialMoveCards(final Integer value) {
        specialMoveCards = value;
    }

    @Override
    public final void setTeamPlayers(final List<String> players) {
        teamPlayers = players;
    }

    @Override
    public final void setTeamValue(final Integer value) {
        teamValue = value;
    }

    @Override
    public final void setWagers(final Integer value) {
        wagers = value;
    }

}
