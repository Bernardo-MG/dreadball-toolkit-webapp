
package com.bernardomg.tabletop.dreadball.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An option for a combo box or similar UI component.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface Option {

    /**
     * Returns the label to show for the option.
     * 
     * @return the label to show for the option
     */
    @JsonProperty
    public String getLabel();

    /**
     * Returns the option value.
     * 
     * @return the option value
     */
    @JsonProperty
    public String getValue();

}
