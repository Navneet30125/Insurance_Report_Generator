package com.insurance.policy.util;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.insurance.policy.entity.CitizenPlan;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {

	public void generate(HttpServletResponse response, List<CitizenPlan> records, File f) throws Exception {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();
		// Title
		Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Color.BLUE);
		Paragraph title = new Paragraph("Citizen Plan Report", titleFont);
		title.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(title);
		document.add(new Paragraph(" ")); // space

		PdfPTable table = new PdfPTable(7);
		table.setWidthPercentage(100f);
		table.setSpacingBefore(10);
		String[] headers = { "ID", "Citizen Name", "Plan Name", "Status", "Start Date", "End Date", "Benefit Amount" };

		for (String headerTitle : headers) {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(Color.LIGHT_GRAY);
			header.setBorderWidth(2);
			header.setPhrase(new Phrase(headerTitle));
			table.addCell(header);
		}


		for (CitizenPlan plan : records) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getPlanStartDate() != null ? plan.getPlanStartDate().toString() : "");
			table.addCell(plan.getPlanEndDate() != null ? plan.getPlanEndDate().toString() : "");
			table.addCell(plan.getBenefitAmount() != null ? plan.getBenefitAmount().toString() : "");
		}

		document.add(table);
		document.close();
	}
}
