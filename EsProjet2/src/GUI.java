import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;

public class GUI {

	private JFrame frmCodequalityassesso;
	private JTextField txtChooseAFile;
	private JTextField txtLimite;
	private JTextField textField;
	private JTextField txtLimite_1;
	private JTextField txtLimite_2;
	private JTextField txtLimite_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmCodequalityassesso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}
	
	/**
	 * Abre nova Janela
	 */
/*	public void abreFrame() {
		frmCodequalityassesso = new JFrame();
		frmCodequalityassesso.getContentPane().setBackground(Color.GRAY);
		frmCodequalityassesso.setTitle("CodeQualityAssessor");
		frmCodequalityassesso.setBounds(100, 100, 616, 494);
		frmCodequalityassesso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCodequalityassesso.getContentPane().setLayout(null);
	}*/
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCodequalityassesso = new JFrame();
		frmCodequalityassesso.getContentPane().setBackground(Color.GRAY);
		frmCodequalityassesso.setTitle("CodeQualityAssessor");
		frmCodequalityassesso.setBounds(100, 100, 616, 494);
		frmCodequalityassesso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCodequalityassesso.getContentPane().setLayout(null);
		
		txtChooseAFile = new JTextField();
		txtChooseAFile.setBackground(Color.WHITE);
		txtChooseAFile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtChooseAFile.setText("Escolha um ficheiro");
		txtChooseAFile.setBounds(52, 37, 343, 28);
		frmCodequalityassesso.getContentPane().add(txtChooseAFile);
		txtChooseAFile.setColumns(10);
		
		JButton btnNewButton = new JButton("search");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Selecionar um ficheiro e filtrar ficheiros java
				JFileChooser fc= new JFileChooser();
			
				FileFilter filter=new FileNameExtensionFilter("*Java Files","JAVA", "Ficheiro JAVA");
				//Verificar o File filter
				int returnVal= fc.showOpenDialog(fc);
				File selectedFile= fc.getSelectedFile();
				txtChooseAFile.setText(selectedFile.getPath());
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(434, 38, 116, 28);
		frmCodequalityassesso.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Visualizar extra\u00E7\u00E3o das m\u00E9tricas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mostar o ficheiro excel gerado numa nova janela
				showFilexlsx excel= new showFilexlsx();
				excel.setVisible(true);  //preciso fazer com que volte a Janela inicial
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(52, 99, 498, 39);
		frmCodequalityassesso.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Calcular resumo das caracteristicas do projeto");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(52, 163, 498, 39);
		frmCodequalityassesso.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Regras");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(52, 239, 105, 28);
		frmCodequalityassesso.getContentPane().add(lblNewLabel);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"NOM_class", "LOC_class", "WMC_class", "LOC_method", "CYCLO_method"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(52, 300, 174, 118);
		frmCodequalityassesso.getContentPane().add(list);
		
		JLabel lblNewLabel_1 = new JLabel("Limites");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(263, 275, 86, 19);
		frmCodequalityassesso.getContentPane().add(lblNewLabel_1);
		
		txtLimite = new JTextField();
		txtLimite.setText("limite 5");
		txtLimite.setBounds(263, 399, 67, 19);
		frmCodequalityassesso.getContentPane().add(txtLimite);
		txtLimite.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Selecione o operador l\u00F3gico");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(359, 265, 183, 39);
		frmCodequalityassesso.getContentPane().add(lblNewLabel_2);
		
		JList list_1 = new JList();
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"AND", "OR"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list_1.setBounds(369, 301, 67, 50);
		frmCodequalityassesso.getContentPane().add(list_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Selecione as m\u00E9tricas");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(52, 265, 134, 39);
		frmCodequalityassesso.getContentPane().add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setText("limite 1");
		textField.setColumns(10);
		textField.setBounds(263, 303, 67, 19);
		frmCodequalityassesso.getContentPane().add(textField);
		
		txtLimite_1 = new JTextField();
		txtLimite_1.setText("limite 2");
		txtLimite_1.setColumns(10);
		txtLimite_1.setBounds(263, 326, 67, 19);
		frmCodequalityassesso.getContentPane().add(txtLimite_1);
		
		txtLimite_2 = new JTextField();
		txtLimite_2.setText("limite 3");
		txtLimite_2.setColumns(10);
		txtLimite_2.setBounds(263, 353, 67, 19);
		frmCodequalityassesso.getContentPane().add(txtLimite_2);
		
		txtLimite_3 = new JTextField();
		txtLimite_3.setText("limite 4");
		txtLimite_3.setColumns(10);
		txtLimite_3.setBounds(263, 376, 67, 19);
		frmCodequalityassesso.getContentPane().add(txtLimite_3);
		
		JButton btnNewButton_3 = new JButton("Modificar Regras");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_3.setBounds(416, 372, 134, 28);
		frmCodequalityassesso.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Ver code-smells");
		btnNewButton_4.setBounds(416, 411, 134, 35);
		frmCodequalityassesso.getContentPane().add(btnNewButton_4);
	}
}
