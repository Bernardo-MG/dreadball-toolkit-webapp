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

package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.service;

import org.springframework.data.domain.Pageable;

import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.Unit;

/**
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface SponsorUnitsService {

    /**
     * Returns all the affinity units for the specified affinity groups.
     * <p>
     * Units which hate any of the affinities won't be returned, for all the
     * others the final cost will be calculated and set into the returned
     * object.
     * 
     * @param affinities
     *            affinities for filtering
     * @param pageReq
     *            pagination data
     * @return the units available for the affinities
     */
    public Iterable<? extends Unit> getAllAffinityUnits(
            final Iterable<? extends AffinityGroup> affinities,
            final Pageable pageReq);

}
