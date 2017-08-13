
package com.wandrell.tabletop.dreadball.build.dbx.model;

public interface SponsorTeamSelection {

    public Iterable<String> getAffinities();

    public Integer getBaseRank();

    public Integer getRank();

    public Integer getTeamValue();

    public Iterable<TeamPlayer> getUnits();

}
