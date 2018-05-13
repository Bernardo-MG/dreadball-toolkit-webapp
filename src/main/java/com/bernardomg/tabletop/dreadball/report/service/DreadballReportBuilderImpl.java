
package com.bernardomg.tabletop.dreadball.report.service;

import java.io.IOException;
import java.io.OutputStream;
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
import com.itextpdf.text.TabSettings;
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

    private final Font chapterFont;

    private final Font paragraphFont;

    /**
     * Constructs a report builder.
     */
    public DreadballReportBuilderImpl() {
        super();

        chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 16,
                Font.BOLDITALIC);
        paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12,
                Font.NORMAL);
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

        general = getGeneralParagraph(team);
        assets = getAssetsParagraph(team);
        players = getPlayersParagraph(team);
        affinities = getAffinitiesParagraph(team);
        copyright = getCopyright();

        header = getHeader();

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

        paragraph.add(new Paragraph("affinities", paragraphFont));

        table = new PdfPTable(1);
        paragraph.add(table);

        // Adds headers
        Stream.of("affinity").forEach(columnTitle -> {
            final PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(columnTitle));
            table.addCell(header);
        });

        team.getSponsor().getAffinityGroups().stream().forEach((affinity) -> {
            table.addCell(affinity.getName());
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
                        tableAdditional.addCell(affinity.getName());
                    });
        }

        return paragraph;
    }

    private final Paragraph getAssetsParagraph(final SponsorTeam team) {
        final Paragraph paragraph;
        final PdfPTable table;

        paragraph = new Paragraph();

        paragraph.add(new Paragraph("assets", paragraphFont));

        table = new PdfPTable(2);
        paragraph.add(table);

        // Adds headers
        Stream.of("asset", "value").forEach(columnTitle -> {
            final PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(columnTitle));
            table.addCell(header);
        });

        table.addCell("cheerleaders");
        table.addCell(String.valueOf(team.getCheerleaders()));

        table.addCell("coaching_dice");
        table.addCell(String.valueOf(team.getCoachingDice()));

        table.addCell("medibots");
        table.addCell(String.valueOf(team.getMediBots()));

        table.addCell("nasty_surprise_cards");
        table.addCell(String.valueOf(team.getNastySurpriseCards()));

        table.addCell("special_move_cards");
        table.addCell(String.valueOf(team.getSpecialMoveCards()));

        table.addCell("wager");
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
        final Paragraph paragraph;
        final Paragraph paraRankCost;
        final Paragraph paraRank;
        final Paragraph paraCost;

        paragraph = new Paragraph();

        paragraph.add(new Paragraph("team", paragraphFont));

        paraRank = new Paragraph();
        paraRank.add(new Chunk("rank"));
        paraRank.setTabSettings(new TabSettings(56f));
        paraRank.add(Chunk.TABBING);
        paraRank.add(new Chunk(String.valueOf(team.getBaseRank())));

        paragraph.add(paraRank);

        paraRankCost = new Paragraph();
        paraRankCost.add(new Chunk("rank_cost"));
        paraRankCost.setTabSettings(new TabSettings(56f));
        paraRankCost.add(Chunk.TABBING);
        paraRankCost.add(new Chunk(String.valueOf(team.getRankCost())));

        paragraph.add(paraRankCost);

        paraCost = new Paragraph();
        paraCost.add(new Chunk("total_cost"));
        paraCost.setTabSettings(new TabSettings(56f));
        paraCost.add(Chunk.TABBING);
        paraCost.add(new Chunk(String.valueOf(team.getTotalCost())));

        paragraph.add(paraCost);

        return paragraph;
    }

    private final Paragraph getHeader() {
        final Chunk chunk;

        chunk = new Chunk("App title", chapterFont);

        return new Paragraph(chunk);
    }

    private final Paragraph getPlayersParagraph(final SponsorTeam team) {
        final Paragraph paragraph;
        final PdfPTable table;

        paragraph = new Paragraph();

        paragraph.add(new Paragraph("players", paragraphFont));

        table = new PdfPTable(3);
        paragraph.add(table);

        // Adds headers
        Stream.of("position", "player", "cost").forEach(columnTitle -> {
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
