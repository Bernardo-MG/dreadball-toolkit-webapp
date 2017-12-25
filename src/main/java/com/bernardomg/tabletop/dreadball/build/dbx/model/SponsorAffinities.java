
package com.bernardomg.tabletop.dreadball.build.dbx.model;

public interface SponsorAffinities {

    public Iterable<String> getAffinities();

    public Integer getBaseRank();

    /**
     * TODO: This value seems to be the same as the base rank, remove it
     * 
     * @return
     */
    public Integer getRank();

}
