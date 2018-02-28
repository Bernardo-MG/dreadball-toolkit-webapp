
package com.bernardomg.tabletop.dreadball.report.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
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

@Service("dreadballReportBuilder")
public class DreadballReportBuilderImpl implements DreadballReportBuilder {

    public DreadballReportBuilderImpl() {
        super();
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
        final Document document = new Document();
        PdfWriter.getInstance(document, output);
        document.open();
        final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 16,
                Font.BOLDITALIC);
        final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA,
                12, Font.NORMAL);
        final Chunk chunk = new Chunk("App title", chapterFont);

        final Paragraph general;
        final Paragraph assets;
        final Paragraph units;

        general = getGeneralParagraph(team, paragraphFont);
        assets = getAssetsParagraph(team, paragraphFont);
        units = getUnitsParagraph(team, paragraphFont);

        final Paragraph header = new Paragraph(chunk);

        final Chunk linebreak = new Chunk(new DottedLineSeparator());

        document.add(header);
        document.add(linebreak);
        document.add(general);
        document.add(assets);
        document.add(units);
        document.close();
    }

    private final Paragraph getAssetsParagraph(final SponsorTeam team,
            final Font paragraphFont) {
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

    private final Paragraph getGeneralParagraph(final SponsorTeam team,
            final Font paragraphFont) {
        final Paragraph paragraph;
        final Paragraph paraRank;
        final Paragraph paraCost;

        paragraph = new Paragraph();

        paragraph.add(new Paragraph("team", paragraphFont));

        paraRank = new Paragraph();
        paraRank.add(new Chunk("rank_cost"));
        paraRank.setTabSettings(new TabSettings(56f));
        paraRank.add(Chunk.TABBING);
        paraRank.add(new Chunk(String.valueOf(team.getRankCost())));

        paragraph.add(paraRank);

        paraCost = new Paragraph();
        paraCost.add(new Chunk("team_value"));
        paraCost.setTabSettings(new TabSettings(56f));
        paraCost.add(Chunk.TABBING);
        paraCost.add(new Chunk(String.valueOf(team.getTotalCost())));

        paragraph.add(paraCost);

        return paragraph;
    }

    private final Paragraph getUnitsParagraph(final SponsorTeam team,
            final Font paragraphFont) {
        final Paragraph paragraph;
        final PdfPTable table;

        paragraph = new Paragraph();

        paragraph.add(new Paragraph("units", paragraphFont));

        table = new PdfPTable(3);
        paragraph.add(table);

        // Adds headers
        Stream.of("position", "unit", "cost").forEach(columnTitle -> {
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
