package com.evan.beltReview.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.evan.beltReview.models.User;
import com.evan.beltReview.models.Wedding;
import com.evan.beltReview.services.UserService;
import com.evan.beltReview.services.WeddingService;
import com.evan.beltReview.validators.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private UserService uService;
	@Autowired
	private WeddingService wService;
	@Autowired
	private UserValidator validator;
	
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	
	@PostMapping(value="/")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			User newUser = uService.registerUser(user);
			session.setAttribute("user_id", newUser.getId());
			return "redirect:/weddings";
		}
	}
	 
	@PostMapping(value="/login")
	public String authenticateUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes att) {
	    if(uService.authenticateUser(email, password)) {
	    	User user = this.uService.findByEmail(email);
	    	session.setAttribute("user_id", user.getId());
	    	return "redirect:/weddings";
	    }
	    att.addFlashAttribute("error", "Nice try bud!");
		return "redirect:/";
	}
	 
	@GetMapping("/weddings")
	public String dashboard(Model viewModel, HttpSession session) {
		viewModel.addAttribute("allWeddings", this.wService.getAllWeddings());
		viewModel.addAttribute("user", this.uService.findSingleUser((Long)session.getAttribute("user_id")));
		return "weddings.jsp";
	}
	
	@GetMapping("/new")
	public String addWedding(@ModelAttribute("wedding") Wedding wedding, HttpSession session, Model viewModel) {
		viewModel.addAttribute("user_id", session.getAttribute("user_id"));
		return "add.jsp";		
	}
	
	@PostMapping("/weddings/new")
	public String newWedding(@Valid @ModelAttribute("wedding") Wedding wedding, BindingResult result, HttpSession session, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("user_id", session.getAttribute("user_id"));
			return "add.jsp";			
		}
		this.wService.createWedding(wedding);
		return "redirect:/weddings";
	}
	
	@GetMapping("/rsvp/{id}")
	public String rsvp(@PathVariable("id") Long id, HttpSession session) {
		Wedding weddingToRSVP = this.wService.getOneWedding(id);
		Long userId = (Long)session.getAttribute("user_id");
		User userToAttend = this.uService.findSingleUser(userId);
		this.wService.RSVP(userToAttend, weddingToRSVP);
		return "redirect:/weddings";
	}
	
	@GetMapping("/unrsvp/{id}")
	public String unrsvp(@PathVariable("id") Long id, HttpSession session) {
		Wedding weddingToRSVP = this.wService.getOneWedding(id);
		Long userId = (Long)session.getAttribute("user_id");
		User userToAttend = this.uService.findSingleUser(userId);
		this.wService.UnRSVP(userToAttend, weddingToRSVP);
		return "redirect:/weddings";
	}
	
	
	
	@GetMapping("/delete")
	public String deleteWedding(@PathVariable("id") Long id) {
		this.wService.deleteWedding(id);
		return "redirect:/weddings";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	     // invalidate session
		session.invalidate();
	     // redirect to login page
		return "redirect:/";
	}
}
