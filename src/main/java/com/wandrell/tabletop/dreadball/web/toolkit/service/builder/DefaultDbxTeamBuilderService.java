
package com.wandrell.tabletop.dreadball.web.toolkit.service.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;

import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.availability.SponsorAffinityGroupAvailabilityRepository;

public final class DefaultDbxTeamBuilderService
        implements DbxTeamBuilderService {

    private final SponsorAffinityGroupAvailabilityRepository affinityAvasRepository;

    @Autowired
    public DefaultDbxTeamBuilderService(
            final SponsorAffinityGroupAvailabilityRepository repository) {
        super();

        affinityAvasRepository = checkNotNull(repository,
                "Received a null pointer as affinity availabilities repository");
    }

    @Override
    public final Iterable<? extends SponsorAffinityGroupAvailability>
            getSponsorAffinityGroups() {
        return getRepository().findAll();
    }

    private final SponsorAffinityGroupAvailabilityRepository getRepository() {
        return affinityAvasRepository;
    }

}
