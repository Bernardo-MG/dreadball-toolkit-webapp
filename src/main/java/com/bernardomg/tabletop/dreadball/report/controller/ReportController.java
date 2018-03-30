/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2017 the original author or authors.
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.bernardomg.tabletop.dreadball.report.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bernardomg.tabletop.dreadball.build.service.SponsorBuilderService;
import com.bernardomg.tabletop.dreadball.model.DefaultSponsorTeamSelection;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.bernardomg.tabletop.dreadball.report.service.DreadballReportBuilder;

/**
 * Controller for generating reports.
 * <p>
 * This serves as an adapter between the UI and the services layer.
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

    private final DreadballReportBuilder reportBuilder;

    private final SponsorBuilderService  sponsorBuilderService;

    @Autowired
    public ReportController(final DreadballReportBuilder builder,
            final SponsorBuilderService builderService) {
        super();

        reportBuilder = checkNotNull(builder,
                "Received a null pointer as report builder");
        sponsorBuilderService = checkNotNull(builderService,
                "Received a null pointer as sponsor builder service");
    }

    @GetMapping
    public final void getPdfReport(final Model model,
            final HttpServletRequest request,
            final HttpServletResponse response,
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

        getReportBuilder().createPdf(team, output);
    }

    private final DreadballReportBuilder getReportBuilder() {
        return reportBuilder;
    }

    private final SponsorBuilderService getSponsorBuilderService() {
        return sponsorBuilderService;
    }

}
