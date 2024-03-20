package com.oned.blogs.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oned.blogs.model.Blog;
import com.oned.blogs.repository.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {
	Logger LOGGER = LoggerFactory.getLogger(BlogServiceImpl.class);

	@Autowired
	BlogRepository blogRepo;

	@Override
	public List<Blog> getAllBlogs() {
		LOGGER.info("request received GET BlogServiceImpl/getAllBlogs()" + (List<Blog>) blogRepo.findAll());
		return (List<Blog>) blogRepo.findAll();
	}

	@Override
	public Blog getBlogById(Long id) {
		LOGGER.info("request received GET BlogServiceImpl/getBlogById()" + blogRepo.findById(id).toString());

		Optional<Blog> b = blogRepo.findById(id);

		if (b.isPresent()) {
			return b.get();
		} else {
			return null;
		}
	}

	@Override
	public Blog createBlog(Blog user) {
		return blogRepo.save(user);
	}

	@Override
	public Blog updateBlog(Blog user, Long id) {
		Blog blogdb = blogRepo.findById(id).get();

		blogdb.setTitle(user.getTitle());
		blogdb.setType(user.getType());
		blogdb.setName(user.getSubTitle());
		blogdb.setContent(user.getContent());
		blogdb.setPicture(user.getPicture());
		blogdb.setCreateDate(user.getCreateDate());
		blogdb.setUpdateDate(user.getUpdateDate());
		blogdb.setAuthor(user.getAuthor());
		blogdb.setActive(user.isActive());

		return blogRepo.save(blogdb);
	}

	@Override
	public void deleteBlog(Long id) {
		blogRepo.deleteById(id);
	}

}
