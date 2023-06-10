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

    @PostMapping("/{userId}/todo/{listId}/post")
    public ResponseEntity postTask(@RequestBody TaskRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(requestDto));
    }

    @GetMapping("/{userId}/todo/{listId}")
    public ResponseEntity getAllTask(@PathVariable Long listId) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findAllInCurrent(listId));
    }

    @GetMapping("/{userId}/todo/{listId}/{taskId}")
    public ResponseEntity getOneTask(@PathVariable Long taskId) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(taskId));
    }

    @PatchMapping("/{userId}/todo/{listId}/{taskId}")
    public ResponseEntity updateTask(@PathVariable Long taskId, @RequestBody TaskRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskService.update(taskId, requestDto));
    }

    @DeleteMapping("/{userId}/todo/{listId}/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.delete(taskId);
        ResponseEntity.noContent();
    }
}
