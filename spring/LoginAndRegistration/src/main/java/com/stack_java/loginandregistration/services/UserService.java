package com.stack_java.loginandregistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.stack_java.loginandregistration.models.User;
import com.stack_java.loginandregistration.models.UserLogin;
import com.stack_java.loginandregistration.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User register(User newUser, BindingResult result) {
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "passwords do not match");
		}
		Optional<User> userObject = userRepository.findByEmail(newUser.getEmail());
		if (userObject.isPresent()) {
			result.rejectValue("email", "Unique", "email already in use");
		}
		if (result.hasErrors()) {
			return null;
		}
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepository.save(newUser);
	}

	public User login(UserLogin newLoginObject, BindingResult result) {
		Optional<User> userObject = userRepository.findByEmail(newLoginObject.getEmail());
		if (!userObject.isPresent()) {
			result.rejectValue("email", "Matches", "Invalid username/password");
			return null;
		}
		User user = userObject.get();
		if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Unique", "Invalid username/password");
		}
		if (result.hasErrors()) {
			return null;
		}
		return user;
	}
	
	public User oneUser(Object object) {
		Optional<User> user = userRepository.findById((Long) object);
		return user.get();
	}
}
