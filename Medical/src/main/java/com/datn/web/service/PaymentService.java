package com.datn.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datn.web.bean.Payment;
import com.datn.web.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	public List<Payment> showAllPayment() {
		return paymentRepository.showAllPayment();
	}

}
