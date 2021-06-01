package com.evan.show.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evan.show.models.Book;
import com.evan.show.services.BookService;

@RestController
public class BooksApi {
	private BookService bookService;
	
	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	@RequestMapping("/api/books")
	public List<Book> index() {
		return this.bookService.getAllBooks();
	}
	
	@RequestMapping(value="/api/books", method=RequestMethod.POST)
	public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String description, @RequestParam(value="language") String language, @RequestParam(value="pages") Integer numOfPages) {
		Book book = new Book(title, description, language, numOfPages);
		return bookService.createBook(book);
	}
	
	@RequestMapping("/api/books/{id")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}

}
