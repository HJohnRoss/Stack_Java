package com.johnross.helloworld.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/show")
	public String show() {
		return "show.jsp";
	}
	@RequestMapping("/show/submit")
	public String add(
			@RequestParam("num") int num,
			@RequestParam("city") String city,
			@RequestParam("name") String name,
			@RequestParam("hobby") String hobby,
			@RequestParam("living") String living,
			@RequestParam("nice") String nice,
			HttpSession session
			){
		session.setAttribute("num", num);
		session.setAttribute("city", city);
		session.setAttribute("name",  name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("living", living);
		session.setAttribute("nice", nice);
		return "redirect:/show";
	}
}
