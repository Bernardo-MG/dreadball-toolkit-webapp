
package com.wandrell.tabletop.dreadball.build.dbx.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.build.dbx.bean.DefaultSponsorAffinities;
import com.wandrell.tabletop.dreadball.build.dbx.bean.SponsorAffinities;
import com.wandrell.tabletop.dreadball.build.dbx.rules.SponsorDefaults;

@Service
public class DefaultAffinitiesSelectionProcessor
        implements AffinitiesSelectionProcessor {

    private final SponsorDefaults sponsorDefaults;

    @Autowired
    public DefaultAffinitiesSelectionProcessor(final SponsorDefaults defaults) {
        super();

        sponsorDefaults = checkNotNull(defaults,
                "Received a null pointer as Sponsor defaults service");
    }

    @Override
    public SponsorAffinities
            selectAffinities(final Collection<String> affinities) {
        final Integer rankAdd;
        final Integer rank;
        final Iterable<String> filtered;

        checkNotNull(affinities, "Received a null pointer as affinities");

        rankAdd = affinities.stream()
                .filter(affinity -> affinity.equals("rank_increase"))
                .collect(Collectors.toList()).size();
        filtered = affinities.stream()
                .filter(affinity -> !affinity.equals("rank_increase"))
                .collect(Collectors.toList());

        rank = getSponsorDefaults().getInitialRank() + rankAdd;

        return new DefaultSponsorAffinities(filtered, rank, rank);
    }

    private final SponsorDefaults getSponsorDefaults() {
        return sponsorDefaults;
    }

}
