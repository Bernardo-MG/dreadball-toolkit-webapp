/**
 * Copyright 2018 the original author or authors
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

import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
     * Codex service.
     * <p>
     * This allows querying for the data to be shown.
     */
    private final CodexService playerCodexService;

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
     *            pagination data
     * @return a group of players with affinities
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final Iterable<? extends TeamPlayer>
            getAffinityTeamPlayers(final Pageable page) {
        return getCodexService().getAffinityTeamPlayers(page);
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
