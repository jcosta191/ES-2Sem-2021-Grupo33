
package com.iscte.ProjetoES.CRegra;

/*
 * Classe auxiliar que permite criar um �nico objeto que cont�m a metrica, limite, oplog e resultado da metrica
 * As vari�veis abaixo s�o indicadas pelo utilizador
 * metrica- int atribuido a metrica
 * nomeMetrica - string com o nome
 * limite- limite da metrica mencionada
 * lop-operador logico
 * */
public class AuxRegra {
	public final int metrica;
	private String nomeMetrica;
	private int limite; 
	private int resultadoMetrica;

	public AuxRegra(int metrica, int limite) {
		this.metrica=metrica; // identificador da metrica
		this.limite=limite; // threshold
		switch(metrica) { //nome da metrica
			case 1:
				nomeMetrica=new String("NOM_class\n");
			case 2:
				nomeMetrica=new String("LOC_class\n");
			case 3:
				nomeMetrica=new String("WMC_class\n");
			case 4:
				nomeMetrica=new String("LOC_method\n");
			case 5:
				nomeMetrica=new String("CYCLO_method\n");
		}this.nomeMetrica=nomeMetrica;
	}


	public String getNomeMetrica() {
		return nomeMetrica;
	}

	public int getLimite() {
		return limite;
	}
	
	public int getResultadoMetrica(){
		return resultadoMetrica;
	}

	/*Os set sao para o caso do user querer redefinir as regras*/

	public void setNomeMetrica(String nomeMetrica) {
		this.nomeMetrica = nomeMetrica;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public void setResultadoMetrica(int resultadoMetrica) {
		this.resultadoMetrica = resultadoMetrica;
	}
}
