package com.iscte.ProjetoES;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalTheme;
import javax.swing.plaf.metal.OceanTheme;

import org.junit.runners.model.FrameworkMethod;

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
            
            // LISTA TESTE
        	 ArrayList<String> ruleNames;
             Leitor_Regras_Guardadas l = new Leitor_Regras_Guardadas("C:\\\\Users\\\\Miguel\\\\OneDrive\\\\Ambiente de Trabalho\\\\testfile.txt");
             ruleNames = l.getSavedRuleNames();
               
              list = new JList<String>(ruleNames.toArray(new String[ruleNames.size()]));
            
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