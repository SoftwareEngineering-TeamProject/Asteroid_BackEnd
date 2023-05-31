package com.example.todolist.repository;

import com.example.todolist.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserInterface extends JpaRepository {
    @Query("SELECT M FROM USER M WHERE M.email=:email")
    User findByEmail(@Param("email") String email);
}
