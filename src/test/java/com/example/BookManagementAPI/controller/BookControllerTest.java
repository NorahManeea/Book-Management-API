package com.example.BookManagementAPI.controller;

import com.example.BookManagementAPI.entity.Book;
import com.example.BookManagementAPI.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookControllerTest {
    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllBooks() {
        // Arrange
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "ISBN1", "Book 1", "Description 1"));
        books.add(new Book(2L, "ISBN2", "Book 2", "Description 2"));
        when(bookService.getAllBooks()).thenReturn(books);

        // Act
        ResponseEntity<List<Book>> response = bookController.getAllBooks();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(books, response.getBody());
    }

    @Test
    void getBookById_existingId() {
        // Arrange
        long id = 1L;
        Book book = new Book(2L, "ISBN2", "Book 2", "Description 2");
        when(bookService.getBookById(id)).thenReturn(Optional.of(book));

        // Act
        ResponseEntity<Book> response = bookController.getBookById(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(book, response.getBody());
    }

    @Test
    void getBookById_nonExistingId() {
        // Arrange
        long id = 1L;
        when(bookService.getBookById(id)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Book> response = bookController.getBookById(id);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void addBook() {
        // Arrange
        Book book = new Book(2L, "ISBN2", "Book 2", "Description 2");
        when(bookService.saveBook(book)).thenReturn(book);

        // Act
        ResponseEntity<Book> response = bookController.addBook(book);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(book, response.getBody());
    }
}
