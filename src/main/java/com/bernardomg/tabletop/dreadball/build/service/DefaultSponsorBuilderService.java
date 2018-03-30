
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
import com.bernardomg.tabletop.dreadball.model.SponsorTeamSelection;
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
import com.bernardomg.tabletop.dreadball.repository.player.AffinityGroupRepository;
import com.bernardomg.tabletop.dreadball.repository.player.AffinityTeamPlayerRepository;
import com.bernardomg.tabletop.dreadball.rules.DbxRules;
import com.bernardomg.tabletop.dreadball.rules.SponsorDefaults;
import com.google.common.collect.Lists;

/**
 * Default implementation of the Sponsor builder service.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
@Service
public final class DefaultSponsorBuilderService
        implements SponsorBuilderService {

    /**
     * Affinity groups repository.
     */
    private final AffinityGroupRepository                    affinityGroupRepository;

    /**
     * Affinity team players repository.
     */
    private final AffinityTeamPlayerRepository               affinityTeamPlayerRepository;

    /**
     * DBX ruleset.
     */
    private final DbxRules                                   dbxRules;

    /**
     * Assets rank costs.
     */
    private final SponsorAssetsAvailability                  rankCosts;

    /**
     * Affinity groups availabilities repository.
     */
    private final SponsorAffinityGroupAvailabilityRepository sponsorAffinityGroupAvailabilityRepository;

    /**
     * Assets costs.
     */
    private final SponsorAssetsAvailability                  sponsorCosts;

    /**
     * Sponsor default values.
     */
    private final SponsorDefaults                            sponsorDefaults;

    /**
     * Constructs a service.
     * 
     * @param sponsorAffAvaRepository
     *            affinity availabilities repository
     * @param defaults
     *            Sponsor default values
     * @param affTeamPlayerRepository
     *            affinity team players repository
     * @param affGroupRepository
     *            affinity groups repository
     * @param costsRank
     *            assets rank costs
     * @param costs
     *            assets costs
     * @param rules
     *            DBX ruleset
     */
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
                "Received a null pointer as affinity players repository");
        affinityGroupRepository = checkNotNull(affGroupRepository,
                "Received a null pointer as affinity players repository");
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
        final List<TeamPlayer> players;          // Available players
        final Page<? extends AffinityTeamPlayer> filtered; // Filtered players
        Integer cost; // TeamPlayer cost

        checkNotNull(affinities, "Received a null pointer as affinities");
        checkNotNull(pageReq, "Received a null pointer as pagination data");

        // Only players not hating any affinity are acquired
        filtered = readTeamPlayersNotHatingAffinities(affinities, pageReq);

        // The received players are adapted and configured
        players = new ArrayList<>();
        for (final AffinityTeamPlayer affTeamPlayer : filtered) {
            cost = calculateTeamPlayerCost(affTeamPlayer, affinities);
            players.add(assembleTeamPlayer(affTeamPlayer, cost));
        }

        return new PageImpl<>(players, pageReq, filtered.getTotalElements());
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
            validateTeam(final SponsorTeamSelection selection) {
        final Iterable<AffinityTeamPlayer> affTeamPlayers;
        final Iterable<PersistentAffinityGroup> affs;
        // TODO: Validate

        affTeamPlayers = assembleTeamPlayers(selection.getTeamPlayers());
        affs = getAffinityGroupRepository()
                .findByNameIn(selection.getAffinities());

        return assembleSponsorTeam(affs, affTeamPlayers, selection,
                selection.getBaseRank());
    }

    /**
     * Creates a {@link SponsorTeam} from the received arguments.
     * 
     * @param affinities
     *            Sponsor affinity groups
     * @param players
     *            team players
     * @param assets
     *            team assets
     * @param rank
     *            Sponsor rank
     * @return a {@code SponsorTeam} created from the arguments
     */
    private final SponsorTeam assembleSponsorTeam(
            final Iterable<? extends AffinityGroup> affinities,
            final Iterable<AffinityTeamPlayer> players,
            final SponsorTeamSelection assets, final Integer rank) {
        final SponsorTeam sponsorTeam;

        sponsorTeam = new DefaultSponsorTeam(new DefaultSponsor(),
                createTeamValorationCalculator(), createRankCostCalculator());

        sponsorTeam.getSponsor().setRank(rank);
        sponsorTeam.getSponsor()
                .setAffinityGroups(Lists.newArrayList(affinities));

        setPlayers(sponsorTeam, affinities, players);

        sponsorTeam.setCheerleaders(assets.getCheerleaders());
        sponsorTeam.setCoachingDice(assets.getCoachingDice());
        sponsorTeam.setMediBots(assets.getMediBots());
        sponsorTeam.setSpecialMoveCards(assets.getSpecialMoveCards());
        sponsorTeam.setNastySurpriseCards(assets.getNastySurpriseCards());
        sponsorTeam.setWagers(assets.getWagers());

        return sponsorTeam;
    }

    /**
     * Creates a {@link TeamPlayer} from the received arguments.
     * 
     * @param affTeamPlayer
     *            player entity
     * @param cost
     *            player cost
     * @return a {@code TeamPlayer} created from the received arguments
     */
    private final TeamPlayer assembleTeamPlayer(
            final AffinityTeamPlayer affTeamPlayer, final Integer cost) {
        final DefaultTeamPlayer player;

        // TODO: Use a new constructor including the name
        player = new DefaultTeamPlayer(affTeamPlayer.getTemplateName(), cost,
                affTeamPlayer.getRole(), affTeamPlayer.getAttributes(),
                affTeamPlayer.getAbilities(), affTeamPlayer.getMvp(),
                affTeamPlayer.getGiant());
        player.setName(affTeamPlayer.getName());

        return player;
    }

    /**
     * Returns the players for the received names.
     * 
     * @param playerNames
     *            names of the players to find
     * @return the players for the received names
     */
    private final Iterable<AffinityTeamPlayer>
            assembleTeamPlayers(final Collection<String> playerNames) {
        final Collection<? extends AffinityTeamPlayer> read;
        final Collection<AffinityTeamPlayer> players;
        final Map<String, ? extends AffinityTeamPlayer> readMap;

        if (playerNames.isEmpty()) {
            read = Collections.emptyList();
        } else {
            read = getAffinityTeamPlayerRepository()
                    .findByTemplateNameIn(playerNames);
        }

        readMap = read.stream().filter(Objects::nonNull)
                .collect(Collectors.toMap(AffinityTeamPlayer::getTemplateName,
                        Function.identity()));

        players = playerNames.stream().filter((n) -> readMap.containsKey(n))
                .map((n) -> readMap.get(n)).collect(Collectors.toList());

        return players;
    }

    /**
     * Returns the actual cost for Sponsor's player.
     * 
     * @param player
     *            player to find the cost for
     * @param affinities
     *            sponsor affinities
     * @return the cost of the player for the sponsor
     */
    private final Integer calculateTeamPlayerCost(
            final AffinityTeamPlayer player,
            final Iterable<? extends AffinityGroup> affinities) {
        final AffinityLevel affinityLevel;  // Affinity level relationship

        affinityLevel = getDbxRules().getAffinityLevel(player, affinities);

        return getDbxRules().getTeamPlayerCost(affinityLevel, player);
    }

    /**
     * Returns a new {@link CostCalculator} for calculating asset rank costs.
     * 
     * @return a new {@code CostCalculator} for asset rank costs
     */
    private final CostCalculator<SponsorTeam> createRankCostCalculator() {
        return new DefaultRankCostCalculator(
                getSponsorRankCosts().getCoachingDieCost(),
                getSponsorRankCosts().getNastySurpriseCardCost(),
                getSponsorRankCosts().getSpecialMoveCardCost(),
                getSponsorRankCosts().getCheerleaderCost(),
                getSponsorRankCosts().getWagerCost(),
                getSponsorRankCosts().getMediBotCost());
    }

    /**
     * Returns a new {@link CostCalculator} for calculating asset costs.
     * 
     * @return a new {@code CostCalculator} for asset costs
     */
    private final CostCalculator<SponsorTeam> createTeamValorationCalculator() {
        return new SponsorTeamValorationCalculator(
                getSponsorCosts().getCoachingDieCost(),
                getSponsorCosts().getNastySurpriseCardCost(),
                getSponsorCosts().getSpecialMoveCardCost(),
                getSponsorCosts().getCheerleaderCost(),
                getSponsorCosts().getWagerCost(),
                getSponsorCosts().getMediBotCost());
    }

    /**
     * Returns the affinity groups repository.
     * 
     * @return the affinity groups repository
     */
    private final AffinityGroupRepository getAffinityGroupRepository() {
        return affinityGroupRepository;
    }

    /**
     * Returns the affinity players repository.
     * 
     * @return the affinity players repository
     */
    private final AffinityTeamPlayerRepository
            getAffinityTeamPlayerRepository() {
        return affinityTeamPlayerRepository;
    }

    /**
     * Returns the DBX ruleset.
     * 
     * @return the DBX ruleset
     */
    private final DbxRules getDbxRules() {
        return dbxRules;
    }

    /**
     * Returns the affinity groups availabilities repository.
     * 
     * @return the affinity groups availabilities repository
     */
    private final SponsorAffinityGroupAvailabilityRepository
            getSponsorAffinityGroupAvailabilityRepository() {
        return sponsorAffinityGroupAvailabilityRepository;
    }

    /**
     * Returns the assets costs.
     * 
     * @return the assets costs
     */
    private final SponsorAssetsAvailability getSponsorCosts() {
        return sponsorCosts;
    }

    /**
     * Returns the Sponsor default values.
     * 
     * @return the Sponsor default values
     */
    private final SponsorDefaults getSponsorDefaults() {
        return sponsorDefaults;
    }

    /**
     * Returns the assets rank costs.
     * 
     * @return the assets rank costs
     */
    private final SponsorAssetsAvailability getSponsorRankCosts() {
        return rankCosts;
    }

    /**
     * Returns all the players which don't hate the received affinities.
     * 
     * @param affinities
     *            required affinities
     * @param pageReq
     *            pagination data
     * @return all the players which don't hate the received affinities
     */
    private final Page<? extends AffinityTeamPlayer>
            readTeamPlayersNotHatingAffinities(
                    final Iterable<? extends AffinityGroup> affinities,
                    final Pageable pageReq) {
        final Page<? extends AffinityTeamPlayer> filtered; // Filtered players
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
            // Only players not hating any affinity are acquired
            filtered = getAffinityTeamPlayerRepository()
                    .findAllFilteredByHatedAffinities(affNames, pageReq);
        }

        return filtered;
    }

    /**
     * Sets the received players into the received team.
     * 
     * @param sponsorTeam
     *            team into which to add the players
     * @param affinities
     *            Sponsor affinities
     * @param players
     *            players to add
     */
    private final void setPlayers(final SponsorTeam sponsorTeam,
            final Iterable<? extends AffinityGroup> affinities,
            final Iterable<AffinityTeamPlayer> players) {
        TeamPlayer playerSetUp;
        Integer cost;
        AffinityLevel affinityLevel; // Affinity level relationship

        for (final AffinityTeamPlayer player : players) {
            affinityLevel = getDbxRules().getAffinityLevel(player, affinities);
            cost = getDbxRules().getTeamPlayerCost(affinityLevel, player);

            playerSetUp = new DefaultTeamPlayer(player.getTemplateName(), cost,
                    player.getRole(), player.getAttributes(),
                    player.getAbilities(), player.getMvp(), player.getGiant());

            sponsorTeam.addPlayer(playerSetUp);
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
    }

}
