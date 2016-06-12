package com.wandrell.tabletop.dreadball.web.toolkit.controller.codex;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.UnitRepository;

@Controller
@RequestMapping("/codex/unit")
public class UnitCodexController {

	final UnitRepository unitRepo;

	@Autowired
	public UnitCodexController(final UnitRepository unitRepository) {
		super();

		unitRepo = checkNotNull(unitRepository);
	}

	@RequestMapping(method = RequestMethod.GET)
	public final String getAllUnits(final ModelMap model) {
		model.put("players", getUnitRepository().findAll());

		return "unitsList";
	}

	private final UnitRepository getUnitRepository() {
		return unitRepo;
	}

}
