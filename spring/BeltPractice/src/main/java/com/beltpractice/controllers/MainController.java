package com.beltpractice.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.beltpractice.models.Sighting;
import com.beltpractice.models.User;
import com.beltpractice.models.UserLogin;
import com.beltpractice.services.SightingService;
import com.beltpractice.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	SightingService sightingService;
	
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
		
		model.addAttribute("allSightings", sightingService.getAll());
		return "dashboard.jsp";
	}
	
	@GetMapping("/create/sighting")
	public String createSighting(Model model, HttpSession session) {
		model.addAttribute("userId", session.getAttribute("userId"));
		model.addAttribute("userName", session.getAttribute("userName"));
		
		if(session.getAttribute("userId") == null) return "redirect:/";
		
		model.addAttribute("sighting", new Sighting());
		return "createSighting.jsp";
	}
	
	@PostMapping("/sighting/create/success")
	public String createProjectSuccess(@Valid @ModelAttribute("sighting") Sighting sighting, BindingResult result, HttpSession session, Model model) {
		model.addAttribute("userId", session.getAttribute("userId"));
		model.addAttribute("userName", session.getAttribute("userName"));
		
		if(session.getAttribute("userId") == null) return "redirect:/";
		
		if(result.hasErrors()) {
			model.addAttribute("sighting", sighting);
			return "createSighting.jsp";
		}
		
		sightingService.save(sighting);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/sighting/edit/{id}")
	public String editProject(@PathVariable("id") Long id, Model model, HttpSession session) {
		
		if (!session.getAttribute("userId").equals(sightingService.getOne(id).getUser().getId())) {
			return "redirect:/";
		}
		
		model.addAttribute("oneSighting", sightingService.getOne(id));
		return "editSighting.jsp";
	}
	
	@PutMapping("/sighting/edit/{id}/success")
	public String editProjectSuccess(@Valid @ModelAttribute("oneSighting") Sighting sighting, BindingResult result, @PathVariable("id") Long id, HttpSession session, Model model) {
		
		if (!session.getAttribute("userId").equals(sightingService.getOne(id).getUser().getId())) {
			return "redirect:/dashboard";
		}
		
		if (result.hasErrors()) {
			model.addAttribute("oneSighting", sighting);
			return "editSighting.jsp";
		}
		sightingService.save(sighting);
		return "redirect:/";
	}
	
	@GetMapping("/sighting/show/{id}")
	public String showProject(@PathVariable("id") Long id, Model model, HttpSession session) {
		model.addAttribute("userId", session.getAttribute("userId"));
		model.addAttribute("userName", session.getAttribute("userName"));
		
		if(session.getAttribute("userId") == null) return "redirect:/";
		
		model.addAttribute("loggedUser", userService.getOne(session.getAttribute("userId")));
		model.addAttribute("oneSighting", sightingService.getOne(id));
		return "oneSighting.jsp";
	}
	
	@PutMapping("/skeptic/add/{id}")
	public String joinTeam(@PathVariable("id") Long sightingId, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) return "redirect:/";
		
		userService.addSkeptik(sightingId, session.getAttribute("userId"));
		return "redirect:/sighting/show/{id}";
	}

	@PutMapping("/skeptic/remove/{id}")
	public String leaveTeam(@PathVariable("id") Long sightingId, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) return "redirect:/";
		
		userService.removeSkeptik(sightingId, session.getAttribute("userId"));
		return "redirect:/sighting/show/{id}";
	}
	
	@DeleteMapping("/sighting/delete/{id}")
	public String deleteProject(@Valid @ModelAttribute("oneSighting") Sighting sighting, BindingResult result, @PathVariable("id") Long id, HttpSession session, Model model) {
		
		if (!session.getAttribute("userId").equals(sightingService.getOne(id).getUser().getId())) {
			return "redirect:/dashboard";
		}
		
		sightingService.deleteSighting(sighting);
		return "redirect:/dashboard";
	}
}
