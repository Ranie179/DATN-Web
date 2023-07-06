package com.datn.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.datn.web.bean.Blogs;
import com.datn.web.bean.Departments;
import com.datn.web.bean.Doctors;
import com.datn.web.bean.Comment;
import com.datn.web.service.BlogService;
import com.datn.web.service.CommentService;
import com.datn.web.service.DepartmentService;
import com.datn.web.service.DoctorService;

@Controller
public class HomeController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CommentService commentService;
    
    @RequestMapping("/")
    public String test(Model model) {
    	List<Doctors> doctors = doctorService.showExpDoctor();
    	List<Blogs> blogs = blogService.getRecentBlog();
    	blogs.remove(4);
    	blogs.remove(3);
    	int doctorCount = doctorService.getTotalDoctorCount(null, null, null);
    	List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	List<Comment> comment = commentService.showRecentComment();
    	model.addAttribute("comment", comment);
    	model.addAttribute("department", departments);
        model.addAttribute("doctor", doctors);
        model.addAttribute("blog", blogs);
        model.addAttribute("count", doctorCount);
        return "customer/home";
    }
    
    @RequestMapping(value = "getToContact")
    public String getToContact(Model model)
    {
    	List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	model.addAttribute("department", departments);
    	return "customer/contact";
    }
    
    @RequestMapping(value = "getToRegister")
    public String getToRegister(Model model)
    {
    	List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	model.addAttribute("department", departments);
    	return "customer/register";
    }
    
    @RequestMapping(value = "getToPolicy")
    public String getToPolicy(Model model)
    {
    	List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	model.addAttribute("department", departments);
    	return "customer/terms-conditions";
    }
    
    @RequestMapping(value = "getToContidion")
    public String getToContidion(Model model)
    {
    	List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	model.addAttribute("department", departments);
    	return "customer/conditions-register";
    }
    
    @RequestMapping(value = "getToChat")
    public String getToChat(Model model)
    {
    	List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	model.addAttribute("department", departments);
    	return "customer/chat";
    }
    
    @RequestMapping(value = "getToAbout")
    public String getToAbout(Model model)
    {
    	List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	model.addAttribute("department", departments);
    	return "customer/about";
    }
}

