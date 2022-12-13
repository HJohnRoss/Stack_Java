package com.boilerplate.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.boilerplate.models.User;
import com.boilerplate.models.UserLogin;
import com.boilerplate.services.UserService;

@Controller
public class MainController {

	@Autowired
	UserService userService;
	
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
	public String dashboard(Model model, HttpSession session) {
		model.addAttribute("userId", session.getAttribute("userId"));
		model.addAttribute("userName", session.getAttribute("userName"));
		
		if(session.getAttribute("userId") == null) return "redirect:/";
		
		
		return "dashboard.jsp";
	}
}
