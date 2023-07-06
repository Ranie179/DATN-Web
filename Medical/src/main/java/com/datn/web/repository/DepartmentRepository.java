package com.datn.web.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.datn.web.bean.Departments;

@Repository
public class DepartmentRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class DepartmentRowMapper implements RowMapper<Departments> {
        public Departments mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Departments department = new Departments();
        	department.setDepartmentName(rs.getString("Department_Name"));
        	department.setIdDepartment(rs.getInt("ID_Department"));
        	department.setNumOfDoctors(rs.getInt("NumOfDoctors"));
        	department.setImage(rs.getString("Image"));
        	department.setIntro(rs.getString("Intro"));
        	department.setInformation(rs.getString("Information"));
        	department.setIsWorking(rs.getString("isWorking"));
        	return department;
        }
    }
	public List<Departments> showDepartmentAndDoctor() {
		String sql = "SELECT departments.*, COUNT(doctors.ID_Doctor)\r\n"
				+ "as NumOfDoctors FROM departments LEFT JOIN doctors\r\n"
				+ "ON departments.ID_Department = doctors.ID_Department where departments.isWorking = \"Vẫn còn hoạt động\" GROUP BY departments.Department_Name;";
		return jdbcTemplate.query(sql, new DepartmentRowMapper());
	}
	public int getTotalDepartmentCount() {
		String sql = "SELECT COUNT(*) FROM departments WHERE isWorking = \"Vẫn còn hoạt động\"";
		return jdbcTemplate.queryForObject(sql,Integer.class);
	}
	public int getTotalDeletedDepartmentCount() {
		String sql = "SELECT COUNT(*) FROM departments WHERE isWorking = \"Không còn hoạt động nữa\"";
		return jdbcTemplate.queryForObject(sql,Integer.class);
	}
	public List<Departments> showAllDepartmentWorking(int page, int pageSize) {
		int offset = (page - 1) * pageSize;
	    String sql = "SELECT departments.*, COUNT(doctors.ID_Doctor)\r\n"
	    		+ "as NumOfDoctors FROM departments LEFT JOIN doctors\r\n"
	    		+ "ON departments.ID_Department = doctors.ID_Department where departments.isWorking = \"Vẫn còn hoạt động\" "
	    		+ "GROUP BY departments.Department_Name LIMIT ? OFFSET ?";
	    Object[] params = new Object[]{pageSize, offset};
		return jdbcTemplate.query(sql, params, new DepartmentRowMapper());
	}
	public List<Departments> showDepartmentInfo(int id) {
		String sql = "SELECT departments.*, COUNT(doctors.ID_Doctor) AS NumOfDoctors\r\n"
				+ "FROM departments\r\n"
				+ "LEFT JOIN doctors ON departments.ID_Department = doctors.ID_Department\r\n"
				+ "WHERE departments.ID_Department = ?\r\n"
				+ "GROUP BY departments.Department_Name;";
		Object[] params = new Object[] {id};
		return jdbcTemplate.query(sql, params, new DepartmentRowMapper());
	}
	public void deleteDepartment(int idDepartment)  {
		String sql = "UPDATE departments\r\n"
				+ "SET isWorking = 'Không còn hoạt động nữa'\r\n"
				+ "WHERE ID_Department = ?;";
		String sql2 ="UPDATE doctors\r\n"
				+ "SET isWorking = 'Không còn làm việc nữa'\r\n"
				+ "WHERE ID_Department IN (\r\n"
				+ "    SELECT ID_Department FROM departments WHERE isWorking = 'Không còn hoạt động nữa'\r\n"
				+ ");";
		Object[] params = new Object[] {idDepartment};
		jdbcTemplate.update(sql, params);
		jdbcTemplate.update(sql2);		
	}
	public List<Departments> adminShowDeletedDepartment(int page, int pageSize) {
		int offset = (page - 1) * pageSize;
	    String sql = "SELECT departments.*, COUNT(doctors.ID_Doctor)\r\n"
	    		+ "as NumOfDoctors FROM departments LEFT JOIN doctors\r\n"
	    		+ "ON departments.ID_Department = doctors.ID_Department\r\n"
	    		+ "WHERE departments.isWorking = \"Không còn hoạt động nữa\"\r\n"
	    		+ "GROUP BY departments.Department_Name LIMIT ? OFFSET ?";
	    Object[] params = new Object[]{pageSize, offset};
		return jdbcTemplate.query(sql, params, new DepartmentRowMapper());
	}
	public void adminEditDepartment(int id, String name, String intro, String information, String relativePath) {
		String sql = "UPDATE departments\r\n"
				+ "SET Department_Name = ?, Intro = ?, Information = ?, Image = ?\r\n"
				+ "WHERE ID_Department = ?;";
		Object[] params = new Object[] {name, intro, information, relativePath, id};
		jdbcTemplate.update(sql, params);
		
	}
	public void adminEditDepartmentWithoutImage(int id, String name, String intro, String information) {
		String sql = "UPDATE departments\r\n"
				+ "SET Department_Name = ?, Intro = ?, Information = ?\r\n"
				+ "WHERE ID_Department = ?;";
		Object[] params = new Object[] {name, intro, information, id};
		jdbcTemplate.update(sql, params);
		
	}
	public List<Departments> adminShowDepartmentInfo(int id) {
		String sql = "SELECT departments.*, COUNT(doctors.ID_Doctor)\r\n"
				+ "as NumOfDoctors FROM departments LEFT JOIN doctors\r\n"
				+ "ON departments.ID_Department = doctors.ID_Department where departments.ID_Department = ? GROUP BY departments.Department_Name;";
		Object[] params = new Object[] {id};
		return jdbcTemplate.query(sql, params, new DepartmentRowMapper());
	}
	public int getNewID() {
		String sql = "SELECT MAX(ID_Department) FROM Departments";
		Integer newID = jdbcTemplate.queryForObject(sql, Integer.class);
		if (newID == null) {
			newID = 0;
		}
		return newID;
	}
	public void adminAddDepartment(int newID, String name, String intro, String information, String relativePath) {
		String sql = "INSERT INTO Departments(ID_Department, Department_Name, Intro, Information, Image)\r\n"
				+ "VALUES (?, ?, ?, ?, ?);";
		Object[] params = new Object[] {newID, name, intro, information, relativePath};
		jdbcTemplate.update(sql, params);
	}
	public void adminAddDepartmentWithoutImage(int newID, String name, String intro, String information) {
		String sql = "INSERT INTO Departments(ID_Department, Department_Name, Intro, Information)\r\n"
				+ "VALUES (?, ?, ?, ?);";
		Object[] params = new Object[] {newID, name, intro, information};
		jdbcTemplate.update(sql, params);
		
	}
	public String getDepartment(int idDepartment) {
		String sql = "SELECT Department_Name from departments where ID_Department = ?";
		Object[] params = new Object[] {idDepartment};
		return jdbcTemplate.queryForObject(sql, params, String.class);
	}

}
