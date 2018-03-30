
package com.bernardomg.tabletop.dreadball.model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A group of options.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface OptionGroup {

    /**
     * Returns the group's name.
     * 
     * @return the group's name
     */
    @JsonProperty
    public String getName();

    /**
     * Returns the group's options.
     * 
     * @return the group's options
     */
    @JsonProperty
    public Collection<Option> getOptions();

}
