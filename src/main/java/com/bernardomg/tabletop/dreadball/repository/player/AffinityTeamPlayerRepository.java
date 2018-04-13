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

package com.bernardomg.tabletop.dreadball.repository.player;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.bernardomg.tabletop.dreadball.model.persistence.player.PersistentAffinityTeamPlayer;

/**
 * Affinity players repository.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface AffinityTeamPlayerRepository extends
        PagingAndSortingRepository<PersistentAffinityTeamPlayer, Integer> {

    /**
     * Returns all the affinity players which does not hate any of the received
     * affinities.
     * 
     * @param affinities
     *            affinities the players should not hate
     * @param pageReq
     *            pagination request
     * @return all the players not hating any of the affinities
     */
    @Query("SELECT u FROM AffinityTeamPlayer u LEFT OUTER JOIN u.hated h WHERE h IS NULL OR h.name NOT IN :affinities")
    public Page<PersistentAffinityTeamPlayer> findAllFilteredByHatedAffinities(
            @Param("affinities") final Iterable<String> affinities,
            final Pageable pageReq);

    /**
     * Returns all the affinity players with their template names contained in
     * the list.
     * <p>
     * This will search for the template name, not the player name.
     * 
     * @param names
     *            wanted names
     * @return affinity players with their name in the list
     */
    public Collection<PersistentAffinityTeamPlayer>
            findByTemplateNameInOrderByTemplateNameAsc(final Iterable<String> names);

}
