package com.evan.controllersAndViews.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.evan.controllersAndViews.models.User;
import com.evan.controllersAndViews.services.UserService;
import com.evan.controllersAndViews.validators.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;

	@GetMapping("/")
	public String index() {
		return "redirect:/login";
	}
	
	@GetMapping("/register")
	public String registration(@ModelAttribute("user") User user) {
	    return "registration.jsp";
	}
	
	@GetMapping("/login")
	public String login() {
	    return "login.jsp";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			return "registration.jsp";
		}else {
			User newUser = uService.registerUser(user);
			session.setAttribute("userId", newUser.getId());
			return "redirect:/home";
		}
	}
	 
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes att) {
	    if(uService.authenticateUser(email, password)) {
	    	User user = this.uService.findByEmail(email);
	    	session.setAttribute("userId", user.getId());
	    	return "redirect:/home";
	    }
	    att.addFlashAttribute("error", "Nice try bud!");
		return "redirect:/login";
	}
	 
	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		Long userId =(Long)session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/login";
		}else {
			User user =uService.findUserById(userId);
			model.addAttribute("user", user);			
			return "home.jsp";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}