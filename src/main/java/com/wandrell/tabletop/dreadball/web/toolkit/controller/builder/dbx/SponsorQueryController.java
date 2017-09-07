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

package com.wandrell.tabletop.dreadball.web.toolkit.controller.builder.dbx;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wandrell.tabletop.dreadball.build.dbx.service.SponsorBuilderService;
import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.unit.DefaultAffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.Unit;

/**
 * Controller for the affinity groups codex views.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RestController
@RequestMapping("/rest/builder")
public class SponsorQueryController {

    private final SponsorBuilderService builderService;

    /**
     * Constructs a controller with the specified dependencies.
     * 
     * @param sponsorBuilderService
     *            sponsor units service
     */
    @Autowired
    public SponsorQueryController(
            final SponsorBuilderService sponsorBuilderService) {
        super();

        builderService = checkNotNull(sponsorBuilderService,
                "Received a null pointer as builder service");
    }

    /**
     * Returns the view for all the affinity units.
     * 
     * @return the view for all the affinity units
     */
    @GetMapping(path = "/affinity",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final Iterable<SponsorAffinityGroupAvailability>
            getAffinityGroups() {
        return getSponsorBuilderService().getAffinityGroupAvailabilities();
    }

    @GetMapping(path = "/units",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final Iterable<? extends Unit> getDbxUnits(@RequestParam(
            name = "affinities", required = false,
            defaultValue = "") final ArrayList<DefaultAffinityGroup> affinities,
            @RequestParam(name = "page", required = false,
                    defaultValue = "0") final Integer page,
            @RequestParam(name = "size", required = false,
                    defaultValue = "10") final Integer size,
            @RequestParam(name = "orderBy", required = false,
                    defaultValue = "") final String orderBy,
            @RequestParam(name = "direction", required = false,
                    defaultValue = "ASC") final Direction direction) {
        final Pageable pageReq;

        // TODO: Page and size may be stored automatically into a pageable
        // Check:
        // https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-part-seven-pagination/
        // http://www.baeldung.com/rest-api-pagination-in-spring
        if (orderBy.isEmpty()) {
            pageReq = new PageRequest(page, size);
        } else {
            pageReq = new PageRequest(page, size, direction, orderBy);
        }

        return getSponsorBuilderService().getAffinityUnits(affinities, pageReq);
    }

    private final SponsorBuilderService getSponsorBuilderService() {
        return builderService;
    }

}
