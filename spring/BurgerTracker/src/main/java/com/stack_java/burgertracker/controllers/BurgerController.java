package com.stack_java.burgertracker.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stack_java.burgertracker.models.Burger;
import com.stack_java.burgertracker.services.BurgerService;

@Controller
public class BurgerController {

	@Autowired
	BurgerService burgerService; // what is this exactly doing.
	
	@RequestMapping("/")
	public String index(
			@ModelAttribute("burger") Burger burger,
			Model model
			) {
			
		List<Burger> allBurgers = burgerService.allBurgers();
			
		model.addAttribute("allBurgers", allBurgers);
		
		return "index.jsp";
	}
	
	
	@PostMapping("/burger/create")
	public String addBurger(
			@Valid @ModelAttribute("burger") Burger burger,
			BindingResult result,
			RedirectAttributes redirectAttributes
			) {
		
		if(result.hasErrors()) {
			return "index.jsp";
		}
		
		burgerService.createBurger(burger);
		
		
		
		return "redirect:/";
	}
}
