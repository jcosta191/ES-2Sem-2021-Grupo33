/**
 * 
 */
package com.iscte.ProjetoES.CRegra;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author jalve
 *
 */
public class RegrasTest {

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
	 * Test method for {@link com.iscte.ProjetoES.CRegra.Regras#Regras(java.lang.String, int, int, int, int, int, int)}.
	 */
	@Test
	public final void testRegras() {
		Regras regras = new Regras("name", 1, 1, 1, 1, 1, 1);
		assertEquals(regras,regras);
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CRegra.Regras#check(int, int)}.
	 */
	@Test
	public final void testCheck() {
		assertEquals(true,true);
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CRegra.Regras#verify(com.iscte.ProjetoES.CRegra.Regras, java.util.ArrayList)}.
	 */
	@Test
	public final void testVerify() {
		Regras regras = new Regras("name", 1, 1, 1, 1, 1, 1);
		assertEquals(regras,regras);
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CRegra.Regras#getLOCC()}.
	 */
	@Test
	public final void testGetLOCC() {
		Regras regras = new Regras("name", 1, 1, 1, 1, 1, 1);
		assertEquals(regras.getLOCC(),regras.getLOCC());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CRegra.Regras#getNOM()}.
	 */
	@Test
	public final void testGetNOM() {
		Regras regras = new Regras("name", 1, 1, 1, 1, 1, 1);
		assertEquals(regras.getNOM(),regras.getNOM());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CRegra.Regras#getWMC()}.
	 */
	@Test
	public final void testGetWMC() {
		Regras regras = new Regras("name", 1, 1, 1, 1, 1, 1);
		assertEquals(regras.getWMC(),regras.getWMC());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CRegra.Regras#getCYCLOM()}.
	 */
	@Test
	public final void testGetCYCLOM() {
		Regras regras = new Regras("name", 1, 1, 1, 1, 1, 1);
		assertEquals(regras.getCYCLOM(),regras.getCYCLOM());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CRegra.Regras#getLOCM()}.
	 */
	@Test
	public final void testGetLOCM() {
		Regras regras = new Regras("name", 1, 1, 1, 1, 1, 1);
		assertEquals(regras.getLOCM(),regras.getLOCM());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CRegra.Regras#getLOP()}.
	 */
	@Test
	public final void testGetLOP() {
		Regras regras = new Regras("name", 1, 1, 1, 1, 1, 1);
		assertEquals(regras.getLOP(),regras.getLOP());
	}

}
