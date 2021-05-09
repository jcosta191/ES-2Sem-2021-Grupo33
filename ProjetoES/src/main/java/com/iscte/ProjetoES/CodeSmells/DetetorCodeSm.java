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
	
	// Variáveis a serem usadas nesta classe
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
		    XSSFWorkbook ficheiroExcelFormatoWorkbook = new XSSFWorkbook(ficheiroParaLerPath);
			
			Sheet folhaExcel = ficheiroExcelFormatoWorkbook.getSheetAt(0);
			XSSFRow colunaDosNomes = (XSSFRow) folhaExcel.getRow(0);
			colunaDosNomes.createCell(9).setCellValue("is_LM");
			
			int i = 1;
			while (i <= folhaExcel.getLastRowNum()) {
				boolean a = false;
				Row linhaExcel = folhaExcel.getRow(i);
				Cell id = linhaExcel.getCell(0);
				Cell loc_method = linhaExcel.getCell(7);
				Cell cyclo_method = linhaExcel.getCell(8);
				String loc = loc_method.toString();
				String cyclo = cyclo_method.toString();
				DefaultTableModel model = (DefaultTableModel) tabelaDosLM.getModel();
				if (regraAndOr.equals("AND")) {
					if (metrica1.equals("LOC_Method")) {
						if (Integer.parseInt(loc) > valor1 && Integer.parseInt(cyclo) > valor2) {
							a = true;
						} else {
							a = false;
						}
					} else {
						if (Integer.parseInt(cyclo) > valor1 && Integer.parseInt(loc) > valor2) {
							a = true;
						} else {
							a = false;
						}
					}
				model.addRow(new Object[] { id, a });
				linhaExcel.createCell(9).setCellValue(a);
				} else {
						if (metrica1.equals("LOC_Method")) {
							if (Integer.parseInt(loc) > valor1 || Integer.parseInt(cyclo) > valor2) {
								a = true;
							} else {
								a = false;
							}
						} else {
							if (Integer.parseInt(cyclo) > valor1 || Integer.parseInt(loc) > valor2) {
								a = true;
							} else {
								a = false;
							}
						}
						model.addRow(new Object[] { id, a });
						linhaExcel.createCell(9).setCellValue(a);
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

		    setWorkbookread2(new XSSFWorkbook(ficheiroParaLerPath));
		    
            Sheet folhaExcel = getWorkbookread2().getSheetAt(0);
            HSSFRow colunaDosNomes = (HSSFRow) folhaExcel.getRow(0);
            colunaDosNomes.createCell(10).setCellValue("is_GC");
            
				for (int i = 1; i <= folhaExcel.getLastRowNum(); i++){ 
				boolean a = false;
				Row linhaExcel = folhaExcel.getRow(i);
				Row linhaAnterior = folhaExcel.getRow(i-1);
				Cell classname = linhaExcel.getCell(2);
				Cell classname2 = linhaAnterior.getCell(2);
                Cell nom_class = linhaExcel.getCell(4);
                Cell loc_class = linhaExcel.getCell(5);
                Cell wmc_class = linhaExcel.getCell(6);
                String nom = nom_class.toString();
                String loc = loc_class.toString();
                String wmc = wmc_class.toString();
                DefaultTableModel model = (DefaultTableModel) tabelaDasGC.getModel();
                if(classname.toString().equals(classname2.toString())==false) {
                if (regraAndOr.equals("AND")) {
                if (metrica3.equals("LOC_class") && metrica4.equals("NOM_class")) {
                	if (Integer.parseInt(loc) > valor3 && Integer.parseInt(nom) > valor4) {
                		a=true;
                	}
                	else {
        				a=false;
                	}
                }
                
                if (metrica3.equals("LOC_class") && metrica4.equals("WMC_class")) {
                	if(Integer.parseInt(loc) > valor3 && Integer.parseInt(wmc) > valor4) {
                		a=true;
                	}
                	else {
                		a=false;
                	}
                }
                if (metrica3.equals("WMC_class") && metrica4.equals("NOM_class")) {
                	if (Integer.parseInt(wmc) > valor3 && Integer.parseInt(nom) > valor4) {
                		a=true;
                	}
                	else {
        				a=false;
                	}
                }
                
                if (metrica3.equals("WMC_class") && metrica4.equals("LOC_class")) {
                	if(Integer.parseInt(wmc) > valor3 && Integer.parseInt(loc) > valor4) {
                		a=true;
                	}
                	else {
                		a=false;
                	}
                }
                if (metrica3.equals("NOM_class") && metrica4.equals("LOC_class")) {
                	if (Integer.parseInt(nom) > valor3 && Integer.parseInt(loc) > valor4) {
                		a=true;
                	}
                	else {
        				a=false;
                	}
                }
                
                if (metrica3.equals("NOM_class") && metrica4.equals("WMC_class")) {
                	if(Integer.parseInt(nom) > valor3 && Integer.parseInt(wmc) > valor4) {
                		a=true;
                	}
                	else {
                		a=false;
                	}
                }
			  model.addRow(new Object[]{classname,a});
			  linhaExcel.createCell(10).setCellValue(a);
				
				}
				else {//OR
				
		                if (metrica3.equals("LOC_class") && metrica4.equals("NOM_class")) {
		                	if (Integer.parseInt(loc) > valor3 || Integer.parseInt(nom) > valor4) {
		                		a=true;
		                	}
		                	else {
		        				a=false;
		                	}
		                }
		                
		                if (metrica3.equals("LOC_class") && metrica4.equals("WMC_class")) {
		                	if(Integer.parseInt(loc) > valor3 || Integer.parseInt(wmc) > valor4) {
		                		a=true;
		                	}
		                	else {
		                		a=false;
		                	}
		                }
		                if (metrica3.equals("WMC_class")&&metrica4.equals("NOM_class")) {
		                	if (Integer.parseInt(wmc)>valor3 || Integer.parseInt(nom)>valor4) {
		                		a=true;
		                	}
		                	else {
		        				a=false;
		                	}
		                }
		                
		                if (metrica3.equals("WMC_class") && metrica4.equals("LOC_class")) {
		                	if(Integer.parseInt(wmc) > valor3 || Integer.parseInt(loc) > valor4) {
		                		a=true;
		                	}
		                	else {
		                		a=false;
		                	}
		                }
		                if (metrica3.equals("NOM_class") && metrica4.equals("LOC_class")) {
		                	if (Integer.parseInt(nom) > valor3 || Integer.parseInt(loc) > valor4) {
		                		a=true;
		                	}
		                	else {
		        				a=false;
		                	}
		                }
		                
		                if (metrica3.equals("NOM_class") && metrica4.equals("WMC_class")) {
		                	if(Integer.parseInt(nom) > valor3 || Integer.parseInt(wmc) > valor4) {
		                		a=true;
		                	}
		                	else {
		                		a=false;
		                	}
		                }
					  model.addRow(new Object[]{classname,a});
					  linhaExcel.createCell(10).setCellValue(a);
						
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