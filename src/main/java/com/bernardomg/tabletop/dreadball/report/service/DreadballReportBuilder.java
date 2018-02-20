
package com.bernardomg.tabletop.dreadball.report.service;

import java.io.OutputStream;

import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;

public interface DreadballReportBuilder {

    public void createPdf(final SponsorTeam team, final OutputStream output);

}
