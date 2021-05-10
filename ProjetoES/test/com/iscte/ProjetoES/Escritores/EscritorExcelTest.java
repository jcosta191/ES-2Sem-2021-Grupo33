/**
 * 
 */
package com.iscte.ProjetoES.Escritores;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.iscte.ProjetoES.Metodo;

/**
 * @author jalve
 *
 */
public class EscritorExcelTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Escritores.EscritorExcel#escreverExcel(java.lang.String)}.
	 */
	@Test
	public final void testEscreverExcel() {
		EscritorExcel ee = new EscritorExcel();
		try {
			ee.escreverExcel("a");
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Escritores.EscritorExcel#adicionaLista(com.iscte.ProjetoES.Metodo)}.
	 */
	@Test
	public final void testAdicionaLista() {
		EscritorExcel ee = new EscritorExcel();
		ee.adicionaLista(new Metodo(1, "a", "b", "c", 1, 1,1, 1, 1));
	}

}
