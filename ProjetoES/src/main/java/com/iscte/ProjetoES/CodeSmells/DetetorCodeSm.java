package com.iscte.ProjetoES.CodeSmells;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import org.apache.poi.hssf.usermodel.HSSFRow;
import java.io.IOException;
import javax.swing.JTable;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class DetetorCodeSm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Variáveis booleanVerificacao serem usadas nesta classe
	private XSSFWorkbook ficheiroExcelFormatoWorkbook;
	private JTable tabelaDosLM;
	private  JTable tabelaDasGC;
	
	
	// Definição dos Getters e Setters das variáveis acima
	public void setWorkbookread2(XSSFWorkbook ficheiroExcelFormatoWorkbook) {
		this.ficheiroExcelFormatoWorkbook = ficheiroExcelFormatoWorkbook;
	}
	
	public void setTableLongMethod(JTable tabelaDosLM) {
		this.tabelaDosLM = tabelaDosLM;
	}
	
	public void setTableGodClass(JTable tabelaDasGC) {
		this.tabelaDasGC = tabelaDasGC;
	}
	
	public JTable getTableLongMethod() { return tabelaDosLM; }
	
	public XSSFWorkbook getWorkbookread2() { return ficheiroExcelFormatoWorkbook; }
	
	public JTable getTableGodClass() { return tabelaDasGC; }
	
	
	// Procedimento que irá detetar os Long Methods 
	public void detetorLM(String ficheiroParaLerPath, String metrica1, int valor1, int valor2, String regraAndOr) throws IOException {
		try {
//		    XSSFWorkbook ficheiroExcelFormatoWorkbook = new XSSFWorkbook(ficheiroParaLerPath);
			
			InputStream excelFile = new FileInputStream(ficheiroParaLerPath);
			ficheiroExcelFormatoWorkbook = new XSSFWorkbook(excelFile);
			org.apache.poi.ss.usermodel.Sheet folhaExcel = ficheiroExcelFormatoWorkbook.getSheetAt(0);
			XSSFRow colunaDosNomes = (XSSFRow) folhaExcel.getRow(0);
			colunaDosNomes.createCell(9).setCellValue("is_LM");
			DataFormatter dataFormatter = new DataFormatter();
			int i = 1;
			while (i <= folhaExcel.getLastRowNum()) {
				boolean booleanVerificacao = false;
				Row linhaExcel = folhaExcel.getRow(i);
				String _id = dataFormatter.formatCellValue(linhaExcel.getCell(0));
				String _loc_method = dataFormatter.formatCellValue(linhaExcel.getCell(7));
				String _cyclo_method = dataFormatter.formatCellValue(linhaExcel.getCell(8));
				
				int id = Integer.parseInt(_id);
				int loc = Integer.parseInt(_loc_method);
				int cyclo = Integer.parseInt(_cyclo_method);
//				String id = 
				
//				String loc = loc_method.toString();
//				String cyclo = cyclo_method.toString();
				DefaultTableModel model = (DefaultTableModel) tabelaDosLM.getModel();
				System.out.println("Ciclo detetorlm: " + linhaExcel);
				if (regraAndOr.equals("AND")) {
					if (metrica1.equals("LOC_Method")) {
						if (loc > (int) valor1 && cyclo > (int) valor2) {
							booleanVerificacao = true;
						} else {
							booleanVerificacao = false;
						}
					} else {
						if (cyclo > (int) valor1 && loc > (int) valor2) {
							booleanVerificacao = true;
						} else {
							booleanVerificacao = false;
						}
					}
				model.addRow(new Object[] { id, booleanVerificacao });
				linhaExcel.createCell(9).setCellValue(booleanVerificacao);
				} else {
						if (metrica1.equals("LOC_Method")) {
							if (loc > valor1 || cyclo > valor2) {
								booleanVerificacao = true;
							} else {
								booleanVerificacao = false;
							}
						} else {
							if (cyclo > valor1 || loc > valor2) {
								booleanVerificacao = true;
							} else {
								booleanVerificacao = false;
							}
						}
						model.addRow(new Object[] { id, booleanVerificacao });
						linhaExcel.createCell(9).setCellValue(booleanVerificacao);
					}
						i++;
				}
				FileOutputStream fileOut = new FileOutputStream(ficheiroParaLerPath);
				ficheiroExcelFormatoWorkbook.write(fileOut);
				fileOut.close();
				ficheiroExcelFormatoWorkbook.close();
			} catch (FileNotFoundException e) {
				System.out.println("Erro encontrado: " + e);
			}
	}
	
	// Procedimento que irá detetar as God Class
	public void detetorGC(String ficheiroParaLerPath, String metrica3, String metrica4, int valor3, int valor4, String regraAndOr) throws IOException {
		try {
			InputStream excelFile = new FileInputStream(ficheiroParaLerPath);
		    setWorkbookread2(new XSSFWorkbook(excelFile));
		    
		    org.apache.poi.ss.usermodel.Sheet folhaExcel = getWorkbookread2().getSheetAt(0);
            XSSFRow colunaDosNomes = (XSSFRow) folhaExcel.getRow(0);
            colunaDosNomes.createCell(10).setCellValue("is_GC");
            DataFormatter dataFormatter = new DataFormatter();
				for (int i = 1; i <= folhaExcel.getLastRowNum(); i++){ 
				boolean booleanVerificacao = false;
				Row linhaExcel = folhaExcel.getRow(i);
				Row linhaAnterior = folhaExcel.getRow(i-1);
				
				String classname = dataFormatter.formatCellValue(linhaExcel.getCell(2));
				String classname2 = dataFormatter.formatCellValue(linhaAnterior.getCell(2));
				
                String nom_class = dataFormatter.formatCellValue(linhaExcel.getCell(4));
				String loc_class = dataFormatter.formatCellValue(linhaExcel.getCell(5));
				String wmc_class = dataFormatter.formatCellValue(linhaExcel.getCell(6));
				
				int nom = Integer.parseInt(nom_class);
				int loc = Integer.parseInt(loc_class);
				int wmc = Integer.parseInt(wmc_class);
                
                
                DefaultTableModel model = (DefaultTableModel) tabelaDasGC.getModel();
                
                System.out.println("Ciclo detetorgc: " + linhaExcel); //DEBUG
                
                if(classname.toString().equals(classname2.toString())==false) {
                if (regraAndOr.equals("AND")) {
                if (metrica3.equals("LOC_class") && metrica4.equals("NOM_class")) {
                	if (loc > valor3 && nom > valor4) {
                		booleanVerificacao=true;
                	}
                	else {
        				booleanVerificacao=false;
                	}
                }
                
                if (metrica3.equals("LOC_class") && metrica4.equals("WMC_class")) {
                	if(loc > valor3 && wmc > valor4) {
                		booleanVerificacao=true;
                	}
                	else {
                		booleanVerificacao=false;
                	}
                }
                if (metrica3.equals("WMC_class") && metrica4.equals("NOM_class")) {
                	if (wmc > valor3 && nom > valor4) {
                		booleanVerificacao=true;
                	}
                	else {
        				booleanVerificacao=false;
                	}
                }
                
                if (metrica3.equals("WMC_class") && metrica4.equals("LOC_class")) {
                	if(wmc > valor3 && loc > valor4) {
                		booleanVerificacao=true;
                	}
                	else {
                		booleanVerificacao=false;
                	}
                }
                if (metrica3.equals("NOM_class") && metrica4.equals("LOC_class")) {
                	if (nom > valor3 && loc > valor4) {
                		booleanVerificacao=true;
                	}
                	else {
        				booleanVerificacao=false;
                	}
                }
                
                if (metrica3.equals("NOM_class") && metrica4.equals("WMC_class")) {
                	if(nom > valor3 && wmc > valor4) {
                		booleanVerificacao=true;
                	}
                	else {
                		booleanVerificacao=false;
                	}
                }
			  model.addRow(new Object[]{classname,booleanVerificacao});
			  linhaExcel.createCell(10).setCellValue(booleanVerificacao);
				
				}
				else {//OR
				
		                if (metrica3.equals("LOC_class") && metrica4.equals("NOM_class")) {
		                	if (loc > valor3 || nom > valor4) {
		                		booleanVerificacao=true;
		                	}
		                	else {
		        				booleanVerificacao=false;
		                	}
		                }
		                
		                if (metrica3.equals("LOC_class") && metrica4.equals("WMC_class")) {
		                	if(loc > valor3 || wmc > valor4) {
		                		booleanVerificacao=true;
		                	}
		                	else {
		                		booleanVerificacao=false;
		                	}
		                }
		                if (metrica3.equals("WMC_class")&&metrica4.equals("NOM_class")) {
		                	if (wmc > valor3 || nom > valor4) {
		                		booleanVerificacao=true;
		                	}
		                	else {
		        				booleanVerificacao=false;
		                	}
		                }
		                
		                if (metrica3.equals("WMC_class") && metrica4.equals("LOC_class")) {
		                	if(wmc > valor3 || loc > valor4) {
		                		booleanVerificacao=true;
		                	}
		                	else {
		                		booleanVerificacao=false;
		                	}
		                }
		                if (metrica3.equals("NOM_class") && metrica4.equals("LOC_class")) {
		                	if (nom > valor3 || loc > valor4) {
		                		booleanVerificacao=true;
		                	}
		                	else {
		        				booleanVerificacao=false;
		                	}
		                }
		                
		                if (metrica3.equals("NOM_class") && metrica4.equals("WMC_class")) {
		                	if(nom > valor3 || wmc > valor4) {
		                		booleanVerificacao=true;
		                	}
		                	else {
		                		booleanVerificacao=false;
		                	}
		                }
					  model.addRow(new Object[]{classname,booleanVerificacao});
					  linhaExcel.createCell(10).setCellValue(booleanVerificacao);
						
						}
						
					}
				}
			
				FileOutputStream fileOut = new FileOutputStream(ficheiroParaLerPath);
	             getWorkbookread2().write(fileOut);
	             fileOut.close();
	             getWorkbookread2().close();
		} catch (FileNotFoundException e) {
			System.out.println("Erro encontrado: " + e);
		}	
	}
}