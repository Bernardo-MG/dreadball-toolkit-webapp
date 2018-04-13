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

package com.bernardomg.tabletop.dreadball.codex.service;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bernardomg.tabletop.dreadball.model.persistence.player.PersistentAffinityTeamPlayer;
import com.bernardomg.tabletop.dreadball.repository.player.AffinityTeamPlayerRepository;

/**
 * Default implementation of the codex service.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Service("playerService")
@Transactional
public final class DefaultCodexService implements CodexService {

    /**
     * Affinity players repository.
     */
    private final AffinityTeamPlayerRepository affinityTeamPlayerRepository;

    /**
     * Constructs a service with the specified arguments.
     * 
     * @param repository
     *            affinity players repository
     */
    public DefaultCodexService(final AffinityTeamPlayerRepository repository) {
        super();

        affinityTeamPlayerRepository = checkNotNull(repository,
                "Received a null pointer as affinity players repository");
    }

    @Override
    public final Iterable<PersistentAffinityTeamPlayer>
            getAffinityTeamPlayers(final Pageable pageReq) {

        checkNotNull(pageReq, "Received a null pointer as pagination data");

        return getAffinityTeamPlayerRepository().findAll(pageReq);
    }

    /**
     * Returns the affinity player repository.
     * 
     * @return the affinity player repository
     */
    private final AffinityTeamPlayerRepository
            getAffinityTeamPlayerRepository() {
        return affinityTeamPlayerRepository;
    }

}
