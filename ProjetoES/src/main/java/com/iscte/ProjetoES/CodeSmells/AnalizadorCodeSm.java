package com.iscte.ProjetoES.CodeSmells;

import javax.swing.JFrame;
import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.BorderFactory;
import java.awt.EventQueue;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartPanel;


public class AnalizadorCodeSm extends JDialog {

	// Variáveis
	DefaultPieDataset dataset = null;
	
	public JFreeChart createChart(DefaultPieDataset dataset, String CodeSmells) {

        JFreeChart graficoTarte = ChartFactory.createPieChart(
                "Avaliação da detecção dos CodeSmells em termos de qualidade - " + CodeSmells, dataset, false, true, false);

        return graficoTarte;
    }

    public void createChart(int VP, int FP, int VN, int FN, String CodeSmell) {
        // Criação Gráfico
    	dataset = createDataset(VP,FP,VN,FN);
        JFreeChart grafico = createChart(dataset, CodeSmell);
        ChartPanel janelaGraficos = new ChartPanel(grafico);
        
        // Criação Janela
        janelaGraficos.setBackground(Color.white);
        janelaGraficos.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        add(janelaGraficos);

        // Personalização Título & Outros
        pack();
        setTitle("Gráfico em Tarte");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    
    public DefaultPieDataset createDataset(int VP, int FP, int VN, int FN) {

        DefaultPieDataset dataset = new DefaultPieDataset();
        
        dataset.setValue("Verdadeiros Positivos (VP) = " +VP, VP);
        dataset.setValue("Falsos Positivos (FP) = " +FP, FP);
        dataset.setValue("Verdadeiros Negativos (VN) = " +VN, VN);
        dataset.setValue("Falsos Negativos (FN) = " +FN, FN);

        return dataset;
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
			    AnalizadorCodeSm anaCodeSm = new AnalizadorCodeSm();
			    anaCodeSm.setVisible(true);
			}
		});
    }
}