package dev.asteroid.todolist.domain.task;

import dev.asteroid.todolist.domain.list.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    @Query(value = "SELECT * FROM TASK WHERE LIST_ID = :listId", nativeQuery = true)
    Optional<List<TaskEntity>> findAllInCurrent(@Param("listId") Long listId);
}
