package com.datn.web.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.datn.web.bean.Blogs;
import com.datn.web.bean.Tags;

@Repository
public class BlogRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private class BlogRowMapper implements RowMapper<Blogs> {
        public Blogs mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Blogs blog = new Blogs();
        	blog.setCreateDate(rs.getDate("Create_Date"));
        	blog.setIdBlog(rs.getInt("ID_Blog"));
        	blog.setImage1(rs.getString("Image1"));
        	blog.setImage2(rs.getString("Image2"));
        	blog.setImage3(rs.getString("Image3"));
        	blog.setIntro(rs.getString("Intro"));
        	blog.setParagraph1(rs.getString("Paragraph1"));
        	blog.setParagraph2(rs.getString("Paragraph2"));
        	blog.setParagraph3(rs.getString("Paragraph3"));
        	blog.setQuote(rs.getString("Quotation"));
        	blog.setTitle(rs.getString("Title"));
        	Tags tag = new Tags();
        	tag.setIdTag(rs.getInt("ID_Tag"));
        	tag.setTag(rs.getString("Tag"));
        	blog.setTag(tag);
        	return blog;
        }
	}

	public List<Blogs> showAllBlogs(int page, int pageSize) {
		int offset = (page - 1) * pageSize;
		String sql = "SELECT blogs.*, tags.Tag\r\n"
				+ "FROM blogs JOIN tags ON blogs.ID_Tag = tags.ID_Tag\r\n"
				+ "LIMIT ? OFFSET ?";
		Object[] params = new Object[] {pageSize, offset};
		return jdbcTemplate.query(sql, params, new BlogRowMapper());
	}

	public int getTotalBlogCount() {
		String sql = "SELECT COUNT(*) FROM blogs";
	    return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	//				+ "WHERE UPPER(blogs.Title) LIKE UPPER(?)\r\n"

	public List<Blogs> showBlogInfo(int idBlog) {
		String sql = "SELECT blogs.*, tags.Tag\r\n"
				+ "FROM blogs\r\n"
				+ "JOIN tags ON blogs.ID_Tag = tags.ID_Tag\r\n"
				+ "WHERE blogs.ID_Blog = ?";
		Object[] params = new Object[] {idBlog};
		return jdbcTemplate.query(sql, params, new BlogRowMapper());
	}

	public List<Blogs> getRecentBlog() {
		String sql = "SELECT blogs.*, tags.Tag\r\n"
				+ "FROM blogs JOIN tags ON blogs.ID_Tag = tags.ID_Tag\r\n"
				+ "ORDER BY Create_Date DESC\r\n"
				+ "LIMIT 5";
		return jdbcTemplate.query(sql, new BlogRowMapper());
	}

	public List<Blogs> showBlogByTag(int idTag) {
		String sql = "SELECT blogs.*, tags.Tag\r\n"
				+ "FROM blogs JOIN tags ON blogs.ID_Tag = tags.ID_Tag\r\n"
				+ "WHERE tags.ID_Tag = ?";
		Object[] params = new Object[] {idTag};
		return jdbcTemplate.query(sql, params, new BlogRowMapper());
	}

	public void adminDeleteBlog(int id) {
		String sql = "DELETE FROM BLOGS WHERE ID_BLOG = ?";
		Object[] params = new Object[] {id};
		jdbcTemplate.update(sql, params);
	}

	public void adminEditBlog(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, int id) {
		String sql = "UPDATE BLOGS\r\n"
				+ "SET title = ?, ID_TAG = ?, Intro = ?, Quotation = ?, Paragraph1 = ?, Paragraph2 =?, Paragraph3 = ?\r\n"
				+ "WHERE ID_BLOG = ?";
		Object[] params = new Object[] {name, idTag, intro, quote, para1, para2, para3, id};
		jdbcTemplate.update(sql, params);
		
	}

	public void adminEditBlogImage1(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath, int id) {
		String sql = "UPDATE BLOGS\r\n"
				+ "SET title = ?, ID_TAG = ?, Intro = ?, Quotation = ?, Paragraph1 = ?, Paragraph2 =?, Paragraph3 = ?, Image1 = ?\r\n"
				+ "WHERE ID_BLOG = ?";
		Object[] params = new Object[] {name, idTag, intro, quote, para1, para2, para3, relativePath, id};
		jdbcTemplate.update(sql, params);
	}
	
	public void adminEditBlogImage2(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath, int id) {
		String sql = "UPDATE BLOGS\r\n"
				+ "SET title = ?, ID_TAG = ?, Intro = ?, Quotation = ?, Paragraph1 = ?, Paragraph2 =?, Paragraph3 = ?, Image2 = ?\r\n"
				+ "WHERE ID_BLOG = ?";
		Object[] params = new Object[] {name, idTag, intro, quote, para1, para2, para3, relativePath, id};
		jdbcTemplate.update(sql, params);
	}
	
	public void adminEditBlogImage3(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath, int id) {
		String sql = "UPDATE BLOGS\r\n"
				+ "SET title = ?, ID_TAG = ?, Intro = ?, Quotation = ?, Paragraph1 = ?, Paragraph2 =?, Paragraph3 = ?, Image3 = ?\r\n"
				+ "WHERE ID_BLOG = ?";
		Object[] params = new Object[] {name, idTag, intro, quote, para1, para2, para3, relativePath, id};
		jdbcTemplate.update(sql, params);
	}
	
	public void adminEditBlogImage12(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath1, String relativePath2, int id) {
		String sql = "UPDATE BLOGS\r\n"
				+ "SET title = ?, ID_TAG = ?, Intro = ?, Quotation = ?, Paragraph1 = ?, Paragraph2 =?, Paragraph3 = ?, Image1 = ?, Image2 = ?\r\n"
				+ "WHERE ID_BLOG = ?";
		Object[] params = new Object[] {name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, id};
		jdbcTemplate.update(sql, params);
	}
	
	public void adminEditBlogImage23(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath1, String relativePath2, int id) {
		String sql = "UPDATE BLOGS\r\n"
				+ "SET title = ?, ID_TAG = ?, Intro = ?, Quotation = ?, Paragraph1 = ?, Paragraph2 =?, Paragraph3 = ?, Image2 = ?, Image3 = ?\r\n"
				+ "WHERE ID_BLOG = ?";
		Object[] params = new Object[] {name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, id};
		jdbcTemplate.update(sql, params);
	}
	
	public void adminEditBlogImage13(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath1, String relativePath2, int id) {
		String sql = "UPDATE BLOGS\r\n"
				+ "SET title = ?, ID_TAG = ?, Intro = ?, Quotation = ?, Paragraph1 = ?, Paragraph2 =?, Paragraph3 = ?, Image1 = ?, Image3 = ?\r\n"
				+ "WHERE ID_BLOG = ?";
		Object[] params = new Object[] {name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, id};
		jdbcTemplate.update(sql, params);
	}

	public void adminEditBlog3Image(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath1, String relativePath2, String relativePath3, int id) {
		String sql = "UPDATE BLOGS\r\n"
				+ "SET title = ?, ID_TAG = ?, Intro = ?, Quotation = ?, Paragraph1 = ?, Paragraph2 =?, Paragraph3 = ?, Image1 = ?,  Image2 = ?, Image3 = ?\r\n"
				+ "WHERE ID_BLOG = ?";
		Object[] params = new Object[] {name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, relativePath3, id};
		jdbcTemplate.update(sql, params);
	}

	public int getNewID() {
		String sql = "SELECT MAX(ID_Blog) from Blogs";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	Date currentDate = new Date(System.currentTimeMillis());
	public void adminAddBlogImg1(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath, int newID) {
		String sql = "INSERT INTO BLOGS(ID_Blog, Title, ID_TAG, Intro, Quotation, Paragraph1, Paragraph2, Paragraph3, Image1, Create_Date)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		Object[] params = new Object[] {newID, name, idTag, intro, quote, para1, para2, para3, relativePath, currentDate};
		jdbcTemplate.update(sql, params);
		
	}

	public void adminAddBlogImg2(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath, int newID) {
		String sql = "INSERT INTO BLOGS(ID_Blog, Title, ID_TAG, Intro, Quotation, Paragraph1, Paragraph2, Paragraph3, Image2, Create_Date)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		Object[] params = new Object[] {newID, name, idTag, intro, quote, para1, para2, para3, relativePath, currentDate};
		jdbcTemplate.update(sql, params);
		
	}

	public void adminAddBlogImg3(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath, int newID) {
		String sql = "INSERT INTO BLOGS(ID_Blog, Title, ID_TAG, Intro, Quotation, Paragraph1, Paragraph2, Paragraph3, Image3, Create_Date)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		Object[] params = new Object[] {newID, name, idTag, intro, quote, para1, para2, para3, relativePath, currentDate};
		jdbcTemplate.update(sql, params);
		
	}

	public void adminAddBlogImg12(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath1, String relativePath2, int newID) {
		String sql = "INSERT INTO BLOGS(ID_Blog, Title, ID_TAG, Intro, Quotation, Paragraph1, Paragraph2, Paragraph3, Image1, Image2, Create_Date)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		Object[] params = new Object[] {newID, name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, currentDate};
		jdbcTemplate.update(sql, params);
		
	}

	public void adminAddBlogImg23(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath1, String relativePath2, int newID) {
		String sql = "INSERT INTO BLOGS(ID_Blog, Title, ID_TAG, Intro, Quotation, Paragraph1, Paragraph2, Paragraph3, Image2, Image3, Create_Date)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		Object[] params = new Object[] {newID, name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, currentDate};
		jdbcTemplate.update(sql, params);
		
	}

	public void adminAddBlogImg13(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath1, String relativePath2, int newID) {
		String sql = "INSERT INTO BLOGS(ID_Blog, Title, ID_TAG, Intro, Quotation, Paragraph1, Paragraph2, Paragraph3, Image1, Image3, Create_Date)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		Object[] params = new Object[] {newID, name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, currentDate};
		jdbcTemplate.update(sql, params);
		
	}

	public void adminAddBlog3Img(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, String relativePath1, String relativePath2, String relativePath3, int newID) {
		String sql = "INSERT INTO BLOGS(ID_Blog, Title, ID_TAG, Intro, Quotation, Paragraph1, Paragraph2, Paragraph3, Image1, Image2, Image3, Create_Date)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		Object[] params = new Object[] {newID, name, idTag, intro, quote, para1, para2, para3, relativePath1, relativePath2, relativePath3, currentDate};
		jdbcTemplate.update(sql, params);
		
	}

	public void adminAddBlog(String name, int idTag, String intro, String quote, String para1, String para2,
			String para3, int newID) {
		String sql = "INSERT INTO BLOGS(ID_Blog, Title, ID_TAG, Intro, Quotation, Paragraph1, Paragraph2, Paragraph3, Create_Date)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		Object[] params = new Object[] {newID, name, idTag, intro, quote, para1, para2, para3, currentDate};
		jdbcTemplate.update(sql, params);
		
	}

	

}
