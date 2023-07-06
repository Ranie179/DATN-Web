package com.datn.web.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.datn.web.bean.Degrees;
import com.datn.web.bean.Doctors;

@Repository
public class DegreeRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private class DegreeRowMapper implements RowMapper<Degrees> {
        public Degrees mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Degrees degree = new Degrees();
        	degree.setIdDegree(rs.getInt("ID_Degree"));
        	degree.setCollege(rs.getString("College"));
        	degree.setDegreeName(rs.getString("Degree_Name"));;
        	degree.setYear(rs.getString("Years"));
            return degree;
        }
    }
	
	public List<Degrees> showDegree(int idDoctor) {
		String sql = "SELECT d.ID_Degree, d.Degree_Name, d.College, d.Years\r\n"
				+ "FROM degrees d\r\n"
				+ "WHERE d.ID_Doctor = ?;\r\n";
		Object[] params = new Object[] {idDoctor};
		return jdbcTemplate.query(sql, params, new DegreeRowMapper());
	}

}
