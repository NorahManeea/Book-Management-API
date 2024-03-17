package com.example.BookManagementAPI.mapper;

import com.example.BookManagementAPI.dto.UserDTO;
import com.example.BookManagementAPI.entity.User;

public class UserMapper {

    public User mapToUser(final UserDTO userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        return user;
    }

    public UserDTO mapToUserDto(final User user) {
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole());
        return userDto;
    }
}
