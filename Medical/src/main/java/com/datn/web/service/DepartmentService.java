package com.datn.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.datn.web.bean.Departments;
import com.datn.web.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Departments> showDepartmentAndDoctor() {
		return departmentRepository.showDepartmentAndDoctor();
	}

	public int getTotalDepartmentCount() {
		return departmentRepository.getTotalDepartmentCount();
	}

	public List<Departments> showAllDepartmentWorking(int page, int pageSize) {
		return departmentRepository.showAllDepartmentWorking(page, pageSize);
	}

	public List<Departments> showDepartmentInfo(int id) {
		return departmentRepository.showDepartmentInfo(id);
	}

	public void deleteDepartment(int idDepartment){
		departmentRepository.deleteDepartment(idDepartment);
	}

	public List<Departments> adminShowDeletedDepartment(int page, int pageSize) {
		return departmentRepository.adminShowDeletedDepartment(page, pageSize);
	}


	public int getTotalDeletedDepartmentCount() {
		return departmentRepository.getTotalDeletedDepartmentCount();
	}

	public void adminEditDepartment(int id, String name, String intro, String information, String relativePath) {
		departmentRepository.adminEditDepartment(id, name, intro, information, relativePath);
	}

	public void adminEditDepartmentWithoutImage(int id, String name, String intro, String information) {
		departmentRepository.adminEditDepartmentWithoutImage(id, name, intro, information);
		
	}

	public List<Departments> adminShowDepartmentInfo(int id) {
		return departmentRepository.adminShowDepartmentInfo(id);
	}

	public int getNewID() {
		return departmentRepository.getNewID();
	}

	public void adminAddDepartment(int newID, String name, String intro, String information, String relativePath) {
		departmentRepository.adminAddDepartment(newID, name, intro, information, relativePath);
		
	}

	public void adminAddDepartmentWithoutImage(int newID, String name, String intro, String information) {
		departmentRepository.adminAddDepartmentWithoutImage(newID, name, intro, information);
		
	}

	public String getDepartment(int idDepartment) {
		return departmentRepository.getDepartment(idDepartment);
	}



}
