package dev.asteroid.todolist.domain.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.asteroid.todolist.domain.list.ListEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import static jakarta.persistence.GenerationType.*;

@Table(name = "TASK")
@NoArgsConstructor
@Getter @Setter
@Entity
public class TaskEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "task_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @NotNull
    @JoinColumn(name = "list_id")
    private ListEntity list;

    private String content;
    private Boolean completed;

    @JsonFormat(pattern = "yyyy.MM.dd")
    private Date deadline;

    public TaskEntity(ListEntity list, String content, Boolean completed, Date deadline) {
        this.list = list;
        this.content = content;
        this.completed = completed;
        this.deadline = deadline;
    }
}
