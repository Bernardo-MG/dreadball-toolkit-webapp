/**
 * Copyright 2016 the original author or authors
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

package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Form data for the Sponsor team assets.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public class SponsorTeamAssets {

    /**
     * Number of cheerleaders.
     */
    @NotNull
    @Min(0)
    private Integer cheerleaders     = 0;

    /**
     * Number of coaching dice.
     */
    @NotNull
    @Min(0)
    private Integer coachingDice     = 0;

    /**
     * Number of medi-bots.
     */
    @NotNull
    @Min(0)
    private Integer mediBots         = 0;

    /**
     * Number of sabotage cards.
     */
    @NotNull
    @Min(0)
    private Integer sabotageCards    = 0;

    /**
     * Number of special move cards.
     */
    @NotNull
    @Min(0)
    private Integer specialMoveCards = 0;

    /**
     * Number of wagers.
     */
    @NotNull
    @Min(0)
    private Integer wagers           = 0;

    /**
     * Default constructor.
     */
    public SponsorTeamAssets() {
        super();
    }

    /**
     * Returns the number of cheerleaders.
     * 
     * @return the number of cheerleaders
     */
    public final Integer getCheerleaders() {
        return cheerleaders;
    }

    /**
     * Returns the number of coaching dice.
     * 
     * @return the number of coaching dice
     */
    public final Integer getCoachingDice() {
        return coachingDice;
    }

    /**
     * Returns the number of medi-bots.
     * 
     * @return the number of medi-bots
     */
    public final Integer getMediBots() {
        return mediBots;
    }

    /**
     * Returns the number of sabotage cards.
     * 
     * @return the number of sabotage cards
     */
    public final Integer getSabotageCards() {
        return sabotageCards;
    }

    /**
     * Returns the number of special move cards.
     * 
     * @return the number of special move cards
     */
    public final Integer getSpecialMoveCards() {
        return specialMoveCards;
    }

    /**
     * Returns the number of wagers.
     * 
     * @return the number of wagers
     */
    public final Integer getWagers() {
        return wagers;
    }

    /**
     * Sets the number of cheerleaders.
     * 
     * @param cheerleaders
     *            the number of cheerleaders
     */
    public final void setCheerleaders(final Integer cheerleaders) {
        this.cheerleaders = cheerleaders;
    }

    /**
     * Sets the number of coaching dice.
     * 
     * @param coachingDice
     *            the number of coaching dice
     */
    public final void setCoachingDice(final Integer coachingDice) {
        this.coachingDice = coachingDice;
    }

    /**
     * Sets the number of medibots.
     * 
     * @param medibots
     *            the number of medibots
     */
    public final void setMediBots(final Integer medibots) {
        this.mediBots = medibots;
    }

    /**
     * Sets the number of sabotage cards.
     * 
     * @param sabotageCards
     *            the number of sabotage cards
     */
    public final void setSabotageCards(final Integer sabotageCards) {
        this.sabotageCards = sabotageCards;
    }

    /**
     * Sets the number of special move cards.
     * 
     * @param specialMoveCards
     *            the number of special move cards
     */
    public final void setSpecialMoveCards(final Integer specialMoveCards) {
        this.specialMoveCards = specialMoveCards;
    }

    /**
     * Sets the number of wagers.
     * 
     * @param wagers
     *            the number of wagers
     */
    public final void setWagers(final Integer wagers) {
        this.wagers = wagers;
    }

}
