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

package com.wandrell.tabletop.dreadball.web.toolkit.test.unit.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorForm;

/**
 * Unit tests for {@link SponsorForm} validation.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The name being empty causes a validation error</li>
 * <li>The affinities being empty causes a validation error</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public class TestSponsorFormValidation {

    /**
     * Validator for validating the bean.
     */
    private Validator validator;

    /**
     * Default constructor.
     */
    public TestSponsorFormValidation() {
        super();
    }

    /**
     * Sets up the validator for the tests.
     */
    @BeforeTest
    public final void setUpValidator() {
        validator = createValidator();
    }

    /**
     * Tests that the affinities being empty causes a validation error.
     */
    @Test
    public final void testValidation_NoAffinities_Error() {
        final SponsorForm form;
        final Set<ConstraintViolation<SponsorForm>> constraintViolations;

        form = new SponsorForm();

        form.setSponsorName("-");

        constraintViolations = validator.validate(form);

        Assert.assertEquals(constraintViolations.size(), 5);
    }

    /**
     * Tests that the name being empty causes a validation error.
     */
    @Test
    public final void testValidation_NoName_Error() {
        final SponsorForm form;
        final Set<ConstraintViolation<SponsorForm>> constraintViolations;
        final ConstraintViolation<SponsorForm> violation;

        form = new SponsorForm();

        form.setAffinityA("-");
        form.setAffinityB("-");
        form.setAffinityC("-");
        form.setAffinityD("-");
        form.setAffinityE("-");

        constraintViolations = validator.validate(form);

        Assert.assertEquals(constraintViolations.size(), 1);

        violation = constraintViolations.iterator().next();
        Assert.assertEquals(violation.getPropertyPath().toString(),
                "sponsorName");
    }

    private final Validator createValidator() {
        final LocalValidatorFactoryBean localValidatorFactoryBean;

        localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.afterPropertiesSet();

        return localValidatorFactoryBean;
    }

}
