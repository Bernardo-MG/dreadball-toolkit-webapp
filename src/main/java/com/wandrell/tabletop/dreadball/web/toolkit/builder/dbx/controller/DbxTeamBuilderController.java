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

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;

/**
 * Controller for the DBX team building AJAX operations.
 * <p>
 * The team to be edited is stored as a session variable.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
// @RestController
// @RequestMapping("/builder/team/dbx")
public class DbxTeamBuilderController {

    /**
     * Parameter name for the team.
     */
    private static final String PARAM_TEAM = "team";

    private final Validator     teamValidator;

    /**
     * Constructs a controller with the specified dependencies.
     * 
     * @param validator
     *            team validator
     */
    @Autowired
    public DbxTeamBuilderController(
            @Qualifier("sponsorTeamValidator") final Validator validator) {
        super();

        teamValidator = checkNotNull(validator,
                "Received a null pointer as validator");
    }

    @GetMapping(path = "/validate",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final String
            validateTeam(@SessionAttribute(PARAM_TEAM) final SponsorTeam team)
                    throws BindException {
        final BindingResult errors;

        errors = new BeanPropertyBindingResult(team, "team");
        getTeamValidator().validate(team, errors);
        if (errors.hasErrors()) {
            throw new BindException(errors);
        }

        return "{}";
    }

    private final Validator getTeamValidator() {
        return teamValidator;
    }

}
