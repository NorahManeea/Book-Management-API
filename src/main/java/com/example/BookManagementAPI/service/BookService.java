package com.example.BookManagementAPI.service;


import com.example.BookManagementAPI.entity.Book;
import com.example.BookManagementAPI.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Page<Book> getPaginatedBooks(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return bookRepository.findAll(pageRequest);
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
                    return bookRepository.save(book);
                })
                .orElse(null);
    }
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}


