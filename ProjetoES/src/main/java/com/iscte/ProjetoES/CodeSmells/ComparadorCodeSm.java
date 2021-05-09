package com.iscte.ProjetoES.CodeSmells;

import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.iscte.ProjetoES.Gui.GUI;
import org.apache.poi.ss.usermodel.Cell;
import java.io.Serializable;

public class ComparadorCodeSm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// Variáveis - excel workbooks
	private HSSFWorkbook metricasLerWorkbook;
	private HSSFWorkbook codeSmLerWorkbook;
	
	// Variáveis
	//VP: Verdadeiros Positivos
	//FP: Falsos Positivos
	//VN: Verdadeiros Negativos
	//FN: Falsos Negativos
	private int VP1;
	private int FP1;
	private int VN1;
	private int FN1;
	private int VP2;
	private int FP2;
	private int VN2;
	private int FN2;

	// Getters das variáveis acima descritas
	public int getVP1() { return VP1; }

	public int getFP1() { return FP1; }

	public int getVN1() { return VN1; }

	public int getFN1() { return FN1; }

	public int getVP2() { return VP2; }

	public int getFP2() { return FP2; }

	public int getVN2() { return VN2; }

	public int getFN2() { return FN2; }
	
	
	// Procedimento para comparar os Long Methods
	public void comparadorLM() throws IOException {
		
		VP1 = 0; FP1 = 0; VN1 = 0; FN1 = 0;
		
		InputStream ficheiroExcelMetricas = new FileInputStream(GUI.getLocation());
		metricasLerWorkbook = new HSSFWorkbook(ficheiroExcelMetricas);
		Sheet folhaExcelMetricas = metricasLerWorkbook.getSheetAt(0);
		
		InputStream ficheiroExcelCodeSm = new FileInputStream("Code_Smells.xls");
		codeSmLerWorkbook = new HSSFWorkbook(ficheiroExcelCodeSm);
		Sheet folhaExcelCodeSm = codeSmLerWorkbook.getSheetAt(0);
		
		int i = 1;
		while (i <= folhaExcelMetricas.getLastRowNum()) {
			Row linhaExcel = folhaExcelMetricas.getRow(i);
			Cell nomeClasse = linhaExcel.getCell(2);
			Cell methodname = linhaExcel.getCell(3);
			Cell isLongMethod = linhaExcel.getCell(9);
			
			int j = 1;
			while (j <= folhaExcelCodeSm.getLastRowNum()) {
				Row linhaExcel2 = folhaExcelCodeSm.getRow(j);
				Cell nomeClasse2 = linhaExcel2.getCell(2);
				Cell methodname2 = linhaExcel2.getCell(3);
				Cell isLongMethod2 = linhaExcel2.getCell(10);
				if (nomeClasse.toString().equals(nomeClasse2.toString())
						&& methodname.toString().equals(methodname2.toString())) {
					if (isLongMethod2.getBooleanCellValue() == true && isLongMethod.getBooleanCellValue() == true) {
						VP1++;
					}
					if (isLongMethod.getBooleanCellValue() == false && isLongMethod2.getBooleanCellValue() == false) {
						VN1++;
					}
					if (isLongMethod.getBooleanCellValue() == false && isLongMethod2.getBooleanCellValue() == true) {
						FN1++;
					}
					if (isLongMethod2.getBooleanCellValue() == false && isLongMethod.getBooleanCellValue() == true) {
						FP1++;
					}
				}
				j++;
			}
			i++;
		}
	}

	// Procedimento para comparar as God Classes
	public void comparadorGC() throws IOException {
		
		VP2 = 0; FP2 = 0; VN2 = 0; FN2 = 0;
		
		InputStream ficheiroExcelMetricas = new FileInputStream(GUI.getLocation());
		metricasLerWorkbook = new HSSFWorkbook(ficheiroExcelMetricas);
		Sheet folhaExcelMetricas = metricasLerWorkbook.getSheetAt(0);
		
		InputStream ficheiroExcelCodeSm = new FileInputStream("Code_Smells.xls");
		codeSmLerWorkbook = new HSSFWorkbook(ficheiroExcelCodeSm);
		Sheet folhaExcelCodeSm = codeSmLerWorkbook.getSheetAt(0);
		
		int i = 1;
		while (i <= folhaExcelMetricas.getLastRowNum()) {
			Row linhaExcel = folhaExcelMetricas.getRow(i);
			Cell nomeClasse = linhaExcel.getCell(2);
			Cell is_GodClass = linhaExcel.getCell(10);
			if (is_GodClass != null) {
				int j = 1;
				while (j <= folhaExcelCodeSm.getLastRowNum()) {
					Row linhaExcel2 = folhaExcelCodeSm.getRow(j);
					Cell nomeClasse2 = linhaExcel2.getCell(2);
					Cell is_GodClass2 = linhaExcel2.getCell(7);
					if (nomeClasse.toString().equals(nomeClasse2.toString())) {
						if (is_GodClass2.getBooleanCellValue() == true && is_GodClass.getBooleanCellValue() == true) {
							VP2++;
						}
						if (is_GodClass.getBooleanCellValue() == false && is_GodClass2.getBooleanCellValue() == false) {
							VN2++;
						}
						if (is_GodClass2.getBooleanCellValue() == false && is_GodClass.getBooleanCellValue() == true) {
							FP2++;
						}
						if (is_GodClass.getBooleanCellValue() == false && is_GodClass2.getBooleanCellValue() == true) {
							FN2++;
						}
						j = folhaExcelCodeSm.getLastRowNum();
					}
					j++;
				}
			}
			i++;
		}
	}
}