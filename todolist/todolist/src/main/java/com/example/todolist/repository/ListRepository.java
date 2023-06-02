package com.example.todolist.repository;

import com.example.todolist.domain.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<ListEntity,Long> {
}
