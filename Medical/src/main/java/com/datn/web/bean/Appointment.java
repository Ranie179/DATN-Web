package com.datn.web.bean;

import java.sql.Timestamp;

public class Appointment {
	private int id;
	protected String name;
	protected String phone;
	protected Timestamp appointmentDate;
	protected String email;
	protected String gender;
	protected Departments department;
	protected String note;
	protected String token;
	protected String information;
	protected String appointmentStatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Timestamp getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Timestamp appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Departments getDepartment() {
		return department;
	}
	public void setDepartment(Departments department) {
		this.department = department;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getAppointmentStatus() {
		return appointmentStatus;
	}
	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	public Appointment(String name, String phone, Timestamp appointmentDate, String email, String gender,
			Departments department, String note, String token, String information, String appointmentStatus) {
		super();
		this.name = name;
		this.phone = phone;
		this.appointmentDate = appointmentDate;
		this.email = email;
		this.gender = gender;
		this.department = department;
		this.note = note;
		this.token = token;
		this.information = information;
		this.appointmentStatus = appointmentStatus;
	}
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
