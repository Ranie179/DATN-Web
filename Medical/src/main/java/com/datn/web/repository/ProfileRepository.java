package com.datn.web.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.datn.web.bean.Profile;

@Repository
public class ProfileRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class ProfileRowMapper implements RowMapper<Profile> {
        public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Profile profile = new Profile();
        	profile.setIdProfile(rs.getInt("ID_Profile"));
        	profile.setName(rs.getString("Name"));
        	profile.setPhone(rs.getString("Phone"));
        	profile.setEmail(rs.getString("Email"));
        	profile.setBirthDay(rs.getDate("Birth_Day"));
        	profile.setBlood(rs.getString("Blood"));
        	profile.setGender(rs.getString("Gender"));
        	profile.setCommune(rs.getString("Commune"));
        	profile.setDistrict(rs.getString("District"));
        	profile.setProvince(rs.getString("Province"));
        	return profile;
        }
    }
	public List<Profile> showProfile(String email) {
		String sql = "SELECT * From Profile WHERE EMAIL = ?";
		Object[] params = new Object[] {email};
		return jdbcTemplate.query(sql, params, new ProfileRowMapper());
	}
	public void editProfile(String name, String phone, String birthDay, String blood, String gender, String commune,
			String district, String province, String email) {
		String sql = "UPDATE Profile\r\n"
				+ "SET Name = ?, Phone = ?, Birth_Day = ?, Blood = ?, Gender = ?, Commune = ?, District = ?, Province = ?\r\n"
				+ "WHERE Email = ?";
		Object[] params = new Object[] {name, phone, birthDay, blood, gender, commune, district, province, email};
		jdbcTemplate.update(sql, params);
		
	}

}
