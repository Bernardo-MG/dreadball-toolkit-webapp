
package com.wandrell.tabletop.dreadball.web.toolkit.controller.codex;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wandrell.tabletop.dreadball.web.toolkit.service.codex.UnitCodexService;

@Controller
@RequestMapping("/codex/unit")
public class UnitCodexController {

    private static final String    PATH_AFFINITY_UNITS = "codex/affinityUnits";

    private static final String    PARAM_PLAYERS       = "players";

    private final UnitCodexService unitCodexService;

    @Autowired
    public UnitCodexController(final UnitCodexService service) {
        super();

        unitCodexService = checkNotNull(service,
                "Received a null pointer as unit service");
    }

    @RequestMapping(method = RequestMethod.GET)
    public final String getAllUnits(final ModelMap model) {
        model.put(PARAM_PLAYERS, getUnitCodexService().getAllUnits());

        return PATH_AFFINITY_UNITS;
    }

    private final UnitCodexService getUnitCodexService() {
        return unitCodexService;
    }

}
