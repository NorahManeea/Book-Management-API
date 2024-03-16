package com.example.BookManagementAPI.service;

import com.example.BookManagementAPI.entity.Borrowing;
import com.example.BookManagementAPI.repository.BorrowingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BorrowingService {

    private final BorrowingRepository borrowingRepository;

    public Borrowing borrowBook(Borrowing borrowing) {
        return borrowingRepository.save(borrowing);
    }

    public Optional<Borrowing> getBorrowingById(Long id) {
        return borrowingRepository.findById(id);
    }

    public List<Borrowing> getAllBorrowings() {
        return borrowingRepository.findAll();
    }
}