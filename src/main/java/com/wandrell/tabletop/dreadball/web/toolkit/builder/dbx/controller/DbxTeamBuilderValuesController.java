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
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wandrell.tabletop.dreadball.build.dbx.DbxSponsorBuilder;
import com.wandrell.tabletop.dreadball.build.dbx.DefaultDbxBuilderDefaults;

/**
 * Controller for the DBX team building AJAX operations.
 * <p>
 * The team to be edited is stored as a session variable.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RestController
@RequestMapping("/rest/builder")
public class DbxTeamBuilderValuesController {

    private final DbxSponsorBuilder sponsorBuilder;

    @Autowired
    public DbxTeamBuilderValuesController(final DbxSponsorBuilder builder) {
        super();

        sponsorBuilder = checkNotNull(builder,
                "Received a null pointer as builder");
    }

    @GetMapping(path = "/defaults",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final DefaultDbxBuilderDefaults validateTeam() {
        return new DefaultDbxBuilderDefaults(
                getDbxSponsorBuilder().getInitialRank());
    }

    private final DbxSponsorBuilder getDbxSponsorBuilder() {
        return sponsorBuilder;
    }

}
