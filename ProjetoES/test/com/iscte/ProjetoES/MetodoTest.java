/**
 * 
 */
package com.iscte.ProjetoES;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author jalve
 *
 */
public class MetodoTest {

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
	 * Test method for {@link com.iscte.ProjetoES.Metodo#Metodo(int, java.lang.String, java.lang.String, java.lang.String, int, int, int, int, int)}.
	 */
	@Test
	public final void testMetodo() {
		Metodo met = new Metodo(1, "a", "b", "c", 1, 1,1, 1, 1);
		assertEquals(met,met);
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Metodo#getMethodID()}.
	 */
	@Test
	public final void testGetMethodID() {
		Metodo met = new Metodo(1, "a", "b", "c", 1, 1,1, 1, 1);
		assertEquals(met.getMethodID(),met.getMethodID());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Metodo#getPackage()}.
	 */
	@Test
	public final void testGetPackage() {
		Metodo met = new Metodo(1, "a", "b", "c", 1, 1,1, 1, 1);
		assertEquals(met.getPackage(),met.getPackage());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Metodo#getClasse()}.
	 */
	@Test
	public final void testGetClasse() {
		Metodo met = new Metodo(1, "a", "b", "c", 1, 1,1, 1, 1);
		assertEquals(met.getClasse(),met.getClasse());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Metodo#getMethod()}.
	 */
	@Test
	public final void testGetMethod() {
		Metodo met = new Metodo(1, "a", "b", "c", 1, 1,1, 1, 1);
		assertEquals(met.getMethod(),met.getMethod());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Metodo#getNOM_class()}.
	 */
	@Test
	public final void testGetNOM_class() {
		Metodo met = new Metodo(1, "a", "b", "c", 1, 1,1, 1, 1);
		assertEquals(met.getNOM_class(),met.getNOM_class());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Metodo#getLOC_class()}.
	 */
	@Test
	public final void testGetLOC_class() {
		Metodo met = new Metodo(1, "a", "b", "c", 1, 1,1, 1, 1);
		assertEquals(met.getLOC_class(),met.getLOC_class());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Metodo#getLOC_method()}.
	 */
	@Test
	public final void testGetLOC_method() {
		Metodo met = new Metodo(1, "a", "b", "c", 1, 1,1, 1, 1);
		assertEquals(met.getLOC_method(),met.getLOC_method());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Metodo#getCYCLO_method()}.
	 */
	@Test
	public final void testGetCYCLO_method() {
		Metodo met = new Metodo(1, "a", "b", "c", 1, 1,1, 1, 1);
		assertEquals(met.getCYCLO_method(),met.getCYCLO_method());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Metodo#getWMC_class()}.
	 */
	@Test
	public final void testGetWMC_class() {
		Metodo met = new Metodo(1, "a", "b", "c", 1, 1,1, 1, 1);
		assertEquals(met.getWMC_class(),met.getWMC_class());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Metodo#getLeituras()}.
	 */
	@Test
	public final void testGetLeituras() {
		Metodo met = new Metodo(1, "a", "b", "c", 1, 1,1, 1, 1);
		assertEquals(met.getLeituras(),met.getLeituras());
	}

}
