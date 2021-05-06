package com.iscte.ProjetoES;

    import java.awt.*;
import java.awt.event.*;
    import java.util.ArrayList;
    import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import GUI_Regras_Guardadas.Leitor_Regras_Guardadas;

    public class GUISelecionadorDeRegras extends JFrame {
    	

        private JPanel panel = new JPanel();
        private JFrame frame = new JFrame("Selecione as Regras        (CTRL para selecionar várias)"); 
        private JList<String> list = null;
      

        public GUISelecionadorDeRegras() throws UnsupportedLookAndFeelException {
            
            // LISTA TESTE
          ArrayList<String> ruleNames;
          Leitor_Regras_Guardadas l = new Leitor_Regras_Guardadas("C:\\\\Users\\\\Miguel\\\\OneDrive\\\\Ambiente de Trabalho\\\\testfile.txt");
          ruleNames = l.getSavedRuleNames();
            
           list = new JList<String>(ruleNames.toArray(new String[ruleNames.size()]));
            
            this.addFrameContent();
            this.frame.setDefaultCloseOperation(2);
        }



        public void open() throws UnsupportedLookAndFeelException {
            this.frame.setVisible(true);
            this.frame.setSize(600,200);
           
            Point d3 = new Point();
            
    		d3.x = (int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-this.frame.getWidth()/2);
    		d3.y = (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-this.frame.getHeight()/2);
    		
    		this.frame.setLocation(d3);
    		this.frame.setResizable(false);
            
        }

        public void addFrameContent() throws UnsupportedLookAndFeelException {
        	
        	JScrollPane scrollPane = new JScrollPane();
        	scrollPane.setViewportView(list);
        	list.setLayoutOrientation(JList.VERTICAL);
        	DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();
        	renderer.setHorizontalAlignment(SwingConstants.CENTER);

        	JButton SelecionarRegras = new JButton("Selecionar Regras");
        	
        	class ListenerSelecionarRegras implements ActionListener {
    			
    			public void actionPerformed ( ActionEvent e ) {
    				for(String seleção : list.getSelectedValuesList()) {
    					System.out.println(seleção);
    				}
    			}
    		}
            
    		SelecionarRegras.addActionListener(new ListenerSelecionarRegras());
        	
        	frame.add(scrollPane, BorderLayout.NORTH);
        	frame.add(SelecionarRegras,BorderLayout.SOUTH);
        	
           // this.frame.getContentPane().add(panel, BorderLayout.NORTH);   
        	

       }
        
        public static void main(String[] args) {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    try {
                    	
                        JFrame.setDefaultLookAndFeelDecorated(true);
                        MetalLookAndFeel.setCurrentTheme(new OceanTheme());
                        UIManager.setLookAndFeel(new MetalLookAndFeel());
                        GUISelecionadorDeRegras picker = new GUISelecionadorDeRegras();
                        picker.open();
                        
                    } catch (UnsupportedLookAndFeelException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        
    }


