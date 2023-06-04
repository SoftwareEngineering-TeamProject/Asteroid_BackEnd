package dev.asteroid.todolist.domain.list;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ListRepository extends JpaRepository<ListEntity, Long> {

    @Query(value = "SELECT * FROM LIST WHERE MEMBER_ID = :userId", nativeQuery = true)
    Optional<List<ListEntity>> findAllInCurrent(@Param("userId") Long userId);
}
