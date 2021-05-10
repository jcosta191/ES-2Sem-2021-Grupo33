package com.iscte.ProjetoES.CRegra;

import java.util.ArrayList;

// @author tmots90

public class Verificacao {
    private boolean result;
    ArrayList<Integer> leituras = new ArrayList<>();

    public boolean check(int limite, int contagem) {
        return limite <= contagem;
    }

    public boolean verify(Regras r, ArrayList<Integer> leituras) {
        if (r.lop == 0) //or
            result = false;
        else // and
            result = true;
        for (AuxRegra condition : r.metrics)
            for (int i = 0; i < leituras.size(); i++)
                if (condition.metrica == i+1)
                    if (check(condition.getLimite(), leituras.get(i)) != result)
                        return !result;
        return result;

    }

    public boolean [] verifyBaseOR(ArrayList<Integer> leituras) {
        Regras god = new Regras("God Class or",10,0,50,0,0,0);
        Regras longM = new Regras("Long Method or",0,0,0,50,10,0);
        boolean [] b= new boolean[]{verify(god,leituras),verify(longM,leituras)};
        return b;
    }
    public boolean [] verifyBaseAND(ArrayList<Integer> leituras) {
        Regras god = new Regras("God Class or",10,0,50,0,0,1);
        Regras longM = new Regras("Long Method or",0,0,0,50,10,1);
        boolean [] b= new boolean[]{verify(god,leituras),verify(longM,leituras)};
        return b;
    }


    public boolean isTrueResult(Regras r, ArrayList<Integer> leituras){// pode receber verifyBase or
        if (verifyBaseOR(leituras)[0]==true) System.out.println("God_Class");
        if (verifyBaseOR(leituras)[1]==true) System.out.println("Long_Method");
        if (verifyBaseOR(leituras)[0]==true||verifyBaseOR(leituras)[1]==true)
            return verify(r,leituras);
         else
             return !verify(r,leituras);
    }
}
