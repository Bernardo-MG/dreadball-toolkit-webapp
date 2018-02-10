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

import org.springframework.data.domain.Pageable;

import com.bernardomg.tabletop.dreadball.model.unit.Unit;

/**
 * Service for the codex.
 * <p>
 * It takes care of queries for game data, such as units info.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface CodexService {

    /**
     * Returns a group of units with affinities.
     * <p>
     * These have a group of affinities which will mark the final cost of the
     * unit.
     * 
     * @param pageable
     *            pagination data
     * @return all the units
     */
    public Iterable<? extends Unit> getAffinityUnits(final Pageable pageable);

}
