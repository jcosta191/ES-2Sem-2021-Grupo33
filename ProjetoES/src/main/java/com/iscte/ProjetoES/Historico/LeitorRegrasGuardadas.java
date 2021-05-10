package com.iscte.ProjetoES.Historico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Classe para ler as regras guardadas permanenente, colectar a informação
 * e editar os arrays usados pela classe Saver
 *
 *
 * @author Bernardo Marques
 *
 */
public class LeitorRegrasGuardadas {
    private static String filePath;
    private BufferedReader reader;
    private ArrayList<String> text = new ArrayList();

    public LeitorRegrasGuardadas(String filePath) {
        this.filePath = filePath;

    }
    /**
     * Função para colocar toda a informação do Ficheiro de regras guardadas numa ArrayList
     */

    public ArrayList lineReaderFile() {
        ArrayList<String> text1 = new ArrayList();
        File file = new File(filePath);
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                //
                text1.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text1;
    }

    /**
     * Função para a verificação da existência da regra dado o nome dentro do ficheiro
     */
    public boolean RuleExists(String name) {
        text = lineReaderFile();
        for (String s : text) {
            if (s.contains(name)) {
                System.out.println("Rule Found");
                return true;
            }
        }
        return false;
    }
    /**
     * Função usada para editar o texto do ficheiro de regras substituindo os parâmetros da regra desejada
     * de forma a enviar o novo array de regras para ser usado pela classe Saver
     */
    public ArrayList EditText(String name, ArrayList<String> changedRule, ArrayList<String> allRules) {
        String s2 = "";
        for (String s1 : changedRule) {
            s2 = s2 + s1 + ";";
        }
        if (RuleExists(name)) {
            for (int counter = 0; counter < allRules.size(); counter++) {
                if (allRules.get(counter).contains(name)) {
                    allRules.remove(counter);
                    allRules.add(counter, s2);
                    break;
                }
            }
        }
        return allRules;
    }
    /**
     * Procurar String da regra num array contendo todas as regras e colocar as suas métricas todas num array
     */
    public ArrayList<String> getRule(String name, ArrayList<String> allRules, ArrayList<String> arrayList) {
        int counter;
        String[] arrOfStr = new String[6];
        for (counter = 0; counter < allRules.size(); counter++) {
            if (allRules.get(counter).contains(name)) {
                arrOfStr = allRules.get(counter).split(";", -2);
                break;
            }
        }
        for (int c = 0; c < arrOfStr.length; c++) {
            arrayList.add(arrOfStr[c]);
        }
        return arrayList;
    }

    /**
     * Obter nomes das regras guardadas no ficheiro Rulefiles.txt
     */
    public ArrayList getSavedRuleNames() {
        ArrayList<String> ruleNames = new ArrayList();
        text = lineReaderFile();
        for (String s : text) {
            String[] arrOfStr = s.split(";", -2);
            ruleNames.add(arrOfStr[0]);
        }
        return ruleNames;
    }
}