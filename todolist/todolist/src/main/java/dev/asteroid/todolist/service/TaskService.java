package dev.asteroid.todolist.service;

import dev.asteroid.todolist.domain.TaskEntity;
import dev.asteroid.todolist.dto.TaskRequestDto;
import dev.asteroid.todolist.dto.TaskResponseDto;
import dev.asteroid.todolist.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;


    public Long save(TaskRequestDto requestDto) {
        return taskRepository.save(requestDto.toEntity()).getId();
    }

    public List<TaskResponseDto> findAllInCurrent(Long listId) {
        List<TaskEntity> taskEntities = taskRepository.findAllInCurrent(listId).get();
        TaskResponseDto responseDto = new TaskResponseDto(taskEntities);  // 조회한 엔티티들을 모두 DTO 로 변환
        return responseDto.getResponseDtoList();
    }

    public TaskResponseDto findById(Long taskId) {
        Optional<TaskEntity> optionalTask = taskRepository.findById(taskId);
        TaskResponseDto responseDto = new TaskResponseDto();
        if(optionalTask.isPresent()) {
            responseDto = new TaskResponseDto(optionalTask.get().getContent(), optionalTask.get().getCompleted());
        }
        return responseDto;
    }

    @Transactional
    public Long update(Long taskId, TaskRequestDto requestDto) {
        TaskEntity taskEntity = taskRepository.findById(taskId).get();
        if(requestDto.getContent() == null) {
            taskEntity.setCompleted(requestDto.getCompleted());
        } else if(requestDto.getCompleted() == null) {
            taskEntity.setContent(requestDto.getContent());
        } else {
            taskEntity.setContent(requestDto.getContent());
            taskEntity.setCompleted(requestDto.getCompleted());
        }
        return taskEntity.getId();
    }

    @Transactional
    public void delete(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
