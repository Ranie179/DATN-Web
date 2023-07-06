package com.datn.web.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.datn.web.repository.ServiceRepository;
import com.datn.web.bean.Services;
@Service
public class ServiceService {
	@Autowired
	private ServiceRepository serviceRepository;
	
	public List<Services> showMoreService ()
	{
		return serviceRepository.showMoreService();
	}

	public List<Services> showServiceInfo(int id) {
		return serviceRepository.showServiceInfo(id);
	}
	
	public int getTotalServiceCount(String search) {
	    if (!StringUtils.isEmpty(search)) {
	        return serviceRepository.getTotalServiceCount(search);
	    } else {
	        return serviceRepository.getTotalServiceCount();
	    }
	}


	public List<Services> showAllService(int page, int pageSize, String search) {
	    if (!StringUtils.isEmpty(search)) {
	        return serviceRepository.showAllService(page, pageSize, search);
	    } else {
	        return serviceRepository.showAllService(page, pageSize);
	    }
	}


	public List<Services> searchServiceByName(String search) {
		return serviceRepository.searchServiceByName(search);
	}
	
	public List<Services> showServiceByIdDepartment(int id){
		return serviceRepository.showServiceByIdDepartment(id);
	}

	public List<Services> adminShowService(int page, int pageSize, String search) {
		if (!StringUtils.isEmpty(search)) {
	        return serviceRepository.adminShowService(page, pageSize, search);
	    } else {
	        return serviceRepository.adminShowService(page, pageSize);
	    }
	}

	public void adminDeleteService(int id) {
		serviceRepository.adminDeleteService(id);
		
	}

	public void upload1(String relativePath, int id) {
		serviceRepository.upload1(relativePath, id);
		
	}

	public void adminEditService(int id, String name, String intro, String description1, String description2,
			String description3, String advantage, String endline) {
		serviceRepository.adminEditService(id, name, intro, description1, description2, description3, advantage, endline);
		
	}

	public void adminEditServiceImage1(int id, String name, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath) {
		serviceRepository.adminEditServiceImage1(id, name, intro, description1, description2, description3, advantage, endline, relativePath);
		
	}

	public void adminEditServiceImage2(int id, String name, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath) {
		serviceRepository.adminEditServiceImage2(id, name, intro, description1, description2, description3, advantage, endline, relativePath);
		
	}

	public void adminEditServiceImage3(int id, String name, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath) {
		serviceRepository.adminEditServiceImage3(id, name, intro, description1, description2, description3, advantage, endline, relativePath);
		
	}

	public void adminEditServiceImage12(int id, String name, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath1, String relativePath2) {
		serviceRepository.adminEditServiceImage12(id, name, intro, description1, description2, description3, advantage, endline, relativePath1, relativePath2);
		
	}

	public void adminEditServiceImage23(int id, String name, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath1, String relativePath2) {
		serviceRepository.adminEditServiceImage23(id, name, intro, description1, description2, description3, advantage, endline, relativePath1, relativePath2);
		
	}

	public void adminEditServiceImage13(int id, String name, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath1, String relativePath2) {
		serviceRepository.adminEditServiceImage13(id, name, intro, description1, description2, description3, advantage, endline, relativePath1, relativePath2);
		
	}

	public void adminEditService3Image(int id, String name, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath1, String relativePath2,
			String relativePath3) {
		serviceRepository.adminEditService3Image(id, name, intro, description1, description2, description3, advantage, endline, relativePath1, relativePath2, relativePath3);
		
	}

	public int getNewID() {
		return serviceRepository.getNewID();
	}

	public void adminAddServiceImage1(int newID, String name, int idDepartment, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath) {
		serviceRepository.adminAddServiceImage1(newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath);
		
	}
	public void adminAddServiceImage2(int newID, String name, int idDepartment, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath) {
		serviceRepository.adminAddServiceImage2(newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath);
		
	}
	public void adminAddServiceImage3(int newID, String name, int idDepartment, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath) {
		serviceRepository.adminAddServiceImage2(newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath);
		
	}

	public void adminAddServiceImage12(int newID, String name, int idDepartment, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath1, String relativePath2) {
		serviceRepository.adminAddServiceImage12(newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath1, relativePath2);
		
	}
	public void adminAddServiceImage23(int newID, String name, int idDepartment, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath1, String relativePath2) {
		serviceRepository.adminAddServiceImage23(newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath1, relativePath2);
		
	}
	public void adminAddServiceImage13(int newID, String name, int idDepartment, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath1, String relativePath2) {
		serviceRepository.adminAddServiceImage13(newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath1, relativePath2);
		
	}

	public void adminAddService3Image(int newID, String name, int idDepartment, String intro, String description1,
			String description2, String description3, String advantage, String endline, String relativePath1,
			String relativePath2, String relativePath3) {
		serviceRepository.adminAddService3Image(newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath1, relativePath2, relativePath3);
		
	}

	public void adminAddService(int newID, String name, int idDepartment, String intro, String description1,
			String description2, String description3, String advantage, String endline) {
		serviceRepository.adminAddService(newID, name, idDepartment, intro, description1, description2, description3, advantage, endline);
		
	}

	
}
