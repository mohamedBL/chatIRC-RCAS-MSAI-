package com.cfranc.irc.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.cfranc.irc.IfClientServerProtocol;

public class ClientConnectThread extends Thread implements IfClientServerProtocol {
	StyledDocument model=null;
	DefaultListModel<String> clientListModel;
	DefaultTreeModel clientTreeModel;
	
	private boolean canStop=false;
	private ServerSocket server = null;
	
	private void printMsg(String msg){
		try {
			if(model!=null){
				model.insertString(model.getLength(), msg+"\n", null);
			}
			System.out.println(msg);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ClientConnectThread(int port, StyledDocument model, DefaultTreeModel clientTreeModel) {
		try {
			this.model=model;
			this.clientTreeModel=clientTreeModel;
			printMsg("Binding to port " + port + ", please wait  ...");
			server = new ServerSocket(port);
			printMsg("Server started: " + server);
		} 
		catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
	
	@Override
	public void run() {
		while(!canStop){
			printMsg("Waiting for a client ...");
			Socket socket;
			try {
				socket = server.accept();
				printMsg("Client accepted: " + socket);
				
				// Accept new client or close the socket
				acceptClient(socket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void acceptClient(Socket socket) throws IOException, InterruptedException {
		// Read user login and pwd
		DataInputStream dis=new DataInputStream(socket.getInputStream());
		DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(LOGIN__PWD_PSEUDO);
		while(dis.available()<=0){
			Thread.sleep(100);
		}
		String reponse=dis.readUTF();//lit qqc
		String[] userPwd=reponse.split(SEPARATOR);
		System.out.println(userPwd[0]+userPwd[1] + userPwd[2]);
		String login=userPwd[1];
		String pwd=userPwd[2];
		String pseudo = userPwd[3];
		User newUser=new User(login, pwd,pseudo);
		
		boolean isUserOK=authentication(newUser);
		if(isUserOK){
			
			ServerToClientThread client=new ServerToClientThread(newUser, socket);
			dos.writeUTF(OK);

			// Add user
			if(BroadcastThread.addClient(newUser, client)){
				client.start();		
				
				//MSAI on ajoute le nom du user dans la liste  de gauche cot� ihm serveur
				
				((DefaultMutableTreeNode)clientTreeModel.getRoot()).add(new DefaultMutableTreeNode(newUser.getPseudo()));
				((DefaultTreeModel)clientTreeModel).reload();
				dos.writeUTF(ADD+login);
			}
		}
		else{
			System.out.println("socket.close()");
			dos.writeUTF(KO);
			dos.close();
			socket.close();
		}
	}
	
	private boolean authentication(User newUser){
		return BroadcastThread.accept(newUser);
	}

	
	public void open() throws IOException {
	}
	
	public void close() throws IOException {
		System.err.println("server:close()");
		if (server != null)
			server.close();
	}
}
