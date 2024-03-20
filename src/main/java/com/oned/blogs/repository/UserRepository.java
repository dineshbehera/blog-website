package com.oned.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oned.blogs.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}


