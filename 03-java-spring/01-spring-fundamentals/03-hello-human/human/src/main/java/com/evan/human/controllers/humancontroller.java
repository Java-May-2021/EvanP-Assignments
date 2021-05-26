package com.evan.human.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class humancontroller {
	@RequestMapping("/")
	public String index(Model mode, @RequestParam(value="name", required=false, defaultValue="Human")String name, Model model) {
		model.addAttribute("name", name);
		return "index.jsp";
	}

}
