package com.oned.blogs.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oned.blogs.model.Blog;
import com.oned.blogs.service.BlogService;

@RequestMapping("/blogs")
@RestController
public class BlogController {
	Logger LOGGER = LoggerFactory.getLogger(BlogController.class);

	@Autowired
	private BlogService blogService;

	@GetMapping({ "", "/" })
	public List<Blog> getBlogs() {
		LOGGER.info("request received GET getBlogs()");
		return blogService.getAllBlogs();
	}

	@GetMapping("/{id}")
	public Blog getBlogById(@PathVariable("id") long id) {
		LOGGER.info("request received GET getBlogById({})", id);
		return blogService.getBlogById(id);

	}

	@PostMapping({ "", "/" })
	public Blog createBlog(@RequestBody Blog blog) {
		LOGGER.info("request received createBlog({})", blog.toString());
		return blogService.createBlog(blog);
	}

	@DeleteMapping("/{id}")
	public String deleteBlog(@PathVariable("id") long id) {
		LOGGER.info("request received deleteBlog({})", id);
		return "Deleted Successfully";
	}

}
