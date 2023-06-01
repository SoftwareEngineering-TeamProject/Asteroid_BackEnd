package com.example.todolist.dto;

import lombok.Data;

@Data
public class MemberRequestDto {
    private String email;
    private String password;
    private String name;
}
