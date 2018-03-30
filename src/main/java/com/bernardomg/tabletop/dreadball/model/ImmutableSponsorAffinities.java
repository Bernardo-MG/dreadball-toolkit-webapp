
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
     * @param affinities
     *            affinities
     * @param rank
     *            rank
     */
    public ImmutableSponsorAffinities(final Iterable<String> affinities,
            final Integer rank) {
        super();

        this.affinities = checkNotNull(affinities,
                "Received a null pointer as affinities");
        this.rank = checkNotNull(rank, "Received a null pointer as rank");
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
