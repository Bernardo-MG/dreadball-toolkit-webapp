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

package com.bernardomg.tabletop.dreadball.service.model;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bernardomg.tabletop.dreadball.model.persistence.unit.PersistentAffinityUnit;
import com.bernardomg.tabletop.dreadball.repository.unit.AffinityUnitRepository;

/**
 * Default implementation of the unit codex service.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Service("unitService")
public final class DefaultUnitService implements UnitService {

    /**
     * Affinity units repository.
     */
    private final AffinityUnitRepository affinityUnitRepository;

    /**
     * Constructs a service with the specified arguments.
     * 
     * @param repository
     *            affinity units repository
     */
    public DefaultUnitService(final AffinityUnitRepository repository) {
        super();

        affinityUnitRepository = checkNotNull(repository,
                "Received a null pointer as affinity units repository");
    }

    @Override
    public final Iterable<PersistentAffinityUnit>
            getAllAffinityUnits(final Pageable pageReq) {

        checkNotNull(pageReq, "Received a null pointer as pagination data");

        return getAffinityUnitRepository().findAll(pageReq);
    }

    /**
     * Returns the affinity unit repository.
     * 
     * @return the affinity unit repository
     */
    private final AffinityUnitRepository getAffinityUnitRepository() {
        return affinityUnitRepository;
    }

}
