package com.iscte.ProjetoES.Gui;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import com.iscte.ProjetoES.Escritores.EscritorJTable;
import com.iscte.ProjetoES.Leitores.LeitorDiretorios;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JFrame.*;

public class GUI {
    private static List<JButton> buttonList = new ArrayList<>();
    private static JTextField txtChooseAFile = new JTextField("Nome do Ficheiro");
    
    private static String excelLocation;
    
    protected String name;
    protected String filepath;
   
    public static void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        addAButton("1) Extração das métricas de código", pane);
        ProcurarFicheiroButtonAction();
        addAButton("2) Importação e visualização das métricas", pane);
        VisualizarExtraçãoButtonAction();

        
        addAButton("Criar Regra", pane);
        NewRuleButtonAction();
        addAButton("Alterar Regra Existente", pane);
        ChangeRuleButtonAction();
        txtChooseAFile.setHorizontalAlignment(JTextField.CENTER);
        txtChooseAFile.setMaximumSize(new Dimension(400,500));
        pane.add(txtChooseAFile);
        
    }

    private static void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
        Dimension MaxSize = new Dimension(400,500);
        button.setMaximumSize(MaxSize);
        buttonList.add(button);
    }
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void NewRuleButtonAction(){
        JButton button = buttonList.get(2);
       button.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
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
       });
    }
   
    private static void ChangeRuleButtonAction(){
        JButton button = buttonList.get(3);
       button.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               javax.swing.SwingUtilities.invokeLater(new Runnable() {
                   public void run() {
                       try {
                           JFrame.setDefaultLookAndFeelDecorated(true);
                           MetalLookAndFeel.setCurrentTheme(new OceanTheme());
                           UIManager.setLookAndFeel(new MetalLookAndFeel());
                           GUI_Rule_Picker picker = new GUI_Rule_Picker("Pick a Rule");
                           picker.open();
                       } catch (UnsupportedLookAndFeelException e) {
                           e.printStackTrace();
                       }
                   }
               });
           }
       });
    }
    
    private static void ProcurarFicheiroButtonAction(){
        JButton button = buttonList.get(0);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LeitorDiretorios java = new LeitorDiretorios();
				java.openDir();
			}
		});
    }

    private static void VisualizarExtraçãoButtonAction(){
        JButton button = buttonList.get(1);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//mostar o ficheiro excel gerado numa nova janela
				EscritorJTable a = new EscritorJTable();
				a.openFile();  //preciso fazer com que volte a Janela inicial
			}
		});
    }
    
    private static void createAndShowGUI() throws UnsupportedLookAndFeelException {
        JFrame.setDefaultLookAndFeelDecorated(true);
        MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        UIManager.setLookAndFeel(new MetalLookAndFeel());
        JFrame frame = new JFrame("CodeQualityAssessor - Option Selector");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400,200);
        frame.setResizable(true);
        Point d3 = new Point();
		d3.x = (int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-frame.getWidth()/2);
		d3.y = (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-frame.getHeight()/2);
		frame.setLocation(d3);
        MouseWheelListener mouseWheelListener = null;
        frame.addMouseWheelListener(mouseWheelListener);
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public static String getLocation() {
		return excelLocation;
	}
	public void setLocation() {
		excelLocation = filepath + "/" + name + "_metrics.xls";
	}
}
