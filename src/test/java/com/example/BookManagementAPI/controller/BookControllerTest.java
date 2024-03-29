package com.example.BookManagementAPI.controller;

import com.example.BookManagementAPI.entity.Book;
import com.example.BookManagementAPI.enums.BookStatus;
import com.example.BookManagementAPI.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

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
    void getPaginatedBooks() {
        // Arrange
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "ISBN1", "Book 1", "Description 1", "Fiction", 2022, 190.0f, "Author1", BookStatus.AVAILABLE));
        books.add(new Book(2L, "ISBN1", "Book 1", "Description 1", "Fiction", 2022, 190.0f, "Author1", BookStatus.AVAILABLE));
        Page<Book> bookPage = new PageImpl<>(books);
        when(bookService.getPaginatedBooks(0, 10)).thenReturn(bookPage);

        ResponseEntity<Page<Book>> response = bookController.getAllBooks(0, 10);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(bookPage, response.getBody());
    }

    @Test
    void getBookById_existingId() {
        long id = 1L;
        Book book = new Book(1L, "ISBN1", "Book 1", "Description 1", "Fiction", 2022, 190.0f, "Author1", BookStatus.AVAILABLE);
        when(bookService.getBookById(id)).thenReturn(Optional.of(book));

        ResponseEntity<Book> response = bookController.getBookById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(book, response.getBody());
    }

    @Test
    void getBookById_nonExistingId() {
        long id = 1L;
        when(bookService.getBookById(id)).thenReturn(Optional.empty());

        ResponseEntity<Book> response = bookController.getBookById(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }


    @Test
    void addBook() {
        Book book = new Book(1L, "ISBN1", "Book 1", "Description 1", "Fiction", 2022, 190.0f, "Author1", BookStatus.AVAILABLE);
        when(bookService.saveBook(book)).thenReturn(book);

        ResponseEntity<Book> response = bookController.addBook(book);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(book, response.getBody());
    }

}
