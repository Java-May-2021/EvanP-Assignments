package com.Evan.Routing.contollers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dojo")
public class DojoController {
	public String index() {
		return "The dojo is awesome!";
	}
	@RequestMapping("/{city}")
	public String burbank(@PathVariable("city")String city) {
		if(city.equals("burbank")) {
			return "Burbank dojo is located in Southern California";
		}
		else if(city.equals("sanJose"));{
			return "San Jose dojo is the headquarters";
		}
	}
}
