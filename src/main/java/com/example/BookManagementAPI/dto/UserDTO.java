package com.example.BookManagementAPI.dto;


import com.example.BookManagementAPI.enums.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    @NotBlank(message = "Username should be filled!")
    private String username;
    @NotBlank(message = "Email should be filled!")
    private String email;
    private Role role;
}
