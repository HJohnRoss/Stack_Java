package com.stack_java.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
	public String index(Model model, HttpSession session) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new UserLogin());
		if (session.getAttribute("userId") != null) {
			return "redirect:/dashboard";
		}
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
		if (result.hasErrors()) {
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
		model.addAttribute("userName", session.getAttribute("userName"));
		model.addAttribute("allBooks", bookService.allBooks());
		if (model.getAttribute("userId") == null) {
			return "redirect:/";
		}
		return "dashboard.jsp";
	}

//	Create a book
	@GetMapping("/book/create")
	public String book(HttpSession session, Model model) {
		model.addAttribute("userId", session.getAttribute("userId"));
		model.addAttribute("userName", session.getAttribute("userName"));
		if (model.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("newBook", new Book());
		return "createBook.jsp";
	}

	@PostMapping("/book/create/success")
	public String createBook(@Valid @ModelAttribute("newBook") Book book, BindingResult result, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			return "createBook.jsp";
		}
		bookService.createBook(book);
		return "redirect:/dashboard";
	}

//	Show One Book
	@GetMapping("/book/show/{id}")
	public String showBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("oneBook", bookService.getBook(id));
		return "oneBook.jsp";
	}

//	edit book
	@GetMapping("/book/edit/{id}")
	public String editBookShow(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") != id) {
			return "redirect:/";
		}
		model.addAttribute("oneBook", bookService.getBook(id));
		return "editBook.jsp";
	}
	
//	Make sure to use PutMapping for edits
	@PutMapping("/book/edit/success")
	public String editBook(@Valid @ModelAttribute("oneBook") Book book, BindingResult result, Model model,
			HttpSession session) {
		if (session.getAttribute("userId") != book.getUser().getId()) {
			return "redirect:/dashboard";
		}
		if (result.hasErrors()) {
			return "editBook.jsp";
		}
		bookService.createBook(book);
		return "redirect:/dashboard";
	}

//	delete book
	@DeleteMapping("/book/delete/{id}")
	public String destroy(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (!session.getAttribute("userId").equals(bookService.getBook(id).getUser().getId())) {
			return "redirect:/dashboard";
		}
		bookService.deleteBook(id);
		return "redirect:/dashboard";
	}
	
//	wrong way
//	@RequestMapping("/book/delete/{id}")
//    public String deleteBook(@PathVariable("id") Long id, HttpSession session) {
//		if (!session.getAttribute("userId").equals(bookService.getBook(id).getUser().getId())) {
//		return "redirect:/dashboard";
//	}
//        bookService.deleteBook(id);
//        return "redirect:/dashboard";
//    }
	
//	book broker dashboard
	@GetMapping("/bookmarket")
	public String bookMarket(HttpSession session, Model model) {
		model.addAttribute("userName", session.getAttribute("userName"));
		model.addAttribute("userId", session.getAttribute("userId"));
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("allBooks", bookService.allBooks());
		model.addAttribute("oneUser", userService.oneUser(session.getAttribute("userId")));
		return "bookMarket.jsp";
	}
	
	@GetMapping("/borrow/add/{id}")
	public String borrow(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		return "redirect:/bookmarket";
	}
}