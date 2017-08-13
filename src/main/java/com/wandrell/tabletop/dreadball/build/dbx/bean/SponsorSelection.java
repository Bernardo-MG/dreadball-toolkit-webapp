
package com.wandrell.tabletop.dreadball.build.dbx.bean;

public interface SponsorSelection {

    public Iterable<String> getAffinities();

    public Integer getBaseRank();

    public Integer getRank();

    public Integer getTeamValue();

    public Iterable<TeamPlayer> getUnits();

}
