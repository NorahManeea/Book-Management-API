package com.example.BookManagementAPI.controller;

import com.example.BookManagementAPI.entity.User;
import com.example.BookManagementAPI.exception.ApiException;
import com.example.BookManagementAPI.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get all users")
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(summary = "Get a user by ID")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> users = userService.getUserById(id);
        return users.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseThrow(() -> new ApiException("User not found with ID: " + id));
    }
}
