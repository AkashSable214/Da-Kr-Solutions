package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Author;
import com.spring.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	AuthorService as;

	@GetMapping
	public ResponseEntity<List<Author>> getAll() {

		List<Author> list = as.getAll();

		return ResponseEntity.ok(list);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
		Author author = as.getAuthorById(id);
		return ResponseEntity.ok(author);

	}

	@PostMapping("/insert")
	public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
		Author author1 = as.addAuthor(author);

		return ResponseEntity.ok(author1);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBookById(@PathVariable Long id) {

		as.deleteAuthorById(id);
		return ResponseEntity.ok("Data Deleted");
	}

}
