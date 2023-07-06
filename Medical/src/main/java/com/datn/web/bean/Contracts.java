package com.datn.web.bean;

import java.util.Date;

public class Contracts {
	private int idContract;
	protected String name;
	protected Departments department;
	protected Positions position;
	protected Date birthDay;
	protected String identityNumber;
	protected String gender;
	protected Graduate graduate;
	protected String nationality;
	protected String identityPlace;
	protected Date identityDay;
	protected String address1;
	protected String address2;
	protected String phone;
	protected String bankNumber;
	protected String bank;
	protected int workTime;
	protected int restTime;
	protected int leaveTime;
	protected int salary;
	protected Payment payment;
	protected int cDay;
	protected int cMonth;
	protected int cYear;
	protected int eDay;
	protected int eMonth;
	protected int eYear;
	public int getIdContract() {
		return idContract;
	}
	public void setIdContract(int idContract) {
		this.idContract = idContract;
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
	public Positions getPosition() {
		return position;
	}
	public void setPosition(Positions position) {
		this.position = position;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Graduate getGraduate() {
		return graduate;
	}
	public void setGraduate(Graduate graduate) {
		this.graduate = graduate;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getIdentityPlace() {
		return identityPlace;
	}
	public void setIdentityPlace(String identityPlace) {
		this.identityPlace = identityPlace;
	}
	public Date getIdentityDay() {
		return identityDay;
	}
	public void setIdentityDay(Date identityDay) {
		this.identityDay = identityDay;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBankNumber() {
		return bankNumber;
	}
	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public int getWorkTime() {
		return workTime;
	}
	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}
	public int getRestTime() {
		return restTime;
	}
	public void setRestTime(int restTime) {
		this.restTime = restTime;
	}
	public int getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(int leaveTime) {
		this.leaveTime = leaveTime;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public int getcDay() {
		return cDay;
	}
	public void setcDay(int cDay) {
		this.cDay = cDay;
	}
	public int getcMonth() {
		return cMonth;
	}
	public void setcMonth(int cMonth) {
		this.cMonth = cMonth;
	}
	public int getcYear() {
		return cYear;
	}
	public void setcYear(int cYear) {
		this.cYear = cYear;
	}
	public int geteDay() {
		return eDay;
	}
	public void seteDay(int eDay) {
		this.eDay = eDay;
	}
	public int geteMonth() {
		return eMonth;
	}
	public void seteMonth(int eMonth) {
		this.eMonth = eMonth;
	}
	public int geteYear() {
		return eYear;
	}
	public void seteYear(int eYear) {
		this.eYear = eYear;
	}
	public Contracts(String name, Departments department, Positions position, Date birthDay, String identityNumber,
			String gender, Graduate graduate, String nationality, String identityPlace, Date identityDay,
			String address1, String address2, String phone, String bankNumber, String bank, int workTime, int restTime,
			int leaveTime, int salary, Payment payment, int cDay, int cMonth, int cYear, int eDay, int eMonth,
			int eYear) {
		super();
		this.name = name;
		this.department = department;
		this.position = position;
		this.birthDay = birthDay;
		this.identityNumber = identityNumber;
		this.gender = gender;
		this.graduate = graduate;
		this.nationality = nationality;
		this.identityPlace = identityPlace;
		this.identityDay = identityDay;
		this.address1 = address1;
		this.address2 = address2;
		this.phone = phone;
		this.bankNumber = bankNumber;
		this.bank = bank;
		this.workTime = workTime;
		this.restTime = restTime;
		this.leaveTime = leaveTime;
		this.salary = salary;
		this.payment = payment;
		this.cDay = cDay;
		this.cMonth = cMonth;
		this.cYear = cYear;
		this.eDay = eDay;
		this.eMonth = eMonth;
		this.eYear = eYear;
	}
	public Contracts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
