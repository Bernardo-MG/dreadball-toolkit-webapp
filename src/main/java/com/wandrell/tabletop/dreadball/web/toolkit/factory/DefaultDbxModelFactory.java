
package com.wandrell.tabletop.dreadball.web.toolkit.factory;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.LinkedList;

import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.RankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.web.toolkit.model.form.SponsorForm;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityGroupRepository;

public class DefaultDbxModelFactory implements DbxModelFactory {

    /**
     * Affinity groups repository.
     */
    private final AffinityGroupRepository               affinitiesRepository;

    /**
     * Rank cost calculator.
     */
    private final RankCostCalculator                    rankCostCalculator;

    /**
     * Team valoration calculator.
     */
    private final TeamValorationCalculator<SponsorTeam> valorationCalculator;

    /**
     * DBX values service.
     */
    private final DbxValuesFactory                      valuesFactory;

    public DefaultDbxModelFactory(final DbxValuesFactory valuesFact,
            final AffinityGroupRepository affinitiesRepo,
            final TeamValorationCalculator<SponsorTeam> valorationCalc,
            final RankCostCalculator rankCalc) {
        super();

        valuesFactory = checkNotNull(valuesFact,
                "Received a null pointer as values factory");

        affinitiesRepository = checkNotNull(affinitiesRepo,
                "Received a null pointer as affinities repository");

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

        sponsor.setRank(getDbxValuesFactory().getInitialRank());

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

    /**
     * Returns the affinity groups repository.
     * 
     * @return the affinity groups repository
     */
    private final AffinityGroupRepository getAffinityGroupRepository() {
        return affinitiesRepository;
    }

    /**
     * Returns the DBX values service.
     * 
     * @return the DBX values service
     */
    private final DbxValuesFactory getDbxValuesFactory() {
        return valuesFactory;
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
