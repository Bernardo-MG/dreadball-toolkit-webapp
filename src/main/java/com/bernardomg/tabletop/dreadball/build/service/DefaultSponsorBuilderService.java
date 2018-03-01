
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

import com.bernardomg.tabletop.dreadball.calculator.SponsorTeamValorationCalculator;
import com.bernardomg.tabletop.dreadball.model.ImmutableOption;
import com.bernardomg.tabletop.dreadball.model.ImmutableOptionGroup;
import com.bernardomg.tabletop.dreadball.model.ImmutableSponsorAffinities;
import com.bernardomg.tabletop.dreadball.model.Option;
import com.bernardomg.tabletop.dreadball.model.OptionGroup;
import com.bernardomg.tabletop.dreadball.model.SponsorAffinities;
import com.bernardomg.tabletop.dreadball.model.SponsorTeamValidationSelection;
import com.bernardomg.tabletop.dreadball.model.availability.affinity.SponsorAffinityGroupAvailability;
import com.bernardomg.tabletop.dreadball.model.availability.asset.SponsorAssetsAvailability;
import com.bernardomg.tabletop.dreadball.model.faction.DefaultSponsor;
import com.bernardomg.tabletop.dreadball.model.persistence.availability.affinity.PersistentSponsorAffinityGroupAvailability;
import com.bernardomg.tabletop.dreadball.model.persistence.player.PersistentAffinityGroup;
import com.bernardomg.tabletop.dreadball.model.player.AffinityLevel;
import com.bernardomg.tabletop.dreadball.model.player.AffinityTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.DefaultTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.stats.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.bernardomg.tabletop.dreadball.model.team.calculator.CostCalculator;
import com.bernardomg.tabletop.dreadball.model.team.calculator.DefaultRankCostCalculator;
import com.bernardomg.tabletop.dreadball.repository.availability.SponsorAffinityGroupAvailabilityRepository;
import com.bernardomg.tabletop.dreadball.repository.unit.AffinityGroupRepository;
import com.bernardomg.tabletop.dreadball.repository.unit.AffinityTeamPlayerRepository;
import com.bernardomg.tabletop.dreadball.rules.DbxRules;
import com.bernardomg.tabletop.dreadball.rules.SponsorDefaults;
import com.google.common.collect.Lists;

@Service
public final class DefaultSponsorBuilderService
        implements SponsorBuilderService {

    private final AffinityGroupRepository                    affinityGroupRepository;

    private final AffinityTeamPlayerRepository               affinityTeamPlayerRepository;

    private final DbxRules                                   dbxRules;

    private final SponsorAssetsAvailability                  rankCosts;

    /**
     * Affinity groups repository.
     */
    private final SponsorAffinityGroupAvailabilityRepository sponsorAffinityGroupAvailabilityRepository;

    private final SponsorAssetsAvailability                  sponsorCosts;

    private final SponsorDefaults                            sponsorDefaults;

    @Autowired
    public DefaultSponsorBuilderService(
            final SponsorAffinityGroupAvailabilityRepository sponsorAffAvaRepository,
            final SponsorDefaults defaults,
            final AffinityTeamPlayerRepository affTeamPlayerRepository,
            final AffinityGroupRepository affGroupRepository,
            @Qualifier("SponsorRankCosts") final SponsorAssetsAvailability costsRank,
            @Qualifier("SponsorCosts") final SponsorAssetsAvailability costs,
            final DbxRules rules) {
        super();

        sponsorAffinityGroupAvailabilityRepository = checkNotNull(
                sponsorAffAvaRepository,
                "Received a null pointer as affinites availabilities repository");
        sponsorDefaults = checkNotNull(defaults,
                "Received a null pointer as Sponsor defaults service");
        affinityTeamPlayerRepository = checkNotNull(affTeamPlayerRepository,
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
    public final Iterable<? extends TeamPlayer> getTeamPlayerOptions(
            final Collection<? extends AffinityGroup> affinities,
            final Pageable pageReq) {
        final List<TeamPlayer> units;          // Available units
        final Page<? extends AffinityTeamPlayer> filtered; // Filtered units
        Integer cost; // TeamPlayer cost

        checkNotNull(affinities, "Received a null pointer as affinities");
        checkNotNull(pageReq, "Received a null pointer as pagination data");

        // Only units not hating any affinity are acquired
        filtered = getTeamPlayersNotHatingAffinities(affinities, pageReq);

        // The received units are adapted and configured
        units = new ArrayList<>();
        for (final AffinityTeamPlayer affTeamPlayer : filtered) {
            cost = getTeamPlayerCost(affTeamPlayer, affinities);
            units.add(generateTeamPlayer(affTeamPlayer, cost));
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
        final Iterable<AffinityTeamPlayer> affTeamPlayers;
        final Iterable<PersistentAffinityGroup> affs;
        // TODO: Validate

        affTeamPlayers = getTeamPlayers(selection.getTeamPlayers());
        affs = getAffinityGroupRepository()
                .findByNameIn(selection.getAffinities());

        return assemble(affs, affTeamPlayers, selection,
                selection.getBaseRank());
    }

    private final SponsorTeam assemble(
            final Iterable<? extends AffinityGroup> affinities,
            final Iterable<AffinityTeamPlayer> units,
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
        sponsorTeam.setNastySurpriseCards(assets.getNastySurpriseCards());
        sponsorTeam.setWagers(assets.getWagers());

        return sponsorTeam;
    }

    private final TeamPlayer generateTeamPlayer(
            final AffinityTeamPlayer affTeamPlayer, final Integer cost) {
        final DefaultTeamPlayer unit;

        // TODO: Use a new constructor including the name
        unit = new DefaultTeamPlayer(affTeamPlayer.getTemplateName(), cost,
                affTeamPlayer.getRole(), affTeamPlayer.getAttributes(),
                affTeamPlayer.getAbilities(), affTeamPlayer.getMvp(),
                affTeamPlayer.getGiant());
        unit.setName(affTeamPlayer.getName());

        return unit;
    }

    private final AffinityGroupRepository getAffinityGroupRepository() {
        return affinityGroupRepository;
    }

    private final AffinityTeamPlayerRepository
            getAffinityTeamPlayerRepository() {
        return affinityTeamPlayerRepository;
    }

    private final DbxRules getDbxRules() {
        return dbxRules;
    }

    private final CostCalculator<SponsorTeam> getRankCostCalculator() {
        return new DefaultRankCostCalculator(
                getSponsorRankCosts().getCoachingDieCost(),
                getSponsorRankCosts().getNastySurpriseCardCost(),
                getSponsorRankCosts().getSpecialMoveCardCost(),
                getSponsorRankCosts().getCheerleaderCost(),
                getSponsorRankCosts().getWagerCost(),
                getSponsorRankCosts().getMediBotCost());
    }

    private final SponsorAffinityGroupAvailabilityRepository
            getSponsorAffinityGroupAvailabilityRepository() {
        return sponsorAffinityGroupAvailabilityRepository;
    }

    private final SponsorAssetsAvailability getSponsorCosts() {
        return sponsorCosts;
    }

    private final SponsorDefaults getSponsorDefaults() {
        return sponsorDefaults;
    }

    private final SponsorAssetsAvailability getSponsorRankCosts() {
        return rankCosts;
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
    private final Integer getTeamPlayerCost(final AffinityTeamPlayer unit,
            final Iterable<? extends AffinityGroup> affinities) {
        final AffinityLevel affinityLevel;  // Affinity level relationship

        affinityLevel = getDbxRules().getAffinityLevel(unit, affinities);

        return getDbxRules().getTeamPlayerCost(affinityLevel, unit);
    }

    private final Iterable<AffinityTeamPlayer>
            getTeamPlayers(final Collection<String> unitNames) {
        final Collection<? extends AffinityTeamPlayer> read;
        final Collection<AffinityTeamPlayer> units;
        final Map<String, ? extends AffinityTeamPlayer> readMap;

        if (unitNames.isEmpty()) {
            read = Collections.emptyList();
        } else {
            read = getAffinityTeamPlayerRepository()
                    .findByTemplateNameIn(unitNames);
        }

        readMap = read.stream().filter(Objects::nonNull)
                .collect(Collectors.toMap(AffinityTeamPlayer::getTemplateName,
                        Function.identity()));

        units = unitNames.stream().filter((n) -> readMap.containsKey(n))
                .map((n) -> readMap.get(n)).collect(Collectors.toList());

        return units;
    }

    private final Page<? extends AffinityTeamPlayer>
            getTeamPlayersNotHatingAffinities(
                    final Iterable<? extends AffinityGroup> affinities,
                    final Pageable pageReq) {
        final Page<? extends AffinityTeamPlayer> filtered; // Filtered units
        final Collection<String> affNames;     // Affinity names
        final Collection<AffinityGroup> affs;     // Affinity names

        // The affinities names are acquired
        affs = new ArrayList<>();
        affinities.iterator().forEachRemaining(affs::add);
        affNames = affs.stream().map(a -> a.getName())
                .collect(Collectors.toList());

        if (affNames.isEmpty()) {
            // There are no affinities, there is no need to filter
            filtered = getAffinityTeamPlayerRepository().findAll(pageReq);
        } else {
            // Only units not hating any affinity are acquired
            filtered = getAffinityTeamPlayerRepository()
                    .findAllFilteredByHatedAffinities(affNames, pageReq);
        }

        return filtered;
    }

    private final CostCalculator<SponsorTeam> getTeamValorationCalculator() {
        return new SponsorTeamValorationCalculator(
                getSponsorCosts().getCoachingDieCost(),
                getSponsorCosts().getNastySurpriseCardCost(),
                getSponsorCosts().getSpecialMoveCardCost(),
                getSponsorCosts().getCheerleaderCost(),
                getSponsorCosts().getWagerCost(),
                getSponsorCosts().getMediBotCost());
    }

    private final void setPlayers(final SponsorTeam sponsorTeam,
            final Iterable<? extends AffinityGroup> affinities,
            final Iterable<AffinityTeamPlayer> units) {
        TeamPlayer unitSetUp;
        Integer cost;
        AffinityLevel affinityLevel; // Affinity level relationship

        for (final AffinityTeamPlayer unit : units) {
            affinityLevel = getDbxRules().getAffinityLevel(unit, affinities);
            cost = getDbxRules().getTeamPlayerCost(affinityLevel, unit);

            unitSetUp = new DefaultTeamPlayer(unit.getTemplateName(), cost,
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
