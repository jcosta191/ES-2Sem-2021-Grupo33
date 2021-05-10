package com.iscte.ProjetoES.Escritores;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.iscte.ProjetoES.Leitores.LeitorExcel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * Classe que representa a escrita do import Excel no JTable
 * 
 * @author jcosta191
 *
 */
public class EscritorJTable extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private JPanel contentPane, excel_panel, info_panel;
	private JTable table;
	private JMenuBar menuBar;
	private JMenu mnFicheiro;
	private JMenuItem mImportarExcel;
	public int numberPackage = 1;

	/**
	 * Create the frame.
	 */
	public EscritorJTable() {
		initContentPanel();
		initTable();
	}

	/**
	 * Inicializa o painel onde vão ficar os componentes.
	 */
	private void initContentPanel() {
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

	/**
	 * Inicializa a tabela.
	 */
	private void initTable() {
		table = new JTable() {
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

	/**
	 * Inicializa a MenuBar e os menus
	 */
	void initMenus() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnFicheiro = new JMenu("Ficheiro");
		menuBar.add(mnFicheiro);

		mImportarExcel = new JMenuItem("Importar Excel");
		mnFicheiro.add(mImportarExcel);

		mImportarExcel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				LeitorExcel.newInstance().addFile();
				table.setModel(LeitorExcel.getInstance());
			}
		});

	}

	/**
	 * Torna visivel a janela e abre a o JFileChooser para escolher o Excel e mostra
	 * o nº de packages, metodos e linhas totais
	 */
	public void openFile() throws IOException, InvalidFormatException {
		LeitorExcel.getInstance().addFile();
		table.setModel(LeitorExcel.getInstance());
		info_panel.add(new JLabel(LeitorExcel.getInstance().getNumberPackages() + " Packages"));
		info_panel.add(new JLabel(LeitorExcel.getInstance().getRowCount() + "Métodos"));
		info_panel.add(new JLabel(LeitorExcel.getInstance().getNumberLOC() + " Linhas"));
		setVisible(true);
	}

	/**
	 * 
	 * @return a JTable que guarda os dados do Excel
	 */
	public JTable getTable() {
		return table;

	}

}
