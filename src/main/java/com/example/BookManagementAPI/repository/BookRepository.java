package com.example.BookManagementAPI.repository;

import com.example.BookManagementAPI.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
