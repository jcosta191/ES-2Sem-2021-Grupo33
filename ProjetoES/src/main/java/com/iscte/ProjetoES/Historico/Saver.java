package com.iscte.ProjetoES.Historico;

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
    //Escrever uma nova regra no Ficheiro de guardar regras
    public void  writeRule(ArrayList<String> rule, String pathname) throws IOException, NullPointerException {
        if(!(new File(pathname)).isFile()){
            System.out.println("File created");
            createFile();
        }
        FileWriter fw = new FileWriter(pathname, true);
        BufferedWriter bw = new BufferedWriter(fw);
        for(String ruleargument: rule) {
            bw.write(ruleargument + ";");
        }
        bw.newLine();
        bw.close();
        fw.close();
    }
    //Editar regra no ficheiro dado um novo array com a alteração efetuada
    public void EditRule(ArrayList<String> newRules, String pathname) throws IOException {
        FileWriter fw = new FileWriter(pathname, false);
        BufferedWriter bw = new BufferedWriter(fw);
        for(String ruleargument: newRules) {
            bw.write(ruleargument);
            bw.newLine();
        }
        bw.close();
        fw.close();
    }
}