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

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.stats.AffinityGroup;
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
public final class DefaultDreadballReportBuilder
        implements DreadballReportBuilder {

    /**
     * Affinites i18n messages.
     */
    private final ResourceBundle affinitiesMessages;

    /**
     * Chapter font.
     */
    private final Font           chapterFont;

    /**
     * Report i18n messages.
     */
    private final ResourceBundle messages;

    /**
     * Paragraph font.
     */
    private final Font           paragraphFont;

    /**
     * Player names i18n messages.
     */
    private final ResourceBundle playersMessages;

    /**
     * Constructs a report builder.
     * 
     * @param affinitiesMsgs
     *            affinities messages
     * @param playersMsgs
     *            player messages
     * @param msgs
     *            report messages
     */
    public DefaultDreadballReportBuilder(final ResourceBundle affinitiesMsgs,
            final ResourceBundle playersMsgs, final ResourceBundle msgs) {
        super();

        chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 16,
                Font.BOLDITALIC);
        paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12,
                Font.NORMAL);

        affinitiesMessages = checkNotNull(affinitiesMsgs);
        playersMessages = checkNotNull(playersMsgs);
        messages = checkNotNull(msgs);
    }

    @Override
    public final void createPdf(final SponsorTeam team,
            final OutputStream output) throws IOException, DocumentException {
        final Document document;
        final Paragraph costs;
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
        costs = getCostsParagraph(team);
        assets = getAssetsParagraph(team);
        players = getPlayersParagraph(team.getPlayers().entrySet());
        affinities = getAffinitiesParagraph(
                team.getSponsor().getAffinityGroups(),
                team.getAdditionalAffinityGroups());
        copyright = getCopyright();

        linebreak = new Chunk(new DottedLineSeparator());

        document.add(header);
        document.add(linebreak);
        document.add(costs);
        document.add(assets);
        document.add(affinities);
        document.add(players);
        document.add(copyright);
        document.close();
    }

    /**
     * Builds the affinities paragraph.
     * 
     * @param affinities
     *            sponsor affinities
     * @param additional
     *            additional affinities
     * @return the affinities paragraph
     */
    private final Paragraph getAffinitiesParagraph(
            final Iterable<AffinityGroup> affinities,
            final Iterable<AffinityGroup> additional) {
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

        StreamSupport.stream(affinities.spliterator(), false)
                .forEach((affinity) -> {
                    table.addCell(
                            affinitiesMessages.getString(affinity.getName()));
                });

        if (!Iterables.isEmpty(additional)) {
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

            StreamSupport.stream(additional.spliterator(), false)
                    .forEach((affinity) -> {
                        tableAdditional.addCell(affinitiesMessages
                                .getString(affinity.getName()));
                    });
        }

        return paragraph;
    }

    /**
     * Builds the assets paragraph.
     * 
     * @param team
     *            sponsor team
     * @return the assets paragraph
     */
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

    /**
     * Builds the copyright paragraph.
     * 
     * @return the copyright paragraph
     */
    private final Paragraph getCopyright() {
        final Paragraph paragraph;

        paragraph = new Paragraph();

        paragraph.add(new Paragraph("Dreadball © Mantic", paragraphFont));

        return paragraph;
    }

    /**
     * Builds the costs paragraph.
     * 
     * @param team
     *            sponsor team
     * @return the costs paragraph
     */
    private final Paragraph getCostsParagraph(final SponsorTeam team) {
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

    /**
     * Builds the header paragraph.
     * 
     * @return the header paragraph
     */
    private final Paragraph getHeader() {
        final Chunk chunk;

        chunk = new Chunk(messages.getString("report.appName"), chapterFont);

        return new Paragraph(chunk);
    }

    /**
     * Returns the players paragraph.
     * 
     * @param players
     *            team players
     * @return the players paragraph
     */
    private final Paragraph
            getPlayersParagraph(final Set<Entry<Integer, TeamPlayer>> players) {
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

        StreamSupport.stream(players.spliterator(), false).forEach((pair) -> {
            table.addCell(String.valueOf(pair.getKey()));
            table.addCell(playersMessages.getString(pair.getValue().getName()));
            table.addCell(String.valueOf(pair.getValue().getCost()));
        });

        return paragraph;
    }

}
