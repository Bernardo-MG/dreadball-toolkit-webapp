
package com.bernardomg.tabletop.dreadball.build.dbx.model;

public interface SponsorTeamSelection {

    public Iterable<String> getAffinities();

    public SponsorTeamAssets getAssets();

    public Integer getBaseRank();

    public Integer getRank();

    public Integer getTeamValue();

    public Iterable<TeamPlayer> getUnits();

}
