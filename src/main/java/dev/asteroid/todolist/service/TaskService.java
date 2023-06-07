package dev.asteroid.todolist.service;

import dev.asteroid.todolist.domain.task.TaskEntity;
import dev.asteroid.todolist.domain.task.TaskRepository;
import dev.asteroid.todolist.dto.task.TaskRequestDto;
import dev.asteroid.todolist.dto.task.TaskResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Transactional
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
            responseDto = new TaskResponseDto(optionalTask.get().getContent(), optionalTask.get().getCompleted(), optionalTask.get().getDeadline());
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

    public List<TaskResponseDto> sortByDeadline(Long listId) {
        List<TaskEntity> taskEntities = taskRepository.findAllInCurrentSortByDeadline(listId).get();
        TaskResponseDto responseDto = new TaskResponseDto(taskEntities);  // 조회한 엔티티들을 모두 DTO 로 변환
        return responseDto.getResponseDtoList();
    }
}
