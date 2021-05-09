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
            
            // Inicialização da lista retirada do ficheiro .txt (que nos permite guardar as regras)
          ArrayList<String> ruleNames;
          Leitor_Regras_Guardadas l = new Leitor_Regras_Guardadas("RuleFile.txt");
          ruleNames = l.getSavedRuleNames();
            
           list = new JList<String>(ruleNames.toArray(new String[ruleNames.size()]));
            
            this.addFrameContent();
            this.frame.setDefaultCloseOperation(2);
        }

      //método open torna a janela visivel e permite o começo da sua utilização
        public void open() throws UnsupportedLookAndFeelException {
            this.frame.setVisible(true);
            this.frame.setSize(600,215);
           
            Point d3 = new Point();
            
    		d3.x = (int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-this.frame.getWidth()/2);
    		d3.y = (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-this.frame.getHeight()/2);
    		
    		this.frame.setLocation(d3);
    		this.frame.setResizable(false);
            
        }

        public void addFrameContent() throws UnsupportedLookAndFeelException {
        	//Adicionada uma scroll list com as regras existentes, com dois botões Editar e Selecionar, é possivel escolher varios resultados
        	JScrollPane scrollPane = new JScrollPane();
        	scrollPane.setViewportView(list);
        	list.setLayoutOrientation(JList.VERTICAL);
        	DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();
        	renderer.setHorizontalAlignment(SwingConstants.CENTER);
        	
        	JButton EditarRegras = new JButton("Editar Regras");
        	
        	class ListenerEditarRegras implements ActionListener {
    			
    			public void actionPerformed ( ActionEvent e ) {
    				for(String seleção : list.getSelectedValuesList()) {
    					System.out.println(seleção);
    				}
    			}
    		}
            
    		EditarRegras.addActionListener(new ListenerEditarRegras());

        	JButton SelecionarRegras = new JButton("Selecionar Regras");
        	
        	class ListenerSelecionarRegras implements ActionListener {
    			
    			public void actionPerformed ( ActionEvent e ) {
    				for(String seleção : list.getSelectedValuesList()) {
    					System.out.println(seleção);
    				}
    			}
    		}
            
    		SelecionarRegras.addActionListener(new ListenerSelecionarRegras());
    		
    		
        	scrollPane.setSize(600, 150);
        	frame.add(scrollPane, BorderLayout.NORTH);
        	
        	JPanel panelSouth = new JPanel();
        	panelSouth.setSize(600,50);
        	panelSouth.add(EditarRegras, BorderLayout.EAST);
        	panelSouth.add(SelecionarRegras,BorderLayout.WEST);
        	
        	frame.add(panelSouth, BorderLayout.SOUTH);
        	
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


