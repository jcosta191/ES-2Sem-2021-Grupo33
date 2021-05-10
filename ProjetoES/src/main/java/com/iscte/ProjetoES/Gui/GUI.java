package com.iscte.ProjetoES.Gui;

import com.iscte.ProjetoES.GUISelecionadorDeRegras;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.iscte.ProjetoES.Escritores.EscritorJTable;
import com.iscte.ProjetoES.Leitores.LeitorDiretorios;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


import static javax.swing.JFrame.*;

public class GUI {
    private static List<JButton> buttonList = new ArrayList<>();
    private static JTextField txtChooseAFile = new JTextField("Nome do Ficheiro");

    public static void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        //Criação dos botões e do textfield da janela inicial da GUI
        addAButton("Criar Regra", pane);
        NewRuleButtonAction();
        addAButton("Visualizar Extração das Métricas", pane);
        VisualizarExtraçãoButtonAction();
        addAButton("Alterar Regra Existente", pane);
        ChangeRuleButtonAction();
        addAButton("Procurar Ficheiro", pane);
        ProcurarFicheiroButtonAction();
        txtChooseAFile.setHorizontalAlignment(JTextField.CENTER);
        txtChooseAFile.setMaximumSize(new Dimension(600,500));
        pane.add(txtChooseAFile);
        addAButton("Importar Regras Existentes", pane);
        ImportarRegrasButtonAction();
    }

    //função para automatizar a criação de botões
    private static void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
        Dimension MaxSize = new Dimension(600,500);
        button.setMaximumSize(MaxSize);
        buttonList.add(button);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void NewRuleButtonAction(){
    	//acesso à lista de botões e implementação do listener do botão selecionado
        JButton button = buttonList.get(0);
       button.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               javax.swing.SwingUtilities.invokeLater(new Runnable() {
                   public void run() {
                       try {
                           JFrame.setDefaultLookAndFeelDecorated(true);
                           MetalLookAndFeel.setCurrentTheme(new OceanTheme());
                           UIManager.setLookAndFeel(new MetalLookAndFeel());
                           //lançamento da janela de criar nova regra
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
    	//acesso à lista de botões e implementação do listener do botão selecionado
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
                           // lançamento da janela de escolher regra para alterar
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
    	//acesso à lista de botões e implementação do listener do botão selecionado
        JButton button = buttonList.get(3);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LeitorDiretorios java = new LeitorDiretorios();
                java.openDir();
            }
        });
    }

    private static void ImportarRegrasButtonAction(){
    	//acesso à lista de botões e implementação do listener do botão selecionado
        JButton button = buttonList.get(4);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//mostar o ficheiro excel gerado numa nova janela
				GUISelecionadorDeRegras selecionador;
				try {
					//lançamento da janela que permite selecionar e editar as regras a alterar
					selecionador = new GUISelecionadorDeRegras();
					selecionador.open();
					selecionador.setVisible(true);  //preciso fazer com que volte a Janela inicial
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

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
                    try {
                        a.openFile();  //preciso fazer com que volte a Janela inicial
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (InvalidFormatException invalidFormatException) {
                        invalidFormatException.printStackTrace();
                    }
                }
            });
        }



    private static void createAndShowGUI() throws UnsupportedLookAndFeelException {
    	//Lançamento da gui e de especificações de visualização da frame
        JFrame.setDefaultLookAndFeelDecorated(true);
        MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        UIManager.setLookAndFeel(new MetalLookAndFeel());
        JFrame frame = new JFrame("CodeQualityAssessor - Option Selector");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600,200);
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
}
