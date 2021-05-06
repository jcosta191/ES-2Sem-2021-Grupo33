package GUI_Regras_Guardadas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Saver {
    private ArrayList<String> rule=new ArrayList<>();
    public Saver() {
/*       this.rule= rule;
*/  }

    public void  writeRule(ArrayList<String> rule) throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\berna\\OneDrive\\Ambiente de Trabalho\\testfile.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        for(String ruleargument: rule) {
            bw.write(ruleargument + ";");
        }
        bw.newLine();
        bw.close();
        fw.close();
    }
}
