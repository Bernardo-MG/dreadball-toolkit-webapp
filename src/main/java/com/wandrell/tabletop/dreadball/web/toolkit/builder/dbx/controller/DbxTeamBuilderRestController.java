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

package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.wandrell.tabletop.dreadball.build.dbx.DbxTeamBuilder;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;

/**
 * Controller for the DBX team building AJAX operations.
 * <p>
 * The team to be edited is stored as a session variable.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RestController
@RequestMapping("/builder/team/dbx")
public class DbxTeamBuilderRestController {

    /**
     * Parameter name for the cheerleaders.
     */
    private static final String PARAM_CHEERLEADERS  = "cheerleaders";

    /**
     * Parameter name for the dice.
     */
    private static final String PARAM_DICE          = "dice";

    /**
     * Parameter name for the medibots.
     */
    private static final String PARAM_MEDIBOTS      = "medibots";

    /**
     * Parameter name for the special move cards.
     */
    private static final String PARAM_MOVES         = "cards";

    /**
     * Parameter name for the position.
     */
    private static final String PARAM_POSITION      = "position";

    /**
     * Parameter name for the sabotage cards.
     */
    private static final String PARAM_SABOTAGES     = "cards";

    /**
     * Parameter name for the team.
     */
    private static final String PARAM_TEAM          = "team";

    /**
     * Parameter name for the template name.
     */
    private static final String PARAM_TEMPLATE_NAME = "templateName";

    /**
     * Parameter name for the wagers.
     */
    private static final String PARAM_WAGERS        = "wagers";

    /**
     * DBX team building service.
     */
    @Autowired
    private DbxTeamBuilder      dbxTeamBuilderService;

    /**
     * Constructs a controller with the specified dependencies.
     */
    public DbxTeamBuilderRestController() {
        super();
    }

    /**
     * Adds a player to the team.
     * 
     * @param templateName
     *            template name of the player to add
     * @param team
     *            team where the player will be added
     * @return the team with the new player
     */
    @RequestMapping(path = "/players", method = RequestMethod.POST)
    public final SponsorTeam addPlayer(
            @RequestParam(name = PARAM_TEMPLATE_NAME,
                    defaultValue = "") final String templateName,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        final Integer maxUnits; // Maximum number of units allowed

        maxUnits = getDbxTeamBuilderService().getMaxTeamUnits();

        // TODO: Instead of enforcing the maximum send a warning
        if (team.getPlayers().size() < maxUnits) {
            getDbxTeamBuilderService().addUnit(team, templateName);
        }

        return team;
    }

    /**
     * Removes a player from the team.
     * 
     * @param position
     *            numeric position of the player in the team
     * @param team
     *            team containing the player
     * @return the team without the removed player
     */
    @RequestMapping(path = "/players", method = RequestMethod.DELETE)
    public final SponsorTeam removePlayer(
            @RequestParam(name = PARAM_POSITION,
                    defaultValue = "-1") final Integer position,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        team.removePlayer(position);

        return team;
    }

    /**
     * Sets the number of cheerleaders in the team.
     * 
     * @param cheerleaders
     *            number of cheerleaders to set in the team
     * @param team
     *            the team where the cheerleaders will be set
     * @return the team with the cheerleaders set
     */
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

    /**
     * Sets the number of dice in the team.
     * 
     * @param dice
     *            number of dice to set in the team
     * @param team
     *            the team where the dice will be set
     * @return the team with the dice set
     */
    @RequestMapping(path = "/assets/dice",
            method = { RequestMethod.POST, RequestMethod.PUT })
    public final SponsorTeam
            setDice(@RequestParam(name = PARAM_DICE,
                    defaultValue = "-1") final Integer dice,
                    @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        if (dice >= 0) {
            team.setCoachingDice(dice);
        }

        return team;
    }

    /**
     * Sets the number of medibots in the team.
     * 
     * @param medibots
     *            number of medibots to set in the team
     * @param team
     *            the team where the medibots will be set
     * @return the team with the medibots set
     */
    @RequestMapping(path = "/assets/medibots",
            method = { RequestMethod.POST, RequestMethod.PUT })
    public final SponsorTeam setMedibots(
            @RequestParam(name = PARAM_MEDIBOTS,
                    defaultValue = "-1") final Integer medibots,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        if (medibots >= 0) {
            team.setMediBots(medibots);
        }

        return team;
    }

    /**
     * Sets the number of sabotage cards in the team.
     * 
     * @param sabotage
     *            number of sabotage cards to set in the team
     * @param team
     *            the team where the sabotage cards will be set
     * @return the team with the sabotage cards set
     */
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

    /**
     * Sets the number of special move cards in the team.
     * 
     * @param move
     *            number of special move cards to set in the team
     * @param team
     *            the team where the special move cards will be set
     * @return the team with the special move cards set
     */
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

    /**
     * Sets the number of wagers in the team.
     * 
     * @param wagers
     *            number of wagers to set in the team
     * @param team
     *            the team where the wagers will be set
     * @return the team with the wagers set
     */
    @RequestMapping(path = "/assets/wager",
            method = { RequestMethod.POST, RequestMethod.PUT })
    public final SponsorTeam setWagers(
            @RequestParam(name = PARAM_WAGERS,
                    defaultValue = "-1") final Integer wagers,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        if (wagers >= 0) {
            team.setWagers(wagers);
        }

        return team;
    }

    /**
     * Returns the DBX team builder service.
     * 
     * @return the DBX team builder service
     */
    private final DbxTeamBuilder getDbxTeamBuilderService() {
        return dbxTeamBuilderService;
    }

}
