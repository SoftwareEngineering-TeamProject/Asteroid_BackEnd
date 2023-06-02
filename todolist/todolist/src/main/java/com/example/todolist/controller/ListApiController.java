package com.example.todolist.controller;

import com.example.todolist.dto.ListRequestDto;
import com.example.todolist.dto.ListResponseDto;
import com.example.todolist.service.ListService;
import com.example.todolist.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/list")
@RestController
public class ListApiController {
    @Autowired
    MemberService memberService;
    @Autowired
    ListService listService;

    @PostMapping("register")
    ResponseEntity create(@RequestBody ListRequestDto requestDto, HttpServletRequest request){
        HttpSession session = request.getSession();
        Long memberId = (Long) session.getAttribute("currentMember");
        Long listId = listService.register(memberId, requestDto.getTitle());
        return ResponseEntity.status(HttpStatus.CREATED).body(listId);
    }
    @GetMapping("lists")
    ResponseEntity read(HttpServletRequest request){
        HttpSession session = request.getSession();
        Long memberId = (Long) session.getAttribute("currentMember");
        List<ListResponseDto> lists = listService.read(memberId);
        return ResponseEntity.status(HttpStatus.CREATED).body(lists);
    }
    @PostMapping("update")
    ResponseEntity update(@RequestBody ListRequestDto requestDto, HttpServletRequest request){
        Long listId = listService.update(requestDto);
        if (listId != 0){
            return ResponseEntity.status(HttpStatus.CREATED).body(requestDto);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @DeleteMapping("delete")
    ResponseEntity delete(@RequestBody ListRequestDto requestDto){
        Long listId = listService.delete(requestDto);
        if (listId != 0){
            return ResponseEntity.status(HttpStatus.CREATED).body(listId);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
//
    }
}
