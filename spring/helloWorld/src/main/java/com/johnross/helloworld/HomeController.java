package com.johnross.helloworld;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {	
		session.setAttribute("name", "John");
		return "hello.jsp";
	}
	@RequestMapping("/welcome")
	public String hello(HttpSession session) {
		String userName = (String) session.getAttribute("name");
		System.out.println("this name is " + userName);
		return "welcome.jsp";
	}
	@RequestMapping("/goodbye")
	public String goodbye() {
		return "goodbye";
	}
	@RequestMapping("/createError")
	public String flashMessage(RedirectAttributes redirectAttributes) {		
		redirectAttributes.addFlashAttribute("error", "This is a test error!");
		return "redirect:/welcome";
	}
}
