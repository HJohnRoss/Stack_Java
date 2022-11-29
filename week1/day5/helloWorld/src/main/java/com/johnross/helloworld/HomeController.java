package com.johnross.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("greeting")
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "Hello User";
	}
	@RequestMapping("/hello")
	public String hello() {
		return "hello World";
	}
	@RequestMapping("/goodbye")
	public String goodbye() {
		return "goodbye";
	}
}
