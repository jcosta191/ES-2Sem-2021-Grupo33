package com.iscte.ProjetoES.Gui;

import GUI_Regras_Guardadas.Leitor_Regras_Guardadas;
import GUI_Regras_Guardadas.Saver;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalTheme;
import javax.swing.plaf.metal.OceanTheme;

//import org.junit.runners.model.FrameworkMethod;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import static javax.swing.UIManager.setLookAndFeel;

public class GUI_Change_Rule {
	
        private JPanel panel = new JPanel();
        private JFrame frame = new JFrame("Change Rule");
        private String s;
        
        private JLabel NumeroDeLinhasPorClasse;
        private JTextField JTMax1 ;


        
        private JLabel NumeroDeMetodosPorClasse;
        private JTextField JTMax2 ;

 
        
        private JLabel ComplexidadeCiclomaticaDaClasse;
        private JTextField JTMax3 ;

 
        
        private JLabel ComplexidadeCiclomaticaDoMetodo;
        private JTextField JTMax4 ;
 

        
        private JLabel NumeroDeLinhasDeCodigoDoMetodo;
        private JTextField JTMax5 ;

        private Leitor_Regras_Guardadas l = new Leitor_Regras_Guardadas("RuleFile.txt");
        
        private JCheckBox AND ;
        private JCheckBox OR ;

        public GUI_Change_Rule(String s) throws UnsupportedLookAndFeelException {
            this.addFrameContent(s);
    		this.s = s;
            this.frame.setDefaultCloseOperation(2);
        }


      //método open torna a janela visivel e permite o começo da sua utilização
        public void open() throws UnsupportedLookAndFeelException {
            this.frame.setVisible(true);
            this.frame.setSize(800,350);
           
            Point d3 = new Point();
            
    		d3.x = (int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-this.frame.getWidth()/2);
    		d3.y = (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-this.frame.getHeight()/2);
    		
    		this.frame.setLocation(d3);
    		this.frame.setResizable(false);
            
        }

        public void addFrameContent(String s) throws UnsupportedLookAndFeelException {
            // aqui optámos por utilizar um gridBagLayout() porque era mais fácil de posicionar os elementos no local desejado
            // a partir dos atributos gridx e gridy conseguimos colocar cada elemento criado na sua "coordenada" certa
            // os valores dos JTextField e das CheckBoxes foram guardados como atributos da classe para serem mais facilmente acessíveis
            GridBagLayout layout = new GridBagLayout();
            GridBagConstraints c = new GridBagConstraints();
            panel.setLayout(layout);

            this.frame.getContentPane().add(panel, BorderLayout.NORTH);

            ArrayList<String> allRules = new ArrayList<>();
            allRules = l.lineReaderFile();
            ArrayList<String> regra = new ArrayList<>();
            l.getRule(s, allRules,regra);


            c.weightx = 0.5;
            c.weighty = 0.5;

            JLabel NomeDaRegra = new JLabel("Nome da Regra: ");
            NomeDaRegra.setFont(new Font("Arial", Font.BOLD, 20));
            c.gridx = 0;
            c.gridy = 0;
            c.insets = new Insets(5,5,5,5);
            panel.add(NomeDaRegra, c);
            
            JLabel ActualNomeDaRegra = new JLabel(s);
            ActualNomeDaRegra.setHorizontalAlignment(SwingConstants.CENTER);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridwidth = 10;
            c.ipady = 10;
            c.gridx = 1;
            c.gridy = 0;
            c.insets = new Insets(5,5,5,5);
            panel.add(ActualNomeDaRegra, c);
            c.gridwidth = 1;
            
            NumeroDeLinhasPorClasse = new JLabel("Número de linhas por classe: ");
            c.gridx = 0;
            c.gridy = 1;
            c.insets = new Insets(0,5,5,5);
            panel.add(NumeroDeLinhasPorClasse, c);
           

            JLabel Max1 = new JLabel("Máx: ");
            Max1.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 2;
            c.gridy = 1;
            c.insets = new Insets(1,0,5,5);
            panel.add(Max1, c);

            JTMax1 = new JTextField(regra.get(1));
            c.gridx = 3;
            c.gridy = 1;
            c.gridwidth = 1;
            c.insets = new Insets(0,0,5,5);
            panel.add(JTMax1, c);

             NumeroDeMetodosPorClasse = new JLabel("Número de métodos por classe: ");
             c.gridx = 0;
             c.gridy = 2;
             c.insets = new Insets(5,5,5,5);
             panel.add(NumeroDeMetodosPorClasse, c);
             
             JLabel Max2 = new JLabel("Max: ");
             Max2.setHorizontalAlignment(SwingConstants.CENTER);
             c.gridx = 2;
             c.gridy = 2;
             c.insets = new Insets(1,1,5,5);
             panel.add(Max2, c);
             
              JTMax2 = new JTextField(regra.get(2));
             c.gridx = 3;
             c.gridy = 2;
             c.insets = new Insets(1,1,5,5);
             panel.add(JTMax2, c);

             ComplexidadeCiclomaticaDaClasse = new JLabel("Complexidade Ciclomática da classe: ");
             c.gridx = 0;
             c.gridy = 3;
             c.insets = new Insets(5,5,5,5);
             panel.add(ComplexidadeCiclomaticaDaClasse, c);
            
             JLabel Max3 = new JLabel("Max: ");
             Max3.setHorizontalAlignment(SwingConstants.CENTER);
             c.gridx = 2;
             c.gridy = 3;
             c.insets = new Insets(1,1,5,5);
             panel.add(Max3, c);
             
              JTMax3 = new JTextField();
             c.gridx = 3;
             c.gridy = 3;
             c.insets = new Insets(1,1,5,5);
             panel.add(JTMax3, c);
             
             
             
             ComplexidadeCiclomaticaDoMetodo= new JLabel("Complexidade Ciclomática do método: ");
             c.gridx = 0;
             c.gridy = 4;
             c.insets = new Insets(5,5,5,5);
             panel.add( ComplexidadeCiclomaticaDoMetodo, c);
             
             JLabel Max4 = new JLabel("Max: ");
             Max4.setHorizontalAlignment(SwingConstants.CENTER);
             c.gridx = 2;
             c.gridy = 4;
             c.insets = new Insets(1,1,5,5);
             panel.add(Max4, c);
             
              JTMax4 = new JTextField(regra.get(4));
             c.gridx = 3;
             c.gridy = 4;
             c.insets = new Insets(1,1,5,5);
             panel.add(JTMax4, c);
             
            
             
             
             NumeroDeLinhasDeCodigoDoMetodo = new JLabel("Número de linhas de código do método: ");
             c.gridx = 0;
             c.gridy = 5;
             c.insets = new Insets(5,5,5,5);
             panel.add( NumeroDeLinhasDeCodigoDoMetodo, c);
            
             
             JLabel Max5 = new JLabel("Max: ");
             Max5.setHorizontalAlignment(SwingConstants.CENTER);
             c.gridx = 2;
             c.gridy = 5;
             c.insets = new Insets(1,1,5,5);
             panel.add(Max5, c);
             
            JTMax5 = new JTextField(regra.get(5));
             c.gridx = 3;
             c.gridy = 5;
             c.insets = new Insets(1,1,5,5);
             panel.add(JTMax5, c);
     
         
            
            JLabel OperadorLogico = new JLabel(" Operador Logico : ");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 6;
            c.insets = new Insets(1,1,5,5);
            panel.add(OperadorLogico, c);
            
	          JLabel AndLabel = new JLabel("AND/OR Checked/Unchecked");
	         AndLabel.setHorizontalAlignment(SwingConstants.CENTER);
	          c.gridx = 1;
	         c.gridy = 6;
	         c.insets = new Insets(1,1,5,5);
	         panel.add(AndLabel, c);

            JLabel EmptyLabel = new JLabel("");
            AndLabel.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 2;
            c.gridy = 6;
            c.insets = new Insets(1,1,5,5);
            panel.add(EmptyLabel, c);

	         AND = new JCheckBox();
	         AND.setHorizontalAlignment(SwingConstants.CENTER);
	         c.gridx = 2;
	          c.gridy = 6;
	          c.insets = new Insets(1,1,5,5);
            if((Integer.parseInt(regra.get(6)))== 1) AND.setSelected(true);
	          panel.add(AND, c);

            JButton button = new JButton("Alterar Regra");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridwidth = 20;
            c.gridx = 0;
            c.gridy = 7;
            c.ipady =30;
            class ListenerDefinirRegra implements ActionListener {

                public void actionPerformed(ActionEvent e) {
                    SaveRule();
                }
            }
            button.addActionListener(new ListenerDefinirRegra());
            panel.add(button, c);
            c.gridwidth =1;
            

       }
    public void SaveRule(){
        ArrayList<String> regraGuardada = new ArrayList<>();
        ArrayList<String> allRules = l.lineReaderFile();
        Saver saver = new Saver();
        String max1 = JTMax1.getText();
        String max2 = JTMax2.getText();
        String max3 = JTMax3.getText();
        String max4 = JTMax4.getText();
        String max5 = JTMax5.getText();
        regraGuardada.add(s);
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
        l.EditText(s,regraGuardada,allRules);
        try {
            saver.EditRule(allRules, "RuleFile.txt");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

        public static void main(String[] args) {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    try {
                        JFrame.setDefaultLookAndFeelDecorated(true);
                        MetalLookAndFeel.setCurrentTheme(new OceanTheme());
                        UIManager.setLookAndFeel(new MetalLookAndFeel());
                        GUI_Change_Rule ruleChanger =new GUI_Change_Rule("Change Rule");
                        ruleChanger.open();
                    } catch (UnsupportedLookAndFeelException e) {
                        e.printStackTrace();
                    }
                }
            });


        }
    }
