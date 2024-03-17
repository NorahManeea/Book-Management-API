package com.example.BookManagementAPI.mapper;

import com.example.BookManagementAPI.dto.BorrowingDTO;
import com.example.BookManagementAPI.entity.Borrowing;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class BorrowingMapper {

    public Borrowing mapToBorrowing(BorrowingDTO borrowingDto) {
        Borrowing borrowing = new Borrowing();
        borrowing.setId(borrowingDto.getId());
        borrowing.setBorrowDate(Date.from(borrowingDto.getBorrowDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        borrowing.setReturnDate(Date.from(borrowingDto.getReturnDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        return borrowing;
    }

    public BorrowingDTO mapToBorrowingDto(Borrowing borrowing) {
        BorrowingDTO borrowingDto = new BorrowingDTO();
        borrowingDto.setId(borrowing.getId());
        borrowingDto.setBookId(borrowing.getBook().getId());
        borrowingDto.setUserId(borrowing.getUser().getId());
        borrowingDto.setBorrowDate(LocalDate.ofInstant(borrowing.getBorrowDate().toInstant(), ZoneId.systemDefault()));
        borrowingDto.setReturnDate(LocalDate.ofInstant(borrowing.getReturnDate().toInstant(), ZoneId.systemDefault()));
        return borrowingDto;
    }
}
