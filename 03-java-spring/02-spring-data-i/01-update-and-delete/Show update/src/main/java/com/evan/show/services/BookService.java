package com.evan.show.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evan.show.models.Book;
import com.evan.show.repositories.BookRepository;

@Service
public class BookService {
	
	private List<Book> books = new ArrayList<Book>(Arrays.asList(
		new Book("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "english", 309),
		new Book("The Great Gatsby", "The story primarily concers the young and mysterious millionaire Jay Gatsby", "english", 180),
		new Book("Moby Dick", "The saga of Captian Ahab", "english", 544),
		new Book("Don Quixote", "Life of a retired country gentleman", "english", 150),
		new Book("The Odyssey", "Ancient Greek epic poem", "english", 475)
		));
	public List<Book> allBooks() {
		return books;
	}
	public Book findBookByIndex(int index) {
		if (index < books.size()) {
			return books.get(index);
		}else {
			return null;
		}
	}
	public List<Book> saveBook(Book book) {
		return books;
	}
	@Autowired
	private final BookRepository bookRepository;
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
	    if(optionalBook.isPresent()) {
	    	return optionalBook.get();
	    } else {
	    	return null;
	    }
	}
	public Book getSingleBook(long id) {
		return this.bookRepository.findById(id).orElse(null);
	}
	public Book updateBook(int id, Book book) {
		if (id < books.size()) {
			books.set(id, book);
		}
		return book;
	}
	public void destroyBook(Long id) {
		if (id < books.size()) {
			books.remove(id);
		}
	}
	public Book updateBook(Long id, String title, String description, String language, Integer numOfPages) {
		return null;
	}
}
