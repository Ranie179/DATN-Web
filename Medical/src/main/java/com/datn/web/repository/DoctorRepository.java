package com.datn.web.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.datn.web.bean.Doctors;
import com.datn.web.bean.Positions;
import com.datn.web.bean.Departments;
import com.datn.web.bean.Graduate;
import com.datn.web.bean.Contracts;
@Repository
public class DoctorRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class DoctorRowMapper implements RowMapper<Doctors> {
        public Doctors mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Doctors doctor = new Doctors();
            doctor.setIdDoctor(rs.getInt("ID_Doctor"));
            doctor.setDoctorName(rs.getString("Doctor_Name"));
            Contracts contract = new Contracts();
            contract.setIdContract(rs.getInt("ID_Contract"));
            doctor.setContract(contract);
            doctor.setImageUrl(rs.getString("Image_URL"));
            doctor.setGender(rs.getString("Gender"));
            doctor.setBirthDay(rs.getDate("BirthDay"));
            Positions position = new Positions();
            position.setIdPosition(rs.getInt("ID_Position"));
            position.setPositionName(rs.getString("Position_Name"));
            doctor.setPosition(position);
            Departments department = new Departments();
            department.setIdDepartment(rs.getInt("ID_Department"));
            department.setDepartmentName(rs.getString("Department_Name"));
            doctor.setDepartment(department);
            doctor.setInformation(rs.getString("Information"));
            Graduate graduate = new Graduate();
            graduate.setGraduate(rs.getString("Graduate"));
            doctor.setGraduate(graduate);
            doctor.setExpYear(rs.getInt("EXP_YEARS"));
            doctor.setSalary(rs.getInt("Salary"));
            doctor.setIsWorking(rs.getString("isWorking"));
            doctor.setPhone(rs.getString("Phone"));
            return doctor;
        }
    }
	
	public List<Doctors> showAllDoctor(int page, int pageSize) {
		int offset = (page - 1) * pageSize;
		Object[] params = new Object[]{pageSize, offset};
		String sql = "select doc.*, gda.*, d.Department_Name, p.Position_Name\r\n"
				+ "from doctors as doc\r\n"
				+ "join positions as p ON doc.ID_Position = p.ID_Position\r\n"
				+ "join departments as d ON doc.ID_Department = d.ID_Department\r\n"
				+ "join graduate as gda ON doc.ID_Graduate = gda.ID_Graduate\r\n"
				+ "where doc.isWorking = \"Vẫn còn làm việc\"\r\n"
				+ "LIMIT ? OFFSET ?";
		return jdbcTemplate.query(sql, params, new DoctorRowMapper());
	}
	
	public List<Doctors> showAllDoctor(int page, int pageSize, String search) {
		int offset = (page - 1) * pageSize;
		Object[] params = new Object[]{"%" + search + "%", pageSize, offset};
		String sql = "select doc.*, gda.*, d.Department_Name, p.Position_Name\r\n"
				+ "FROM doctors AS doc\r\n"
				+ "JOIN positions AS p ON doc.ID_Position = p.ID_Position\r\n"
				+ "JOIN departments AS d ON doc.ID_Department = d.ID_Department\r\n"
				+ "join graduate as gda ON doc.ID_Graduate = gda.ID_Graduate\r\n"
				+ "WHERE doc.isWorking = \"Vẫn còn làm việc\" and UPPER(doc.Doctor_Name) LIKE UPPER(?) LIMIT ? OFFSET ?";
		return jdbcTemplate.query(sql, params, new DoctorRowMapper());
	}
	
	public List<Doctors> showDoctorInfo(int idDoctor) {
		String sql = "select doc.*, gda.*, d.Department_Name, p.Position_Name\r\n"
				+ "from doctors as doc \r\n"
				+ "join positions as p ON doc.ID_Position = p.ID_Position\r\n"
				+ "join departments as d ON doc.ID_Department = d.ID_Department\r\n"
				+ "join graduate as gda ON doc.ID_Graduate = gda.ID_Graduate\r\n"
				+ "where doc.ID_Doctor = ?";
		Object[] params = new Object[] {idDoctor};
		return jdbcTemplate.query(sql, params, new DoctorRowMapper());
	}

	public List<Doctors> doctorBonus(int idDepartment) {
		String sql = "select doc.*, gda.*, d.Department_Name, p.Position_Name\r\n"
				+ "from doctors as doc \r\n"
				+ "join positions as p ON doc.ID_Position = p.ID_Position\r\n"
				+ "join departments as d ON doc.ID_Department = d.ID_Department\r\n"
				+ "join graduate as gda ON doc.ID_Graduate = gda.ID_Graduate\r\n"
				+ "where doc.isWorking = \"Vẫn còn làm việc\" and d.ID_Department = ?\r\n"
				+ "LIMIT 3";
		Object[] params = new Object[] {idDepartment};
		return jdbcTemplate.query(sql, params, new DoctorRowMapper());
	}
	
	public int getTotalDoctorCount() {
		String sql = "SELECT COUNT(*) FROM doctors where isWorking = \"Vẫn còn làm việc\"";
	    return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public int getTotalDoctorCount(String search) {
		String sql = "SELECT COUNT(*) FROM doctors WHERE UPPER(Doctor_Name) LIKE UPPER(?) and isWorking = \"Vẫn còn làm việc\"";
	    Object[] params = new Object[]{"%" + search + "%"};
		return jdbcTemplate.queryForObject(sql, params, Integer.class);
	}

	public List<Doctors> showDoctorByExp(int page, int pageSize, Integer experience) {
		int offset = (page - 1) * pageSize;
		String sql = "";
		  switch (experience) {
		        case 1:
		            sql = "select doc.*, gda.*, d.Department_Name, p.Position_Name\r\n" +
		                  "FROM doctors AS doc " +
		                  "JOIN positions AS p ON doc.ID_Position = p.ID_Position " +
		                  "JOIN departments AS d ON doc.ID_Department = d.ID_Department " +
		                  "JOIN graduate as gda ON doc.ID_Graduate = gda.ID_Graduate\r\n" +
		                  "WHERE doc.isWorking = \"Vẫn còn làm việc\" and doc.EXP_YEARS < 1 LIMIT ? OFFSET ?";
		            break;
		        case 2:
		            sql = "select doc.*, gda.*, d.Department_Name, p.Position_Name\r\n" +
		                  "FROM doctors AS doc " +
		                  "JOIN positions AS p ON doc.ID_Position = p.ID_Position " +
		                  "JOIN departments AS d ON doc.ID_Department = d.ID_Department " +
		                  "JOIN graduate as gda ON doc.ID_Graduate = gda.ID_Graduate\r\n" +
		                  "WHERE doc.isWorking = \"Vẫn còn làm việc\" and doc.EXP_YEARS BETWEEN 1 AND 3 LIMIT ? OFFSET ?";
		            break;
		        case 3:
		            sql = "select doc.*, gda.*, d.Department_Name, p.Position_Name\r\n" +
		                  "FROM doctors AS doc " +
		                  "JOIN positions AS p ON doc.ID_Position = p.ID_Position " +
		                  "JOIN departments AS d ON doc.ID_Department = d.ID_Department " +
		                  "JOIN graduate as gda ON doc.ID_Graduate = gda.ID_Graduate\r\n" +
		                  "WHERE doc.isWorking = \"Vẫn còn làm việc\" and doc.EXP_YEARS BETWEEN 3 AND 7 LIMIT ? OFFSET ?";
		            break;
		        case 4:
		            sql = "select doc.*, gda.*, d.Department_Name, p.Position_Name\r\n" +
		                  "FROM doctors AS doc " +
		                  "JOIN positions AS p ON doc.ID_Position = p.ID_Position " +
		                  "JOIN departments AS d ON doc.ID_Department = d.ID_Department " +
		                  "JOIN graduate as gda ON doc.ID_Graduate = gda.ID_Graduate\r\n" +
		                  "WHERE doc.isWorking = \"Vẫn còn làm việc\" and doc.EXP_YEARS BETWEEN 7 AND 10 LIMIT ? OFFSET ?";
		            break;
		        case 5:
		            sql = "select doc.*, gda.*, d.Department_Name, p.Position_Name\r\n" +
		                  "FROM doctors AS doc " +
		                  "JOIN positions AS p ON doc.ID_Position = p.ID_Position " +
		                  "JOIN departments AS d ON doc.ID_Department = d.ID_Department " +
		                  "JOIN graduate as gda ON doc.ID_Graduate = gda.ID_Graduate\r\n" +
		                  "WHERE doc.isWorking = \"Vẫn còn làm việc\" and doc.EXP_YEARS > 10 LIMIT ? OFFSET ?";
		            break;
		    }
		  Object[] params = new Object[] {pageSize, offset };
			return jdbcTemplate.query(sql, params, new DoctorRowMapper());
	}

	public int getTotalDoctorByIdDepartment(int idDepartment) {
		String sql = "SELECT COUNT(*) FROM doctors WHERE isWorking = \"Vẫn còn làm việc\" and ID_Department = ?";
		Object[] params = new Object[] {idDepartment};
		return jdbcTemplate.queryForObject(sql, params, Integer.class);
	}

	public List<Doctors> showDoctorByIdDepartment(int page, int pageSize, Integer idDepartment) {
		int offset = (page - 1) * pageSize;
		String sql = "select doc.*, gda.*, d.Department_Name, p.Position_Name\r\n"
				+ "from doctors as doc\r\n"
				+ "join positions as p ON doc.ID_Position = p.ID_Position\r\n"
				+ "join departments as d ON doc.ID_Department = d.ID_Department\r\n"
				+ "join graduate as gda ON doc.ID_Graduate = gda.ID_Graduate\r\n"
				+ "where doc.isWorking = \"Vẫn còn làm việc\" and doc.ID_Department = ? LIMIT ? OFFSET ? ";
		Object[] params = new Object[] {idDepartment, pageSize, offset};
		return jdbcTemplate.query(sql, params, new DoctorRowMapper());
	}

	public int getTotalDoctorByExp(Integer experience) {
		String sql = "";
		switch (experience) {
        case 1:
            sql = "SELECT COUNT(*) FROM doctors where isWorking = \"Vẫn còn làm việc\" and EXP_YEARS < 1";
            break;
        case 2:
            sql = "SELECT COUNT(*) FROM doctors where isWorking = \"Vẫn còn làm việc\" and EXP_YEARS BETWEEN 1 AND 3";
            break;
        case 3:
            sql = "SELECT COUNT(*) FROM doctors where isWorking = \"Vẫn còn làm việc\" and EXP_YEARS BETWEEN 3 AND 7";
            break;
        case 4:
            sql = "SELECT COUNT(*) FROM doctors where isWorking = \"Vẫn còn làm việc\" and EXP_YEARS BETWEEN 7 AND 10";
            break;
        case 5:
            sql = "SELECT COUNT(*) FROM doctors where isWorking = \"Vẫn còn làm việc\" and EXP_YEARS > 10";
            break;
    }
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public List<Doctors> showExpDoctor() {
		String sql = "select doc.*, gda.*, d.Department_Name, p.Position_Name\r\n"
				+ "from doctors as doc\r\n"
				+ "join positions as p ON doc.ID_Position = p.ID_Position\r\n"
				+ "join departments as d ON doc.ID_Department = d.ID_Department\r\n"
				+ "join graduate as gda ON doc.ID_Graduate = gda.ID_Graduate\r\n"
				+ "where doc.isWorking = \"Vẫn còn làm việc\"\r\n"
				+ "ORDER BY EXP_YEARS DESC\r\n"
				+ "LIMIT 10";
		return jdbcTemplate.query(sql, new DoctorRowMapper());
	}

	public void adminEditDoctor(int id, int idDepartment,int idPosition, int experience, int salary, String information, String phone, String isWorking,
			String relativePath) {
		String sql = "UPDATE doctors\r\n"
				+ "SET ID_Department = ?, ID_Position = ?, EXP_YEARS = ?, salary = ?, Information = ?, phone = ?, isWorking = ?, Image_Url = ?\r\n"
				+ "WHERE ID_Doctor = ?";
		Object[] params = new Object[] {idDepartment, idPosition, experience, salary, information, phone, isWorking, relativePath, id};
		jdbcTemplate.update(sql, params);
		
	}

	public void addDoctor(String name, String gender, String phone, String birthDay, int idPosition, int idDepartment,
			int salary, int idGraduate, int newID) {
		String sql = "INSERT INTO Doctors(Doctor_Name, Gender, phone, BirthDay, ID_Position, ID_Department, salary, ID_Graduate, ID_Contract)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		Object[] params = new Object[] {name, gender, phone, birthDay, idPosition, idDepartment, salary, idGraduate, newID};
		jdbcTemplate.update(sql, params);
		
	}

	public void adminEditDoctorWithoutAvatar(int id, int idDepartment, int idPosition, int experience, int salary,
			String information, String phone, String isWorking) {
		String sql = "UPDATE doctors\r\n"
				+ "SET ID_Department = ?, ID_Position = ?, EXP_YEARS = ?, salary = ?, Information = ?, phone = ?, isWorking = ?\r\n"
				+ "WHERE ID_Doctor = ?";
		Object[] params = new Object[] {idDepartment, idPosition, experience, salary, information, phone, isWorking, id};
		jdbcTemplate.update(sql, params);
		
	}

	public void adminDeleteDoctor(int id) {
		String sql = "UPDATE doctors\r\n"
				+ "SET isWorking = \"Không còn làm việc nữa\"\r\n"
				+ "WHERE ID_Doctor = ?;";
		Object[] params = new Object[] {id};
		jdbcTemplate.update(sql, params);
		
	}

	public int adminGetCountDoctor() {
		String sql = "SELECT COUNT(*) FROM doctors where isWorking = \"Không còn làm việc nữa\" ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public List<Doctors> adminShowDeletedDoctor(int page, int pageSize) {
		int offset = (page - 1) * pageSize;
		Object[] params = new Object[]{pageSize, offset};
		String sql = "select doc.*, gda.*, d.Department_Name, p.Position_Name\r\n"
				+ "from doctors as doc\r\n"
				+ "join positions as p ON doc.ID_Position = p.ID_Position\r\n"
				+ "join departments as d ON doc.ID_Department = d.ID_Department\r\n"
				+ "join graduate as gda ON doc.ID_Graduate = gda.ID_Graduate\r\n"
				+ "where doc.isWorking = \"Không còn làm việc nữa\"\r\n"
				+ "LIMIT ? OFFSET ?";
		return jdbcTemplate.query(sql,params, new DoctorRowMapper());
	}


	


}
