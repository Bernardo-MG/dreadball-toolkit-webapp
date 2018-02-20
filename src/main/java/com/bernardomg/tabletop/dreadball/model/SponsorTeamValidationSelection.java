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

/**
 * Form data for the Sponsor team assets.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface SponsorTeamValidationSelection {

    public Collection<String> getAffinities();

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

    public Integer getTeamValue();

    public Collection<String> getUnits();

    /**
     * Returns the number of wagers.
     * 
     * @return the number of wagers
     */
    public Integer getWagers();

}
