
package com.bernardomg.tabletop.dreadball.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface OptionGroup {

    @JsonProperty
    public String getName();

    @JsonProperty
    public Iterable<Option> getOptions();

}
