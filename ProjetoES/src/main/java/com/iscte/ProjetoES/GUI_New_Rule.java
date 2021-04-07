package com.iscte.ProjetoES;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalTheme;
import javax.swing.plaf.metal.OceanTheme;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.UIManager.setLookAndFeel;

public class GUI_New_Rule {
        private JFrame frame = new JFrame("Select Rule");
        private String s;

        public GUI_New_Rule(String s) throws UnsupportedLookAndFeelException {
            this.addFrameContent(s);
            this.frame.setDefaultCloseOperation(3);
        }



        public void open() throws UnsupportedLookAndFeelException {
            this.frame.setVisible(true);
            this.frame.setSize(300, 150);
        }

        public void addFrameContent(String s) throws UnsupportedLookAndFeelException {
           this.frame.setLayout(new GridLayout(0,6));
            addALabel("Nome da regra:", frame);
            addATextField(frame);
            addALabel("", frame);
            addALabel("", frame);
            addALabel("", frame);
            addAButton("Definir Regra", frame);
           addALabel("Número de linhas por classe: ", frame);
           addALabel("Max: ", frame);
           addATextField(frame);
           addALabel("Min: ", frame);
           addATextField(frame);
           addACheckBox(frame);
            addALabel("Número de métodos por classe: ", frame);
            addALabel("Max: ", frame);
            addATextField(frame);
            addALabel("Min: ", frame);
            addATextField(frame);
            addACheckBox(frame);
            addALabel("Complexidade Ciclomática da classe: ", frame);
            addALabel("Max: ", frame);
            addATextField(frame);
            addALabel("Min: ", frame);
            addATextField(frame);
            addACheckBox(frame);
            addALabel("Complexidade Ciclomática do método: ", frame);
            addALabel("Max: ", frame);
            addATextField(frame);
            addALabel("Min: ", frame);
            addATextField(frame);
            addACheckBox(frame);
            addALabel("Número de linhas de código do método: ", frame);
            addALabel("Max: ", frame);
            addATextField(frame);
            addALabel("Min: ", frame);
            addATextField(frame);
            addACheckBox(frame);
        }
    private static void addAButton(String text, JFrame frame) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        frame.add(button);
    }
    private static void addALabel(String text, JFrame frame){
            JLabel label = new JLabel(text);
            label.setAlignmentX(Component.LEFT_ALIGNMENT);
            frame.add(label);
    }
    private static void addATextField(JFrame frame){
            JTextField field = new JTextField();
            field.setAlignmentX(Component.LEFT_ALIGNMENT);
            frame.add(field);
    }
    private static void addACheckBox(JFrame frame){
            JCheckBox box = new JCheckBox();
            box.setAlignmentX(Component.LEFT_ALIGNMENT);
            frame.add(box);
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

