package com.oned.blogs.service;

import java.util.List;

import com.oned.blogs.model.Blog;

public interface BlogService {
	
	//GET operation
	List<Blog> getAllBlogs();
	
	Blog getBlogById(Long id);
	
	//POST operation
	Blog createBlog(Blog Blog);
	
	//PUT operation
	Blog updateBlog(Blog Blog, Long id);
	
	//Delete operation
	void deleteBlog(Long id);


}
