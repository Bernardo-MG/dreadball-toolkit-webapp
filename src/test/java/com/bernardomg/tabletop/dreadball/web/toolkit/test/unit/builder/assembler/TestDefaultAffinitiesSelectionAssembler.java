
package com.bernardomg.tabletop.dreadball.web.toolkit.test.unit.builder.assembler;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.build.dbx.assembler.AffinitiesSelectionAssembler;
import com.bernardomg.tabletop.dreadball.build.dbx.assembler.DefaultAffinitiesSelectionAssembler;
import com.bernardomg.tabletop.dreadball.build.dbx.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.build.dbx.rules.SponsorDefaults;
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

        result = assembler.assemble(affinities, 0);

        Assert.assertEquals(Iterables.size(result.getAffinities()), 2);
    }

    @Test
    public final void testAssemble_NoAffinities_NoAffinitiesResult() {
        final AffinitiesSelectionAssembler assembler;
        final Collection<String> affinities;
        final SponsorAffinities result;

        assembler = getAffinitiesSelectionAssembler();

        affinities = new ArrayList<>();

        result = assembler.assemble(affinities, 0);

        Assert.assertEquals(Iterables.size(result.getAffinities()), 0);
    }

    @Test
    public final void testAssemble_NoRank_NoReturnedRank() {
        final AffinitiesSelectionAssembler assembler;
        final Collection<String> affinities;
        final SponsorAffinities result;

        assembler = getAffinitiesSelectionAssembler();

        affinities = new ArrayList<>();

        result = assembler.assemble(affinities, 0);

        Assert.assertEquals(result.getBaseRank(), new Integer(0));
    }

    @Test
    public final void testAssemble_Rank_ReturnedRank() {
        final AffinitiesSelectionAssembler assembler;
        final Collection<String> affinities;
        final SponsorAffinities result;

        assembler = getAffinitiesSelectionAssembler();

        affinities = new ArrayList<>();

        result = assembler.assemble(affinities, 6);

        Assert.assertEquals(result.getBaseRank(), new Integer(6));
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

        result = assembler.assemble(affinities, 0);

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
