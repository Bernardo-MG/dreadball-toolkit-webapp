
package com.wandrell.tabletop.dreadball.build.dbx.assembler;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.common.collect.Sets;
import com.wandrell.tabletop.dreadball.build.dbx.model.DefaultSponsorAffinities;
import com.wandrell.tabletop.dreadball.build.dbx.model.SponsorAffinities;
import com.wandrell.tabletop.dreadball.build.dbx.rules.SponsorDefaults;

@Component
public class DefaultAffinitiesSelectionAssembler
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

        return new DefaultSponsorAffinities(valid, totalRank, totalRank);
    }

    private final SponsorDefaults getSponsorDefaults() {
        return sponsorDefaults;
    }

}
