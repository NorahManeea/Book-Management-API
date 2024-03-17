package com.example.BookManagementAPI.entity;

import com.example.BookManagementAPI.enums.BookStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 20)
    private String isbn;

    private String title;
    private String description;
    private String genre;
    private int publicationYear;
    private float price;
    private String author;
    private BookStatus status;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Borrowing> bookBorrows = new ArrayList<>();

}
