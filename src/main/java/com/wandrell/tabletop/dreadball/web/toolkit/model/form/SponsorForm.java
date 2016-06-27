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
