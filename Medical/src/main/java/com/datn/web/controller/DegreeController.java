package com.datn.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.datn.web.service.DegreeService;
import com.datn.web.service.DoctorService;
import com.datn.web.bean.Degrees;
import com.datn.web.bean.Doctors;
@Controller
public class DegreeController {
	@Autowired
	private DegreeService degreeService;
	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping(value = "showDegree", method = RequestMethod.GET)
	public String showDegree (@RequestParam("idDoctor") int idDoctor, Model model) {
		List<Degrees> degrees = degreeService.showDegree(idDoctor);
		model.addAttribute("degree", degrees);
		List<Doctors> doctors = doctorService.showDoctorInfo(idDoctor);
		model.addAttribute("doctor", doctors);
		return "customer/doctor";
	}

}
