package com.johnross.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class HomeController {
	@RequestMapping("/{place}/{city}")
	public String daikichi(@PathVariable("place") String place, @PathVariable("city") String city) {
		return "Congratulations! You will soon travel to " + city;
	}
	@RequestMapping("/lotto/{num}")
	public String daikichi(@PathVariable("num") int num) {
		if(num % 2 == 0) {
			return "You will take a grand journey in the future, but be weary of tempting offers.";
		} else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend with family and friends.";
		}
	}
}
