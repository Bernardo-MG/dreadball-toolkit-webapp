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

package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.build.dbx.DbxSponsorBuilder;

/**
 * Default implementation of the {@code DbxSponsorBuilder}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Service
public class DefaultDbxSponsorBuilder implements DbxSponsorBuilder {

    @Value("${sponsor.asset.cheerleader.cost}")
    private Integer cheerleaderCost;

    @Value("${sponsor.asset.cheerleader.rank}")
    private Integer cheerleaderRank;

    @Value("${sponsor.asset.die.cost}")
    private Integer dieCost;

    @Value("${sponsor.asset.die.rank}")
    private Integer dieRank;

    /**
     * Initial rank.
     */
    @Value("${sponsor.rank.initial}")
    private Integer initialRank;

    @Value("${sponsor.asset.medibot.cost}")
    private Integer medibotCost;

    @Value("${sponsor.asset.medibot.rank}")
    private Integer medibotRank;

    @Value("${sponsor.asset.move.cost}")
    private Integer moveCost;

    @Value("${sponsor.asset.move.rank}")
    private Integer moveRank;

    @Value("${sponsor.asset.sabotage.cost}")
    private Integer sabotageCost;

    @Value("${sponsor.asset.sabotage.rank}")
    private Integer sabotageRank;

    @Value("${sponsor.asset.wager.cost}")
    private Integer wagerCost;

    @Value("${sponsor.asset.wager.rank}")
    private Integer wagerRank;

    /**
     * Constructs a builder with the specified dependencies.
     */
    public DefaultDbxSponsorBuilder() {
        super();
    }

    @Override
    public Integer getCheerleaderCost() {
        return cheerleaderCost;
    }

    @Override
    public Integer getCheerleaderRank() {
        return cheerleaderRank;
    }

    @Override
    public Integer getDieCost() {
        return dieCost;
    }

    @Override
    public Integer getDieRank() {
        return dieRank;
    }

    @Override
    public final Integer getInitialRank() {
        return initialRank;
    }

    @Override
    public Integer getMedibotCost() {
        return medibotCost;
    }

    @Override
    public Integer getMedibotRank() {
        return medibotRank;
    }

    @Override
    public Integer getMoveCost() {
        return moveCost;
    }

    @Override
    public Integer getMoveRank() {
        return moveRank;
    }

    @Override
    public Integer getSabotageCost() {
        return sabotageCost;
    }

    @Override
    public Integer getSabotageRank() {
        return sabotageRank;
    }

    @Override
    public Integer getWagerCost() {
        return wagerCost;
    }

    @Override
    public Integer getWagerRank() {
        return wagerRank;
    }

}
