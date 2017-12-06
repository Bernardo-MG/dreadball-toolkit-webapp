
package com.bernardomg.tabletop.dreadball.build.dbx.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bernardomg.tabletop.dreadball.build.dbx.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.build.dbx.model.SponsorTeamAssets;
import com.bernardomg.tabletop.dreadball.build.dbx.model.SponsorTeamSelection;
import com.bernardomg.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.unit.Unit;
import com.bernardomg.tabletop.dreadball.service.model.SponsorAffinityGroupAvailabilityService;
import com.bernardomg.tabletop.dreadball.service.model.SponsorUnitsService;

@Service
public final class DefaultSponsorBuilderService
        implements SponsorBuilderService {

    private final SponsorAffinityGroupAvailabilityService affinityGroupAvailabilityService;

    private final SponsorBuilderAssemblerService          assemblerService;

    private final SponsorUnitsService                     unitsService;

    public DefaultSponsorBuilderService(
            final SponsorBuilderAssemblerService sponsorBuilderAssemblerService,
            final SponsorUnitsService sponsorUnitsService,
            final SponsorAffinityGroupAvailabilityService sponsorAffinityGroupAvailabilityService) {
        super();

        assemblerService = checkNotNull(sponsorBuilderAssemblerService,
                "Received a null pointer as assembler service");
        unitsService = checkNotNull(sponsorUnitsService,
                "Received a null pointer as units service");
        affinityGroupAvailabilityService = checkNotNull(
                sponsorAffinityGroupAvailabilityService,
                "Received a null pointer as affinites availabilities service");
    }

    @Override
    public final Iterable<SponsorAffinityGroupAvailability>
            getAffinityGroupAvailabilities() {
        return getSponsorAffinityGroupAvailabilityService()
                .getAllSponsorAffinityGroupAvailabilities();
    }

    @Override
    public final Iterable<? extends Unit> getAffinityUnits(
            final Iterable<? extends AffinityGroup> affinities,
            final Pageable pageReq) {
        return getSponsorUnitsService().getAllAffinityUnits(affinities,
                pageReq);
    }

    @Override
    public final SponsorAffinities
            selectAffinities(final Collection<String> affinities) {
        return getSponsorBuilderAssemblerService()
                .assembleSponsorAffinities(affinities);
    }

    @Override
    public final SponsorTeamSelection selectTeam(
            final Collection<String> affinities, final Collection<String> units,
            final SponsorTeamAssets assets, final Integer baseRank) {
        return getSponsorBuilderAssemblerService().assembleSponsorTeamSelection(
                affinities, units, assets, baseRank);
    }

    private final SponsorAffinityGroupAvailabilityService
            getSponsorAffinityGroupAvailabilityService() {
        return affinityGroupAvailabilityService;
    }

    private final SponsorBuilderAssemblerService
            getSponsorBuilderAssemblerService() {
        return assemblerService;
    }

    private final SponsorUnitsService getSponsorUnitsService() {
        return unitsService;
    }

}
