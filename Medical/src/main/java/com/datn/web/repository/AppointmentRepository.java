package com.datn.web.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.datn.web.bean.Appointment;
import com.datn.web.bean.Departments;

@Repository
public class AppointmentRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class AppointmentRowMapper implements RowMapper<Appointment> {
        public Appointment mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Appointment appointment = new Appointment();
        	appointment.setId(rs.getInt("ID"));
        	appointment.setName(rs.getString("Name"));
        	appointment.setAppointmentDate(rs.getTimestamp("Appointment_Date"));
        	appointment.setEmail(rs.getString("Email"));
        	appointment.setGender(rs.getString("Gender"));
        	appointment.setNote(rs.getString("Note"));
        	appointment.setPhone(rs.getString("Phone"));
        	appointment.setToken(rs.getString("Token"));
        	appointment.setInformation(rs.getString("Information"));
        	appointment.setAppointmentStatus(rs.getString("Appointment_Status"));
        	Departments department = new Departments();
        	department.setDepartmentName(rs.getString("Department_Name"));
        	appointment.setDepartment(department);
            return appointment;
        }
    }
	public void setAppointment(String name, String phone, String date, String email, String gender,
			int idDepartment, String note, String token) throws Exception {
		String sql = "INSERT INTO appointment(name, phone, appointment_date, email, gender, id_department, note, token, information)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[] {name, phone, date, email, gender, idDepartment, note, token, "Không có thông báo"};
		int rs =jdbcTemplate.update(sql, params);
		if(rs!= 1) {
			throw new Exception(); 
		}
		
	}

	public List<Appointment> searchAppointment(String token) {
		String sql = "SELECT * FROM `appointment` join departments on appointment.ID_Department = departments.ID_Department where token = ?";
		Object[] params = new Object[] {token};
		return jdbcTemplate.query(sql, params, new AppointmentRowMapper());
	}

	public List<Appointment> adminShowAllAppointment() {
		String sql = "SELECT * FROM `appointment` join departments on appointment.ID_Department = departments.ID_Department";
		return jdbcTemplate.query(sql, new AppointmentRowMapper());
	}

	public List<Appointment> adminShowAppointmentInfo(int id) {
		String sql = "SELECT * FROM `appointment` join departments on appointment.ID_Department = departments.ID_Department where id = ?";
		Object[] params = new Object[] {id};
		return jdbcTemplate.query(sql, params, new AppointmentRowMapper());
	}

	public void adminUpdateAppointment(int id, String status, String information) {
		String sql = "UPDATE appointment\r\n"
				+ "SET Appointment_Status = ?, Information = ?\r\n"
				+ "WHERE id = ?;";
		Object[] params = new Object[] {status, information, id};
		jdbcTemplate.update(sql, params);
		
	}

	public List<Appointment> showUpcomingAppointment() {
		String sql = "SELECT appointment.*, departments.Department_Name\n"
				+ "FROM appointment\r\n"
				+ "JOIN departments ON appointment.ID_Department = departments.ID_Department\r\n"
				+ "WHERE (appointment.Appointment_Date >= NOW() AND appointment.appointment_Date <= NOW() + INTERVAL 4 HOUR)\r\n"
				+ "AND appointment_status = 'Đã lên lịch'\r\n"
				+ "ORDER BY appointment.Appointment_Date ASC;";
		return jdbcTemplate.query(sql, new AppointmentRowMapper());
	}

	public List<Appointment> showMyAppointment(int page, int pageSize, String email) {
		int offset = (page - 1) * pageSize;
		String sql = "SELECT appointment.*, departments.Department_Name\r\n"
				+ "FROM appointment\r\n"
				+ "JOIN departments ON appointment.ID_Department = departments.ID_Department\r\n"
				+ "JOIN account ON appointment.ID_Account = account.ID_Account\r\n"
				+ "WHERE account.email = ?\r\n"
				+ "ORDER BY appointment.Appointment_Date ASC LIMIT ? OFFSET ?;";
		Object[] params = new Object[] {email, pageSize, offset};
		return jdbcTemplate.query(sql, params, new AppointmentRowMapper());
	}

	public int getTotalAppointment(String email) {
		String sql = "SELECT COUNT(*) FROM appointment\r\n"
				+ "JOIN Account ON appointment.ID_Account = account.ID_Account\r\n"
				+ "WHERE account.email = ?";
		Object[] params = new Object[] {email};
		return jdbcTemplate.queryForObject(sql, params, Integer.class);
	}

	public List<Appointment> showAppointmentByID(int id) {
		String sql = "SELECT * FROM `appointment` join departments on appointment.ID_Department = departments.ID_Department where id = ?";
		Object[] params = new Object[] {id};
		return jdbcTemplate.query(sql, params, new AppointmentRowMapper());
	}



}
