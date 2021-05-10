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

/**
 * @author jalve
 *
 */
public class EscritorJTableTest {

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
	 * Test method for {@link com.iscte.ProjetoES.Escritores.EscritorJTable#EscritorJTable()}.
	 */
	@Test
	public final void testEscritorJTable() {
		EscritorJTable ejt = new EscritorJTable();
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Escritores.EscritorJTable#initMenus()}.
	 */
	@Test
	public final void testInitMenus() {
		EscritorJTable ejt = new EscritorJTable();
		ejt.initMenus();
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Escritores.EscritorJTable#openFile()}.
	 */
	@Test
	public final void testOpenFile() {
		EscritorJTable ejt = new EscritorJTable();
		try {
			ejt.openFile();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Escritores.EscritorJTable#getTable()}.
	 */
	@Test
	public final void testGetTable() {
		EscritorJTable ejt = new EscritorJTable();
		assertEquals(ejt.getTable(), ejt.getTable());
		}

}
