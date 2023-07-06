package com.datn.web.bean;

public class Payment {
	private int idPayment;
	protected String payment;
	public int getIdPayment() {
		return idPayment;
	}
	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public Payment(String payment) {
		super();
		this.payment = payment;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
