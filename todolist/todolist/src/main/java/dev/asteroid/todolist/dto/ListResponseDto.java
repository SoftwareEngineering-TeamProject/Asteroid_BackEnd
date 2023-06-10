package dev.asteroid.todolist.dto;

import dev.asteroid.todolist.domain.TaskEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListResponseDto {
    private Long id;
    private String  title;
    private List<TaskEntity> tasks = new ArrayList<>();
}
