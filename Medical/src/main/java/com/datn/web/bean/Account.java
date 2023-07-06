package com.datn.web.bean;

public class Account {
	private int idAccount;
	private String email;
	private String pass;
	protected String role;
	
	public int getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Account(String email, String pass, String role) {
		super();
		this.email = email;
		this.pass = pass;
		this.role = role;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
