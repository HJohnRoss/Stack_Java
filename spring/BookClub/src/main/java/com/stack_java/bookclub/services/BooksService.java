package com.stack_java.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stack_java.bookclub.models.Book;
import com.stack_java.bookclub.repositories.BookRepository;

@Service
public class BooksService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}

	public void createBook(Book book) {
		bookRepository.save(book);
	}
	
	public Book getBook(Long id) {
		Optional<Book> opBook = bookRepository.findById(id);
		return opBook.get();
	}

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}
