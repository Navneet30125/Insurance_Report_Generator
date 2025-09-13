package com.insurance.policy.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.insurance.policy.entity.CitizenPlan;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {
	
	public void generate(HttpServletResponse response, List<CitizenPlan> records, File f) throws Exception{
	Workbook workbook = new HSSFWorkbook();
//	Workbook workbook = new XSSFWorkbook();
	Sheet sheet = workbook.createSheet("Plans-Info");
	Row headerRow = sheet.createRow(0);
	headerRow.createCell(0).setCellValue("ID");
	headerRow.createCell(1).setCellValue("Citizen Name");
	headerRow.createCell(2).setCellValue("Plan Name");
	headerRow.createCell(3).setCellValue("Gender");
	headerRow.createCell(4).setCellValue("Plan Status");
	headerRow.createCell(5).setCellValue("Plan Start Date");
	headerRow.createCell(6).setCellValue("Plan End Date");
	headerRow.createCell(7).setCellValue("Benefit Amount");
	
	int dataRowIndex = 1;
	for (CitizenPlan plan : records) {
		Row datarow = sheet.createRow(dataRowIndex);
		datarow.createCell(0).setCellValue(plan.getCitizenId());
		datarow.createCell(1).setCellValue(plan.getCitizenName());
		datarow.createCell(2).setCellValue(plan.getGender());
		datarow.createCell(3).setCellValue(plan.getPlanName());
		datarow.createCell(4).setCellValue(plan.getPlanStatus());
		if (plan.getPlanStartDate() != null) {
			datarow.createCell(5).setCellValue(plan.getPlanStartDate() + "");
		} else {
			datarow.createCell(5).setCellValue("N/A");
		}
		if (plan.getPlanStartDate() != null) {
			datarow.createCell(6).setCellValue(plan.getPlanEndDate() + "");
		} else {
			datarow.createCell(6).setCellValue("N/A");
		}
		if (plan.getBenefitAmount() != null) {
			datarow.createCell(7).setCellValue(plan.getBenefitAmount());
		} else {
			datarow.createCell(7).setCellValue("N/A");
		}
		dataRowIndex++;
	}
	//for creating the file dynamically with records in project folder
	FileOutputStream fileoutputstream = new FileOutputStream(f);
	workbook.write(fileoutputstream);
	fileoutputstream.close();
	
	ServletOutputStream outputStream = response.getOutputStream();
	workbook.write(outputStream);
	workbook.close();
	}

}
