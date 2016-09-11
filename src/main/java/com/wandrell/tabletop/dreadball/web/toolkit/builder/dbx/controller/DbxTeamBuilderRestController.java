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
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.wandrell.tabletop.dreadball.build.dbx.DbxTeamBuilder;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.DefaultUnit;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorTeamAssets;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorTeamPlayer;

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
     * Parameter name for the team.
     */
    private static final String PARAM_TEAM = "team";

    /**
     * DBX team building service.
     */
    @Autowired
    private DbxTeamBuilder      dbxTeamBuilderService;

    /**
     * Message source.
     */
    @Autowired
    private MessageSource       messageSource;

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
    @PostMapping(path = "/players", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final SponsorTeam addPlayer(
            @RequestBody final SponsorTeamPlayer player,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        final Integer maxUnits; // Maximum number of units allowed
        final Unit unit;        // Unit to add
        String name;            // Unit name

        maxUnits = getDbxTeamBuilderService().getMaxTeamUnits();

        // TODO: Instead of enforcing the maximum send a warning
        if (team.getPlayers().size() < maxUnits) {
            unit = getDbxTeamBuilderService().getUnit(team.getSponsor(),
                    player.getTemplateName());

            // TODO: Is this internationalization step really needed here?
            try {
                name = getMessageSource().getMessage(player.getTemplateName(),
                        null, LocaleContextHolder.getLocale());
            } catch (final NoSuchMessageException e) {
                name = player.getTemplateName();
            }

            ((DefaultUnit) unit).setName(name);

            team.addPlayer(unit);
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
    @DeleteMapping(path = "/players",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final SponsorTeam removePlayer(
            @RequestBody final SponsorTeamPlayer player,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        team.removePlayer(player.getPosition());

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
    @PutMapping(path = "/assets/cheerleader",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final SponsorTeam setCheerleaders(
            @RequestBody final SponsorTeamAssets assets,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        team.setCheerleaders(assets.getCheerleaders());

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
    @PutMapping(path = "/assets/dice",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final SponsorTeam setDice(
            @RequestBody final SponsorTeamAssets assets,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        team.setCoachingDice(assets.getCoachingDice());

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
    @PutMapping(path = "/assets/medibots",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final SponsorTeam setMedibots(
            @RequestBody final SponsorTeamAssets assets,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        team.setMediBots(assets.getMediBots());

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
    @PutMapping(path = "/assets/sabotage",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final SponsorTeam setSabotageCards(
            @RequestBody final SponsorTeamAssets assets,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        team.setSabotageCards(assets.getSabotageCards());

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
    @PutMapping(path = "/assets/move",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final SponsorTeam setSpecialMoveCards(
            @RequestBody final SponsorTeamAssets assets,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        team.setSpecialMoveCards(assets.getSpecialMoveCards());

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
    @PutMapping(path = "/assets/wager",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final SponsorTeam setWagers(
            @RequestBody final SponsorTeamAssets assets,
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team) {
        team.setWagers(assets.getWagers());

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

    /**
     * Returns the message source.
     * 
     * @return the message source
     */
    private final MessageSource getMessageSource() {
        return messageSource;
    }

}
