package com.datn.web.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.datn.web.bean.Tags;

@Repository
public class TagRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private class TagRowMapper implements RowMapper<Tags> {
        public Tags mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Tags tag = new Tags();
        	tag.setIdTag(rs.getInt("ID_Tag"));
        	tag.setTag(rs.getString("Tag"));
        	tag.setNumOfPosts(rs.getInt("NumOfPosts"));
        	return tag;
        	}
        
	}
	public List<Tags> showTags() {
		String sql = "SELECT Tags.ID_Tag, Tags.Tag, COUNT(Blogs.ID_Blog) "
				+ "as NumOfPosts FROM Tags LEFT JOIN Blogs "
				+ "ON Tags.ID_Tag = Blogs.ID_Tag GROUP BY Tags.Tag;";
		return jdbcTemplate.query(sql, new TagRowMapper());
	}
}
