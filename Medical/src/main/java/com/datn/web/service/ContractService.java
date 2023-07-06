package com.datn.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datn.web.bean.Contracts;
import com.datn.web.repository.ContractRepository;

@Service
public class ContractService {
	@Autowired
	private ContractRepository contractRepository;

	public int getNewID() {
		return contractRepository.getNewID();
	}
	public void addContract(int newID, String name, String nationality, String phone, String iPlace, String identity,
			String gender, int idGraduate, String birthDay, String iDate, String address1, String address2, String createDate,
			String endDate, int salary, String bankNumber, String bank, int workTime, int restTime, int leaveTime,
			int idDepartment, int idPosition, int idPayment) {
		contractRepository.addContract(newID, name, nationality, phone, iPlace, identity, gender, idGraduate, birthDay, iDate, address1, address2,
				createDate, endDate, salary, bankNumber, bank, workTime, restTime, leaveTime, idDepartment, idPosition, idPayment);
		
	}
	public List<Contracts> adminShowContract(int id) {
		return contractRepository.adminShowContract(id);
	}

}
