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

package com.wandrell.tabletop.dreadball.web.toolkit.codex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.codex.UnitCodex;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityUnitRepository;

/**
 * Default implementation of the unit codex service.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Service("unitCodexService")
public final class DefaultUnitCodex implements UnitCodex {

    /**
     * Affinity units repository.
     */
    @Autowired
    private AffinityUnitRepository affinityUnitRepository;

    /**
     * Constructs a service with the specified arguments.
     * 
     * @param affinityUnitRepo
     *            the affinity units repository
     */
    public DefaultUnitCodex() {
        super();
    }

    @Override
    public final Iterable<? extends AffinityUnit> getAllAffinityUnits() {
        return getAffinityUnitRepository().findAll();
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
