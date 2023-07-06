package com.datn.web.bean;

import java.util.Date;

public class Blogs {
	private int idBlog;
	protected String title;
	protected String image1;
	protected String image2;
	protected String image3;
	protected String intro;
	protected String quote;
	protected String paragraph1;
	protected String paragraph2;
	protected String paragraph3;
	protected Date createDate;
	protected Tags tag;
	public int getIdBlog() {
		return idBlog;
	}
	public void setIdBlog(int idBlog) {
		this.idBlog = idBlog;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public String getParagraph1() {
		return paragraph1;
	}
	public void setParagraph1(String paragraph1) {
		this.paragraph1 = paragraph1;
	}
	public String getParagraph2() {
		return paragraph2;
	}
	public void setParagraph2(String paragraph2) {
		this.paragraph2 = paragraph2;
	}
	public String getParagraph3() {
		return paragraph3;
	}
	public void setParagraph3(String paragraph3) {
		this.paragraph3 = paragraph3;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Tags getTag() {
		return tag;
	}
	public void setTag(Tags tag) {
		this.tag = tag;
	}
	public Blogs(String title, String image1, String image2, String image3, String intro, String quote,
			String paragraph1, String paragraph2, String paragraph3, Date createDate, Tags tag) {
		super();
		this.title = title;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.intro = intro;
		this.quote = quote;
		this.paragraph1 = paragraph1;
		this.paragraph2 = paragraph2;
		this.paragraph3 = paragraph3;
		this.createDate = createDate;
		this.tag = tag;
	}
	public Blogs() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
