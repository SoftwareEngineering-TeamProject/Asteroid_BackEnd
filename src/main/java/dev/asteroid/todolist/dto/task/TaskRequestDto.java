package dev.asteroid.todolist.dto.task;

import dev.asteroid.todolist.domain.list.ListEntity;
import dev.asteroid.todolist.domain.task.TaskEntity;
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
