package GUI_Regras_Guardadas;

    import java.awt.*;
import java.awt.event.*;
    import java.util.ArrayList;
    import javax.swing.*;

    public class GUISelecionadorDeRegras extends JFrame {
        final static int maxGap = 20;
        GridLayout layout = new GridLayout(0,2);

        public GUISelecionadorDeRegras(String name) {
            super(name);
            setResizable(false);
        }

        public void addComponentsToPane(final Container pane) {
            final JPanel compsToExperiment = new JPanel();
            //JScrollPane scrollPane = new JScrollPane(compsToExperiment);
            //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            compsToExperiment.setLayout(layout);

            //Set up components preferred size
            JButton b = new JButton("Just fake button");
            Dimension buttonSize = b.getPreferredSize();
            compsToExperiment.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 5.5)+maxGap,
                    (int)(buttonSize.getHeight() * 6.5)+maxGap * 3));

            ArrayList<String> ruleNames;
            Leitor_Regras_Guardadas l = new Leitor_Regras_Guardadas("C:\\Users\\berna\\OneDrive\\Ambiente de Trabalho\\testfile.txt");
            ruleNames = l.getSavedRuleNames();
            for (String s: ruleNames){
                compsToExperiment.add(new JLabel(s));
                compsToExperiment.add(new JCheckBox());
            }
            layout.setHgap(5);
            //Set up the vertical gap value
            layout.setVgap(5);
            //Set up the layout of the buttons
            layout.layoutContainer(compsToExperiment);
            pane.add(compsToExperiment, BorderLayout.NORTH);
        }

        /**
         * Create the GUI and show it.  For thread safety,
         * this method is invoked from the
         * event dispatch thread.
         */
        private static void createAndShowGUI() {
            //Create and set up the window.
            GUISelecionadorDeRegras frame = new GUISelecionadorDeRegras("Selecionar Regras");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Set up the content pane.
            frame.addComponentsToPane(frame.getContentPane());
            //Display the window.
            frame.pack();
            frame.setResizable(true);
            frame.setVisible(true);

        }

        public static void main(String[] args) {
            /* Use an appropriate Look and Feel */
            try {
                //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            /* Turn off metal's use of bold fonts */
            UIManager.put("swing.boldMetal", Boolean.FALSE);

            //Schedule a job for the event dispatch thread:
            //creating and showing this application's GUI.
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
        }
    }


