package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Book;
import com.spring.service.BookService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")

public class BookController {
	
	@Autowired
	BookService bookService;
	@GetMapping("/all")
	public ResponseEntity<List<Book>> getAllBook() {
		List<Book> books= bookService.getAllBook();
		return ResponseEntity.ok(books);
		}
	
	@PostMapping("/insert")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book addBook=bookService.addBook(book);
		return ResponseEntity.ok(addBook);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable long id) {
		Book updateBook=bookService.updateBook(book, id);
		return ResponseEntity.ok(updateBook);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable long id) {
		 bookService.deleteBook(id);
		return ResponseEntity.ok("Data deleted");
	}

}
