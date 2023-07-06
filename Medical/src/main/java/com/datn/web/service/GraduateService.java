package com.datn.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datn.web.bean.Graduate;
import com.datn.web.repository.GraduateRepository;

@Service
public class GraduateService {
	@Autowired
	private GraduateRepository graduateRepository;

	public List<Graduate> showAllGraduate() {
		return graduateRepository.showAllGraduate();
	}

}
