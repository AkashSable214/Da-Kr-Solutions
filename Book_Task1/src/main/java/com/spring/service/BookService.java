package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Book;
import com.spring.repository.BookInterfaceRepository;

@Service
public class BookService {
	
	@Autowired
	BookInterfaceRepository bookRepo;
	
//	get all Book
	public List<Book> getAllBook() {
		List<Book> list=bookRepo.findAll();
		return list;
		
	}

//	insert into book in database
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}
	
//	update book information from database
	public Book updateBook(Book book, long id) {
		Book bb=bookRepo.findById(id).get();
		bb.setTitle(book.getTitle());
		bb.setAutherName(book.getAutherName());
		bb.setPrice(book.getPrice());
		
		return bookRepo.save(bb);
	}
	
//	delete book from database
	public void deleteBook(long id) {
		bookRepo.deleteById(id);
	}
	
}
