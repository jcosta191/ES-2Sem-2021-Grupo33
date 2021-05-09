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

	/**
	 * 
	 */
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
	 * @return um ArrayList que contém todos os metodos presentes no ficheiro excel
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
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

	public int getNumberPackages() {
		return numberP;
	}

	public void setNumberPackage(int a) {
		numberP = a;

	}

	public void setNumberLOC(int a) {
		numberLOC = a;

	}

	public int getNumberLOC() {
		return numberLOC;
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

	/**
	 * 
	 * @return a Instance of this class
	 */
	public static LeitorExcel getInstance() {
		if (INSTANCE == null)
			INSTANCE = new LeitorExcel();
		return INSTANCE;
	}

	/**
	 * 
	 * @return a new Instance of this class
	 */
	public static LeitorExcel newInstance() {
		INSTANCE = new LeitorExcel();
		return INSTANCE;
	}

	/**
	 * Abre um seletor de ficheiros para o utilizador poder abrir um ficheiro do
	 * tipo Excel
	 * 
	 * @return o ficheiro selecionado pelo utilizador (null se não foi selecionado
	 *         nenhum)
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
	 * Adiciona o ficheiro do tipo excel diretamente do diretorio a fim de uso para
	 * testes
	 */
	public void setFile(boolean s) {
		File f = null;
		if (s) {
			f = new File(System.getProperty("user.dir") + "/Long-Method.xlsx");
		}
		Workbook workbook;
		try {
			workbook = WorkbookFactory.create(f);
			sheet = workbook.getSheetAt(0);
		} catch (NullPointerException | InvalidFormatException | IOException e) {
			System.out.println("Ficheiro não aberto!");
		}

	}

	public ArrayList<Metodo> getListaMetodo() {
		return metodos;
	}

}