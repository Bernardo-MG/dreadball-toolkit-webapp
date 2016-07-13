
package com.wandrell.tabletop.dreadball.web.toolkit.json;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class DreadballObjectMapper extends ObjectMapper {

    private static final long serialVersionUID = 7809888101081207633L;

    public DreadballObjectMapper() {
        super();

        registerModule(new JsonModelModule());
    }

}
