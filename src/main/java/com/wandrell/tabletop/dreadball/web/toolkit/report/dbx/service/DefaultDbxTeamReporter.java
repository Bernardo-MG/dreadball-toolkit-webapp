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

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;

import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.report.dbx.DbxTeamReporter;

@Service
public final class DefaultDbxTeamReporter implements DbxTeamReporter {

    public DefaultDbxTeamReporter() {
        super();
    }

    @Override
    public final JasperReportsMultiFormatView
            getSponsorTeamReport(final SponsorTeam team) {
        final JasperReportsMultiFormatView view;

        view = new JasperReportsMultiFormatView();
        view.setUrl("classpath:report/dbxTeam.jasper");
        view.setReportDataKey("datasource");

        return view;
    }

}
