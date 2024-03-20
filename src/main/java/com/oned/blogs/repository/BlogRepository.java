package com.oned.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oned.blogs.model.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long>{

}


