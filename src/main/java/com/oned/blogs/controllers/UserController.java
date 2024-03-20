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

import com.oned.blogs.model.User;
import com.oned.blogs.service.UserService;

@RequestMapping("/users")
@RestController
public class UserController {
	Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping({ "", "/" })
	public List<User> getUsers() {
		LOGGER.info("request received GET getUsers()");
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") long id) {
		LOGGER.info("request received GET getUserById({})", id);
		return userService.getUserById(id);

	}

	@PostMapping({ "", "/" })
	public User createUser(@RequestBody User user) {
		LOGGER.info("request received createUser({})", user.toString());
		return userService.createUser(user);
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") long id) {
		LOGGER.info("request received deleteUser({})", id);
		return "Deleted Successfully";
	}

}
