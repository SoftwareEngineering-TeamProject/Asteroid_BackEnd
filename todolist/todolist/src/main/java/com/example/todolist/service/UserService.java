package com.example.todolist.service;

import com.example.todolist.domain.User;
import com.example.todolist.dto.UserRequestDto;
import com.example.todolist.repository.UserInterface;
import com.example.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserInterface userInterface;

    public void createUser(UserRequestDto userRequestDto){
        User user = new User();
        user.setEmail(userRequestDto.getEmail());
        user.setName(userRequestDto.getName());
        user.setPassword(userRequestDto.getPassword());

        userRepository.save(user);
    }
    public void deleteUser(User user){
        userRepository.delete(user);
    }
}
