package dev.asteroid.todolist.repository;

import dev.asteroid.todolist.domain.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    @Query(value = "SELECT * FROM member WHERE email = :email AND password = :password", nativeQuery = true)
    Optional<MemberEntity> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query(value = "SELECT * FROM member WHERE email = :email", nativeQuery = true)
    Optional<MemberEntity> findByEmail(@Param("email") String email);
}