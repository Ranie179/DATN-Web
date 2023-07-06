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

import com.datn.web.bean.Departments;
import com.datn.web.bean.Doctors;
import com.datn.web.bean.Services;
import com.datn.web.bean.Comment;
import com.datn.web.service.CommentService;
import com.datn.web.service.DepartmentService;
import com.datn.web.service.DoctorService;
import com.datn.web.service.ServiceService;

@Controller
public class ServiceController {
	@Autowired
	private ServiceService serviceService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private CommentService commentService;
	
	public int getNewID() {
		return serviceService.getNewID();
	}
	@RequestMapping(value = "showAllService", method = RequestMethod.GET)
	public String showAllService(@RequestParam(defaultValue = "1") int page, 
			@RequestParam(required = false) String search, Model model) {
	    int pageSize = 5;
	    int totalCount = serviceService.getTotalServiceCount(search);
	    int totalPages = (int) Math.ceil((double) totalCount / pageSize);
	    List<Services> services = serviceService.showAllService(page, pageSize, search);
	    model.addAttribute("service", services);
	    model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", totalPages);
		List<Doctors> doctors = doctorService.showExpDoctor();
	    model.addAttribute("doctor", doctors);
	    model.addAttribute("search", search);
	    List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	model.addAttribute("department", departments);
	    return "customer/servicelist";
	}

	
	@RequestMapping(value = "showServiceInfo", method = RequestMethod.GET)
	public String showServiceInfo(@RequestParam(required = false) String failed, @RequestParam("id") int id, Model model) {
		List<Services> serviceInfo = serviceService.showServiceInfo(id);
		model.addAttribute("serviceInfo",serviceInfo.get(0));
		List<Services> services = serviceService.showMoreService();
	    model.addAttribute("service", services);
	    List<Comment> comments = commentService.showComment(id);
	    model.addAttribute("comment", comments);
	    model.addAttribute("failed", failed);
	    List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	model.addAttribute("department", departments);
		return "customer/service";
	}
	
	@RequestMapping(value = "searchServiceByName", method = RequestMethod.GET)
	public String searchServiceByName(@RequestParam("search") String search, Model model) {
	    List<Services> services = serviceService.searchServiceByName(search);
	    model.addAttribute("service", services);
	    model.addAttribute("searchKeyword", search);
	    return "customer/servicelist";
	}

	@RequestMapping(value = "adminShowService")
	public String adminShowService(@RequestParam(defaultValue = "1") int page, 
			@RequestParam(required = false) String search, Model model) {
	    int pageSize = 10;
	    int totalCount = serviceService.getTotalServiceCount(search);
	    int totalPages = (int) Math.ceil((double) totalCount / pageSize);
	    List<Services> services = serviceService.adminShowService(page, pageSize, search);
	    model.addAttribute("service", services);
	    model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("search", search);
	    return "admin/adminServiceList";
	}
	
	@RequestMapping(value = "adminDeleteService")
	public String adminDeleteService(@RequestParam("id") int id, Model model) {
		serviceService.adminDeleteService(id);
		return "redirect:adminShowService";
	}
	
	@RequestMapping(value = "adminShowServiceInfo")
	public String adminShowServiceInfo(@RequestParam("id") int id, Model model){
		List<Services> serviceInfo = serviceService.showServiceInfo(id);
		List<Departments> departments = departmentService.showDepartmentAndDoctor();
		model.addAttribute("serviceInfo", serviceInfo.get(0));
	    model.addAttribute("department", departments);
		return "admin/adminService";
	}
	public void getUrl(MultipartFile file, String relativePath) throws IOException {
		 String destinationPath = "C:\\Users\\Admin\\Documents\\GitHub\\Capstone\\Medical\\src\\main\\webapp\\" + relativePath;
		 File destinationFile = new File(destinationPath);
		 Path destination = destinationFile.toPath();
		 InputStream inputStream = file.getInputStream();
		 Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);
	}
	@RequestMapping(value = "adminEditService")
	public String adminEditService(@RequestParam("id") int id, @RequestParam(required = false) MultipartFile  img1, 
			@RequestParam(required = false) MultipartFile  img2, @RequestParam(required = false) MultipartFile  img3, 
			@RequestParam("name") String  name, @RequestParam("intro") String  intro, @RequestParam("idDepartment") int idDepartment,
			@RequestParam("description1") String  description1, @RequestParam("description2") String  description2, 
			@RequestParam("description3") String  description3, @RequestParam("advantage") String  advantage, 
			@RequestParam("endline") String  endline, Model model) throws IOException {
		
		if (!img1.isEmpty() && img2.isEmpty() && img3.isEmpty()) {
			 String relativePath = "/resources/images/service" + String.valueOf(id) + "img1.png";
			 getUrl(img1, relativePath);
			 serviceService.adminEditServiceImage1(id, name, intro, description1, description2, description3, advantage, endline, relativePath);
		} 
		else if (!img2.isEmpty() && img1.isEmpty() && img3.isEmpty()) {
			 String relativePath = "/resources/images/service" + String.valueOf(id) + "img2.png";
			 getUrl(img2, relativePath);
			 serviceService.adminEditServiceImage2(id, name, intro, description1, description2, description3, advantage, endline, relativePath);
		}
		else if (!img3.isEmpty() && img2.isEmpty() && img1.isEmpty()) {
			 String relativePath = "/resources/images/service" + String.valueOf(id) + "img3.png";
			 getUrl(img3, relativePath);
			 serviceService.adminEditServiceImage3(id, name, intro, description1, description2, description3, advantage, endline, relativePath);
		}
		else if (!img1.isEmpty() && !img2.isEmpty() && img3.isEmpty()){
			 String relativePath1 = "/resources/images/service" + String.valueOf(id) + "img1.png";
			 getUrl(img1, relativePath1);
			 String relativePath2 = "/resources/images/service" + String.valueOf(id) + "img2.png";
			 getUrl(img2, relativePath2);
			 serviceService.adminEditServiceImage12(id, name, intro, description1, description2, description3, advantage, endline, relativePath1, relativePath2);
		}
		else if (!img2.isEmpty() && !img3.isEmpty() && img1.isEmpty()) {
			 String relativePath1 = "/resources/images/service" + String.valueOf(id) + "img2.png";
			 getUrl(img2, relativePath1);
			 String relativePath2 = "/resources/images/service" + String.valueOf(id) + "img3.png";
			 getUrl(img3, relativePath2);
			 serviceService.adminEditServiceImage23(id, name, intro, description1, description2, description3, advantage, endline, relativePath1, relativePath2);
		}
		else if (!img1.isEmpty() && !img3.isEmpty() && img2.isEmpty()) {
			 String relativePath1 = "/resources/images/service" + String.valueOf(id) + "img1.png";
			 getUrl(img2, relativePath1);
			 String relativePath2 = "/resources/images/service" + String.valueOf(id) + "img3.png";
			 getUrl(img3, relativePath2);
			 serviceService.adminEditServiceImage13(id, name, intro, description1, description2, description3, advantage, endline, relativePath1, relativePath2);
		}
		else if (!img1.isEmpty() && !img2.isEmpty() && !img3.isEmpty()) {
			 String relativePath1 = "/resources/images/service" + String.valueOf(id) + "img1.png";
			 getUrl(img1, relativePath1);
			 String relativePath2 = "/resources/images/service" + String.valueOf(id) + "img2.png";
			 getUrl(img2, relativePath2);
			 String relativePath3 = "/resources/images/service" + String.valueOf(id) + "img3.png";
			 getUrl(img3, relativePath3);
			 serviceService.adminEditService3Image(id, name, intro, description1, description2, description3, advantage, endline, relativePath1, relativePath2, relativePath3);
			
		}
		else {
			serviceService.adminEditService(id, name, intro, description1, description2, description3, advantage, endline);
		}
		return "redirect:adminShowServiceInfo?id=" + id;
	}
	@RequestMapping(value = "getToAddService")
	public String getToAddService(Model model) {
		List<Departments> departments = departmentService.showDepartmentAndDoctor();
		model.addAttribute("department", departments);
		return "admin/adminAddService";
	}
	
	@RequestMapping(value = "adminAddService")
	public String adminAddService(@RequestParam(required = false) MultipartFile  img1, 
			@RequestParam(required = false) MultipartFile  img2, @RequestParam(required = false) MultipartFile  img3, 
			@RequestParam("name") String  name, @RequestParam("idDepartment") int idDepartment, @RequestParam("intro") String intro, 
			@RequestParam("description1") String  description1, @RequestParam("description2") String  description2, 
			@RequestParam("description3") String  description3, @RequestParam("advantage") String  advantage, 
			@RequestParam("endline") String  endline, Model model) throws IOException {
		int newID = getNewID() +1;
		if (!img1.isEmpty() && img2.isEmpty() && img3.isEmpty()) {
			 String relativePath = "/resources/images/service" + String.valueOf(newID) + "img1.png";
			 getUrl(img1, relativePath);
			 serviceService.adminAddServiceImage1(newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath);
		} 
		else if (!img2.isEmpty() && img1.isEmpty() && img3.isEmpty()) {
			 String relativePath = "/resources/images/service" + String.valueOf(newID) + "img2.png";
			 getUrl(img2, relativePath);
			 serviceService.adminAddServiceImage2(newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath);
		}
		else if (!img3.isEmpty() && img2.isEmpty() && img1.isEmpty()) {
			 String relativePath = "/resources/images/service" + String.valueOf(newID) + "img3.png";
			 getUrl(img3, relativePath);
			 serviceService.adminAddServiceImage3(newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath);
		}
		else if (!img1.isEmpty() && !img2.isEmpty() && img3.isEmpty()){
			 String relativePath1 = "/resources/images/service" + String.valueOf(newID) + "img1.png";
			 getUrl(img1, relativePath1);
			 String relativePath2 = "/resources/images/service" + String.valueOf(newID) + "img2.png";
			 getUrl(img2, relativePath2);
			 serviceService.adminAddServiceImage12(newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath1, relativePath2);
		}
		else if (!img2.isEmpty() && !img3.isEmpty() && img1.isEmpty()) {
			 String relativePath1 = "/resources/images/service" + String.valueOf(newID) + "img2.png";
			 getUrl(img2, relativePath1);
			 String relativePath2 = "/resources/images/service" + String.valueOf(newID) + "img3.png";
			 getUrl(img3, relativePath2);
			 serviceService.adminAddServiceImage23(newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath1, relativePath2);
		}
		else if (!img1.isEmpty() && !img3.isEmpty() && img2.isEmpty()) {
			 String relativePath1 = "/resources/images/service" + String.valueOf(newID) + "img1.png";
			 getUrl(img2, relativePath1);
			 String relativePath2 = "/resources/images/service" + String.valueOf(newID) + "img3.png";
			 getUrl(img3, relativePath2);
			 serviceService.adminAddServiceImage13(newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath1, relativePath2);
		}
		else if (!img1.isEmpty() && !img2.isEmpty() && !img3.isEmpty()) {
			 String relativePath1 = "/resources/images/service" + String.valueOf(newID) + "img1.png";
			 getUrl(img1, relativePath1);
			 String relativePath2 = "/resources/images/service" + String.valueOf(newID) + "img2.png";
			 getUrl(img2, relativePath2);
			 String relativePath3 = "/resources/images/service" + String.valueOf(newID) + "img3.png";
			 getUrl(img3, relativePath3);
			 serviceService.adminAddService3Image(newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath1, relativePath2, relativePath3);
			
		}
		else {
			serviceService.adminAddService(newID, name, idDepartment, intro, description1, description2, description3, advantage, endline);
		}
		return "redirect:adminShowService";
	}
	

}
