package com.example.BookManagementAPI.service;

import com.example.BookManagementAPI.entity.Borrowing;
import com.example.BookManagementAPI.enums.BookStatus;
import com.example.BookManagementAPI.repository.BorrowingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BorrowingService {

    private final BorrowingRepository borrowingRepository;

    public List<Borrowing> getAllBorrowings() {
        return borrowingRepository.findAll();
    }

    public Optional<Borrowing> getBorrowingById(Long id) {
        return borrowingRepository.findById(id);
    }

    public Borrowing borrowBook(Borrowing borrowing) {
        borrowing.getBook().setStatus(BookStatus.BORROWED);
        return borrowingRepository.save(borrowing);
    }

    public void deleteBorrowing(Long id) {
        borrowingRepository.deleteById(id);
    }
}