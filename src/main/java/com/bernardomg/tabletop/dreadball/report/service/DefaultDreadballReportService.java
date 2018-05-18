
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
