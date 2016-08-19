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

package com.wandrell.tabletop.dreadball.web.toolkit.controller.codex;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wandrell.tabletop.dreadball.web.toolkit.codex.UnitCodex;

/**
 * Controller for the unit codex views.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Controller
@RequestMapping("/codex/unit")
public class UnitCodexController {

    /**
     * Parameter name for the players.
     */
    private static final String PARAM_PLAYERS       = "players";

    /**
     * Name for the affinity units view.
     */
    private static final String VIEW_AFFINITY_UNITS = "codex/affinityUnits";

    /**
     * Unit codex service.
     */
    private final UnitCodex     unitCodexService;

    /**
     * Constructs a controller with the specified dependencies.
     * 
     * @param service
     *            the unit codex service
     */
    @Autowired
    public UnitCodexController(final UnitCodex service) {
        super();

        unitCodexService = checkNotNull(service,
                "Received a null pointer as unit service");
    }

    /**
     * Returns the view for all the affinity units.
     * 
     * @param model
     *            model map
     * @return the view for all the affinity units
     */
    @RequestMapping(method = RequestMethod.GET)
    public final String getAllAffinityUnits(final ModelMap model) {
        model.put(PARAM_PLAYERS, getUnitCodexService().getAllAffinityUnits());

        return VIEW_AFFINITY_UNITS;
    }

    /**
     * Returns the unit codex service.
     * 
     * @return the unit codex service
     */
    private final UnitCodex getUnitCodexService() {
        return unitCodexService;
    }

}
