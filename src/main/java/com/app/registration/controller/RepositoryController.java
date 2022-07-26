package com.app.registration.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.User;
import com.app.registration.service.RegistrationService;

@RestController
public class RepositoryController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping("/register")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmail=user.getEmail();
		if(tempEmail!=null && !"".equals(tempEmail)) {
			User userObj = registrationService.fetchUserByEmail(tempEmail);
			if(userObj != null) {
				throw new Exception("user with "+tempEmail+" is already exists.");
			}
		}
		User obj=null;
		obj=registrationService.saveUser(user);
		return obj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String email=user.getEmail();
		String pass=user.getPassword();
		User userObj=null;
		if(email!=null && pass!=null) {
			userObj=registrationService.fetchUserByEmailAndPassword(email, pass);
		}
		if(userObj ==null) {
			throw new Exception("Bas Credentials");
		}
		return userObj;
				
	}
	
	
	

}
