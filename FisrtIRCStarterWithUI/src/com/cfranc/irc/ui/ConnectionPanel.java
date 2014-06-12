package com.cfranc.irc.ui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.activation.MailcapCommandMap;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import net.miginfocom.swing.MigLayout;

public class ConnectionPanel extends JPanel {

    private JTextField serverPortField;
    private JTextField serverField;
    private JTextField pseudoField;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JTextField txtPseudofield;
    
    

	public JTextField getServerPortField() {
		return serverPortField;
	}



	public JTextField getServerField() {
		return serverField;
	}



	/**
	 * Create the panel.
	 */
	public ConnectionPanel() {
	
	
	    JPanel connectionPanel = new JPanel(false);
		connectionPanel.setLayout(new BoxLayout(connectionPanel,
							BoxLayout.X_AXIS));
	
		JPanel namePanel = new JPanel(false);
		namePanel.setLayout(new GridLayout(0, 1));
	
		JPanel fieldPanel = new JPanel(false);
		fieldPanel.setLayout(new GridLayout(0, 1));
	    JLabel userNameLabel = new JLabel("User name: ", JLabel.RIGHT);
	    userNameField = new JTextField("guest");
	    
	    JLabel lblPseudo = new JLabel("Pseudo");
	    setPreferredSize(new Dimension(300,200));
	    setLayout(new MigLayout("", "[69px][72px,grow][86px][1px]", "[20px][1px][5px][][8px][][3px][20px][20px][20px]"));
	    
	    txtPseudofield = new JTextField();
	    txtPseudofield.setText("pseudoField");
	    add(txtPseudofield, "cell 1 3,growx");
	    txtPseudofield.setColumns(10);
	    //	    JLabel pseudoLabel = new JLabel("Pseudo: ", JLabel.RIGHT);
	    //	    pseudoField = new JTextField("");
	    	        JLabel passwordLabel = new JLabel("Password: ", JLabel.RIGHT);
	    	        add(passwordLabel, "cell 0 5,alignx right,aligny center");
	    passwordField = new JPasswordField("trustworthy");
	    add(passwordField, "cell 1 5,alignx left,aligny center");
	    
	    JLabel serverLabel = new JLabel("Server name:", JLabel.RIGHT);
	    add(serverLabel, "cell 0 7,alignx left,aligny center");
	    serverField = new JTextField("localhost");
	    add(serverField, "cell 1 7,alignx left,aligny top");
	    
	        JLabel serverPortLabel = new JLabel("Port: ", JLabel.RIGHT);
	        add(serverPortLabel, "cell 0 8,alignx right,aligny center");
	    serverPortField = new JTextField("4567");
	    add(serverPortField, "cell 1 8,alignx left,aligny top");
	    add(lblPseudo, "cell 0 1 1 4,alignx center,aligny center");
	    add(userNameLabel, "cell 0 0,alignx right,aligny center");
	    add(namePanel, "cell 1 1,alignx left,aligny top");
	    add(userNameField, "cell 1 0,growx,aligny top");
	    add(fieldPanel, "cell 3 0,alignx left,aligny top");
	}

	public JTextField getUserNameField() {
		return userNameField;
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}
}
