
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

    private final DbxTeamBuilderService dbxTeamBuilderService;

    public DbxTeamBuilderRestController(final DbxTeamBuilderService service) {
        super();

        dbxTeamBuilderService = checkNotNull(service,
                "Received a null pointer as DBX team builder service");
    }

    @RequestMapping(path = "/players", method = RequestMethod.PUT)
    public final Map<Integer, ? extends Unit> greeting(
            @RequestParam(value = "templateName",
                    defaultValue = "") final String templateName,
            @SessionAttribute("team") final SponsorTeam team) {
        final Unit unit;

        unit = getDbxTeamBuilderService().getUnit(templateName);
        if (unit != null) {
            // TODO: The position should be calculated correctly
            team.addPlayer(unit, team.getPlayers().size());
        }

        return team.getPlayers();
    }

    private final DbxTeamBuilderService getDbxTeamBuilderService() {
        return dbxTeamBuilderService;
    }

}
