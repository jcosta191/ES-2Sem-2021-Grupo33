
public class VerificarRegras {
	Metodo metodo;

	/*
	 * Metodo que verifica um metodo longo tendo em conta o resultado obtido na extração das metricas->Excel e o operador lógico AND
	 * lim1,lim2, são os limites respetivos a cada metrica
	 */
	public boolean isLongMethod_AND(int lim1,int lim2) {
		if(metodo.getLOC_method() > lim1 && metodo.getCYCLO_method() > lim2)
			return true;
		return false;
	}
	
	/*
	 * Metodo que verifica um metodo longo tendo em conta o resultado obtido na extração das metricas->Excel e o operador lógico OR
	 * lim1,lim2, são os limites respetivos a cada metrica
	 */
	public boolean isLongMethod_OR(int lim1,int lim2) {
		if(metodo.getLOC_method() > lim1 || metodo.getCYCLO_method() > lim2)
			return true;
		return false;
	}
	
	/*
	 * Metodo que verifica se é uma GOD Class tendo em conta o resultado obtido na extração das metricas->Excel e o operador lógico AND
	 * lim1,lim2, são os limites respetivos a cada metrica
	 */
	public boolean isGODClass_AND(int lim1,int lim2) {
		if(metodo.getWMC_class() > lim1 && metodo.getNOM_class() > lim2)
			return true;
		return false;
	}
	
	/*
	 * Metodo que verifica se é uma GOD Class tendo em conta o resultado obtido na extração das metricas->Excel e o operador lógico OR
	 * lim1,lim2, são os limites respetivos a cada metrica
	 */
	public boolean isGODClass_OR(int lim1,int lim2) {
		if(metodo.getWMC_class() > lim1 || metodo.getNOM_class() > lim2)
			return true;
		return false;
	}
	
	/*
	 * Como o programa tem de suportar a detecao dos codeSmell longMethod e GodClass, caso o utilizador não defina limites poderá verificar-se a mesma se
	 * esta sucede com os metódos abaixo---> preciso confirmar com o grupo
	 */

}
