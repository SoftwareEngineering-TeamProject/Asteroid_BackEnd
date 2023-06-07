package dev.asteroid.todolist.dto;

import dev.asteroid.todolist.domain.ListEntity;
import dev.asteroid.todolist.domain.TaskEntity;
import lombok.Data;
import lombok.Getter;

@Getter
public class TaskRequestDto {
    private ListEntity list;
    private String content;
    private Boolean completed;

    public TaskEntity toEntity() {
        TaskEntity taskEntity = new TaskEntity(list, content, completed);
        taskEntity.setList(list);
        return taskEntity;
    }
}
