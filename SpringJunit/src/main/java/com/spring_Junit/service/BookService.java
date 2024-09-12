package com.spring_Junit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.spring_Junit.entity.Book;
import com.spring_Junit.repo.BookRepo;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    // Get book by ID (throws exception if not found)
    public Book getBookById(Long bookId) {
        return bookRepo.findById(bookId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found with ID: " + bookId));
    }

    // Create a new book with validation
    public Book createBook(Book book) {
        if (book == null || book.getBookName() == null || book.getAuther() == null || book.getPrice() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid book data: Book name, author, and price must not be null");
        }
        return bookRepo.save(book);
    }

    // Update an existing book
    public Book updateBook(Book book) {
        if (book == null || book.getBookId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book record or book ID cannot be null");
        }

        return bookRepo.findById(book.getBookId()).map(existingBook -> {
            existingBook.setBookName(book.getBookName());
            existingBook.setAuther(book.getAuther());
            existingBook.setPrice(book.getPrice());
            return bookRepo.save(existingBook);
        }).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found with ID: " + book.getBookId()));
    }

    // Delete an existing book by ID (check if exists first)
    public void deleteBookById(Long bookId) {
        if (!bookRepo.existsById(bookId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found with ID: " + bookId);
        }
        bookRepo.deleteById(bookId);
    }
}
