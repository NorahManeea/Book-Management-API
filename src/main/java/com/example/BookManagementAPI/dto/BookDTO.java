package com.example.BookManagementAPI.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    @NotBlank
    @Size(min = 0, max = 20)
    private String isbn;
    private String title;
    private String description;
    private String genre;
    private String author;
    @PositiveOrZero(message = "Publication year must be a non-negative value")
    private int publicationYear;
    @PositiveOrZero(message = "Total pages must be a non-negative value")
    private int totalPages;
    @Min(value = 0, message = "Stock must not be negative")
    private int stock;

}