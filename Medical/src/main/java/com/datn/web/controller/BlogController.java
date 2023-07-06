package com.datn.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.datn.web.bean.Blogs;
import com.datn.web.bean.Departments;
import com.datn.web.bean.Tags;
import com.datn.web.service.BlogService;
import com.datn.web.service.DepartmentService;
import com.datn.web.service.TagService;

@Controller
public class BlogController {
	@Autowired
	private BlogService blogService;
	@Autowired
	private TagService tagService;
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "showTags")
	public String showTags(Model model) {
		List<Tags> tags = tagService.showTags();
		model.addAttribute("tag", tags);
		return "customer/bloglist";
	}
	public int getNewID() {
		return blogService.getNewID() +1;
	}
	public void getUrl(MultipartFile file, String relativePath) throws IOException {
		 String destinationPath = "C:\\Users\\Admin\\Documents\\GitHub\\Capstone\\Medical\\src\\main\\webapp\\" + relativePath;
		 File destinationFile = new File(destinationPath);
		 Path destination = destinationFile.toPath();
		 InputStream inputStream = file.getInputStream();
		 Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);
	}
	
	@RequestMapping(value ="showAllBlogs")
	public String showAllBlogs (@RequestParam(defaultValue = "1") int page, Model model) {
		
		int totalCount = blogService.getTotalBlogCount();
		int pageSize = 10;
		int totalPages = (int) Math.ceil((double) totalCount / pageSize);
		
		List<Blogs> blogs = blogService.showAllBlogs(page, pageSize);
		model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", totalPages);
		model.addAttribute("blog", blogs);
		List<Blogs> recentBlog = blogService.getRecentBlog();
		model.addAttribute("recent", recentBlog);
		List<Tags> tags = tagService.showTags();
		model.addAttribute("tag", tags);
		List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	model.addAttribute("department", departments);
		return "customer/bloglist";
	}
	
	@RequestMapping(value = "showBlogInfo")
	public String showBlogInfo(@RequestParam("idBlog") int idBlog, Model model) {
		List<Blogs> blogs = blogService.showBlogInfo(idBlog);
		model.addAttribute("blogInfo", blogs.get(0));
		List<Tags> tags = tagService.showTags();
		model.addAttribute("tag", tags);
		List<Blogs> recentBlog = blogService.getRecentBlog();
		model.addAttribute("recent", recentBlog);
		List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	model.addAttribute("department", departments);
		return "customer/blog";
	}
	
	@RequestMapping(value = "showBlogByTag")
	public String showBlogByTag(@RequestParam("idTag") int idTag, Model model) {
		List<Blogs> blogs = blogService.showBlogByTag(idTag);
		model.addAttribute("blog", blogs);
		List<Tags> tags = tagService.showTags();
		model.addAttribute("tag", tags);
		List<Blogs> recentBlog = blogService.getRecentBlog();
		model.addAttribute("recent", recentBlog);
		return "customer/bloglist";
	}
	
	@RequestMapping(value = "adminShowBlog")
	public String adminShowBlog(@RequestParam(required = false) String success, @RequestParam(required = false) String deleted, 
			@RequestParam(defaultValue = "1") int page, Model model) {
		int totalCount = blogService.getTotalBlogCount();
		int pageSize = 10;
		int totalPages = (int) Math.ceil((double) totalCount / pageSize);
		
		List<Blogs> blogs = blogService.showAllBlogs(page, pageSize);
		model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", totalPages);
		model.addAttribute("blog", blogs);
		model.addAttribute("deleted", deleted);
		model.addAttribute("success", success);
		return "admin/adminBlogList";
	}
	
	@RequestMapping(value = "adminDeleteBlog")
	public String adminDeleteBlog(@RequestParam("id") int id){
		blogService.adminDeleteBlog(id);
		String deleted = "deleted";
		return "redirect:adminShowBlog?deleted=" +deleted;
	}
	
	@RequestMapping(value = "adminShowBlogInfo")
	public String adminShowBlogInfo(@RequestParam(required = false) String success,
			@RequestParam("id") int id, Model model) {
		List<Blogs> blogInfo = blogService.showBlogInfo(id);
		model.addAttribute("blogInfo", blogInfo.get(0));
		List<Tags> tag = tagService.showTags();
		model.addAttribute("tag", tag);
		model.addAttribute("success", success);
		return "admin/adminBlog";
	}
	
	@RequestMapping(value = "adminEditBlog")
	public String adminEditBlog(@RequestParam(required = false) MultipartFile  img1, @RequestParam(required = false) MultipartFile  img2, 
			@RequestParam(required = false) MultipartFile  img3, @RequestParam("id") int id, 
			@RequestParam("name") String name, @RequestParam("intro") String intro, 
			@RequestParam("idTag") int idTag, @RequestParam("quote") String quote, 
			@RequestParam("para1") String para1, @RequestParam("para2") String para2, 
			@RequestParam("para3") String para3, Model model) throws IOException {
		if (!img1.isEmpty() && img2.isEmpty() && img3.isEmpty()) {
			 String relativePath = "/resources/images/blog" + String.valueOf(id) + "img1.png";
			 getUrl(img1, relativePath);
			 blogService.adminEditBlogImage1(name, idTag, intro, quote, para1, para2, para3, relativePath, id);
		} 
		else if (!img2.isEmpty() && img1.isEmpty() && img3.isEmpty()) {
			 String relativePath = "/resources/images/blog" + String.valueOf(id) + "img2.png";
			 getUrl(img2, relativePath);
			 blogService.adminEditBlogImage2(name, idTag, intro, quote, para1, para2, para3, relativePath, id);
		}
		else if (!img3.isEmpty() && img2.isEmpty() && img1.isEmpty()) {
			 String relativePath = "/resources/images/blog" + String.valueOf(id) + "img3.png";
			 getUrl(img3, relativePath);
			 blogService.adminEditBlogImage3(name, idTag, intro, quote, para1, para2, para3, relativePath, id);
		}
		else if (!img1.isEmpty() && !img2.isEmpty() && img3.isEmpty()){
			 String relativePath1 = "/resources/images/blog" + String.valueOf(id) + "img1.png";
			 getUrl(img1, relativePath1);
			 String relativePath2 = "/resources/images/blog" + String.valueOf(id) + "img2.png";
			 getUrl(img2, relativePath2);
			 blogService.adminEditBlogImage12(name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, id);
		}
		else if (!img2.isEmpty() && !img3.isEmpty() && img1.isEmpty()) {
			 String relativePath1 = "/resources/images/blog" + String.valueOf(id) + "img2.png";
			 getUrl(img2, relativePath1);
			 String relativePath2 = "/resources/images/blog" + String.valueOf(id) + "img3.png";
			 getUrl(img3, relativePath2);
			 blogService.adminEditBlogImage23(name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, id);
		}
		else if (!img1.isEmpty() && !img3.isEmpty() && img2.isEmpty()) {
			 String relativePath1 = "/resources/images/blog" + String.valueOf(id) + "img1.png";
			 getUrl(img2, relativePath1);
			 String relativePath2 = "/resources/images/blog" + String.valueOf(id) + "img3.png";
			 getUrl(img3, relativePath2);
			 blogService.adminEditBlogImage13(name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, id);
		}
		else if (!img1.isEmpty() && !img2.isEmpty() && !img3.isEmpty()) {
			 String relativePath1 = "/resources/images/blog" + String.valueOf(id) + "img1.png";
			 getUrl(img1, relativePath1);
			 String relativePath2 = "/resources/images/blog" + String.valueOf(id) + "img2.png";
			 getUrl(img2, relativePath2);
			 String relativePath3 = "/resources/images/blog" + String.valueOf(id) + "img3.png";
			 getUrl(img3, relativePath3);
			 blogService.adminEditBlog3Image(name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, relativePath3, id);
		
		}
		else {
			blogService.adminEditBlog(name, idTag, intro, quote, para1, para2, para3, id);
		}
		String success = "Success";
		return "redirect:adminShowBlogInfo?id=" + id +"&success="+success;
	}

	@RequestMapping(value = "adminAddBlog")
	public String adminAddBlog(@RequestParam(required = false) MultipartFile  img1, @RequestParam(required = false) MultipartFile  img2, 
			@RequestParam(required = false) MultipartFile  img3, @RequestParam("name") String name, 
			@RequestParam("intro") String intro, @RequestParam("idTag") int idTag, 
			@RequestParam("quote") String quote, @RequestParam("para1") String para1, 
			@RequestParam("para2") String para2, @RequestParam("para3") String para3, 
			Model model) throws IOException {
		int newID = getNewID();
		
		if (!img1.isEmpty() && img2.isEmpty() && img3.isEmpty()) {
			 String relativePath = "/resources/images/blog" + String.valueOf(newID) + "img1.png";
			 getUrl(img1, relativePath);
			 blogService.adminAddBlogImg1(name, idTag, intro, quote, para1, para2, para3, relativePath, newID);
		} 
		else if (!img2.isEmpty() && img1.isEmpty() && img3.isEmpty()) {
			 String relativePath = "/resources/images/blog" + String.valueOf(newID) + "img2.png";
			 getUrl(img2, relativePath);
			 blogService.adminAddBlogImg2(name, idTag, intro, quote, para1, para2, para3, relativePath, newID);
		}
		else if (!img3.isEmpty() && img2.isEmpty() && img1.isEmpty()) {
			 String relativePath = "/resources/images/blog" + String.valueOf(newID) + "img3.png";
			 getUrl(img3, relativePath);
			 blogService.adminAddBlogImg3(name, idTag, intro, quote, para1, para2, para3, relativePath, newID);
		}
		else if (!img1.isEmpty() && !img2.isEmpty() && img3.isEmpty()){
			 String relativePath1 = "/resources/images/blog" + String.valueOf(newID) + "img1.png";
			 getUrl(img1, relativePath1);
			 String relativePath2 = "/resources/images/blog" + String.valueOf(newID) + "img2.png";
			 getUrl(img2, relativePath2);
			 blogService.adminAddBlogImg12(name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, newID);
		}
		else if (!img2.isEmpty() && !img3.isEmpty() && img1.isEmpty()) {
			 String relativePath1 = "/resources/images/blog" + String.valueOf(newID) + "img2.png";
			 getUrl(img2, relativePath1);
			 String relativePath2 = "/resources/images/blog" + String.valueOf(newID) + "img3.png";
			 getUrl(img3, relativePath2);
			 blogService.adminAddBlogImg23(name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, newID);
		}
		else if (!img1.isEmpty() && !img3.isEmpty() && img2.isEmpty()) {
			 String relativePath1 = "/resources/images/blog" + String.valueOf(newID) + "img1.png";
			 getUrl(img2, relativePath1);
			 String relativePath2 = "/resources/images/blog" + String.valueOf(newID) + "img3.png";
			 getUrl(img3, relativePath2);
			 blogService.adminAddBlogImg13(name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, newID);
		}
		else if (!img1.isEmpty() && !img2.isEmpty() && !img3.isEmpty()) {
			 String relativePath1 = "/resources/images/blog" + String.valueOf(newID) + "img1.png";
			 getUrl(img1, relativePath1);
			 String relativePath2 = "/resources/images/blog" + String.valueOf(newID) + "img2.png";
			 getUrl(img2, relativePath2);
			 String relativePath3 = "/resources/images/blog" + String.valueOf(newID) + "img3.png";
			 getUrl(img3, relativePath3);
			 blogService.adminAddBlog3Img(name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, relativePath3, newID);
		
		}
		else {
			blogService.adminAddBlog(name, idTag, intro, quote, para1, para2, para3, newID);
		}
		String success = "success!";
		return "redirect:adminShowBlog?success=" + success;
	}
	
	@RequestMapping(value = "getToAddBlog")
	public String getToAddBlog(Model model) {
		List<Tags> tag = tagService.showTags();
		model.addAttribute("tag", tag);
		return "admin/adminAddBlog";
	}
}
