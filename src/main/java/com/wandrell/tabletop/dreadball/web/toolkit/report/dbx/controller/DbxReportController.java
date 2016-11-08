/**
 * Copyright 2016 the original author or authors
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

package com.wandrell.tabletop.dreadball.web.toolkit.report.dbx.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.report.dbx.DbxTeamReporter;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Controller
@RequestMapping("/builder/team/dbx")
public class DbxReportController {

    /**
     * Parameter name for the team.
     */
    private static final String   PARAM_TEAM = "team";

    private final DbxTeamReporter reportService;

    @Autowired
    public DbxReportController(final DbxTeamReporter service) {
        super();

        reportService = checkNotNull(service,
                "Received a null pointer as reports service");
    }

    @GetMapping(path = "/pdf")
    public final void getReport(
            @SessionAttribute(PARAM_TEAM) final SponsorTeam team, Model model,
            HttpServletRequest request, HttpServletResponse response)
            throws JRException, NamingException, SQLException, IOException {
        // Parameters as Map to be passed to Jasper
        HashMap<String, Object> hmParams = new HashMap<String, Object>();

        JasperReport jasperReport = getDbxTeamReporter()
                .getSponsorTeamReport(team);

        generateReportPDF(response, hmParams, jasperReport);
    }

    private final void generateReportPDF(final HttpServletResponse resp,
            final Map<String, Object> parameters,
            final JasperReport jasperReport)
            throws JRException, NamingException, SQLException, IOException {
        final ServletOutputStream ouputStream;
        final JasperPrint jasperPrint;

        jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
                new JREmptyDataSource());

        resp.setContentType("application/x-pdf");
        resp.setHeader("Content-disposition", "inline; filename=dbxTeam.pdf");

        ouputStream = resp.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, ouputStream);
    }

    private final DbxTeamReporter getDbxTeamReporter() {
        return reportService;
    }

}
