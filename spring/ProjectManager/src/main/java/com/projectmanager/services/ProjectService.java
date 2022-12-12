package com.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectmanager.models.Project;
import com.projectmanager.models.User;
import com.projectmanager.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	
	public List<Project> getAll() {
		return projectRepository.findAll();
	}

	public Project save(Project project) {
		return projectRepository.save(project);
	}

	public Project getOne(Long id) {
		Optional<Project> project = projectRepository.findById((Long) id);
		if (project.isPresent()) return project.get();
		return null;
	}
// ================================= BLACK BELT =================================
	public List<Project> getAssignedUsers(User user) {
		return projectRepository.findAllByUsers(user);
	}
	
	public List<Project> getUnassignedUsers(User user) {
		return projectRepository.findByUsersNotContains(user);
	}
}
