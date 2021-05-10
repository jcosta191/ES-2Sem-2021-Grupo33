package com.iscte.ProjetoES;

import com.iscte.ProjetoES.CRegra.Regras;
//import com.iscte.ProjetoES.CRegra.Verificacao;
//import com.iscte.ProjetoES.Escritores.EscritorJTable;
import com.iscte.ProjetoES.Gui.GUI;

import java.util.ArrayList;

import javax.swing.UnsupportedLookAndFeelException;

/**
 * Inicia o programa com a Classe GUI
 * 
 * @author jcosta191
 *
 */
public class App {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		GUI a = new GUI() ;
		try {
			a.createAndShowGUI();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
