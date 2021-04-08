
public class RuleChecker {
	/*
	 * Feature Envy, caso o user n�o especifique o operador l�gico por defini��o usaremos o AND
	 * Caso todos par�metros estejam preenchidos apenas efetuamos a compara��o.
	 */
	public boolean checkFeatureEnvy(int i,int j, int limit1, int limit2, LogicalOperators lop) throws Exception {
		if(lop.equals(null))
			return checkFeatureEnvy(i,j,limit1,limit2, new LogicalOperators("AND"));
		else
			if(lop.comparison((i > limit1), (j < limit2)))
				return  true;
		return false;
	}
	
	/*
	 * Feature Envy, caso o user n�o especifique nenhum valor de limite
	 */
	public boolean checkFeatureEnvy(int i, int j) {
		if(i>6 && j<0.48)
			return true;
		return false;
	}
	/*
	 * Verifica��o do Long Method caso o user n�o especifique nenhum valor de limite
	 */
	public boolean checkLongMethod(int i, int j) {
		if(i > 85 && j>15) 
			return true;
		return false;
	}
	
	/*
	 * Verifica��o do Long Method, caso o user n�o especifique o operador l�gico por defini��o usaremos o AND.
	 * Caso todos par�metros estejam preenchidos apenas efetuamos a compara��o.
	 */
	public boolean checkLongMethod(int i, int j, int limit1, int limit2, LogicalOperators lop) throws Exception {
		if(lop.equals(null)) 
			return checkLongMethod(i,j,limit1,limit2, new LogicalOperators("AND"));
		else if (lop.comparison((i > limit1), (j > limit2)))
			return true;
		return false;
	}
}
