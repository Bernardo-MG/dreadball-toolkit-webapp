
package com.bernardomg.tabletop.dreadball.report.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ResourceBundle;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.google.common.collect.Iterables;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

/**
 * Default implementation of the report builder.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
@Service("dreadballReportBuilder")
public class DreadballReportBuilderImpl implements DreadballReportBuilder {

    private final Font           chapterFont;

    private final ResourceBundle messages;

    private final ResourceBundle affinitiesMessages;

    private final Font           paragraphFont;

    /**
     * Constructs a report builder.
     */
    public DreadballReportBuilderImpl() {
        super();

        chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 16,
                Font.BOLDITALIC);
        paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12,
                Font.NORMAL);

        messages = ResourceBundle.getBundle("messages/report");
        affinitiesMessages = ResourceBundle.getBundle("messages/affinities");
    }

    @Override
    public final void createPdf(final SponsorTeam team,
            final OutputStream output) {
        try {
            create(team, output);
        } catch (final IOException | DocumentException e) {
            e.printStackTrace();
        }
    }

    private final void create(final SponsorTeam team, final OutputStream output)
            throws IOException, DocumentException {
        final Document document;
        final Paragraph general;
        final Paragraph assets;
        final Paragraph players;
        final Paragraph affinities;
        final Paragraph copyright;
        final Paragraph header;
        final Chunk linebreak;

        document = new Document();
        PdfWriter.getInstance(document, output);
        document.open();

        header = getHeader();
        general = getGeneralParagraph(team);
        assets = getAssetsParagraph(team);
        players = getPlayersParagraph(team);
        affinities = getAffinitiesParagraph(team);
        copyright = getCopyright();

        linebreak = new Chunk(new DottedLineSeparator());

        document.add(header);
        document.add(linebreak);
        document.add(general);
        document.add(assets);
        document.add(affinities);
        document.add(players);
        document.add(copyright);
        document.close();
    }

    private final Paragraph getAffinitiesParagraph(final SponsorTeam team) {
        final Paragraph paragraph;
        final PdfPTable table;
        final PdfPTable tableAdditional;

        paragraph = new Paragraph();

        paragraph.add(new Paragraph(" ", paragraphFont));

        table = new PdfPTable(1);
        paragraph.add(table);

        // Adds headers
        Stream.of(messages.getString("report.affinity"))
                .forEach(columnTitle -> {
                    final PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });

        team.getSponsor().getAffinityGroups().stream().forEach((affinity) -> {
            table.addCell(affinitiesMessages.getString(affinity.getName()));
        });

        if (!Iterables.isEmpty(team.getAdditionalAffinityGroups())) {
            tableAdditional = new PdfPTable(1);
            paragraph.add(tableAdditional);

            // Adds headers
            Stream.of("additional_affinity").forEach(columnTitle -> {
                final PdfPCell header = new PdfPCell();
                header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                header.setBorderWidth(2);
                header.setPhrase(new Phrase(columnTitle));
                tableAdditional.addCell(header);
            });

            StreamSupport
                    .stream(team.getAdditionalAffinityGroups().spliterator(),
                            false)
                    .forEach((affinity) -> {
                        tableAdditional.addCell(affinitiesMessages
                                .getString(affinity.getName()));
                    });
        }

        return paragraph;
    }

    private final Paragraph getAssetsParagraph(final SponsorTeam team) {
        final Paragraph paragraph;
        final PdfPTable table;

        paragraph = new Paragraph();

        paragraph.add(new Paragraph(" ", paragraphFont));

        table = new PdfPTable(2);
        paragraph.add(table);

        // Adds headers
        Stream.of(messages.getString("report.asset"),
                messages.getString("report.value")).forEach(columnTitle -> {
                    final PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });

        table.addCell(messages.getString("report.cheerleaders"));
        table.addCell(String.valueOf(team.getCheerleaders()));

        table.addCell(messages.getString("report.coachingDice"));
        table.addCell(String.valueOf(team.getCoachingDice()));

        table.addCell(messages.getString("report.medibots"));
        table.addCell(String.valueOf(team.getMediBots()));

        table.addCell(messages.getString("report.nastySupriseCards"));
        table.addCell(String.valueOf(team.getNastySurpriseCards()));

        table.addCell(messages.getString("report.specialMoveCards"));
        table.addCell(String.valueOf(team.getSpecialMoveCards()));

        table.addCell(messages.getString("report.wagers"));
        table.addCell(String.valueOf(team.getWagers()));

        return paragraph;
    }

    private final Paragraph getCopyright() {
        final Paragraph paragraph;

        paragraph = new Paragraph();

        paragraph.add(new Paragraph("Dreadball © Mantic", paragraphFont));

        return paragraph;
    }

    private final Paragraph getGeneralParagraph(final SponsorTeam team) {
        final PdfPTable table;
        final Paragraph paragraph;

        paragraph = new Paragraph();

        table = new PdfPTable(2);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        paragraph.add(table);

        table.addCell(messages.getString("report.rank"));
        table.addCell(String.valueOf(team.getBaseRank()));

        table.addCell(messages.getString("report.rankCost"));
        table.addCell(String.valueOf(team.getRankCost()));

        table.addCell(messages.getString("report.totalCost"));
        table.addCell(String.valueOf(team.getTotalCost()));

        return paragraph;
    }

    private final Paragraph getHeader() {
        final Chunk chunk;

        chunk = new Chunk(messages.getString("report.appName"), chapterFont);

        return new Paragraph(chunk);
    }

    private final Paragraph getPlayersParagraph(final SponsorTeam team) {
        final Paragraph paragraph;
        final PdfPTable table;

        paragraph = new Paragraph();

        paragraph.add(new Paragraph(" ", paragraphFont));

        table = new PdfPTable(3);
        paragraph.add(table);

        // Adds headers
        Stream.of(messages.getString("report.position"),
                messages.getString("report.player"),
                messages.getString("report.cost")).forEach(columnTitle -> {
                    final PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });

        team.getPlayers().entrySet().stream().forEach((pair) -> {
            table.addCell(String.valueOf(pair.getKey()));
            table.addCell(pair.getValue().getTemplateName());
            table.addCell(String.valueOf(pair.getValue().getCost()));
        });

        return paragraph;
    }

}
