package com.datn.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datn.web.bean.Positions;
import com.datn.web.repository.PositionRepository;

@Service
public class PositionService {
	@Autowired
	private PositionRepository positionRepository;

	public List<Positions> showAllPosition() {
		return positionRepository.showAllPosition();
	}

}
