package com.stack_java.relationships.controllers;

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

import com.stack_java.relationships.models.License;
import com.stack_java.relationships.models.Person;
import com.stack_java.relationships.services.LicenseService;
import com.stack_java.relationships.services.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@Autowired
	LicenseService licenseService;
	
	@GetMapping("/")
	public String showCreatePerson(
			@ModelAttribute("person") Person person
			) {
		return "newPerson.jsp";
	}
	
	@PostMapping("/person/create")
	public String createPerson(
			@Valid @ModelAttribute("person") Person person,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "newPerson.jsp";
		}
		
		personService.createPerson(person);
		
		return "redirect:/license";
	}
	
	@GetMapping("/persons/{person_id}")
	public String showPerson(
			@PathVariable Long person_id,
			Model model
			) {
		Person person = personService.findById(person_id);
		model.addAttribute("person", person);
		
		return "showPerson.jsp";
	}
	
	@GetMapping("/license")
	public String showlicense(
			@ModelAttribute("license") License license,
			Model model
			) {
		
		List<Person> allPersons = personService.allPersons();
		model.addAttribute("persons", allPersons);
		return "newLicense.jsp";
	}
	
	@PostMapping("/licenses")
	public String licenses(@Valid @ModelAttribute("license") License license) {
	    // error handling with binding result omitted    
	    licenseService.createLicense(license); // Already has the person!
	        
	    return "redirect:/";
	}
}
