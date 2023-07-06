package com.datn.web.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.datn.web.bean.Graduate;

@Repository
public class GraduateRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class GraduateRowMapper implements RowMapper<Graduate> {
        public Graduate mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Graduate graduate = new Graduate();
        	graduate.setIdGraduate(rs.getInt("ID_Graduate"));
        	graduate.setGraduate(rs.getString("Graduate"));
        	return graduate;
        }
	}
    
	public List<Graduate> showAllGraduate() {
		String sql = "SELECT * FROM Graduate";
		return jdbcTemplate.query(sql, new GraduateRowMapper());
	}

}
