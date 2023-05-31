package com.example.todolist.service;

import com.example.todolist.domain.Task;
import com.example.todolist.domain.User;
import com.example.todolist.dto.TaskRequestDto;
import com.example.todolist.repository.TaskRepository;
import com.example.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    public void createTask(TaskRequestDto taskRequestDto){
        User user = userRepository.findById(taskRequestDto.getUserId());

        Task task = Task.builder()
                .user(user)
                .month(taskRequestDto.getMonth())
                .day(taskRequestDto.getDay())
                .title(taskRequestDto.getTitle())
                .content(taskRequestDto.getContent())
                .complete(false)
                .alarm(taskRequestDto.getAlarm())
                .build();
        taskRepository.save(task);
    }
    public void deleteTask(TaskRequestDto taskRequestDto){

        User user = userRepository.findById(taskRequestDto.getUserId());
        Task task = Task.builder()
                .user(user)
                .month(taskRequestDto.getMonth())
                .day(taskRequestDto.getDay())
                .title(taskRequestDto.getTitle())
                .content(taskRequestDto.getContent())
                .complete(taskRequestDto.getComplete())
                .alarm(taskRequestDto.getAlarm())
                .build();
        taskRepository.delete(task);
    }

    public List<TaskRequestDto>  findByDay(int day, Long userId){
        User user = userRepository.findById(userId);
        List<Task> tasks = user.getTasks();
        List<TaskRequestDto> taskRequestDtoList = new ArrayList<>();
        List<Task> taskCollectors = tasks.stream()
                .filter(u -> u.getDay() == day)
                .collect(Collectors.toList());
        System.out.println(taskCollectors);

        for(Task task :taskCollectors ){
            TaskRequestDto dto = TaskRequestDto.builder()
                    .userId(userId)
                    .month(day)
                    .day(task.getDay())
                    .title(task.getTitle())
                    .content(task.getContent())
                    .complete(task.getComplete())
                    .alarm(task.getAlarm())
                    .build();
            taskRequestDtoList.add(dto);
        }
        return taskRequestDtoList;
    }
    public List<TaskRequestDto> findByMonth(int month, Long userId){
        User user = userRepository.findById(userId);
        List<Task> tasks = user.getTasks();
        List<TaskRequestDto> taskRequestDtoList = new ArrayList<>();
        List<Task> taskCollectors = tasks.stream()
                .filter(u -> u.getMonth() == month)
                .collect(Collectors.toList());
        System.out.println(taskCollectors);

        for(Task task :taskCollectors ){
            TaskRequestDto dto = TaskRequestDto.builder()
                    .userId(userId)
                    .month(month)
                    .day(task.getDay())
                    .title(task.getTitle())
                    .content(task.getContent())
                    .complete(task.getComplete())
                    .alarm(task.getAlarm())
                    .build();
            taskRequestDtoList.add(dto);
        }
        return taskRequestDtoList;
    }


    public List<TaskRequestDto> findAllTask(Long userId) {
        User user = userRepository.findById(userId);
        List<Task> tasks = user.getTasks();
        List<TaskRequestDto> taskRequestDtoList = new ArrayList<>();
        for(Task task : tasks) {
            TaskRequestDto dto = TaskRequestDto.builder()
                    .userId(userId)
                    .month(task.getMonth())
                    .day(task.getDay())
                    .title(task.getTitle())
                    .content(task.getContent())
                    .complete(task.getComplete())
                    .alarm(task.getAlarm())
                    .build();

            taskRequestDtoList.add(dto);

        }
        return taskRequestDtoList;
    }
    public List<TaskRequestDto> findAllCompleteTask(Long userId){
        List<Task> tasks = taskRepository.findByComplete(userId);
        List<TaskRequestDto> taskRequestDtoList = new ArrayList<>();
        for(Task task : tasks) {
            TaskRequestDto dto = TaskRequestDto.builder()
                    .userId(userId)
                    .month(task.getMonth())
                    .day(task.getDay())
                    .title(task.getTitle())
                    .content(task.getContent())
                    .complete(task.getComplete())
                    .alarm(task.getAlarm())
                    .build();

            taskRequestDtoList.add(dto);

        }
        return taskRequestDtoList;
    }

}
