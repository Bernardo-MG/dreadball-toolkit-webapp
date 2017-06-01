
package com.wandrell.tabletop.dreadball.build.dbx;

import static com.google.common.base.Preconditions.checkNotNull;

public class DefaultDbxBuilderDefaults implements DbxBuilderDefaults {

    final Integer initialRank;

    public DefaultDbxBuilderDefaults(final Integer rank) {
        super();

        initialRank = checkNotNull(rank, "Received a null pointer as rank");
    }

    @Override
    public Integer getInitialRank() {
        return initialRank;
    }

}
