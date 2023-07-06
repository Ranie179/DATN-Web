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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.datn.web.service.BlogService;
import com.datn.web.service.DegreeService;
import com.datn.web.service.DepartmentService;
import com.datn.web.service.DoctorService;
import com.datn.web.service.PositionService;
import com.datn.web.service.ServiceService;
import com.datn.web.bean.Doctors;
import com.datn.web.bean.Positions;
import com.datn.web.bean.Services;
import com.datn.web.bean.Blogs;
import com.datn.web.bean.Degrees;
import com.datn.web.bean.Departments;

@Controller
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private DegreeService degreeService;
	@Autowired
	private ServiceService serviceService;
	@Autowired
	private BlogService blogService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private PositionService positionService;
	
	@RequestMapping(value = "showAllDoctor", method = RequestMethod.GET)
	public String showAllService(@RequestParam(required = false) Integer experience,
			@RequestParam(required = false) Integer idDepartment,
			@RequestParam(required = false) String search, 
			@RequestParam(defaultValue = "1") int page, Model model) {
		int pageSize = 10; 
	    int totalCount = doctorService.getTotalDoctorCount(search, idDepartment, experience); 
	    int totalPages = (int) Math.ceil((double) totalCount / pageSize); 
		List<Doctors> doctors = doctorService.showAllDoctor(page, pageSize, search, idDepartment, experience);
	    model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", totalPages);
	    
	    List<Services> services = serviceService.showMoreService();
	    model.addAttribute("service", services);
	    List<Blogs> recentBlog = blogService.getRecentBlog();
		model.addAttribute("recent", recentBlog);
		
		List<Departments> departments = departmentService.showDepartmentAndDoctor();
	    model.addAttribute("doctorlist", doctors);
		model.addAttribute("department", departments);
		model.addAttribute("idDepartment", idDepartment);
		model.addAttribute("experience", experience);
		model.addAttribute("search", search);
		if (experience == null) {
	        experience = 0; // Giá trị mặc định, ví dụ "1" cho "Dưới 1 năm"
	    }
	    
	    // Truyền giá trị trạng thái đã chọn sang view
	    model.addAttribute("selectedExperience", experience);
		return "customer/doctorlist";
	}
	
	@RequestMapping(value = "showDoctorInfo", method = RequestMethod.GET)
	public String showDoctorInfo(@RequestParam("idDoctor") int idDoctor, 
			@RequestParam("idDepartment") int idDepartment, Model model) {
		List<Degrees> degrees = degreeService.showDegree(idDoctor);
		model.addAttribute("degree", degrees);
		List<Doctors> doctorInfo = doctorService.showDoctorInfo(idDoctor);
		model.addAttribute("doctorInfo", doctorInfo.get(0));
		List<Doctors> doctorBonus = doctorService.doctorBonus(idDepartment);
		model.addAttribute("doctorBonus", doctorBonus);
		List<Services> services = serviceService.showMoreService();
		model.addAttribute("serviceBonus", services);
		List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	model.addAttribute("department", departments);
		return "customer/doctor";
	}
	
	@RequestMapping(value = "adminShowDoctor")
	public String adminShowDoctor(@RequestParam(required = false) Integer experience,
			@RequestParam(required = false) Integer idDepartment,
			@RequestParam(required = false) String search, 
			@RequestParam(defaultValue = "1") int page, Model model) {
		int pageSize = 10; 
	    int totalCount = doctorService.getTotalDoctorCount(search, idDepartment, experience); 
	    int totalPages = (int) Math.ceil((double) totalCount / pageSize); 
		List<Doctors> doctors = doctorService.showAllDoctor(page, pageSize, search, idDepartment, experience);
	    model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", totalPages);
	    
	    List<Services> services = serviceService.showMoreService();
	    model.addAttribute("service", services);
	    List<Blogs> recentBlog = blogService.getRecentBlog();
		model.addAttribute("recent", recentBlog);
		
		List<Departments> departments = departmentService.showDepartmentAndDoctor();
	    model.addAttribute("doctorlist", doctors);
		model.addAttribute("department", departments);
		model.addAttribute("idDepartment", idDepartment);
		model.addAttribute("experience", experience);
		model.addAttribute("search", search);
		if (experience == null) {
	        experience = 0;
	    }
	    model.addAttribute("selectedExperience", experience);
		return "admin/adminDoctorList";
	}
	
	@RequestMapping(value = "adminShowDoctorInfo")
	public String adminShowDoctorInfo(@RequestParam("id") int id, Model model) {
		List<Doctors> doctorInfo = doctorService.showDoctorInfo(id);
		model.addAttribute("doctorInfo", doctorInfo.get(0));
		List<Departments> departments = departmentService.showDepartmentAndDoctor();
		model.addAttribute("department", departments);
		List<Positions> position = positionService.showAllPosition();
		model.addAttribute("position", position);
		List<Degrees> degrees = degreeService.showDegree(id);
		model.addAttribute("degree", degrees);
		return "admin/test";
	}
	
	@RequestMapping(value = "adminEditDoctor")
	public String adminEditDoctor(@RequestParam("id") int id, @RequestParam("idDepartment") int idDepartment, 
			@RequestParam("idPosition") int idPosition, @RequestParam("isWorking") String isWorking, 
			@RequestParam("experience") int experience, @RequestParam("salary") int salary, 
			@RequestParam("information") String information, @RequestParam("phone") String phone, 
			@RequestParam(required = false) MultipartFile file, Model model) throws IOException {

		if (!file.isEmpty()) {
		    String relativePath = "/resources/images/avatar" + String.valueOf(id) + ".png";
		    String destinationPath = "C:\\Users\\Admin\\Documents\\GitHub\\Capstone\\Medical\\src\\main\\webapp\\" + relativePath;
		    File destinationFile = new File(destinationPath);
		    Path destination = destinationFile.toPath();
		    InputStream inputStream = file.getInputStream();
		    Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);
		    
		    doctorService.adminEditDoctor(id, idDepartment, idPosition, experience, salary, information, phone, isWorking, relativePath);
		} else {
		    doctorService.adminEditDoctorWithoutAvatar(id, idDepartment, idPosition, experience, salary, information, phone, isWorking);
		}

		return "redirect:adminShowDoctorInfo?id=" + id;
	}
	
	@RequestMapping(value = "adminDeleteDoctor")
	public String adminDeleteDoctor(@RequestParam("id") int id) {
		doctorService.adminDeleteDoctor(id);
		return "redirect:adminShowDoctor";
	}
	
	@RequestMapping("adminShowDeletedDoctor")
	public String adminShowDeletedDoctor(@RequestParam(defaultValue = "1") int page, Model model) {
		int pageSize = 10; 
	    int totalCount = doctorService.adminGetCountDoctor(); 
	    int totalPages = (int) Math.ceil((double) totalCount / pageSize); 
		List<Doctors> doctor = doctorService.adminShowDeletedDoctor(page, pageSize);
		model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("doctor", doctor);
		return "admin/adminDeletedDoctor";
	}
	
	
}

