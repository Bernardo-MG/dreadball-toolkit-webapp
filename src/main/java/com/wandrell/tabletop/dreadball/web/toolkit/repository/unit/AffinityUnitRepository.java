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

package com.wandrell.tabletop.dreadball.web.toolkit.repository.unit;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.wandrell.tabletop.dreadball.model.persistence.unit.PersistentAffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;

/**
 * Affinity units repository.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface AffinityUnitRepository
        extends PagingAndSortingRepository<PersistentAffinityUnit, Integer> {

    /**
     * Returns the affinity unit with the specified template name.
     * 
     * @param name
     *            template name to search for
     * @return the affinity unit with the specified template name
     */
    public AffinityUnit findByTemplateName(final String name);

}
