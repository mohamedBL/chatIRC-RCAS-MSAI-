package com.cfranc.irc.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.GridLayout;

import javax.swing.JSplitPane;

import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;

public class FenetreConnection extends JFrame {

	private JPanel contentPane;
	private static JTextField textFirldport;
	private static JTextField textFieldserveur;
	private static JTextField textFieldpwd1;
	private static JTextField textFieldpseudo;
	private static JTextField textFieldnom1;
	private JButton btnSeConnecter;
	private JButton btnNewButton;
	private JButton btnCrerCompte;
	private JPasswordField textFieldpwd1_1;


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
		setForeground(Color.GRAY);
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
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
		
		JPanel Titre = new JPanel();
		contentPane.add(Titre, BorderLayout.NORTH);
		
		JLabel lblBienvenuSurLe = new JLabel("TCHAT IRC RCAS-MSAI");
		lblBienvenuSurLe.setBackground(Color.BLACK);
		lblBienvenuSurLe.setForeground(Color.ORANGE);
		Titre.add(lblBienvenuSurLe);
		
		JPanel panneaumasque = new JPanel();
		contentPane.add(panneaumasque, BorderLayout.WEST);
		panneaumasque.setLayout(new BorderLayout(0, 0));
		
		JPanel formulaire = new JPanel();
		contentPane.add(formulaire, BorderLayout.CENTER);
		formulaire.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		formulaire.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel nom_1 = new JPanel();
		nom_1.setVisible(false);
		panel_1.add(nom_1);
		
		JLabel lblNom1 = new JLabel("Nom     ");
		nom_1.add(lblNom1);
		
		textFieldnom1 = new JTextField();
		nom_1.add(textFieldnom1);
		textFieldnom1.setColumns(10);
		
		final JLabel lblNewLabel = new JLabel("");
		nom_1.add(lblNewLabel);
		
		// ajout MSAI
		btnSeConnecter = new JButton("Se connecter");
		boutonbas.add(btnSeConnecter);
		btnSeConnecter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
			
					ResultSet toto =ConnectDB.selectionnerUser();
					if (toto == null){
						System.out.println("On fait rien on laisse la fenetre ouverte");
					}
					
					else {
						//System.out.println(toto.getString(0));
					
					String pseudo=toto.getString(4);
					String pwd = toto.getString(5);
				//	System.out.println(tata);
					//System.out.println(textFieldnom1.getText());
					if (!textFieldpwd1.getText().equals(pwd)){
						JOptionPane.showMessageDialog(FenetreConnection.this,"mot de passe incorrect","Erreur",JOptionPane.WARNING_MESSAGE);
						//System.out.println(" vous n'avez pas de compte !");
					}
					else{
				
					SimpleChatClientApp.connectClient();
					String textFieldnom1 = toto.getString(2);
					 SimpleChatClientApp.displayClient();
					 FenetreConnection.this.dispose();
				}
					}
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		
		
		btnNewButton = new JButton("Quitter");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				FenetreConnection.this.dispose();
			}
		});
		boutonbas.add(btnNewButton);
		
		
		JPanel pseudo = new JPanel();
		panel_1.add(pseudo);
		
		JLabel lblPseudo = new JLabel("Pseudo  ");
		pseudo.add(lblPseudo);
		
		textFieldpseudo = new JTextField();
		pseudo.add(textFieldpseudo);
		textFieldpseudo.setColumns(10);
		
		JPanel password = new JPanel();
		panel_1.add(password);
		
		JLabel lblPassword = new JLabel("Password");
		password.add(lblPassword);
		
		textFieldpwd1 = new JPasswordField();
		password.add(textFieldpwd1);
		
//		textFieldpwd1 = new JTextField();
//		password.add(textFieldpwd1);
		textFieldpwd1.setColumns(10);
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		
		final JRadioButton rdbtnAvanc = new JRadioButton("avanc\u00E9");
		panel.add(rdbtnAvanc);
		
		final JPanel formulairemasque = new JPanel();
		panel.add(formulairemasque);
		formulairemasque.setVisible(false);
		
		JPanel port = new JPanel();
		formulairemasque.add(port);
		
		JLabel lblPort = new JLabel("Port");
		port.add(lblPort);
		
		textFirldport = new JTextField();
		textFirldport.setText("4567");
		port.add(textFirldport);
		textFirldport.setColumns(10);
		
		JPanel serveur = new JPanel();
		formulairemasque.add(serveur);
		
		JLabel lblServeur = new JLabel("Serveur");
		serveur.add(lblServeur);
		
		textFieldserveur = new JTextField();
		textFieldserveur.setText("localhost");
		serveur.add(textFieldserveur);
		textFieldserveur.setColumns(10);
		rdbtnAvanc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnAvanc.isSelected()== true)
				{
			
					formulairemasque.setVisible(true);
				
				
				
				}
				else {
						formulairemasque.setVisible(false);
					
					} 
				}
				
				
					
			
				
			}
		);
		
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
		return textFieldserveur;
	}
	public static JTextField getNom() {
		return textFieldnom1;
	}
	public static JTextField getPseudo() {
		return textFieldpseudo;
	}
	public static JTextField getPassword() {
		return textFieldpwd1;
	}
}
