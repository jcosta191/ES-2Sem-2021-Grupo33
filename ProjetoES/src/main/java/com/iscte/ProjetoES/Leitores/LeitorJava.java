package com.iscte.ProjetoES.Leitores;

import java.lang.*;
import java.lang.reflect.Method;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
import com.iscte.ProjetoES.Gui.GUI;

/**
 * Classe que representa o leitor dos ficheiros Java
 * 
 * @author jcosta191
 *
 */
public class LeitorJava extends AbstractTableModel {
	private static final long serialVersionUID = -4220550076295049347L;
	private static LeitorJava INSTANCIA;
	private int MethodID, NOM_class, WMC_class, LOC_method, CYCLO_method;
	private String Package, Classe, method;
	private String filepath, name;
	private File file;
	private Class cls;

	private LeitorJava() {
	}

	/**
	 * Classe que abre o escolherJava
	 *
	 */
	public void abrirJava() {
		escolherJava();
	}

	/**
	 * Cria a instancia
	 *
	 */
	public static LeitorJava getInstance() {
		if (INSTANCIA == null)
			INSTANCIA = new LeitorJava();
		return INSTANCIA;
	}

	/**
	 * Classe que abre o filechooser e retorna os files javas
	 *
	 */
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

	/**
	 * Classe que vai percorrer os files Java e faz a seleção
	 *
	 */
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

	/**
	 * Classe que vai ler os ficheiros e preencher as colunas do excel
	 *
	 */
	private void lerFicheiro(File file, File folder) {
		// if (file.getName().endsWith(".java")) {
		String[] words = null;
		ArrayList<String> data1 = new ArrayList<String>();
		try {
			WMC_class = saberWMC_class(file);
			int count = 0;
			Scanner myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				count++;
				String data = myReader.nextLine();
				data1.add(data);
				words = data.split(" ");
				if (words.length > 0 && count == 1) {
					Package = words[1].replace(";", "");
				}
				Classe = file.getName().replace(".java", "");
				cls = Class.forName(Package + "." + Classe);
				NOM_class = cls.getDeclaredMethods().length;
			}
			for (Method a : cls.getDeclaredMethods()) {
				method = a.getName();
				LOC_method = saberLOC_method(a, file);

				MethodID++;
				Metodo met = new Metodo(MethodID, Package, Classe, method, NOM_class, count, WMC_class, LOC_method,
						CYCLO_method);
				EscritorExcel.adicionaLista(met);
			}
			try {
				EscritorExcel.escreverExcel(folder.getName());
				GUI.setLocation(folder.getName());
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

	/**
	 * Classe que vai poder saber o LOC_METHOD
	 *
	 */
	public int saberLOC_method(Method a, File b) throws FileNotFoundException {
		Scanner myReader = new Scanner(b);
		int LOC_method1 = 0;

		int CYCLO_method1 = 0;
		boolean ativadoContarLOC = false;
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			String[] words = data.split(" ");

			if ((data.contains("public") || data.contains("private") || data.contains("protected"))
					&& (!data.contains("class") && !data.contains(";") && data.contains("{")
							&& data.contains(a.getName()))) {
				ativadoContarLOC = true;
			}

			if ((data.contains("public") || data.contains("private") || data.contains("private"))
					&& ((data.contains(";") || data.contains("{")) && !data.contains(a.getName()))) {
				ativadoContarLOC = false;
				// System.out.println(data + " " + ativadoContarLOC);
			}

			if ((data.contains("public") || data.contains("private") || data.contains("private"))
					&& (data.contains(";") && !data.contains("{") && !data.contains(a.getName()))) {
				ativadoContarLOC = false;
				// System.out.println(data + " " + ativadoContarLOC);
			}

			if (ativadoContarLOC == true) {
				LOC_method1++;
				if (saberCYCLO(data)) {
					CYCLO_method1++;
					System.out.println(CYCLO_method1);

				}
				setCYCLO(CYCLO_method1);

			}
		}
		myReader.close();
		return LOC_method1 - 1 > 0 ? LOC_method1 - 1 : 0;
	}

	/**
	 *
	 * Classe que poder saber o WMC_class
	 *
	 */
	public int saberWMC_class(File b) throws FileNotFoundException {
		Scanner myReader = new Scanner(b);
		int cyclo_methods = 0;
		boolean ativadoContarLOC = false;
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			if ((data.contains("private") || data.contains("public")) && !data.contains(";") && !data.contains("=")
					&& !data.contains("class") && data.contains("(")) {
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

	/**
	 * Classe que vai poder saber se é CYCLO com boolean para depois ser usado no saber_LOCmethod
	 *
	 */
	public boolean saberCYCLO(String words) throws FileNotFoundException {
		// boolean ativadoContarLinhas = false;
		// String newStr = words[i].substring(0, words[i].indexOf("("));
		Pattern pattern = Pattern.compile(
				"(\\&\\&|\\|\\|)|((^| +|\\}|\\;|\t)((if|for|while|catch)( +|\\()))|(\\?.*\\:)|((\t|^|\\;|\\{\\})(case +|continue;))",
				Pattern.MULTILINE);
		String cleanText = words.replaceAll("\\/\\/(.*)|\\/\\*([\\s\\S]*?)\\*\\/", "");
		System.out.println(cleanText);
		Matcher matcher = pattern.matcher(cleanText);

		while (matcher.find()) {
			return true; // setCYCLO(CYCLO_method);
		}
		return false;
	}

	/**
	 * Classe que vai dar set ao CYCLO_method declarado em cima
	 *
	 */
	public void setCYCLO(int a) {
		// TODO Auto-generated method stub
		CYCLO_method = a;
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