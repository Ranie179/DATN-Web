package com.datn.web.bean;

public class Graduate {
	private int idGraduate;
	protected String graduate;
	public int getIdGraduate() {
		return idGraduate;
	}
	public void setIdGraduate(int idGraduate) {
		this.idGraduate = idGraduate;
	}
	public String getGraduate() {
		return graduate;
	}
	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}
	public Graduate(String graduate) {
		super();
		this.graduate = graduate;
	}
	public Graduate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
