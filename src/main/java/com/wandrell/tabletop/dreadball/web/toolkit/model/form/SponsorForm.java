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
     * Retuns the affinity A.
     * 
     * @return the affinity A
     */
    public final String getAffinityA() {
        return affinityA;
    }

    /**
     * Retuns the affinity B.
     * 
     * @return the affinity B
     */
    public final String getAffinityB() {
        return affinityB;
    }

    /**
     * Retuns the affinity C.
     * 
     * @return the affinity C
     */
    public final String getAffinityC() {
        return affinityC;
    }

    /**
     * Retuns the affinity D.
     * 
     * @return the affinity D
     */
    public final String getAffinityD() {
        return affinityD;
    }

    /**
     * Retuns the affinity E.
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
     * Sets the affinity A
     * 
     * @param affinityA
     *            the affinity A
     */
    public final void setAffinityA(final String affinityA) {
        this.affinityA = affinityA;
    }

    /**
     * Sets the affinity B
     * 
     * @param affinityB
     *            the affinity B
     */
    public final void setAffinityB(final String affinityB) {
        this.affinityB = affinityB;
    }

    /**
     * Sets the affinity C
     * 
     * @param affinityC
     *            the affinity C
     */
    public final void setAffinityC(final String affinityC) {
        this.affinityC = affinityC;
    }

    /**
     * Sets the affinity D
     * 
     * @param affinityD
     *            the affinity D
     */
    public final void setAffinityD(final String affinityD) {
        this.affinityD = affinityD;
    }

    /**
     * Sets the affinity E
     * 
     * @param affinityE
     *            the affinity E
     */
    public final void setAffinityE(final String affinityE) {
        this.affinityE = affinityE;
    }

    /**
     * Sets the Sponsor name
     * 
     * @param sponsorName
     *            the Sponsor name
     */
    public final void setSponsorName(final String sponsorName) {
        this.sponsorName = sponsorName;
    }

}
