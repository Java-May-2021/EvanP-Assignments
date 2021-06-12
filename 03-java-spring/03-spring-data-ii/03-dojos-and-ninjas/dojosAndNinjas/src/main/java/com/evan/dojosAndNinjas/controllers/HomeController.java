package com.evan.dojosAndNinjas.controllers;

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

import com.evan.dojosAndNinjas.models.Dojo;
import com.evan.dojosAndNinjas.models.Ninja;
import com.evan.dojosAndNinjas.services.DojoService;
import com.evan.dojosAndNinjas.services.NinjaService;

@Controller
public class HomeController {
	@Autowired
	private DojoService dService;
	@Autowired
	private NinjaService nService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newdojo.jsp";
	}
	@PostMapping(value="/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newdojo.jsp";
		}else {
			this.dService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja")Ninja ninja, Model model) {
		List<Dojo> allDojos = dService.getAll();
		model.addAttribute("allDojos", allDojos);
		return "newninja.jsp";
	}
	
	@PostMapping(value="/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, @ModelAttribute("dojo") Dojo dojo) {
		if(result.hasErrors()) {
			return "newninja.jsp";
		}else {
			this.nService.createNinja(ninja);
			return "redirect:/dojos/" +dojo.getId();
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dService.getSingleDojo(id);
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninja", dojo.getNinja());
		return "showlocation.jsp";
	}
}
