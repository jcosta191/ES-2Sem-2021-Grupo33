package com.iscte.ProjetoES.Leitores;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class LeitorFicheiros extends JFrame{

	private static final long serialVersionUID = -22324213434235555L;
	private JPanel contentPane, excel_panel, info_panel;
	private JTable table;
	private JMenuBar menuBar;
	private JMenu mnFicheiro;
	private JMenuItem mImportarExcel, mNovaRegra, mComparador;

	public LeitorFicheiros() {
	initContentPanel();
	initTable();
	}

	void initContentPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 100, 1300, 600);
		initMenus();
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		excel_panel = new JPanel(new GridLayout(1, 1));
		contentPane.add(excel_panel, BorderLayout.CENTER);
		info_panel = new JPanel();
		contentPane.add(info_panel, BorderLayout.SOUTH);
	}
	
    void initTable() {
		table = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -1528885477774668184L;

			public String getToolTipText(MouseEvent e) {
				String tip = null;
				java.awt.Point p = e.getPoint();
				int rowIndex = rowAtPoint(p);
				int colIndex = columnAtPoint(p);

				try {
					tip = getValueAt(rowIndex, colIndex).toString();
				} catch (RuntimeException e1) {
					tip = "";
				}
				return tip;
			}
		};
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		JScrollPane scrollPane = new JScrollPane();
		excel_panel.add(scrollPane);
		scrollPane.setViewportView(table);
	}
    
    private void initMenus() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnFicheiro = new JMenu("Ficheiro");
		menuBar.add(mnFicheiro);

		mImportarExcel = new JMenuItem("Importar Excel");
		mnFicheiro.add(mImportarExcel);

		mImportarExcel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				LeitorExcel.newInstance().abrirExcel();
				table.setModel(LeitorExcel.getInstance());
			}
		});
	}
	
	public void openFile() {
		LeitorExcel.getInstance().abrirExcel();
		table.setModel(LeitorExcel.getInstance());
		info_panel.add(new JLabel(LeitorExcel.getInstance().getRowCount() + " métodos"));
		setVisible(true);
		}
	
	public JTable getTable() {
		return table;

	}


}