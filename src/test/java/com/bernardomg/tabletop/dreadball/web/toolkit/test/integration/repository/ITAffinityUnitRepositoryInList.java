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

package com.bernardomg.tabletop.dreadball.web.toolkit.test.integration.repository;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.bernardomg.tabletop.dreadball.model.persistence.unit.PersistentAffinityUnit;
import com.bernardomg.tabletop.dreadball.repository.unit.AffinityUnitRepository;

@ContextConfiguration(locations = { "classpath:context/test-db-context.xml" })
public class ITAffinityUnitRepositoryInList
        extends AbstractJUnit4SpringContextTests {

    @Autowired
    private AffinityUnitRepository repository;

    public ITAffinityUnitRepositoryInList() {
        super();
    }

    @Test
    public final void testFindByTemplateNameIn_ExpectedAffinities() {
        final Collection<String> names;
        final Collection<PersistentAffinityUnit> result;
        final PersistentAffinityUnit unit;

        names = new ArrayList<>();
        names.add("unit_1_affinity");

        result = repository.findByTemplateNameIn(names);

        unit = result.iterator().next();

        Assert.assertEquals(1, unit.getAffinityGroups().size());
    }

    @Test
    public final void testFindByTemplateNameIn_ExpectedCostRange() {
        final Collection<String> names;
        final Collection<PersistentAffinityUnit> result;
        final PersistentAffinityUnit unit;

        names = new ArrayList<>();
        names.add("unit_1_affinity");

        result = repository.findByTemplateNameIn(names);

        unit = result.iterator().next();

        Assert.assertEquals(new Integer(23), unit.getStrangerCost());
        Assert.assertEquals(new Integer(15), unit.getAllyCost());
        Assert.assertEquals(new Integer(10), unit.getFriendCost());
    }

    @Test
    public final void testFindByTemplateNameIn_MultipleNames() {
        final Collection<String> names;
        final Collection<PersistentAffinityUnit> result;

        names = new ArrayList<>();
        names.add("unit_1_affinity");
        names.add("unit_2_affinity");

        result = repository.findByTemplateNameIn(names);

        Assert.assertEquals(2, result.size());
    }

    @Test
    public final void testFindByTemplateNameIn_NoName() {
        final Collection<String> names;
        final Collection<PersistentAffinityUnit> result;

        names = new ArrayList<>();

        result = repository.findByTemplateNameIn(names);

        Assert.assertEquals(0, result.size());
    }

    @Test
    public final void testFindByTemplateNameIn_RepeatedName() {
        final Collection<String> names;
        final Collection<PersistentAffinityUnit> result;

        names = new ArrayList<>();
        names.add("unit_1_affinity");
        names.add("unit_2_affinity");
        names.add("unit_1_affinity");

        result = repository.findByTemplateNameIn(names);

        Assert.assertEquals(2, result.size());
    }

    @Test
    public final void testFindByTemplateNameIn_SingleName() {
        final Collection<String> names;
        final Collection<PersistentAffinityUnit> result;

        names = new ArrayList<>();
        names.add("unit_1_affinity");

        result = repository.findByTemplateNameIn(names);

        Assert.assertEquals(1, result.size());
    }

}
