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

package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wandrell.tabletop.dreadball.build.dbx.DbxSponsorBuilder;
import com.wandrell.tabletop.dreadball.factory.DbxModelFactory;
import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorForm;

/**
 * Controller for the DBX Sponsor building view.
 * <p>
 * The team to be edited is stored as a session variable.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RestController
@RequestMapping("/builder/team/dbx")
public class SponsorCreationController {

    /**
     * Parameter name for the team.
     */
    private static final String     PARAM_TEAM = "team";

    /**
     * DBX model factory.
     */
    private final DbxModelFactory   dbxModelFact;

    /**
     * DBX team builder service.
     */
    private final DbxSponsorBuilder sponsorCreationService;

    /**
     * Constructs a controller with the specified dependencies.
     * 
     * @param service
     *            the sponsor creation service
     * @param modelFact
     *            the model factory
     */
    @Autowired
    public SponsorCreationController(final DbxSponsorBuilder service,
            final DbxModelFactory modelFact) {
        super();

        sponsorCreationService = checkNotNull(service,
                "Received a null pointer as sponsor creation service");
        dbxModelFact = checkNotNull(modelFact,
                "Received a null pointer as model factory");
    }

    @GetMapping(path = "/affinities/initial",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Deprecated
    public final Iterable<SponsorAffinityGroupAvailability>
            getInitialAffinityGroups() {
        return getDbxSponsorCreationService().getAvailableAffinityGroups();
    }

    @PostMapping(path = "/sponsor", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final SponsorTeam setSponsor(
            @RequestBody @Valid final SponsorForm form,
            final BindingResult errors, final HttpSession session)
            throws BindException {
        final Sponsor sponsor;  // Sponsor data
        final SponsorTeam team; // Sponsor team

        if (errors.hasErrors()) {
            throw new BindException(errors);
        }

        sponsor = getDbxModelFactory().getSponsor(form);
        team = getDbxModelFactory().getSponsorTeam(sponsor);

        // TODO: What if the team is already in session?
        session.setAttribute(PARAM_TEAM, team);

        return team;
    }

    /**
     * Returns the model factory.
     * 
     * @return the model factory
     */
    private final DbxModelFactory getDbxModelFactory() {
        return dbxModelFact;
    }

    /**
     * Returns the DBX team builder service.
     * 
     * @return the DBX team builder service
     */
    private final DbxSponsorBuilder getDbxSponsorCreationService() {
        return sponsorCreationService;
    }

}
