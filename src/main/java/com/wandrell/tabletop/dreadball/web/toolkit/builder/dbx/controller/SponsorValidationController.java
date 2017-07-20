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

package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wandrell.tabletop.dreadball.build.dbx.SponsorCosts;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorAffinitiesSelection;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorTeamOptions;

/**
 * Controller for the affinity groups codex views.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RestController
@RequestMapping("/rest/builder/validation")
public class SponsorValidationController {

    private final SponsorCosts sponsorCosts;

    /**
     * Constructs a controller with the specified dependencies.
     * 
     */
    @Autowired
    public SponsorValidationController(final SponsorCosts costs) {
        super();

        sponsorCosts = checkNotNull(costs,
                "Received a null pointer as Sponsor costs service");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final SponsorAffinitiesSelection
            getSelectionResult(final SponsorTeamOptions team) {
        final Integer rankAdd;
        final Integer rank;
        final Iterable<String> filtered;

        rankAdd = team.getAffinities().stream()
                .filter(affinity -> affinity.getName().equals("rank_increase"))
                .collect(Collectors.toList()).size();
        filtered = team.getAffinities().stream()
                .filter(affinity -> !affinity.getName().equals("rank_increase"))
                .map(affinity -> affinity.getName())
                .collect(Collectors.toList());

        rank = getSponsorCosts().getInitialRank() + rankAdd;

        return new SponsorAffinitiesSelection(filtered, rank);
    }

    private final SponsorCosts getSponsorCosts() {
        return sponsorCosts;
    }

}
