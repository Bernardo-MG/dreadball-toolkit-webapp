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

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.codex.AffinityGroupCodex;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityGroupRepository;

/**
 * Default implementation of the affinity group codex service.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Service("unitCodexService")
public final class DefaultAffinityGroupCodex implements AffinityGroupCodex {

    /**
     * Affinity groups repository.
     */
    @Autowired
    private AffinityGroupRepository affinityGroupRepository;

    /**
     * Constructs a service with the specified arguments.
     */
    public DefaultAffinityGroupCodex() {
        super();
    }

    @Override
    public final Iterable<AffinityGroup> getAllAffinityGroups() {
        final Collection<AffinityGroup> groups;

        // TODO: There may be a better way to do this
        groups = new LinkedList<AffinityGroup>();
        for (final AffinityGroup group : getAffinityGroupRepository()
                .findAll()) {
            groups.add(group);
        }

        return groups;
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
