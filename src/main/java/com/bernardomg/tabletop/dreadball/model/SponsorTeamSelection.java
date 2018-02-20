
package com.bernardomg.tabletop.dreadball.model;

import java.util.Collection;

public interface SponsorTeamSelection {

    public Collection<String> getAffinities();

    public SponsorTeamAssets getAssets();

    public Integer getBaseRank();

    public Integer getRank();

    public Integer getTeamValue();

    public Collection<TeamPlayer> getUnits();

}
