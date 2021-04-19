import java.util.ArrayList;

/*
 * int metrica-metrica escolhida para criar a regra
 * int limite-limite escolhido para a metrica acima escolhida
 * LogicalOperators lop-operador l�gico escolhido pelo user para formar express�es com as m�tricas
 */
public class Regra {
	private String opLog;
	private ArrayList<auxRegra> metricas=new ArrayList<>(); //ArrayList que recebe o conjunto de metricas e os respetivos limites e operador l�gico 
	private boolean isCodeSmell;


/*
 * Metodo que verifica se existe o codeSmell isLong
 */
	public boolean isLongMethod() {
		for(int i=0; i != metricas.size(); i++) {
			opLog = metricas.get(i).getLop();
			if(opLog.equalsIgnoreCase("AND")) {
				if(metricas.get(i).getResultadoMetrica() > metricas.get(i).getLimite() 
						&& metricas.get(i+1).getResultadoMetrica() > metricas.get(i+1).getLimite()) {
					isCodeSmell=true; 
				} 
			}
			if(opLog.equalsIgnoreCase("OR")) {
				if(metricas.get(i).getResultadoMetrica() > metricas.get(i).getLimite() 
						|| metricas.get(i+1).getResultadoMetrica() > metricas.get(i+1).getLimite()) {
					isCodeSmell=true; 
				} 
			}else isCodeSmell=false;
		}
		return isCodeSmell;
	}
	
	public boolean isGoodClass() { //ja tenho a ideia, falta passar para c�digo
		return false;
	}
	
	public String getOperadorLogico() {
		for(int i=0; i != metricas.size(); i++) {
			opLog = metricas.get(i).getLop();
			if(metricas.get(i).getLop().equalsIgnoreCase("AND")) {
				opLog="AND";
			}
			else if(metricas.get(i).getLop().equalsIgnoreCase("OR")) {
				opLog="OR";
			}
		}
		return opLog;
	}

}
