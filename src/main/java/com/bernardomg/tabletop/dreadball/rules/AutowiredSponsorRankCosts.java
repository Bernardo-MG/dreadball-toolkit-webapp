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

package com.bernardomg.tabletop.dreadball.rules;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bernardomg.tabletop.dreadball.model.availability.asset.SponsorAssetsAvailability;

/**
 * Service implementation of the {@code SponsorCosts}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Service("SponsorRankCosts")
public class AutowiredSponsorRankCosts implements SponsorAssetsAvailability {

    @Value("${sponsor.asset.cheerleader.rank}")
    private Integer cheerleaderRank;

    @Value("${sponsor.asset.die.rank}")
    private Integer dieRank;

    @Value("${sponsor.asset.medibot.rank}")
    private Integer medibotRank;

    @Value("${sponsor.asset.move.rank}")
    private Integer moveRank;

    @Value("${sponsor.asset.sabotage.rank}")
    private Integer sabotageRank;

    @Value("${sponsor.asset.wager.rank}")
    private Integer wagerRank;

    /**
     * Constructs a builder with the specified dependencies.
     */
    public AutowiredSponsorRankCosts() {
        super();
    }

    @Override
    public final Integer getAffinityGroupCost() {
        return 0;
    }

    @Override
    public final Integer getCheerleaderCost() {
        return cheerleaderRank;
    }

    @Override
    public final Integer getCoachingDieCost() {
        return dieRank;
    }

    @Override
    public final Integer getMediBotCost() {
        return medibotRank;
    }

    @Override
    public final Integer getNastySurpriseCardCost() {
        return sabotageRank;
    }

    @Override
    public final Integer getSpecialMoveCardCost() {
        return moveRank;
    }

    @Override
    public final Integer getWagerCost() {
        return wagerRank;
    }

}
