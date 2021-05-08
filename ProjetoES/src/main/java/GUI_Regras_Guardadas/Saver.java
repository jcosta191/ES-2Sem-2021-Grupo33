package GUI_Regras_Guardadas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Saver {
    private File path;
    private ArrayList<String> rule=new ArrayList<>();
    public Saver() {
/*       this.rule= rule;
*/  }
    public void createFile() throws IOException {
        path = new File("RuleFile.txt");
        path.createNewFile();
    }
    public void  writeRule(ArrayList<String> rule) throws IOException, NullPointerException {
        System.out.println("Im here");
        if(!(new File("RuleFile.txt")).isFile()){
            System.out.println("File created");
            createFile();
        }
        FileWriter fw = new FileWriter("RuleFile.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        for(String ruleargument: rule) {
            bw.write(ruleargument + ";");
        }
        bw.newLine();
        bw.close();
        fw.close();
    }
}
