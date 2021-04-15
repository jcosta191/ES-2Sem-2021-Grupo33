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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import static javax.swing.UIManager.setLookAndFeel;

public class GUI_Rule_Picker {
	
        private JPanel panel = new JPanel();
        private JList<String> list = null;
        private JFrame frame = new JFrame("Escolha uma das regras existentes: ");
        private String s;

        public GUI_Rule_Picker(String s) throws UnsupportedLookAndFeelException {
            
            // LISTA TESTE
           ArrayList<String> myList = new ArrayList<>();
            myList = new ArrayList<>(10);
            
            for (int index = 1; index < 21; index++) {
               myList.add("Regra Numero " + index);
            }
            list = new JList<String>(myList.toArray(new String[myList.size()]));
            
            MouseListener mouseListener = new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {


                       String selectedItem = (String) list.getSelectedValue();
                       // add selectedItem to your second list.
                       System.out.println("Carregou em " + selectedItem);
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
            this.frame.setSize(300,200);
           
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