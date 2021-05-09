package com.iscte.ProjetoES.CRegra;

import java.util.ArrayList;

/*
 *Classe Regra recebe como argumentos um arrayList em cada posi��o uma m�trica selecionada pelo user, o respetivo limite e operador l�gico
 *a considerar para a forma��o de express�es com as metricas.
 */
public class Regras {
	public ArrayList<AuxRegra> metrics=new ArrayList<AuxRegra>(); // conjunto de condicoes que compoem a regra

	public int[] args; //array the thresholds
	public String nome; // nome da regra
	public int lop; // 0-OR 1-AND
	public boolean isCodeSmell; // boolean a usar na coluna da regra, culminar da sua verificacao perante um metodo

	//public Verificacao vr;

	public Regras(String name, int NOM_class, int LOC_class, int WMC_class, int LOC_method, int CYCLO_method, int lop){
		// args de nom a cyclo correspondem a thresholds
		this.nome=name;
		if (lop!=0 && lop!=1) // se nao fpr 0 ou 1 nao corresponde a um dos operadores logicos suportados
			throw new IllegalArgumentException (" lop invalido");
		this.lop=lop;
		int args[]={NOM_class,LOC_class,WMC_class,LOC_method,CYCLO_method};
		ArrayList<AuxRegra> metrics=new ArrayList<AuxRegra>();
		for (int i =0; i<args.length;i++)
			if (args[i]>0) // valor 0 ou menor é considera-se que nao é para verificar a metrica em questao, logo nao se cria auxregra(condicão da regra)
			{
				AuxRegra ar=new AuxRegra(i + 1, args[i]);
				metrics.add(ar);
			}
		this.args=args;
		this.metrics=metrics;
		//this.vr=vr;
	}
	ArrayList<Integer> leituras=new ArrayList<>();
	public boolean check(int limite, int contagem){
		return limite<=contagem;
	}

/*	public void verify(Regras r, ArrayList<Integer> leituras){
		if(this.metrics.size()>0) { // evitar resultados falsos
			if (this.lop == 0) //or
				isCodeSmell = false;
			else // and
				isCodeSmell = true;
			for (AuxRegra condition : this.metrics)
				if (check(condition.getLimite(), leituras.get(condition.metrica)) != isCodeSmell)
					// se o lop for OR o primeiro true acaba a verificação
					// se for AND o primeiro false termina o processo
					isCodeSmell = !isCodeSmell; // troca caso refutacao
		}
		else System.out.println("Regra vazia!"); // nao deve acontecer
	}
/*
	public void detecao (ArrayList<Integer> leituras){
		boolean one =vr.detection(leituras)[0];
		boolean two =vr.detection(leituras)[1];
		boolean [] quality=new boolean [2];
		quality[1]=this.isCodeSmell;
		if((one)


	}*/

	public ArrayList<AuxRegra> getMetrics() {
		return metrics;
	}
}
