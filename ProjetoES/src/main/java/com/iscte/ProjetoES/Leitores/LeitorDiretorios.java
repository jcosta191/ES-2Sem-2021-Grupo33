package com.iscte.ProjetoES.Leitores;

import javax.swing.JFrame;
import javax.swing.JTable;

/**
 * Classe para importar um diretório
 * 
 * 
 * @author jcosta191
 *
 */
public class LeitorDiretorios extends JFrame {
	private static final long serialVersionUID = -22324213434235555L;
	private JTable table;

	public LeitorDiretorios() {

	}
	/**
	 * Chama o leitor Java para ler os ficheiros java
	 *
	 */
	public void openDir() {
        LeitorJava.getInstance().abrirJava();
		table.setModel(LeitorJava.getInstance());
		setVisible(true);
	}

	public JTable getTable() {
		return table;

	}

}
