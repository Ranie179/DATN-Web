package com.datn.web.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.datn.web.bean.Positions;

@Repository
public class PositionRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class PositionRowMapper implements RowMapper<Positions> {
        public Positions mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Positions position = new Positions();
        	position.setIdPosition(rs.getInt("ID_Position"));
        	position.setPositionName(rs.getString("Position_Name"));
        	return position;
        }
    }
	public List<Positions> showAllPosition() {
		String sql = "SELECT * FROM positions";
		return jdbcTemplate.query(sql, new PositionRowMapper());
	}

}
