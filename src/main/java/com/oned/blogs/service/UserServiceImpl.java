package com.oned.blogs.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oned.blogs.model.User;
import com.oned.blogs.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepo;

	@Override
	public List<User> getAllUsers() {
		LOGGER.info("request received GET UserServiceImpl/getAllUsers()" + (List<User>)userRepo.findAll());
		return (List<User>)userRepo.findAll();
	}

	@Override
	public User getUserById(Long id) {
		LOGGER.info("request received GET UserServiceImpl/getUserById()" + userRepo.findById(id).toString());

		Optional<User> u =  userRepo.findById(id);
		
		if (u.isPresent()) {
            return u.get();
        } else {
        	return null;
        }
	}

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User updateUser(User user, Long id) {
		User userdb = userRepo.findById(id).get();
		
		userdb.setFirstName(user.getFirstName());
		userdb.setLastName(user.getLastName());
		userdb.setUserName(user.getUserName());
		userdb.setPassword(user.getPassword());
		userdb.setDob(user.getDob());
		userdb.setJoiningDate(user.getJoiningDate());
		userdb.setPhone(user.getPhone());
		userdb.setEmail(user.getEmail());
		userdb.setActive(user.isActive());
		
		return userRepo.save(userdb);
	}

	@Override
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}

}
