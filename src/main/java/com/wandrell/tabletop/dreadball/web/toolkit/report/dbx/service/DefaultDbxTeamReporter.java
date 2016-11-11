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

package com.wandrell.tabletop.dreadball.web.toolkit.report.dbx.service;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.report.dbx.DbxTeamReporter;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public final class DefaultDbxTeamReporter implements DbxTeamReporter {

    public DefaultDbxTeamReporter() {
        super();
    }

    @Override
    public final JasperPrint getSponsorTeamReport(final SponsorTeam team) {
        final File reportFile;
        final JasperReport jasperReport;
        final JasperPrint jasperPrint;
        final Map<String, Object> parameters;

        // TODO: The file should be received as a configuration value
        try {
            reportFile = new ClassPathResource("/report/DbxTeam.jasper")
                    .getFile();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }

        if (!reportFile.exists()) {
            // TODO: Compile report
        }

        try {
            jasperReport = (JasperReport) JRLoader
                    .loadObjectFromFile(reportFile.getPath());
        } catch (final JRException e) {
            throw new RuntimeException(e);
        }

        parameters = new LinkedHashMap<>();

        try {
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
                    new JREmptyDataSource());
        } catch (final JRException e) {
            throw new RuntimeException(e);
        }

        return jasperPrint;
    }

}
