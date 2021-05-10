/**
 * 
 */
package com.iscte.ProjetoES.CodeSmells;

import static org.junit.Assert.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.chart.ChartPanel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author jalve
 *
 */
public class AnalizadorCodeSmTest {

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
	 * Test method for {@link com.iscte.ProjetoES.CodeSmells.AnalizadorCodeSm#createChart(org.jfree.data.general.DefaultPieDataset, java.lang.String)}.
	 */
	@Test
	public final void testCreateChartDefaultPieDatasetString() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CodeSmells.AnalizadorCodeSm#criarDataSet(int, int, int, int)}.
	 */
	@Test
	public final void testCriarDataSet() {
		DefaultPieDataset dadosGrafico = new DefaultPieDataset();
		assertEquals(dadosGrafico, dadosGrafico);

	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CodeSmells.AnalizadorCodeSm#createChart(int, int, int, int, java.lang.String)}.
	 */
	@Test
	public final void testCreateChartIntIntIntIntString() {
		AnalizadorCodeSm sm = new AnalizadorCodeSm();
		DefaultPieDataset dadosGrafico = new DefaultPieDataset();
		sm.createChart(dadosGrafico, "Olá");
	}

	/**
	 * Test method for {@link com.iscte.ProjetoES.CodeSmells.AnalizadorCodeSm#main(java.lang.String[])}.
	 */
	@Test
	public final void testMain() {
		AnalizadorCodeSm sm = new AnalizadorCodeSm();
		sm.main(null);
	}

}
