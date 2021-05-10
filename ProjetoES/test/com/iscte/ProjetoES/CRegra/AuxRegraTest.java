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
public class AuxRegraTest {

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
	 * Test method for {@link com.iscte.ProjetoES.CRegra.AuxRegra#AuxRegra(int, int)}.
	 */
	@Test
	public final void testAuxRegra() {
		AuxRegra aux = new AuxRegra(1,20);
		assertEquals(aux, aux);

	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CRegra.AuxRegra#getNomeMetrica()}.
	 */
	@Test
	public final void testGetNomeMetrica() {
		AuxRegra aux = new AuxRegra(1,20);
		assertEquals(aux.getNomeMetrica(), aux.getNomeMetrica());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CRegra.AuxRegra#getLimite()}.
	 */
	@Test
	public final void testGetLimite() {
		AuxRegra aux = new AuxRegra(1,20);
		assertEquals(aux.getLimite(), aux.getLimite());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CRegra.AuxRegra#getResultadoMetrica()}.
	 */
	@Test
	public final void testGetResultadoMetrica() {
		AuxRegra aux = new AuxRegra(1,20);
		assertEquals(aux.getResultadoMetrica(), aux.getResultadoMetrica());
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CRegra.AuxRegra#setNomeMetrica(java.lang.String)}.
	 */
	@Test
	public final void testSetNomeMetrica() {
		AuxRegra aux = new AuxRegra(1,20);
		aux.setNomeMetrica("test");
		assertEquals(aux.getNomeMetrica(), "test");
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CRegra.AuxRegra#setLimite(int)}.
	 */
	@Test
	public final void testSetLimite() {
		AuxRegra aux = new AuxRegra(1,20);
		aux.setLimite(1);
		assertEquals(aux.getLimite(), 1);
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CRegra.AuxRegra#setResultadoMetrica(int)}.
	 */
	@Test
	public final void testSetResultadoMetrica() {
		AuxRegra aux = new AuxRegra(1,20);
		aux.setResultadoMetrica(2);
		assertEquals(aux.getResultadoMetrica(), 2);
	}

}
