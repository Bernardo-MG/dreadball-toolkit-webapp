/**
 * Copyright 2018 the original author or authors
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

package com.bernardomg.tabletop.dreadball.model;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Immutable implementation of {@link SponsorAffinities}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class ImmutableSponsorAffinities implements SponsorAffinities {

    /**
     * Affinities.
     */
    private final Iterable<String> affinities;

    /**
     * Ranks.
     */
    private final Integer          rank;

    /**
     * Constructs a sponsor affinities set.
     * 
     * @param affs
     *            affinities
     * @param affsRank
     *            rank
     */
    public ImmutableSponsorAffinities(final Iterable<String> affs,
            final Integer affsRank) {
        super();

        affinities = checkNotNull(affs,
                "Received a null pointer as affinities");
        rank = checkNotNull(affsRank, "Received a null pointer as rank");
    }

    @Override
    public Iterable<String> getAffinities() {
        return affinities;
    }

    @Override
    public final Integer getRank() {
        return rank;
    }

}
