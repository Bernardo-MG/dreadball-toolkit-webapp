
package com.bernardomg.tabletop.dreadball.build.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bernardomg.tabletop.dreadball.model.ImmutableOption;
import com.bernardomg.tabletop.dreadball.model.ImmutableOptionGroup;
import com.bernardomg.tabletop.dreadball.model.ImmutableSponsorAffinities;
import com.bernardomg.tabletop.dreadball.model.Option;
import com.bernardomg.tabletop.dreadball.model.OptionGroup;
import com.bernardomg.tabletop.dreadball.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.model.SponsorTeamValidationSelection;
import com.bernardomg.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.bernardomg.tabletop.dreadball.model.faction.DefaultSponsor;
import com.bernardomg.tabletop.dreadball.model.persistence.availability.unit.PersistentSponsorAffinityGroupAvailability;
import com.bernardomg.tabletop.dreadball.model.persistence.unit.PersistentAffinityGroup;
import com.bernardomg.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.bernardomg.tabletop.dreadball.model.team.calculator.CostCalculator;
import com.bernardomg.tabletop.dreadball.model.team.calculator.DefaultRankCostCalculator;
import com.bernardomg.tabletop.dreadball.model.team.calculator.SponsorTeamValorationCalculator;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityLevel;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityUnit;
import com.bernardomg.tabletop.dreadball.model.unit.DefaultUnit;
import com.bernardomg.tabletop.dreadball.model.unit.Unit;
import com.bernardomg.tabletop.dreadball.repository.availability.SponsorAffinityGroupAvailabilityRepository;
import com.bernardomg.tabletop.dreadball.repository.unit.AffinityGroupRepository;
import com.bernardomg.tabletop.dreadball.repository.unit.AffinityUnitRepository;
import com.bernardomg.tabletop.dreadball.rules.DbxRules;
import com.bernardomg.tabletop.dreadball.rules.SponsorCosts;
import com.bernardomg.tabletop.dreadball.rules.SponsorDefaults;
import com.google.common.collect.Lists;

@Service
public final class DefaultSponsorBuilderService
        implements SponsorBuilderService {

    private final AffinityGroupRepository                    affinityGroupRepository;

    private final AffinityUnitRepository                     affinityUnitRepository;

    private final DbxRules                                   dbxRules;

    private final SponsorCosts                               rankCosts;

    /**
     * Affinity groups repository.
     */
    private final SponsorAffinityGroupAvailabilityRepository sponsorAffinityGroupAvailabilityRepository;

    private final SponsorCosts                               sponsorCosts;

    private final SponsorDefaults                            sponsorDefaults;

    @Autowired
    public DefaultSponsorBuilderService(
            final SponsorAffinityGroupAvailabilityRepository sponsorAffAvaRepository,
            final SponsorDefaults defaults,
            final AffinityUnitRepository affUnitRepository,
            final AffinityGroupRepository affGroupRepository,
            @Qualifier("SponsorRankCosts") final SponsorCosts costsRank,
            @Qualifier("SponsorCosts") final SponsorCosts costs,
            final DbxRules rules) {
        super();

        sponsorAffinityGroupAvailabilityRepository = checkNotNull(
                sponsorAffAvaRepository,
                "Received a null pointer as affinites availabilities repository");
        sponsorDefaults = checkNotNull(defaults,
                "Received a null pointer as Sponsor defaults service");
        affinityUnitRepository = checkNotNull(affUnitRepository,
                "Received a null pointer as affinity units repository");
        affinityGroupRepository = checkNotNull(affGroupRepository,
                "Received a null pointer as affinity units repository");
        rankCosts = checkNotNull(costsRank,
                "Received a null pointer as rank costs");
        sponsorCosts = checkNotNull(costs, "Received a null pointer as costs");
        dbxRules = checkNotNull(rules, "Received a null pointer as rules");
    }

    @Override
    public final Collection<OptionGroup> getAffinityOptions() {
        final Iterable<PersistentSponsorAffinityGroupAvailability> avas;

        // Read all the availabilities
        avas = getSponsorAffinityGroupAvailabilityRepository().findAll();

        // The availabilities are transformed into options
        return StreamSupport.stream(avas.spliterator(), false)
                .map(this::toOptionGroup).collect(Collectors.toList());
    }

    @Override
    public final Iterable<? extends Unit> getUnitOptions(
            final Collection<? extends AffinityGroup> affinities,
            final Pageable pageReq) {
        final List<Unit> units;          // Available units
        final Page<? extends AffinityUnit> filtered; // Filtered units
        Integer cost; // Unit cost

        checkNotNull(affinities, "Received a null pointer as affinities");
        checkNotNull(pageReq, "Received a null pointer as pagination data");

        // Only units not hating any affinity are acquired
        filtered = getUnitsNotHatingAffinities(affinities, pageReq);

        // The received units are adapted and configured
        units = new ArrayList<>();
        for (final AffinityUnit affUnit : filtered) {
            cost = getUnitCost(affUnit, affinities);
            units.add(generateUnit(affUnit, cost));
        }

        return new PageImpl<>(units, pageReq, filtered.getTotalElements());
    }

    @Override
    public final SponsorAffinities

            validateSponsorAffinities(final Collection<String> affinities) {
        final Integer totalRank;
        final Iterable<String> valid;
        final Integer rank;

        // TODO: Validate
        // TODO: Ensure these are existing affinities

        checkNotNull(affinities, "Received a null pointer as affinities");

        // TODO: ¿Receive an object which takes care of these operations?

        // TODO: Use a constant
        // Counts how many times the rank option appears
        rank = (int) affinities.stream()
                .filter(affinity -> affinity.equals("rank_increase")).count();

        // TODO: Use a constant
        // Filters out the rank increase option
        valid = affinities.stream()
                .filter(affinity -> !affinity.equals("rank_increase"))
                .collect(Collectors.toSet());

        totalRank = getSponsorDefaults().getInitialRank() + rank;

        return new ImmutableSponsorAffinities(valid, totalRank);

    }

    @Override
    public final SponsorTeam
            validateTeam(final SponsorTeamValidationSelection selection) {
        final Iterable<AffinityUnit> affUnits;
        final Iterable<PersistentAffinityGroup> affs;
        // TODO: Validate

        affUnits = getUnits(selection.getUnits());
        affs = getAffinityGroupRepository()
                .findByNameIn(selection.getAffinities());

        return assemble(affs, affUnits, selection, selection.getBaseRank());
    }

    private final SponsorTeam assemble(
            final Iterable<? extends AffinityGroup> affinities,
            final Iterable<AffinityUnit> units,
            final SponsorTeamValidationSelection assets, final Integer rank) {
        final SponsorTeam sponsorTeam;

        sponsorTeam = new DefaultSponsorTeam(new DefaultSponsor(),
                getTeamValorationCalculator(), getRankCostCalculator());

        sponsorTeam.getSponsor().setRank(rank);
        sponsorTeam.getSponsor()
                .setAffinityGroups(Lists.newArrayList(affinities));

        setPlayers(sponsorTeam, affinities, units);

        sponsorTeam.setCheerleaders(assets.getCheerleaders());
        sponsorTeam.setCoachingDice(assets.getCoachingDice());
        sponsorTeam.setMediBots(assets.getMediBots());
        sponsorTeam.setSpecialMoveCards(assets.getSpecialMoveCards());
        sponsorTeam.setSabotageCards(assets.getNastySurpriseCards());
        sponsorTeam.setWagers(assets.getWagers());

        return sponsorTeam;
    }

    private final Unit generateUnit(final AffinityUnit affUnit,
            final Integer cost) {
        final DefaultUnit unit;

        // TODO: Use a new constructor including the name
        unit = new DefaultUnit(affUnit.getTemplateName(), cost,
                affUnit.getRole(), affUnit.getAttributes(),
                affUnit.getAbilities(), affUnit.getMvp(), affUnit.getGiant());
        unit.setName(affUnit.getName());

        return unit;
    }

    private final AffinityGroupRepository getAffinityGroupRepository() {
        return affinityGroupRepository;
    }

    private final AffinityUnitRepository getAffinityUnitRepository() {
        return affinityUnitRepository;
    }

    private final DbxRules getDbxRules() {
        return dbxRules;
    }

    private final CostCalculator<SponsorTeam> getRankCostCalculator() {
        return new DefaultRankCostCalculator(getSponsorRankCosts().getDieCost(),
                getSponsorRankCosts().getSabotageCost(),
                getSponsorRankCosts().getSpecialMoveCost(),
                getSponsorRankCosts().getCheerleaderCost(),
                getSponsorRankCosts().getWagerCost(),
                getSponsorRankCosts().getMediBotCost());
    }

    private final SponsorAffinityGroupAvailabilityRepository
            getSponsorAffinityGroupAvailabilityRepository() {
        return sponsorAffinityGroupAvailabilityRepository;
    }

    private final SponsorCosts getSponsorCosts() {
        return sponsorCosts;
    }

    private final SponsorDefaults getSponsorDefaults() {
        return sponsorDefaults;
    }

    private final SponsorCosts getSponsorRankCosts() {
        return rankCosts;
    }

    private final CostCalculator<SponsorTeam> getTeamValorationCalculator() {
        return new SponsorTeamValorationCalculator(
                getSponsorCosts().getDieCost(),
                getSponsorCosts().getSabotageCost(),
                getSponsorCosts().getSpecialMoveCost(),
                getSponsorCosts().getCheerleaderCost(),
                getSponsorCosts().getWagerCost(),
                getSponsorCosts().getMediBotCost());
    }

    /**
     * Returns the actual cost for a unit for a sponsor.
     * 
     * @param unit
     *            unit to find the cost for
     * @param affinities
     *            sponsor affinities
     * @return the cost of the unit for the sponsor
     */
    private final Integer getUnitCost(final AffinityUnit unit,
            final Iterable<? extends AffinityGroup> affinities) {
        final AffinityLevel affinityLevel;  // Affinity level relationship

        affinityLevel = getDbxRules().getAffinityLevel(unit, affinities);

        return getDbxRules().getUnitCost(affinityLevel, unit);
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

        units = unitNames.stream().filter((n) -> readMap.containsKey(n))
                .map((n) -> readMap.get(n)).collect(Collectors.toList());

        return units;
    }

    private final Page<? extends AffinityUnit> getUnitsNotHatingAffinities(
            final Iterable<? extends AffinityGroup> affinities,
            final Pageable pageReq) {
        final Page<? extends AffinityUnit> filtered; // Filtered units
        final Collection<String> affNames;     // Affinity names
        final Collection<AffinityGroup> affs;     // Affinity names

        // The affinities names are acquired
        affs = new ArrayList<>();
        affinities.iterator().forEachRemaining(affs::add);
        affNames = affs.stream().map(a -> a.getName())
                .collect(Collectors.toList());

        if (affNames.isEmpty()) {
            // There are no affinities, there is no need to filter
            filtered = getAffinityUnitRepository().findAll(pageReq);
        } else {
            // Only units not hating any affinity are acquired
            filtered = getAffinityUnitRepository()
                    .findAllFilteredByHatedAffinities(affNames, pageReq);
        }

        return filtered;
    }

    private final void setPlayers(final SponsorTeam sponsorTeam,
            final Iterable<? extends AffinityGroup> affinities,
            final Iterable<AffinityUnit> units) {
        Unit unitSetUp;
        Integer cost;
        AffinityLevel affinityLevel; // Affinity level relationship

        for (final AffinityUnit unit : units) {
            affinityLevel = getDbxRules().getAffinityLevel(unit, affinities);
            cost = getDbxRules().getUnitCost(affinityLevel, unit);

            unitSetUp = new DefaultUnit(unit.getTemplateName(), cost,
                    unit.getRole(), unit.getAttributes(), unit.getAbilities(),
                    unit.getMvp(), unit.getGiant());

            sponsorTeam.addPlayer(unitSetUp);
        }
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
        options = ava.getAffinityGroups().stream().map(this::toOption)
                .collect(Collectors.toList());

        // If the availability allows increasing the rank this is added as an
        // option
        if (ava.isIncludingRankIncrease()) {
            // TODO: Use a constant
            options.add(new ImmutableOption("rank_increase", "rank_increase"));
        }

        return new ImmutableOptionGroup(ava.getName(), options);
    };

}
