package dev.asteroid.todolist.dto;

import lombok.Data;

@Data
public class MemberRequestDto {
    private String email;
    private String password;
    private String name;
}
