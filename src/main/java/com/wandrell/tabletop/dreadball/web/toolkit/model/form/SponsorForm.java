package com.wandrell.tabletop.dreadball.web.toolkit.model.form;

import org.hibernate.validator.constraints.NotEmpty;

public final class SponsorForm {

	@NotEmpty
	private String sponsorName;

	public SponsorForm() {
		super();
	}

	public final String getSponsorName() {
		return sponsorName;
	}

	public final void setSponsorName(final String sponsorName) {
		this.sponsorName = sponsorName;
	}

}
