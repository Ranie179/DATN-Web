package com.datn.web.bean;

public class Services {
	private int id;
	protected String name;
	protected String image1;
	protected String image2;
	protected String image3;
	protected String description1;
	protected String description2;
	protected String description3;
	protected String intro;
	protected String advantage;
	protected String endline;
	protected Departments department;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getImage2() {
		return image2;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	public String getImage3() {
		return image3;
	}
	public void setImage3(String image3) {
		this.image3 = image3;
	}
	public String getDescription1() {
		return description1;
	}
	public void setDescription1(String description1) {
		this.description1 = description1;
	}
	public String getDescription2() {
		return description2;
	}
	public void setDescription2(String description2) {
		this.description2 = description2;
	}
	public String getDescription3() {
		return description3;
	}
	public void setDescription3(String description3) {
		this.description3 = description3;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getAdvantage() {
		return advantage;
	}
	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}
	public String getEndline() {
		return endline;
	}
	public void setEndline(String endline) {
		this.endline = endline;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Departments getDepartment() {
		return department;
	}
	public void setDepartment(Departments department) {
		this.department = department;
	}
	public Services(String name, String image1, String image2, String image3,String description1, String description2, 
			String description3, String intro, String advantage,
			String endline, Departments department) {
		super();
		this.name = name;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.description1 = description1;
		this.description2 = description2;
		this.description3 = description3;
		this.intro = intro;
		this.advantage = advantage;
		this.endline = endline;
		this.department = department;
	}
	public Services() {}
	
	
}



