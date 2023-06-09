package dev.asteroid.todolist.controller;

import dev.asteroid.todolist.dto.TaskRequestDto;
import dev.asteroid.todolist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TaskApiController {

    @Autowired
    TaskService taskService;

    // 작업 등록
    @PostMapping("/{userId}/todo/{listId}/post")
    public ResponseEntity postTask(@RequestBody TaskRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(requestDto));
    }

    // 작업 전체 조회
    @GetMapping("/{userId}/todo/{listId}")
    public ResponseEntity getAllTask(@PathVariable Long listId) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findAllInCurrent(listId));
    }

    // 작업 단일 조회
    @GetMapping("/{userId}/todo/{listId}/{taskId}")
    public ResponseEntity getOneTask(@PathVariable Long taskId) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(taskId));
    }

    // 작업 편집
    @PatchMapping("/{userId}/todo/{listId}/{taskId}")
    public ResponseEntity updateTask(@PathVariable Long taskId, @RequestBody TaskRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskService.update(taskId, requestDto));
    }

    // 작업 삭제
    @DeleteMapping("/{userId}/todo/{listId}/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.delete(taskId);
        ResponseEntity.noContent();
    }

    // 작업 마감일 정렬
    @GetMapping("/{userId}/todo/{listId}/deadline")
    public ResponseEntity getAllTaskSortByDeadline(@PathVariable Long listId) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.sortByDeadline(listId));
    }

    // 작업 우선순위 정렬


    // 완료된 작업만 보는 옵션
    @GetMapping("/{userId}/todo/{listId}/completed")
    public ResponseEntity getAllTaskSortByCompleted(@PathVariable Long listId) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.sortByCompleted(listId));
    }

    // 완료되지 않은 작업만 보는 옵션
    @GetMapping("/{userId}/todo/{listId}/uncompleted")
    public ResponseEntity getAllTaskSortByUncompleted(@PathVariable Long listId) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.sortByUncompleted(listId));
    }
}
