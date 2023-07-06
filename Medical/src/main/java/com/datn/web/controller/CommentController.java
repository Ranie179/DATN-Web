package com.datn.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.datn.web.bean.Departments;
import com.datn.web.service.CommentService;
import com.datn.web.service.DepartmentService;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "comment")
	public String comment(@RequestParam(required = false) String email, @RequestParam("idService") int idService,
			@RequestParam("comment") String comment, Model model) {
		if (email == "") {
			String failed = "failed";
			List<Departments> departments = departmentService.showDepartmentAndDoctor();
	    	model.addAttribute("department", departments);
			return "redirect:showServiceInfo?id=" + idService + "&failed=" + failed;
		}
		else {
		commentService.comment(email, comment, idService);
		List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	model.addAttribute("department", departments);
		return "redirect:showServiceInfo?id=" +idService;
		}
	}
	

}
