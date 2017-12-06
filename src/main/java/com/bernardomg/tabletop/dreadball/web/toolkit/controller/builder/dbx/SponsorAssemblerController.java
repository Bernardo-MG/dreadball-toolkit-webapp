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

package com.bernardomg.tabletop.dreadball.web.toolkit.controller.builder.dbx;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bernardomg.tabletop.dreadball.build.dbx.model.DefaultSponsorTeamAssets;
import com.bernardomg.tabletop.dreadball.build.dbx.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.build.dbx.model.SponsorTeamSelection;
import com.bernardomg.tabletop.dreadball.build.dbx.service.SponsorBuilderService;

/**
 * Controller for the affinity groups codex views.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RestController
@RequestMapping("/rest/builder/validation")
public class SponsorAssemblerController {

    private final SponsorBuilderService builderService;

    /**
     * Constructs a controller with the specified dependencies.
     * 
     * @param sponsorBuilderService
     *            sponsor builder service
     */
    @Autowired
    public SponsorAssemblerController(
            final SponsorBuilderService sponsorBuilderService) {
        super();

        builderService = checkNotNull(sponsorBuilderService,
                "Received a null pointer as sponsor builder service");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final SponsorTeamSelection
            getSelectionResult(@RequestParam(name = "affinities",
                    defaultValue = "") final ArrayList<String> affinities,
                    @RequestParam(name = "units",
                            defaultValue = "") final ArrayList<String> units,
                    final DefaultSponsorTeamAssets assets,
                    @RequestParam(name = "baseRank",
                            defaultValue = "0") final Integer baseRank) {
        return getSponsorBuilderService().selectTeam(affinities, units, assets,
                baseRank);
    }

    @GetMapping(path = "/affinities",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final SponsorAffinities
            selectAffinities(@RequestParam(name = "affinities",
                    defaultValue = "") final ArrayList<String> affinities) {
        return getSponsorBuilderService().selectAffinities(affinities);
    }

    private final SponsorBuilderService getSponsorBuilderService() {
        return builderService;
    }

}
