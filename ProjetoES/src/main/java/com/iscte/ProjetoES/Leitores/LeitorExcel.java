package com.iscte.ProjetoES.Leitores;

import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;

import java.io.File;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.iscte.ProjetoES.Metodo;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

/**
 * Classe para vizualizar os dados importados do ficheiro Excel
 * 
 * 
 * @author jcosta191
 *
 */
public class LeitorExcel extends AbstractTableModel {
	private static final long serialVersionUID = -4220550076295049347L;
	private static LeitorExcel INSTANCE;
	private Sheet sheet;
	public int numberP, numberLOC;
	public static ArrayList<Metodo> metodos = new ArrayList<>();

	private LeitorExcel() {
	}

	/**
	 * Abre o filechooser para escolher o ficheiro Excel
	 */
	public void addFile() {
		Workbook workbook;
		try {
			workbook = WorkbookFactory.create(fileChooser());
			sheet = workbook.getSheetAt(0);
			numberP = 1;
		} catch (NullPointerException | InvalidFormatException | IOException e) {
			System.out.println("Ficheiro não aberto!");
			System.exit(0);
		}
	}

	/**
	 * 
	 *Classe que vai ler os dados do excel por coluna e linha
	 *
	 */
	public ArrayList<Metodo> getContent() throws EncryptedDocumentException, InvalidFormatException, IOException {
		int numberLOC1 = 0;
		if (sheet != null) {
			DataFormatter dataFormatter = new DataFormatter();
			int j = 1;
			while (j <= sheet.getLastRowNum()) {

				Row linha = sheet.getRow(j);
				int methodID = (int) linha.getCell(0).getNumericCellValue();
				String Package = dataFormatter.formatCellValue(linha.getCell(1));
				String Class = dataFormatter.formatCellValue(linha.getCell(2));
				String method = dataFormatter.formatCellValue(linha.getCell(3));
				int NOM_class = (int) linha.getCell(4).getNumericCellValue();
				int LOC_class = (int) linha.getCell(5).getNumericCellValue();
				int WMC_class = (int) linha.getCell(6).getNumericCellValue();
				int LOC_method = (int) linha.getCell(7).getNumericCellValue();
				int CYCLO_method = (int) linha.getCell(8).getNumericCellValue();
				numberLOC1 += LOC_method;
				setNumberLOC(numberLOC1);
				System.out.print("LOCCCCC" + numberLOC);
				System.out.print("PACKAGE:   " + numberP);
				Metodo met = new Metodo(methodID, Package, Class, method, NOM_class, LOC_class, WMC_class, LOC_method,
						CYCLO_method);
				metodos.add(met);
				System.out.print(met.getClass());
				j++;
			}
		}
		return metodos;
	}

	@Override
	public int getColumnCount() {
		if (sheet != null) {
			int last_cell = sheet.getRow(0).getLastCellNum();
			return last_cell;
		} else {
			return 0;
		}
	}

	public void setNumberPackage(int a) {
		numberP = a;

	}

	public void setNumberLOC(int a) {
		numberLOC = a;

	}

	@Override
	public int getRowCount() {
		if (sheet != null) {
			return sheet.getLastRowNum();
		} else {
			return 0;
		}
	}

	@Override
	public String getColumnName(int arg0) {
		if (sheet != null) {
			Cell cell = sheet.getRow(0).getCell(arg0);
			return cell.getStringCellValue();
		} else {
			return "";
		}
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		if (sheet != null) {
			DataFormatter dataFormatter = new DataFormatter();
			arg0++;
			Cell cell = sheet.getRow(arg0).getCell(arg1);

			switch (arg1) {
			case 0:
				return (int) cell.getNumericCellValue();
			case 1:
			case 2:
			case 3:
				return cell.getStringCellValue();
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				return (int) cell.getNumericCellValue();

			default:
				return null;
			}
		} else {
			return "";
		}

	}

	public static LeitorExcel getInstance() {
		if (INSTANCE == null)
			INSTANCE = new LeitorExcel();
		return INSTANCE;
	}

	public static LeitorExcel newInstance() {
		INSTANCE = new LeitorExcel();
		return INSTANCE;
	}

	/**
	 * Classe que um seletor de ficheiros para o utilizador poder abrir um ficheiro do tipo Excel
	 * 
	 * 
	 */
	public File fileChooser() {
		JFileChooser filechooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel File", "xlsx", "excel");
		filechooser.setAcceptAllFileFilterUsed(false);
		filechooser.setFileFilter(filter);
		filechooser.showOpenDialog(null);
		File excelfile = filechooser.getSelectedFile();
		return excelfile;

	}
	
	/**
	 * Método para retornar o número de linhas total do projeto
	 * 
	 * @author Bernardo Marques
	 */
	public int getNumberLOC() {
		DataFormatter dataFormatter = new DataFormatter();
		Row r = sheet.getRow(1);
		String s = dataFormatter.formatCellValue(r.getCell(5));
		numberLOC=Integer.parseInt(s);
		for(int i=0; i<sheet.getLastRowNum()-1; i++){
			Row row = sheet.getRow(i);
			Row nextRow = sheet.getRow(i+1);
			String pack = dataFormatter.formatCellValue(row.getCell(5));
			String nextPack = dataFormatter.formatCellValue(nextRow.getCell(5));
			if(!pack.equals(nextPack)){
				int x = Integer.parseInt(nextPack);
				numberLOC=numberLOC+x;
			}
		}
		return numberLOC;
	}
	
	/**
	 * Método para retornar o número de packages total
	 * @author Bernardo Marques
	 */
	public int getNumberPackages() {
		DataFormatter dataFormatter = new DataFormatter();
		for(int i=0; i<sheet.getLastRowNum()-1; i++){
			Row row = sheet.getRow(i);
			Row nextRow = sheet.getRow(i+1);
			String pack = dataFormatter.formatCellValue(row.getCell(1));
			String nextPack = dataFormatter.formatCellValue(nextRow.getCell(1));
			if(!(pack.equals(nextPack))) numberP++;
		}
		System.out.println(numberP);
		return numberP;
	}
	
	public ArrayList<Metodo> getListaMetodo() {
		return metodos;
	}

}