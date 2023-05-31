package com.example.todolist.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nonnull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskRequestDto {

    private Long userId;
    @Nonnull
    private int month;
    @Nonnull
    private int day;
    @Nonnull
    private String title;
    @Nonnull
    private String content;

    private Boolean complete;
    @Nonnull
    private Boolean alarm;

}
