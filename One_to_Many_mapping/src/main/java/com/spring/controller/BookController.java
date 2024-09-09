package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Book;
import com.spring.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bs;

	@GetMapping
	public ResponseEntity<List<Book>> getAllBook() {
		List<Book> list = bs.getAll();

		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id) {
		Book book = bs.getBookById(id);
		return ResponseEntity.ok(book);

	}

	@PostMapping("/insert")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book book1 = bs.addBook(book);
		return ResponseEntity.ok(book1);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
		Book book1 = bs.updateBook(id, book);
		return ResponseEntity.ok(book1);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBookById(@PathVariable Long id) {
		bs.deleteBookById(id);
		return ResponseEntity.ok("Data Deleted");
	}

}
