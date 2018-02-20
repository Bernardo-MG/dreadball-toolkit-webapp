
package com.bernardomg.tabletop.dreadball.build.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bernardomg.tabletop.dreadball.model.DefaultSponsorAffinities;
import com.bernardomg.tabletop.dreadball.model.DefaultSponsorTeamValidationSelection;
import com.bernardomg.tabletop.dreadball.model.ImmutableOption;
import com.bernardomg.tabletop.dreadball.model.ImmutableOptionGroup;
import com.bernardomg.tabletop.dreadball.model.Option;
import com.bernardomg.tabletop.dreadball.model.OptionGroup;
import com.bernardomg.tabletop.dreadball.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.model.SponsorTeamAssets;
import com.bernardomg.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.bernardomg.tabletop.dreadball.model.faction.DefaultSponsor;
import com.bernardomg.tabletop.dreadball.model.service.SponsorAffinityGroupAvailabilityService;
import com.bernardomg.tabletop.dreadball.model.service.SponsorUnitsService;
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
import com.bernardomg.tabletop.dreadball.repository.unit.AffinityGroupRepository;
import com.bernardomg.tabletop.dreadball.repository.unit.AffinityUnitRepository;
import com.bernardomg.tabletop.dreadball.rules.DbxRules;
import com.bernardomg.tabletop.dreadball.rules.SponsorCosts;
import com.bernardomg.tabletop.dreadball.rules.SponsorDefaults;
import com.google.common.collect.Lists;

@Service
public final class DefaultSponsorBuilderService
        implements SponsorBuilderService {

    private final SponsorAffinityGroupAvailabilityService affinityGroupAvailabilityService;

    private final AffinityGroupRepository                 affinityGroupRepository;

    private final AffinityUnitRepository                  affinityUnitRepository;

    private final DbxRules                                dbxRules;

    private final SponsorCosts                            rankCosts;

    private final SponsorCosts                            sponsorCosts;

    private final SponsorDefaults                         sponsorDefaults;

    private final SponsorUnitsService                     unitsService;

    @Autowired
    public DefaultSponsorBuilderService(
            final SponsorUnitsService sponsorUnitsService,
            final SponsorAffinityGroupAvailabilityService sponsorAffinityGroupAvailabilityService,
            final SponsorDefaults defaults,
            final AffinityUnitRepository affUnitRepository,
            final AffinityGroupRepository affGroupRepository,
            @Qualifier("SponsorRankCosts") final SponsorCosts costsRank,
            @Qualifier("SponsorCosts") final SponsorCosts costs,
            final DbxRules rules) {
        super();

        unitsService = checkNotNull(sponsorUnitsService,
                "Received a null pointer as units service");
        affinityGroupAvailabilityService = checkNotNull(
                sponsorAffinityGroupAvailabilityService,
                "Received a null pointer as affinites availabilities service");
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
        final Iterable<SponsorAffinityGroupAvailability> avas;

        // Acquires all the availabilities
        avas = getSponsorAffinityGroupAvailabilityService()
                .getAllSponsorAffinityGroupAvailabilities();

        // The availabilities are transformed into options
        return toOptionGroups(avas);
    }

    @Override
    public final Iterable<? extends Unit> getUnitOptions(
            final Collection<? extends AffinityGroup> affinities,
            final Pageable pageReq) {
        return getSponsorUnitsService().getAllAffinityUnits(affinities,
                pageReq);
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

        rank = getRank(affinities);
        valid = getFilterOutRankOption(affinities);

        totalRank = getSponsorDefaults().getInitialRank() + rank;

        return new DefaultSponsorAffinities(valid, totalRank);

    }

    @Override
    public final SponsorTeam validateTeam(
            final DefaultSponsorTeamValidationSelection selection) {
        final Iterable<AffinityUnit> affUnits;
        final Iterable<AffinityGroup> affs;
        // TODO: Validate

        affUnits = getUnits(selection.getUnits());
        affs = getAffinityGroups(selection.getAffinities());

        return assemble(affs, affUnits, selection, selection.getBaseRank());
    }

    private final SponsorTeam assemble(final Iterable<AffinityGroup> affinities,
            final Iterable<AffinityUnit> units, final SponsorTeamAssets assets,
            final Integer rank) {
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

    private final AffinityGroupRepository getAffinityGroupRepository() {
        return affinityGroupRepository;
    }

    private final Iterable<AffinityGroup>
            getAffinityGroups(final Collection<String> affinities) {
        final Collection<AffinityGroup> result;
        final Collection<String> affinitiesFiltered;

        affinitiesFiltered = affinities.stream().collect(Collectors.toSet());

        result = new ArrayList<>();
        result.addAll(
                getAffinityGroupRepository().findByNameIn(affinitiesFiltered));

        return result;
    }

    private final AffinityUnitRepository getAffinityUnitRepository() {
        return affinityUnitRepository;
    }

    private final DbxRules getDbxRules() {
        return dbxRules;
    }

    private final Collection<String>
            getFilterOutRankOption(final Collection<String> affinities) {
        return affinities.stream()
                .filter(affinity -> !affinity.equals("rank_increase"))
                .collect(Collectors.toSet());
    }

    private final Integer getRank(final Collection<String> affinities) {
        return (int) affinities.stream()
                .filter(affinity -> affinity.equals("rank_increase")).count();
    }

    private final CostCalculator<SponsorTeam> getRankCostCalculator() {
        return new DefaultRankCostCalculator(getSponsorRankCosts().getDieCost(),
                getSponsorRankCosts().getSabotageCost(),
                getSponsorRankCosts().getSpecialMoveCost(),
                getSponsorRankCosts().getCheerleaderCost(),
                getSponsorRankCosts().getWagerCost(),
                getSponsorRankCosts().getMediBotCost());
    }

    private final SponsorAffinityGroupAvailabilityService
            getSponsorAffinityGroupAvailabilityService() {
        return affinityGroupAvailabilityService;
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

    private final SponsorUnitsService getSponsorUnitsService() {
        return unitsService;
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

    private final void setPlayers(final SponsorTeam sponsorTeam,
            final Iterable<AffinityGroup> affinities,
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
