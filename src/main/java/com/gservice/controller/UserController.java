package com.gservice.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gservice.entity.User;
import com.gservice.entity.UserRole;
import com.gservice.service.UserService;

@RestController
@RequestMapping("/user/api/v1/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("{userId}")
	public User getUsers(@PathVariable long userId) {
		User user = userService.findUserById(3l);
		List<UserRole> roles = (List<UserRole>) user.getRoles();
		roles.add(new UserRole("ROLE_ADMIN"));
		user.setRoles(roles);
		userService.saveUser(user);
		
		return user;
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		userService.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/user/api/v1/")
				.buildAndExpand(user.getFirstName()).toUri();
		
//		new ResponseEntity<>(HttpStatus.CREATED);
		return ResponseEntity.created(location).build();
	}
}
