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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.bernardomg.tabletop.dreadball.model.persistence.player.PersistentAffinityTeamPlayer;
import com.bernardomg.tabletop.dreadball.repository.player.AffinityTeamPlayerRepository;

@ContextConfiguration(locations = { "classpath:context/test-db-context.xml" })
public class ITAffinityTeamPlayerRepositoryFiltered
        extends AbstractJUnit4SpringContextTests {

    @Autowired
    private AffinityTeamPlayerRepository repository;

    public ITAffinityTeamPlayerRepositoryFiltered() {
        super();
    }

    @Test
    public final void
            testFindAll_FilteredByHatedAffinities_ExpectedAffinities() {
        final Collection<String> affinities;
        final Pageable pageReq;
        final Iterable<PersistentAffinityTeamPlayer> players;
        final PersistentAffinityTeamPlayer player;

        affinities = new ArrayList<>();
        affinities.add("affinity_5");

        pageReq = PageRequest.of(0, 10);

        players = repository.findAllFilteredByHatedAffinities(affinities,
                pageReq);
        player = players.iterator().next();

        Assert.assertEquals(1, player.getAffinityGroups().size());
    }

    @Test
    public final void
            testFindAll_FilteredByHatedAffinities_ExpectedCostRange() {
        final Collection<String> affinities;
        final Pageable pageReq;
        final Iterable<PersistentAffinityTeamPlayer> players;
        final PersistentAffinityTeamPlayer player;

        affinities = new ArrayList<>();
        affinities.add("affinity_5");

        pageReq = PageRequest.of(0, 10);

        players = repository.findAllFilteredByHatedAffinities(affinities,
                pageReq);
        player = players.iterator().next();

        Assert.assertEquals(new Integer(23), player.getStrangerCost());
        Assert.assertEquals(new Integer(15), player.getAllyCost());
        Assert.assertEquals(new Integer(10), player.getFriendCost());
    }

    @Test
    public final void testFindAll_FilteredByHatedAffinities_Hated_Filtered() {
        final Collection<String> affinities;
        final Pageable pageReq;

        affinities = new ArrayList<>();
        affinities.add("affinity_5");

        pageReq = PageRequest.of(0, 10);

        Assert.assertEquals(3,
                (repository.findAllFilteredByHatedAffinities(affinities,
                        pageReq)).getTotalElements());
    }

    @Test
    public final void
            testFindAll_FilteredByHatedAffinities_NoFilter_AllEntities() {
        // TODO: Breaks with MySQL
        // final Iterable<String> affinities;
        //
        // affinities = new ArrayList<>();
        //
        // Assert.assertEquals(
        // ((Collection<PersistentAffinityTeamPlayer>) repository
        // .findAllFilteredByHatedAffinities(affinities)).size(),
        // 4);
    }

    @Test
    public final void
            testFindAll_FilteredByHatedAffinities_NotHated_NotFiltered() {
        final Collection<String> affinities;
        final Pageable pageReq;

        affinities = new ArrayList<>();
        affinities.add("affinity_1");

        pageReq = PageRequest.of(0, 10);

        Assert.assertEquals(4,
                (repository.findAllFilteredByHatedAffinities(affinities,
                        pageReq)).getTotalElements());
    }

}
