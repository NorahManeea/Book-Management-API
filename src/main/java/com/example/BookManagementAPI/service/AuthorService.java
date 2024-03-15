package com.example.BookManagementAPI.service;


import com.example.BookManagementAPI.entity.Author;
import com.example.BookManagementAPI.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long Id){
        return authorRepository.findById(Id);
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Optional<Author> deleteAuthorById(Long Id) {
        Optional<Author> deletedAuthor = authorRepository.findById(Id);
        if (deletedAuthor.isPresent()) {
            authorRepository.deleteById(Id);
        }
        return deletedAuthor;
    }

    public Author updateAuthor(Long id, Author updatedAuthor) {
        Optional<Author> existingAuthorOptional = authorRepository.findById(id);
        if (existingAuthorOptional.isPresent()) {
            Author existingAuthor = existingAuthorOptional.get();
            existingAuthor.setName(updatedAuthor.getName());
            return authorRepository.save(existingAuthor);
        }
        return null;
    }
}
