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

package com.bernardomg.tabletop.dreadball.model;

/**
 * Immutable implementation of {@link Option}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class ImmutableOption implements Option {

    /**
     * The option label.
     */
    private final String label;

    /**
     * The option value.
     */
    private final String value;

    /**
     * Constructs an option.
     * 
     * @param optionLabel
     *            option's label
     * @param optionValue
     *            option's value
     */
    public ImmutableOption(final String optionLabel, final String optionValue) {
        super();

        label = optionLabel;
        value = optionValue;
    }

    @Override
    public final String getLabel() {
        return label;
    }

    @Override
    public final String getValue() {
        return value;
    }

}
