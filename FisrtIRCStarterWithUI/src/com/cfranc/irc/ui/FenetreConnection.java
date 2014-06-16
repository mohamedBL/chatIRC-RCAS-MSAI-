package com.cfranc.irc.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FenetreConnection extends JFrame {

	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private JButton btnSeConnecter;
	private JButton btnNewButton;
	private JButton btnCrerCompte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreConnection frame = new FenetreConnection();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreConnection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel boutonbas = new JPanel();
		contentPane.add(boutonbas, BorderLayout.SOUTH);
		
		btnCrerCompte = new JButton("Cr\u00E9er compte");
		btnCrerCompte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("on ouvre la fenetre de creation de compte");
				TablePane window = new TablePane();
				window.getFrame().setVisible(true);
					
			}
		});
		boutonbas.add(btnCrerCompte);
		
		btnSeConnecter = new JButton("Se connecter");
		btnSeConnecter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			
				SimpleChatClientApp.connectClient();
			 SimpleChatClientApp.displayClient();
			 FenetreConnection.this.dispose();
			}
		});
		boutonbas.add(btnSeConnecter);
		
		btnNewButton = new JButton("Quitter");
		boutonbas.add(btnNewButton);
		
		JPanel formulaire = new JPanel();
		contentPane.add(formulaire, BorderLayout.CENTER);
		GridBagLayout gbl_Formulaire = new GridBagLayout();
		gbl_Formulaire.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_Formulaire.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Formulaire.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_Formulaire.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		formulaire.setLayout(gbl_Formulaire);
		
		JPanel nom = new JPanel();
		GridBagConstraints gbc_nom = new GridBagConstraints();
		gbc_nom.insets = new Insets(0, 0, 5, 0);
		gbc_nom.fill = GridBagConstraints.BOTH;
		gbc_nom.gridx = 4;
		gbc_nom.gridy = 2;
		formulaire.add(nom, gbc_nom);
		
		JLabel lblNom = new JLabel("Nom");
		nom.add(lblNom);
		
		textField_4 = new JTextField();
		nom.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel pseudo = new JPanel();
		GridBagConstraints gbc_pseudo = new GridBagConstraints();
		gbc_pseudo.insets = new Insets(0, 0, 5, 0);
		gbc_pseudo.fill = GridBagConstraints.BOTH;
		gbc_pseudo.gridx = 4;
		gbc_pseudo.gridy = 3;
		formulaire.add(pseudo, gbc_pseudo);
		
		JLabel lblPseudo = new JLabel("Pseudo");
		pseudo.add(lblPseudo);
		
		textField_3 = new JTextField();
		pseudo.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel password = new JPanel();
		GridBagConstraints gbc_password = new GridBagConstraints();
		gbc_password.insets = new Insets(0, 0, 5, 0);
		gbc_password.fill = GridBagConstraints.BOTH;
		gbc_password.gridx = 4;
		gbc_password.gridy = 4;
		formulaire.add(password, gbc_password);
		
		JLabel lblPassword = new JLabel("Password");
		password.add(lblPassword);
		
		textField_2 = new JTextField();
		password.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel serveur = new JPanel();
		GridBagConstraints gbc_serveur = new GridBagConstraints();
		gbc_serveur.insets = new Insets(0, 0, 5, 0);
		gbc_serveur.fill = GridBagConstraints.BOTH;
		gbc_serveur.gridx = 4;
		gbc_serveur.gridy = 5;
		formulaire.add(serveur, gbc_serveur);
		
		JLabel lblServeur = new JLabel("Serveur");
		serveur.add(lblServeur);
		
		textField_1 = new JTextField();
		serveur.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel port = new JPanel();
		GridBagConstraints gbc_port = new GridBagConstraints();
		gbc_port.fill = GridBagConstraints.BOTH;
		gbc_port.gridx = 4;
		gbc_port.gridy = 6;
		formulaire.add(port, gbc_port);
		
		JLabel lblPort = new JLabel("Port");
		port.add(lblPort);
		
		textField = new JTextField();
		port.add(textField);
		textField.setColumns(10);
		
		JPanel Titre = new JPanel();
		contentPane.add(Titre, BorderLayout.NORTH);
		
		JLabel lblBienvenuSurLe = new JLabel("bienvenu sur le tchat");
		Titre.add(lblBienvenuSurLe);
	}

	public JButton getBtnSeConnecter() {
		return btnSeConnecter;
	}
	public JButton getBtnNewButton() {
		return btnNewButton;
	}
	public JButton getBtnCrerCompte() {
		return btnCrerCompte;
	}
	public static int getPort() {
		return 4567;
	}
	public static JTextField getServeur() {
		return textField_1;
	}
	public static JTextField getNom() {
		return textField_4;
	}
	public static JTextField getPseudo() {
		return textField_3;
	}
	public static JTextField getPassword() {
		return textField_2;
	}
}
