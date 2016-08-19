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

package com.wandrell.tabletop.dreadball.web.toolkit.controller.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.web.toolkit.model.form.SponsorForm;
import com.wandrell.tabletop.dreadball.web.toolkit.service.builder.dbx.DbxSponsorCreationService;

/**
 * Controller for the DBX Sponsor building view.
 * <p>
 * The team to be edited is stored as a session variable.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Controller
@RequestMapping("/builder/team/dbx")
public class SponsorCreationController {

    /**
     * Sponsor bean parameter name.
     */
    private static final String             BEAN_SPONSOR            = "form";

    /**
     * Parameter name for the affinities.
     */
    private static final String             PARAM_AFFINITIES        = "affinities";

    /**
     * Parameter name for the available players.
     */
    private static final String             PARAM_AVAILABLE_PLAYERS = "availablePlayers";

    /**
     * Parameter name for the initial rank.
     */
    private static final String             PARAM_INITIAL_RANK      = "initialRank";

    /**
     * Parameter name for the sponsor.
     */
    private static final String             PARAM_SPONSOR           = "sponsor";

    /**
     * Parameter name for the team.
     */
    private static final String             PARAM_TEAM              = "team";

    /**
     * Name for the view after the sponsor view.
     */
    private static final String             VIEW_NEXT               = "build/dbx/players";

    /**
     * Name for the sponsor view.
     */
    private static final String             VIEW_SPONSOR            = "build/dbx/sponsor";

    /**
     * DBX team builder service.
     */
    private final DbxSponsorCreationService sponsorCreationService;

    /**
     * Constructs a controller with the specified dependencies.
     * 
     * @param service
     *            the DBX team builder service
     */
    @Autowired
    public SponsorCreationController(final DbxSponsorCreationService service) {
        super();

        sponsorCreationService = checkNotNull(service,
                "Received a null pointer as sponsor creation service");
    }

    /**
     * Checks the sponsor info before moving to the next view.
     * <p>
     * If the data is invalid then the view returns to the Sponsor edition view,
     * otherwise it moves to the next view.
     * 
     * @param model
     *            model map
     * @param sponsor
     *            sponsor form data
     * @param bindingResult
     *            binding result data
     * @param session
     *            session data
     * @return the name for the view to show
     */
    @RequestMapping(method = RequestMethod.POST)
    public final String checkSponsorInfo(final ModelMap model,
            @ModelAttribute(BEAN_SPONSOR) @Valid final SponsorForm sponsor,
            final BindingResult bindingResult, final HttpSession session) {
        final String path;

        if (bindingResult.hasErrors()) {
            // Invalid sponsor data

            // Loads required data into the model
            loadSponsorModel(model);
            // Returns to the sponsor creation view
            path = VIEW_SPONSOR;
        } else {
            // Loads required data into the model and session
            loadNextStepModel(model, session, sponsor);

            path = VIEW_NEXT;
        }

        return path;
    }

    /**
     * Returns the initial Sponsor form data.
     * 
     * @return the initial Sponsor form data
     */
    @ModelAttribute(BEAN_SPONSOR)
    public final SponsorForm getSponsorForm() {
        // TODO: Acquire through the service
        return new SponsorForm();
    }

    /**
     * Shows the sponsor edition view.
     * 
     * @param model
     *            model map
     * @param status
     *            session status
     * @return the name for the sponsor edition view
     */
    @RequestMapping(method = RequestMethod.GET)
    public final String showSponsorForm(final ModelMap model,
            final SessionStatus status) {
        // Clears session
        status.setComplete();

        // Loads required data into the model
        loadSponsorModel(model);

        return VIEW_SPONSOR;
    }

    /**
     * Returns the DBX team builder service.
     * 
     * @return the DBX team builder service
     */
    private final DbxSponsorCreationService getDbxSponsorCreationService() {
        return sponsorCreationService;
    }

    /**
     * Loads the model data required for the next step.
     * 
     * @param model
     *            model map
     * @param session
     *            session data
     * @param form
     *            Sponsor form data
     */
    private final void loadNextStepModel(final ModelMap model,
            final HttpSession session, final SponsorForm form) {
        final Sponsor sponsor;  // Sponsor data
        final SponsorTeam team; // Sponsor team

        sponsor = getDbxSponsorCreationService().getSponsor(form);
        team = getDbxSponsorCreationService().getSponsorTeam(sponsor);

        session.setAttribute(PARAM_TEAM, team);

        model.put(PARAM_SPONSOR, sponsor);
        model.put(PARAM_TEAM, team);
        model.put(PARAM_AVAILABLE_PLAYERS, getDbxSponsorCreationService()
                .getSponsorTeamAvailableUnits(team));
    }

    /**
     * Loads the model data required for the Sponsor edition view.
     * 
     * @param model
     *            model map
     */
    private final void loadSponsorModel(final ModelMap model) {
        // Initial sponsor rank
        model.put(PARAM_INITIAL_RANK,
                getDbxSponsorCreationService().getInitialRank());
        // Affinity groups for the sponsors
        model.put(PARAM_AFFINITIES,
                getDbxSponsorCreationService().getSponsorAffinityGroups());
    }

}
