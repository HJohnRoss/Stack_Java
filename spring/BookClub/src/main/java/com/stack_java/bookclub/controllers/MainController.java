package com.stack_java.bookclub.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.stack_java.bookclub.models.Book;
import com.stack_java.bookclub.models.User;
import com.stack_java.bookclub.models.UserLogin;
import com.stack_java.bookclub.services.BooksService;
import com.stack_java.bookclub.services.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BooksService bookService;

//	LOGIN & REGISTRATION
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new UserLogin());
		return "index.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {
		User user = userService.register(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new UserLogin());
			return "index.jsp";
		}
		session.setAttribute("userId", user.getId());
		session.setAttribute("userName", user.getName());
		return "redirect:/dashboard";
	}

	@PostMapping("/login")
	public String register(@Valid @ModelAttribute("newLogin") UserLogin newLogin, BindingResult result, Model model,
			HttpSession session) {
		User user = userService.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		session.setAttribute("userId", user.getId());
		session.setAttribute("userName", user.getName());
		return "redirect:/dashboard";
	}
	
//	Logout
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
//	Dashboard
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		model.addAttribute("userId", session.getAttribute("userId"));
		model.addAttribute("userName" ,session.getAttribute("userName"));
		model.addAttribute("allBooks", bookService.allBooks());
		if(model.getAttribute("userId") == null) {
			return "redirect:/";
		}
		return "dashboard.jsp";
	}
	
//	Create a book
	@GetMapping("/book/create")
	public String book(HttpSession session, Model model) {
		model.addAttribute("userId", session.getAttribute("userId"));
		model.addAttribute("userName" ,session.getAttribute("userName"));
		if(model.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("newBook", new Book());
		return "createBook.jsp";
	}
	
	@PostMapping("/book/create/success")
	public String createBook(@Valid @ModelAttribute("newBook") Book book, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "createBook.jsp";
		}
		bookService.createBook(book);
		return "redirect:/dashboard";
	}
	
//	Show One Book
	@GetMapping("/book/show/{id}")
	public String showBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("oneBook", bookService.getBook(id));
		return "oneBook.jsp";
	}
	
//	edit book
	@GetMapping("/book/edit/{id}")
	public String editBookShow(@PathVariable("id") Long id, Model model) {
		model.addAttribute("oneBook", bookService.getBook(id));
		return "editBook.jsp";
	}
	
	@PostMapping("/book/edit/success")
	public String editBook(@Valid @ModelAttribute("oneBook") Book book, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		}
		bookService.createBook(book);
		return "redirect:/dashboard";
	}
	
//	delete book
	@RequestMapping("/books/delete/{id}")
//	 what is going on here?????????????????? why cant i use DeleteMapping and why can i use request?
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/dashboard";
    }
	
}