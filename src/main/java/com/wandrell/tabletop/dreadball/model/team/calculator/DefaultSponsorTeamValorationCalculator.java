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

package com.wandrell.tabletop.dreadball.model.team.calculator;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.stereotype.Component;

import com.wandrell.tabletop.dreadball.build.dbx.SponsorCosts;
import com.wandrell.tabletop.dreadball.model.team.calculator.AbstractSponsorTeamValorationCalculator;

/**
 * Team valoration calculator for an {@code SponsorTeam}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Component
public final class DefaultSponsorTeamValorationCalculator
        extends AbstractSponsorTeamValorationCalculator {

    private final SponsorCosts costs;

    /**
     * Default constructor.
     */
    public DefaultSponsorTeamValorationCalculator(final SponsorCosts costs) {
        super();

        this.costs = checkNotNull(costs,
                "Received a null pointer as sponsor costs");
    }

    private final SponsorCosts getSponsorCosts() {
        return costs;
    }

    @Override
    protected final Integer getCheerleaderCost() {
        return getSponsorCosts().getCheerleaderCost();
    }

    @Override
    protected final Integer getDieCost() {
        return getSponsorCosts().getDieCost();
    }

    @Override
    protected final Integer getMediBotCost() {
        return getSponsorCosts().getMediBotCost();
    }

    @Override
    protected final Integer getSabotageCost() {
        return getSponsorCosts().getSabotageCost();
    }

    @Override
    protected final Integer getSpecialMoveCost() {
        return getSponsorCosts().getSpecialMoveCost();
    }

    @Override
    protected final Integer getWagerCost() {
        return getSponsorCosts().getWagerCost();
    }

}
