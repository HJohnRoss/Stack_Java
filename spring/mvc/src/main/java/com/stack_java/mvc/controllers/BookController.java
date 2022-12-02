package com.stack_java.mvc.controllers;

import java.sql.Array;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.stack_java.mvc.models.Book;
import com.stack_java.mvc.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books/{bookId}")
	public String index(
			Model model,
			@PathVariable("bookId") Long bookId
			) {
		
		System.out.println(bookId);
		Book book = bookService.findBook(bookId);
		
		List<Book> books = bookService.allBooks();
		
		model.addAttribute("book", book);
		model.addAttribute("books", books);
		
		return "index.jsp";
	}
	
	
}
