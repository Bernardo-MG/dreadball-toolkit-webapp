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

package com.bernardomg.tabletop.dreadball.report.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.springframework.stereotype.Service;

import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.itextpdf.text.DocumentException;

/**
 * Default implementation of the report service.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
@Service("dreadballReportService")
public final class DefaultDreadballReportService
        implements DreadballReportService {

    /**
     * Report builder.
     */
    private final DreadballReportBuilder builder;

    /**
     * Default constructor.
     */
    public DefaultDreadballReportService() {
        super();
        final ResourceBundle playersMessages;
        final ResourceBundle affinitiesMessages;
        final ResourceBundle messages;

        // TODO: Get resource bundles from Spring?
        messages = ResourceBundle.getBundle("messages/report");
        affinitiesMessages = ResourceBundle.getBundle("messages/affinities");
        playersMessages = ResourceBundle.getBundle("messages/playerNames");

        builder = new DefaultDreadballReportBuilder(affinitiesMessages,
                playersMessages, messages);
    }

    @Override
    public final void createPdf(final SponsorTeam team,
            final OutputStream output) {
        try {
            builder.createPdf(team, output);
        } catch (final IOException | DocumentException e) {
            throw new RuntimeException(e);
        }
    }

}
