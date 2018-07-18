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

package com.bernardomg.tabletop.dreadball.web.toolkit.test.integration.builder.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Assert;
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
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.bernardomg.tabletop.dreadball.build.service.SponsorBuilderService;
import com.bernardomg.tabletop.dreadball.model.player.ImmutableAffinityGroup;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.stats.AffinityGroup;
import com.bernardomg.tabletop.dreadball.web.toolkit.test.configuration.TestValues;
import com.google.common.collect.Iterables;

/**
 * Integration tests for {@link SponsorBuilderService}, verifying affinity
 * options validation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(
        locations = { "classpath:context/test-service-context.xml" })
public class ITSponsorBuilderServiceTeamPlayers
        extends AbstractJUnit4SpringContextTests {

    /**
     * Tested service.
     */
    @Autowired
    private SponsorBuilderService service;

    /**
     * Default constructor.
     */
    public ITSponsorBuilderServiceTeamPlayers() {
        super();
    }

    /**
     * Verifies that the players have the expected value when there are
     * affinities.
     */
    @Test
    public final void testGetAffinityTeamPlayers_Affinities_ExpectedCost() {
        final Pageable pageable;
        final Iterable<? extends TeamPlayer> players;
        final Collection<AffinityGroup> affinities;
        final TeamPlayer player;

        affinities = new ArrayList<>();
        affinities.add(new ImmutableAffinityGroup("affinity_1"));

        pageable = PageRequest.of(0, 10, Direction.ASC, "templateName");
        players = service.getTeamPlayerOptions(affinities, pageable);

        player = Iterables.get(players, 0);
        Assert.assertEquals(TestValues.PLAYER_A, player.getTemplateName());
        Assert.assertEquals(new Integer(15), player.getCost());
    }

    /**
     * Verifies that players hating the received affinities are not returned.
     */
    @Test
    public final void testGetAffinityTeamPlayers_IgnoresHated() {
        final Pageable pageable;
        final Iterable<? extends TeamPlayer> players;
        final Collection<AffinityGroup> affinities;

        affinities = new ArrayList<>();
        affinities.add(new ImmutableAffinityGroup("affinity_5"));

        pageable = PageRequest.of(0, 10);
        players = service.getTeamPlayerOptions(affinities, pageable);

        Assert.assertEquals(3, Iterables.size(players));
    }

    /**
     * Verifies that the players have the expected value when there are no
     * affinities.
     */
    @Test
    public final void testGetAffinityTeamPlayers_NoAffinities_ExpectedCost() {
        final Pageable pageable;
        final Iterable<? extends TeamPlayer> players;
        final Collection<AffinityGroup> affinities;
        final TeamPlayer player;

        affinities = new ArrayList<>();

        pageable = PageRequest.of(0, 10, Direction.ASC, "templateName");
        players = service.getTeamPlayerOptions(affinities, pageable);

        player = Iterables.get(players, 0);
        Assert.assertEquals(TestValues.PLAYER_A, player.getTemplateName());
        Assert.assertEquals(new Integer(23), player.getCost());
    }

    /**
     * Verifies that the players can be read.
     */
    @Test
    public final void testGetAffinityTeamPlayers_ReturnsExpected() {
        final Pageable pageable;
        final Iterable<? extends TeamPlayer> players;
        final Collection<AffinityGroup> affinities;

        affinities = new ArrayList<>();

        pageable = PageRequest.of(0, 10);
        players = service.getTeamPlayerOptions(affinities, pageable);

        Assert.assertEquals(4, Iterables.size(players));
    }

    /**
     * Verifies that the players are ordered.
     */
    @Test
    public final void testGetTeamPlayers_Affinities_ReturnsOrdered() {
        final Pageable pageable;
        final Iterable<? extends TeamPlayer> players;
        final Collection<AffinityGroup> affinities;
        final Iterator<? extends TeamPlayer> itr;

        affinities = new ArrayList<>();
        affinities.add(new ImmutableAffinityGroup("affinity_1"));

        pageable = PageRequest.of(0, 10, Direction.ASC, "templateName");
        players = service.getTeamPlayerOptions(affinities, pageable);

        itr = players.iterator();

        Assert.assertEquals(TestValues.PLAYER_A, itr.next().getTemplateName());
        Assert.assertEquals(TestValues.PLAYER_B, itr.next().getTemplateName());
        Assert.assertEquals(TestValues.PLAYER_C, itr.next().getTemplateName());
    }

    /**
     * Verifies that the players are ordered.
     */
    @Test
    public final void testGetTeamPlayers_NoAffinities_ReturnsOrdered() {
        final Pageable pageable;
        final Iterable<? extends TeamPlayer> players;
        final Collection<AffinityGroup> affinities;
        final Iterator<? extends TeamPlayer> itr;

        affinities = new ArrayList<>();

        pageable = PageRequest.of(0, 10, Direction.ASC, "templateName");
        players = service.getTeamPlayerOptions(affinities, pageable);

        itr = players.iterator();

        Assert.assertEquals(TestValues.PLAYER_A, itr.next().getTemplateName());
        Assert.assertEquals(TestValues.PLAYER_B, itr.next().getTemplateName());
        Assert.assertEquals(TestValues.PLAYER_C, itr.next().getTemplateName());
    }

    /**
     * Verifies that the players are returned inside a page.
     */
    @Test
    public final void testGetTeamPlayers_ReturnsPage() {
        final Pageable pageable;
        final Iterable<? extends TeamPlayer> players;
        final Collection<AffinityGroup> affinities;

        affinities = new ArrayList<>();

        pageable = PageRequest.of(0, 10);
        players = service.getTeamPlayerOptions(affinities, pageable);

        Assert.assertTrue(players instanceof Page);
    }

}
