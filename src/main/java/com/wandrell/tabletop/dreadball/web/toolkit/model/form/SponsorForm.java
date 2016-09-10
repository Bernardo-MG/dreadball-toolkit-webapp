/**
 * Copyright 2016 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.wandrell.tabletop.dreadball.web.toolkit.model.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Form data for the Sponsor edition view.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class SponsorForm {

    /**
     * Affinity A.
     */
    @NotEmpty
    private String affinityA;

    /**
     * Affinity B.
     */
    @NotEmpty
    private String affinityB;

    /**
     * Affinity C.
     */
    @NotEmpty
    private String affinityC;

    /**
     * Affinity D.
     */
    @NotEmpty
    private String affinityD;

    /**
     * Affinity E.
     */
    @NotEmpty
    private String affinityE;

    /**
     * Sponsor name.
     */
    @NotEmpty
    private String sponsorName;

    /**
     * Default constructor.
     */
    public SponsorForm() {
        super();
    }

    /**
     * Returns the affinity A.
     * 
     * @return the affinity A
     */
    public final String getAffinityA() {
        return affinityA;
    }

    /**
     * Returns the affinity B.
     * 
     * @return the affinity B
     */
    public final String getAffinityB() {
        return affinityB;
    }

    /**
     * Returns the affinity C.
     * 
     * @return the affinity C
     */
    public final String getAffinityC() {
        return affinityC;
    }

    /**
     * Returns the affinity D.
     * 
     * @return the affinity D
     */
    public final String getAffinityD() {
        return affinityD;
    }

    /**
     * Returns the affinity E.
     * 
     * @return the affinity E
     */
    public final String getAffinityE() {
        return affinityE;
    }

    /**
     * Returns the Sponsor name.
     * 
     * @return the Sponsor name
     */
    public final String getSponsorName() {
        return sponsorName;
    }

    /**
     * Sets the affinity A.
     * 
     * @param affinity
     *            the affinity A
     */
    public final void setAffinityA(final String affinity) {
        this.affinityA = affinity;
    }

    /**
     * Sets the affinity B.
     * 
     * @param affinity
     *            the affinity B
     */
    public final void setAffinityB(final String affinity) {
        this.affinityB = affinity;
    }

    /**
     * Sets the affinity C.
     * 
     * @param affinity
     *            the affinity C
     */
    public final void setAffinityC(final String affinity) {
        this.affinityC = affinity;
    }

    /**
     * Sets the affinity D.
     * 
     * @param affinity
     *            the affinity D
     */
    public final void setAffinityD(final String affinity) {
        this.affinityD = affinity;
    }

    /**
     * Sets the affinity E.
     * 
     * @param affinity
     *            the affinity E
     */
    public final void setAffinityE(final String affinity) {
        this.affinityE = affinity;
    }

    /**
     * Sets the Sponsor name.
     * 
     * @param name
     *            the Sponsor name
     */
    public final void setSponsorName(final String name) {
        this.sponsorName = name;
    }

}
