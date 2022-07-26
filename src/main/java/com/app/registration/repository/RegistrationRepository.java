package com.app.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.registration.model.User;

@Repository
public interface RegistrationRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	User findByEmailAndPassword(String email, String password);

}
