
package com.bernardomg.tabletop.dreadball.report;

import java.io.IOException;
import java.io.OutputStream;

import com.itextpdf.text.DocumentException;

public interface DreadballReportBuilder {

    public void createPdf(final OutputStream output)
            throws IOException, DocumentException;

}
