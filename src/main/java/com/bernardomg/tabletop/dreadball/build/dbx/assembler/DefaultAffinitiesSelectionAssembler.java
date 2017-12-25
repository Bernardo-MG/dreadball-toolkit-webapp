
package com.bernardomg.tabletop.dreadball.build.dbx.assembler;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bernardomg.tabletop.dreadball.build.dbx.model.DefaultSponsorAffinities;
import com.bernardomg.tabletop.dreadball.build.dbx.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.build.dbx.rules.SponsorDefaults;
import com.google.common.collect.Sets;

@Component
public final class DefaultAffinitiesSelectionAssembler
        implements AffinitiesSelectionAssembler {

    private final SponsorDefaults sponsorDefaults;

    @Autowired
    public DefaultAffinitiesSelectionAssembler(final SponsorDefaults defaults) {
        super();

        sponsorDefaults = checkNotNull(defaults,
                "Received a null pointer as Sponsor defaults service");
    }

    @Override
    public final SponsorAffinities assemble(final Iterable<String> affinities,
            final Integer rank) {
        final Integer totalRank;
        final Iterable<String> valid;

        checkNotNull(affinities, "Received a null pointer as affinities");
        checkNotNull(rank, "Received a null pointer as rank");

        valid = Sets.newHashSet(affinities);

        totalRank = getSponsorDefaults().getInitialRank() + rank;

        return new DefaultSponsorAffinities(valid, totalRank);
    }

    private final SponsorDefaults getSponsorDefaults() {
        return sponsorDefaults;
    }

}
