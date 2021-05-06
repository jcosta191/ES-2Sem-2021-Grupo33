package com.iscte.ProjetoES;

/**
 * Classe que representa um Metodo
 * 
 * @author rmdca
 *
 */
public class Metodo {

	private int methodID;
	@SuppressWarnings("unused")
	private String pacote;
	@SuppressWarnings("unused")
	private String classe;
	@SuppressWarnings("unused")
	private String method;
	int NOM_class;
	int LOC_class; 
	int WMC_class;
	int LOC_method; 
	int CYCLO_method;
	/**
	 * Construtor
	 * 
	 * @param methodID        - correspondente à identificação do método do projeto
	 *                        Java
	 * @param pacote          - correspondente à identificação do package onde se
	 *                        encontra o método
	 * @param classe          -correspondente à identificação da class onde se
	 *                        encontra o método;
	 * @param method          - correspondente ao nome do metodo
	 * @param loc             - número de linhas de código do método
	 * @param cyclo           - complexidade ciclomática do método
	 * @param atfd            - acessos que o método faz a métodos de outras classes
	 * @param laa             - acessos que o metodo faz a atributos da propria
	 *                        classe
	 * @param is_long_method  - correspondente à classificação correta do defeito
	 *                        is_long_method no método, ou seja, se o defeito long
	 *                        method se encontra presente ou não no método
	 * @param iplasma         - correspondente à classificação que a ferramenta
	 *                        iPlasma faz sobre a presença (ou não) do defeito
	 *                        long_method no método
	 * @param pmd             - correspondente à classificação que a ferramenta PMD
	 *                        faz sobre a presença (ou não) do defeito long_method
	 *                        no método
	 * @param is_feature_envy - is_ feature_envy , correspondente à classificação
	 *                        correta do defeito feature_envy no método, ou seja, se
	 *                        o defeito feature_envy se encontra presente ou não no
	 *                        método.
	 */
	public Metodo(int methodID, String pacote, String classe, String method, int NOM_class, int LOC_class, int WMC_class, int LOC_method, int CYCLO_method) {
		this.methodID = methodID;
		this.pacote = pacote;
		this.classe = classe;
		this.method = method;
		this.NOM_class=NOM_class;
		this.LOC_class=LOC_class; 
		this.WMC_class=WMC_class;
		this.LOC_method=LOC_method; 
		this.CYCLO_method=CYCLO_method;
	}
	public int getMethodID() {
		// TODO Auto-generated method stub
		return methodID;
	}
	
	public String getpacote() {
		// TODO Auto-generated method stub
		return pacote;
	}
	
	public String getClasse() {
		// TODO Auto-generated method stub
		return classe;
	}
	
	
	public String getMethod() {
		// TODO Auto-generated method stub
		return method;
	}
	
	public int getNOM_class() {
		// TODO Auto-generated method stub
		return NOM_class;
	}
	
	public int getLOC_class() {
		// TODO Auto-generated< method stub
		return LOC_class;
	}
	
	public int getLOC_method() {
		// TODO Auto-generated method stub
		return WMC_class;
	}
	
	public int getCYCLO_method() {
		// TODO Auto-generated method stub
		return WMC_class;
	}
	
	
	
	
	

}

	