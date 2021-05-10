package com.iscte.ProjetoES.Leitores;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.iscte.ProjetoES.Metodo;

public class LeitorJavaTest {

	@Test
	public final void testAbrirJava() {
		LeitorJava aj = new LeitorJava();
		aj.abrirJava();
	}

	@Test
	public final void testGetInstance() {
		LeitorJava aj = new LeitorJava();
		assertEquals(aj.getInstance(),aj.getInstance());
	}

	@Test
	public final void testEscolherJava() {
		LeitorJava aj = new LeitorJava();
		aj.escolherJava();
	}

	@Test
	public final void testListAllFiles() {
		LeitorJava aj = new LeitorJava();
		aj.listAllFiles(null);
	}

	@Test
	public final void testSaberLOC_method() {

	}

	@Test
	public final void testSaberWMC_class() {

		
	}

	@Test
	public final void testSaberCYCLO() {

	}

	@Test
	public final void testSetCYCLO() {
		LeitorJava aj = new LeitorJava();
		aj.setCYCLO(1);
	}

	@Test
	public final void testGetRowCount() {
		LeitorJava aj = new LeitorJava();
		assertEquals(aj.getRowCount(), aj.getRowCount());
	}

	@Test
	public final void testGetColumnCount() {
		LeitorJava aj = new LeitorJava();
		assertEquals(aj.getColumnCount(), aj.getColumnCount());
	}

	@Test
	public final void testGetValueAt() {
		LeitorJava aj = new LeitorJava();
		assertEquals(aj.getValueAt(1, 1), aj.getValueAt(1, 1));
	}

}
