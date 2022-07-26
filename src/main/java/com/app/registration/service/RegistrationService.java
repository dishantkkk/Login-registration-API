package com.app.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.model.User;
import com.app.registration.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	public User saveUser(User user) {
		return registrationRepository.save(user);
	}

	public User fetchUserByEmail(String email) {
		return registrationRepository.findByEmail(email);
	}
	
	public User fetchUserByEmailAndPassword(String email,String password) {
		return registrationRepository.findByEmailAndPassword(email,password);
	}
}
