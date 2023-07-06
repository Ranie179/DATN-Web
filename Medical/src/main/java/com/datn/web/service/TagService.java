package com.datn.web.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datn.web.bean.Tags;
import com.datn.web.repository.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tagRepository;
	
	public List<Tags> showTags() {
		return tagRepository.showTags();
		}

}
