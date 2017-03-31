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

package com.wandrell.tabletop.dreadball.web.toolkit.codex.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wandrell.tabletop.dreadball.codex.UnitCodex;
import com.wandrell.tabletop.dreadball.model.unit.DefaultAffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.Unit;

/**
 * Controller for the unit codex views.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RestController
@RequestMapping("/rest/units")
public class UnitCodexController {

    /**
     * Unit codex service.
     */
    private final UnitCodex unitCodexService;

    /**
     * Constructs a controller with the specified dependencies.
     * 
     * @param codex
     *            unit codex service
     */
    public UnitCodexController(final UnitCodex codex) {
        super();

        unitCodexService = checkNotNull(codex,
                "Received a null pointer as unit codex service");
    }

    /**
     * Returns the view for all the affinity units.
     * 
     * @return the view for all the affinity units
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final Iterable<? extends Unit> getDbxUnits(@RequestParam(
            value = "affinities", required = false,
            defaultValue = "") final ArrayList<DefaultAffinityGroup> affinities) {
        final Iterable<? extends Unit> units;

        if (affinities.isEmpty()) {
            units = getUnitCodexService().getAllAffinityUnits();
        } else {
            units = getUnitCodexService().getAllAffinityUnits(affinities);
        }

        return units;
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
