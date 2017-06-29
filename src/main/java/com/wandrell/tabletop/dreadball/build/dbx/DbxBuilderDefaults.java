
package com.wandrell.tabletop.dreadball.build.dbx;

public interface DbxBuilderDefaults {

    public Integer getCheerleaderCost();

    public Integer getCheerleaderRank();

    public Integer getDieCost();

    public Integer getDieRank();

    /**
     * Returns the initial rank.
     * 
     * @return the initial rank
     */
    public Integer getInitialRank();

    public Integer getMedibotCost();

    public Integer getMedibotRank();

    public Integer getMoveCost();

    public Integer getMoveRank();

    public Integer getSabotageCost();

    public Integer getSabotageRank();

    public Integer getWagerCost();

    public Integer getWagerRank();

}
