
package com.bernardomg.tabletop.dreadball.report;

import java.io.OutputStream;

import com.bernardomg.tabletop.dreadball.build.dbx.model.SponsorTeamSelection;

public interface DreadballReportBuilder {

    public void createPdf(final SponsorTeamSelection team,
            final OutputStream output);

}
