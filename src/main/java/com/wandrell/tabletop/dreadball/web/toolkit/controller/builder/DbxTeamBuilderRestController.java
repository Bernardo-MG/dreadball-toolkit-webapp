
package com.wandrell.tabletop.dreadball.web.toolkit.controller.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.web.toolkit.service.builder.DbxTeamBuilderService;

@RestController
@RequestMapping("/builder/team/dbx")
public class DbxTeamBuilderRestController {

    private static final String         PARAM_TEAM          = "team";

    private static final String         PARAM_TEMPLATE_NAME = "templateName";

    private static final String         PARAM_DICE          = "dice";

    private static final String         PARAM_POSITION      = "position";

    private static final String         PARAM_SABOTAGES     = "cards";

    private static final String         PARAM_MOVES         = "cards";

    private static final String         PARAM_WAGERS        = "wagers";

    private static final String         PARAM_MEDIBOTS      = "medibots";

    private static final String         PARAM_CHEERLEADERS  = "cheerleaders";

    private final DbxTeamBuilderService dbxTeamBuilderService;

    public DbxTeamBuilderRestController(final DbxTeamBuilderService service) {
        super();

        dbxTeamBuilderService = checkNotNull(service,
                "Received a null pointer as DBX team builder service");
    }

    @RequestMapping(path = "/players", method = RequestMethod.POST)
    public final SponsorTeam addPlayer(
            @RequestParam(name = PARAM_TEMPLATE_NAME,
                    defaultValue = "") final String templateName,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        final Integer maxUnits;

        maxUnits = getDbxTeamBuilderService().getMaxTeamUnits();

        if (team.getPlayers().size() < maxUnits) {
            getDbxTeamBuilderService().addUnit(team, templateName);
        }

        return team;
    }

    @RequestMapping(path = "/players", method = RequestMethod.DELETE)
    public final SponsorTeam removePlayer(
            @RequestParam(name = PARAM_POSITION,
                    defaultValue = "-1") final Integer position,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        team.removePlayer(position);

        return team;
    }

    @RequestMapping(path = "/assets/cheerleader",
            method = { RequestMethod.POST, RequestMethod.PUT })
    public final SponsorTeam setCheerleaders(
            @RequestParam(name = PARAM_CHEERLEADERS,
                    defaultValue = "-1") final Integer cheerleaders,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        if (cheerleaders >= 0) {
            team.setCheerleaders(cheerleaders);
        }

        return team;
    }

    @RequestMapping(path = "/assets/dice",
            method = { RequestMethod.POST, RequestMethod.PUT })
    public final SponsorTeam setDreadballDice(
            @RequestParam(name = PARAM_DICE,
                    defaultValue = "-1") final Integer dice,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        if (dice >= 0) {
            team.setCoachingDice(dice);
        }

        return team;
    }

    @RequestMapping(path = "/assets/medibots",
            method = { RequestMethod.POST, RequestMethod.PUT })
    public final SponsorTeam setMedibots(
            @RequestParam(name = PARAM_MEDIBOTS,
                    defaultValue = "-1") final Integer medibot,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        if (medibot >= 0) {
            team.setMediBots(medibot);
        }

        return team;
    }

    @RequestMapping(path = "/assets/sabotage",
            method = { RequestMethod.POST, RequestMethod.PUT })
    public final SponsorTeam setSabotageCards(
            @RequestParam(name = PARAM_SABOTAGES,
                    defaultValue = "-1") final Integer sabotage,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        if (sabotage >= 0) {
            team.setSabotageCards(sabotage);
        }

        return team;
    }

    @RequestMapping(path = "/assets/move",
            method = { RequestMethod.POST, RequestMethod.PUT })
    public final SponsorTeam setSpecialMoveCards(
            @RequestParam(name = PARAM_MOVES,
                    defaultValue = "-1") final Integer move,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        if (move >= 0) {
            team.setSpecialMoveCards(move);
        }

        return team;
    }

    @RequestMapping(path = "/assets/wager",
            method = { RequestMethod.POST, RequestMethod.PUT })
    public final SponsorTeam setWagers(
            @RequestParam(name = PARAM_WAGERS,
                    defaultValue = "-1") final Integer wager,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        if (wager >= 0) {
            team.setWagers(wager);
        }

        return team;
    }

    private final DbxTeamBuilderService getDbxTeamBuilderService() {
        return dbxTeamBuilderService;
    }

}
