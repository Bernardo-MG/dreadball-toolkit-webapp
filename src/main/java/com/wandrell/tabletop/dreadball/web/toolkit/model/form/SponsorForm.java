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

public final class SponsorForm {

    @NotEmpty
    private String affinityA;

    @NotEmpty
    private String affinityB;

    @NotEmpty
    private String affinityC;

    @NotEmpty
    private String affinityD;

    @NotEmpty
    private String affinityE;

    @NotEmpty
    private String sponsorName;

    public SponsorForm() {
        super();
    }

    public final String getAffinityA() {
        return affinityA;
    }

    public final String getAffinityB() {
        return affinityB;
    }

    public final String getAffinityC() {
        return affinityC;
    }

    public final String getAffinityD() {
        return affinityD;
    }

    public final String getAffinityE() {
        return affinityE;
    }

    public final String getSponsorName() {
        return sponsorName;
    }

    public final void setAffinityA(final String affinityA) {
        this.affinityA = affinityA;
    }

    public final void setAffinityB(final String affinityB) {
        this.affinityB = affinityB;
    }

    public final void setAffinityC(final String affinityC) {
        this.affinityC = affinityC;
    }

    public final void setAffinityD(final String affinityD) {
        this.affinityD = affinityD;
    }

    public final void setAffinityE(final String affinityE) {
        this.affinityE = affinityE;
    }

    public final void setSponsorName(final String sponsorName) {
        this.sponsorName = sponsorName;
    }

}
