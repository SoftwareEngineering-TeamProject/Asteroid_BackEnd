package dev.asteroid.todolist.repository;

import dev.asteroid.todolist.domain.TaskEntity;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
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

    @Query(value = "SELECT * FROM TASK WHERE LIST_ID = :listId ORDER BY DEADLINE", nativeQuery = true)
    Optional<List<TaskEntity>> findAllInCurrentSortByDeadline(@Param("listId") Long listId);

    @Query(value = "SELECT * FROM TASK WHERE LIST_ID = :listId AND COMPLETED = TRUE", nativeQuery = true)
    Optional<List<TaskEntity>> findAllInCurrentSortByCompleted(@Param("listId") Long listId);

    @Query(value = "SELECT * FROM TASK WHERE LIST_ID = :listId AND COMPLETED = FALSE", nativeQuery = true)
    Optional<List<TaskEntity>> findAllInCurrentSortByUnCompleted(@Param("listId") Long listId);
}