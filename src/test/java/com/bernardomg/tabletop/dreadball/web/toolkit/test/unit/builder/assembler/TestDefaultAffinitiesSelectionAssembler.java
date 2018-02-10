
package com.bernardomg.tabletop.dreadball.web.toolkit.test.unit.builder.assembler;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.model.assembler.AffinitiesSelectionAssembler;
import com.bernardomg.tabletop.dreadball.model.assembler.DefaultAffinitiesSelectionAssembler;
import com.bernardomg.tabletop.dreadball.rules.SponsorDefaults;
import com.google.common.collect.Iterables;

public final class TestDefaultAffinitiesSelectionAssembler {

    public TestDefaultAffinitiesSelectionAssembler() {
        super();
    }

    @Test
    public final void testAssemble_Affinities_ExpectedAffinitiesResult() {
        final AffinitiesSelectionAssembler assembler;
        final Collection<String> affinities;
        final SponsorAffinities result;

        assembler = getAffinitiesSelectionAssembler();

        affinities = new ArrayList<>();
        affinities.add("affinity_1");
        affinities.add("affinity_2");

        result = assembler.assemble(affinities);

        Assert.assertEquals(Iterables.size(result.getAffinities()), 2);
    }

    @Test
    public final void testAssemble_Affinities_NoRankIncrease_NoReturnedRank() {
        final AffinitiesSelectionAssembler assembler;
        final Collection<String> affinities;
        final SponsorAffinities result;

        assembler = getAffinitiesSelectionAssembler();

        affinities = new ArrayList<>();
        affinities.add("affinity_1");
        affinities.add("affinity_2");

        result = assembler.assemble(affinities);

        Assert.assertEquals(result.getRank().intValue(), 0);
    }

    @Test
    public final void
            testAssemble_Affinities_RankIncrease_ExpectedAffinitiesResult() {
        final AffinitiesSelectionAssembler assembler;
        final Collection<String> affinities;
        final SponsorAffinities result;

        assembler = getAffinitiesSelectionAssembler();

        affinities = new ArrayList<>();
        affinities.add("affinity_1");
        affinities.add("affinity_2");
        affinities.add("rank_increase");

        result = assembler.assemble(affinities);

        Assert.assertEquals(Iterables.size(result.getAffinities()), 2);
    }

    @Test
    public final void testAssemble_NoAffinities_NoAffinitiesResult() {
        final AffinitiesSelectionAssembler assembler;
        final Collection<String> affinities;
        final SponsorAffinities result;

        assembler = getAffinitiesSelectionAssembler();

        affinities = new ArrayList<>();

        result = assembler.assemble(affinities);

        Assert.assertEquals(Iterables.size(result.getAffinities()), 0);
    }

    @Test
    public final void testAssemble_NoAffinities_NoReturnedRank() {
        final AffinitiesSelectionAssembler assembler;
        final Collection<String> affinities;
        final SponsorAffinities result;

        assembler = getAffinitiesSelectionAssembler();

        affinities = new ArrayList<>();

        result = assembler.assemble(affinities);

        Assert.assertEquals(result.getRank(), new Integer(0));
    }

    @Test
    public final void testAssemble_RankIncrease_NoAffinities() {
        final AffinitiesSelectionAssembler assembler;
        final Collection<String> affinities;
        final SponsorAffinities result;

        assembler = getAffinitiesSelectionAssembler();

        affinities = new ArrayList<>();
        affinities.add("rank_increase");

        result = assembler.assemble(affinities);

        Assert.assertEquals(Iterables.size(result.getAffinities()), 0);
    }

    @Test
    public final void testAssemble_RankIncrease_Rank() {
        final AffinitiesSelectionAssembler assembler;
        final Collection<String> affinities;
        final SponsorAffinities result;

        assembler = getAffinitiesSelectionAssembler();

        affinities = new ArrayList<>();
        affinities.add("rank_increase");

        result = assembler.assemble(affinities);

        Assert.assertEquals(result.getRank().intValue(), 1);
    }

    @Test
    public final void
            testAssemble_RepeatedAffinities_NoRepeatedAffinitiesResult() {
        final AffinitiesSelectionAssembler assembler;
        final Collection<String> affinities;
        final SponsorAffinities result;

        assembler = getAffinitiesSelectionAssembler();

        affinities = new ArrayList<>();
        affinities.add("affinity_1");
        affinities.add("affinity_2");
        affinities.add("affinity_1");

        result = assembler.assemble(affinities);

        Assert.assertEquals(Iterables.size(result.getAffinities()), 2);
    }

    private final AffinitiesSelectionAssembler
            getAffinitiesSelectionAssembler() {
        final SponsorDefaults defaults;

        defaults = Mockito.mock(SponsorDefaults.class);
        Mockito.when(defaults.getInitialRank()).thenReturn(0);

        return new DefaultAffinitiesSelectionAssembler(defaults);
    }

}
