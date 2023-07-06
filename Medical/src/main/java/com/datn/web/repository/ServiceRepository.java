package com.datn.web.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.datn.web.bean.Services;
import com.datn.web.bean.Departments;
@Repository
public class ServiceRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class ServiceRowMapper implements RowMapper<Services> {
        public Services mapRow(ResultSet rs, int rowNum) throws SQLException {
            Services services = new Services();
            services.setId(rs.getInt("id"));
            services.setName(rs.getString("name"));
            services.setDescription1(rs.getString("description1"));
            services.setDescription2(rs.getString("description2"));
            services.setDescription3(rs.getString("description3"));
            services.setImage1(rs.getString("image1"));
            services.setImage2(rs.getString("image2"));
            services.setImage3(rs.getString("image3"));
            services.setIntro(rs.getString("intro"));
            services.setAdvantage(rs.getString("advantage"));
            services.setEndline(rs.getString("endline"));
            return services;
        }
    }
	
	private class ServiceDepartmentRowMapper implements RowMapper<Services> {
        public Services mapRow(ResultSet rs, int rowNum) throws SQLException {
            Services services = new Services();
            services.setId(rs.getInt("id"));
            services.setName(rs.getString("name"));
            services.setDescription1(rs.getString("description1"));
            services.setDescription2(rs.getString("description2"));
            services.setDescription3(rs.getString("description3"));
            services.setImage1(rs.getString("image1"));
            services.setImage2(rs.getString("image2"));
            services.setImage3(rs.getString("image3"));
            services.setIntro(rs.getString("intro"));
            services.setEndline(rs.getString("endline"));
            Departments department = new Departments();
            department.setDepartmentName(rs.getString("Department_Name"));
            services.setDepartment(department);
            return services;
        }
    }
	
	public List<Services> showMoreService() {
	    String sql = "SELECT * FROM service LIMIT 7";
	    return jdbcTemplate.query(sql, new ServiceRowMapper());
	}


	public List<Services> showServiceInfo(int id) {
		String sql = "SELECT * FROM service WHERE id = ?";
		Object[] params = new Object[] {id};
		return jdbcTemplate.query(sql, params, new ServiceRowMapper());
	}
	
	public List<Services> showAllService(int page, int pageSize) {
	    int offset = (page - 1) * pageSize;
	    String sql = "SELECT * FROM service LIMIT ? OFFSET ?";
	    Object[] params = new Object[]{pageSize, offset};
	    return jdbcTemplate.query(sql, params, new ServiceRowMapper());
	}
	
	public List<Services> showAllService(int page, int pageSize, String search) {
	    int offset = (page - 1) * pageSize;
	    String sql = "SELECT * FROM service WHERE UPPER(name) LIKE UPPER(?) LIMIT ? OFFSET ?";
	    Object[] params = new Object[]{"%" + search + "%", pageSize, offset};
	    return jdbcTemplate.query(sql, params, new ServiceRowMapper());
	}

	public int getTotalServiceCount() {
	    String sql = "SELECT COUNT(*) FROM service";
	    return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public int getTotalServiceCount(String search) {
	    String sql = "SELECT COUNT(*) FROM service WHERE UPPER(name) LIKE UPPER(?)";
	    Object[] params = new Object[]{"%" + search + "%"};
	    return jdbcTemplate.queryForObject(sql, params, Integer.class);
	}

	public List<Services> searchServiceByName(String search) {
	    String sql = "SELECT * FROM service WHERE UPPER(name) LIKE UPPER(?)";
	    Object[] params = new Object[]{"%" + search + "%"};
	    return jdbcTemplate.query(sql, params, new ServiceRowMapper());
	}
	
	public List<Services> showServiceByIdDepartment(int id){
		String sql = "SELECT * FROM service WHERE ID_Department = ? LIMIT 10";
		Object[] params = new Object[] {id};
		return jdbcTemplate.query(sql, params, new ServiceRowMapper());
	}
	
	public List<Services> adminShowService(int page, int pageSize){
		int offset = (page - 1) * pageSize;
		String sql = "SELECT * FROM service join departments on service.ID_Department = departments.ID_Department LIMIT ? OFFSET ?";
		Object[] params = new Object[]{pageSize, offset};
		return jdbcTemplate.query(sql, params, new ServiceDepartmentRowMapper());
	}
	
	public List<Services> adminShowService(int page, int pageSize, String search){
		int offset = (page - 1) * pageSize;
		String sql = "SELECT service.*, departments.Department_Name FROM service join departments on service.ID_Department = departments.ID_Department WHERE UPPER(name) LIKE UPPER(?) LIMIT ? OFFSET ?";
		Object[] params = new Object[]{"%" + search + "%", pageSize, offset};
		return jdbcTemplate.query(sql, params, new ServiceDepartmentRowMapper());
	}


	public void adminDeleteService(int id) {
		String sql = "DELETE FROM service where ID = ?";
		Object[] params = new Object[] {id};
		jdbcTemplate.update(sql, params);
		
	}


	public void upload1(String relativePath, int id) {
		String sql = "UPDATE FROM service(image1)\r\n"
				+ "VALUES (?)\r\n"
				+ "WHERE ID = ?";
		Object[] params = new Object[] {relativePath, id};
		jdbcTemplate.update(sql, params);
		
	}


	public void adminEditService(int id, String name, String intro, String description1, String description2,
			String description3, String advantage, String endline) {
		String sql = "UPDATE service\r\n"
				+ "SET name = ?, intro = ?, description1 = ?, description2 = ?, description3 = ?, "
				+ "advantage = ?, endline = ?\r\n"
				+ "where id = ?";
		Object[] params = new Object[] {name, intro, description1, description2, description3, advantage, endline, id};
		jdbcTemplate.update(sql, params);
		
	}


	public void adminEditServiceImage1(int id, String name, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath) {
		String sql = "UPDATE service\r\n"
				+ "SET name = ?, intro = ?, description1 = ?, description2 = ?, description3 = ?, "
				+ "advantage = ?, endline = ?, image1 = ?\r\n"
				+ "where id = ?";
		Object[] params = new Object[] {name, intro, description1, description2, description3, advantage, endline, relativePath, id};
		jdbcTemplate.update(sql, params);
	}


	public void adminEditServiceImage2(int id, String name, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath) {
		String sql = "UPDATE service\r\n"
				+ "SET name = ?, intro = ?, description1 = ?, description2 = ?, description3 = ?, "
				+ "advantage = ?, endline = ?, image2 = ?\r\n"
				+ "where id = ?";
		Object[] params = new Object[] {name, intro, description1, description2, description3, advantage, endline, relativePath, id};
		jdbcTemplate.update(sql, params);
		
	}


	public void adminEditServiceImage3(int id, String name, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath) {
		String sql = "UPDATE service\r\n"
				+ "SET name = ?, intro = ?, description1 = ?, description2 = ?, description3 = ?, "
				+ "advantage = ?, endline = ?, image3 = ?\r\n"
				+ "where id = ?";
		Object[] params = new Object[] {name, intro, description1, description2, description3, advantage, endline, relativePath, id};
		jdbcTemplate.update(sql, params);
		
	}


	public void adminEditServiceImage12(int id, String name, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath1, String relativePath2) {
		String sql = "UPDATE service\r\n"
				+ "SET name = ?, intro = ?, description1 = ?, description2 = ?, description3 = ?, "
				+ "advantage = ?, endline = ?, image1 = ?, image2 = ?\r\n"
				+ "where id = ?";
		Object[] params = new Object[] {name, intro, description1, description2, description3, advantage, endline, relativePath1, relativePath2, id};
		jdbcTemplate.update(sql, params);
		
	}


	public void adminEditServiceImage23(int id, String name, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath1, String relativePath2) {
		String sql = "UPDATE service\r\n"
				+ "SET name = ?, intro = ?, description1 = ?, description2 = ?, description3 = ?, "
				+ "advantage = ?, endline = ?, image2 = ?, image3 = ?\r\n"
				+ "where id = ?";
		Object[] params = new Object[] {name, intro, description1, description2, description3, advantage, endline, relativePath1, relativePath2, id};
		jdbcTemplate.update(sql, params);
		
	}


	public void adminEditServiceImage13(int id, String name, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath1, String relativePath2) {
		String sql = "UPDATE service\r\n"
				+ "SET name = ?, intro = ?, description1 = ?, description2 = ?, description3 = ?, "
				+ "advantage = ?, endline = ?, image1 = ?, image3 = ?\r\n"
				+ "where id = ?";
		Object[] params = new Object[] {name, intro, description1, description2, description3, advantage, endline, relativePath1, relativePath2, id};
		jdbcTemplate.update(sql, params);
		
	}


	public void adminEditService3Image(int id, String name, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath1, String relativePath2,
			String relativePath3) {
		String sql = "UPDATE service\r\n"
				+ "SET name = ?, intro = ?, description1 = ?, description2 = ?, description3 = ?, "
				+ "advantage = ?, endline = ?, image1 = ?, image2 = ?, image3 = ?\r\n"
				+ "where id = ?";
		Object[] params = new Object[] {name, intro, description1, description2, description3, advantage, endline, relativePath1, relativePath2, relativePath3, id};
		jdbcTemplate.update(sql, params);
		
	}


	public int getNewID() {
		String sql = "SELECT MAX(ID) FROM service";
		Integer newID = jdbcTemplate.queryForObject(sql, Integer.class);
		if (newID == null) {
			newID = 0;
		}
		return newID;
	}

	public void adminAddServiceImage1(int newID, String name, int idDepartment, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath) {
		String sql = "INSERT INTO service(id, name, ID_Department, intro, description1, description2, description3, advantage, endline, image1)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[] {newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath};
		jdbcTemplate.update(sql, params);
		
	}
	
	public void adminAddServiceImage2(int newID, String name, int idDepartment, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath) {
		String sql = "INSERT INTO service(id, name, ID_Department, intro, description1, description2, description3, advantage, endline, image2)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[] {newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath};
		jdbcTemplate.update(sql, params);
		
	}
	
	public void adminAddServiceImage3(int newID, String name, int idDepartment, String intro, String description1, String description2,
			String description3, String advantage, String endline, String relativePath) {
		String sql = "INSERT INTO service(id, name, ID_Department, intro, description1, description2, description3, advantage, endline, image3)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[] {newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath};
		jdbcTemplate.update(sql, params);
		
	}


	public void adminAddServiceImage12(int newID, String name, int idDepartment, String intro, String description1,
			String description2, String description3, String advantage, String endline, String relativePath1,
			String relativePath2) {
		String sql = "INSERT INTO service(id, name, ID_Department, intro, description1, description2, description3, advantage, endline, image1, image2)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[] {newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath1 , relativePath2};
		jdbcTemplate.update(sql, params);
		
	}
	
	public void adminAddServiceImage23(int newID, String name, int idDepartment, String intro, String description1,
			String description2, String description3, String advantage, String endline, String relativePath1,
			String relativePath2) {
		String sql = "INSERT INTO service(id, name, ID_Department, intro, description1, description2, description3, advantage, endline, image2, image3)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[] {newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath1 , relativePath2};
		jdbcTemplate.update(sql, params);
		
	}
	
	public void adminAddServiceImage13(int newID, String name, int idDepartment, String intro, String description1,
			String description2, String description3, String advantage, String endline, String relativePath1,
			String relativePath2) {
		String sql = "INSERT INTO service(id, name, ID_Department, intro, description1, description2, description3, advantage, endline, image1, image3)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[] {newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath1 , relativePath2};
		jdbcTemplate.update(sql, params);
		
	}


	public void adminAddService3Image(int newID, String name, int idDepartment, String intro, String description1,
			String description2, String description3, String advantage, String endline, String relativePath1,
			String relativePath2, String relativePath3) {
		String sql = "INSERT INTO service(id, name, ID_Department, intro, description1, description2, description3, advantage, endline, image1, image2, image3)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[] {newID, name, idDepartment, intro, description1, description2, description3, advantage, endline, relativePath1 , relativePath2, relativePath3};
		jdbcTemplate.update(sql, params);
		
	}


	public void adminAddService(int newID, String name, int idDepartment, String intro, String description1,
			String description2, String description3, String advantage, String endline) {
		String sql = "INSERT INTO service(id, name, ID_Department, intro, description1, description2, description3, advantage, endline)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[] {newID, name, idDepartment, intro, description1, description2, description3, advantage, endline};
		jdbcTemplate.update(sql, params);
		
	}





}
