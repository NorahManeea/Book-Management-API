package com.example.BookManagementAPI.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 0, max = 20)
    private String isbn;
    @Column(name = "title", nullable = false)
    private String title;
    private String description;
    private String genre;
    private int publicationYear;
    private int totalPages;
    private String author;

}
