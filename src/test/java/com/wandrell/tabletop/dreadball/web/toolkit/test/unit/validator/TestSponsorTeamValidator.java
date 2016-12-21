
package com.wandrell.tabletop.dreadball.web.toolkit.test.unit.validator;

import java.util.Arrays;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.build.dbx.DbxTeamBuilder;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.calculator.RankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.validator.SponsorTeamValidator;

public final class TestSponsorTeamValidator {

    public TestSponsorTeamValidator() {
        super();

        // TODO: Verify the message codes
    }

    @Test
    public final void testAcceptsBean() {
        final SponsorTeamValidator validator;

        validator = new SponsorTeamValidator(getDbxTeamBuilder());

        Assert.assertTrue(validator.supports(SponsorTeam.class));
    }

    @Test
    public final void testPlayers_AboveMax_Invalid() {
        final SponsorTeamValidator validator;
        final SponsorTeam team;
        final Errors errors;

        validator = new SponsorTeamValidator(getDbxTeamBuilder());

        team = getSponsorTeam(5, 5, 5, 11);

        errors = new BeanPropertyBindingResult(team, "team");

        validator.validate(team, errors);

        Assert.assertTrue(errors.hasFieldErrors("players"));
        Assert.assertFalse(errors.getFieldError("players").isBindingFailure());
        Assert.assertEquals(errors.getErrorCount(), 1);
    }

    @Test
    public final void testPlayers_AboveMax_Message() {
        final SponsorTeamValidator validator;
        final SponsorTeam team;
        final Errors errors;

        validator = new SponsorTeamValidator(getDbxTeamBuilder());

        team = getSponsorTeam(5, 5, 5, 11);

        errors = new BeanPropertyBindingResult(team, "team");

        validator.validate(team, errors);

        Assert.assertTrue(
                Arrays.asList(errors.getFieldError("players").getCodes())
                        .contains("aboveMax.team.players"));
    }

    @Test
    public final void testPlayers_BelowMin_Invalid() {
        final SponsorTeamValidator validator;
        final SponsorTeam team;
        final Errors errors;

        validator = new SponsorTeamValidator(getDbxTeamBuilder());

        team = getSponsorTeam(5, 5, 5, 1);

        errors = new BeanPropertyBindingResult(team, "team");

        validator.validate(team, errors);

        Assert.assertTrue(errors.hasFieldErrors("players"));
        Assert.assertFalse(errors.getFieldError("players").isBindingFailure());
        Assert.assertEquals(errors.getErrorCount(), 1);
    }

    @Test
    public final void testPlayers_BelowMin_Message() {
        final SponsorTeamValidator validator;
        final SponsorTeam team;
        final Errors errors;

        validator = new SponsorTeamValidator(getDbxTeamBuilder());

        team = getSponsorTeam(5, 5, 5, 1);

        errors = new BeanPropertyBindingResult(team, "team");

        validator.validate(team, errors);

        Assert.assertTrue(
                Arrays.asList(errors.getFieldError("players").getCodes())
                        .contains("belowMin.team.players"));
    }

    @Test
    public final void testRankCost_AboveRank_Invalid() {
        final SponsorTeamValidator validator;
        final SponsorTeam team;
        final Errors errors;

        validator = new SponsorTeamValidator(getDbxTeamBuilder());

        team = getSponsorTeam(10, 5, 5, 5);

        errors = new BeanPropertyBindingResult(team, "team");

        validator.validate(team, errors);

        Assert.assertTrue(errors.hasFieldErrors("rankCost"));
        Assert.assertFalse(errors.getFieldError("rankCost").isBindingFailure());
        Assert.assertEquals(errors.getErrorCount(), 1);
    }

    @Test
    public final void testRankCost_AboveRank_Message() {
        final SponsorTeamValidator validator;
        final SponsorTeam team;
        final Errors errors;

        validator = new SponsorTeamValidator(getDbxTeamBuilder());

        team = getSponsorTeam(10, 5, 5, 5);

        errors = new BeanPropertyBindingResult(team, "team");

        validator.validate(team, errors);

        Assert.assertTrue(
                Arrays.asList(errors.getFieldError("rankCost").getCodes())
                        .contains("aboveMax.team.rankCost"));
    }

    @Test
    public final void testValid() {
        final SponsorTeamValidator validator;
        final SponsorTeam team;
        final Errors errors;

        validator = new SponsorTeamValidator(getDbxTeamBuilder());

        team = getSponsorTeam(5, 5, 5, 5);

        errors = new BeanPropertyBindingResult(team, "team");

        validator.validate(team, errors);

        Assert.assertEquals(errors.getErrorCount(), 0);
    }

    @Test
    public final void testValoration_AboveMax_Message() {
        final SponsorTeamValidator validator;
        final SponsorTeam team;
        final Errors errors;

        validator = new SponsorTeamValidator(getDbxTeamBuilder());

        team = getSponsorTeam(5, 5, 15, 5);

        errors = new BeanPropertyBindingResult(team, "team");

        validator.validate(team, errors);

        Assert.assertTrue(
                Arrays.asList(errors.getFieldError("valoration").getCodes())
                        .contains("aboveMax.team.valoration"));
    }

    @Test
    public final void testValoration_AboveMin_Invalid() {
        final SponsorTeamValidator validator;
        final SponsorTeam team;
        final Errors errors;

        validator = new SponsorTeamValidator(getDbxTeamBuilder());

        team = getSponsorTeam(5, 5, 15, 5);

        errors = new BeanPropertyBindingResult(team, "team");

        validator.validate(team, errors);

        Assert.assertTrue(errors.hasFieldErrors("valoration"));
        Assert.assertFalse(
                errors.getFieldError("valoration").isBindingFailure());
        Assert.assertEquals(errors.getErrorCount(), 1);
    }

    @Test
    public final void testValoration_BelowMin_Invalid() {
        final SponsorTeamValidator validator;
        final SponsorTeam team;
        final Errors errors;

        validator = new SponsorTeamValidator(getDbxTeamBuilder());

        team = getSponsorTeam(5, 5, 1, 5);

        errors = new BeanPropertyBindingResult(team, "team");

        validator.validate(team, errors);

        Assert.assertTrue(errors.hasFieldErrors("valoration"));
        Assert.assertFalse(
                errors.getFieldError("valoration").isBindingFailure());
        Assert.assertEquals(errors.getErrorCount(), 1);
    }

    @Test
    public final void testValoration_BelowMin_Message() {
        final SponsorTeamValidator validator;
        final SponsorTeam team;
        final Errors errors;

        validator = new SponsorTeamValidator(getDbxTeamBuilder());

        team = getSponsorTeam(5, 5, 1, 5);

        errors = new BeanPropertyBindingResult(team, "team");

        validator.validate(team, errors);

        Assert.assertTrue(
                Arrays.asList(errors.getFieldError("valoration").getCodes())
                        .contains("belowMin.team.valoration"));
    }

    private final DbxTeamBuilder getDbxTeamBuilder() {
        final DbxTeamBuilder builder;

        builder = Mockito.mock(DbxTeamBuilder.class);

        Mockito.when(builder.getMinTeamUnits()).thenReturn(2);
        Mockito.when(builder.getMaxTeamUnits()).thenReturn(10);

        Mockito.when(builder.getMinTeamValoration()).thenReturn(2);
        Mockito.when(builder.getMaxTeamValoration()).thenReturn(10);

        return builder;
    }

    @SuppressWarnings("unchecked")
    private final SponsorTeam getSponsorTeam(final Integer rankCost,
            final Integer rank, final Integer valoration,
            final Integer players) {
        final SponsorTeam team;
        final RankCostCalculator calculator;
        final TeamValorationCalculator<SponsorTeam> valCalc;
        final Sponsor sponsor;

        calculator = Mockito.mock(RankCostCalculator.class);
        Mockito.when(calculator.getRankCost(Matchers.any()))
                .thenReturn(rankCost);

        valCalc = Mockito.mock(TeamValorationCalculator.class);
        Mockito.when(valCalc.getValoration(Matchers.any()))
                .thenReturn(valoration);

        sponsor = Mockito.mock(Sponsor.class);
        Mockito.when(sponsor.getRank()).thenReturn(rank);

        // TODO: Increase the returned rank cost
        team = new DefaultSponsorTeam(sponsor, valCalc, calculator);

        for (Integer i = 0; i < players; i++) {
            team.addPlayer(Mockito.mock(Unit.class));
        }

        return team;
    }

}
