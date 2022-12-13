package com.beltpractice.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.beltpractice.models.Sighting;
import com.beltpractice.models.User;
import com.beltpractice.models.UserLogin;
import com.beltpractice.repositories.SightingRepository;
import com.beltpractice.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SightingRepository sightingRepository;
	
	public User register(User newUser, BindingResult result) {
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "passwords don't match");
		}
		Optional<User> userObject = userRepository.findByEmail(newUser.getEmail());
		if(userObject.isPresent()) {
			result.rejectValue("email", "Unique", "email is taken");
		}
		if(result.hasErrors()) {
			return null;
		}
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepository.save(newUser);
	}
	
	public User login(UserLogin newLogin, BindingResult result) {
		Optional<User> userObject = userRepository.findByEmail(newLogin.getEmail());
		if(!userObject.isPresent()) {
			result.rejectValue("email", "Matches", "Invalid username/password");
			return null;
		}
		User user = userObject.get();
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Unique", "Invalid username/password");
		}
		if(result.hasErrors()) {
			return null;
		}
		return user;
	}
	
	public User getOne(Object idObject) {
		Optional<User> user = userRepository.findById((Long) idObject);
		return user.get();
	}

	public User addSkeptik(Long sightingId, Object userId) {
		Sighting project = sightingRepository.findById((Long) sightingId).get();
		User user = userRepository.findById((Long) userId).get();
		user.getSkeptics().add(project);
		userRepository.save(user);
		return user;
	}

	public User removeSkeptik(Long sightingId, Object userId) {
		Sighting project = sightingRepository.findById((Long) sightingId).get();
		User user = userRepository.findById((Long) userId).get();
		user.getSkeptics().remove(project);
		userRepository.save(user);
		return user;
	}
}