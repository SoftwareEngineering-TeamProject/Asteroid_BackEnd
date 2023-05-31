package com.example.todolist.repository;

import com.example.todolist.domain.Task;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskRepository {

    private final EntityManager em;

    public void save(Task task){
        em.persist(task);
    }
    public void delete(Task task){
        em.remove(task);
    }
    public Task findById(Long id){
        return em.find(Task.class,id);
    }
    public List<Task> findAll(Long userId){
        return em.createQuery("select m from task m where m.user=:userId",Task.class)
                .setParameter("userId",userId)
                .getResultList();
    }

    public List<Task> findByComplete(Long userId){
        return em.createQuery("select m from task m where m.complete=:true and m.user=:userId", Task.class)
                .setParameter("userId",userId)
                .getResultList();
    }


}
