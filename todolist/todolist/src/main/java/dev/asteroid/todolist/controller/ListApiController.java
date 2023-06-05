package dev.asteroid.todolist.controller;

import dev.asteroid.todolist.dto.ListRequestDto;
import dev.asteroid.todolist.dto.ListResponseDto;
import dev.asteroid.todolist.service.ListService;
import dev.asteroid.todolist.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ListApiController {
    @Autowired
    MemberService memberService;
    @Autowired
    ListService listService;

    @PostMapping("/list/register")
    ResponseEntity register(@RequestBody ListRequestDto requestDto, HttpServletRequest request){
        HttpSession session = request.getSession();
        Long memberId = (Long) session.getAttribute("currentMember");
        return ResponseEntity.status(HttpStatus.CREATED).body(listService.register(memberId, requestDto.getTitle()));
    }
    @GetMapping("/list/lists")
    ResponseEntity read(HttpServletRequest request){
        HttpSession session = request.getSession();
        Long memberId = (Long) session.getAttribute("currentMember");
        return ResponseEntity.status(HttpStatus.CREATED).body(listService.read(memberId));
    }
    @PatchMapping("/list/{listId}")
    ResponseEntity update(@PathVariable("listId") Long listId,@RequestBody ListResponseDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(listService.update(listId,requestDto));
    }
    @DeleteMapping("/list/{listId}")
    ResponseEntity delete(@PathVariable Long listId){
        return ResponseEntity.status(HttpStatus.CREATED).body(listService.delete(listId));
        }

}
