package com.example.BookManagementAPI.controller;


import com.example.BookManagementAPI.entity.Author;
import com.example.BookManagementAPI.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") Long id) {
        Optional<Author> authorId = authorService.getAuthorById(id);
        return authorId.map(author -> new ResponseEntity<>(author, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        Author newAuthor = authorService.saveAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Author> deleteAuthorById(@PathVariable("id") Long id) {
        Optional<Author> authorId = authorService.deleteAuthorById(id);
        return authorId.map(author -> new ResponseEntity<>(author, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthorById(@PathVariable("id") Long id, @RequestBody Author author) {
        Author updatedAuthor = authorService.updateAuthor(id, author);
        if (updatedAuthor != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedAuthor);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
