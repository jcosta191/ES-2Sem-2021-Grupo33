package com.iscte.ProjetoES;

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

        
        private JCheckBox AND ;
        private JCheckBox OR ;

        public GUI_Change_Rule(String s) throws UnsupportedLookAndFeelException {
            this.addFrameContent(s);
    		this.s = s;
            this.frame.setDefaultCloseOperation(2);
        }



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

            JTMax1 = new JTextField();
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
             
              JTMax2 = new JTextField();
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
             
              JTMax4 = new JTextField();
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
             
            JTMax5 = new JTextField();
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
            
	          JLabel AndLabel = new JLabel("AND");
	         AndLabel.setHorizontalAlignment(SwingConstants.CENTER);
	          c.gridx = 1;
	         c.gridy = 6;
	         c.insets = new Insets(1,1,5,5);
	         panel.add(AndLabel, c);
	          
	         AND = new JCheckBox();
	         AND.setHorizontalAlignment(SwingConstants.CENTER);
	         c.gridx = 2;
	          c.gridy = 6;
	          c.insets = new Insets(1,1,5,5);
	          panel.add(AND, c);
	         
	         JLabel OrLabel = new JLabel("OR");
	        OrLabel.setHorizontalAlignment(SwingConstants.CENTER);
	         c.gridx = 3;
	        c.gridy = 6;
	        c.insets = new Insets(1,1,5,5);
	        panel.add(OrLabel, c);
	         
	         OR = new JCheckBox();
	         OR.setHorizontalAlignment(SwingConstants.CENTER);
	        c.gridx = 4;
	         c.gridy = 6;
	         c.insets = new Insets(1,1,5,5);
	         panel.add(OR, c);
            
            JButton button = new JButton("Alterar Regra");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridwidth = 20;
            c.gridx = 0;
            c.gridy = 7;
            c.ipady =30;
            panel.add(button, c);
            c.gridwidth =1;
            

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
