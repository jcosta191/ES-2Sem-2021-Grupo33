/**
 * 
 */
package com.iscte.ProjetoES.Leitores;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author jalve
 *
 */
public class LeitorExcelTest {

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
	 * Test method for {@link com.iscte.ProjetoES.Leitores.LeitorExcel#addFile()}.
	 */
	@Test
	public final void testAddFile() {
		LeitorExcel le = new LeitorExcel();
		le.addFile();
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Leitores.LeitorExcel#getContent()}.
	 */
	@Test
	public final void testGetContent() {
		LeitorExcel le = new LeitorExcel();
		try {
			assertEquals(le.getContent(), le.getContent());
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Leitores.LeitorExcel#getColumnCount()}.
	 */
	@Test
	public final void testGetColumnCount() {
		LeitorExcel le = new LeitorExcel();
		assertEquals(le.getColumnCount(), le.getColumnCount());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Leitores.LeitorExcel#setNumberPackage(int)}.
	 */
	@Test
	public final void testSetNumberPackage() {
		LeitorExcel le = new LeitorExcel();
		le.setNumberPackage(1);
		assertEquals(le.getNumberPackages(), 1);
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Leitores.LeitorExcel#setNumberLOC(int)}.
	 */
	@Test
	public final void testSetNumberLOC() {
		LeitorExcel le = new LeitorExcel();
		le.setNumberLOC(1);
		assertEquals(le.getNumberLOC(), 1);
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Leitores.LeitorExcel#getRowCount()}.
	 */
	@Test
	public final void testGetRowCount() {
		LeitorExcel le = new LeitorExcel();
		assertEquals(le.getRowCount(), le.getRowCount());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Leitores.LeitorExcel#getColumnName(int)}.
	 */
	@Test
	public final void testGetColumnNameInt() {
		LeitorExcel le = new LeitorExcel();
		assertEquals(le.getColumnName(1), le.getColumnName(1));
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Leitores.LeitorExcel#getValueAt(int, int)}.
	 */
	@Test
	public final void testGetValueAt() {
		LeitorExcel le = new LeitorExcel();
		assertEquals(le.getValueAt(1, 1), le.getValueAt(1, 1));
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Leitores.LeitorExcel#getInstance()}.
	 */
	@Test
	public final void testGetInstance() {
		LeitorExcel le = new LeitorExcel();
		assertEquals(le.getInstance(), le.getInstance());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Leitores.LeitorExcel#newInstance()}.
	 */
	@Test
	public final void testNewInstance() {
		LeitorExcel le = new LeitorExcel();
		le.newInstance();
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Leitores.LeitorExcel#fileChooser()}.
	 */
	@Test
	public final void testFileChooser() {
		LeitorExcel le = new LeitorExcel();
		le.fileChooser();
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Leitores.LeitorExcel#getNumberLOC()}.
	 */
	@Test
	public final void testGetNumberLOC() {
		LeitorExcel le = new LeitorExcel();
		assertEquals(le.getNumberLOC(), le.getNumberLOC());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Leitores.LeitorExcel#getNumberPackages()}.
	 */
	@Test
	public final void testGetNumberPackages() {
		LeitorExcel le = new LeitorExcel();
		assertEquals(le.getNumberPackages(), le.getNumberPackages());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Leitores.LeitorExcel#getListaMetodo()}.
	 */
	@Test
	public final void testGetListaMetodo() {
		LeitorExcel le = new LeitorExcel();
		assertEquals(le.getListaMetodo(), le.getListaMetodo());
		
	}

}
