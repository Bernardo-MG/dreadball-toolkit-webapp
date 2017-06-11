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

package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.service;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.build.dbx.DbxSponsorBuilder;

/**
 * Default implementation of the {@code DbxSponsorBuilder}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Service
public class DefaultDbxSponsorBuilder implements DbxSponsorBuilder {

    /**
     * Initial rank.
     */
    private final Integer initialRank;

    /**
     * Constructs a builder with the specified dependencies.
     * 
     * @param rank
     *            initial rank
     */
    @Autowired
    public DefaultDbxSponsorBuilder(
            @Value("${sponsor.rank.initial}") final Integer rank) {
        super();

        initialRank = checkNotNull(rank,
                "Received a null pointer as initial rank");
    }

    @Override
    public final Integer getInitialRank() {
        return initialRank;
    }

}
