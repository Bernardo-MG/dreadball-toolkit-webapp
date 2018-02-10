
package com.bernardomg.tabletop.dreadball.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface Option {

    @JsonProperty
    public String getLabel();

    @JsonProperty
    public String getValue();

}
