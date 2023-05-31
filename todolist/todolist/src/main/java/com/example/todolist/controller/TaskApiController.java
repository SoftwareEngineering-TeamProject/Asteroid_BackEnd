package com.example.todolist.controller;

import com.example.todolist.domain.Task;
import com.example.todolist.dto.TaskRequestDto;
import com.example.todolist.service.TaskService;
import com.example.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskApiController {
    @Autowired
    TaskService taskService;
    @Autowired
    UserService userService;

    @PostMapping("v1/todo/register/")
    public TaskRequestDto registerTask(@RequestBody TaskRequestDto taskRequestDto){
        taskService.createTask(taskRequestDto);
        return taskRequestDto;
    }
    @DeleteMapping("v1/todo/delete/")
    public TaskRequestDto  deleteTask(@RequestBody TaskRequestDto taskRequestDto){
        taskService.deleteTask(taskRequestDto);
        return taskRequestDto;
    }
    @GetMapping("v1/todo/")
    public List<TaskRequestDto> taskList(@RequestParam("userid") Long userId){
        return taskService.findAllTask(userId);
    }
    @GetMapping("v1/todo/month/")
    public List<TaskRequestDto> taskListByMonth(@RequestParam("month") int month,@RequestParam("userid") Long userId ){
        return taskService.findByMonth(month,userId);
    }
    @GetMapping("v1/todo/day/")
    public List<TaskRequestDto> taskListByDay(@RequestParam("day") int day,@RequestParam("userid") Long userId ){
        return taskService.findByDay(day,userId);
    }
    @GetMapping("v1/todo/complete/")
    public List<TaskRequestDto> tasKListByComplete(@RequestParam("userid") Long userId){
        return taskService.findAllCompleteTask(userId);
    }


}
