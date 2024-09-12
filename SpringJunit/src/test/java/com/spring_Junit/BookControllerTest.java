package com.spring_Junit;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring_Junit.controller.BookController;
import com.spring_Junit.entity.Book;
import com.spring_Junit.service.BookService;

@WebMvcTest(BookController.class)
@ExtendWith(SpringExtension.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    
   Book list1= new Book(1L, "Spring Boot", "Author 1", 100.0);
   Book list2=new Book(2L, "JUnit in Action", "Author 2", 150.0);
    
    
    // Utility method to convert object to JSON string
    private String asJsonString(Object obj) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    // Test case for getting all books
    @Test
    public void testGetAllBooks() throws Exception {

    	List<Book> list=new ArrayList<>(Arrays.asList(list1,list2));
    	
    	Mockito.when(bookService.getAllBooks()).thenReturn(list);
    	
        mockMvc.perform(get("/api/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].bookName").value("Spring Boot"))
                .andExpect(jsonPath("$[1].bookName").value("JUnit in Action"));
    }

    // Test case for getting a book by ID
    @Test
    public void testGetBookById() throws Exception {
        when(bookService.getBookById(1L)).thenReturn(
            new Book(1L, "Spring Boot", "Author 1", 100.0)
        );

        mockMvc.perform(get("/api/books/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookName").value("Spring Boot"))
                .andExpect(jsonPath("$.auther").value("Author 1"))
                .andExpect(jsonPath("$.price").value(100.0));
    }
   


    // Test case for creating a new book
    @Test
    public void testCreateBook() throws Exception {
        Book newBook = new Book(null, "New Book", "New Author", 200.0);
        Book savedBook = new Book(1L, "New Book", "New Author", 200.0);

        when(bookService.createBook(any(Book.class))).thenReturn(savedBook);

        mockMvc.perform(post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(newBook)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.bookId").value(1L))
                .andExpect(jsonPath("$.bookName").value("New Book"))
                .andExpect(jsonPath("$.auther").value("New Author"))
                .andExpect(jsonPath("$.price").value(200.0));
    }

    // Test case for updating a book
    @Test
    public void testUpdateBook() throws Exception {
        Book updatedBook = new Book(1L, "Updated Book", "Updated Author", 250.0);

        when(bookService.updateBook(any(Book.class))).thenReturn(updatedBook);

        mockMvc.perform(put("/api/books/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(updatedBook)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookName").value("Updated Book"))
                .andExpect(jsonPath("$.auther").value("Updated Author"))
                .andExpect(jsonPath("$.price").value(250.0));
    }

    // Test case for deleting a book by ID
    @Test
    public void testDeleteBookById() throws Exception {
        mockMvc.perform(delete("/api/books/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
