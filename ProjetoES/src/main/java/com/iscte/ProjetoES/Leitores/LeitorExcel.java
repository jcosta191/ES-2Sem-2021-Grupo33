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

public class LeitorExcel  extends AbstractTableModel {
	private static final long serialVersionUID = -4220550076295049347L;
	private static LeitorExcel INSTANCIA;
	private Sheet excel;

	private LeitorExcel() {
	}

	public void abrirExcel() {
		Workbook workbook;
		try {
			workbook = WorkbookFactory.create(escolherExcel());
			excel = workbook.getSheetAt(0);
		} catch (NullPointerException | InvalidFormatException | IOException e) {
			System.out.println("Não foi possível abrir o ficheiro!");
			System.exit(0);
		}
	}

	/*REVEEEEERRR
	 * public ArrayList<Metodo> puxarExcel() throws EncryptedDocumentException, InvalidFormatException, IOException {

		ArrayList<Metodo> metodos = new ArrayList<Metodo>();
		if (excel != null) {
			DataFormatter dataFormatter = new DataFormatter();

			int j = 1;
			while (j <= excel.getLastRowNum()) {
				Row linha = excel.getRow(j);
				int methodID = (int) linha.getCell(0).getNumericCellValue();
				String Package = dataFormatter.formatCellValue(linha.getCell(1));
				String Class = dataFormatter.formatCellValue(linha.getCell(2));
				String method = dataFormatter.formatCellValue(linha.getCell(3));
				int NOM_class = (int) linha.getCell(4).getNumericCellValue();
				int LOC_class = (int) linha.getCell(5).getNumericCellValue();
				int WMC_class = (int) linha.getCell(6).getNumericCellValue();
				boolean is_God_Class = (boolean) linha.getCell(7).getBooleanCellValue();
				int LOC_method = (int) linha.getCell(8).getNumericCellValue();
				int CYCLO_method = (int) linha.getCell(9).getNumericCellValue();
				boolean is_Long_Method = (boolean) linha.getCell(10).getBooleanCellValue();
				Metodo met = new Metodo(methodID, Package, Class, method, NOM_class, LOC_class, WMC_class, is_God_Class, LOC_method, CYCLO_method, is_Long_Method);
				metodos.add(met);
				j++;
			}
		}
		return metodos;
	}*/

	@Override
	public int getColumnCount() {
		if (excel != null) {
			int last_cell = excel.getRow(0).getLastCellNum();
			return last_cell;
		} else {
			return 0;
		}
	}

	@Override
	public int getRowCount() {
		if (excel != null) {
			return excel.getLastRowNum();
		} else {
			return 0;
		}
	}

	@Override
	public String getColumnName(int arg0) {
		if (excel != null) {
			Cell cell = excel.getRow(0).getCell(arg0);
			return cell.getStringCellValue();
		} else {
			return "";
		}
	}

	/*MUDAR E REVER*/
	@Override
	public Object getValueAt(int arg0, int arg1) {
		if (excel != null) {
			Cell cell = excel.getRow(arg0).getCell(arg1);

			switch (arg1) {
			case 0:
				return (int) cell.getNumericCellValue();
			case 1:
				return cell.getStringCellValue();

			case 2:
				return cell.getStringCellValue();

			case 3:
				return cell.getStringCellValue();
			case 4:
				return (int) cell.getNumericCellValue();
			case 5:
				return (int) cell.getNumericCellValue();
			case 6:
				return (int) cell.getNumericCellValue();
			case 7:
				return (int) cell.getNumericCellValue();
			default:
				return (int) cell.getNumericCellValue();


			}
		} else {
			return "";
		}

	}

	
	public static LeitorExcel getInstance() {
		if (INSTANCIA == null)
			INSTANCIA = new LeitorExcel();
		return INSTANCIA;
	}

	public static LeitorExcel newInstance() {
		INSTANCIA = new LeitorExcel();
		return INSTANCIA;
	}

	public File escolherExcel() {
		JFileChooser escolherExcel = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Ficheiro Excel", "xlsx", "excel");
		escolherExcel.setAcceptAllFileFilterUsed(false);
		escolherExcel.setFileFilter(filter);
		escolherExcel.showOpenDialog(null);
		File excel = escolherExcel.getSelectedFile();
		return excel;
		
		
	}
}
