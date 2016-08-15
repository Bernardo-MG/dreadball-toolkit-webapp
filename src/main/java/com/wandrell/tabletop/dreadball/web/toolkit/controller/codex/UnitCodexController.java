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
