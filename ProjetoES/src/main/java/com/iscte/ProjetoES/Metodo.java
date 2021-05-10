package com.iscte.ProjetoES;

import java.util.ArrayList;

/**
 * Classe que representa um Metodo
 * 
 * @author jcosta191
 *
 */
public class Metodo {

	private int methodID;
	private String pacote;
	private String classe;
	private String method;
	int NOM_class;
	int LOC_class;
	int WMC_class;
	int LOC_method;
	int CYCLO_method;

	/**
	 * Construtor
	 * 
	 * @param methodID     - correspondente à identificação do método do projeto
	 *                     Java;
	 * 
	 * @param pacote       - correspondente à identificação do package onde se
	 *                     encontra o método
	 * 
	 * @param classe       - correspondente à identificação da classe onde se
	 *                     encontra o método;
	 * 
	 * @param method       - correspondente ao nome do método;
	 * 
	 * @param NOM_class    - correspondente ao número de métodos existente na
	 *                     classe;
	 * 
	 * @param LOC_class    - correspondente ao número de linhas de código da classe;
	 * 
	 * @param WMC_class    - correspondente à complexidade ciclomática da classe
	 *                     (soma das complexidades ciclomáticas dos métodos da
	 *                     classe);
	 *
	 * @param LOC_method   - correspondente ao número de linhas de código do método;
	 *
	 * @param CYCLO_method - correspondente à complexidade ciclomática do método.
	 *                     (Para efeitos deste projeto, a complexidade ciclomática
	 *                     de um método deve ser calculada da seguinte forma:
	 *                     Somatório da quantidade de instruções “if”, “case”,
	 *                     “for”, “while” e outros ciclos, acrescentado de 1);
	 *
	 */
	public Metodo(int methodID, String pacote, String classe, String method, int NOM_class, int LOC_class,
			int WMC_class, int LOC_method, int CYCLO_method) {
		this.methodID = methodID;
		this.pacote = pacote;
		this.classe = classe;
		this.method = method;
		this.NOM_class = NOM_class;
		this.LOC_class = LOC_class;
		this.WMC_class = WMC_class;
		this.LOC_method = LOC_method;
		this.CYCLO_method = CYCLO_method;
	}

	public int getMethodID() {
		// TODO Auto-generated method stub
		return methodID;
	}

	public String getPackage() {
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
		return LOC_method;
	}

	public int getCYCLO_method() {
		// TODO Auto-generated method stub
		return CYCLO_method;
	}

	public int getWMC_class() {
		// TODO Auto-generated method stub
		return WMC_class;
	}

	public ArrayList<Integer> getLeituras() {
		ArrayList<Integer> leituras = new ArrayList<Integer>();
		leituras.add(NOM_class);
		leituras.add(LOC_class);
		leituras.add(WMC_class);
		leituras.add(LOC_method);
		leituras.add(CYCLO_method);
		return leituras;
	}

}
