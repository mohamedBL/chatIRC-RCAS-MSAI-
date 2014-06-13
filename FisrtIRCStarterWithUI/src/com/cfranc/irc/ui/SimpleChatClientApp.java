package com.cfranc.irc.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.sql.ConnectionEventListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import com.cfranc.irc.client.ClientToServerThread;
import com.cfranc.irc.server.BroadcastThread;
import com.cfranc.irc.server.ClientConnectThread;
import com.cfranc.irc.server.User;

public class SimpleChatClientApp {
    //static String[] ConnectOptionNames = { "Connect" };	
	static JButton creer = new JButton("Cr�er Compte");
	static JButton connecter = new JButton(" connecter");
    static JButton[] ConnectOptionNames ={creer,connecter};

    static String   ConnectTitle = "Connection Information";
    Socket socketClientServer;
    int serverPort;
    String serverName;
    String clientName;
    String clientPwd;
    
	private SimpleChatFrameClient frame;
	public StyledDocument documentModel=new DefaultStyledDocument();
	DefaultListModel<String> clientListModel=new DefaultListModel<String>();
	
    public static final String BOLD_ITALIC = "BoldItalic";
    public static final String GRAY_PLAIN = "Gray";
        
	public static DefaultStyledDocument defaultDocumentModel() {
		DefaultStyledDocument res=new DefaultStyledDocument();
	    
	    Style styleDefault = (Style) res.getStyle(StyleContext.DEFAULT_STYLE);
	    
	    res.addStyle(BOLD_ITALIC, styleDefault);
	    Style styleBI = res.getStyle(BOLD_ITALIC);
	    StyleConstants.setBold(styleBI, true);
	    StyleConstants.setItalic(styleBI, true);
	    StyleConstants.setForeground(styleBI, Color.black);	    

	    res.addStyle(GRAY_PLAIN, styleDefault);
        Style styleGP = res.getStyle(GRAY_PLAIN);
        StyleConstants.setBold(styleGP, false);
        StyleConstants.setItalic(styleGP, false);
        StyleConstants.setForeground(styleGP, Color.lightGray);

		return res;
	}

	private static ClientToServerThread clientToServerThread;
			
	public SimpleChatClientApp(){
		
	}
	
	public void displayClient() {
		
		// Init GUI
		this.frame=new SimpleChatFrameClient(clientToServerThread, clientListModel, documentModel);
		this.frame.setTitle(this.frame.getTitle()+" : "+clientName+" connected to "+serverName+":"+serverPort);
		((JFrame)this.frame).setVisible(true);

		
		
			

		this.frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				User user = (User) BroadcastThread.clientTreadsMap.keySet();
				BroadcastThread.removeClient(user);
				quitApp(SimpleChatClientApp.this);
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void hideClient() {
		
		// Init GUI
		((JFrame)this.frame).setVisible(false);
	}
	
    void displayConnectionDialog() {
    	//Custom button text
    	creer.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				  
			
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("toto");
				JFrame frameMsai = new JFrame();
				JPanel panel = new JPanel();
				frameMsai.add(panel);
				JButton monbouton = new JButton();
				panel.add(monbouton);
				frameMsai.setVisible(true);
				
			}
		}) ;

    	ConnectionPanel connectionPanel=new ConnectionPanel();
//    	int result = JOptionPane.showOptionDialog(null, connectionPanel, ConnectTitle,JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, ConnectOptionNames ,null);
//    	System.out.println(result);
		if (JOptionPane.showOptionDialog(null, connectionPanel, ConnectTitle,JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, ConnectOptionNames ,ConnectOptionNames [1]) == 1);// ) 
		//if(result == 1){
			//System.out.println("toto");
		{
		
			serverPort=Integer.parseInt(connectionPanel.getServerPortField().getText());
			serverName=connectionPanel.getServerField().getText();
			clientName=connectionPanel.getUserNameField().getText();
			clientPwd=connectionPanel.getPasswordField().getText();
		}


	}
    
    private void connectClient() {
		System.out.println("Establishing connection. Please wait ...");
		try {
			socketClientServer = new Socket(this.serverName, this.serverPort);
			// Start connection services
			clientToServerThread=new ClientToServerThread(documentModel, clientListModel,socketClientServer,clientName, clientPwd);
			clientToServerThread.start();

			System.out.println("Connected: " + socketClientServer);
			
		
		} catch (UnknownHostException uhe) {
			System.out.println("Host unknown: " + uhe.getMessage());
		} catch (IOException ioe) {
			System.out.println("Unexpected exception: " + ioe.getMessage());
		}
	}
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		final SimpleChatClientApp app = new SimpleChatClientApp();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app.displayConnectionDialog();

					app.connectClient();
					
					app.displayClient();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			
		});
		
		Scanner sc=new Scanner(System.in);
		String line="";
		while(!line.equals(".bye")){
			line=sc.nextLine();			
		}
		
		quitApp(app);
	}

	private static void quitApp(final SimpleChatClientApp app) {
		try {
			app.clientToServerThread.quitServer();
			app.socketClientServer.close();
			app.hideClient();
			System.out.println("SimpleChatClientApp : ferm�e");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
