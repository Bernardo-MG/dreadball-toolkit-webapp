
package com.wandrell.tabletop.dreadball.web.toolkit.controller.builder;

import static com.google.common.base.Preconditions.checkNotNull;

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

import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.web.toolkit.model.form.SponsorForm;
import com.wandrell.tabletop.dreadball.web.toolkit.service.builder.DbxTeamBuilderService;

@Controller
@RequestMapping("/builder/team/dbx")
public class DbxTeamBuilderController {

    private final DbxTeamBuilderService dbxTeamBuilderService;

    @Autowired
    public DbxTeamBuilderController(final DbxTeamBuilderService service) {
        super();

        dbxTeamBuilderService = checkNotNull(service,
                "Received a null pointer as DBX team builder service");
    }

    @RequestMapping(method = RequestMethod.POST)
    public final String checkSponsorInfo(final ModelMap model,
            @ModelAttribute("form") @Valid final SponsorForm form,
            final BindingResult bindingResult) {
        final String path;
        final Sponsor sponsor;

        if (bindingResult.hasErrors()) {
            // Affinity groups for the sponsors
            model.put("affinities",
                    getDbxTeamBuilderService().getSponsorAffinityGroups());
            path = "build/dbx/sponsor";
        } else {
            sponsor = getDbxTeamBuilderService().getSponsor(form);

            model.put("sponsor", sponsor);
            model.put("units", getDbxTeamBuilderService()
                    .getSponsorAvailableUnits(sponsor));

            path = "build/dbx/players";
        }

        return path;
    }

    @InitBinder
    public final void setAllowedFields(final WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping(method = RequestMethod.GET)
    public final String showSponsorForm(final ModelMap model,
            @ModelAttribute("form") final SponsorForm form) {
        // Affinity groups for the sponsors
        model.put("affinities",
                getDbxTeamBuilderService().getSponsorAffinityGroups());

        return "build/dbx/sponsor";
    }

    private final DbxTeamBuilderService getDbxTeamBuilderService() {
        return dbxTeamBuilderService;
    }

}
