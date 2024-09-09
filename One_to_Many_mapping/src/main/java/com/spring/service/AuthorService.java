package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Author;
import com.spring.repo.AuthorRepo;

@Service
public class AuthorService {

	@Autowired
	AuthorRepo ar;

	public List<Author> getAll() {
		List<Author> list=ar.findAll();
		return list;
	}

	public Author getAuthorById(Long id) {
		Author author=ar.findById(id).orElse(null);
		
		return author;
	}

	public Author addAuthor(Author author) {
		Author author1=ar.save(author);
		return author1;
	}

	

	public void deleteAuthorById(Long id) {
		ar.deleteById(id);
	}

}
