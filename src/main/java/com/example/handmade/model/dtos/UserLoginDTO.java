package com.example.handmade.model.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserLoginDTO {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public String getEmail() {
        return email;
    }

    public UserLoginDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
