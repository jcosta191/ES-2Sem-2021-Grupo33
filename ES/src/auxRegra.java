/*
 * Classe auxiliar que permite criar um �nico objeto que cont�m a metrica, limite, oplog e resultado da metrica
 * As vari�veis abaixo s�o indicadas pelo utilizador
 * metrica- nome da metrica 
 * limite- limite da metrica acima mencionada
 * lop-operador l�gico
 */
public class auxRegra {
	private String nomeMetrica; 
	private int limite; 
	private int resultadoMetrica;
	private String lop;
	
	/*
	 * Construtor da classe que cria o objeto acima descrito
	 */
	public auxRegra(String nomeMetrica, int limite, String lop, int resultadoMetrica) {
		this.nomeMetrica=nomeMetrica;
		this.limite=limite; 
		this.resultadoMetrica=resultadoMetrica;
		this.lop=lop;
	}

	public String getMetrica() {
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

	
	

}
