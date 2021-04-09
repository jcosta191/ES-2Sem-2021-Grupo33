
public class Condition {
	private int metrica; //valor indica metrica a analisar
	private int limite; 
	
	public Condition(int metrica,int limite) throws Exception {
		if (metrica  <1 && metrica>5)
			throw new IllegalArgumentException("Metrica inválida!");
		if (limite<1)
			throw new IllegalArgumentException("Limite inválido");
		this.limite=limite;
		this.metrica=metrica;
		
	}
	public String getMetrica() {
		switch(metrica) {
		case 1:
			return new String("NOM_class\n");
		case 2:
			return new String("LOC_class\n");
		case 3:
			return new String("WMC_class\n");
		case 4:
			return new String("LOC_method\n");
		case 5:
			return new String("CYCLO_method\n");
		}
		return null;//nunca acontece
	}
}
