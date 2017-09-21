
package com.wandrell.tabletop.dreadball.web.toolkit.test.unit.builder.assembler;

import java.util.ArrayList;
import java.util.Collection;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Iterables;
import com.wandrell.tabletop.dreadball.build.dbx.assembler.DefaultSponsorTeamAssembler;
import com.wandrell.tabletop.dreadball.build.dbx.assembler.SponsorTeamAssembler;
import com.wandrell.tabletop.dreadball.build.dbx.model.SponsorTeamAssets;
import com.wandrell.tabletop.dreadball.build.dbx.rules.SponsorCosts;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.DefaultAffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.Role;
import com.wandrell.tabletop.dreadball.model.unit.stats.MutableAttributes;
import com.wandrell.tabletop.dreadball.rules.DbxRules;

public final class TestDefaultSponsorTeamAssembler {

    public TestDefaultSponsorTeamAssembler() {
        super();
    }

    @Test
    public final void testAssemble_Affinities_ReturnsExpectedAffinities() {
        final SponsorTeamAssembler assembler;
        final Collection<AffinityGroup> affinities;
        final Collection<AffinityUnit> units;
        final SponsorTeamAssets assets;
        final Integer rank;
        final SponsorTeam team;
        final AffinityGroup aff1;
        final AffinityGroup aff2;
        final AffinityGroup aff3;

        assembler = getSponsorTeamAssembler();

        aff1 = Mockito.mock(AffinityGroup.class);
        Mockito.when(aff1.getName()).thenReturn("aff1");
        aff2 = Mockito.mock(AffinityGroup.class);
        Mockito.when(aff2.getName()).thenReturn("aff2");
        aff3 = Mockito.mock(AffinityGroup.class);
        Mockito.when(aff3.getName()).thenReturn("aff3");

        affinities = new ArrayList<>();
        affinities.add(aff1);
        affinities.add(aff2);
        affinities.add(aff3);

        units = new ArrayList<>();
        assets = Mockito.mock(SponsorTeamAssets.class);
        rank = 0;

        team = assembler.assemble(affinities, units, assets, rank);

        Assert.assertEquals(
                Iterables.size(team.getSponsor().getAffinityGroups()), 3);
    }

    @Test
    public final void testAssemble_Units_ReturnsExpectedUnits() {
        final SponsorTeamAssembler assembler;
        final Collection<AffinityGroup> affinities;
        final Collection<AffinityUnit> units;
        final SponsorTeamAssets assets;
        final Integer rank;
        final SponsorTeam team;
        final AffinityUnit unit1;
        final AffinityUnit unit2;
        final AffinityUnit unit3;

        assembler = getSponsorTeamAssembler();

        unit1 = new DefaultAffinityUnit("unit1", Role.JACK,
                new MutableAttributes(), new ArrayList<>(), false, false,
                new ArrayList<>(), new ArrayList<>(), 0, 0, 0);
        unit2 = new DefaultAffinityUnit("unit1", Role.JACK,
                new MutableAttributes(), new ArrayList<>(), false, false,
                new ArrayList<>(), new ArrayList<>(), 0, 0, 0);
        unit3 = new DefaultAffinityUnit("unit1", Role.JACK,
                new MutableAttributes(), new ArrayList<>(), false, false,
                new ArrayList<>(), new ArrayList<>(), 0, 0, 0);

        units = new ArrayList<>();
        units.add(unit1);
        units.add(unit2);
        units.add(unit3);

        affinities = new ArrayList<>();
        assets = Mockito.mock(SponsorTeamAssets.class);
        rank = 0;

        team = assembler.assemble(affinities, units, assets, rank);

        Assert.assertEquals(team.getPlayers().size(), 3);
    }

    private final SponsorTeamAssembler getSponsorTeamAssembler() {
        final SponsorCosts sponsorCosts;
        final SponsorCosts sponsorRankCosts;
        final DbxRules rules;

        sponsorCosts = Mockito.mock(SponsorCosts.class);
        sponsorRankCosts = Mockito.mock(SponsorCosts.class);
        rules = Mockito.mock(DbxRules.class);

        return new DefaultSponsorTeamAssembler(sponsorCosts, sponsorRankCosts,
                rules);
    }

}
