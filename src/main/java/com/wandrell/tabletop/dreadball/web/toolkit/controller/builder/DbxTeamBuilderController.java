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

import com.wandrell.tabletop.dreadball.web.toolkit.model.form.SponsorForm;
import com.wandrell.tabletop.dreadball.web.toolkit.service.domain.availability.SponsorAffinityGroupAvailabilityService;

@Controller
@RequestMapping("/builder/team/dbx")
public class DbxTeamBuilderController {

	private final SponsorAffinityGroupAvailabilityService affinitiesAvasService;

	@Autowired
	public DbxTeamBuilderController(final SponsorAffinityGroupAvailabilityService affinitiesService) {
		super();

		affinitiesAvasService = checkNotNull(affinitiesService,
				"Received a null pointer as sponsor affinities availabilities service");
	}

	@RequestMapping(method = RequestMethod.POST)
	public final String checkSponsorInfo(final ModelMap model,
			@ModelAttribute("form") @Valid final SponsorForm form, final BindingResult bindingResult) {
		final String path;

		if (bindingResult.hasErrors()) {
			model.put("affinities",
					getSponsorAffinityGroupAvailabilityService().getAllSponsorAffinityGroupAvailabilities());
			path = "build/dbx/sponsor";
		} else {
			path = "build/dbx/players";
		}

		return path;
	}

	private final SponsorAffinityGroupAvailabilityService getSponsorAffinityGroupAvailabilityService() {
		return affinitiesAvasService;
	}

	@InitBinder
	public final void setAllowedFields(final WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(method = RequestMethod.GET)
	public final String showSponsorForm(final ModelMap model,
			@ModelAttribute("form") final SponsorForm form) {
		model.put("affinities",
				getSponsorAffinityGroupAvailabilityService().getAllSponsorAffinityGroupAvailabilities());

		return "build/dbx/sponsor";
	}

}
