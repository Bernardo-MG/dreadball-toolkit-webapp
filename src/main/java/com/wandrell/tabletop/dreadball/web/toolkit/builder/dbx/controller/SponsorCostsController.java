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

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wandrell.tabletop.dreadball.build.dbx.SponsorCosts;
import com.wandrell.tabletop.dreadball.build.dbx.model.DefaultSponsorCosts;

/**
 * Controller for the DBX team building AJAX operations.
 * <p>
 * The team to be edited is stored as a session variable.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RestController
@RequestMapping("/rest/builder")
public class SponsorCostsController {

    private final SponsorCosts sponsorCosts;

    @Autowired
    public SponsorCostsController(final SponsorCosts costs) {
        super();

        sponsorCosts = checkNotNull(costs,
                "Received a null pointer as sponsor costs");
    }

    @GetMapping(path = "/costs",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final SponsorCosts getDefaultCosts() {
        final DefaultSponsorCosts defaults;

        defaults = new DefaultSponsorCosts();

        BeanUtils.copyProperties(getSponsorCosts(), defaults);

        return defaults;
    }

    private final SponsorCosts getSponsorCosts() {
        return sponsorCosts;
    }

}
