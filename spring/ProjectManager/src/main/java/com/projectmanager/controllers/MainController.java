package com.projectmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.projectmanager.models.Project;
import com.projectmanager.models.Task;
import com.projectmanager.models.User;
import com.projectmanager.models.UserLogin;
import com.projectmanager.services.ProjectService;
import com.projectmanager.services.TaskService;
import com.projectmanager.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private TaskService taskService;
	
	
//	=============================== LOGIN REGISTER ===============================
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new UserLogin());
		
		if (session.getAttribute("userId") != null) return "redirect:/dashboard";
		return "index.jsp";
	}
	
//	register a user
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {
		User user = userService.register(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new UserLogin());
			return "index.jsp";
		}
		session.setAttribute("userId", user.getId());
		session.setAttribute("userName", user.getFirstName());
		return "redirect:/dashboard";
	}
	
//	login a user
	@PostMapping("/login")
	public String register(@Valid @ModelAttribute("newLogin") UserLogin newLogin, BindingResult result, Model model,
			HttpSession session) {
		User user = userService.login(newLogin, result);
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		session.setAttribute("userId", user.getId());
		session.setAttribute("userName", user.getFirstName());
		return "redirect:/dashboard";
	}
	
//	Logout
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
//	=============================== DASHBOARD ===============================
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		model.addAttribute("userId", session.getAttribute("userId"));
		model.addAttribute("userName", session.getAttribute("userName"));
		User user = userService.getOne(session.getAttribute("userId"));
		
		if(session.getAttribute("userId") == null) return "redirect:/";
		
		model.addAttribute("oneUser", userService.getOne(session.getAttribute("userId")));
//		!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! BLACK BELT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		model.addAttribute("unassignedProjects", projectService.getUnassignedUsers(user));
		model.addAttribute("assignedProjects", projectService.getAssignedUsers(user));
		return "dashboard.jsp";
	}
	
//	=============================== PROJECT ===============================
//	creating a project
	@GetMapping("/project/create")
	public String createProject(HttpSession session, Model model) {
		model.addAttribute("userId", session.getAttribute("userId"));
		model.addAttribute("userName", session.getAttribute("userName"));
		
		if(session.getAttribute("userId") == null) return "redirect:/";
		
		model.addAttribute("project", new Project());
		return "createProject.jsp";
	}
	
	@PostMapping("/project/create/success")
	public String createProjectSuccess(@Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session, Model model) {
		model.addAttribute("userId", session.getAttribute("userId"));
		model.addAttribute("userName", session.getAttribute("userName"));
		
		if(session.getAttribute("userId") == null) return "redirect:/";
		
		if(result.hasErrors()) {
			model.addAttribute("project", project);
			return "createProject.jsp";
		}
		
		Project oneProject = projectService.save(project);
		return "redirect:/project/show/" + oneProject.getId();
	}
	
//	show one project
	@GetMapping("/project/show/{id}")
	public String showProject(@PathVariable("id") Long id, Model model, HttpSession session) {
		model.addAttribute("userId", session.getAttribute("userId"));
		model.addAttribute("userName", session.getAttribute("userName"));
		
		if(session.getAttribute("userId") == null) return "redirect:/";
		
		model.addAttribute("oneProject", projectService.getOne(id));
		return "oneProject.jsp";
	}
	
//	edit a project
	@GetMapping("/project/edit/{id}")
	public String editProject(@PathVariable("id") Long id, Model model, HttpSession session) {
		
		if (!session.getAttribute("userId").equals(projectService.getOne(id).getUser().getId())) {
			return "redirect:/";
		}
		
		model.addAttribute("oneProject", projectService.getOne(id));
		return "editProject.jsp";
	}
	
	@PutMapping("/project/edit/{id}/success")
	public String editProjectSuccess(@Valid @ModelAttribute("oneProject") Project project, BindingResult result, @PathVariable("id") Long id, HttpSession session, Model model) {
		
		if (!session.getAttribute("userId").equals(projectService.getOne(id).getUser().getId())) {
			return "redirect:/";
		}
		
		if (result.hasErrors()) {
			model.addAttribute("oneProject", project);
			return "editProject.jsp";
		}
		return "redirect:/project/show/{id}";
	}
	
//	=============================== BLACK BELT ===============================
	@GetMapping("/team/join/{id}")
	public String joinTeam(@PathVariable("id") Long projectId, Model model, HttpSession session) {
		
//		if(session.getAttribute("userId") == null) return "redirect:/";
		
		userService.joinTeam(projectId, session.getAttribute("userId"));
		return "redirect:/dashboard";
	}
	
	@GetMapping("/team/leave/{id}")
	public String leaveTeam(@PathVariable("id") Long projectId, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) return "redirect:/";
		
		userService.leaveTeam(projectId, session.getAttribute("userId"));
		return "redirect:/dashboard";
	}
	
//	=============================== TASKS ===============================
	@GetMapping("/project/{id}/tasks")
	public String tasks(@PathVariable("id") Long projectId, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) return "redirect:/";
		
		model.addAttribute("oneProject", projectService.getOne(projectId));
		model.addAttribute("task", new Task());
		return "tasks.jsp";
	}
	
	@PostMapping("/project/{id}/tasks/success")
	public String createTask(@Valid @ModelAttribute("task") Task task, BindingResult result, @PathVariable("id") Long projectId, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) return "redirect:/";
		
		if(result.hasErrors()) {
			model.addAttribute("oneProject", projectService.getOne(projectId));
			model.addAttribute("task", task);
			return "task.jsp";
		}
		Task newTask = new Task(task.getName()); // why do i need this
		taskService.createTask(newTask, projectId, session.getAttribute("userId"));
		return "redirect:/project/{id}/tasks";
	}
}
