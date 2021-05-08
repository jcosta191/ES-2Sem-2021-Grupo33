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
    public Leitor_Regras_Guardadas(String filePath){
        this.filePath = filePath;

    }
    public ArrayList lineReaderFile(){
        ArrayList<String> text1 = new ArrayList();
        File file = new File(filePath);
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line!=null){
                //
                text1.add(line);
                line=reader.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return text1;
    }

    public boolean RuleExists(String name){
        text=lineReaderFile();
        for(String s:text){
            if(s.contains(name)){
                System.out.println("Rule Found");
                return true;
            }
        }
        return false;
    }
    public ArrayList EditText(String name, ArrayList<String> changedRule, ArrayList<String> allRules){
        String s2="";
        for (String s1:changedRule){
            s2 = s2+s1+";";
        }
        System.out.println(s2);
        if(RuleExists(name)){
            for(int counter=0;counter<allRules.size(); counter++){
                if(allRules.get(counter).contains(name)){
                    allRules.remove(counter);
                    allRules.add(counter, s2);
                    break;
                }
            }
        }
        System.out.println(allRules);
        return allRules;
    }
    public ArrayList getSavedRuleNames(){
       ArrayList<String> ruleNames = new ArrayList();
       this.lineReaderFile();
        for (String s : text){
            String[] arrOfStr = s.split(";", -2);
            ruleNames.add(arrOfStr[0]);
        }
        System.out.println(ruleNames);
        return ruleNames;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> ruleNames = new ArrayList();
        ruleNames.add("i");
        ruleNames.add("i");
        ruleNames.add("i");
        ruleNames.add("i");
        ruleNames.add("i");
        Saver s = new Saver();
        Leitor_Regras_Guardadas l = new Leitor_Regras_Guardadas("RuleFile.txt");
        l.getSavedRuleNames();
        ArrayList<String> allRules = l.lineReaderFile();
        l.EditText("Long rule", ruleNames,allRules);
        s.EditRule(allRules,"RuleFile.txt" );
    }
}
