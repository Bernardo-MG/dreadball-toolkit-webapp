
package com.bernardomg.tabletop.dreadball.build.dbx.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardomg.tabletop.dreadball.build.dbx.assembler.AffinitiesSelectionAssembler;
import com.bernardomg.tabletop.dreadball.build.dbx.assembler.SponsorTeamAssembler;
import com.bernardomg.tabletop.dreadball.build.dbx.assembler.SponsorTeamSelectionAssembler;
import com.bernardomg.tabletop.dreadball.build.dbx.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.build.dbx.model.SponsorTeamAssets;
import com.bernardomg.tabletop.dreadball.build.dbx.model.SponsorTeamSelection;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityUnit;
import com.bernardomg.tabletop.dreadball.repository.unit.AffinityGroupRepository;
import com.bernardomg.tabletop.dreadball.repository.unit.AffinityUnitRepository;

@Service
public final class DefaultSponsorBuilderAssemblerService
        implements SponsorBuilderAssemblerService {

    private final AffinitiesSelectionAssembler  affAssembler;

    private final AffinityGroupRepository       affinityGroupRepository;

    /**
     * Affinity units repository.
     */
    private final AffinityUnitRepository        affinityUnitRepository;

    private final SponsorTeamAssembler          teamAssembler;

    private final SponsorTeamSelectionAssembler teamSelectionAssembler;

    @Autowired
    public DefaultSponsorBuilderAssemblerService(
            final SponsorTeamAssembler sponsorTeamAssembler,
            final SponsorTeamSelectionAssembler sponsorTeamSelectionAssembler,
            final AffinitiesSelectionAssembler affinitiesAssembler,
            final AffinityUnitRepository unitsRepository,
            final AffinityGroupRepository affinityRepository) {
        super();

        teamAssembler = checkNotNull(sponsorTeamAssembler,
                "Received a null pointer as team assembler");
        teamSelectionAssembler = checkNotNull(sponsorTeamSelectionAssembler,
                "Received a null pointer as team selection assembler");
        affAssembler = checkNotNull(affinitiesAssembler,
                "Received a null pointer as affinities selection assembler");
        affinityUnitRepository = checkNotNull(unitsRepository,
                "Received a null pointer as units repository");
        affinityGroupRepository = checkNotNull(affinityRepository,
                "Received a null pointer as affinities repository");
    }

    @Override
    public final SponsorAffinities
            assembleSponsorAffinities(final Iterable<String> affinities) {
        return getAffinitiesSelectionAssembler().assemble(affinities);
    }

    @Override
    public final SponsorTeamSelection assembleSponsorTeamSelection(
            final Collection<String> affinities, final Collection<String> units,
            final SponsorTeamAssets assets, final Integer baseRank) {
        final Iterable<AffinityUnit> affUnits;
        final Iterable<AffinityGroup> affs;
        final SponsorTeam team;
        // TODO: Validate

        affUnits = getUnits(units);
        affs = getAffinityGroups(affinities);

        team = getSponsorTeamAssembler().assemble(affs, affUnits, assets,
                baseRank);

        return getSponsorTeamSelectionAssembler().assemble(team);
    }

    private final AffinitiesSelectionAssembler
            getAffinitiesSelectionAssembler() {
        return affAssembler;
    }

    private final AffinityGroupRepository getAffinityGroupRepository() {
        return affinityGroupRepository;
    }

    private final Iterable<AffinityGroup>
            getAffinityGroups(final Collection<String> affinities) {
        final Collection<AffinityGroup> result;

        result = new ArrayList<>();
        result.addAll(getAffinityGroupRepository().findByNameIn(affinities));

        return result;
    }

    private final AffinityUnitRepository getAffinityUnitRepository() {
        return affinityUnitRepository;
    }

    private final SponsorTeamAssembler getSponsorTeamAssembler() {
        return teamAssembler;
    }

    private final SponsorTeamSelectionAssembler
            getSponsorTeamSelectionAssembler() {
        return teamSelectionAssembler;
    }

    private final Iterable<AffinityUnit>
            getUnits(final Collection<String> unitNames) {
        final Collection<? extends AffinityUnit> read;
        final Collection<AffinityUnit> units;
        final Map<String, ? extends AffinityUnit> readMap;

        if (unitNames.isEmpty()) {
            read = Collections.emptyList();
        } else {
            read = getAffinityUnitRepository().findByTemplateNameIn(unitNames);
        }

        readMap = read.stream().filter(Objects::nonNull).collect(Collectors
                .toMap(AffinityUnit::getTemplateName, Function.identity()));

        units = new ArrayList<>();
        for (final String name : unitNames) {
            units.add(readMap.get(name));
        }

        return units;
    }

}
