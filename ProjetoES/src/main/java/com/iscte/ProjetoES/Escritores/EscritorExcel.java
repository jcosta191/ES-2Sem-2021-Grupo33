package com.iscte.ProjetoES.Escritores;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.iscte.ProjetoES.Metodo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

public class EscritorExcel {
	private static List<Metodo> methods = new ArrayList<>();

	// Initializing employees data to insert into the excel file
	
	private EscritorExcel() {
	}

	public static void escreverExcel(String a) throws IOException, InvalidFormatException {
		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		/*
		 * CreationHelper helps us create instances of various things like DataFormat,
		 * Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way
		 */
		CreationHelper createHelper = workbook.getCreationHelper();

		// Create a Sheet
		Sheet sheet = workbook.createSheet(a);

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.BLACK.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Create a Row
		Row headerRow = sheet.createRow(0);

		// Create Other rows and cells with employees data
		int rowNum = 1;
		for (Metodo method : methods) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(method.getMethodID());

			row.createCell(1).setCellValue(method.getPackage());

			row.createCell(2).setCellValue(method.getClasse());

			row.createCell(3).setCellValue(method.getMethod());
			
			row.createCell(4).setCellValue(method.getNOM_class());
		
			row.createCell(5).setCellValue(method.getLOC_class());
			
			row.createCell(6).setCellValue(method.getWMC_class());
			
			row.createCell(7).setCellValue(method.getLOC_method());
			
			row.createCell(8).setCellValue(method.getCYCLO_method());	
		}

		// Resize all columns to fit the content size
		for (int i = 0; i < 9; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream(a+"_metrics.xlsx");
		workbook.write(fileOut);
		fileOut.close();

		// Closing the workbook
		workbook.close();
	}
	
	public static void adicionaLista(Metodo a) {
		methods.add(a);
		}
}
