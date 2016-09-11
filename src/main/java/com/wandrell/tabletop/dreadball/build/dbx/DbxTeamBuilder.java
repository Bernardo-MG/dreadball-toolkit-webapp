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

package com.wandrell.tabletop.dreadball.build.dbx;

import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.unit.Unit;

/**
 * Facade service for the DBX team builder.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface DbxTeamBuilder {

    /**
     * Returns the maximum number of units a Sponsor may have.
     * 
     * @return the Sponsors maximum number of units
     */
    public Integer getMaxTeamUnits();

    /**
     * Returns the unit created from the specified template and set up for the
     * received sponsor.
     * 
     * @param sponsor
     *            Sponsor for which the unit is prepared
     * @param templateName
     *            template to create the unit from
     * @return the unit created
     */
    public Unit getUnit(final Sponsor sponsor, final String templateName);

}
