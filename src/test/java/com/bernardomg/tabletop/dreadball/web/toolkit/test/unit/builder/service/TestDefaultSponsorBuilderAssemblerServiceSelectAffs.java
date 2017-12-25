
package com.bernardomg.tabletop.dreadball.web.toolkit.test.unit.builder.service;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.build.dbx.assembler.AffinitiesSelectionAssembler;
import com.bernardomg.tabletop.dreadball.build.dbx.assembler.SponsorTeamAssembler;
import com.bernardomg.tabletop.dreadball.build.dbx.assembler.SponsorTeamSelectionAssembler;
import com.bernardomg.tabletop.dreadball.build.dbx.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.build.dbx.service.DefaultSponsorBuilderAssemblerService;
import com.bernardomg.tabletop.dreadball.build.dbx.service.SponsorBuilderAssemblerService;
import com.bernardomg.tabletop.dreadball.repository.unit.AffinityGroupRepository;
import com.bernardomg.tabletop.dreadball.repository.unit.AffinityUnitRepository;
import com.google.common.collect.Iterables;

public class TestDefaultSponsorBuilderAssemblerServiceSelectAffs {

    public TestDefaultSponsorBuilderAssemblerServiceSelectAffs() {
        super();
    }

    @Test
    public final void
            testGetAffinityOptionGroups_Affinities_RankIncrease_Affinities() {
        final SponsorBuilderAssemblerService service;
        final Collection<String> affinities;
        final AffinitiesSelectionAssembler assembler;
        final ArgumentCaptor<Iterable> captor;

        assembler = getAffinitiesSelectionAssemblerMock();
        service = getSponsorBuilderAssemblerService(assembler);

        affinities = new ArrayList<>();
        affinities.add("aff1");
        affinities.add("aff2");
        affinities.add("aff3");
        affinities.add("rank_increase");

        service.assembleSponsorAffinities(affinities);

        captor = ArgumentCaptor.forClass(Iterable.class);
        Mockito.verify(assembler).assemble(captor.capture(), Matchers.any());

        Assert.assertEquals(3, Iterables.size(captor.getValue()));
    }

    @Test
    public final void
            testGetAffinityOptionGroups_Affinities_RankIncrease_Rank() {
        final SponsorBuilderAssemblerService service;
        final Collection<String> affinities;
        final AffinitiesSelectionAssembler assembler;
        final ArgumentCaptor<Integer> captor;

        assembler = getAffinitiesSelectionAssemblerMock();
        service = getSponsorBuilderAssemblerService(assembler);

        affinities = new ArrayList<>();
        affinities.add("aff1");
        affinities.add("aff2");
        affinities.add("aff3");
        affinities.add("rank_increase");

        service.assembleSponsorAffinities(affinities);

        captor = ArgumentCaptor.forClass(Integer.class);
        Mockito.verify(assembler).assemble(Matchers.any(), captor.capture());

        Assert.assertEquals(1, captor.getValue().intValue());
    }

    @Test
    public final void
            testGetAffinityOptionGroups_Affinities_WithoutRankIncrease_Affinities() {
        final SponsorBuilderAssemblerService service;
        final Collection<String> affinities;
        final AffinitiesSelectionAssembler assembler;
        final ArgumentCaptor<Iterable> captor;

        assembler = getAffinitiesSelectionAssemblerMock();
        service = getSponsorBuilderAssemblerService(assembler);

        affinities = new ArrayList<>();
        affinities.add("aff1");
        affinities.add("aff2");
        affinities.add("aff3");

        service.assembleSponsorAffinities(affinities);

        captor = ArgumentCaptor.forClass(Iterable.class);
        Mockito.verify(assembler).assemble(captor.capture(), Matchers.any());

        Assert.assertEquals(3, Iterables.size(captor.getValue()));
    }

    @Test
    public final void
            testGetAffinityOptionGroups_Affinities_WithoutRankIncrease_NoRank() {
        final SponsorBuilderAssemblerService service;
        final Collection<String> affinities;
        final AffinitiesSelectionAssembler assembler;
        final ArgumentCaptor<Integer> captor;

        assembler = getAffinitiesSelectionAssemblerMock();
        service = getSponsorBuilderAssemblerService(assembler);

        affinities = new ArrayList<>();
        affinities.add("aff1");
        affinities.add("aff2");
        affinities.add("aff3");

        service.assembleSponsorAffinities(affinities);

        captor = ArgumentCaptor.forClass(Integer.class);
        Mockito.verify(assembler).assemble(Matchers.any(), captor.capture());

        Assert.assertEquals(0, captor.getValue().intValue());
    }

    @Test
    public final void testGetAffinityOptionGroups_NoAffinities_NoAffinities() {
        final SponsorBuilderAssemblerService service;
        final Collection<String> affinities;
        final AffinitiesSelectionAssembler assembler;
        final ArgumentCaptor<Iterable> captor;

        assembler = getAffinitiesSelectionAssemblerMock();
        service = getSponsorBuilderAssemblerService(assembler);

        affinities = new ArrayList<>();
        service.assembleSponsorAffinities(affinities);

        captor = ArgumentCaptor.forClass(Iterable.class);
        Mockito.verify(assembler).assemble(captor.capture(), Matchers.any());

        Assert.assertEquals(0, Iterables.size(captor.getValue()));
    }

    @Test
    public final void testGetAffinityOptionGroups_NoAffinities_NoRank() {
        final SponsorBuilderAssemblerService service;
        final Collection<String> affinities;
        final AffinitiesSelectionAssembler assembler;
        final ArgumentCaptor<Integer> captor;

        assembler = getAffinitiesSelectionAssemblerMock();
        service = getSponsorBuilderAssemblerService(assembler);

        affinities = new ArrayList<>();
        service.assembleSponsorAffinities(affinities);

        captor = ArgumentCaptor.forClass(Integer.class);
        Mockito.verify(assembler).assemble(Matchers.any(), captor.capture());

        Assert.assertEquals(0, captor.getValue().intValue());
    }

    private final AffinitiesSelectionAssembler
            getAffinitiesSelectionAssemblerMock() {
        final AffinitiesSelectionAssembler affinitiesAssembler;

        affinitiesAssembler = Mockito.mock(AffinitiesSelectionAssembler.class);
        Mockito.when(
                affinitiesAssembler.assemble(Matchers.any(), Matchers.any()))
                .thenReturn(Mockito.mock(SponsorAffinities.class));

        return affinitiesAssembler;
    }

    private final SponsorBuilderAssemblerService
            getSponsorBuilderAssemblerService(
                    final AffinitiesSelectionAssembler assembler) {
        final SponsorTeamAssembler sponsorTeamAssembler;
        final SponsorTeamSelectionAssembler sponsorTeamSelectionAssembler;
        final AffinityUnitRepository unitsRepository;
        final AffinityGroupRepository affinityRepository;

        sponsorTeamAssembler = Mockito.mock(SponsorTeamAssembler.class);
        sponsorTeamSelectionAssembler = Mockito
                .mock(SponsorTeamSelectionAssembler.class);

        unitsRepository = Mockito.mock(AffinityUnitRepository.class);
        affinityRepository = Mockito.mock(AffinityGroupRepository.class);

        return new DefaultSponsorBuilderAssemblerService(sponsorTeamAssembler,
                sponsorTeamSelectionAssembler, assembler, unitsRepository,
                affinityRepository);
    }

}
