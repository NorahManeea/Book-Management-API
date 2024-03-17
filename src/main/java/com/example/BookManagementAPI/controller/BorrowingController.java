package com.example.BookManagementAPI.controller;


import com.example.BookManagementAPI.entity.Borrowing;
import com.example.BookManagementAPI.service.BorrowingService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
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
    public ResponseEntity<Borrowing> createBorrowing(@RequestBody @Valid Borrowing borrowing) {
        Borrowing newBorrowing = borrowingService.borrowBook(borrowing);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBorrowing);
    }

    @Operation(summary = "Update borrowing By ID")
    @PutMapping("/{id}")
    public ResponseEntity<Borrowing> updateBorrowing(@PathVariable Long id, @RequestBody Borrowing borrowing) {
        Borrowing updatedBorrowing = borrowingService.updateBorrowing(id, borrowing);
        if (updatedBorrowing != null) {
            return ResponseEntity.ok(updatedBorrowing);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete borrowing By ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrowing(@PathVariable Long id) {
        borrowingService.deleteBorrowing(id);
        return ResponseEntity.noContent().build();
    }
}