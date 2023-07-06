package com.datn.web.bean;

public class Degrees {
	private int idDegree;
	protected Doctors doctor;
	protected String degreeName;
	protected String college;
	protected String year;
	public int getIdDegree() {
		return idDegree;
	}
	public void setIdDegree(int idDegree) {
		this.idDegree = idDegree;
	}
	public Doctors getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctors doctor) {
		this.doctor = doctor;
	}
	public String getDegreeName() {
		return degreeName;
	}
	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Degrees(Doctors doctor, String degreeName, String college, String year) {
		super();
		this.doctor = doctor;
		this.degreeName = degreeName;
		this.college = college;
		this.year = year;
	}
	
	public Degrees() {};
}
