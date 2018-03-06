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

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bernardomg.tabletop.dreadball.model.persistence.player.PersistentAffinityGroup;

/**
 * Affinity groups repository.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface AffinityGroupRepository
        extends PagingAndSortingRepository<PersistentAffinityGroup, Integer> {

    /**
     * Returns all the affinity groups with their names contained in the list.
     * 
     * @param names
     *            wanted names
     * @return affinity groups with their name in the list
     */
    public Collection<PersistentAffinityGroup>
            findByNameIn(final Iterable<String> names);

}
