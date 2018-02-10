
package com.bernardomg.tabletop.dreadball.model;

public final class ImmutableOption implements Option {

    private final String label;

    private final String value;

    public ImmutableOption(final String label, final String value) {
        super();
        this.label = label;
        this.value = value;
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
