package com.evan.dlicense.controllers;

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

import com.evan.dlicense.models.License;
import com.evan.dlicense.models.Person;
import com.evan.dlicense.services.LicenseService;
import com.evan.dlicense.services.PersonService;

@Controller
public class LicenseController {
	@Autowired
	private PersonService personService;
	@Autowired
	private LicenseService licenseService;
	

	@GetMapping("/")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "newperson.jsp";
	}
	
	@PostMapping(value="/persons/new")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "newperson.jsp";
		}else {
			this.personService.createPerson(person);
			return "redirect:/licenses";
		}
	}
	
	@GetMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> person = personService.findAll();
		model.addAttribute("persons", person);
		return "newlicense.jsp";		
	}
	
	@PostMapping(value="/licenses/new")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "newlicense.jsp";
		}else {
			this.licenseService.createLicense(license);
			return "redirect:/persons/" +license.getPerson().getId();
		}
	}
	
	@GetMapping("/persons/{id}")
	public String showLicense(@PathVariable("id") Long id, Model model) {
		Person person = this.personService.getSinglePerson(id);
		model.addAttribute("person", person);
		if(person.getLicense() != null) {
			License license = person.getLicense();
			model.addAttribute("license", license);
		}
		return "profilepage.jsp";
	}
}
