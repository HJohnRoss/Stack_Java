package com.projectmanager.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.projectmanager.models.Project;
import com.projectmanager.models.User;
import com.projectmanager.models.UserLogin;
import com.projectmanager.repositories.ProjectRepository;
import com.projectmanager.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
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
	
//	============================ BLACK BELT ============================
//	add to database
	public User joinTeam(Long projectId, Object userId) {
		Project project = projectRepository.findById((Long) projectId).get();
		User user = userRepository.findById((Long) userId).get();
		user.getTeams().add(project);
		userRepository.save(user);
		return user;
	}
	
//	remove from database
	public User leaveTeam(Long projectId, Object userId) {
		Project project = projectRepository.findById((Long) projectId).get();
		User user = userRepository.findById((Long) userId).get();
		user.getTeams().remove(project);
		userRepository.save(user);
		return user;
	}
}
