package com.projectmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectmanager.models.Project;
import com.projectmanager.models.Task;
import com.projectmanager.models.User;
import com.projectmanager.repositories.ProjectRepository;
import com.projectmanager.repositories.TaskRepository;
import com.projectmanager.repositories.UserRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired UserRepository userRepository;
	
	public void createTask(Task task, Long projectId, Object userId){
		Project project = projectRepository.findById((Long) projectId).get();
		User user = userRepository.findById((Long) userId).get();
		task.setProject(project);
		task.setCreator(user);
		taskRepository.save(task);
	}
}
