
package com.wandrell.tabletop.dreadball.web.toolkit.test.unit.builder.processor.assembler;

import java.util.ArrayList;
import java.util.Collection;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Iterables;
import com.wandrell.tabletop.dreadball.build.dbx.assembler.AffinitiesSelectionAssembler;
import com.wandrell.tabletop.dreadball.build.dbx.assembler.DefaultAffinitiesSelectionAssembler;
import com.wandrell.tabletop.dreadball.build.dbx.model.SponsorAffinities;
import com.wandrell.tabletop.dreadball.build.dbx.rules.SponsorDefaults;

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
    public final void testAssemble_NoAffinities_NoRank() {
        final AffinitiesSelectionAssembler assembler;
        final Collection<String> affinities;
        final SponsorAffinities result;

        assembler = getAffinitiesSelectionAssembler();

        affinities = new ArrayList<>();

        result = assembler.assemble(affinities);

        Assert.assertEquals(result.getBaseRank(), new Integer(0));
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
