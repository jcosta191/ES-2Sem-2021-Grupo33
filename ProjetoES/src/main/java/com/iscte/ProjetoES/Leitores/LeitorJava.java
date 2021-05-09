package com.iscte.ProjetoES.Leitores;

import java.lang.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.iscte.ProjetoES.Metodo;
import com.iscte.ProjetoES.Escritores.EscritorExcel;

public class LeitorJava extends AbstractTableModel {
	private static final long serialVersionUID = -4220550076295049347L;
	private static LeitorJava INSTANCIA;
	private Sheet java;
	private int MethodID, NOM_class, LOC_class, WMC_class, LOC_method, CYCLO_method;
	private String Package, Classe, method;
	private String filepath;
	private String name;
	private File file;
	private Class cls;

	public void abrirJava() {
		Workbook workbook;

		escolherJava();
		// try {
		// workbook = WorkbookFactory.create(escolherJava());
		// java = workbook.getSheetAt(0);
		// } catch (NullPointerException | InvalidFormatException | IOException e) {
//			System.out.println("Não foi possível abrir o ficheiro!" + e);
//			System.exit(0);
//		}
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
		
		int opcaoEscolhida = escolherJava.showOpenDialog(null);
        if(opcaoEscolhida == escolherJava.APPROVE_OPTION){
           file = escolherJava.getSelectedFile();
           filepath =  (String) file.getAbsolutePath();
           name = (String) file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\")+1);
          
           listAllFiles(file);
        }

		System.out.println("List of files and directories in the specified directory:" + file.getName());
		
		return file;

		int opcaoEscolhida = escolherJava.showOpenDialog(null);
		if (opcaoEscolhida == escolherJava.APPROVE_OPTION) {
			file = escolherJava.getSelectedFile();
			filepath = (String) file.getAbsolutePath();
			name = (String) file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1);

	}

	private void lerFicheiro(File file) {
			if (file.getName().endsWith(".java")) {
				try {
					/*Class cls = Class.forName(Classe);
					NOM_class= cls.getDeclaredMethods().length;*/
					int count = 0;
					Scanner myReader = new Scanner(file);
					while (myReader.hasNextLine()) {
						count++;
						String data = myReader.nextLine();
						LOC_class++;
						String[] words = data.split(" ");
						Classe = file.getName().replace(".java","");
						if (count == 1 && words.length > 0) {
							if (words[0] == "package") {
								Package = words[1];
							}
						}

			listAllFiles(file);
		}

						
						
						if(procurarCYCLO("for",data) || procurarCYCLO("if",data) || procurarCYCLO("case",data) || procurarCYCLO("while",data)) {
							CYCLO_method++;
						}
						
						
						
						if (data.isEmpty()) {
//							if (data.isBlank()) {
							LOC_class--;
						}
						Metodo met = new Metodo(MethodID, Package, Classe, method, NOM_class, LOC_class, WMC_class,
								LOC_method, CYCLO_method);
						EscritorExcel.adicionaLista(met);

		System.out.println("List of files and directories in the specified directory:" + file.getName());

		return file;

	}

	public void listAllFiles(File folder) {
		File[] fileNames = folder.listFiles();

		for (File file : fileNames) {
			if (file.isDirectory()) {
				// Caso identifique que é uma subpasta lança outra vez o ListAllFiles
				listAllFiles(file);
			} else {
				if (file.getName().endsWith("java")) {
					lerFicheiro(file, folder);
				}
			}
		}
	}

	private void lerFicheiro(File file, File folder) {
		// if (file.getName().endsWith(".java")) {
		try {

			int count = 0;
			Scanner myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				count++;
				String data = myReader.nextLine();
				LOC_class++;
				String[] words = data.split(" ");
				if (count == 1 && words.length > 0) {
					if (words[0] == "package") {
						Package = words[1];
						Classe = file.getName().replace(".java", "");

						cls = Class.forName(Package + Classe);
						NOM_class = cls.getDeclaredMethods().length;
					}
				}

				if (procurarCYCLO("for", data) || procurarCYCLO("if", data) || procurarCYCLO("case", data)
						|| procurarCYCLO("while", data)) {
					CYCLO_method++;
				}

				for (int i = 0; i <= NOM_class; i++) {

					//if (myReader.hasNext(cls.getDeclaredMethods()[i].getName().replace("(", "")));
					//MethodID++;
				}

				if (data.isEmpty()) {
					//	if (data.isBlank()) {
					LOC_class--;
				}

				Metodo met = new Metodo(MethodID, Package, Classe, method, NOM_class, LOC_class, WMC_class, LOC_method,
						CYCLO_method);
				EscritorExcel.adicionaLista(met);
				try {
					EscritorExcel.escreverExcel(folder.getName());
				} catch (InvalidFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				/*
				 * System.out.println("File name: "+file.getName());
				 * System.out.println("File path: "+file.getAbsolutePath());
				 * System.out.println("Size :"+file.getTotalSpace()); System.out.println(" ");
				 */
			}
				System.out.println("File name: " + met.getClasse());

			}
			myReader.close();
			
		} catch (FileNotFoundException | ClassNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		/*
		 * System.out.println("File name: "+file.getName());
		 * System.out.println("File path: "+file.getAbsolutePath());
		 * System.out.println("Size :"+file.getTotalSpace()); System.out.println(" ");
		 */
		// }
	}

	public boolean procurarCYCLO(String a, String b) {
		Pattern p = Pattern.compile(a);
		Matcher m = p.matcher(b);
		if (m.find()) {
			return true;
		}
		return false;

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