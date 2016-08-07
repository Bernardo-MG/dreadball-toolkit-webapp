
package com.wandrell.tabletop.dreadball.web.toolkit.json;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class DreadballObjectMapper extends ObjectMapper {

    private static final long serialVersionUID = 7809888101081207633L;

    @Autowired
    public DreadballObjectMapper(
            @Qualifier("jsonModelModule") final JsonModelModule module) {
        super();

        checkNotNull(module, "Received a null pointer as JSON module");

        registerModule(module);
    }

}
