
package com.bernardomg.tabletop.dreadball.report.service;

import java.io.OutputStream;

import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;

/**
 * Report service.
 * <p>
 * Takes care of setting up and creating reports.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public interface DreadballReportService {

    /**
     * Creates a PDF report and stores it in the output.
     * 
     * @param team
     *            team for the report
     * @param output
     *            output where the report will be stored
     */
    public void createPdf(final SponsorTeam team, final OutputStream output);

}
