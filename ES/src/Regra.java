import java.util.ArrayList;

/*
 *Classe Regra recebe como argumentos um arrayList em cada posi��o uma m�trica selecionada pelo user, o respetivo limite e operador l�gico
 *a considerar para a forma��o de express�es com as metricas.
 */
public class Regra {
	private ArrayList<auxRegra> metrics=new ArrayList<>(); //ArrayList que recebe o conjunto de metricas e os respetivos limites e operador l�gico 
	private boolean isCodeSmell;
	private VerificarRegras vr;

	public Regra(ArrayList <auxRegra> metrics) {
		this.metrics=metrics;
	}

/*
 * Metodo que verifica se existe o codeSmell isLongMethod quando o operador � AND ou OR, usando as classes auxiliares Verifica Regra e auxRegra
 *Este metodo verifica se as metricas necess�rias foram selecionadas pelo user(e utiliza os respetivos limites)
 * , caso sim, verifica se estamos perante um Long Method tendo em conta o operador l�gico selecionado pelo user.
 */
	public boolean longMethod() {
		for(int i=0; i != metrics.size(); i++) {
			for(int j=0; j != metrics.size(); j++) {
			if(metrics.get(i).getMetrica() == "LOC_Method" && metrics.get(j).getMetrica() == "CYCLO_method" && metrics.get(i).getLop()== "AND") {
				isCodeSmell=vr.isLongMethod_AND(metrics.get(i).getLimite(), metrics.get(j).getLimite());
			}else 
				if(metrics.get(i).getMetrica() == "LOC_Method" && metrics.get(j).getMetrica() == "CYCLO_method" && metrics.get(i).getLop()== "OR") {
				isCodeSmell=vr.isLongMethod_OR(metrics.get(i).getLimite(), metrics.get(j).getLimite());
				}
			}
		}
		return isCodeSmell;
	}
	
/*
 * Metodo que verifica se existe o codeSmell isGodClass quando o operador � AND ou OR, usando as classes auxiliares Verifica Regra e auxRegra
 * Este metodo verifica se as metricas necess�rias foram selecionadas pelo user(e utiliza os respetivos limites)
 * , caso sim, verifica se estamos perante uma God Class tendo em conta o operador l�gico selecionado pelo user.
 */
	public boolean isGodClass() { 
		for(int i=0; i != metrics.size(); i++) {
			for(int j=0; j != metrics.size(); j++) {
			if(metrics.get(i).getMetrica() == "WMC_class" && metrics.get(j).getMetrica() == "NOM_class" && metrics.get(i).getLop()== "AND") {
				isCodeSmell=vr.isGODClass_AND(metrics.get(i).getLimite(), metrics.get(j).getLimite());
			}else 
				if(metrics.get(i).getMetrica() == "LOC_Method" && metrics.get(j).getMetrica() == "CYCLO_method" && metrics.get(i).getLop()== "OR") {
				isCodeSmell=vr.isGODClass_OR(metrics.get(i).getLimite(), metrics.get(j).getLimite());
				}
			}
		}
		return isCodeSmell;
	}
}
