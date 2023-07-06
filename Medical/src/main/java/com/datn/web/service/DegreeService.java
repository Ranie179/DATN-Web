package com.datn.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datn.web.bean.Degrees;
import com.datn.web.repository.DegreeRepository;

@Service
public class DegreeService {

	@Autowired
	private DegreeRepository degreeRepository;
	
	public List<Degrees> showDegree(int idDoctor) {
		return degreeRepository.showDegree(idDoctor);
	}

}
