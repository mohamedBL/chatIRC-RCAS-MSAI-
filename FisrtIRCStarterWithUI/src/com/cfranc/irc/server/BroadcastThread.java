package com.cfranc.irc.server;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import com.cfranc.irc.IfClientServerProtocol;
import com.cfranc.irc.client.ClientToServerThread;


public class BroadcastThread extends Thread {
	
	public static HashMap<User, ServerToClientThread> clientTreadsMap=new HashMap<User, ServerToClientThread>();
	static{
		Collections.synchronizedMap(clientTreadsMap);
	}
	
	public static boolean addClient(User user, ServerToClientThread serverToClientThread){
		boolean res=true;
		if(clientTreadsMap.containsKey(user)){
			res=false;
		}
		else{
			clientTreadsMap.put(user, serverToClientThread);
			sendUser(user);
			listeUserConnect(serverToClientThread);
			
		}
		return res;
	}

	public static void sendMessage(User sender, String msg){
		Collection<ServerToClientThread> clientTreads=clientTreadsMap.values();
		Iterator<ServerToClientThread> receiverClientThreadIterator=clientTreads.iterator();
		while (receiverClientThreadIterator.hasNext()) {
			ServerToClientThread clientThread = (ServerToClientThread) receiverClientThreadIterator.next();
//			clientThread.post("#"+sender.getPseudo()+"#"+msg);		
			clientThread.post(IfClientServerProtocol.SEPARATOR+sender.getPseudo()+IfClientServerProtocol.SEPARATOR+msg);	
			System.out.println("sendMessage : "+IfClientServerProtocol.SEPARATOR+sender.getPseudo()+IfClientServerProtocol.SEPARATOR+msg);
			
		}
	}
	
	public static void sendUser(User sender){
		Collection<ServerToClientThread> clientTreads=clientTreadsMap.values();
		Iterator<ServerToClientThread> receiverClientThreadIterator=clientTreads.iterator();
		while (receiverClientThreadIterator.hasNext()) {
			ServerToClientThread clientThread = (ServerToClientThread) receiverClientThreadIterator.next();
	//		clientThread.post("#+#"+sender.getPseudo());		
			clientThread.post(IfClientServerProtocol.ADD+sender.getPseudo());
			//listeUserConnect();
			System.out.println("Nouvel utilisateur"+IfClientServerProtocol.ADD+sender.getPseudo());
		}
	}
	
	public static void listeUserConnect(ServerToClientThread serverToClientThread){
		
		Collection<User> userTreads=clientTreadsMap.keySet();
		Iterator<User> userThreadIterator=userTreads.iterator();
		
		//ServerToClientThread userTreads = (ServerToClientThread) userThreadIterator.next();
	
		while (userThreadIterator.hasNext()) {
			// on recupere la valeur courante de l'iterateur
		
			User currentUser= userThreadIterator.next();
			// on envoi la valeur 
			serverToClientThread.post(IfClientServerProtocol.ADD+currentUser.getPseudo());
	}
	}
	
	
	public static void removeClient(User user){
		clientTreadsMap.remove(user);
		
		Collection<ServerToClientThread> clientTreads=clientTreadsMap.values();
		Iterator<ServerToClientThread> receiverClientThreadIterator=clientTreads.iterator();
		while (receiverClientThreadIterator.hasNext()) {
			ServerToClientThread clientThread = (ServerToClientThread) receiverClientThreadIterator.next();
			clientThread.post(IfClientServerProtocol.DEL+user.getPseudo());		
		//	clientThread.post(IfClientServerProtocol.BYE+user.getPseudo());	
	
		}
		}
	
	
	public static boolean accept(User user){
		boolean res=true;
		if(clientTreadsMap.containsKey(user)){
			res= false;
		}
		return res;
	}
}
