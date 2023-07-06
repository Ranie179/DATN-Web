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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.datn.web.bean.Blogs;
import com.datn.web.bean.Departments;
import com.datn.web.bean.Doctors;
import com.datn.web.bean.Services;
import com.datn.web.service.BlogService;
import com.datn.web.service.DepartmentService;
import com.datn.web.service.DoctorService;
import com.datn.web.service.ServiceService;

import jakarta.servlet.ServletContext;
@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private BlogService blogService;
	@Autowired
	private ServiceService serviceService;
	
	public int getNewID() {
		return departmentService.getNewID();
	}
	public static String getPath() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        ServletContext servletContext = attr.getRequest().getServletContext();
        String realPath = servletContext.getRealPath("/");
        String rootFolderPath = realPath.replace("\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps", "");
        return realPath;
    }
	
	@RequestMapping(value = "showAllDepartment")
	public String showAllDepartment(@RequestParam(defaultValue = "1") int page,  Model model) {
		int pageSize = 6;
	    int totalCount = departmentService.getTotalDepartmentCount( );
	    int totalPages = (int) Math.ceil((double) totalCount / pageSize);
		List<Departments> departmentslist = departmentService.showAllDepartmentWorking(page, pageSize);
	    model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("departmentList", departmentslist);
	    List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	model.addAttribute("department", departments);
		return "customer/departmentlist";
	}
	
	@RequestMapping(value = "showDepartmentInfo")
	public String showDepartmentInfo(@RequestParam("id") int id, Model model) {
		List<Departments> departmentInfo = departmentService.showDepartmentInfo(id);
		model.addAttribute("departmentInfo", departmentInfo.get(0));
		List<Doctors> doctors = doctorService.showExpDoctor();
		List<Blogs> recent = blogService.getRecentBlog();
		List<Services> service = serviceService.showServiceByIdDepartment(id);
		model.addAttribute("doctor", doctors);
		model.addAttribute("recent", recent);
		model.addAttribute("service", service);
		List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	model.addAttribute("department", departments);
		return "customer/department";
	}
	
	@RequestMapping(value = "adminShowDepartment")
	public String adminShowDepartment(@RequestParam(defaultValue = "1") int page,  Model model) {
		int pageSize = 10;
	    int totalCount = departmentService.getTotalDepartmentCount( );
	    int totalPages = (int) Math.ceil((double) totalCount / pageSize);
		List<Departments> departments = departmentService.showAllDepartmentWorking(page, pageSize);
	    model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("department", departments);
		return "admin/adminDepartmentList";
	}
	
	@RequestMapping(value = "deleteDepartment")
	public String deleteDepartment(@RequestParam("id") int idDepartment){
		departmentService.deleteDepartment(idDepartment);
		return "redirect:adminShowDepartment";
	}
	
	@RequestMapping(value = "adminShowDeletedDepartment")
	public String adminShowDeletedDepartment(@RequestParam(defaultValue = "1") int page,  Model model) {
		int pageSize = 10;
	    int totalCount = departmentService.getTotalDeletedDepartmentCount( );
	    int totalPages = (int) Math.ceil((double) totalCount / pageSize);
		List<Departments> departments = departmentService.adminShowDeletedDepartment(page, pageSize);
	    model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("department", departments);
		return "admin/adminDeletedDepartment";
	}

	@RequestMapping(value = "adminShowDepartmentInfo")
	public String adminShowDepartmentInfo(@RequestParam(required = false) String success, @RequestParam("id") int id, Model model) {
		List<Departments> department = departmentService.adminShowDepartmentInfo(id);
		model.addAttribute("department", department.get(0));
		model.addAttribute("successMessage", success);
		return "admin/adminDepartment";
	}
	
	@RequestMapping(value = "adminEditDepartment")
	public String adminEditDepartment(@RequestParam("id") int id, @RequestParam(required = false) MultipartFile file, @RequestParam("name") String name, 
			@RequestParam("intro") String intro, @RequestParam("information") String information, Model model) throws IOException {
		
		if (!file.isEmpty()) {
			System.out.print(getPath());
		    String relativePath = "/resources/images/department" + String.valueOf(id) + ".png";
		    String destinationPath = "C:\\Users\\Admin\\Documents\\GitHub\\Capstone\\Medical\\src\\main\\webapp\\" + relativePath;
		    File destinationFile = new File(destinationPath);
		    Path destination = destinationFile.toPath();
		    InputStream inputStream = file.getInputStream();
		    Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);
		    departmentService.adminEditDepartment(id, name, intro, information, relativePath);
		    File directory = new File("C:\\Users\\Admin\\Documents\\GitHub\\Capstone\\Medical\\src\\main\\webapp\\resources\\images");
		    String[] files = directory.list();
		    for (String file1 : files) {
		        File currentFile = new File(directory.getPath(), file1);
		        if (currentFile.isDirectory()) {
		        }
		    }


		} else {
			departmentService.adminEditDepartmentWithoutImage(id, name, intro, information);
		}
		String success = "Success";
		return "redirect:adminShowDepartmentInfo?id=" +id+ "&success=" + success;
	}
	
	@RequestMapping(value = "adminAddDepartment")
	public String adminAddDepartment(@RequestParam(required = false) MultipartFile file, @RequestParam("name") String name, 
			@RequestParam("intro") String intro, @RequestParam("information") String information) throws IOException {
		int newID = getNewID() + 1;
		if (!file.isEmpty()) {
		    String relativePath = "/resources/images/department" + String.valueOf(newID) + ".png";
		    String destinationPath = "C:\\Users\\Admin\\Documents\\GitHub\\Capstone\\Medical\\src\\main\\webapp\\" + relativePath;
		    File destinationFile = new File(destinationPath);
		    Path destination = destinationFile.toPath();
		    InputStream inputStream = file.getInputStream();
		    Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);
		    departmentService.adminAddDepartment(newID,name, intro, information, relativePath);
		} else {
			departmentService.adminAddDepartmentWithoutImage(newID, name, intro, information);
		}
		return "redirect:adminShowDepartment";
	}
}
