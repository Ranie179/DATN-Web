package com.datn.web.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datn.web.bean.Appointment;
import com.datn.web.repository.AppointmentRepository;

@Service
public class AppointmentService {
	@Autowired
	private AppointmentRepository appointmentRepository;

	public void setAppointment(String name, String phone, String date, String email, String gender,
			int idDepartment, String note, String token) throws Exception {
		appointmentRepository.setAppointment(name, phone, date, email, gender, idDepartment, note, token);
		
	}

	public List<Appointment> searchAppointment(String token) {
		return appointmentRepository.searchAppointment(token);
	}

	public List<Appointment> adminShowAllAppointment() {
		return appointmentRepository.adminShowAllAppointment();
	}

	public List<Appointment> adminShowAppointmentInfo(int id) {
		return appointmentRepository.adminShowAppointmentInfo(id);
	}

	public void adminUpdateAppointment(int id, String status, String information) {
		appointmentRepository.adminUpdateAppointment(id, status, information);
		
	}

	public List<Appointment> showUpcomingAppointment() {
		return appointmentRepository.showUpcomingAppointment();
	}

	public List<Appointment> showMyAppointment(int page, int pageSize, String email) {
		return appointmentRepository.showMyAppointment(page, pageSize, email);
	}

	public int getTotalAppointment(String email) {
		return appointmentRepository.getTotalAppointment(email);
	}

	public List<Appointment> showAppointmentByID(int id) {
		return appointmentRepository.showAppointmentByID(id);
	}

}