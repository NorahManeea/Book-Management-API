package com.example.BookManagementAPI.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    @Size(min = 0, max = 20)
    private String isbn;
    private String title;
    private String description;
    private String genre;
    private String author;
    @Min(value = 0, message = "Stock must not be negative")
    private int stock;
    @OneToMany(mappedBy = "book")
    private List<Borrowing> bookBorrows = new ArrayList<>();

}
