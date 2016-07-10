
package com.wandrell.tabletop.dreadball.web.toolkit.controller.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.web.toolkit.model.form.SponsorForm;
import com.wandrell.tabletop.dreadball.web.toolkit.service.builder.DbxTeamBuilderService;

@Controller
@RequestMapping("/builder/team/dbx")
public class SponsorCreationController {

    private static final String         BEAN_SPONSOR          = "form";

    private static final String         PATH_SPONSOR          = "build/dbx/sponsor";

    private static final String         PATH_NEXT             = "build/dbx/players";

    private static final String         KEY_SPONSOR           = "sponsor";

    private static final String         KEY_TEAM              = "team";

    private static final String         KEY_AVAILABLE_PLAYERS = "availablePlayers";

    private static final String         KEY_INITIAL_RANK      = "initialRank";

    private static final String         KEY_AFFINITIES        = "affinities";

    private final DbxTeamBuilderService dbxTeamBuilderService;

    @Autowired
    public SponsorCreationController(final DbxTeamBuilderService service) {
        super();

        dbxTeamBuilderService = checkNotNull(service,
                "Received a null pointer as DBX team builder service");
    }

    @RequestMapping(method = RequestMethod.POST)
    public final String checkSponsorInfo(final ModelMap model,
            @ModelAttribute(BEAN_SPONSOR) @Valid final SponsorForm form,
            final BindingResult bindingResult, final HttpSession session) {
        final String path;

        if (bindingResult.hasErrors()) {
            // Loads required data into the model
            loadSponsorModel(model);
            // Returns to the sponsor creation view
            path = PATH_SPONSOR;
        } else {
            // Loads required data into the model and session
            loadNextStepModel(model, session, form);

            path = PATH_NEXT;
        }

        return path;
    }

    @InitBinder
    public final void setAllowedFields(final WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping(method = RequestMethod.GET)
    public final String showSponsorForm(final ModelMap model,
            @ModelAttribute(BEAN_SPONSOR) final SponsorForm form,
            final SessionStatus status) {

        // Clears session
        status.setComplete();

        // Loads required data into the model
        loadSponsorModel(model);

        return PATH_SPONSOR;
    }

    private final DbxTeamBuilderService getDbxTeamBuilderService() {
        return dbxTeamBuilderService;
    }

    private void loadNextStepModel(final ModelMap model,
            final HttpSession session, final SponsorForm form) {
        final Sponsor sponsor;
        final SponsorTeam team;

        sponsor = getDbxTeamBuilderService().getSponsor(form);
        team = getDbxTeamBuilderService().getSponsorTeam(sponsor);

        session.setAttribute(KEY_TEAM, team);

        model.put(KEY_SPONSOR, sponsor);
        model.put(KEY_TEAM, team);
        model.put(KEY_AVAILABLE_PLAYERS,
                getDbxTeamBuilderService().getSponsorTeamAvailableUnits(team));
    }

    private final void loadSponsorModel(final ModelMap model) {
        // Initial sponsor rank
        model.put(KEY_INITIAL_RANK,
                getDbxTeamBuilderService().getInitialRank());
        // Affinity groups for the sponsors
        model.put(KEY_AFFINITIES,
                getDbxTeamBuilderService().getSponsorAffinityGroups());
    }

}
