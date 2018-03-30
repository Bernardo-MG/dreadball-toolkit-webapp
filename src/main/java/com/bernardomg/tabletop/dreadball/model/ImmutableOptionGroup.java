
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
     * @param name
     *            option group's name
     * @param options
     *            option group's options
     */
    public ImmutableOptionGroup(final String name,
            final Collection<Option> options) {
        super();

        this.name = name;
        this.options = options;
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
