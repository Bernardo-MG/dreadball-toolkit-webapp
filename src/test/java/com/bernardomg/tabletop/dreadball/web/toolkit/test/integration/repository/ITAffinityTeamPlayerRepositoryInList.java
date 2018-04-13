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
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import com.bernardomg.tabletop.dreadball.model.persistence.player.PersistentAffinityTeamPlayer;
import com.bernardomg.tabletop.dreadball.repository.player.AffinityTeamPlayerRepository;
import com.bernardomg.tabletop.dreadball.web.toolkit.test.configuration.TestValues;

@ContextConfiguration(locations = { "classpath:context/test-db-context.xml" })
public class ITAffinityTeamPlayerRepositoryInList
        extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private AffinityTeamPlayerRepository repository;

    public ITAffinityTeamPlayerRepositoryInList() {
        super();
    }

    @Test
    public final void testFindByTemplateNameIn_ExpectedAffinities() {
        final Collection<String> names;
        final Collection<PersistentAffinityTeamPlayer> result;
        final PersistentAffinityTeamPlayer player;

        names = new ArrayList<>();
        names.add(TestValues.PLAYER_1);

        result = repository.findByTemplateNameIn(names);

        player = result.iterator().next();

        Assert.assertEquals(1, player.getAffinityGroups().size());
    }

    @Test
    public final void testFindByTemplateNameIn_ExpectedCostRange() {
        final Collection<String> names;
        final Collection<PersistentAffinityTeamPlayer> result;
        final PersistentAffinityTeamPlayer player;

        names = new ArrayList<>();
        names.add(TestValues.PLAYER_1);

        result = repository.findByTemplateNameIn(names);

        player = result.iterator().next();

        Assert.assertEquals(new Integer(23), player.getStrangerCost());
        Assert.assertEquals(new Integer(15), player.getAllyCost());
        Assert.assertEquals(new Integer(10), player.getFriendCost());
    }

    @Test
    public final void testFindByTemplateNameIn_MultipleNames() {
        final Collection<String> names;
        final Collection<PersistentAffinityTeamPlayer> result;

        names = new ArrayList<>();
        names.add(TestValues.PLAYER_1);
        names.add(TestValues.PLAYER_2);

        result = repository.findByTemplateNameIn(names);

        Assert.assertEquals(2, result.size());
    }

    @Test
    public final void testFindByTemplateNameIn_NoName() {
        final Collection<String> names;
        final Collection<PersistentAffinityTeamPlayer> result;

        names = new ArrayList<>();

        result = repository.findByTemplateNameIn(names);

        Assert.assertEquals(0, result.size());
    }

    @Test
    public final void testFindByTemplateNameIn_RepeatedName() {
        final Collection<String> names;
        final Collection<PersistentAffinityTeamPlayer> result;

        names = new ArrayList<>();
        names.add(TestValues.PLAYER_1);
        names.add(TestValues.PLAYER_2);
        names.add(TestValues.PLAYER_1);

        result = repository.findByTemplateNameIn(names);

        Assert.assertEquals(2, result.size());
    }

    @Test
    public final void testFindByTemplateNameIn_SingleName() {
        final Collection<String> names;
        final Collection<PersistentAffinityTeamPlayer> result;

        names = new ArrayList<>();
        names.add(TestValues.PLAYER_1);

        result = repository.findByTemplateNameIn(names);

        Assert.assertEquals(1, result.size());
    }

}
