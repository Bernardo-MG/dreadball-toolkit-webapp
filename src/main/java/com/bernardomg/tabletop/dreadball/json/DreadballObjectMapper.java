/**
 * Copyright 2016 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.bernardomg.tabletop.dreadball.json;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Maps the beans for Jackson.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Component
public final class DreadballObjectMapper extends ObjectMapper {

    /**
     * Serialization id.
     */
    private static final long serialVersionUID = 7809888101081207633L;

    /**
     * Constructs the mapper with the specified parameters.
     * 
     * @param dreadballModule
     *            module for the Dreadball model
     */
    @Autowired
    public DreadballObjectMapper(
            final JsonDreadballModelModule dreadballModule) {
        super();

        checkNotNull(dreadballModule, "Received a null pointer as JSON module");

        registerModule(dreadballModule);
    }

}
