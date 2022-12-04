package com.stack_java.dojosandninjas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stack_java.dojosandninjas.models.Dojo;
import com.stack_java.dojosandninjas.models.Ninja;
import com.stack_java.dojosandninjas.services.DojoService;
import com.stack_java.dojosandninjas.services.NinjaService;

@Controller
public class MainController {
	
	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("/")
	public String index(
			@ModelAttribute("dojo") Dojo dojo
			) {
		return "index.jsp";
	}
	
	@PostMapping("/dojo/create/success")
	public String createDojo(
			@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		dojoService.createDojo(dojo);
		
		return "redirect:/";
	}
	
	@GetMapping("/ninja/create")
	public String showCreateNinja(
			@ModelAttribute("ninja") Ninja ninja,
			Model model
			) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos", allDojos);
		
		return "newNinja.jsp";
	}
	
	@RequestMapping("/ninja/create/success")
	public String createNinja(
			@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		}
		ninjaService.createNinja(ninja);
		
		return String.format("redirect:/dojo/%s", ninja.getDojo().getId());
	}
	
	@GetMapping("/dojo/{id}")
	public String showDojo(
			@PathVariable("id") Long id,
			Model model
			) {
		model.addAttribute("oneDojo", dojoService.findDojo(id));
		
		return "showDojo.jsp";
	}
}
