package com.evan.dojoOverflow.controllers;

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

import com.evan.dojoOverflow.models.Answer;
import com.evan.dojoOverflow.models.Question;
import com.evan.dojoOverflow.models.Tag;
import com.evan.dojoOverflow.services.DojoOverflowService;

@Controller
public class DojoController {
	
	@Autowired
	private DojoOverflowService dService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/questions";
	}
	
	@GetMapping("/questions")
	public String questions(@ModelAttribute("question") Question question, @ModelAttribute("tags") Tag tags, Model model) {
		List<Question> allQuestions = this.dService.getAllQuestions();
		List<Tag> allTags = this.dService.getAllTags();
		model.addAttribute("allQuestions", allQuestions);
		model.addAttribute("allTags", allTags);				
		return "index.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "new.jsp";
	}
	
	@PostMapping("/questions/new")
	public String createQuestion(@Valid @ModelAttribute("newQuestion") Question question, BindingResult result, Tag tag, Model model) {
		if(result.hasErrors()) {
			return "new.jsp";
		}	
			this.dService.createQuestion(question);
			return "redirect:/questions";
	}
	
	@GetMapping("/questions/{id}")
	public String showQuestion(@PathVariable("id") Long id, @ModelAttribute("answer") Answer answer, Model model) {
		Long questionId = id;
		List<Answer> answers = this.dService.getAllAnswers();
		model.addAttribute("question", this.dService.getQuestion(questionId));
		model.addAttribute("allAnswers", this.dService.getAllAnswers());
		return "show.jsp";
	}
	@GetMapping("/questions/answers")
	public String showAnswers(@PathVariable("id") Long id, @ModelAttribute("answer") Answer answer) {
		return "show.jsp";
	}
	
	@PostMapping("/questions/{id}")
	public String createAnswers(@Valid @ModelAttribute("answer") Answer answer, BindingResult result, Model model, Long id) {
		if(result.hasErrors()) {
			return "show.jsp";
		} else {
			this.dService.addAnswer(answer);
			return "redirect:/questions/" + answer.getQuestion().getId();
		}
	}
}
