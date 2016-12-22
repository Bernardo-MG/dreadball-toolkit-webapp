
package com.wandrell.tabletop.dreadball.validator;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.wandrell.tabletop.dreadball.build.dbx.DbxTeamBuilder;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;

@Component("sponsorTeamValidator")
public final class SponsorTeamValidator implements Validator {

    private final DbxTeamBuilder builderService;

    public SponsorTeamValidator(final DbxTeamBuilder builder) {
        super();

        builderService = checkNotNull(builder,
                "Received a null pointer as team builder service");
    }

    @Override
    public final boolean supports(final Class<?> clazz) {
        return SponsorTeam.class.isAssignableFrom(clazz);
    }

    @Override
    public final void validate(final Object object, final Errors errors) {
        final SponsorTeam team;

        team = (SponsorTeam) object;

        // errors.pushNestedPath("validation");
        // errors.pushNestedPath("team");

        // errors.pushNestedPath("rank");
        if (team.getRankCost() > team.getSponsor().getRank()) {
            errors.rejectValue("rankCost", "aboveMax");
        }
        // errors.popNestedPath();

        // errors.pushNestedPath("valoration");
        if (team.getValoration() < getDbxTeamBuilder().getMinTeamValoration()) {
            errors.rejectValue("valoration", "belowMin");
        } else if (team.getValoration() > getDbxTeamBuilder()
                .getMaxTeamValoration()) {
            errors.rejectValue("valoration", "aboveMax");
        }
        // errors.popNestedPath();

        // errors.pushNestedPath("players");
        if (team.getPlayers().size() < getDbxTeamBuilder().getMinTeamUnits()) {
            errors.rejectValue("players", "belowMin");
        } else if (team.getPlayers().size() > getDbxTeamBuilder()
                .getMaxTeamUnits()) {
            errors.rejectValue("players", "aboveMax");
        }
        // errors.popNestedPath();

        // errors.popNestedPath();
        // errors.popNestedPath();
    }

    private final DbxTeamBuilder getDbxTeamBuilder() {
        return builderService;
    }

}
