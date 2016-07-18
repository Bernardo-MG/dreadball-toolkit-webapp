
package com.wandrell.tabletop.dreadball.web.toolkit.controller.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.web.toolkit.service.builder.DbxTeamBuilderService;

@RestController
@RequestMapping("/builder/team/dbx")
public class DbxTeamBuilderRestController {

    private static final String         PARAM_TEAM          = "team";

    private static final String         PARAM_TEMPLATE_NAME = "templateName";

    private static final String         PARAM_POSITION      = "position";

    private final DbxTeamBuilderService dbxTeamBuilderService;

    public DbxTeamBuilderRestController(final DbxTeamBuilderService service) {
        super();

        dbxTeamBuilderService = checkNotNull(service,
                "Received a null pointer as DBX team builder service");
    }

    @RequestMapping(path = "/players", method = RequestMethod.POST)
    public final Map<Integer, ? extends Unit> addPlayer(
            @RequestParam(name = PARAM_TEMPLATE_NAME,
                    defaultValue = "") final String templateName,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        final Integer maxUnits;

        maxUnits = getDbxTeamBuilderService().getMaxTeamUnits();

        if (team.getPlayers().size() < maxUnits) {
            getDbxTeamBuilderService().addUnit(team, templateName);
        }

        return team.getPlayers();
    }

    @RequestMapping(path = "/players", method = RequestMethod.DELETE)
    public final Map<Integer, ? extends Unit> removePlayer(
            @RequestParam(name = PARAM_POSITION,
                    defaultValue = "-1") final Integer position,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        team.removePlayer(position);

        return team.getPlayers();
    }

    private final DbxTeamBuilderService getDbxTeamBuilderService() {
        return dbxTeamBuilderService;
    }

}
