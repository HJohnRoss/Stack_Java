package com.stack_java.languages.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stack_java.languages.models.Language;
import com.stack_java.languages.services.LanguageService;

@Controller
public class LanguageController {
	@Autowired
	LanguageService languageService;
	
	@RequestMapping("/")
	public String index(
			@ModelAttribute("language") Language language,
			Model model
			) {
		
		List<Language> allLanguages = languageService.allLanguages();
		
		model.addAttribute("allLanguages", allLanguages);
		return "index.jsp";
	}
	
	@PostMapping("/language/create")
	public String createLanguage(
			@Valid @ModelAttribute("language") Language language,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		
		languageService.createLanguage(language);
		
		return "redirect:/";
	}
	
	@GetMapping("/language/show/{id}")
	public String showLanguage(
			@PathVariable("id") Long id,
			Model model
			) {
		
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		
		return "showLanguage.jsp";
	}
	
	@RequestMapping("/language/edit/{id}")
	public String editLanguage(
			@PathVariable("id") Long id,
			Model model
			) {
		
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		
		return "editLanguage.jsp";
	}
	
	@RequestMapping(value="/language/update/{id}", method=RequestMethod.PUT)
	public String updateLanguage(
			@Valid @ModelAttribute("language") Language language,
			BindingResult result
			) {
		
		if(result.hasErrors()) {
			return "editLanguage.jsp";
		}
		
		languageService.createLanguage(language);
		
		return "redirect:/";
		
	}
	
	@DeleteMapping("/language/delete/{id}")
	public String deleteLanguage(
			@PathVariable("id") Long id
			) {
		languageService.deleteLanguage(id);
		return "redirect:/";
		
	}
}
