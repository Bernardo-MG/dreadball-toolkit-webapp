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

package com.bernardomg.tabletop.dreadball.build.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bernardomg.tabletop.dreadball.build.service.SponsorBuilderService;
import com.bernardomg.tabletop.dreadball.model.DefaultSponsorTeamValidationSelection;
import com.bernardomg.tabletop.dreadball.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;

/**
 * Controller for validating the team being built.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RestController
@RequestMapping("/rest/builder/validation")
public class SponsorValidationController {

    /**
     * Builder service.
     */
    private final SponsorBuilderService builderService;

    /**
     * Constructs a controller with the specified dependencies.
     * 
     * @param sponsorBuilderService
     *            sponsor builder service
     */
    @Autowired
    public SponsorValidationController(
            final SponsorBuilderService sponsorBuilderService) {
        super();

        builderService = checkNotNull(sponsorBuilderService,
                "Received a null pointer as sponsor builder service");
    }

    /**
     * Validates a set of Sponsor affinities.
     * <p>
     * This is meant to be used for validating the affinities selected when
     * creating a Sponsor.
     * 
     * @param affinities
     *            sponsor affinities
     * @return the valid affinities
     */
    @GetMapping(path = "/affinities",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final SponsorAffinities
            validateSponsorAffinities(@RequestParam(name = "affinities",
                    defaultValue = "") final ArrayList<String> affinities) {
        return getSponsorBuilderService().validateSponsorAffinities(affinities);
    }

    /**
     * Validates a Sponsor team.
     * <p>
     * This allows the validation of a team at any point.
     * 
     * @param selection
     *            team to validate
     * @return the valid team
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final SponsorTeam validateTeam(
            final DefaultSponsorTeamValidationSelection selection) {
        return getSponsorBuilderService().validateTeam(selection);
    }

    /**
     * Returns the builder service.
     * 
     * @return the builder service
     */
    private final SponsorBuilderService getSponsorBuilderService() {
        return builderService;
    }

}
