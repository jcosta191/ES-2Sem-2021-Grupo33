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
        File file = new File(filePath);
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line!=null){
                //
                text.add(line);
                line=reader.readLine();
                
            }
           // System.out.println(text);
        } catch (IOException e){
            e.printStackTrace();
        }
        return text;
    }
    public ArrayList getSavedRuleNames(){
       ArrayList<String> ruleNames = new ArrayList();
       this.lineReaderFile();
       
       for (String s : text){
            String[] arrOfStr = s.split(";", -2);
            ruleNames.add(arrOfStr[0]);
        }
       
        return ruleNames;
    }

    public static void main(String[] args) {
        Leitor_Regras_Guardadas l = new Leitor_Regras_Guardadas("C:\\Users\\Miguel\\OneDrive\\Ambiente de Trabalho\\testfile.txt");
        l.getSavedRuleNames();
    }
}
