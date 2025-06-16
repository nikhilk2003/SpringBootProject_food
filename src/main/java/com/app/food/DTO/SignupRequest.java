package com.app.food.DTO;

import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String name;
    private String password;
    private String email;
    private String phone;
}
// Getters and Setters