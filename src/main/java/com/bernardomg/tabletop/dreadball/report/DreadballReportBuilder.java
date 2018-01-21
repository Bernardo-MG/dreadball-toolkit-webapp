
package com.bernardomg.tabletop.dreadball.report;

import java.io.OutputStream;

public interface DreadballReportBuilder {

    public void createPdf(final OutputStream output);

}
