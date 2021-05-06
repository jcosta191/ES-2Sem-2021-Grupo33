package Regra;

//import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Saver {
//    private String SafeRegras;
// new Regra (String name,int a, int b, int c, int d, int e, int lop);
    public Saver(Regras r) throws IOException {
/*        File regraSafe = new File( String SafeRegras);
        regraSafe.createNewFile();
*/
        FileWriter fw = new FileWriter("myfile.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        out.println(r.nome+";");
        for(int limite: r.args)
            out.print(limite+";");
        out.print(r.lop);
        out.close();
        bw.close();
        fw.close();
    }
}
