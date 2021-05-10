package com.iscte.ProjetoES.Historico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
/**
 * Classe para escrever  regras no ficheiro RuleFiles.txt para guardar regras previamente criadas pelo utilizador.
 *
 *
 * @author Bernardo Marques
 *
 */
public class Saver {
    private File path;
    private ArrayList<String> rule=new ArrayList<>();
    public Saver() {
    }
    /**
     *Criador do ficheiro usado para guardar as regras
     *
     */
    public void createFile() throws IOException {
        path = new File("RuleFile.txt");
        path.createNewFile();
    }


    /**
     *Escrever uma nova regra no Ficheiro de guardar regras
     *
     */


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
    /**
     *Editar ficheiro desejado dada uma ArrayList contendo a informação e o path do ficheiro
     */

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