package com.oned.blogs.service;

import java.util.List;

import com.oned.blogs.model.User;

public interface UserService {
	
	//GET operation
	List<User> getAllUsers();
	
	User getUserById(Long id);
	
	//POST operation
	User createUser(User user);
	
	//PUT operation
	User updateUser(User user, Long id);
	
	//Delete operation
	void deleteUser(Long id);

}
