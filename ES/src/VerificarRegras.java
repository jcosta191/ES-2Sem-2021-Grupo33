
public class VerificarRegras {
	Metodo metodo;

	/*
	 * Metodo que verifica um metodo longo tendo em conta o resultado obtido na extra��o das metricas->Excel e o operador l�gico AND
	 * lim1,lim2, s�o os limites respetivos a cada metrica
	 */
	public boolean isLongMethod_AND(int lim1,int lim2) {
		if(metodo.getLOC_method() > lim1 && metodo.getCYCLO_method() > lim2)
			return true;
		return false;
	}
	
	/*
	 * Metodo que verifica um metodo longo tendo em conta o resultado obtido na extra��o das metricas->Excel e o operador l�gico OR
	 * lim1,lim2, s�o os limites respetivos a cada metrica
	 */
	public boolean isLongMethod_OR(int lim1,int lim2) {
		if(metodo.getLOC_method() > lim1 || metodo.getCYCLO_method() > lim2)
			return true;
		return false;
	}
	
	/*
	 * Metodo que verifica se � uma GOD Class tendo em conta o resultado obtido na extra��o das metricas->Excel e o operador l�gico AND
	 * lim1,lim2, s�o os limites respetivos a cada metrica
	 */
	public boolean isGODClass_AND(int lim1,int lim2) {
		if(metodo.getWMC_class() > lim1 && metodo.getNOM_class() > lim2)
			return true;
		return false;
	}
	
	/*
	 * Metodo que verifica se � uma GOD Class tendo em conta o resultado obtido na extra��o das metricas->Excel e o operador l�gico OR
	 * lim1,lim2, s�o os limites respetivos a cada metrica
	 */
	public boolean isGODClass_OR(int lim1,int lim2) {
		if(metodo.getWMC_class() > lim1 || metodo.getNOM_class() > lim2)
			return true;
		return false;
	}
	
	/*
	 * Como o programa tem de suportar a detecao dos codeSmell longMethod e GodClass, caso o utilizador n�o defina limites poder� verificar-se a mesma se
	 * esta sucede com os met�dos abaixo---> preciso confirmar com o grupo
	 */

}
