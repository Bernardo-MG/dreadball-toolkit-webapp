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

package com.wandrell.tabletop.dreadball.web.toolkit.factory;

import org.springframework.beans.factory.annotation.Value;

/**
 * Default implementation of the DBX values service.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public class SpringDbxValuesFactory implements DbxValuesFactory {

    /**
     * Initial rank.
     */
    @Value("${sponsor.rank.initial}")
    private Integer initialRank;

    /**
     * Maximum number of units a Sponsor may have.
     */
    @Value("${sponsor.players.max}")
    private Integer maxTeamUnits;

    /**
     * Default constructor.
     */
    public SpringDbxValuesFactory() {
        super();
    }

    @Override
    public final Integer getInitialRank() {
        return initialRank;
    }

    @Override
    public final Integer getMaxTeamUnits() {
        return maxTeamUnits;
    }

}
