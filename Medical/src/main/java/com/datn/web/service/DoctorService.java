package com.datn.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.datn.web.bean.Doctors;
import com.datn.web.repository.DoctorRepository;
@Service
public class DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;

	public List<Doctors> showAllDoctor(int page, int pageSize, String search, Integer idDepartment, Integer experience) {
		if (!StringUtils.isEmpty(search) && experience == null && idDepartment == null) {
			return doctorRepository.showAllDoctor(page, pageSize, search);
		} else if (experience == null && idDepartment == null) {
			return doctorRepository.showAllDoctor(page, pageSize);
		} else if (experience != null && search == null && idDepartment == null) {
			return doctorRepository.showDoctorByExp(page, pageSize, experience);
		} else if (idDepartment != null && search == null && experience == null) {
			return doctorRepository.showDoctorByIdDepartment(page, pageSize, idDepartment);
		} else {
			return doctorRepository.showAllDoctor(page, pageSize);
		}
	}


	public List<Doctors> showDoctorInfo(int idDoctor) {
		return doctorRepository.showDoctorInfo(idDoctor);
	}

	public List<Doctors> doctorBonus(int idDepartment) {
		return doctorRepository.doctorBonus(idDepartment);
	}
	public int getTotalDoctorCount(String search, Integer idDepartment,Integer experience) {
		if (!StringUtils.isEmpty(search) && experience == null && idDepartment == null) {
			return doctorRepository.getTotalDoctorCount(search);
		} else if (experience == null && idDepartment == null) {
			return doctorRepository.getTotalDoctorCount();
		} else if (experience != null && search == null && idDepartment == null) {
			return doctorRepository.getTotalDoctorByExp(experience);
		} else if (idDepartment != null && search == null && experience == null) {
			return doctorRepository.getTotalDoctorByIdDepartment(idDepartment);
		} else {
			return doctorRepository.getTotalDoctorCount();
		}
	}
	public int getTotalDoctorByIdDepartment(int idDepartment) {
		return doctorRepository.getTotalDoctorByIdDepartment(idDepartment);
	}


	public List<Doctors> showExpDoctor() {
		return doctorRepository.showExpDoctor();
	}


	public void adminEditDoctor(int id, int idDepartment,int idPosition, int experience, int salary, String information, String phone, String isWorking,
			String relativePath) {
		doctorRepository.adminEditDoctor(id, idDepartment, idPosition, experience, salary, information, phone, isWorking, relativePath);
		
	}


	public void addDoctor(String name, String gender, String phone, String birthDay, int idPosition, int idDepartment,
			int salary, int idGraduate, int newID) {
		doctorRepository.addDoctor(name, gender, phone, birthDay, idPosition, idDepartment, salary, idGraduate, newID);
		
	}


	public void adminEditDoctorWithoutAvatar(int id, int idDepartment, int idPosition, int experience, int salary,
			String information, String phone, String isWorking) {
		doctorRepository.adminEditDoctorWithoutAvatar(id, idDepartment, idPosition, experience, salary, information, phone, isWorking);
		
	}


	public void adminDeleteDoctor(int id) {
		doctorRepository.adminDeleteDoctor(id);
		
	}


	public int adminGetCountDoctor() {
		return doctorRepository.adminGetCountDoctor();	
	}


	public List<Doctors> adminShowDeletedDoctor(int page, int pageSize) {
		return doctorRepository.adminShowDeletedDoctor(page, pageSize);
	}







}
