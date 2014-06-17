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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TablePane extends JFrame {

	private JFrame frame;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JPasswordField pwd;
	private static JComboBox comboBox;

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
		gbl_grille.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_grille.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		grille.setLayout(gbl_grille);
		//insertion de l'image
		Icon image = new ImageIcon(".//resources//images//tchat.jpg");
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 3;
		gbc_panel_3.gridy = 1;
		grille.add(panel_3, gbc_panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Nom        ");
		panel_3.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_4.gridx = 3;
		gbc_panel_4.gridy = 2;
		grille.add(panel_4, gbc_panel_4);
		
		JLabel lblPrenom = new JLabel("  Prenom    ");
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
		
		JLabel lblPseudo = new JLabel("  Pseudo     ");
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
		pwd.setText("               ");
		panel_6.add(pwd);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 3;
		gbc_panel_2.gridy = 5;
		grille.add(panel_2, gbc_panel_2);
		
		JLabel lblNewLabel = new JLabel("Avatar   ");
		panel_2.add(lblNewLabel);
		
		// creation  recuperation des avatars
		final Icon icon1= new ImageIcon(".//resources//images//icon1.jpg");
		final Icon icon2= new ImageIcon(".//resources//images//icon2.jpg");
		final Icon icon3= new ImageIcon(".//resources//images//icon3.jpg");
		final Icon icon4= new ImageIcon(".//resources//images//icon4.jpg");
		final String tab[] = {"avatar1","avatar2","avatar3","avatar4"};
		
		comboBox = new JComboBox();
		final JLabel lblavatar = new JLabel("New label");
		JPanel emplacementavatar = new JPanel();
		fond.add(emplacementavatar, BorderLayout.WEST);
		emplacementavatar.setLayout(new BorderLayout(0, 0));
		emplacementavatar.add(lblavatar);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem() == "avatar1")
					{
					lblavatar.setIcon(icon1);
					}
					else if (comboBox.getSelectedItem() == "avatar2")
					{
						lblavatar.setIcon(icon2);
					}
					else if (comboBox.getSelectedItem() == "avatar3")
					{
						lblavatar.setIcon(icon3);
					}
					else if (comboBox.getSelectedItem() == "avatar4")
					{
						lblavatar.setIcon(icon4);
					}
					System.out.println(comboBox.getSelectedItem());
					
				
			}
		});

		
		for (int i = 0; i < tab.length; i++) {
			
		comboBox.addItem(tab[i]);
		}
		//comboBox.addItem("avatar2");
		panel_2.add(comboBox);
		
		//Object choix = comboBox.getSelectedItem();
	
		

		
		
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
					JOptionPane.showMessageDialog(TablePane.this,"merci de renseigner tous les champs obligatoire","toto",JOptionPane.WARNING_MESSAGE);
					
				}	
		
			//System.out.println(TablePane.getNom().getText());
			//System.out.println(("insert into Utilisateurs values ('" + TablePane.getNom().getText()+"','"+  TablePane.getPrenom().getText()+"','"+ TablePane.getPseudo().getText()+"','"+ TablePane.getPwd().getText()+"'"+")"));	
				try {
					ConnectDB.ajoutUser();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		
		JPanel Tritre = new JPanel();
		fond.add(Tritre, BorderLayout.NORTH);
		Tritre.setLayout(new BorderLayout(0, 0));
		
			
			JLabel lblImage = new JLabel("Creation de compte");
			lblImage.setHorizontalAlignment(JLabel.CENTER);
			lblImage.setVerticalAlignment(JLabel.CENTER);
			lblImage.setIcon(image);
			Tritre.add(lblImage, BorderLayout.CENTER);
		
		
		

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
	public static JComboBox getComboBox() {
		return comboBox;
	}
}
