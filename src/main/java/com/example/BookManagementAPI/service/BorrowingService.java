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

    public List<Borrowing> getAllBorrowings() {
        return borrowingRepository.findAll();
    }

    public Optional<Borrowing> getBorrowingById(Long id) {
        return borrowingRepository.findById(id);
    }

    public Borrowing borrowBook(Borrowing borrowing) {
        return borrowingRepository.save(borrowing);
    }

    public Borrowing updateBorrowing(Long id, Borrowing updatedBorrowing) {
        return borrowingRepository.findById(id)
                .map(borrowing -> {
                    borrowing.setBook(updatedBorrowing.getBook());
                    borrowing.setUser(updatedBorrowing.getUser());
                    borrowing.setBorrowDate(updatedBorrowing.getBorrowDate());
                    borrowing.setReturnDate(updatedBorrowing.getReturnDate());
                    return borrowingRepository.save(borrowing);
                })
                .orElse(null);
    }

    public void deleteBorrowing(Long id) {
        borrowingRepository.deleteById(id);
    }
}