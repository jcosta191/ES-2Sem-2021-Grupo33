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
	private DetetorCodeSm DetetorCodeSm = new DetetorCodeSm();
	private ComparadorCodeSm ComparadorCodeSm = new ComparadorCodeSm();
	private final JPanel contentPanel = new JPanel();
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SeletorCodeSm dialog = new SeletorCodeSm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		/**
	 * Create the dialog.
	 */
	public SeletorCodeSm() {
		setTitle("Deteção de Code Smells");
		setBounds(100, 100, 1104, 693);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 39, 526, 565);
		contentPanel.add(scrollPane1);
		
		DetetorCodeSm.setTableLongMethod(new JTable());
		DetetorCodeSm.getTableLongMethod().setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] { "Method ID", "is Long Method" }) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane1.setViewportView(DetetorCodeSm.getTableLongMethod());
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(573, 39, 493, 565);
		contentPanel.add(scrollPane2);
		
		DetetorCodeSm.setTableGodClass(new JTable());
		DetetorCodeSm.getTableGodClass().setModel(new DefaultTableModel(
			new Object[][] {}, new String[] {"Class", "is God Class"}) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane2.setViewportView(DetetorCodeSm.getTableGodClass());
		
		JLabel lblLongMethod = new JLabel("Long Method:");
		lblLongMethod.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLongMethod.setBounds(10, 11, 204, 26);
		contentPanel.add(lblLongMethod);
		
		JLabel lblGodClass = new JLabel("God Class:");
		lblGodClass.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGodClass.setBounds(573, 11, 204, 26);
		contentPanel.add(lblGodClass);
		
		JButton btnqualidade = new JButton("Avaliar Qualidade dos Code Smells Detetados");
		btnqualidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ComparadorCodeSm.comparadorLM();
					ComparadorCodeSm.comparadorGC();
					AnalizadorCodeSm c = new AnalizadorCodeSm();
					c.createChart(ComparadorCodeSm.getVP1(), ComparadorCodeSm.getFP1(), ComparadorCodeSm.getVN1(), ComparadorCodeSm.getFN1(),"LongMethod");
					c.setVisible(true);
					AnalizadorCodeSm c1 = new AnalizadorCodeSm();
					c1.createChart(ComparadorCodeSm.getVP2(), ComparadorCodeSm.getFP2(), ComparadorCodeSm.getVN2(), ComparadorCodeSm.getFN2(), "GodClass");
					c1.setVisible(true);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnqualidade.setBounds(10, 615, 249, 28);
		contentPanel.add(btnqualidade);
	}
	
	public void detecaoLongMethod (String file, String metrica1 , int valor1,  String andor1, String metrica2, int valor2) throws IOException {
		DetetorCodeSm.detecaoLongMethod(file, metrica1, valor1, andor1, metrica2, valor2);	
	}
		
	public void detecaoGodClass (String file, String metrica3 , int valor3,  String andor2, String metrica4, int valor4) throws IOException {
		DetetorCodeSm.detecaoGodClass(file, metrica3, valor3, andor2, metrica4, valor4);
	}		
}