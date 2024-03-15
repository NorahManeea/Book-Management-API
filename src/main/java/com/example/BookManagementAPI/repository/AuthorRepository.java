package com.example.BookManagementAPI.repository;

import com.example.BookManagementAPI.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
