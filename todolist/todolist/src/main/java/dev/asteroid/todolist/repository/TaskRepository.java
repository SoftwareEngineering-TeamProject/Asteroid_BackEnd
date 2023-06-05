package dev.asteroid.todolist.repository;

import dev.asteroid.todolist.domain.TaskEntity;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;

public interface TaskRepository extends JpaAttributeConverter<TaskEntity,Long> {
}
