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

package com.bernardomg.tabletop.dreadball.web.toolkit.test.unit.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.bernardomg.tabletop.dreadball.model.DefaultSponsorTeamAssets;

/**
 * Unit tests for {@link DefaultSponsorTeamAssets} bean validation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestSponsorTeamAssetsValidation {

    /**
     * Validator for validating the bean.
     */
    private Validator validator;

    /**
     * Default constructor.
     */
    public TestSponsorTeamAssetsValidation() {
        super();
    }

    /**
     * Sets up the validator for the tests.
     */
    @Before
    public final void setUpValidator() {
        validator = createValidator();
    }

    /**
     * Tests that the assets being negative causes a validation error.
     */
    @Test
    public final void testValidation_NegativeAssets_Error() {
        final DefaultSponsorTeamAssets assets; // Tested assets
        final Set<ConstraintViolation<DefaultSponsorTeamAssets>> errors;

        assets = new DefaultSponsorTeamAssets();

        assets.setCheerleaders(-1);
        assets.setCoachingDice(-1);
        assets.setMediBots(-1);
        assets.setNastySurpriseCards(-1);
        assets.setSpecialMoveCards(-1);
        assets.setWagers(-1);

        errors = validator.validate(assets);

        Assert.assertEquals(errors.size(), 6);
    }

    /**
     * Tests that the assets being null causes a validation error.
     */
    @Test
    public final void testValidation_NullAssets_Error() {
        final DefaultSponsorTeamAssets assets; // Tested assets
        final Set<ConstraintViolation<DefaultSponsorTeamAssets>> errors;

        assets = new DefaultSponsorTeamAssets();

        assets.setCheerleaders(null);
        assets.setCoachingDice(null);
        assets.setMediBots(null);
        assets.setNastySurpriseCards(null);
        assets.setSpecialMoveCards(null);
        assets.setWagers(null);

        errors = validator.validate(assets);

        Assert.assertEquals(errors.size(), 6);
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
