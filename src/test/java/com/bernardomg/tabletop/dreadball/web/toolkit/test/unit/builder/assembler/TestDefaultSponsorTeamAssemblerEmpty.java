
package com.bernardomg.tabletop.dreadball.web.toolkit.test.unit.builder.assembler;

import java.util.ArrayList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bernardomg.tabletop.dreadball.build.dbx.assembler.DefaultSponsorTeamAssembler;
import com.bernardomg.tabletop.dreadball.build.dbx.assembler.SponsorTeamAssembler;
import com.bernardomg.tabletop.dreadball.build.dbx.model.SponsorTeamAssets;
import com.bernardomg.tabletop.dreadball.build.dbx.rules.SponsorCosts;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityUnit;
import com.bernardomg.tabletop.dreadball.rules.DbxRules;

public final class TestDefaultSponsorTeamAssemblerEmpty {

    public TestDefaultSponsorTeamAssemblerEmpty() {
        super();
    }

    @Test
    public final void testAssemble_Affinities_ReturnsExpectedAffinities() {
        final SponsorTeamAssembler assembler;
        final Iterable<AffinityGroup> affinities;
        final Iterable<AffinityUnit> units;
        final SponsorTeamAssets assets;
        final Integer rank;
        final SponsorTeam team;

        assembler = getSponsorTeamAssembler();

        affinities = new ArrayList<>();
        units = new ArrayList<>();
        assets = Mockito.mock(SponsorTeamAssets.class);
        rank = 0;

        team = assembler.assemble(affinities, units, assets, rank);

        Assert.assertEquals(team.getSponsor().getAffinityGroups().size(), 0);
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
