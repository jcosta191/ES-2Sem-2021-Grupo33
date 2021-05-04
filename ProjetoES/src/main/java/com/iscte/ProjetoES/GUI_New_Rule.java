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

public class GUI_New_Rule {
	
        private JPanel panel = new JPanel();
        private JFrame frame = new JFrame("Select Rule");
        private String s;
        
        private JTextField JTNomeDaRegra;        
        //AND = 0 , OR = 1;
        private JTextField   JTOperadorLogico;
        
        private JLabel NumeroDeLinhasPorClasse;
        private JTextField JTMax1 ;
        private JTextField JTMin1 ;

        
        private JLabel NumeroDeMetodosPorClasse;
        private JTextField JTMax2 ;
        private JTextField JTMin2 ;

        
        private JLabel ComplexidadeCiclomaticaDaClasse;
        private JTextField JTMax3 ;
        private JTextField JTMin3 ;

        private JLabel ComplexidadeCiclomaticaDoMetodo;
        private JTextField JTMax4 ;
        private JTextField JTMin4 ;

        
        private JLabel NumeroDeLinhasDeCodigoDoMetodo;
        private JTextField JTMax5 ;
        private JTextField JTMin5 ;
        
        private JCheckBox AND ;
        private JCheckBox OR ;
        
        

        public GUI_New_Rule(String s) throws UnsupportedLookAndFeelException {
            this.addFrameContent(s);
    		
            this.frame.setDefaultCloseOperation(2);
        }



        public void open() throws UnsupportedLookAndFeelException {
            this.frame.setVisible(true);
            this.frame.setSize(700,350);
           
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
            
             JTNomeDaRegra = new JTextField();
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridwidth = 10;
            c.ipady = 10;
            c.gridx = 1;
            c.gridy = 0;
            c.insets = new Insets(5,5,5,5);
            panel.add(JTNomeDaRegra, c);
            c.gridwidth = 1;
            
           NumeroDeLinhasPorClasse = new JLabel("Número de linhas por classe: ");
           c.gridx = 0;
           c.gridy = 1;
           c.insets = new Insets(0,5,5,5);
           panel.add(NumeroDeLinhasPorClasse, c);
          

           JLabel Max1 = new JLabel("Máx: ");
           Max1.setHorizontalAlignment(SwingConstants.CENTER);
           c.gridx = 1;
           c.gridy = 1;
           c.insets = new Insets(1,0,5,5);
           panel.add(Max1, c);

           JTMax1 = new JTextField();
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

            JTMin1 = new JTextField();
           c.gridx = 4;
           c.gridy = 1;
           c.insets = new Insets(1,1,5,5);
           panel.add(JTMin1, c);

            
            NumeroDeMetodosPorClasse = new JLabel("Número de métodos por classe: ");
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
            
             JTMax2 = new JTextField();
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
            
             JTMin2 = new JTextField();
            c.gridx = 4;
            c.gridy = 2;
            c.insets = new Insets(1,1,5,5);
            panel.add(JTMin2, c);
            

            
            ComplexidadeCiclomaticaDaClasse = new JLabel("Complexidade Ciclomática da classe: ");
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
            
             JTMax3 = new JTextField();
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
            
             JTMin3 = new JTextField();
            c.gridx = 4;
            c.gridy = 3;
            c.insets = new Insets(1,1,5,5);
            panel.add(JTMin3, c);
            
            
            ComplexidadeCiclomaticaDoMetodo= new JLabel("Complexidade Ciclomática do método: ");
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
            
             JTMax4 = new JTextField();
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
            
             JTMin4 = new JTextField();
            c.gridx = 4;
            c.gridy = 4;
            c.insets = new Insets(1,1,5,5);
            panel.add(JTMin4, c);
            
            
            NumeroDeLinhasDeCodigoDoMetodo = new JLabel("Número de linhas de código do método: ");
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
            
           JTMax5 = new JTextField();
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
            
             JTMin5 = new JTextField();
            c.gridx = 4;
            c.gridy = 5;
            c.insets = new Insets(1,1,5,5);
            panel.add(JTMin5, c);
            
            
            JLabel OperadorLogico = new JLabel("Operador Logico ( E = 0 , OU = 1 ) : ");
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
           
            
            JButton DefinirRegra = new JButton("Definir Regra");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridwidth = 20;
            c.gridx = 0;
            c.gridy = 7;
            c.ipady =30;
            c.insets = new Insets(0,0,0,0);
            
            class ListenerDefinirRegra implements ActionListener {
    			
    			public void actionPerformed ( ActionEvent e ) {

    			}
    		}
            
    		DefinirRegra.addActionListener(new ListenerDefinirRegra());
            panel.add(DefinirRegra, c);
            c.gridwidth = 1;

       }
        
        public void DataInserTester(JLabel labelName , JTextField JTMax, JTextField JTMin, JCheckBox AndBox , JCheckBox OrBox) {
        	
        	if(JTMax != null || JTMin != null)
				if(AndBox.isSelected() || OrBox.isSelected()) {
					
					System.out.println(labelName.getText());
					
					if(AndBox.isSelected()) {
						
						if(!JTMin.getText().equals("") && !JTMax.getText().equals(""))
							System.out.println(" --> [ "+JTMin.getText()+", "+JTMax.getText()+"]");
						
						if(!JTMin.getText().equals("") && JTMax.getText().equals(""))
							System.out.println(" --> ["+JTMin.getText()+", + ∞]");
						
						if(JTMin.getText().equals("") && !JTMax.getText().equals(""))
							System.out.println(" --> [ 0 , "+JTMax.getText()+"]");
					}
					if(OrBox.isSelected() && AndBox.isSelected()==false) {
					
					if(!JTMin.getText().equals("") && !JTMax.getText().equals(""))
					System.out.println(" --> ["+JTMin.getText()+", + ∞]" + " ["+JTMax.getText()+", 0]");
					
					//if(!JTMin.getText().equals("") && JTMax.getText().equals(""))
						
					//if(JTMin.getText().equals("") && !JTMax.getText().equals(""))
					
					
					}
				}
        }

        public static void main(String[] args) {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    try {
                        JFrame.setDefaultLookAndFeelDecorated(true);
                        MetalLookAndFeel.setCurrentTheme(new OceanTheme());
                        UIManager.setLookAndFeel(new MetalLookAndFeel());
                        GUI_New_Rule rule=new GUI_New_Rule("Define Rule");
                        rule.open();
                    } catch (UnsupportedLookAndFeelException e) {
                        e.printStackTrace();
                    }
                }
            });


        }
    }

