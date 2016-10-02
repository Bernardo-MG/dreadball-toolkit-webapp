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

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.wandrell.tabletop.dreadball.model.persistence.unit.PersistentAffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;

/**
 * Affinity units repository.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface AffinityUnitRepository
        extends PagingAndSortingRepository<PersistentAffinityUnit, Integer> {

    /**
     * Returns all the affinity units which does not hate any of the received
     * affinities.
     * <p>
     * TODO: This should be tested
     * <p>
     * TODO: The arguments received should be instances of
     * PersistentAffinityUnit
     * 
     * @param affinities
     *            affinities the units should not hate
     * @return all the units not hating any of the affinities
     */
    @Query("SELECT u FROM AffinityUnit u LEFT OUTER JOIN u.hated h WHERE (h IS NULL OR h NOT IN :affinities)")
    public Iterable<PersistentAffinityUnit> findAllFilteredByHatedAffinities(
            @Param("affinities") final Iterable<AffinityGroup> affinities);

    /**
     * Returns all the affinity units ordered by the template name.
     * 
     * @return all the affinity units ordered by the template name
     */
    @Query("SELECT u FROM AffinityUnit u ORDER BY u.templateName ASC")
    public Iterable<PersistentAffinityUnit> findAllOrderByTemplateName();

    /**
     * Returns the affinity unit with the specified template name.
     * 
     * @param name
     *            template name to search for
     * @return the affinity unit with the specified template name
     */
    public PersistentAffinityUnit findOneByTemplateName(final String name);

}
