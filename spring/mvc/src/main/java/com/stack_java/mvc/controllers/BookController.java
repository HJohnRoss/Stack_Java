package com.stack_java.mvc.controllers;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stack_java.mvc.models.Book;
import com.stack_java.mvc.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public String home(
			Model model
			) {
		
		List<Book> allBooks = bookService.allBooks();
		
		model.addAttribute("allBooks", allBooks);
		
		return "home.jsp";
	}
	
	@GetMapping("/books/{bookId}")
	public String index(
			Model model,
			@PathVariable("bookId") Long bookId
			) {
		
		System.out.println(bookId);
		Book book = bookService.findBook(bookId);
		
		
		model.addAttribute("book", book);
		
		return "index.jsp";
	}
	
	
	
	@GetMapping("/book/create")
	public String create(
			@ModelAttribute("book") Book book // equal to request.form** in python
			) {
		
		
		return "createBook.jsp";
	}
	
	@PostMapping("/book/create/success")
	public String addBook(
			RedirectAttributes redirectAttributes, // equal to request.form** in python
			@Valid @ModelAttribute("book") Book book,
			BindingResult result // for validations
//			@RequestParam(name="title") String title,
//			@RequestParam(name="description") String description,
//			@RequestParam(name="language") String language,
//			@RequestParam(name="numberOfPages") Integer numberOfPages
			) {
		
		if(result.hasErrors()) {
			return "createBook.jsp";
		}
		
//		Book book = new Book(title, description, language, numberOfPages);
		bookService.createBook(book);
		
		return "redirect:/";
		
	}
	
	
}
