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

package com.bernardomg.tabletop.dreadball.web.toolkit.test.integration.codex.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.bernardomg.tabletop.dreadball.codex.service.CodexService;
import com.bernardomg.tabletop.dreadball.model.unit.Unit;
import com.google.common.collect.Iterables;

/**
 * Integration tests for {@link CodexService}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@ContextConfiguration(
        locations = { "classpath:context/test-service-context.xml" })
public class ITCodexService extends AbstractJUnit4SpringContextTests {

    /**
     * Tested service.
     */
    @Autowired
    private CodexService service;

    /**
     * Default constructor.
     */
    public ITCodexService() {
        super();
    }

    /**
     * Verifies that the units can be read.
     */
    @Test
    public final void testGetAffinityUnits_ReturnsExpected() {
        final Pageable pageable;
        final Iterable<? extends Unit> result;

        pageable = new PageRequest(0, 10);
        result = service.getAffinityUnits(pageable);

        Assert.assertEquals(4, Iterables.size(result));
    }

    /**
     * Verifies that the units are returned inside a page.
     */
    @Test
    public final void testGetAffinityUnits_ReturnsPage() {
        final Pageable pageable;
        final Iterable<? extends Unit> result;

        pageable = new PageRequest(0, 10);
        result = service.getAffinityUnits(pageable);

        Assert.assertTrue(result instanceof Page);
    }

}
