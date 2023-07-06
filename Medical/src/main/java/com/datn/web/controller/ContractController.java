package com.datn.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.datn.web.bean.Contracts;
import com.datn.web.bean.Departments;
import com.datn.web.bean.Graduate;
import com.datn.web.bean.Payment;
import com.datn.web.bean.Positions;
import com.datn.web.service.ContractService;
import com.datn.web.service.DepartmentService;
import com.datn.web.service.DoctorService;
import com.datn.web.service.GraduateService;
import com.datn.web.service.PaymentService;
import com.datn.web.service.PositionService;

@Controller
public class ContractController {
	@Autowired
	private ContractService contractService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private GraduateService graduateService;
	
	public int getNewID() {
		return contractService.getNewID();
	}
	@RequestMapping(value = "addContract")
	public String addContract(@RequestParam("name") String name, @RequestParam("nationality") String nationality,
			@RequestParam("phone") String phone,@RequestParam("iplace") String iPlace,
			@RequestParam("identity") String identity,@RequestParam("gender") String gender, @RequestParam("idGraduate") int idGraduate,
			@RequestParam("birthday") String birthDay,@RequestParam("idate") String iDate,
			@RequestParam("address1") String address1,@RequestParam("address2") String address2,
			@RequestParam("createdate") String createDate,@RequestParam("enddate") String endDate,
			@RequestParam("salary") int salary,@RequestParam("banknumber") String bankNumber,
			@RequestParam("bank") String bank,@RequestParam("worktime") int workTime,
			@RequestParam("resttime") int restTime,@RequestParam("leavetime") int leaveTime,
			@RequestParam("idDepartment") int idDepartment,@RequestParam("idPosition") int idPosition,
			@RequestParam("idPayment") int idPayment, Model model) {
		int newID = getNewID() +1;
		contractService.addContract(newID, name, nationality, phone, iPlace, identity, gender, idGraduate, birthDay, iDate, address1, address2,
				createDate, endDate, salary, bankNumber, bank, workTime, restTime, leaveTime, idDepartment, idPosition, idPayment);
		doctorService.addDoctor(name, gender, phone, birthDay, idPosition, idDepartment, salary,idGraduate, newID);
		return "redirect:adminShowDoctor";
	}
	
	@RequestMapping(value = "getToAddDoctor")
	public String getToAddDoctor(Model model) {
		List<Departments> department = departmentService.showDepartmentAndDoctor();
		model.addAttribute("department", department);
		List<Positions> position = positionService.showAllPosition();
		model.addAttribute("position", position);
		List<Payment> payment = paymentService.showAllPayment();
		model.addAttribute("payment", payment);
		List<Graduate> graduate = graduateService.showAllGraduate();
		model.addAttribute("graduate", graduate);
		return "admin/adminAddContract";
	}
	
	@RequestMapping(value = "adminShowContract")
	public String adminShowContract(@RequestParam("id") int id, Model model) {
		List<Contracts> contract = contractService.adminShowContract(id);
		model.addAttribute("contract", contract.get(0));
		return "admin/adminContract";
	}

}
