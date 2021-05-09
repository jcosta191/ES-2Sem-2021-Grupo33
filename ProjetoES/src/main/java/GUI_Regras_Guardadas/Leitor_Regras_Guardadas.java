package GUI_Regras_Guardadas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Leitor_Regras_Guardadas {
    private static String filePath;
    private BufferedReader reader;
    private ArrayList<String> text = new ArrayList();

    public Leitor_Regras_Guardadas(String filePath) {
        this.filePath = filePath;

    }
    //Função para colocar toda a informação do Ficheiro de regras guardadas numa ArrayList

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

    //Verifica se a regra existe no ficheiro
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

    //Editar Array para colocar a regra q se deseja editar do ficheiro
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

    //Selecionar regra dado o array de todas as regras
    public ArrayList<String> getRule(String name, ArrayList<String> allRules, ArrayList<String> arrayList) {
        int counter;
        String[] arrOfStr = new String[6];
        for (counter = 0; counter < allRules.size(); counter++) {
            if (allRules.get(counter).contains(name)) {
                System.out.println(allRules.get(counter));
                arrOfStr = allRules.get(counter).split(";", -2);
                break;
            }
        }
        for (int c = 0; c < arrOfStr.length; c++) {
            System.out.println(arrOfStr[c]);
            arrayList.add(arrOfStr[c]);
        }
        return arrayList;
    }

    //Getter para os nomes de todas as regras existentes no ficheiro de regras guardadas
    public ArrayList getSavedRuleNames() {
        ArrayList<String> ruleNames = new ArrayList();
        text = lineReaderFile();
        for (String s : text) {
            String[] arrOfStr = s.split(";", -2);
            ruleNames.add(arrOfStr[0]);
        }
        System.out.println(ruleNames);
        return ruleNames;
    }
}
