package com.example.BookManagementAPI.entity;

import com.example.BookManagementAPI.enums.BookStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @Size(min = 1, max = 20)
    @Column(unique = true)
    private String isbn;

    @NotBlank
    @Size(min = 1, max = 255)
    private String title;

    @Size(max = 1000)
    private String description;

    @NotBlank
    @Size(min = 1, max = 255)
    private String genre;

    @PositiveOrZero(message = "Publication year must be a non-negative value")
    private Integer publicationYear;

    @PositiveOrZero(message = "Price must be a non-negative value")
    private Float price;

    @NotBlank
    @Size(min = 1, max = 255)
    private String author;

    @Enumerated(EnumType.STRING)
    private BookStatus status;
}
