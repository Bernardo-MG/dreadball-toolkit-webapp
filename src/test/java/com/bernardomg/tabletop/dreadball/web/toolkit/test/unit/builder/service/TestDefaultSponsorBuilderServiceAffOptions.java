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

package com.bernardomg.tabletop.dreadball.web.toolkit.test.unit.builder.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.build.service.DefaultSponsorBuilderService;
import com.bernardomg.tabletop.dreadball.build.service.SponsorBuilderService;
import com.bernardomg.tabletop.dreadball.model.Option;
import com.bernardomg.tabletop.dreadball.model.OptionGroup;
import com.bernardomg.tabletop.dreadball.model.availability.asset.SponsorAssetsCosts;
import com.bernardomg.tabletop.dreadball.model.persistence.availability.affinity.PersistentSponsorAffinityGroupAvailability;
import com.bernardomg.tabletop.dreadball.model.persistence.player.stats.PersistentAffinityGroup;
import com.bernardomg.tabletop.dreadball.repository.availability.SponsorAffinityGroupAvailabilityRepository;
import com.bernardomg.tabletop.dreadball.repository.player.AffinityGroupRepository;
import com.bernardomg.tabletop.dreadball.repository.player.AffinityTeamPlayerRepository;
import com.bernardomg.tabletop.dreadball.rules.DbxRules;
import com.bernardomg.tabletop.dreadball.rules.SponsorDefaults;
import com.google.common.collect.Iterables;

/**
 * TeamPlayer tests for {@link DefaultSponsorBuilderService}, verifying the
 * affinity options read method.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public class TestDefaultSponsorBuilderServiceAffOptions {

    /**
     * Default constructor.
     */
    public TestDefaultSponsorBuilderServiceAffOptions() {
        super();
    }

    /**
     * Verifies that an option is created for each affinity.
     */
    @Test
    public final void testGetAffinityOptions_Affinities_OptionForEach() {
        final SponsorBuilderService service; // Tested service
        final Iterable<OptionGroup> options; // Returned data

        service = getAffinitiesSponsorBuilderService();

        options = service.getAffinityOptions();

        Assert.assertEquals(4,
                Iterables.size(options.iterator().next().getOptions()));
    }

    /**
     * Verifies that when there is a rank option then an additional option is
     * returned.
     */
    @Test
    public final void
            testGetAffinityOptions_AffinitiesAndRank_AddsAdditionalOption() {
        final SponsorBuilderService service; // Tested service
        final Iterable<OptionGroup> options; // Returned data

        service = getAffinitiesAndRankSponsorBuilderService();

        options = service.getAffinityOptions();

        Assert.assertEquals(5,
                Iterables.size(options.iterator().next().getOptions()));
    }

    /**
     * Verifies that when there is an affinity group then an option group is
     * returned.
     */
    @Test
    public final void testGetAffinityOptions_AffinityGroup_ReturnsGroup() {
        final SponsorBuilderService service;   // Tested service
        final Collection<OptionGroup> options; // Returned data

        service = getAffinitiesAndRankSponsorBuilderService();

        options = service.getAffinityOptions();

        Assert.assertEquals(1, options.size());
    }

    /**
     * Verifies that the option group contains the affinity group name.
     */
    @Test
    public final void testGetAffinityOptions_Name() {
        final SponsorBuilderService service;   // Tested service
        final Collection<OptionGroup> options; // Returned data

        service = getAffinitiesAndRankSponsorBuilderService();

        options = service.getAffinityOptions();

        Assert.assertEquals("A", options.iterator().next().getName());
    }

    /**
     * Verifies that when there are no affinities the result is empty.
     */
    @Test
    public final void testGetAffinityOptions_NoAffinities_Empty() {
        final SponsorBuilderService service;   // Tested service
        final Collection<OptionGroup> options; // Returned data

        service = getNoAffinitiesSponsorBuilderService();

        options = service.getAffinityOptions();

        Assert.assertEquals(0, options.size());
    }

    /**
     * Verifies that when the group does not include a rank none is returned as
     * an option.
     */
    @Test
    public final void testGetAffinityOptions_NoRank_ContainsNoRank() {
        final SponsorBuilderService service;   // Tested service
        final Collection<OptionGroup> options; // Returned data
        final Boolean found;

        service = getAffinitiesSponsorBuilderService();

        options = service.getAffinityOptions();

        found = options.stream().flatMap((o) -> o.getOptions().stream())
                .map(Option::getValue)
                .anyMatch((v) -> v.equals("rank_increase"));
        Assert.assertFalse(found);
    }

    /**
     * Verifies that when the group includes rank it is returned as an option.
     */
    @Test
    public final void testGetAffinityOptions_Rank_ContainsRank() {
        final SponsorBuilderService service;   // Tested service
        final Collection<OptionGroup> options; // Returned data
        final Boolean found;

        service = getAffinitiesAndRankSponsorBuilderService();

        options = service.getAffinityOptions();

        found = options.stream().flatMap((o) -> o.getOptions().stream())
                .map(Option::getValue)
                .anyMatch((v) -> v.equals("rank_increase"));
        Assert.assertTrue(found);
    }

    /**
     * Returns a service with affinities and rank option.
     * <p>
     * All the dependencies are mocked.
     * 
     * @return service with affinities
     */
    private final SponsorBuilderService
            getAffinitiesAndRankSponsorBuilderService() {
        final SponsorDefaults defaults;
        final SponsorAffinityGroupAvailabilityRepository sponsorAffinityGroupAvailabilityRepository;
        final Collection<PersistentSponsorAffinityGroupAvailability> avas;
        final Collection<PersistentAffinityGroup> affinities;
        final AffinityTeamPlayerRepository affTeamPlayerRepository;
        final AffinityGroupRepository affGroupRepository;
        final SponsorAssetsCosts costsRank;
        final SponsorAssetsCosts costs;
        final DbxRules rules;
        final PersistentSponsorAffinityGroupAvailability ava;

        affTeamPlayerRepository = Mockito
                .mock(AffinityTeamPlayerRepository.class);
        affGroupRepository = Mockito.mock(AffinityGroupRepository.class);
        defaults = Mockito.mock(SponsorDefaults.class);
        costsRank = Mockito.mock(SponsorAssetsCosts.class);
        costs = Mockito.mock(SponsorAssetsCosts.class);
        rules = Mockito.mock(DbxRules.class);

        sponsorAffinityGroupAvailabilityRepository = Mockito
                .mock(SponsorAffinityGroupAvailabilityRepository.class);

        affinities = new ArrayList<>();
        affinities.add(getAffinity("aff1"));
        affinities.add(getAffinity("aff2"));
        affinities.add(getAffinity("aff3"));
        affinities.add(getAffinity("aff4"));

        avas = new ArrayList<>();

        ava = new PersistentSponsorAffinityGroupAvailability();
        ava.setName("A");
        ava.setIncludingRankIncrease(true);
        ava.setAffinityGroups(affinities);
        avas.add(ava);

        Mockito.when(sponsorAffinityGroupAvailabilityRepository.findAll())
                .thenReturn(avas);

        return new DefaultSponsorBuilderService(
                sponsorAffinityGroupAvailabilityRepository, defaults,
                affTeamPlayerRepository, affGroupRepository, costsRank, costs,
                rules);
    }

    /**
     * Returns a service with affinities, but no rank option.
     * <p>
     * All the dependencies are mocked.
     * 
     * @return service with affinities
     */
    private final SponsorBuilderService getAffinitiesSponsorBuilderService() {
        final SponsorDefaults defaults;
        final SponsorAffinityGroupAvailabilityRepository sponsorAffinityGroupAvailabilityRepository;
        final Collection<PersistentSponsorAffinityGroupAvailability> avas;
        final Collection<PersistentAffinityGroup> affinities;
        final AffinityTeamPlayerRepository affTeamPlayerRepository;
        final AffinityGroupRepository affGroupRepository;
        final SponsorAssetsCosts costsRank;
        final SponsorAssetsCosts costs;
        final DbxRules rules;
        final PersistentSponsorAffinityGroupAvailability ava;

        affTeamPlayerRepository = Mockito
                .mock(AffinityTeamPlayerRepository.class);
        affGroupRepository = Mockito.mock(AffinityGroupRepository.class);
        defaults = Mockito.mock(SponsorDefaults.class);
        costsRank = Mockito.mock(SponsorAssetsCosts.class);
        costs = Mockito.mock(SponsorAssetsCosts.class);
        rules = Mockito.mock(DbxRules.class);

        sponsorAffinityGroupAvailabilityRepository = Mockito
                .mock(SponsorAffinityGroupAvailabilityRepository.class);

        affinities = new ArrayList<>();
        affinities.add(getAffinity("aff1"));
        affinities.add(getAffinity("aff2"));
        affinities.add(getAffinity("aff3"));
        affinities.add(getAffinity("aff4"));

        avas = new ArrayList<>();

        ava = new PersistentSponsorAffinityGroupAvailability();
        ava.setName("A");
        ava.setIncludingRankIncrease(false);
        ava.setAffinityGroups(affinities);
        avas.add(ava);

        Mockito.when(sponsorAffinityGroupAvailabilityRepository.findAll())
                .thenReturn(avas);

        return new DefaultSponsorBuilderService(
                sponsorAffinityGroupAvailabilityRepository, defaults,
                affTeamPlayerRepository, affGroupRepository, costsRank, costs,
                rules);
    }

    private final PersistentAffinityGroup getAffinity(final String name) {
        final PersistentAffinityGroup group;

        group = new PersistentAffinityGroup();
        group.setAffinityGroupName(name);

        return group;
    }

    /**
     * Returns a service with no affinities.
     * <p>
     * All the dependencies are mocked.
     * 
     * @return service with no affinities
     */
    private final SponsorBuilderService getNoAffinitiesSponsorBuilderService() {
        final SponsorDefaults defaults;
        final SponsorAffinityGroupAvailabilityRepository sponsorAffinityGroupAvailabilityRepository;
        final AffinityTeamPlayerRepository affTeamPlayerRepository;
        final AffinityGroupRepository affGroupRepository;
        final SponsorAssetsCosts costsRank;
        final SponsorAssetsCosts costs;
        final DbxRules rules;

        affTeamPlayerRepository = Mockito
                .mock(AffinityTeamPlayerRepository.class);
        affGroupRepository = Mockito.mock(AffinityGroupRepository.class);
        defaults = Mockito.mock(SponsorDefaults.class);
        costsRank = Mockito.mock(SponsorAssetsCosts.class);
        costs = Mockito.mock(SponsorAssetsCosts.class);
        rules = Mockito.mock(DbxRules.class);

        sponsorAffinityGroupAvailabilityRepository = Mockito
                .mock(SponsorAffinityGroupAvailabilityRepository.class);

        Mockito.when(sponsorAffinityGroupAvailabilityRepository.findAll())
                .thenReturn(Collections.emptyList());

        return new DefaultSponsorBuilderService(
                sponsorAffinityGroupAvailabilityRepository, defaults,
                affTeamPlayerRepository, affGroupRepository, costsRank, costs,
                rules);
    }

}
