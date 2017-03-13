
package com.wandrell.tabletop.dreadball.web.toolkit.codex.service;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.codex.SponsorAffinityGroupAvailabilityCodex;
import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.availability.SponsorAffinityGroupAvailabilityRepository;

@Service("sponsorAffinityGroupAvailabilityCodex")
public class DefaultSponsorAffinityGroupAvailabilityCodex
        implements SponsorAffinityGroupAvailabilityCodex {

    /**
     * Affinity groups repository.
     */
    @Autowired
    private SponsorAffinityGroupAvailabilityRepository sponsorAffinityGroupAvailabilityRepository;

    /**
     * Constructs a service with the specified arguments.
     */
    public DefaultSponsorAffinityGroupAvailabilityCodex() {
        super();
    }

    @Override
    public final Iterable<SponsorAffinityGroupAvailability>
            getAllSponsorAffinityGroupAvailabilities() {
        final Collection<SponsorAffinityGroupAvailability> groups;

        // TODO: There may be a better way to do this
        groups = new LinkedList<SponsorAffinityGroupAvailability>();
        for (final SponsorAffinityGroupAvailability group : getSponsorAffinityGroupAvailabilityRepository()
                .findAll()) {
            groups.add(group);
        }

        return groups;
    }

    private SponsorAffinityGroupAvailabilityRepository
            getSponsorAffinityGroupAvailabilityRepository() {
        return sponsorAffinityGroupAvailabilityRepository;
    }

}
