package com.gservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gservice.entity.User;
import com.gservice.repository.UserRepository;
import com.gservice.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User findUserById(long userId) {
		return userRepo.findById(3l).get();
	}
}
