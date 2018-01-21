
package com.bernardomg.tabletop.dreadball.report;

import java.io.IOException;
import java.io.OutputStream;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
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
    public final void createPdf(final OutputStream output) {
        try {
            create(output);
        } catch (final IOException | DocumentException e) {
            e.printStackTrace();
        }
    }

    private final void create(final OutputStream output)
            throws IOException, DocumentException {
        final Document document = new Document();
        PdfWriter.getInstance(document, output);
        document.open();
        final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 16,
                Font.BOLDITALIC);
        final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA,
                12, Font.NORMAL);
        final Chunk chunk = new Chunk("App title", chapterFont);

        final Paragraph assets = new Paragraph();

        assets.add(new Paragraph("Assets", paragraphFont));

        final PdfPTable table = new PdfPTable(2);
        addTableHeader(table);
        addRows(table);
        assets.add(table);

        final Paragraph header = new Paragraph(chunk);

        final Chunk linebreak = new Chunk(new DottedLineSeparator());

        document.add(header);
        document.add(linebreak);
        document.add(assets);
        document.close();
    }

    private void addTableHeader(final PdfPTable table) {
        Stream.of("asset", "value").forEach(columnTitle -> {
            final PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(columnTitle));
            table.addCell(header);
        });
    }

    private void addRows(final PdfPTable table) {
        table.addCell("cheerleaders");
        table.addCell("0");

        table.addCell("coaching_dice");
        table.addCell("0");

        table.addCell("medibots");
        table.addCell("0");

        table.addCell("nasty_surprise_cards");
        table.addCell("0");

        table.addCell("special_move_cards");
        table.addCell("0");

        table.addCell("wager");
        table.addCell("0");
    }

}
