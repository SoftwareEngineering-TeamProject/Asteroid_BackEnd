package dev.asteroid.todolist.repository;

import dev.asteroid.todolist.domain.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<ListEntity,Long> {
}
