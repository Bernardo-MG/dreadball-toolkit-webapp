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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bernardomg.tabletop.dreadball.build.service.SponsorBuilderService;
import com.bernardomg.tabletop.dreadball.model.OptionGroup;
import com.bernardomg.tabletop.dreadball.model.player.ImmutableAffinityGroup;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;

/**
 * Controller for the affinity groups codex views.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RestController
@RequestMapping("/rest/builder")
public class SponsorQueryController {

    private final SponsorBuilderService builderService;

    /**
     * Constructs a controller with the specified dependencies.
     * 
     * @param sponsorBuilderService
     *            sponsor builder service
     */
    @Autowired
    public SponsorQueryController(
            final SponsorBuilderService sponsorBuilderService) {
        super();

        builderService = checkNotNull(sponsorBuilderService,
                "Received a null pointer as builder service");
    }

    /**
     * Returns all the affinities available to a Sponsor.
     * <p>
     * These will be stored into options, allowing these affinities to be
     * selected by the user through a combo box or similar UI component.
     * 
     * @return all the affinities available to a Sponsor
     */
    @GetMapping(path = "/affinity",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final Iterable<OptionGroup> getAffinityOptions() {
        return getSponsorBuilderService().getAffinityOptions();
    }

    /**
     * Returns all the players available to a Sponsor.
     * 
     * @param affinities
     *            sponsor affinities
     * @param page
     *            page number
     * @param size
     *            page size
     * @param orderBy
     *            field to order by
     * @param direction
     *            ordering direction
     * @return all the players available to a Sponsor
     */
    @GetMapping(path = "/players",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final Iterable<? extends TeamPlayer> getDbxTeamPlayers(@RequestParam(
            name = "affinities", required = false,
            defaultValue = "") final ArrayList<ImmutableAffinityGroup> affinities,
            @RequestParam(name = "page", required = false,
                    defaultValue = "0") final Integer page,
            @RequestParam(name = "size", required = false,
                    defaultValue = "10") final Integer size,
            @RequestParam(name = "orderBy", required = false,
                    defaultValue = "") final String orderBy,
            @RequestParam(name = "direction", required = false,
                    defaultValue = "ASC") final Direction direction) {
        final Pageable pageReq;

        // TODO: Page and size may be stored automatically into a pageable
        // Check:
        // https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-part-seven-pagination/
        // http://www.baeldung.com/rest-api-pagination-in-spring
        if (orderBy.isEmpty()) {
            pageReq = new PageRequest(page, size);
        } else {
            pageReq = new PageRequest(page, size, direction, orderBy);
        }

        return getSponsorBuilderService().getTeamPlayerOptions(affinities,
                pageReq);
    }

    private final SponsorBuilderService getSponsorBuilderService() {
        return builderService;
    }

}
