/**
 * Copyright 2018 the original author or authors
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

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.bernardomg.tabletop.dreadball.model.persistence.player.PersistentAffinityTeamPlayer;
import com.bernardomg.tabletop.dreadball.repository.player.AffinityTeamPlayerRepository;
import com.bernardomg.tabletop.dreadball.web.toolkit.test.configuration.TestValues;
import com.google.common.collect.Iterables;

/**
 * Integration tests for {@link AffinityTeamPlayerRepository}, checking the
 * query filtering by hated affinities.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(locations = { "classpath:context/test-db-context.xml" })
public class ITAffinityTeamPlayerRepositoryFilteredByHated
        extends AbstractTransactionalJUnit4SpringContextTests {

    /**
     * Tested repository.
     */
    @Autowired
    private AffinityTeamPlayerRepository repository;

    /**
     * Default constructor.
     */
    public ITAffinityTeamPlayerRepositoryFilteredByHated() {
        super();
    }

    /**
     * Verifies that filtering by hated affinities returns the expected
     * affinities.
     */
    @Test
    public final void testFindAll_FilteredByHatedAffinities_ExpectedData() {
        final Collection<String> affinities;
        final Pageable pageReq;
        final Iterable<PersistentAffinityTeamPlayer> players;
        final PersistentAffinityTeamPlayer player;

        affinities = new ArrayList<>();
        affinities.add("affinity_5");

        pageReq = PageRequest.of(0, 10, Direction.ASC, "templateName");

        players = repository.findAllFilteredByHatedAffinities(affinities,
                pageReq);

        player = Iterables.get(players, 0);
        Assertions.assertEquals(TestValues.PLAYER_A, player.getTemplateName());
        Assertions.assertEquals(new Integer(23), player.getStrangerCost());
        Assertions.assertEquals(new Integer(15), player.getAllyCost());
        Assertions.assertEquals(new Integer(10), player.getFriendCost());
        Assertions.assertEquals(1, player.getAffinityGroups().size());
    }

    /**
     * Verifies that filtering by hated affinities filters the affinities.
     */
    @Test
    public final void testFindAll_FilteredByHatedAffinities_Hated_Filtered() {
        final Collection<String> affinities;
        final Pageable pageReq;
        final Page<PersistentAffinityTeamPlayer> players;

        affinities = new ArrayList<>();
        affinities.add("affinity_5");

        pageReq = PageRequest.of(0, 10);
        players = repository.findAllFilteredByHatedAffinities(affinities,
                pageReq);

        Assertions.assertEquals(3, players.getTotalElements());
    }

    /**
     * Verifies that when not applying a filter all the affinities are returned.
     */
    @Disabled
    @Test
    public final void
            testFindAll_FilteredByHatedAffinities_NoFilter_AllEntities() {
        // TODO: Breaks with MySQL
        final Collection<String> affinities;
        final Pageable pageReq;
        final Page<PersistentAffinityTeamPlayer> players;

        affinities = new ArrayList<>();

        pageReq = PageRequest.of(0, 10);
        players = repository.findAllFilteredByHatedAffinities(affinities,
                pageReq);

        Assertions.assertEquals(4, players.getTotalElements());
    }

    /**
     * Verifies that filtering by an affinity which is not hated returns all the
     * affinities.
     */
    @Test
    public final void
            testFindAll_FilteredByHatedAffinities_NotHated_NotFiltered() {
        final Collection<String> affinities;
        final Pageable pageReq;
        final Page<PersistentAffinityTeamPlayer> players;

        affinities = new ArrayList<>();
        affinities.add("affinity_1");

        pageReq = PageRequest.of(0, 10);
        players = repository.findAllFilteredByHatedAffinities(affinities,
                pageReq);

        Assertions.assertEquals(4, players.getTotalElements());
    }

}
