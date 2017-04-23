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

package com.wandrell.tabletop.dreadball.web.toolkit.codex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityGroupRepository;

/**
 * Default implementation of the affinity group codex service.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Service("affinityGroupService")
public final class DefaultAffinityGroupService implements AffinityGroupService {

    /**
     * Affinity groups repository.
     */
    @Autowired
    private AffinityGroupRepository affinityGroupRepository;

    /**
     * Constructs a service with the specified arguments.
     */
    public DefaultAffinityGroupService() {
        super();
    }

    @Override
    public final Iterable<? extends AffinityGroup> getAllAffinityGroups() {
        return getAffinityGroupRepository().findAll();
    }

    /**
     * Returns the affinity groups repository.
     * 
     * @return the affinity groups repository
     */
    private final AffinityGroupRepository getAffinityGroupRepository() {
        return affinityGroupRepository;
    }

}
