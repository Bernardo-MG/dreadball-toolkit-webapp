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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bernardomg.tabletop.dreadball.model.persistence.unit.PersistentAffinityUnit;
import com.bernardomg.tabletop.dreadball.repository.unit.AffinityUnitRepository;

@ContextConfiguration(locations = { "classpath:context/test-db-context.xml" })
public class ITAffinityUnitRepositoryInList
        extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private AffinityUnitRepository repository;

    public ITAffinityUnitRepositoryInList() {
        super();
    }

    @Test
    public final void testFindByTemplateNameIn_MultipleNames() {
        final Collection<String> names;
        final Collection<PersistentAffinityUnit> result;

        names = new ArrayList<>();
        names.add("unit_1_affinity");
        names.add("unit_2_affinity");

        result = repository.findByTemplateNameIn(names);

        Assert.assertEquals(result.size(), 2);
    }

    @Test
    public final void testFindByTemplateNameIn_NoName() {
        final Collection<String> names;
        final Collection<PersistentAffinityUnit> result;

        names = new ArrayList<>();

        result = repository.findByTemplateNameIn(names);

        Assert.assertEquals(result.size(), 0);
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

        Assert.assertEquals(result.size(), 2);
    }

    @Test
    public final void testFindByTemplateNameIn_SingleName() {
        final Collection<String> names;
        final Collection<PersistentAffinityUnit> result;

        names = new ArrayList<>();
        names.add("unit_1_affinity");

        result = repository.findByTemplateNameIn(names);

        Assert.assertEquals(result.size(), 1);
    }

}
