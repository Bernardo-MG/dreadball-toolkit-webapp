
package com.wandrell.tabletop.dreadball.web.toolkit.factory;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Value;

import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.RankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.DefaultUnit;
import com.wandrell.tabletop.dreadball.model.unit.Role;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.Attributes;
import com.wandrell.tabletop.dreadball.web.toolkit.model.form.SponsorForm;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityGroupRepository;

public class DefaultDbxModelFactory implements DbxModelFactory {

    /**
     * Affinity groups repository.
     */
    private final AffinityGroupRepository               affinitiesRepository;

    /**
     * Initial rank.
     */
    private final Integer                               initialRank;

    /**
     * Rank cost calculator.
     */
    private final RankCostCalculator                    rankCostCalculator;

    /**
     * Team valoration calculator.
     */
    private final TeamValorationCalculator<SponsorTeam> valorationCalculator;

    public DefaultDbxModelFactory(final AffinityGroupRepository affinitiesRepo,
            @Value("${sponsor.rank.initial}") final Integer rank,
            final TeamValorationCalculator<SponsorTeam> valorationCalc,
            final RankCostCalculator rankCalc) {
        super();

        affinitiesRepository = checkNotNull(affinitiesRepo,
                "Received a null pointer as affinities repository");

        initialRank = checkNotNull(rank,
                "Received a null pointer as initial rank");

        valorationCalculator = checkNotNull(valorationCalc,
                "Received a null pointer as valoration calculator");
        rankCostCalculator = checkNotNull(rankCalc,
                "Received a null pointer as rank cost calculator");
    }

    @Override
    public final Sponsor getSponsor(final SponsorForm form) {
        final Sponsor sponsor;               // Created sponsor
        final Collection<String> affinities; // Affinities list

        checkNotNull(form, "Received a null pointer as sponsor form");

        sponsor = new DefaultSponsor();

        sponsor.setName(form.getSponsorName());

        sponsor.setRank(getInitialRank());

        // TODO: The affinities should come as a list
        // Loads affinities
        affinities = new LinkedList<String>();
        affinities.add(form.getAffinityA());
        affinities.add(form.getAffinityB());
        affinities.add(form.getAffinityC());
        affinities.add(form.getAffinityD());
        affinities.add(form.getAffinityE());

        // Searchs for rank increase tags
        while (affinities.contains("rank")) {
            sponsor.setRank(sponsor.getRank() + 1);
            affinities.remove("rank");
        }

        // Creates the affinities
        for (final String affinity : affinities) {
            sponsor.addAffinityGroup(
                    getAffinityGroupRepository().findByName(affinity));
        }

        return sponsor;
    }

    @Override
    public final SponsorTeam getSponsorTeam(final Sponsor sponsor) {
        final SponsorTeam team; // Created team

        checkNotNull(sponsor, "Received a null pointer as sponsor");

        team = new DefaultSponsorTeam(sponsor,
                getSponsorTeamValorationCalculator(), getRankCostCalculator());

        return team;
    }

    @Override
    public final Unit getUnit(final String nameTemplate, final Integer cost,
            final Role role, final Attributes attributes,
            final Collection<Ability> abilities, final Boolean mvp,
            final Boolean giant) {
        return new DefaultUnit(nameTemplate, cost, role, attributes, abilities,
                mvp, giant);
    }

    /**
     * Returns the affinity groups repository.
     * 
     * @return the affinity groups repository
     */
    private final AffinityGroupRepository getAffinityGroupRepository() {
        return affinitiesRepository;
    }

    private final Integer getInitialRank() {
        return initialRank;
    }

    /**
     * Returns the rank cost calculator.
     * 
     * @return the rank cost calculator
     */
    private final RankCostCalculator getRankCostCalculator() {
        return rankCostCalculator;
    }

    /**
     * Returns the team valoration calculator.
     * 
     * @return the team valoration calculator
     */
    private final TeamValorationCalculator<SponsorTeam>
            getSponsorTeamValorationCalculator() {
        return valorationCalculator;
    }

}
