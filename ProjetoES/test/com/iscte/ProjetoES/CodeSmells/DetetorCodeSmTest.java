/**
 * 
 */
package com.iscte.ProjetoES.CodeSmells;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.iscte.ProjetoES.Metodo;

/**
 * @author jalve
 *
 */
public class DetetorCodeSmTest {

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
	 * Test method for {@link com.iscte.ProjetoES.CodeSmells.DetetorCodeSm#setWorkbookread2(org.apache.poi.xssf.usermodel.XSSFWorkbook)}.
	 */
	@Test
	public final void testSetWorkbookread2() {
		DetetorCodeSm dsm = new DetetorCodeSm();
		dsm.setWorkbookread2(null);
		assertEquals(dsm.getWorkbookread2(), null);
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CodeSmells.DetetorCodeSm#setTableLongMethod(javax.swing.JTable)}.
	 */
	@Test
	public final void testSetTableLongMethod() {
		DetetorCodeSm dsm = new DetetorCodeSm();
		dsm.setTableLongMethod(null);
		assertEquals(dsm.getTableLongMethod(), null);
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CodeSmells.DetetorCodeSm#setTableGodClass(javax.swing.JTable)}.
	 */
	@Test
	public final void testSetTableGodClass() {
		DetetorCodeSm dsm = new DetetorCodeSm();
		dsm.setTableLongMethod(null);
		assertEquals(dsm.getTableLongMethod(), null);
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CodeSmells.DetetorCodeSm#getTableLongMethod()}.
	 */
	@Test
	public final void testGetTableLongMethod() {
		DetetorCodeSm dsm = new DetetorCodeSm();
		assertEquals(dsm.getTableLongMethod(), dsm.getTableLongMethod());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CodeSmells.DetetorCodeSm#getWorkbookread2()}.
	 */
	@Test
	public final void testGetWorkbookread2() {
		DetetorCodeSm dsm = new DetetorCodeSm();
		assertEquals(dsm.getWorkbookread2(), dsm.getWorkbookread2());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CodeSmells.DetetorCodeSm#getTableGodClass()}.
	 */
	@Test
	public final void testGetTableGodClass() {
		DetetorCodeSm dsm = new DetetorCodeSm();
		assertEquals(dsm.getTableGodClass(), dsm.getTableGodClass());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CodeSmells.DetetorCodeSm#detetorLM(java.lang.String, java.lang.String, int, int, java.lang.String)}.
	 */
	@Test
	public final void testDetetorLM() {
		DetetorCodeSm dsm = new DetetorCodeSm();
		try {
			dsm.detetorLM("o", "o", 1, 1, "o");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CodeSmells.DetetorCodeSm#detetorGC(java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String)}.
	 */
	@Test
	public final void testDetetorGC() {
		DetetorCodeSm dsm = new DetetorCodeSm();
		try {
			dsm.detetorGC("o", "o","o", 1, 1, "o");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
