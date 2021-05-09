package com.iscte.ProjetoES.Gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalTheme;
import javax.swing.plaf.metal.OceanTheme;

import com.iscte.ProjetoES.Gui.GUI_Change_Rule;
//import org.junit.runners.model.FrameworkMethod;

import GUI_Regras_Guardadas.Leitor_Regras_Guardadas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import static javax.swing.UIManager.setLookAndFeel;

public class GUI_Rule_Picker {
	
        private JPanel panel = new JPanel();
        private JList<String> list = null;
        private JFrame frame = new JFrame("Escolha uma das regras existentes:     (Carregue duas vezes)");
        private String s;

        public GUI_Rule_Picker(String s) throws UnsupportedLookAndFeelException {
            
            // Inicialização da lista retirada do ficheiro .txt (que nos permite guardar as regras)
        	 ArrayList<String> ruleNames;
             Leitor_Regras_Guardadas l = new Leitor_Regras_Guardadas("RuleFile.txt");
             ruleNames = l.getSavedRuleNames();
               System.out.println(ruleNames);
              list = new JList<String>(ruleNames.toArray(new String[ruleNames.size()]));
            
              //para utilizar esta lista basta carregar duas vezes na regra que se deseja alterar.
            MouseListener mouseListener = new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {


                       String selectedItem = (String) list.getSelectedValue();
                       
                       try {
						GUI_Change_Rule ruleChanger = new GUI_Change_Rule(selectedItem);
						ruleChanger.open();
					} catch (UnsupportedLookAndFeelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                       
                     }
                }
            };
            list.addMouseListener(mouseListener);
            
            this.addFrameContent(s);
            this.frame.setDefaultCloseOperation(2);
        }


      //método open torna a janela visivel e permite o começo da sua utilização
        public void open() throws UnsupportedLookAndFeelException {
            this.frame.setVisible(true);
            this.frame.setSize(600,200);
           
            Point d3 = new Point();
            
    		d3.x = (int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-this.frame.getWidth()/2);
    		d3.y = (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-this.frame.getHeight()/2);
    		
    		this.frame.setLocation(d3);
    		this.frame.setResizable(false);
            
        }

        public void addFrameContent(String s) throws UnsupportedLookAndFeelException {
        	//adicionada uma scroll list para escolher uma regra a alterar, dois cliques.
        	JScrollPane scrollPane = new JScrollPane();
        	scrollPane.setViewportView(list);
        	list.setLayoutOrientation(JList.VERTICAL);
        	DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();
        	renderer.setHorizontalAlignment(SwingConstants.CENTER);
        	
        	frame.add(scrollPane);
        	
           // this.frame.getContentPane().add(panel, BorderLayout.NORTH);   
        	

       }
        
        public static void main(String[] args) {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    try {
                        JFrame.setDefaultLookAndFeelDecorated(true);
                        MetalLookAndFeel.setCurrentTheme(new OceanTheme());
                        UIManager.setLookAndFeel(new MetalLookAndFeel());
                        GUI_Rule_Picker picker=new GUI_Rule_Picker("Pick a Rule");
                        picker.open();
                    } catch (UnsupportedLookAndFeelException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        
        
    }