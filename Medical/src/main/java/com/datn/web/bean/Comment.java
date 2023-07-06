package com.datn.web.bean;

import java.util.Date;

public class Comment {
	protected String email;
	protected String comment;
	protected Date createDate;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Comment(String comment, Date createDate) {
		super();
		this.comment = comment;
		this.createDate = createDate;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
