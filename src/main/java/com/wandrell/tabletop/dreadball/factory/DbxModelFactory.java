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

package com.wandrell.tabletop.dreadball.factory;

import java.util.Collection;

import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.Role;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.Attributes;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorForm;

/**
 * Service used to instantiate model classes.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface DbxModelFactory {

    /**
     * Creates an Sponsor from the form data.
     * 
     * @param form
     *            sponsor form data
     * @return the Sponsor created from the form
     */
    public Sponsor getSponsor(final SponsorForm form);

    /**
     * Creates an Sponsor team from the specified Sponsor.
     * 
     * @param sponsor
     *            Sponsor for the team
     * @return a Sponsor team for the specified Sponsor
     */
    public SponsorTeam getSponsorTeam(final Sponsor sponsor);

    /**
     * Creates a Unit from the specified arguments.
     * 
     * @param nameTemplate
     *            the unit's base template name
     * @param cost
     *            cost of the unit
     * @param role
     *            team position role of the unit
     * @param attributes
     *            unit attributes
     * @param abilities
     *            unit abilities
     * @param mvp
     *            flag indicating if this is a MVP
     * @param giant
     *            flag indicating if this is a giant
     * @return a new Unit
     */
    public Unit getUnit(final String nameTemplate, final Integer cost,
            final Role role, final Attributes attributes,
            final Collection<Ability> abilities, final Boolean mvp,
            final Boolean giant);

    /**
     * Returns the unit created from the specified template and set up for the
     * correct affinity level.
     * <p>
     * The affinity level will be marked by the received affinities, and the
     * affinities owned by the unit.
     * 
     * @param templateName
     *            template to create the unit from
     * @param affinities
     *            affinities to find out the affinity level
     * @return the unit created
     */
    public Unit getUnit(final String templateName,
            final Iterable<AffinityGroup> affinities);

}
