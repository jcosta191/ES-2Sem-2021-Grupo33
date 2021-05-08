package com.iscte.ProjetoES;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollBar;

public class showFilexlsx extends JFrame {

	private JPanel contentPane;
	private JTextField txtMostarResultadosDos;
	private JTextField txtMostarFicheiroExcel;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					showFilexlsx frame = new showFilexlsx();
					frame.setTitle("Excel gerado com resultado das métricas");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	

	/**
	 * Create the frame.
	 */
			
	//esta é a unica janela do projeto que foi desenhada com o window builder,
	// o codigo é automaticamente gerado e no construtor adiciona logo tudo ao panel da janela
	
	public showFilexlsx() {
		setTitle("Excel gerado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Total de packages");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox.setBounds(6, 67, 155, 39);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("Calcular n\u00FAmero:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 116, 49);
		contentPane.add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Total de classes");
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox_1.setBounds(318, 67, 162, 39);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Total de met\u00F3dos");
		chckbxNewCheckBox_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox_2.setBounds(163, 72, 174, 29);
		contentPane.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("total de linhas de c\u00F3digo");
		chckbxNewCheckBox_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox_3.setBounds(482, 72, 210, 29);
		contentPane.add(chckbxNewCheckBox_3);
		
		txtMostarResultadosDos = new JTextField();
		txtMostarResultadosDos.setText("  Mostar resultados dos calculos selecionados");
		txtMostarResultadosDos.setBounds(441, 113, 251, 309);
		contentPane.add(txtMostarResultadosDos);
		txtMostarResultadosDos.setColumns(10);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(414, 113, 17, 309);
		contentPane.add(scrollBar);
		
		txtMostarFicheiroExcel = new JTextField();
		txtMostarFicheiroExcel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMostarFicheiroExcel.setText("Mostar ficheiro excel gerado");
		txtMostarFicheiroExcel.setBounds(6, 114, 425, 309);
		contentPane.add(txtMostarFicheiroExcel);
		txtMostarFicheiroExcel.setColumns(10);
		
		
	}
}
