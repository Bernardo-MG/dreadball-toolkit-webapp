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

package com.wandrell.tabletop.dreadball.web.toolkit.test.integration.repository;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.persistence.unit.PersistentAffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityGroupRepository;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityUnitRepository;

@ContextConfiguration(locations = { "classpath:context/test-db-context.xml" })
public class ITAffinityUnitRepository
        extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private AffinityGroupRepository affinityRepository;

    @Autowired
    private AffinityUnitRepository  repository;

    public ITAffinityUnitRepository() {
        super();
    }

    @Test
    public final void testFindAll_FilteredByHatedAffinities_Hated_Filtered() {
        final Collection<AffinityGroup> affinities;

        affinities = new ArrayList<>();
        affinities.add(affinityRepository.findByName("affinity_5"));

        Assert.assertEquals(
                ((Collection<PersistentAffinityUnit>) repository
                        .findAllFilteredByHatedAffinities(affinities)).size(),
                3);
    }

    @Test
    public final void
            testFindAll_FilteredByHatedAffinities_NoFilter_AllEntities() {
        final Iterable<AffinityGroup> affinities;

        affinities = new ArrayList<>();

        Assert.assertEquals(
                ((Collection<PersistentAffinityUnit>) repository
                        .findAllFilteredByHatedAffinities(affinities)).size(),
                4);
    }

    @Test
    public final void
            testFindAll_FilteredByHatedAffinities_NotHated_NotFiltered() {
        final Collection<AffinityGroup> affinities;

        affinities = new ArrayList<>();
        affinities.add(affinityRepository.findByName("affinity_1"));

        Assert.assertEquals(
                ((Collection<PersistentAffinityUnit>) repository
                        .findAllFilteredByHatedAffinities(affinities)).size(),
                4);
    }

    @Test
    public final void testFindAllOrderByTemplateName() {
        // TODO: Remove or improve this test
        repository.findAllOrderByTemplateName();
    }

    @Test
    public final void testFindOneByTemplateName_Existing_ExpectedResult() {
        final Unit unit;
        final String templateName;

        templateName = "unit_1_affinity";

        unit = repository.findOneByTemplateName(templateName);

        Assert.assertEquals(unit.getTemplateName(), templateName);
    }

}
