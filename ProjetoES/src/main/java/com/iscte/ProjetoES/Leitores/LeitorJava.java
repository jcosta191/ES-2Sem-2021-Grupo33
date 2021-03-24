package com.iscte.ProjetoES.Leitores;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class LeitorJava extends AbstractTableModel {
	private static final long serialVersionUID = -4220550076295049347L;
	private static LeitorJava INSTANCIA;
	private Sheet java;

	private LeitorJava() {
	}

	public void abrirJava() {
		Workbook workbook;
		try {
			workbook = WorkbookFactory.create(escolherJava());
			java = workbook.getSheetAt(0);
		} catch (NullPointerException | InvalidFormatException | IOException e) {
			System.out.println("Não foi possível abrir o ficheiro!");
			System.exit(0);
		}
	}


	
	public static LeitorJava getInstance() {
		if (INSTANCIA == null)
			INSTANCIA = new LeitorJava();
		return INSTANCIA;
	}

	public static LeitorJava newInstance() {
		INSTANCIA = new LeitorJava();
		return INSTANCIA;
	}

	public File escolherJava() {
		JFileChooser escolherJava = new JFileChooser();
	    escolherJava.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		/*FileNameExtensionFilter filter = new FileNameExtensionFilter("Ficheiro Excel", "xlsx", "excel");*/
		escolherJava.setAcceptAllFileFilterUsed(false);
		/*escolherJava.setFileFilter(filter);*/
		escolherJava.showOpenDialog(null);
		File java = escolherJava.getSelectedFile();
		return java;
		
		
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
