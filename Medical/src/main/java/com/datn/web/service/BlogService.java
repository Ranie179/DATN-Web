package com.datn.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.datn.web.bean.Blogs;
import com.datn.web.repository.BlogRepository;

@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;

	public List<Blogs> showAllBlogs(int page, int pageSize) {
		return blogRepository.showAllBlogs(page, pageSize);
	}

	public int getTotalBlogCount() {
		return blogRepository.getTotalBlogCount();
	}

	public List<Blogs> showBlogInfo(int idBlog) {
		return blogRepository.showBlogInfo(idBlog);
	}

	public List<Blogs> getRecentBlog() {
		return blogRepository.getRecentBlog();
	}

	public List<Blogs> showBlogByTag(int idTag) {
		return blogRepository.showBlogByTag(idTag);
	}

	public void adminDeleteBlog(int id) {
		blogRepository.adminDeleteBlog(id);
		
	}

	public void adminEditBlog(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, int id) {
		blogRepository.adminEditBlog(name, idTag, intro, quote, para1, para2, para3, id);
		
	}

	public void adminEditBlogImage1(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath, int id) {
		blogRepository.adminEditBlogImage1(name, idTag, intro, quote, para1, para2, para3, relativePath, id);
		
	}

	public void adminEditBlogImage2(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath, int id) {
		blogRepository.adminEditBlogImage2(name, idTag, intro, quote, para1, para2, para3, relativePath, id);
		
	}

	public void adminEditBlogImage3(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath, int id) {
		blogRepository.adminEditBlogImage3(name, idTag, intro, quote, para1, para2, para3, relativePath, id);
		
	}

	public void adminEditBlogImage12(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath1, String relativePath2, int id) {
		blogRepository.adminEditBlogImage12(name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, id);
		
	}

	public void adminEditBlogImage23(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath1, String relativePath2, int id) {
		blogRepository.adminEditBlogImage23(name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, id);
		
	}

	public void adminEditBlogImage13(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath1, String relativePath2, int id) {
		blogRepository.adminEditBlogImage13(name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, id);
		
	}

	public void adminEditBlog3Image(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath1, String relativePath2, String relativePath3, int id) {
		blogRepository.adminEditBlog3Image(name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, relativePath3, id);
		
	}

	public int getNewID() {
		return blogRepository.getNewID();
	}

	public void adminAddBlogImg1(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath, int newID) {
		blogRepository.adminAddBlogImg1(name, idTag, intro, quote, para1, para2, para3, relativePath, newID);
		
	}
	
	public void adminAddBlogImg2(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath, int newID) {
		blogRepository.adminAddBlogImg2(name, idTag, intro, quote, para1, para2, para3, relativePath, newID);
		
	}
	
	public void adminAddBlogImg3(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath, int newID) {
		blogRepository.adminAddBlogImg3(name, idTag, intro, quote, para1, para2, para3, relativePath, newID);
		
	}
	
	public void adminAddBlogImg12(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath1, String relativePath2, int newID) {
		blogRepository.adminAddBlogImg12(name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, newID);
		
	}
	
	public void adminAddBlogImg23(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath1, String relativePath2, int newID) {
		blogRepository.adminAddBlogImg23(name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, newID);
		
	}
	
	public void adminAddBlogImg13(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath1, String relativePath2, int newID) {
		blogRepository.adminAddBlogImg13(name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, newID);
		
	}
	
	public void adminAddBlog3Img(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath1, String relativePath2, String relativePath3, int newID) {
		blogRepository.adminAddBlog3Img(name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, relativePath3, newID);
		
	}

	public void adminAddBlog(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, int newID) {
		blogRepository.adminAddBlog(name, idTag, intro, quote, para1, para2, para3, newID);
		
	}

}
