package com.example.BookManagementAPI.service;


import com.example.BookManagementAPI.entity.Book;
import com.example.BookManagementAPI.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setIsbn(updatedBook.getIsbn());
                    book.setTitle(updatedBook.getTitle());
                    book.setDescription(updatedBook.getDescription());
                    book.setGenre(updatedBook.getGenre());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setStock(updatedBook.getStock());
                    return bookRepository.save(book);
                })
                .orElse(null);
    }
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}


