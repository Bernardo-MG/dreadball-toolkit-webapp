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

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wandrell.tabletop.dreadball.codex.AffinityGroupCodex;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;

/**
 * Controller for the affinity groups codex views.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RestController
@RequestMapping("/rest/affinityGroups")
public class AffinityGroupCodexController {

    /**
     * Affinity groups codex service.
     */
    private final AffinityGroupCodex affinityGroupsCodexService;

    /**
     * Constructs a controller with the specified dependencies.
     * 
     * @param codex
     *            affinity groups codex service
     */
    public AffinityGroupCodexController(final AffinityGroupCodex codex) {
        super();

        affinityGroupsCodexService = checkNotNull(codex,
                "Received a null pointer as affinity groups codex service");
    }

    /**
     * Returns the view for all the affinity units.
     * 
     * @return the view for all the affinity units
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final Iterable<AffinityGroup> getDbxUnits() {
        return getAffinityGroupCodex().getAllAffinityGroups();
    }

    /**
     * Returns the affinity groups service.
     * 
     * @return the affinity groups service
     */
    private final AffinityGroupCodex getAffinityGroupCodex() {
        return affinityGroupsCodexService;
    }

}
