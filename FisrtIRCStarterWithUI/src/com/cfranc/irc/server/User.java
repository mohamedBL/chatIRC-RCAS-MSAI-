package com.cfranc.irc.server;

public class User {

	private String login;
	private String pwd;
	private String pseudo;
	
	public String getLogin() {
		return login;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public User(String login, String pwd, String pseudo) {
	
		super();
		this.login = login;
		this.pwd = pwd;
		this.pseudo = pseudo;
	}	
	
}
