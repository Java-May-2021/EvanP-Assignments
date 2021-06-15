package com.evan.license.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.evan.license.models.License;
import com.evan.license.models.Person;
import com.evan.license.services.LicenseService;
import com.evan.license.services.PersonService;

@Controller
public class LicenseController {
	@Autowired
	private PersonService pService;
	@Autowired
	private LicenseService lService;
	

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("persons", this.pService.findAll());		
		return "index.jsp";
	}
	
	@GetMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "new.jsp";
	}
	
	@PostMapping(value="/persons/new")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}else {
			this.pService.createPerson(person);
			return "redirect:/";
		}
	}
	
	@GetMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		model.addAttribute("unlicensed", this.pService.getUnlicensedPeople());
		return "newlicense.jsp";		
	}
	
	@PostMapping(value="/licenses/new")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("unlicensed", this.pService.getUnlicensedPeople());
			return "newlicense.jsp";
		}else {
			this.lService.createLicense(license);
			return "redirect:/";
		}
	}
	
	@GetMapping("/persons/{id}")
	public String showLicense(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", this.pService.getSinglePerson(id));
		return "show.jsp";
	}
}

