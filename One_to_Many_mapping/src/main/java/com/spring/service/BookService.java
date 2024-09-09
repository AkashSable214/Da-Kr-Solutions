package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Book;
import com.spring.repo.BookRepo;

@Service
public class BookService {
	@Autowired
	BookRepo br;

	public List<Book> getAll() {
	List<Book> list=br.findAll();
	return list;
	}

	public Book getBookById(Long id) {
		Book book=br.findById(id).get();
		
		return book;
	}

	public Book addBook(Book book) {
		Book book1=br.save(book);
		return book1;
	}

	public Book updateBook(Long id, Book book) {
		Book book1=br.findById(id).get();
		
		book1.setBookName(book.getBookName());
		book1.setAuthor(book.getAuthor());
		
		return br.save(book1);
	}

	public void deleteBookById(Long id) {
		br.deleteById(id);
	}

}
