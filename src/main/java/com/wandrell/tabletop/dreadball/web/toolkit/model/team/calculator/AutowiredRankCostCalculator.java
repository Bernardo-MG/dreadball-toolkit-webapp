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

package com.wandrell.tabletop.dreadball.web.toolkit.model.team.calculator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.wandrell.tabletop.dreadball.model.team.calculator.AbstractRankCostCalculator;

/**
 * Rank cost calculator.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Component
public final class AutowiredRankCostCalculator
        extends AbstractRankCostCalculator {

    /**
     * Cost of a Cheerleader.
     */
    @Value("${sponsor.asset.cheerleader.rank}")
    private Integer costCheerleader;

    /**
     * Cost of a Coaching Die.
     */
    @Value("${sponsor.asset.die.rank}")
    private Integer costDie;

    /**
     * Cost of a Medibot.
     */
    @Value("${sponsor.asset.medibot.rank}")
    private Integer costMediBot;

    /**
     * Cost of a Sabotage Card.
     */
    @Value("${sponsor.asset.sabotage.rank}")
    private Integer costSabotage;

    /**
     * Cost of a Special Move Card.
     */
    @Value("${sponsor.asset.move.rank}")
    private Integer costSpecialMove;

    /**
     * Cost of a Wager.
     */
    @Value("${sponsor.asset.wager.rank}")
    private Integer costWager;

    /**
     * Default constructor
     */
    public AutowiredRankCostCalculator() {
        super();
    }

    /**
     * Returns the cost of a cheerleader.
     * 
     * @return the cost of a cheerleader
     */
    @Override
    protected final Integer getCheerleaderCost() {
        return costCheerleader;
    }

    /**
     * Returns the cost of a die.
     * 
     * @return the cost of a die
     */
    @Override
    protected final Integer getDieCost() {
        return costDie;
    }

    /**
     * Returns the cost of a medibot.
     * 
     * @return the cost of a medibot
     */
    @Override
    protected final Integer getMediBotCost() {
        return costMediBot;
    }

    /**
     * Returns the cost of a sabotage card.
     * 
     * @return the cost of a sabotage card
     */
    @Override
    protected final Integer getSabotageCost() {
        return costSabotage;
    }

    /**
     * Returns the cost of a special move card.
     * 
     * @return the cost of a special move card
     */
    @Override
    protected final Integer getSpecialMoveCost() {
        return costSpecialMove;
    }

    /**
     * Returns the cost of a wager.
     * 
     * @return the cost of a wager
     */
    @Override
    protected final Integer getWagerCost() {
        return costWager;
    }

}
