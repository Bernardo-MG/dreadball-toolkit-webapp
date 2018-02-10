
package com.bernardomg.tabletop.dreadball.model;

import java.util.Collection;

public final class ImmutableOptionGroup implements OptionGroup {

    private final String             name;

    private final Collection<Option> options;

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
