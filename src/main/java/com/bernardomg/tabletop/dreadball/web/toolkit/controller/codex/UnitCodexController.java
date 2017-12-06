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

package com.bernardomg.tabletop.dreadball.web.toolkit.controller.codex;

import static com.google.common.base.Preconditions.checkNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bernardomg.tabletop.dreadball.model.unit.Unit;
import com.bernardomg.tabletop.dreadball.service.model.UnitService;

/**
 * Controller for the unit codex views.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RestController
@RequestMapping("/rest/units")
public class UnitCodexController {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(UnitCodexController.class);

    /**
     * Unit codex service.
     */
    private final UnitService   unitCodexService;

    /**
     * Constructs a controller with the specified dependencies.
     * 
     * @param codex
     *            unit codex service
     */
    public UnitCodexController(final UnitService codex) {
        super();

        unitCodexService = checkNotNull(codex,
                "Received a null pointer as unit codex service");
    }

    /**
     * Returns the view for all the affinity units.
     * 
     * @param page
     *            page number
     * @param size
     *            page size
     * @param orderBy
     *            field to order by
     * @param direction
     *            ordering direction
     * @return the view for all the affinity units
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final Iterable<? extends Unit> getDbxUnits(
            @RequestParam(name = "page", defaultValue = "0") final Integer page,
            @RequestParam(name = "size",
                    defaultValue = "10") final Integer size,
            @RequestParam(name = "orderBy",
                    defaultValue = "") final String orderBy,
            @RequestParam(name = "direction",
                    defaultValue = "ASC") final Direction direction) {
        final Pageable pageReq;

        LOGGER.debug("orderBy: {}", orderBy);
        LOGGER.debug("direction: {}", direction);

        // TODO: Page and size may be stored automatically into a pageable
        // Check:
        // https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-part-seven-pagination/
        // http://www.baeldung.com/rest-api-pagination-in-spring
        if (orderBy.isEmpty()) {
            pageReq = new PageRequest(page, size);
        } else {
            pageReq = new PageRequest(page, size, direction, orderBy);
        }

        final Iterable<? extends Unit> result;
        result = getUnitCodexService().getAllAffinityUnits(pageReq);

        return result;
    }

    /**
     * Returns the unit codex service.
     * 
     * @return the unit codex service
     */
    private final UnitService getUnitCodexService() {
        return unitCodexService;
    }

}
