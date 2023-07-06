package com.datn.web.bean;

import java.util.Date;

public class Profile {
	private int idProfile;
	protected String name;
	protected String email;
	protected String phone;
	protected Date birthDay;
	protected String blood;
	protected String gender;
	protected String commune;
	protected String district;
	protected String province;
	public int getIdProfile() {
		return idProfile;
	}
	public void setIdProfile(int idProfile) {
		this.idProfile = idProfile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCommune() {
		return commune;
	}
	public void setCommune(String commune) {
		this.commune = commune;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Profile(String name, String email, String phone, Date birthDay, String blood, String gender, String commune,
			String district, String province) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.birthDay = birthDay;
		this.blood = blood;
		this.gender = gender;
		this.commune = commune;
		this.district = district;
		this.province = province;
	}
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
