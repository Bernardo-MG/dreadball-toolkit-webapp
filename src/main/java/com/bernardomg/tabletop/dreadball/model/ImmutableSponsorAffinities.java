
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
