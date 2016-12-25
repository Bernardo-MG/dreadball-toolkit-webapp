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

package com.wandrell.tabletop.dreadball.web.toolkit.test.unit.builder.dbx;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.build.dbx.DbxSponsorBuilder;
import com.wandrell.tabletop.dreadball.build.dbx.DbxTeamBuilder;
import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.calculator.RankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.service.DefaultDbxTeamBuilder;

/**
 * Unit tests for {@link DbxSponsorBuilder}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestDefaultDbxTeamBuilderAddPlayerGiantMvp {

    /**
     * Default constructor.
     */
    public TestDefaultDbxTeamBuilderAddPlayerGiantMvp() {
        super();
    }

    /**
     * Tests that when adding multiple players these are added one after the
     * other.
     */
    @Test
    public final void testAddPlayer_MultipleGiantMvps_Added() throws Exception {
        final DbxTeamBuilder builder; // Builder to test
        final SponsorTeam team;

        // Creates the builder with the mocked dependencies
        builder = getDbxTeamBuilder();

        team = getSponsorTeam();

        builder.addPlayer(team, getUnit("mvp1"));
        builder.addPlayer(team, getUnit("mvp2"));
        builder.addPlayer(team, getUnit("mvp3"));

        Assert.assertEquals(team.getPlayers().size(), 3);

        Assert.assertTrue(team.getPlayers().containsKey(1));
        Assert.assertTrue(team.getPlayers().containsKey(2));
        Assert.assertTrue(team.getPlayers().containsKey(3));
    }

    /**
     * Tests that when the data and the context is correct players can be added.
     */
    @Test
    public final void testAddPlayer_RepeatedGiantMvp_NotAdded()
            throws Exception {
        final DbxTeamBuilder builder; // Builder to test
        final SponsorTeam team;
        final Unit unit;

        // Creates the builder with the mocked dependencies
        builder = getDbxTeamBuilder();

        team = getSponsorTeam();

        unit = getUnit("mvp1");
        builder.addPlayer(team, unit);
        builder.addPlayer(team, unit);

        Assert.assertEquals(team.getPlayers().size(), 1);

        Assert.assertTrue(team.getPlayers().containsKey(1));
    }

    /**
     * Returns the DBX sponsor builder to test, with mocked dependencies.
     * 
     * @return the DBX sponsor builder with mocked dependencies
     */
    private final DbxTeamBuilder getDbxTeamBuilder() {
        return new DefaultDbxTeamBuilder(0, 0, 0, 0);
    }

    @SuppressWarnings("unchecked")
    private final SponsorTeam getSponsorTeam() {
        final Sponsor sponsor;
        final TeamValorationCalculator<SponsorTeam> vCalc;
        final RankCostCalculator rCalc;

        sponsor = new DefaultSponsor();

        vCalc = Mockito.mock(TeamValorationCalculator.class);
        rCalc = Mockito.mock(RankCostCalculator.class);

        return new DefaultSponsorTeam(sponsor, vCalc, rCalc);
    }

    private final Unit getUnit(final String template) {
        final Unit unit;

        unit = Mockito.mock(Unit.class);
        Mockito.when(unit.getGiant()).thenReturn(true);
        Mockito.when(unit.getMvp()).thenReturn(true);
        Mockito.when(unit.getTemplateName()).thenReturn(template);

        return unit;
    }

}
