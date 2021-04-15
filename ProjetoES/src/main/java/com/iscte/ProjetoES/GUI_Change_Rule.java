package com.iscte.ProjetoES;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalTheme;
import javax.swing.plaf.metal.OceanTheme;

import org.junit.runners.model.FrameworkMethod;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.UIManager.setLookAndFeel;

public class GUI_Change_Rule {
	
        private JPanel panel = new JPanel();
        private JFrame frame = new JFrame("Change Rule");
        private String s;

        public GUI_Change_Rule(String s) throws UnsupportedLookAndFeelException {
            this.addFrameContent(s);
    		this.s = s;
            this.frame.setDefaultCloseOperation(2);
        }



        public void open() throws UnsupportedLookAndFeelException {
            this.frame.setVisible(true);
            this.frame.setSize(800,310);
           
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
            
           JLabel NumeroDeLinhasPorClasse = new JLabel("Número de linhas por classe: ");
           c.gridx = 0;
           c.gridy = 1;
           c.insets = new Insets(0,5,5,5);
           panel.add(NumeroDeLinhasPorClasse, c);
          

           JLabel Max1 = new JLabel("Max: ");
           Max1.setHorizontalAlignment(SwingConstants.CENTER);
           c.gridx = 1;
           c.gridy = 1;
           c.insets = new Insets(1,0,5,5);
           panel.add(Max1, c);

           JTextField JTMax1 = new JTextField();
           c.gridx = 2;
           c.gridy = 1;
           c.gridwidth = 1;
           c.insets = new Insets(0,0,5,5);
           panel.add(JTMax1, c);
           
           JLabel Min1 = new JLabel("Min: ");
           Min1.setHorizontalAlignment(SwingConstants.CENTER);
           c.gridx = 3;
           c.gridy = 1;
           c.insets = new Insets(0,0,5,5);
           panel.add(Min1, c);

           JTextField JTMin1 = new JTextField();
           c.gridx = 4;
           c.gridy = 1;
           c.insets = new Insets(1,1,5,5);
           panel.add(JTMin1, c);
           
           JLabel AndLabel1 = new JLabel("AND");
           AndLabel1.setHorizontalAlignment(SwingConstants.CENTER);
           c.gridx = 5;
           c.gridy = 1;
           c.insets = new Insets(0,0,5,5);
           panel.add(AndLabel1, c);
           
           JCheckBox AndBox1 = new JCheckBox();
           AndBox1.setHorizontalAlignment(SwingConstants.CENTER);
           c.gridx = 6;
           c.gridy = 1;
           c.insets = new Insets(0,0,5,5);
           panel.add(AndBox1, c);
           
           JLabel OrLabel1 = new JLabel("OR");
           OrLabel1.setHorizontalAlignment(SwingConstants.CENTER);
           c.gridx = 7;
           c.gridy = 1;
           c.insets = new Insets(0,0,5,5);
           panel.add(OrLabel1, c);
           
           JCheckBox OrBox1 = new JCheckBox();
           OrBox1.setHorizontalAlignment(SwingConstants.CENTER);
           c.gridx = 8;
           c.gridy = 1;
           c.insets = new Insets(0,0,5,5);
           panel.add(OrBox1, c);
            
            JLabel NumeroDeMetodosPorClasse = new JLabel("Número de métodos por classe: ");
            c.gridx = 0;
            c.gridy = 2;
            c.insets = new Insets(5,5,5,5);
            panel.add(NumeroDeMetodosPorClasse, c);
            
            JLabel Max2 = new JLabel("Max: ");
            Max2.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 1;
            c.gridy = 2;
            c.insets = new Insets(1,1,5,5);
            panel.add(Max2, c);
            
            JTextField JTMax2 = new JTextField();
            c.gridx = 2;
            c.gridy = 2;
            c.insets = new Insets(1,1,5,5);
            panel.add(JTMax2, c);
            
            JLabel Min2 = new JLabel("Min: ");
            Min2.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 3;
            c.gridy = 2;
            c.insets = new Insets(1,1,5,5);
            panel.add(Min2, c);
            
            JTextField JTMin2 = new JTextField();
            c.gridx = 4;
            c.gridy = 2;
            c.insets = new Insets(1,1,5,5);
            panel.add(JTMin2, c);
            
            JLabel AndLabel2 = new JLabel("AND");
            AndLabel2.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 5;
            c.gridy = 2;
            c.insets = new Insets(0,0,5,5);
            panel.add(AndLabel2, c);
            
            JCheckBox AndBox2 = new JCheckBox();
            AndBox2.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 6;
            c.gridy = 2;
            c.insets = new Insets(0,0,5,5);
            panel.add(AndBox2, c);
            
            JLabel OrLabel2 = new JLabel("OR");
            OrLabel2.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 7;
            c.gridy = 2;
            c.insets = new Insets(0,0,5,5);
            panel.add(OrLabel2, c);
            
            JCheckBox OrBox2 = new JCheckBox();
            OrBox2.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 8;
            c.gridy = 2;
            c.insets = new Insets(0,0,5,5);
            panel.add(OrBox2, c);
            
            JLabel ComplexidadeCiclomaticaDaClasse = new JLabel("Complexidade Ciclomática da classe: ");
            c.gridx = 0;
            c.gridy = 3;
            c.insets = new Insets(5,5,5,5);
            panel.add(ComplexidadeCiclomaticaDaClasse, c);
           
            JLabel Max3 = new JLabel("Max: ");
            Max3.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 1;
            c.gridy = 3;
            c.insets = new Insets(1,1,5,5);
            panel.add(Max3, c);
            
            JTextField JTMax3 = new JTextField();
            c.gridx = 2;
            c.gridy = 3;
            c.insets = new Insets(1,1,5,5);
            panel.add(JTMax3, c);
            
            JLabel Min3 = new JLabel("Min: ");
            Min3.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 3;
            c.gridy = 3;
            c.insets = new Insets(1,1,5,5);
            panel.add(Min3, c);
            
            JTextField JTMin3 = new JTextField();
            c.gridx = 4;
            c.gridy = 3;
            c.insets = new Insets(1,1,5,5);
            panel.add(JTMin3, c);
            
            JLabel AndLabel3 = new JLabel("AND");
            AndLabel3.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 5;
            c.gridy = 3;
            c.insets = new Insets(0,0,5,5);
            panel.add(AndLabel3, c);
            
            JCheckBox AndBox3 = new JCheckBox();
            AndBox3.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 6;
            c.gridy = 3;
            c.insets = new Insets(0,0,5,5);
            panel.add(AndBox3, c);
            
            JLabel OrLabel3 = new JLabel("OR");
            OrLabel3.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 7;
            c.gridy = 3;
            c.insets = new Insets(0,0,5,5);
            panel.add(OrLabel3, c);
            
            JCheckBox OrBox3 = new JCheckBox();
            OrBox3.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 8;
            c.gridy = 3;
            c.insets = new Insets(0,0,5,5);
            panel.add(OrBox3, c);
            
            JLabel ComplexidadeCiclomaticaDoMetodo= new JLabel("Complexidade Ciclomática do método: ");
            c.gridx = 0;
            c.gridy = 4;
            c.insets = new Insets(5,5,5,5);
            panel.add( ComplexidadeCiclomaticaDoMetodo, c);
            
            JLabel Max4 = new JLabel("Max: ");
            Max4.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 1;
            c.gridy = 4;
            c.insets = new Insets(1,1,5,5);
            panel.add(Max4, c);
            
            JTextField JTMax4 = new JTextField();
            c.gridx = 2;
            c.gridy = 4;
            c.insets = new Insets(1,1,5,5);
            panel.add(JTMax4, c);
            
            JLabel Min4 = new JLabel("Min: ");
            Min4.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 3;
            c.gridy = 4;
            c.insets = new Insets(1,1,5,5);
            panel.add(Min4, c);
            
            JTextField JTMin4 = new JTextField();
            c.gridx = 4;
            c.gridy = 4;
            c.insets = new Insets(1,1,5,5);
            panel.add(JTMin4, c);
            
            JLabel AndLabel4 = new JLabel("AND");
            AndLabel4.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 5;
            c.gridy = 4;
            c.insets = new Insets(0,0,5,5);
            panel.add(AndLabel4, c);
            
            JCheckBox AndBox4 = new JCheckBox();
            AndBox4.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 6;
            c.gridy = 4;
            c.insets = new Insets(0,0,5,5);
            panel.add(AndBox4, c);
            
            JLabel OrLabel4 = new JLabel("OR");
            OrLabel4.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 7;
            c.gridy = 4;
            c.insets = new Insets(0,0,5,5);
            panel.add(OrLabel4, c);
            
            JCheckBox OrBox4 = new JCheckBox();
            OrBox4.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 8;
            c.gridy = 4;
            c.insets = new Insets(0,0,5,5);
            panel.add(OrBox4, c);
            
            JLabel NumeroDeLinhasDeCodigoDoMetodo = new JLabel("Número de linhas de código do mtodo: ");
            c.gridx = 0;
            c.gridy = 5;
            c.insets = new Insets(5,5,5,5);
            panel.add( NumeroDeLinhasDeCodigoDoMetodo, c);
           
            
            JLabel Max5 = new JLabel("Max: ");
            Max5.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 1;
            c.gridy = 5;
            c.insets = new Insets(1,1,5,5);
            panel.add(Max5, c);
            
            JTextField JTMax5 = new JTextField();
            c.gridx = 2;
            c.gridy = 5;
            c.insets = new Insets(1,1,5,5);
            panel.add(JTMax5, c);
     
            JLabel Min5 = new JLabel("Min: ");
            Min5.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 3;
            c.gridy = 5;
            c.insets = new Insets(1,1,5,5);
            panel.add(Min5, c);
            
            JTextField JTMin5 = new JTextField();
            c.gridx = 4;
            c.gridy = 5;
            c.insets = new Insets(1,1,5,5);
            panel.add(JTMin5, c);
            
            JLabel AndLabel5 = new JLabel("AND");
            AndLabel5.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 5;
            c.gridy = 5;
            c.insets = new Insets(0,0,5,5);
            panel.add(AndLabel5, c);
            
            JCheckBox AndBox5 = new JCheckBox();
            AndBox5.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 6;
            c.gridy = 5;
            c.insets = new Insets(0,0,5,5);
            panel.add(AndBox5, c);
            
            JLabel OrLabel5 = new JLabel("OR");
            OrLabel5.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 7;
            c.gridy = 5;
            c.insets = new Insets(0,0,5,5);
            panel.add(OrLabel5, c);
            
            JCheckBox OrBox5 = new JCheckBox();
            OrBox5.setHorizontalAlignment(SwingConstants.CENTER);
            c.gridx = 8;
            c.gridy = 5;
            c.insets = new Insets(0,0,5,5);
            panel.add(OrBox5, c);
            
            JButton button = new JButton("Alterar Regra");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridwidth = 20;
            c.gridx = 0;
            c.gridy = 6;
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
