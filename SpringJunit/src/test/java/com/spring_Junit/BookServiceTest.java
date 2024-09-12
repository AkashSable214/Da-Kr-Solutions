package com.spring_Junit;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.spring_Junit.entity.Book;
import com.spring_Junit.repo.BookRepo;
import com.spring_Junit.service.BookService;

@SpringBootTest
public class BookServiceTest {

    @Mock
    private BookRepo bookRepo;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Test case for getAllBooks
    @Test
    void testGetAllBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "Spring Boot", "Author 1", 100.0));
        books.add(new Book(2L, "Java Basics", "Author 2", 50.0));

        when(bookRepo.findAll()).thenReturn(books);

        List<Book> result = bookService.getAllBooks();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Spring Boot", result.get(0).getBookName());
    }

    // Test case for getBookById - Book exists
    @Test
    void testGetBookById_BookExists() {
        Book book = new Book(1L, "Spring Boot", "Author 1", 100.0);

        when(bookRepo.findById(1L)).thenReturn(Optional.of(book));

        Book result = bookService.getBookById(1L);

        assertNotNull(result);
        assertEquals("Spring Boot", result.getBookName());
        assertEquals("Author 1", result.getAuther());
    }

    // Test case for getBookById - Book does not exist
    @Test
    void testGetBookById_BookNotFound() {
        when(bookRepo.findById(1L)).thenReturn(Optional.empty());

        ResponseStatusException thrown = assertThrows(
            ResponseStatusException.class,
            () -> bookService.getBookById(1L)
        );

        assertEquals(HttpStatus.NOT_FOUND, thrown.getStatusCode());
        assertEquals("Book not found with ID: 1", thrown.getReason());
    }

    // Test case for createBook - Valid Book
    @Test
    void testCreateBook_ValidBook() {
        Book book = new Book(null, "Spring Boot", "Author 1", 100.0);
        Book savedBook = new Book(1L, "Spring Boot", "Author 1", 100.0);

        when(bookRepo.save(book)).thenReturn(savedBook);

        Book result = bookService.createBook(book);

        assertNotNull(result);
        assertEquals(1L, result.getBookId());
    }

    // Test case for createBook - Invalid Book
    @Test
    void testCreateBook_InvalidBook() {
        Book invalidBook = new Book(null, null, null, null);

        ResponseStatusException thrown = assertThrows(
            ResponseStatusException.class,
            () -> bookService.createBook(invalidBook)
        );

        assertEquals(HttpStatus.BAD_REQUEST, thrown.getStatusCode());
        assertEquals("Invalid book data: Book name, author, and price must not be null", thrown.getReason());
    }

    // Test case for updateBook - Book exists
    @Test
    void testUpdateBook_BookExists() {
        Book existingBook = new Book(1L, "Spring Boot", "Author 1", 100.0);
        Book updatedBook = new Book(1L, "Spring Boot Updated", "Author 1", 120.0);

        when(bookRepo.findById(1L)).thenReturn(Optional.of(existingBook));
        when(bookRepo.save(updatedBook)).thenReturn(updatedBook);

        Book result = bookService.updateBook(updatedBook);

        assertNotNull(result);
        assertEquals("Spring Boot Updated", result.getBookName());
        assertEquals(120.0, result.getPrice());
    }

    // Test case for updateBook - Book does not exist
    @Test
    void testUpdateBook_BookNotFound() {
        Book book = new Book(1L, "Spring Boot", "Author 1", 100.0);

        when(bookRepo.findById(1L)).thenReturn(Optional.empty());

        ResponseStatusException thrown = assertThrows(
            ResponseStatusException.class,
            () -> bookService.updateBook(book)
        );

        assertEquals(HttpStatus.NOT_FOUND, thrown.getStatusCode());
        assertEquals("Book not found with ID: 1", thrown.getReason());
    }

    // Test case for deleteBookById - Book exists
    @Test
    void testDeleteBookById_BookExists() {
        when(bookRepo.existsById(1L)).thenReturn(true);

        // No exception should be thrown
        bookService.deleteBookById(1L);

        verify(bookRepo, times(1)).deleteById(1L);
    }

    // Test case for deleteBookById - Book does not exist
    @Test
    void testDeleteBookById_BookNotFound() {
        when(bookRepo.existsById(1L)).thenReturn(false);

        ResponseStatusException thrown = assertThrows(
            ResponseStatusException.class,
            () -> bookService.deleteBookById(1L)
        );

        assertEquals(HttpStatus.NOT_FOUND, thrown.getStatusCode());
        assertEquals("Book not found with ID: 1", thrown.getReason());
    }
}
