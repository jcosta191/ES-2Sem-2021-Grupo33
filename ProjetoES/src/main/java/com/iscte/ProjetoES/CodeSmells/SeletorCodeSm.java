package com.iscte.ProjetoES.CodeSmells;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SeletorCodeSm extends JDialog {

	private static final long serialVersionUID = 1L;
	
	// Definição das variáveis e constantes a serem usadas
	private DetetorCodeSm DetetorCodeSm = new DetetorCodeSm();
	private ComparadorCodeSm ComparadorCodeSm = new ComparadorCodeSm();
	private final JPanel janelaPrincipal = new JPanel();
		
	// Ligar o Seletor de CodeSmells (So para debug)
	public static void main(String[] args) {
		try {
			SeletorCodeSm dialog = new SeletorCodeSm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception excecao) {
			System.out.println("Erro ocorrido: " + excecao);
		}
	}

	// Criação da janela principal e adição dos botões
	public SeletorCodeSm() {
		setTitle("CodeSmells - LM, GC & Avaliador de Qualidade");
		setBounds(100, 100, 1104, 693);
		
		getContentPane().setLayout(new BorderLayout());
		janelaPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(janelaPrincipal, BorderLayout.CENTER);
		janelaPrincipal.setLayout(null);
		
		JScrollPane painelDaEsquerda = new JScrollPane();
		JScrollPane painelDaDireita = new JScrollPane();
		
		DetetorCodeSm.setTableLongMethod(new JTable());
		DetetorCodeSm.getTableLongMethod().setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] { "ID do Método", "is_LM" }) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		painelDaEsquerda.setViewportView(DetetorCodeSm.getTableLongMethod());
		
		DetetorCodeSm.setTableGodClass(new JTable());
		DetetorCodeSm.getTableGodClass().setModel(new DefaultTableModel(
			new Object[][] {}, new String[] {"Classe", "is_GC"}) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		painelDaDireita.setViewportView(DetetorCodeSm.getTableGodClass());
		
		JLabel tituloDosLM = new JLabel("Long Methods");
		tituloDosLM.setFont(new Font("Calibri", Font.BOLD, 16));

		JLabel tituloDasGC = new JLabel("God Classes");
		tituloDasGC.setFont(new Font("Calibri", Font.BOLD, 16));
		
		JButton botaoAvaliarQualidade = new JButton("Avaliador Qualidade CodeSmells");
		botaoAvaliarQualidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ComparadorCodeSm.comparadorLM();
					ComparadorCodeSm.comparadorGC();
					
					AnalizadorCodeSm anaCodeSm = new AnalizadorCodeSm();
					anaCodeSm.createChart(ComparadorCodeSm.getVP1(), ComparadorCodeSm.getFP1(), ComparadorCodeSm.getVN1(), ComparadorCodeSm.getFN1(),"LongMethod");
					anaCodeSm.setVisible(true);
					
					AnalizadorCodeSm anaCodeSm1 = new AnalizadorCodeSm();
					anaCodeSm1.createChart(ComparadorCodeSm.getVP2(), ComparadorCodeSm.getFP2(), ComparadorCodeSm.getVN2(), ComparadorCodeSm.getFN2(), "GodClass");
					anaCodeSm1.setVisible(true);
				} catch (IOException excecao) {
					System.out.println("Erro ocorrido: " + excecao);
				}
				
			}
		});
		
		painelDaEsquerda.setBounds(10, 39, 526, 565);
		painelDaDireita.setBounds(573, 39, 493, 565);
		tituloDosLM.setBounds(10, 11, 204, 26);
		tituloDasGC.setBounds(573, 11, 204, 26);
		botaoAvaliarQualidade.setBounds(10, 615, 249, 28);
		
		janelaPrincipal.add(painelDaEsquerda);
		janelaPrincipal.add(painelDaDireita);
		janelaPrincipal.add(tituloDosLM);
		janelaPrincipal.add(tituloDasGC);
		janelaPrincipal.add(botaoAvaliarQualidade);
	}
	
	// Procedimentos que invocam os detetores da classe DetetorCodeSm
	public void detetorLM(String ficheiroALer, String escolhaMetrica1 , int escolhaValor1, int escolhaValor2, String regraAndOr) throws IOException {
		DetetorCodeSm.detetorLM(ficheiroALer, escolhaMetrica1, escolhaValor1, escolhaValor2, regraAndOr);	
	}
		
	public void detetorGC(String ficheiroALer, String escolhaMetrica1, String escolhaMetrica2, int escolhaValor1, int escolhaValor2, String regraAndOr) throws IOException {
		DetetorCodeSm.detetorGC(ficheiroALer, escolhaMetrica1, escolhaMetrica2, escolhaValor1, escolhaValor2, regraAndOr);
	}		
}