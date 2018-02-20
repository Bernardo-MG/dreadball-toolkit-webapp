
package com.bernardomg.tabletop.dreadball.model;

import java.util.Collection;

public final class DefaultSponsorTeamSelection implements SponsorTeamSelection {

    private Collection<String>     affinities;

    private SponsorTeamAssets      assets;

    private Integer                baseRank;

    private Integer                rank;

    private Integer                teamValue;

    private Collection<TeamPlayer> units;

    public DefaultSponsorTeamSelection() {
        super();
    }

    @Override
    public final Collection<String> getAffinities() {
        return affinities;
    }

    @Override
    public final SponsorTeamAssets getAssets() {
        return assets;
    }

    @Override
    public final Integer getBaseRank() {
        return baseRank;
    }

    @Override
    public final Integer getRank() {
        return rank;
    }

    @Override
    public final Integer getTeamValue() {
        return teamValue;
    }

    @Override
    public final Collection<TeamPlayer> getUnits() {
        return units;
    }

    public void setAffinities(final Collection<String> affinities) {
        this.affinities = affinities;
    }

    public void setAssets(final SponsorTeamAssets assets) {
        this.assets = assets;
    }

    public void setBaseRank(final Integer baseRank) {
        this.baseRank = baseRank;
    }

    public void setRank(final Integer rank) {
        this.rank = rank;
    }

    public void setTeamValue(final Integer teamValue) {
        this.teamValue = teamValue;
    }

    public void setUnits(final Collection<TeamPlayer> units) {
        this.units = units;
    }

}
