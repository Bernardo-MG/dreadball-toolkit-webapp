
package com.bernardomg.tabletop.dreadball.report.service;

import java.io.OutputStream;

import com.bernardomg.tabletop.dreadball.model.SponsorTeamSelection;

public interface DreadballReportBuilder {

    public void createPdf(final SponsorTeamSelection team,
            final OutputStream output);

}
