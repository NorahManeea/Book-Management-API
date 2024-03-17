package com.example.BookManagementAPI.dto;

import com.example.BookManagementAPI.enums.BookStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookDTO {
    private Long id;

    @NotBlank
    @Size(min = 1, max = 20)
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

    private BookStatus status;
}