package dev.asteroid.todolist.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table(name = "TASK")
@NoArgsConstructor
@Getter
@Setter
@Entity
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "task_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @NotNull
    @JoinColumn(name = "list_id")
    private ListEntity list;

    private String content;
    private Boolean completed;

    public TaskEntity(ListEntity list, String content, Boolean completed) {
        this.list = list;
        this.content = content;
        this.completed = completed;
    }
}