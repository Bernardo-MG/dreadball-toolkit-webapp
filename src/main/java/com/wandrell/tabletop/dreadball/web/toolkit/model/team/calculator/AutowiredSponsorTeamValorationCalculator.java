/**
 * Copyright 2015-2016 the original author or authors
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

import com.wandrell.tabletop.dreadball.model.team.calculator.AbstractSponsorTeamValorationCalculator;

/**
 * Team valoration calculator for an {@code SponsorTeam}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Component
public final class AutowiredSponsorTeamValorationCalculator
        extends AbstractSponsorTeamValorationCalculator {

    /**
     * Cost of a Cheerleader.
     */
    @Value("${sponsor.asset.cheerleader.cost}")
    private Integer costCheerleader;

    /**
     * Cost of a Coaching Die.
     */
    @Value("${sponsor.asset.die.cost}")
    private Integer costDie;

    /**
     * Cost of a Medibot.
     */
    @Value("${sponsor.asset.medibot.cost}")
    private Integer costMediBot;

    /**
     * Cost of a Sabotage Card.
     */
    @Value("${sponsor.asset.sabotage.cost}")
    private Integer costSabotage;

    /**
     * Cost of a Special Move Card.
     */
    @Value("${sponsor.asset.move.cost}")
    private Integer costSpecialMove;

    /**
     * Cost of a Wager.
     */
    @Value("${sponsor.asset.wager.cost}")
    private Integer costWager;

    /**
     * Default constructor
     */
    public AutowiredSponsorTeamValorationCalculator() {
        super();
    }

    @Override
    protected final Integer getCheerleaderCost() {
        return costCheerleader;
    }

    @Override
    protected final Integer getDieCost() {
        return costDie;
    }

    @Override
    protected final Integer getMediBotCost() {
        return costMediBot;
    }

    @Override
    protected final Integer getSabotageCost() {
        return costSabotage;
    }

    @Override
    protected final Integer getSpecialMoveCost() {
        return costSpecialMove;
    }

    @Override
    protected final Integer getWagerCost() {
        return costWager;
    }

}
