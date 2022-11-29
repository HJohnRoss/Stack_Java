package com.johnross.helloworld;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
