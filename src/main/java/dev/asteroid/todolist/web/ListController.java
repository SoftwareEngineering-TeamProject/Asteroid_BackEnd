package dev.asteroid.todolist.web;

import dev.asteroid.todolist.dto.list.ListRequestDto;
import dev.asteroid.todolist.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ListController {

    private final ListService listService;

    @PostMapping("/{userId}/todo/post")
    public ResponseEntity postList(@RequestBody ListRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(listService.save(requestDto));
    }

    @GetMapping("/{userId}/todo/{listId}")
    public ResponseEntity getList(@PathVariable Long listId) {
        return ResponseEntity.status(HttpStatus.OK).body(listService.findById(listId));
    }

    @PatchMapping("/{userId}/todo/{listId}")
    public ResponseEntity updateList(@PathVariable Long listId, @RequestBody ListRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(listService.update(listId, requestDto));
    }

    @DeleteMapping("/{userId}/todo/{listId}")
    public void deleteList(@PathVariable Long listId) {
        listService.delete(listId);
        ResponseEntity.noContent();
    }
}
