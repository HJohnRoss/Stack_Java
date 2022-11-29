package com.johnross.helloworld;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/your_server")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/your_server/counter")
	public String count(HttpSession session) {
		if(session.getAttribute("count") == null) {			
			session.setAttribute("count", 0);
		} else {		
			int count = (int) session.getAttribute("count");
			count++;
			System.out.println(count);
			session.setAttribute("count", count);
		}
		return "count.jsp";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session, HttpServletRequest request) {
		session.invalidate();
		return "redirect:/your_server/counter";
	}
	@RequestMapping("/by_two")
	public String inc(HttpSession session) {
		if(session.getAttribute("count") == null) {			
			session.setAttribute("count", 0);
		} else {		
			int count = (int) session.getAttribute("count");
			count++;
			System.out.println(count);
			session.setAttribute("count", count);
		}
		return "redirect:/your_server/counter";
	}
}
