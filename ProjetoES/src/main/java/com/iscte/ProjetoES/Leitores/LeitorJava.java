package com.iscte.ProjetoES.Leitores;

import java.lang.*;
import java.lang.reflect.Method;
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

import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

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

	private LeitorJava() {
	}

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

		int option = escolherJava.showOpenDialog(null);
		if (option == escolherJava.APPROVE_OPTION) {
			file = escolherJava.getSelectedFile();
			filepath = (String) file.getAbsolutePath();
			name = (String) file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1);

			listAllFiles(file);
		}

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
					System.out.print(file.getName());
					lerFicheiro(file, folder);
				}
			}
		}
	}

	private void lerFicheiro(File file, File folder) {
		// if (file.getName().endsWith(".java")) {
		String[] words=null;
		try {
			WMC_class = saberWMC_class(file);
			int count = 0;
			Scanner myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				count++;
				String data = myReader.nextLine();
				words = data.split(" ");
				if (words.length > 0 && count == 1) {
					Package = words[1].replace(";", "");
				}
				Classe = file.getName().replace(".java", "");
				cls = Class.forName(Package + "." + Classe);
				NOM_class = cls.getDeclaredMethods().length;
				for (int i = 0; i <= words.length - 1; i++) {
					System.out.println(words[i]);
					if (words[i].contains("if") || words[i].contains("for") || words[i].contains("case")
							|| words[i].contains("while")) {
						CYCLO_method++;
					}

				}
			}
			// System.out.println("File name: " + met.getClasse());
			for (Method a : cls.getDeclaredMethods()) {

				method = a.getName();
				MethodID++;
				LOC_method = saberLOC_method(a, file);
				
				Metodo met = new Metodo(MethodID, Package, Classe, method, NOM_class, count, WMC_class, LOC_method,
						CYCLO_method);
				EscritorExcel.adicionaLista(met);

			}

			try {
				EscritorExcel.escreverExcel(folder.getName());
			} catch (InvalidFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			myReader.close();

		} catch (FileNotFoundException | ClassNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public int saberLOC_method(Method a, File b) throws FileNotFoundException {
		Scanner myReader = new Scanner(b);
		int LOC_method1 = 0;
		boolean ativadoContarLOC = false;
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			String[] words = data.split(" ");
			
			if ((data.contains("public") || data.contains("private") || data.contains("protected")) && (!data.contains("class") && !data.contains(";") && data.contains("{") && data.contains(a.getName()))) {
				ativadoContarLOC = true;
				System.out.println(data + " " + ativadoContarLOC);
			}
			
			if ((data.contains("public") || data.contains("private") || data.contains("private")) && ((data.contains(";") || data.contains("{")) && !data.contains(a.getName()))) {
				ativadoContarLOC = false;
				System.out.println(data + " " + ativadoContarLOC);
			}
			
			if ((data.contains("public") || data.contains("private") || data.contains("private")) && (data.contains(";") && !data.contains("{") && !data.contains(a.getName()))) {
				ativadoContarLOC = false;
				System.out.println(data + " " + ativadoContarLOC);
			}
			
			if (ativadoContarLOC == true) {
				LOC_method1++;
			}
		}
		myReader.close();
		return LOC_method1-1>0?LOC_method1-1:0;
	}
	
	public int saberWMC_class(File b) throws FileNotFoundException {
		Scanner myReader = new Scanner(b);
		int cyclo_methods = 0;
		boolean ativadoContarLOC = false;
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
				if ((data.contains("private") || data.contains("public")) && !data.contains(";") && !data.contains("=") 
						&& !data.contains("class") && data.contains("(")){
					cyclo_methods++;
				}
				if ((data.contains("while") || data.contains("else") || data.contains("for") || data.contains("if"))
						&& !data.endsWith(";")) {
					cyclo_methods++;
				}
		}
		myReader.close();
		System.out.println("The class has a complexity of " + cyclo_methods + ".");
		return cyclo_methods;
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