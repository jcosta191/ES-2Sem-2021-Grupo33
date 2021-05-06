
package Regra;

/*
 * Classe auxiliar que permite criar um �nico objeto que cont�m a metrica, limite, oplog e resultado da metrica
 * As vari�veis abaixo s�o indicadas pelo utilizador
 * metrica- nome da metrica 
 * limite- limite da metrica acima mencionada
 * lop-operador l�gico
 */
public class AuxRegra {
	private int metrica;
	private String nomeMetrica;
	private int limite; 
	private int resultadoMetrica;
	private String lop;
	
	/*
	 * Construtor da classe que cria o objeto acima descrito
	 */
/*	public AuxRegra(int metrica, String nomeMetrica, int limite, String lop, int resultadoMetrica) {
		this.metrica = metrica;
		this.nomeMetrica=nomeMetrica;
		this.limite=limite; 
		this.resultadoMetrica=resultadoMetrica;
		this.lop=lop;
	}
*/
	public AuxRegra(int metrica, int limite) {
		this.metrica=metrica;
		this.limite=limite;
		switch(metrica) {
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

	public String getLop() {
		return lop;
	}
	
	public int getResultadoMetrica(){
		return resultadoMetrica;
	}

	/*Os set s�o para o caso do user quiser redefinir as regras*/

	public void setNomeMetrica(String nomeMetrica) {
		this.nomeMetrica = nomeMetrica;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public void setResultadoMetrica(int resultadoMetrica) {
		this.resultadoMetrica = resultadoMetrica;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	
	

}
