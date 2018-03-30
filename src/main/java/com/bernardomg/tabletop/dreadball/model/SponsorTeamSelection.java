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

package com.bernardomg.tabletop.dreadball.model;

import java.util.Collection;
import java.util.List;

/**
 * Data for creating a team. It contains the data selected by the user.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface SponsorTeamSelection {

    /**
     * Returns the Sponsor affinities.
     * 
     * @return the Sponsor affinities
     */
    public Collection<String> getAffinities();

    /**
     * Returns the Sponsor base rank.
     * 
     * @return the Sponsor base rank
     */
    public Integer getBaseRank();

    /**
     * Returns the number of cheerleaders.
     * 
     * @return the number of cheerleaders
     */
    public Integer getCheerleaders();

    /**
     * Returns the number of coaching dice.
     * 
     * @return the number of coaching dice
     */
    public Integer getCoachingDice();

    /**
     * Returns the number of medi-bots.
     * 
     * @return the number of medi-bots
     */
    public Integer getMediBots();

    /**
     * Returns the number of sabotage cards.
     * 
     * @return the number of sabotage cards
     */
    public Integer getNastySurpriseCards();

    /**
     * Returns the number of special move cards.
     * 
     * @return the number of special move cards
     */
    public Integer getSpecialMoveCards();

    /**
     * Returns the team players.
     * 
     * @return the team players
     */
    public Collection<String> getTeamPlayers();

    /**
     * Returns the team value.
     * 
     * @return the team value
     */
    public Integer getTeamValue();

    /**
     * Returns the number of wagers.
     * 
     * @return the number of wagers
     */
    public Integer getWagers();

    /**
     * Sets the Sponsor affinities.
     * 
     * @param affinities
     *            the sponsor affinities
     */
    public void setAffinities(final Collection<String> affinities);

    /**
     * Sets the Sponsor base rank.
     * 
     * @param baseRank
     *            the Sponsor base rank
     */
    public void setBaseRank(final Integer baseRank);

    /**
     * Sets the number of cheerleaders.
     * 
     * @param value
     *            the number of cheerleaders
     */
    public void setCheerleaders(final Integer value);

    /**
     * Sets the number of coaching die.
     * 
     * @param value
     *            the number of coaching die
     */
    public void setCoachingDice(final Integer value);

    /**
     * Sets the number of medi-bots.
     * 
     * @param value
     *            the number of medi-bots
     */
    public void setMediBots(final Integer value);

    /**
     * Sets the number of nasty surprise cards.
     * 
     * @param value
     *            the number of nasty surprise cards
     */
    public void setNastySurpriseCards(final Integer value);

    /**
     * Sets the number of special move cards.
     * 
     * @param value
     *            the number of special move cards
     */
    public void setSpecialMoveCards(final Integer value);

    /**
     * Sets the team players.
     * 
     * @param players
     *            the team players
     */
    public void setTeamPlayers(final List<String> players);

    /**
     * Sets the team value.
     * 
     * @param teamValue
     *            the team value
     */
    public void setTeamValue(final Integer teamValue);

    /**
     * Sets the number of wagers.
     * 
     * @param value
     *            the number of wagers
     */
    public void setWagers(final Integer value);

}
