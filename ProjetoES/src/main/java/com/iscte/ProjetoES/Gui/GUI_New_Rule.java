package com.iscte.ProjetoES.Gui;

import com.iscte.ProjetoES.Historico.Saver;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class GUI_New_Rule {

    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("Select Rule");
    private String s;
    private Saver saver = new Saver();
    private JTextField JTNomeDaRegra;
    //AND = 0 , OR = 1;

    private JLabel NumeroDeLinhasPorClasse;
    private JTextField JTMax1;


    private JLabel NumeroDeMetodosPorClasse;
    private JTextField JTMax2;


    private JLabel ComplexidadeCiclomaticaDaClasse;
    private JTextField JTMax3;


    private JLabel ComplexidadeCiclomaticaDoMetodo;
    private JTextField JTMax4;


    private JLabel NumeroDeLinhasDeCodigoDoMetodo;
    private JTextField JTMax5;


    private JCheckBox AND;
    private JCheckBox OR;


    public GUI_New_Rule(String s) throws UnsupportedLookAndFeelException {
        this.addFrameContent(s);

        this.frame.setDefaultCloseOperation(2);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame.setDefaultLookAndFeelDecorated(true);
                    MetalLookAndFeel.setCurrentTheme(new OceanTheme());
                    UIManager.setLookAndFeel(new MetalLookAndFeel());
                    GUI_New_Rule rule = new GUI_New_Rule("Define Rule");
                    rule.open();
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    public void open() throws UnsupportedLookAndFeelException {
        this.frame.setVisible(true);
        this.frame.setSize(700, 350);

        Point d3 = new Point();

        d3.x = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2) - this.frame.getWidth() / 2);
        d3.y = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) - this.frame.getHeight() / 2);

        this.frame.setLocation(d3);
        this.frame.setResizable(false);

    }

    public void addFrameContent(String s) throws UnsupportedLookAndFeelException, NullPointerException {

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        panel.setLayout(layout);

        this.frame.getContentPane().add(panel, BorderLayout.NORTH);

        c.weightx = 0.5;
        c.weighty = 0.5;

        JLabel NomeDaRegra = new JLabel("Nome da Regra: ");
        NomeDaRegra.setFont(new Font("Arial", Font.BOLD, 20));
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        panel.add(NomeDaRegra, c);

        JTNomeDaRegra = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 10;
        c.ipady = 10;
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        panel.add(JTNomeDaRegra, c);
        c.gridwidth = 1;

        NumeroDeLinhasPorClasse = new JLabel("N??mero de linhas por classe: ");
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0, 5, 5, 5);
        panel.add(NumeroDeLinhasPorClasse, c);


        JLabel Max1 = new JLabel("M??x: ");
        Max1.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(1, 0, 5, 5);
        panel.add(Max1, c);

        JTMax1 = new JTextField();
        c.gridx = 3;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 5, 5);
        panel.add(JTMax1, c);


        NumeroDeMetodosPorClasse = new JLabel("N??mero de m??todos por classe: ");
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(5, 5, 5, 5);
        panel.add(NumeroDeMetodosPorClasse, c);

        JLabel Max2 = new JLabel("Max: ");
        Max2.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(1, 1, 5, 5);
        panel.add(Max2, c);

        JTMax2 = new JTextField();
        c.gridx = 3;
        c.gridy = 2;
        c.insets = new Insets(1, 1, 5, 5);
        panel.add(JTMax2, c);


        ComplexidadeCiclomaticaDaClasse = new JLabel("Complexidade Ciclom??tica da classe: ");
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(5, 5, 5, 5);
        panel.add(ComplexidadeCiclomaticaDaClasse, c);

        JLabel Max3 = new JLabel("Max: ");
        Max3.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridx = 2;
        c.gridy = 3;
        c.insets = new Insets(1, 1, 5, 5);
        panel.add(Max3, c);

        JTMax3 = new JTextField();
        c.gridx = 3;
        c.gridy = 3;
        c.insets = new Insets(1, 1, 5, 5);
        panel.add(JTMax3, c);


        ComplexidadeCiclomaticaDoMetodo = new JLabel("Complexidade Ciclom??tica do m??todo: ");
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(5, 5, 5, 5);
        panel.add(ComplexidadeCiclomaticaDoMetodo, c);

        JLabel Max4 = new JLabel("Max: ");
        Max4.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridx = 2;
        c.gridy = 4;
        c.insets = new Insets(1, 1, 5, 5);
        panel.add(Max4, c);

        JTMax4 = new JTextField();
        c.gridx = 3;
        c.gridy = 4;
        c.insets = new Insets(1, 1, 5, 5);
        panel.add(JTMax4, c);


        NumeroDeLinhasDeCodigoDoMetodo = new JLabel("N??mero de linhas de c??digo do m??todo: ");
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(5, 5, 5, 5);
        panel.add(NumeroDeLinhasDeCodigoDoMetodo, c);


        JLabel Max5 = new JLabel("Max: ");
        Max5.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridx = 2;
        c.gridy = 5;
        c.insets = new Insets(1, 1, 5, 5);
        panel.add(Max5, c);

        JTMax5 = new JTextField();
        c.gridx = 3;
        c.gridy = 5;
        c.insets = new Insets(1, 1, 5, 5);
        panel.add(JTMax5, c);


        JLabel OperadorLogico = new JLabel(" Operador Logico : ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(1, 1, 5, 5);
        panel.add(OperadorLogico, c);

        JLabel AndLabel = new JLabel("AND/OR  Checked/Unchecked");
        AndLabel.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(1, 1, 5, 5);
        panel.add(AndLabel, c);
        JLabel EmptyLabel = new JLabel("");

        AndLabel.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridx = 2;
        c.gridy = 6;
        c.insets = new Insets(1, 1, 5, 5);
        panel.add(AndLabel, c);

        AND = new JCheckBox();
        AND.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridx = 3;
        c.gridy = 6;
        c.insets = new Insets(1, 1, 5, 5);
        panel.add(AND, c);

        JButton DefinirRegra = new JButton("Definir Regra");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 20;
        c.gridx = 0;
        c.gridy = 7;
        c.ipady = 30;
        c.insets = new Insets(0, 0, 0, 0);

        class ListenerDefinirRegra implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                SaveRule();
            }
        }

        DefinirRegra.addActionListener(new ListenerDefinirRegra());
        panel.add(DefinirRegra, c);
        c.gridwidth = 1;

    }

    public void DataInserTester(JLabel labelName, JTextField JTMax, JTextField JTMin, JCheckBox AndBox, JCheckBox OrBox) {

        if (JTMax != null || JTMin != null)
            if (AndBox.isSelected() || OrBox.isSelected()) {

                System.out.println(labelName.getText());

                if (AndBox.isSelected()) {

                    if (!JTMin.getText().equals("") && !JTMax.getText().equals(""))
                        System.out.println(" --> [ " + JTMin.getText() + ", " + JTMax.getText() + "]");

                    if (!JTMin.getText().equals("") && JTMax.getText().equals(""))
                        System.out.println(" --> [" + JTMin.getText() + ", + ???]");

                    if (JTMin.getText().equals("") && !JTMax.getText().equals(""))
                        System.out.println(" --> [ 0 , " + JTMax.getText() + "]");
                }
                if (OrBox.isSelected() && AndBox.isSelected() == false) {

                    if (!JTMin.getText().equals("") && !JTMax.getText().equals(""))
                        System.out.println(" --> [" + JTMin.getText() + ", + ???]" + " [" + JTMax.getText() + ", 0]");

                    //if(!JTMin.getText().equals("") && JTMax.getText().equals(""))

                    //if(JTMin.getText().equals("") && !JTMax.getText().equals(""))


                }
            }
    }

    /**
     * Fun????o para extrair os parametros dados por input do utilizador e escrever no ficheiro usado para guardar regras
     * @author Bernardo Marques
     */
    public void SaveRule(){
        ArrayList<String> regraGuardada = new ArrayList<>();
        String rulename = JTNomeDaRegra.getText();
        String max1 = JTMax1.getText();
        String max2 = JTMax2.getText();
        String max3 = JTMax3.getText();
        String max4 = JTMax4.getText();
        String max5 = JTMax5.getText();
        regraGuardada.add(rulename);
        regraGuardada.add(max1);
        regraGuardada.add(max2);
        regraGuardada.add(max3);
        regraGuardada.add(max4);
        regraGuardada.add(max5);
        if(AND.isSelected()){
            regraGuardada.add("1");
        }else{
            regraGuardada.add("0");
        }
        try {
            saver.writeRule(regraGuardada, "RuleFile.txt");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
