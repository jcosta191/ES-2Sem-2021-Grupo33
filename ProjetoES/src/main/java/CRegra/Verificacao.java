package CRegra;

import java.util.ArrayList;

public class Verificacao { //incompleto
	boolean result=false;
	ArrayList<Integer> leituras=new ArrayList<>();
	public boolean check(int limite, int contagem){
		return limite<=contagem;
	}

	public boolean Verify(Regras r, ArrayList<Integer> leituras){
    	if (r.lop==0) //or
    		result=false;
    	else // and
    		result=true;
    	for(AuxRegra condition: r.metrics)
			for(int i=0;i< leituras.size();i++)
				//falta verificar se tipo do limite corresponde ao tipo da leitura
				//seja pelo nome ou pelo id [1,5]
				if(condition.metrica==i)
   		 			if (check(condition.getLimite(), leituras.get(i))!=result)
    					return !result;
    return result;

    }



}
