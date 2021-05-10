
package com.iscte.ProjetoES;

import com.iscte.ProjetoES.Escritores.EscritorJTable;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

/**
 * Inicia o programa
 * 
 * @author dariop
 *
 */
public class App {
	public static void main(String[] args) throws IOException, InvalidFormatException {
		EscritorJTable a = new EscritorJTable();
		a.openFile();
	}
}
