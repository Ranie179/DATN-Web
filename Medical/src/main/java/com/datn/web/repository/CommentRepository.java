package com.datn.web.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.datn.web.bean.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class CommentRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private class CommentRowMapper implements RowMapper<Comment> {
        public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Comment comment = new Comment();
        	comment.setEmail(rs.getString("Email"));
        	comment.setComment(rs.getString("Comment"));
        	comment.setCreateDate(rs.getDate("Create_Date"));
        	return comment;
        }
    }
	Date currentDate = new Date();
	public void comment(String email, String comment, int id) {
		String sql = "INSERT INTO Comment (Email, Comment, ID_Service, Create_Date)\r\n"
				+ "VALUES (?, ?, ?, ?)";
		Object[] params = new Object[] {email, comment, id, currentDate};
		jdbcTemplate.update(sql, params);
	}
	
	public List<Comment> showComment(int id) {
		String sql = "SELECT * from comment where ID_Service = ?\r\n"
				+ "ORDER BY Create_Date DESC LIMIT 5";
		Object[] params = new Object[] {id};
		return jdbcTemplate.query(sql, params, new CommentRowMapper());
	}

	public List<Comment> showRecentComment() {
		String sql = "SELECT * from comment\r\n"
				+ "ORDER BY Create_Date DESC LIMIT 5";
		return jdbcTemplate.query(sql, new CommentRowMapper());
	}

}
