
package com.wandrell.tabletop.dreadball.build.dbx.assembler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.build.dbx.model.DefaultSponsorAffinities;
import com.wandrell.tabletop.dreadball.build.dbx.model.SponsorAffinities;
import com.wandrell.tabletop.dreadball.build.dbx.rules.SponsorDefaults;

@Service
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
    public final SponsorAffinities
            assemble(final Collection<String> affinities) {
        final Integer rank;
        final Iterable<String> filtered;

        checkNotNull(affinities, "Received a null pointer as affinities");

        // TODO: Ensure these are existing affinities
        filtered = getValidAffinities(affinities);
        rank = getRank(affinities);

        return new DefaultSponsorAffinities(filtered, rank, rank);
    }

    private final Integer getRank(final Collection<String> affinities) {
        final Integer rank;
        final Integer rankAdd;

        rankAdd = affinities.stream()
                .filter(affinity -> affinity.equals("rank_increase"))
                .collect(Collectors.toList()).size();

        rank = getSponsorDefaults().getInitialRank() + rankAdd;

        return rank;
    }

    private final SponsorDefaults getSponsorDefaults() {
        return sponsorDefaults;
    }

    private final Iterable<String>
            getValidAffinities(final Collection<String> affinities) {
        return affinities.stream()
                .filter(affinity -> !affinity.equals("rank_increase"))
                .collect(Collectors.toSet());
    }

}
