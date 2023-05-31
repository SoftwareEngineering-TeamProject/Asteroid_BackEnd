package com.example.todolist.controller;

import com.example.todolist.dto.UserRequestDto;
import com.example.todolist.service.TaskService;
import com.example.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @Autowired
    TaskService taskService;
    @Autowired
    UserService userService;

    @PostMapping("v1/auth/register")
    public UserRequestDto registerUser(@RequestBody UserRequestDto userRequestDto){
        userService.createUser(userRequestDto);
        return userRequestDto;
    }


}
