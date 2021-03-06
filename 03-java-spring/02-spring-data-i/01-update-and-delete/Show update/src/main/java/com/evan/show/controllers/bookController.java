package com.evan.show.controllers;

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

import com.evan.show.models.Book;
import com.evan.show.services.BookService;

@Controller
public class bookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public String books(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}
	@GetMapping("/books/{id}")
	public String findBookById(Model model, @PathVariable("id") int id) {
		Book newBook = this.bookService.getSingleBook(id);
		model.addAttribute("book", newBook);
		return "showBook.jsp";
	}
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "newBook.jsp";
	}
	@PostMapping("/books/new")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "newBook.jsp";
		}else {
			bookService.addBook(book);
			return "redirect:/books";
		}
	}
	@GetMapping("/books/edit/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book book = bookService.findBookByIndex(id);
		if (book != null) {
			model.addAttribute("book", book);
			return "editBook.jsp";
		}else {
			return "redirect:/books";
		}
	}
	@PostMapping("/books/edit/{id}")
	public String updateBook(@PathVariable("id") int id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "editBook.jsp";
		}else {
			this.bookService.updateBook(id, book);
			return "redirect:/books{id}";
		}
	}
	@GetMapping(value="/books/delete/{id}")
	public String destroyBook(@PathVariable("id") Long id) {
		this.bookService.destroyBook((long) id);
		return "redirect:/books";
	}
}
