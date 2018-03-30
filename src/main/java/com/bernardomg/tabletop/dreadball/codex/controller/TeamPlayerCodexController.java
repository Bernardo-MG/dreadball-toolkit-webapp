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

package com.bernardomg.tabletop.dreadball.codex.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bernardomg.tabletop.dreadball.codex.service.CodexService;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;

/**
 * Controller for querying players.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RestController
@RequestMapping("/rest/players")
public class TeamPlayerCodexController {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(TeamPlayerCodexController.class);

    /**
     * Codex service.
     * <p>
     * This allows querying for the data to be shown.
     */
    private final CodexService  playerCodexService;

    /**
     * Constructs a controller.
     * 
     * @param codex
     *            codex service
     */
    public TeamPlayerCodexController(final CodexService codex) {
        super();

        playerCodexService = checkNotNull(codex,
                "Received a null pointer as player codex service");
    }

    /**
     * Returns a group of players with affinities.
     * 
     * @param page
     *            page number
     * @param size
     *            page size
     * @param orderBy
     *            field to order by
     * @param direction
     *            ordering direction
     * @return a group of players with affinities
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final Iterable<? extends TeamPlayer> getAffinityTeamPlayers(
            @RequestParam(name = "page", defaultValue = "0") final Integer page,
            @RequestParam(name = "size",
                    defaultValue = "10") final Integer size,
            @RequestParam(name = "orderBy",
                    defaultValue = "") final String orderBy,
            @RequestParam(name = "direction",
                    defaultValue = "ASC") final Direction direction) {
        final Pageable pageReq;

        LOGGER.debug("orderBy: {}", orderBy);
        LOGGER.debug("direction: {}", direction);

        // TODO: Page and size may be stored automatically into a pageable
        // Check:
        // https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-part-seven-pagination/
        // http://www.baeldung.com/rest-api-pagination-in-spring
        if (orderBy.isEmpty()) {
            pageReq = new PageRequest(page, size);
        } else {
            pageReq = new PageRequest(page, size, direction, orderBy);
        }

        final Iterable<? extends TeamPlayer> result;
        result = getCodexService().getAffinityTeamPlayers(pageReq);

        return result;
    }

    /**
     * Returns the codex service.
     * 
     * @return the codex service
     */
    private final CodexService getCodexService() {
        return playerCodexService;
    }

}
