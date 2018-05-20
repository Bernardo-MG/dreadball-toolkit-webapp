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

import java.util.Collection;

/**
 * Immutable implementation of {@link OptionGroup}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class ImmutableOptionGroup implements OptionGroup {

    /**
     * Option group name.
     */
    private final String             name;

    /**
     * Option group options.
     */
    private final Collection<Option> options;

    /**
     * Constructs an option group.
     * 
     * @param groupName
     *            option group's name
     * @param groupOptions
     *            option group's options
     */
    public ImmutableOptionGroup(final String groupName,
            final Collection<Option> groupOptions) {
        super();

        name = groupName;
        options = groupOptions;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Collection<Option> getOptions() {
        return options;
    }

}
