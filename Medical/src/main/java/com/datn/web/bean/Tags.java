package com.datn.web.bean;

public class Tags {
	private int idTag;
	protected String tag;
	protected int numOfPosts;
	
	public int getIdTag() {
		return idTag;
	}
	public void setIdTag(int idTag) {
		this.idTag = idTag;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getNumOfPosts() {
		return numOfPosts;
	}
	public void setNumOfPosts(int numOfPosts) {
		this.numOfPosts = numOfPosts;
	}
	public Tags(String tag, int numOfPosts) {
		super();
		this.tag = tag;
		this.numOfPosts = numOfPosts;
	}
	public Tags() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
