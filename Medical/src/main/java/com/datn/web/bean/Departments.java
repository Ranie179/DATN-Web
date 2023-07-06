package com.datn.web.bean;

public class Departments {
	private int idDepartment;
	protected String departmentName;
	protected int numOfDoctors;
	protected String intro;
	protected String information;
	protected String image;
	protected String isWorking;
	
	public int getNumOfDoctors() {
		return numOfDoctors;
	}
	public void setNumOfDoctors(int numOfDoctors) {
		this.numOfDoctors = numOfDoctors;
	}
	public int getIdDepartment() {
		return idDepartment;
	}
	public void setIdDepartment(int idDepartment) {
		this.idDepartment = idDepartment;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getIsWorking() {
		return isWorking;
	}
	public void setIsWorking(String isWorking) {
		this.isWorking = isWorking;
	}
	public Departments(String departmentName, int numOfDoctors, String intro, String information, String image, String isWorking) {
		super();
		this.departmentName = departmentName;
		this.numOfDoctors = numOfDoctors;
		this.intro = intro;
		this.information = information;
		this.image = image;
		this.isWorking = isWorking;
	}
	public Departments() {
		super();
	};

}
