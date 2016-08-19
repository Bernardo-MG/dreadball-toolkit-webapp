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

package com.wandrell.tabletop.dreadball.web.toolkit.service.builder.dbx;

import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;

/**
 * Facade service for the DBX team builder.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface DbxTeamBuilderService
        extends DbxValuesService, DbxModelService, DbxAvailabilitiesService {

    /**
     * Adds a unit to the specified team.
     * <p>
     * The unit will be acquired through its template name.
     * 
     * @param team
     *            team where the unit will be added
     * @param templateName
     *            name of the template to add
     */
    public void addUnit(final SponsorTeam team, final String templateName);

}
