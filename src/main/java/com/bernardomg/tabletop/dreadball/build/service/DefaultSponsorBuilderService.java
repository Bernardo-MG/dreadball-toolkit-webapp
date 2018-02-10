
package com.bernardomg.tabletop.dreadball.build.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bernardomg.tabletop.dreadball.model.DefaultSponsorAffinities;
import com.bernardomg.tabletop.dreadball.model.ImmutableOption;
import com.bernardomg.tabletop.dreadball.model.ImmutableOptionGroup;
import com.bernardomg.tabletop.dreadball.model.Option;
import com.bernardomg.tabletop.dreadball.model.OptionGroup;
import com.bernardomg.tabletop.dreadball.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.model.SponsorTeamAssets;
import com.bernardomg.tabletop.dreadball.model.SponsorTeamSelection;
import com.bernardomg.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.bernardomg.tabletop.dreadball.model.service.SponsorAffinityGroupAvailabilityService;
import com.bernardomg.tabletop.dreadball.model.service.SponsorBuilderAssemblerService;
import com.bernardomg.tabletop.dreadball.model.service.SponsorUnitsService;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.unit.Unit;
import com.bernardomg.tabletop.dreadball.rules.SponsorDefaults;

@Service
public final class DefaultSponsorBuilderService
        implements SponsorBuilderService {

    private final SponsorAffinityGroupAvailabilityService affinityGroupAvailabilityService;

    private final SponsorBuilderAssemblerService          assemblerService;

    private final SponsorDefaults                         sponsorDefaults;

    private final SponsorUnitsService                     unitsService;

    public DefaultSponsorBuilderService(
            final SponsorBuilderAssemblerService sponsorBuilderAssemblerService,
            final SponsorUnitsService sponsorUnitsService,
            final SponsorAffinityGroupAvailabilityService sponsorAffinityGroupAvailabilityService,
            final SponsorDefaults defaults) {
        super();

        assemblerService = checkNotNull(sponsorBuilderAssemblerService,
                "Received a null pointer as assembler service");
        unitsService = checkNotNull(sponsorUnitsService,
                "Received a null pointer as units service");
        affinityGroupAvailabilityService = checkNotNull(
                sponsorAffinityGroupAvailabilityService,
                "Received a null pointer as affinites availabilities service");
        sponsorDefaults = checkNotNull(defaults,
                "Received a null pointer as Sponsor defaults service");
    }

    @Override
    public final Collection<OptionGroup> getAffinityOptions() {
        final Iterable<SponsorAffinityGroupAvailability> avas;

        // Acquires all the availabilities
        avas = getSponsorAffinityGroupAvailabilityService()
                .getAllSponsorAffinityGroupAvailabilities();

        // The availabilities are transformed into options
        return toOptionGroups(avas);
    }

    @Override
    public final Iterable<? extends Unit> getUnitOptions(
            final Iterable<? extends AffinityGroup> affinities,
            final Pageable pageReq) {
        return getSponsorUnitsService().getAllAffinityUnits(affinities,
                pageReq);
    }

    @Override
    public final SponsorAffinities
            validateSponsorAffinities(final Iterable<String> affinities) {
        final Integer totalRank;
        final Iterable<String> valid;
        final Integer rank;

        // TODO: Validate
        // TODO: Ensure these are existing affinities

        checkNotNull(affinities, "Received a null pointer as affinities");

        rank = getRank(affinities);
        valid = getFilterOutRankOption(affinities);

        totalRank = getSponsorDefaults().getInitialRank() + rank;

        return new DefaultSponsorAffinities(valid, totalRank);

    }

    @Override
    public final SponsorTeamSelection validateTeam(
            final Collection<String> affinities, final Collection<String> units,
            final SponsorTeamAssets assets, final Integer baseRank) {
        return getSponsorBuilderAssemblerService().assembleSponsorTeamSelection(
                affinities, units, assets, baseRank);
    }

    private final Iterable<String>
            getFilterOutRankOption(final Iterable<String> affinities) {
        return StreamSupport.stream(affinities.spliterator(), false)
                .filter(affinity -> !affinity.equals("rank_increase"))
                .collect(Collectors.toSet());
    }

    private final Integer getRank(final Iterable<String> affinities) {
        // TODO: This doesn't look like a good solution
        return StreamSupport.stream(affinities.spliterator(), false)
                .filter(affinity -> affinity.equals("rank_increase"))
                .collect(Collectors.toList()).size();
    }

    private final SponsorAffinityGroupAvailabilityService
            getSponsorAffinityGroupAvailabilityService() {
        return affinityGroupAvailabilityService;
    }

    private final SponsorBuilderAssemblerService
            getSponsorBuilderAssemblerService() {
        return assemblerService;
    }

    private final SponsorDefaults getSponsorDefaults() {
        return sponsorDefaults;
    }

    private final SponsorUnitsService getSponsorUnitsService() {
        return unitsService;
    }

    /**
     * Returns an {@link Option} created from the received
     * {@link AffinityGroup}.
     * 
     * @param affinity
     *            affinity to transform
     * @return transformed affinity
     */
    private final Option toOption(final AffinityGroup affinity) {
        return new ImmutableOption(affinity.getName(), affinity.getName());
    }

    /**
     * Returns an {@link OptionGroup} created from the received
     * {@link SponsorAffinityGroupAvailability}.
     * <p>
     * The affinity groups contained in the
     * {@code SponsorAffinityGroupAvailability} are transformed into options by
     * using {@link #toOption(AffinityGroup) toOption}.
     * 
     * @param ava
     *            availability to transform
     * @return transformed availability
     */
    private final OptionGroup
            toOptionGroup(final SponsorAffinityGroupAvailability ava) {
        final Collection<Option> options;

        // Creates options from the affinities
        options = StreamSupport
                .stream(ava.getAffinityGroups().spliterator(), false)
                .map(this::toOption).collect(Collectors.toList());

        // If the availability allows increasing the rank this is added as an
        // option
        if (ava.isIncludingRankIncrease()) {
            // TODO: Use a constant
            options.add(new ImmutableOption("rank_increase", "rank_increase"));
        }

        return new ImmutableOptionGroup(ava.getName(), options);
    };

    /**
     * Returns a collection of {@link OptionGroup} created from the received
     * collection of {@link SponsorAffinityGroupAvailability}.
     * <p>
     * Each {@code SponsorAffinityGroupAvailability} is transformed by using
     * {@link #toOptionGroup(SponsorAffinityGroupAvailability) toOptionGroup}.
     * 
     * @param avas
     *            availabilities to transform
     * @return transformed availabilities
     */
    private final Collection<OptionGroup> toOptionGroups(
            final Iterable<SponsorAffinityGroupAvailability> avas) {
        return StreamSupport.stream(avas.spliterator(), false)
                .map(this::toOptionGroup).collect(Collectors.toList());
    };

}
