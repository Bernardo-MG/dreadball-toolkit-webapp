
package com.bernardomg.tabletop.dreadball.model;

/**
 * Sponsor affinities and their rank.
 * <p>
 * This represents the data resulting from processing a selection of affinities,
 * when creating a Sponsor.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public interface SponsorAffinities {

    /**
     * Returns the affinities.
     * 
     * @return the affinities
     */
    public Iterable<String> getAffinities();

    /**
     * Returns the rank.
     * 
     * @return the rank
     */
    public Integer getRank();

}
