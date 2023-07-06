package com.datn.web.bean;

public class Positions {
	private int idPosition;
	protected String positionName;
	public int getIdPosition() {
		return idPosition;
	}
	public void setIdPosition(int idPosition) {
		this.idPosition = idPosition;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public Positions(String positionName) {
		super();
		this.positionName = positionName;
	}
	public Positions() {
		super();
		// TODO Auto-generated constructor stub
	}

}
