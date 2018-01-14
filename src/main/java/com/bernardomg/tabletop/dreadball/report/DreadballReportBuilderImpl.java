
package com.bernardomg.tabletop.dreadball.report;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service("dreadballReportBuilder")
public class DreadballReportBuilderImpl implements DreadballReportBuilder {

    public DreadballReportBuilderImpl() {
        super();
    }

    @Override
    public final void createPdf(final OutputStream output)
            throws IOException, DocumentException {
        final Document document = new Document();
        PdfWriter.getInstance(document, output);
        document.open();
        final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 16,
                Font.BOLDITALIC);
        final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA,
                12, Font.NORMAL);
        final Chunk chunk = new Chunk("This is the title", chapterFont);
        final Chapter chapter = new Chapter(new Paragraph(chunk), 1);
        chapter.setNumberDepth(0);
        chapter.add(new Paragraph("This is the paragraph", paragraphFont));
        document.add(chapter);
        document.close();
    }

}
