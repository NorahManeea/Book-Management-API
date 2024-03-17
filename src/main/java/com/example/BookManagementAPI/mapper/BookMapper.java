package com.example.BookManagementAPI.mapper;

import com.example.BookManagementAPI.dto.BookDTO;
import com.example.BookManagementAPI.entity.Book;

public class BookMapper {

    public Book mapToBook( BookDTO bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setDescription(bookDto.getDescription());
        book.setGenre(bookDto.getGenre());
        book.setAuthor(bookDto.getAuthor());
        book.setStatus(bookDto.getStatus());
        book.setPublicationYear(bookDto.getPublicationYear());
        return book;
    }

    public BookDTO mapToBookDto(Book book) {
        BookDTO bookDto = new BookDTO();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setDescription(book.getDescription());
        bookDto.setGenre(book.getGenre());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setStatus(book.getStatus());
        bookDto.setPublicationYear(book.getPublicationYear());
        return bookDto;
    }
}
