
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
     * @param label
     *            option's label
     * @param value
     *            option's value
     */
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
