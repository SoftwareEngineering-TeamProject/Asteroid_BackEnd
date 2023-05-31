package com.example.todolist.repository;

import com.example.todolist.domain.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.hibernate.metamodel.internal.MemberResolver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepository {

    private final EntityManager em;

    public void save(User user){
        em.persist(user);
    }
    public void delete(User user){
        em.remove(user);
    }
    public User findById(Long id){
        return em.find(User.class,id);
    }


}
