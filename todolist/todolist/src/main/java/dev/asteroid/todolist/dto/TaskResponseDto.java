package dev.asteroid.todolist.dto;

import dev.asteroid.todolist.domain.TaskEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
public class TaskResponseDto {
    private String content;
    private Boolean completed;

    private Date completeDate;

    private List<TaskResponseDto> responseDtoList = new ArrayList<>();  // 엔티티를 DTO 로 변환하여 조회할 때 사용되는 리스트

    public TaskResponseDto(String content, Boolean completed, Date completeDate) {
        this.content = content;
        this.completed = completed;
        this.completeDate = completeDate;
    }

    public TaskResponseDto(List<TaskEntity> taskEntities) {
        for(TaskEntity taskEntity : taskEntities) {  // 엔티티 목록 가져와서
            this.content = taskEntity.getContent();
            this.completed = taskEntity.getCompleted();  // DTO 담아서
            this.completeDate = taskEntity.getDeadline();

            responseDtoList.add(new TaskResponseDto(content, completed, completeDate));  // 리스트에 저장 (외부에서 조회 시 Getter 사용)
        }
    }
}
