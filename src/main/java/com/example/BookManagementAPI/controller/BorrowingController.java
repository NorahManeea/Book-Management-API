package com.example.BookManagementAPI.controller;


import com.example.BookManagementAPI.entity.Borrowing;
import com.example.BookManagementAPI.service.BorrowingService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {

    private final BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @Operation(summary = "Get all borrowings")
    @GetMapping
    public ResponseEntity<List<Borrowing>> getAllBorrowings() {
        List<Borrowing> borrowings = borrowingService.getAllBorrowings();
        return new ResponseEntity<>(borrowings, HttpStatus.OK);
    }

    @Operation(summary = "Get a borrowing by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Borrowing> getBorrowingById(@PathVariable("id") Long id) {
        Optional<Borrowing> borrowing = borrowingService.getBorrowingById(id);
        return borrowing.map(b -> new ResponseEntity<>(b, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Operation(summary = "Create a new borrowing")
    @PostMapping
    public ResponseEntity<Borrowing> createBorrowing(@RequestBody Borrowing borrowing) {
        Borrowing newBorrowing = borrowingService.borrowBook(borrowing);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBorrowing);
    }
}