package com.wandrell.tabletop.dreadball.web.toolkit.controller.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(method = RequestMethod.GET)
	public final String createSponsor(final ModelMap model) {
		model.put("affinities",
				getSponsorAffinityGroupAvailabilityService().getAllSponsorAffinityGroupAvailabilities());

		return "build/dbx/sponsor";
	}

	private final SponsorAffinityGroupAvailabilityService getSponsorAffinityGroupAvailabilityService() {
		return affinitiesAvasService;
	}

}
