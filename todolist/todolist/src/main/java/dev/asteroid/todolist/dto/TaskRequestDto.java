package dev.asteroid.todolist.dto;

import lombok.Data;

@Data
public class TaskRequestDto {
    private Long id;
    private int day;
    private String title;
    private String content;
    private Boolean complete;
    private Boolean alarm;
}
