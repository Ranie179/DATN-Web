package com.datn.web.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.datn.web.bean.Payment;

@Repository
public class PaymentRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class PaymentRowMapper implements RowMapper<Payment> {
        public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Payment payment = new Payment();
        	payment.setIdPayment(rs.getInt("ID_Payment"));
        	payment.setPayment(rs.getString("Payment"));
        	return payment;
        }
    }
	public List<Payment> showAllPayment() {
		String sql = "SELECT * FROM Payment";
		return jdbcTemplate.query(sql, new PaymentRowMapper());
	}

}
