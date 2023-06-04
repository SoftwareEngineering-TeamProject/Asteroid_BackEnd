package dev.asteroid.todolist.dto.task;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TaskResponseDto {

    private String content;
    private Boolean completed;

    public TaskResponseDto(String content, Boolean completed) {
        this.content = content;
        this.completed = completed;
    }
}
