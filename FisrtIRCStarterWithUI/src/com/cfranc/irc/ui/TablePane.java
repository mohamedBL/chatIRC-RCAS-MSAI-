package com.cfranc.irc.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;

import javax.swing.JTextField;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JTextPane;

import com.sun.java.swing.plaf.windows.resources.windows;

public class TablePane extends JFrame {

	private JFrame frame;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablePane window = new TablePane();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TablePane() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel fond = new JPanel();
		getFrame().getContentPane().add(fond, BorderLayout.CENTER);
		fond.setLayout(new BorderLayout(0, 0));
		
		JPanel grille = new JPanel();
		fond.add(grille, BorderLayout.CENTER);
		GridBagLayout gbl_grille = new GridBagLayout();
		gbl_grille.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_grille.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_grille.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_grille.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		grille.setLayout(gbl_grille);
		
		JPanel Tritre = new JPanel();
		GridBagConstraints gbc_Tritre = new GridBagConstraints();
		gbc_Tritre.insets = new Insets(0, 0, 5, 0);
		gbc_Tritre.fill = GridBagConstraints.BOTH;
		gbc_Tritre.gridx = 3;
		gbc_Tritre.gridy = 0;
		grille.add(Tritre, gbc_Tritre);
		Tritre.setLayout(new BorderLayout(0, 0));
		//insertion de l'image
		Icon image = new ImageIcon(".//resources//images//tchat.jpg");
	
		
		JLabel lblImage = new JLabel("Creation de compte");
		lblImage.setHorizontalAlignment(JLabel.CENTER);
		lblImage.setVerticalAlignment(JLabel.CENTER);
		lblImage.setIcon(image);
		Tritre.add(lblImage, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 3;
		gbc_panel_3.gridy = 1;
		grille.add(panel_3, gbc_panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		panel_3.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 3;
		gbc_panel_4.gridy = 2;
		grille.add(panel_4, gbc_panel_4);
		
		JLabel lblPrenom = new JLabel("Prenom");
		panel_4.add(lblPrenom);
		
		textField_1 = new JTextField();
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 3;
		gbc_panel_5.gridy = 3;
		grille.add(panel_5, gbc_panel_5);
		
		JLabel lblPseudo = new JLabel("Pseudo");
		panel_5.add(lblPseudo);
		
		textField_2 = new JTextField();
		panel_5.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 3;
		gbc_panel_6.gridy = 4;
		grille.add(panel_6, gbc_panel_6);
		
		JLabel lblPassword = new JLabel("Password");
		panel_6.add(lblPassword);
		
		pwd = new JPasswordField();
		pwd.setText("          ");
		panel_6.add(pwd);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 3;
		gbc_panel_2.gridy = 5;
		grille.add(panel_2, gbc_panel_2);
		
		JLabel lblNewLabel = new JLabel("Avatar");
		panel_2.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		panel_2.add(textPane);
		
		JPanel boutons = new JPanel();
		fond.add(boutons, BorderLayout.SOUTH);
		
		JButton btnCrer = new JButton("Cr\u00E9er");
		btnCrer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//connection a la BDD et insertion
				System.out.println("toto");
				if (TablePane.getNom().getText().isEmpty() ||TablePane.getPrenom().getText().isEmpty() || TablePane.getPseudo().getText().isEmpty()|| TablePane.getPwd().getText().isEmpty()){
					System.out.println("toto");
					JOptionPane.showMessageDialog(TablePane.this,"merci de saisir de renseigner tous les champs obligatoire","toto",JOptionPane.WARNING_MESSAGE);
					
				}	
		
			//System.out.println(TablePane.getNom().getText());
			//System.out.println(("insert into Utilisateurs values ('" + TablePane.getNom().getText()+"','"+  TablePane.getPrenom().getText()+"','"+ TablePane.getPseudo().getText()+"','"+ TablePane.getPwd().getText()+"'"+")"));	
		ConnectDB.connectAndClose("D://BDDChatIrc//ChatIrc.sqlite");
		}
		});
		boutons.add(btnCrer);
		
		JButton btnRaz = new JButton("Raz");
		btnRaz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				getNom().setText(null); 
				getPrenom().setText(null);
				getPseudo().setText(null);
				getPwd().setText(null);
			}
		});
		boutons.add(btnRaz);
		
	
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				getFrame().dispose();
			}
		});
		boutons.add(btnQuitter);

	}

	public static JTextField getNom() {
		return textField;
	}
	public static JTextField getPrenom() {
		return textField_1;
	}
	public static JTextField getPseudo() {
		return textField_2;
	}
	public static JPasswordField getPwd() {
		return pwd;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
