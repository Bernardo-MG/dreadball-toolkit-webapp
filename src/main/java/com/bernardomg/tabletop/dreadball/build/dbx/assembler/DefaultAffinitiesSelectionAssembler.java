
package com.bernardomg.tabletop.dreadball.build.dbx.assembler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bernardomg.tabletop.dreadball.build.dbx.model.DefaultSponsorAffinities;
import com.bernardomg.tabletop.dreadball.build.dbx.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.build.dbx.rules.SponsorDefaults;

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
    public final SponsorAffinities assemble(final Iterable<String> affinities) {
        final Integer totalRank;
        final Iterable<String> valid;
        final Integer rank;
        // TODO: Validate

        checkNotNull(affinities, "Received a null pointer as affinities");

        // TODO: Combine these operations with the assembler
        rank = getRank(affinities);
        // TODO: Ensure these are existing affinities
        valid = getValidAffinities(affinities);

        totalRank = getSponsorDefaults().getInitialRank() + rank;

        return new DefaultSponsorAffinities(valid, totalRank);
    }

    private final Integer getRank(final Iterable<String> affinities) {
        // TODO: This doesn't look like a good solution
        return StreamSupport.stream(affinities.spliterator(), false)
                .filter(affinity -> affinity.equals("rank_increase"))
                .collect(Collectors.toList()).size();
    }

    private final SponsorDefaults getSponsorDefaults() {
        return sponsorDefaults;
    }

    private final Iterable<String>
            getValidAffinities(final Iterable<String> affinities) {
        return StreamSupport.stream(affinities.spliterator(), false)
                .filter(affinity -> !affinity.equals("rank_increase"))
                .collect(Collectors.toSet());
    }

}
