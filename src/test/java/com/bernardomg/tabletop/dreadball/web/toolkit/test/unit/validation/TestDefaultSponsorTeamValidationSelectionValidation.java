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

package com.bernardomg.tabletop.dreadball.web.toolkit.test.unit.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.bernardomg.tabletop.dreadball.model.DefaultSponsorTeamSelection;

/**
 * Unit tests for {@link DefaultSponsorTeamSelection} bean validation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestDefaultSponsorTeamValidationSelectionValidation {

    /**
     * Validator for validating the bean.
     */
    private Validator validator;

    /**
     * Default constructor.
     */
    public TestDefaultSponsorTeamValidationSelectionValidation() {
        super();
    }

    /**
     * Sets up the validator for the tests.
     */
    @BeforeEach
    public final void setUpValidator() {
        validator = createValidator();
    }

    /**
     * Tests that the assets being negative causes a validation error.
     */
    @Test
    public final void testValidation_NegativeAssets_Error() {
        final DefaultSponsorTeamSelection selection; // Tested assets
        final Set<ConstraintViolation<DefaultSponsorTeamSelection>> errors;

        selection = new DefaultSponsorTeamSelection();

        selection.setCheerleaders(-1);
        selection.setCoachingDice(-1);
        selection.setMediBots(-1);
        selection.setNastySurpriseCards(-1);
        selection.setSpecialMoveCards(-1);
        selection.setWagers(-1);

        errors = validator.validate(selection);

        Assertions.assertEquals(6, errors.size());
    }

    /**
     * Tests that the assets being null causes a validation error.
     */
    @Test
    public final void testValidation_NullAssets_Error() {
        final DefaultSponsorTeamSelection selection; // Tested assets
        final Set<ConstraintViolation<DefaultSponsorTeamSelection>> errors;

        selection = new DefaultSponsorTeamSelection();

        selection.setCheerleaders(null);
        selection.setCoachingDice(null);
        selection.setMediBots(null);
        selection.setNastySurpriseCards(null);
        selection.setSpecialMoveCards(null);
        selection.setWagers(null);

        errors = validator.validate(selection);

        Assertions.assertEquals(6, errors.size());
    }

    /**
     * Returns the validator to use in the tests.
     * 
     * @return the validator to use in the tests
     */
    private final Validator createValidator() {
        final LocalValidatorFactoryBean localValidatorFactoryBean;

        localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.afterPropertiesSet();

        return localValidatorFactoryBean;
    }

}
