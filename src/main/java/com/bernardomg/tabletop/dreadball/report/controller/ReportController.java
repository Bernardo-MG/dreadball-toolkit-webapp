/**
 * Copyright 2018 the original author or authors
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

package com.bernardomg.tabletop.dreadball.report.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bernardomg.tabletop.dreadball.build.service.SponsorBuilderService;
import com.bernardomg.tabletop.dreadball.model.DefaultSponsorTeamSelection;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.bernardomg.tabletop.dreadball.report.service.DreadballReportService;

/**
 * Controller for generating reports.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
@Controller
@RequestMapping("/rest/builder/report")
public class ReportController {

    /**
     * Default report file name.
     */
    private static final String          FILENAME = "EntityReport";

    /**
     * Report service.
     */
    private final DreadballReportService dreadballReportService;

    /**
     * Sponsor builder service.
     */
    private final SponsorBuilderService  sponsorBuilderService;

    /**
     * Constructs a controller.
     * 
     * @param reportService
     *            report service
     * @param builderService
     *            Sponsor builder service
     */
    @Autowired
    public ReportController(final DreadballReportService reportService,
            final SponsorBuilderService builderService) {
        super();

        dreadballReportService = checkNotNull(reportService,
                "Received a null pointer as service builder");
        sponsorBuilderService = checkNotNull(builderService,
                "Received a null pointer as sponsor builder service");
    }

    /**
     * Adds a PDF report to the response.
     * 
     * @param response
     *            response where the report will be added
     * @param selection
     *            team selection for the report
     */
    @GetMapping
    public final void getPdfReport(final HttpServletResponse response,
            final DefaultSponsorTeamSelection selection) {
        final SponsorTeam team;
        final OutputStream output;

        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader("Content-disposition",
                String.format("inline; filename=%s.pdf", FILENAME));

        // TODO: Merge with the PDF creation
        // TODO: Try to receive an object instead of creating one here
        team = getSponsorBuilderService().validateTeam(selection);

        try {
            output = response.getOutputStream();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }

        getDreadballReportService().createPdf(team, output);
    }

    /**
     * Returns the report service.
     * 
     * @return the report service
     */
    private final DreadballReportService getDreadballReportService() {
        return dreadballReportService;
    }

    /**
     * Returns the Sponsor builder service.
     * 
     * @return the Sponsor builder service
     */
    private final SponsorBuilderService getSponsorBuilderService() {
        return sponsorBuilderService;
    }

}
