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

package com.wandrell.tabletop.dreadball.model.team.calculator;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.stereotype.Component;

import com.wandrell.tabletop.dreadball.build.dbx.SponsorCosts;
import com.wandrell.tabletop.dreadball.model.team.calculator.AbstractRankCostCalculator;

/**
 * Rank cost calculator.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Component
public final class DefaultRankCostCalculator
        extends AbstractRankCostCalculator {

    private final SponsorCosts costs;

    /**
     * Default constructor.
     */
    public DefaultRankCostCalculator(final SponsorCosts costs) {
        super();

        this.costs = checkNotNull(costs,
                "Received a null pointer as sponsor costs");
    }

    private final SponsorCosts getSponsorCosts() {
        return costs;
    }

    /**
     * Returns the cost of a cheerleader.
     * 
     * @return the cost of a cheerleader
     */
    @Override
    protected final Integer getCheerleaderCost() {
        return getSponsorCosts().getCheerleaderRank();
    }

    /**
     * Returns the cost of a die.
     * 
     * @return the cost of a die
     */
    @Override
    protected final Integer getDieCost() {
        return getSponsorCosts().getDieRank();
    }

    /**
     * Returns the cost of a medibot.
     * 
     * @return the cost of a medibot
     */
    @Override
    protected final Integer getMediBotCost() {
        return getSponsorCosts().getMediBotRank();
    }

    /**
     * Returns the cost of a sabotage card.
     * 
     * @return the cost of a sabotage card
     */
    @Override
    protected final Integer getSabotageCost() {
        return getSponsorCosts().getSabotageRank();
    }

    /**
     * Returns the cost of a special move card.
     * 
     * @return the cost of a special move card
     */
    @Override
    protected final Integer getSpecialMoveCost() {
        return getSponsorCosts().getSpecialMoveRank();
    }

    /**
     * Returns the cost of a wager.
     * 
     * @return the cost of a wager
     */
    @Override
    protected final Integer getWagerCost() {
        return getSponsorCosts().getWagerRank();
    }

}
