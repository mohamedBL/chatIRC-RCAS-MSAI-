package com.cfranc.irc.ui;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.sqlite.JDBC;

public class ConnectDB extends JFrame{
	public static Connection connection = null;
	public static void connectAndClose(String filePath) {
		
		try{
			// create a database connection
			String url = "jdbc:sqlite:" + filePath;
			if (JDBC.isValidURL(url)) {
				connection = DriverManager.getConnection(url);
				ajoutUser(connection);
			}
		}
		
		catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}
	public static void ajoutUser(Connection connection) throws SQLException {
		
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		
	// on recupere la liste des pseudo
		System.out.println("select Pseudo from Utilisateurs where Pseudo =" +"'"+ TablePane.getPseudo().getText()+"'");
		ResultSet  result =  statement.executeQuery("select Pseudo from Utilisateurs where Pseudo ='" + TablePane.getPseudo().getText()+"'");
		boolean hasSamePseudo=result.next();
		System.out.println("The result set have at least one element : "+hasSamePseudo);
		if (hasSamePseudo){
			JOptionPane.showMessageDialog(null,"Ce Pseudo existe deja !","toto",JOptionPane.WARNING_MESSAGE);
		    System.out.println(result);
		}
		else{
			// insere un user dans la table Utilisateur
			statement.executeUpdate(("insert into Utilisateurs (Nom,Prenom,Pseudo,Password,Avatar) values ('" + TablePane.getNom().getText()+"','"+  TablePane.getPrenom().getText()+"','"+ TablePane.getPseudo().getText()+"','"+ TablePane.getPwd().getText()+"','"+ null+"'"+")"));
		}

		
		}
public static void modifierUser(Connection connection) throws SQLException {
		
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		// modifier un user dans la table Utilisateur
		
	
		statement.executeUpdate(("update  Utilisateurs set ('" + "Nom ="+ TablePane.getNom().getText()+"','"+  TablePane.getPrenom().getText()+"','"+ TablePane.getPseudo().getText()+"','"+ TablePane.getPwd().getText()+"','"+ null+"'"+")"));

		
		}
		
		
	
	private void printGetTable(Connection connection) throws SQLException {
		DatabaseMetaData dmd = connection.getMetaData();
		ResultSet tables = dmd.getTables(connection.getCatalog(),null,"&",null);
		while(tables.next()){
			System.out.println("#####################################");
			for (int i = 0; i < tables.getMetaData().getColumnCount(); i++) {
				String nomcolonne = tables.getMetaData().getColumnName(i+1);
				Object valeurColonne = tables.getObject(i+1);
				System.out.println(nomcolonne + "= "+ valeurColonne);
				
			}
		}
	}
			
			public static void printGetColumn(Connection connection) throws SQLException {
				DatabaseMetaData dmd = connection.getMetaData();
				ResultSet tablesColumns = dmd.getColumns(connection.getCatalog(),null,"UTILISATEURS","&");
				ResultSetMetaData rsmd = tablesColumns.getMetaData();
				while(tablesColumns.next()){
					System.out.println("#####################################");
					for (int i = 0; i < rsmd.getColumnCount(); i++) {
						String col = rsmd.getColumnName(i+1);
						Object val = tablesColumns.getObject(i+1);
						System.out.println(col + "= "+ val);
						
					}
		}
	}
}
