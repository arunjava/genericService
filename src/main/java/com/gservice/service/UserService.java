package com.gservice.service;

import com.gservice.entity.User;

public interface UserService {

	public User findUserById(long userId);
	
	public User saveUser(User user);
	
}
