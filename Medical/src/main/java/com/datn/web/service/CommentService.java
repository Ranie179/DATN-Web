package com.datn.web.service;

import java.util.List;
import com.datn.web.bean.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datn.web.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;

	public void comment(String email, String comment, int id) {
		commentRepository.comment(email, comment, id);
	}
	
	public List<Comment> showComment(int id){
		return commentRepository.showComment(id);
	}

	public List<Comment> showRecentComment() {
		return commentRepository.showRecentComment();
	}

}
