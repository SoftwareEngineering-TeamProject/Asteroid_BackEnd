package dev.asteroid.todolist.dto.task;

import dev.asteroid.todolist.domain.list.ListEntity;
import dev.asteroid.todolist.domain.task.TaskEntity;
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
