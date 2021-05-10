/**
 * 
 */
package com.iscte.ProjetoES.Historico;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author jalve
 *
 */
public class LeitorRegrasGuardadasTest {

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
	 * Test method for {@link com.iscte.ProjetoES.Historico.LeitorRegrasGuardadas#LeitorRegrasGuardadas(java.lang.String)}.
	 */
	@Test
	public final void testLeitorRegrasGuardadas() {
	LeitorRegrasGuardadas lrg = new LeitorRegrasGuardadas("O");

	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Historico.LeitorRegrasGuardadas#lineReaderFile()}.
	 */
	@Test
	public final void testLineReaderFile() {
		LeitorRegrasGuardadas lrg = new LeitorRegrasGuardadas("O");
		lrg.lineReaderFile();
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Historico.LeitorRegrasGuardadas#RuleExists(java.lang.String)}.
	 */
	@Test
	public final void testRuleExists() {
		LeitorRegrasGuardadas lrg = new LeitorRegrasGuardadas("O");
		lrg.RuleExists("a");
		
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Historico.LeitorRegrasGuardadas#EditText(java.lang.String, java.util.ArrayList, java.util.ArrayList)}.
	 */
	@Test
	public final void testEditText() {
		LeitorRegrasGuardadas lrg = new LeitorRegrasGuardadas("O");
		ArrayList<String> a = new ArrayList<String>();
		lrg.EditText("a", a, a);
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Historico.LeitorRegrasGuardadas#getRule(java.lang.String, java.util.ArrayList, java.util.ArrayList)}.
	 */
	@Test
	public final void testGetRule() {
//		LeitorRegrasGuardadas lrg = new LeitorRegrasGuardadas("O");
//		ArrayList<String> a = new ArrayList<String>();
//		assertEquals(lrg.getRule("o", a, a), lrg.getRule("o", a, a));
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Historico.LeitorRegrasGuardadas#getSavedRuleNames()}.
	 */
	@Test
	public final void testGetSavedRuleNames() {
		LeitorRegrasGuardadas lrg = new LeitorRegrasGuardadas("O");
		ArrayList<String> a = new ArrayList<String>();
		assertEquals(lrg.getSavedRuleNames(),lrg.getSavedRuleNames());
	}

}
