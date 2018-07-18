/**
 * Copyright 2018 the original author or authors
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

package com.bernardomg.tabletop.dreadball.web.toolkit.test.integration.repository;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.bernardomg.tabletop.dreadball.model.persistence.player.PersistentAffinityTeamPlayer;
import com.bernardomg.tabletop.dreadball.repository.player.AffinityTeamPlayerRepository;
import com.bernardomg.tabletop.dreadball.web.toolkit.test.configuration.TestValues;

/**
 * Integration tests for {@link AffinityTeamPlayerRepository}, checking the
 * query filtering by a name list.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(locations = { "classpath:context/test-db-context.xml" })
public class ITAffinityTeamPlayerRepositoryInList
        extends AbstractTransactionalJUnit4SpringContextTests {

    /**
     * Tested repository.
     */
    @Autowired
    private AffinityTeamPlayerRepository repository;

    /**
     * Default constructor.
     */
    public ITAffinityTeamPlayerRepositoryInList() {
        super();
    }

    /**
     * Verifies that filtering by an empty list returns no values.
     */
    @Test
    public final void testFindByTemplateNameIn_EmptyList() {
        final Collection<String> names;
        final Collection<PersistentAffinityTeamPlayer> result;

        names = new ArrayList<>();

        result = repository.findByTemplateNameInOrderByTemplateNameAsc(names);

        Assertions.assertEquals(0, result.size());
    }

    /**
     * Verifies that filtering by a template name returns the entity matching
     * it.
     */
    @Test
    public final void testFindByTemplateNameIn_ExpectedData() {
        final Collection<String> names;
        final Collection<PersistentAffinityTeamPlayer> result;
        final PersistentAffinityTeamPlayer player;

        names = new ArrayList<>();
        names.add(TestValues.PLAYER_A);

        result = repository.findByTemplateNameInOrderByTemplateNameAsc(names);

        player = result.iterator().next();

        Assertions.assertEquals(1, player.getAffinityGroups().size());

        Assertions.assertEquals(new Integer(23), player.getStrangerCost());
        Assertions.assertEquals(new Integer(15), player.getAllyCost());
        Assertions.assertEquals(new Integer(10), player.getFriendCost());
    }

    /**
     * Verifies that filtering by a collection of template names returns all the
     * entities matching them.
     */
    @Test
    public final void testFindByTemplateNameIn_MultipleNames() {
        final Collection<String> names;
        final Collection<PersistentAffinityTeamPlayer> result;

        names = new ArrayList<>();
        names.add(TestValues.PLAYER_A);
        names.add(TestValues.PLAYER_C);

        result = repository.findByTemplateNameInOrderByTemplateNameAsc(names);

        Assertions.assertEquals(2, result.size());
    }

    /**
     * Verifies that filtering by a repeated name returns the expected values.
     */
    @Test
    public final void testFindByTemplateNameIn_RepeatedName() {
        final Collection<String> names;
        final Collection<PersistentAffinityTeamPlayer> result;

        names = new ArrayList<>();
        names.add(TestValues.PLAYER_A);
        names.add(TestValues.PLAYER_C);
        names.add(TestValues.PLAYER_A);

        result = repository.findByTemplateNameInOrderByTemplateNameAsc(names);

        Assertions.assertEquals(2, result.size());
    }

    /**
     * Verifies that filtering by a template name returns the entity matching
     * it.
     */
    @Test
    public final void testFindByTemplateNameIn_SingleName() {
        final Collection<String> names;
        final Collection<PersistentAffinityTeamPlayer> result;

        names = new ArrayList<>();
        names.add(TestValues.PLAYER_A);

        result = repository.findByTemplateNameInOrderByTemplateNameAsc(names);

        Assertions.assertEquals(1, result.size());
    }

}
