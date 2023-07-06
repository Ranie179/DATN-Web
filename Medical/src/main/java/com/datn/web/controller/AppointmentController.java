package com.datn.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.List;
import java.util.Random;

import com.datn.web.bean.Appointment;
import com.datn.web.bean.Blogs;
import com.datn.web.bean.Departments;
import com.datn.web.bean.Services;
import com.datn.web.bean.Doctors;
import com.datn.web.service.AppointmentService;
import com.datn.web.service.BlogService;
import com.datn.web.service.DepartmentService;
import com.datn.web.service.DoctorService;
import com.datn.web.service.ServiceService;

@Controller
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private DoctorService doctorService;
	@Autowired 
	private BlogService blogService;
	@Autowired
	private ServiceService serviceService;
	@Autowired
	private DepartmentService departmentService;
	
	public String getDepartment(int idDepartment) {
		return departmentService.getDepartment(idDepartment);
	}
	public String getDate(String appointmentDate) throws ParseException {
		String dateString = appointmentDate;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", new Locale("vi", "VN"));
        Date date = formatter.parse(dateString);
        SimpleDateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm", new Locale("vi", "VN"));
        String formattedDate = outputFormatter.format(date);
		return formattedDate;
	}
	public static String generateToken(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder token = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            token.append(randomChar);
        }

        return token.toString();
    }
	
	@RequestMapping(value = "setAppointment")
	public String setApointment(@RequestParam("name") String name, @RequestParam("phone") String phone,
			@RequestParam("date") String date, @RequestParam("email") String email, 
			@RequestParam("gender") String gender,@RequestParam("idDepartment") int idDepartment, 
			@RequestParam("note") String note, Model model) throws Exception {
		String token = generateToken(10);
		appointmentService.setAppointment(name, phone, date, email, gender, idDepartment, note, token);
		List<Services> services = serviceService.showMoreService();
		List<Doctors> doctors = doctorService.showExpDoctor();
		List<Blogs> recent = blogService.getRecentBlog();
		List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	model.addAttribute("department", departments);
		model.addAttribute("token", token);
		model.addAttribute("doctor", doctors);
		model.addAttribute("service", services);
		model.addAttribute("recent", recent);
		
		String message = "Xin chào" + name + "\r\nChúng tôi gửi mail này để xác nhận "
				+ "rằng bạn đã đặt lịch tại phòng khám của chúng tôi vào: " + getDate(date) + " với"
						+ " những thông tin như sau:\r\n"
						+ "Số điện thoại:" + phone + "\r\n"
						+ "Giới tính:"  + gender + "\r\n"
						+ "Khoa:" + getDepartment(idDepartment)+ "\r\n"
						+ "Mã của cuộc hẹn:" + token;
		Email mail = new SimpleEmail();
		mail.setHostName("smtp-mail.outlook.com");
		mail.setSmtpPort(587);
		mail.setAuthenticator(new DefaultAuthenticator("rainievalentine@outlook.com.vn", "Rainie132$"));
		mail.setStartTLSEnabled(true);
		mail.setFrom("rainievalentine@outlook.com.vn", "Phòng khám đa khoa Medic Support");
		mail.addTo(email, "client");
		mail.setSubject("Thông báo xác nhận lịch hẹn ở phòng khám Medic Support");
		mail.setMsg(message);
		mail.send();
		
		return "customer/success";
	}
	
	@RequestMapping(value = "searchAppointment")
	public String searchAppointment(@RequestParam("token") String token, Model model) {
		List<Appointment> appointment = appointmentService.searchAppointment(token);
		model.addAttribute("appointment", appointment.get(0));
		List<Services> services = serviceService.showMoreService();
		List<Doctors> doctors = doctorService.showExpDoctor();
		List<Blogs> recent = blogService.getRecentBlog();
		model.addAttribute("doctor", doctors);
		model.addAttribute("service", services);
		model.addAttribute("recent", recent);
		List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	model.addAttribute("department", departments);
		return "customer/appointmentinfo";
	}
	
	@RequestMapping(value = "showMoreInfo")
	public String showMoreInfo(Model model) {
		List<Services> services = serviceService.showMoreService();
		List<Doctors> doctors = doctorService.showExpDoctor();
		List<Blogs> recent = blogService.getRecentBlog();
		model.addAttribute("doctor", doctors);
		model.addAttribute("service", services);
		model.addAttribute("recent", recent);
		List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	model.addAttribute("department", departments);
		return "customer/turnup";
	}
	
	@RequestMapping(value = "showDepartmentForAppointment")
	public String showDepartmentForAppointment(Model model) {
		List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	model.addAttribute("department", departments);
    	return "customer/myappointment";
	}
	
	@RequestMapping(value = "adminShowAllAppointment")
	public String adminShowAllAppointment(Model model) {
		List<Appointment> appointment = appointmentService.adminShowAllAppointment();
		model.addAttribute("appointmentlist", appointment);
		return "admin/adminAppointmentList";
	}
	
	@RequestMapping(value = "adminShowAppointmentInfo")
	public String adminShowAppointmentInfo(@RequestParam("id") int id, Model model) {
		List<Appointment> appointmentInfo = appointmentService.adminShowAppointmentInfo(id);
		model.addAttribute("appointment", appointmentInfo.get(0));
		return "admin/adminAppointment";
	}
	
	@RequestMapping(value = "adminUpdateAppointment")
	public String adminUpdateAppointment(@RequestParam("id") int id, @RequestParam("status") String status, 
			@RequestParam("information") String information,
			Model model) {
		appointmentService.adminUpdateAppointment(id, status, information);
		return "redirect:adminShowAllAppointment";
	}
	
	@RequestMapping(value = "showUpcomingAppointment")
	public String showUpcomingAppointment(Model model) {
		List<Appointment> appointment =  appointmentService.showUpcomingAppointment();
		model.addAttribute("appointment", appointment);
		return "admin/adminPage";
	}
	
	@RequestMapping(value = "showMyAppointment")
	public String showMyAppointment(@RequestParam(defaultValue = "1") int page, @RequestParam("email") String email, Model model){
		int pageSize = 10;
	    int totalCount = appointmentService.getTotalAppointment(email);
	    int totalPages = (int) Math.ceil((double) totalCount / pageSize);
		List<Appointment> appointment = appointmentService.showMyAppointment(page, pageSize, email);
		List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	model.addAttribute("department", departments);
		model.addAttribute("email", email);
		model.addAttribute("appointment", appointment);
	    model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", totalPages);
		return "customer/appointmentList";
	}
	
	@RequestMapping(value = "showAppointmentByID")
	public String showAppointmentByID(@RequestParam("id") int id, Model model) {
		List<Appointment> appointment = appointmentService.showAppointmentByID(id);
		model.addAttribute("appointment", appointment.get(0));
		List<Services> services = serviceService.showMoreService();
		List<Doctors> doctors = doctorService.showExpDoctor();
		List<Blogs> recent = blogService.getRecentBlog();
		List<Departments> departments = departmentService.showDepartmentAndDoctor();
    	model.addAttribute("department", departments);
		model.addAttribute("doctor", doctors);
		model.addAttribute("service", services);
		model.addAttribute("recent", recent);
		return "customer/appointmentinfo";
	}

}
