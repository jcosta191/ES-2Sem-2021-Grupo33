/**
 * 
 */
package com.iscte.ProjetoES.Historico;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author jalve
 *
 */
public class SaverTest {

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
	 * Test method for {@link com.iscte.ProjetoES.Historico.Saver#Saver()}.
	 */
	@Test
	public final void testSaver() {
		Saver save = new Saver();
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Historico.Saver#createFile()}.
	 */
	@Test
	public final void testCreateFile() {
		Saver save = new Saver();
		try {
			save.createFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Historico.Saver#writeRule(java.util.ArrayList, java.lang.String)}.
	 */
	@Test
	public final void testWriteRule() {
		Saver save = new Saver();
		ArrayList<String> a = new ArrayList<String>();
		try {
			save.writeRule(a, "OLA");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.Historico.Saver#EditRule(java.util.ArrayList, java.lang.String)}.
	 */
	@Test
	public final void testEditRule() {
		ArrayList<String> a = new ArrayList<String>();
		Saver save = new Saver();
		try {
			save.EditRule(a, "OLA");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
