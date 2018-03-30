
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
