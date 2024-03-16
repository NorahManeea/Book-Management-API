package com.example.BookManagementAPI.repository;

import com.example.BookManagementAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
