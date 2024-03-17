package com.example.BookManagementAPI.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingDTO {
    private Long id;
    private Long bookId;
    private Long userId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}