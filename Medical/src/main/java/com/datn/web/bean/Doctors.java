package com.datn.web.bean;

import java.util.Date;

public class Doctors {
	private int idDoctor;
	protected String doctorName;
	protected Contracts contract;
	protected String imageUrl;
	protected String gender;
	protected Date birthDay;
	protected Positions position;
	protected Departments department;
	protected String information;
	protected Graduate graduate;
	protected int expYear;
	protected int salary;
	protected String phone;
	protected String isWorking;
	
	public int getIdDoctor() {
		return idDoctor;
	}
	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public Contracts getContract() {
		return contract;
	}
	public void setContract(Contracts contract) {
		this.contract = contract;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public Positions getPosition() {
		return position;
	}
	public void setPosition(Positions position) {
		this.position = position;
	}
	public Departments getDepartment() {
		return department;
	}
	public void setDepartment(Departments department) {
		this.department = department;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public Graduate getGraduate() {
		return graduate;
	}
	public void setGraduate(Graduate graduate) {
		this.graduate = graduate;
	}
	public int getExpYear() {
		return expYear;
	}
	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getIsWorking() {
		return isWorking;
	}
	public void setIsWorking(String isWorking) {
		this.isWorking = isWorking;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Doctors(String doctorName, Contracts contract, String imageUrl, String gender, Date birthDay, Positions position,
			Departments department, String information, Graduate graduate, int expYear, int salary, String isWorking, String phone) {
		super();
		this.doctorName = doctorName;
		this.contract = contract;
		this.imageUrl = imageUrl;
		this.gender = gender;
		this.birthDay = birthDay;
		this.position = position;
		this.department = department;
		this.information = information;
		this.graduate = graduate;
		this.expYear = expYear;
		this.salary = salary;
		this.isWorking = isWorking;
		this.phone = phone;
	}
	public Doctors() {};
}
