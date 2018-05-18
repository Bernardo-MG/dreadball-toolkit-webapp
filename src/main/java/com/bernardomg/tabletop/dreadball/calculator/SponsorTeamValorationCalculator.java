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

package com.bernardomg.tabletop.dreadball.calculator;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.bernardomg.tabletop.dreadball.model.team.calculator.CostCalculator;

/**
 * Team valoration calculator for an {@code SponsorTeam}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class SponsorTeamValorationCalculator
        implements CostCalculator<SponsorTeam>, Serializable {

    /**
     * Serialization id.
     */
    private static final long serialVersionUID = -7111948173180755774L;

    /**
     * Cost of a Cheerleader.
     */
    private final Integer     costCheerleader;

    /**
     * Cost of a Coaching Die.
     */
    private final Integer     costDie;

    /**
     * Cost of a Medibot.
     */
    private final Integer     costMediBot;

    /**
     * Cost of a Sabotage Card.
     */
    private final Integer     costSabotage;

    /**
     * Cost of a Special Move Card.
     */
    private final Integer     costSpecialMove;

    /**
     * Cost of a Wager.
     */
    private final Integer     costWager;

    /**
     * Constructs a team valoration calculator using the specified cost.
     * <p>
     * These costs will be applied to the team assets to find out the final
     * cost.
     * 
     * @param dieCost
     *            cost of a Coaching Die
     * @param sabotageCost
     *            cost of a Sabotage Card
     * @param specialMoveCost
     *            cost of a Special Move Card
     * @param cheerleaderCost
     *            cost of a Cheerleader
     * @param wagerCost
     *            cost of a Wager
     * @param medibotCost
     *            cost of a Medibot
     */
    public SponsorTeamValorationCalculator(final Integer dieCost,
            final Integer sabotageCost, final Integer specialMoveCost,
            final Integer cheerleaderCost, final Integer wagerCost,
            final Integer medibotCost) {
        super();

        costDie = checkNotNull(dieCost,
                "Received a null pointer as the dice cost");
        costSabotage = checkNotNull(sabotageCost,
                "Received a null pointer as the sabotage card cost");
        costSpecialMove = checkNotNull(specialMoveCost,
                "Received a null pointer as the special move card cost");
        costCheerleader = checkNotNull(cheerleaderCost,
                "Received a null pointer as the cheerleader cost");
        costWager = checkNotNull(wagerCost,
                "Received a null pointer as the wager cost");
        costMediBot = checkNotNull(medibotCost,
                "Received a null pointer as the wager cost");
    }

    /**
     * Returns a team's valoration.
     * 
     * @param team
     *            the team of which the valoration will be calculated
     * @return the valoration of the team
     */
    @Override
    public final Integer getCost(final SponsorTeam team) {
        Integer valoration;

        checkNotNull(team, "Received a null pointer as the team");

        valoration = 0;
        for (final TeamPlayer player : team.getPlayers().values()) {
            valoration += player.getCost();
        }

        valoration += team.getCoachingDice() * getDieCost();
        valoration += team.getNastySurpriseCards() * getSabotageCost();
        valoration += team.getSpecialMoveCards() * getSpecialMoveCost();
        valoration += team.getWagers() * getWagerCost();
        valoration += team.getMediBots() * getMediBotCost();

        if (team.getCheerleaders() > 0) {
            // The cheerleaders have an unlocking cost
            valoration += getCheerleaderCost();
        }

        return valoration;
    }

    /**
     * Returns the cost of a cheerleader.
     * 
     * @return the cost of a cheerleader
     */
    private final Integer getCheerleaderCost() {
        return costCheerleader;
    }

    /**
     * Returns the cost of a die.
     * 
     * @return the cost of a die
     */
    private final Integer getDieCost() {
        return costDie;
    }

    /**
     * Returns the cost of a medibot.
     * 
     * @return the cost of a medibot
     */
    private final Integer getMediBotCost() {
        return costMediBot;
    }

    /**
     * Returns the cost of a sabotage card.
     * 
     * @return the cost of a sabotage card
     */
    private final Integer getSabotageCost() {
        return costSabotage;
    }

    /**
     * Returns the cost of a special move card.
     * 
     * @return the cost of a special move card
     */
    private final Integer getSpecialMoveCost() {
        return costSpecialMove;
    }

    /**
     * Returns the cost of a wager.
     * 
     * @return the cost of a wager
     */
    private final Integer getWagerCost() {
        return costWager;
    }

}
