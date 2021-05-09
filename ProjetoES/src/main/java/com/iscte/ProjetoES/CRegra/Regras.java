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
	private boolean isCodeSmell; // boolean a usar na coluna da regra, culminar da sua verificacao perante um metodo

	public int a;
	public int b;
	public int c;
	public int d;
	public int e;
	
	public Regras(String name, int a, int b, int c, int d, int e, int lop){
		this.nome=name;
		if (lop!=0 && lop!=1) // se nao fpr 0 ou 1 nao corresponde a um dos operadores logicos suportados
			throw new IllegalArgumentException (" lop invalido");
		this.lop=lop;
		int args[]={a,b,c,d,e};
		ArrayList<AuxRegra> metrics=new ArrayList<AuxRegra>();
		for (int i =0; i<args.length;i++)
			if (args[i]>0) // valor 0 ou menor é considera-se que nao é para verificar a metrica em questao, logo nao se cria auxregra(condicão da regra)
			{
				AuxRegra ar=new AuxRegra(i + 1, args[i]);
				metrics.add(ar);
			}
		this.args=args;
		this.metrics=metrics;
	}
	ArrayList<Integer> leituras=new ArrayList<>();
	public boolean check(int limite, int contagem){
		return limite<=contagem;
	}

	public void verify(Regras r, ArrayList<Integer> leituras){
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
	
	public int getLOCC() { return a; }
	public int getNOM() { return b; }
	public int getWMC() { return c; }
	public int getCYCLOM() { return d; }
	public int getLOCM() { return e; }
	public int getLOP() { return lop; }
}
