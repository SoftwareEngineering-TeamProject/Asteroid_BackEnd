package dev.asteroid.todolist.dto;

import dev.asteroid.todolist.domain.ListEntity;
import dev.asteroid.todolist.domain.TaskEntity;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Getter
public class TaskRequestDto {

    private ListEntity list;
    private String content;
    private Boolean completed;
    private Date deadline;

    public TaskEntity toEntity() {
        TaskEntity taskEntity = new TaskEntity(list, content, completed, deadline);
        taskEntity.setList(list);
        return taskEntity;
    }
}
