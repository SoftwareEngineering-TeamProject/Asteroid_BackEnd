package com.example.todolist.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDto {
    private String email;
    private String password;
    private String name;
}
