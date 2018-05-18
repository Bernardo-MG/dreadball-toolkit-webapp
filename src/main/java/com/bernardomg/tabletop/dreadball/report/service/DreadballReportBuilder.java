
package com.bernardomg.tabletop.dreadball.report.service;

import java.io.IOException;
import java.io.OutputStream;

import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.itextpdf.text.DocumentException;

/**
 * Report builder.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public interface DreadballReportBuilder {

    /**
     * Creates a PDF report and stores it in the output.
     * 
     * @param team
     *            team for the report
     * @param output
     *            output where the report will be stored
     * 
     * @throws IOException
     *             if there was an I/O error
     * @throws DocumentException
     *             if there was an error generating the document
     */
    public void createPdf(final SponsorTeam team, final OutputStream output)
            throws IOException, DocumentException;

}
