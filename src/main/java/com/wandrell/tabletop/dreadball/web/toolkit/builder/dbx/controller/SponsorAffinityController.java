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

import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.unit.DefaultAffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.service.SponsorAffinityGroupAvailabilityService;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.service.SponsorUnitsService;

/**
 * Controller for the affinity groups codex views.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RestController
@RequestMapping("/rest/builder")
public class SponsorAffinityController {

    /**
     * Affinity groups codex service.
     */
    private final SponsorAffinityGroupAvailabilityService sponsorAffinityGroupAvailabilityService;

    private final SponsorUnitsService                     sponsorUnitsService;

    /**
     * Constructs a controller with the specified dependencies.
     * 
     * @param service
     *            affinity groups codex service
     * @param unitsService
     *            sponsor units service
     */
    @Autowired
    public SponsorAffinityController(
            final SponsorAffinityGroupAvailabilityService service,
            final SponsorUnitsService unitsService) {
        super();

        sponsorAffinityGroupAvailabilityService = checkNotNull(service,
                "Received a null pointer as Sponsor affinity groups availabilities codex service");
        sponsorUnitsService = checkNotNull(unitsService,
                "Received a null pointer as Sponsor units service");
    }

    private final SponsorUnitsService getSponsorUnitsService() {
        return sponsorUnitsService;
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
        return getSponsorAffinityGroupAvailabilityService()
                .getAllSponsorAffinityGroupAvailabilities();
    }

    @GetMapping(path = "/units",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final Iterable<? extends Unit> getDbxUnits(@RequestParam(
            name = "affinities", required = false,
            defaultValue = "") final ArrayList<DefaultAffinityGroup> affinities,
            @RequestParam(name = "page", defaultValue = "0") final Integer page,
            @RequestParam(name = "size",
                    defaultValue = "10") final Integer size,
            @RequestParam(name = "orderBy",
                    defaultValue = "") final String orderBy,
            @RequestParam(name = "direction",
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

        return getSponsorUnitsService().getAllAffinityUnits(affinities,
                pageReq);
    }

    /**
     * Returns the affinity groups service.
     * 
     * @return the affinity groups service
     */
    private final SponsorAffinityGroupAvailabilityService
            getSponsorAffinityGroupAvailabilityService() {
        return sponsorAffinityGroupAvailabilityService;
    }

}
