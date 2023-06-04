package dev.asteroid.todolist.domain.list;

import dev.asteroid.todolist.domain.member.MemberEntity;
import dev.asteroid.todolist.domain.task.TaskEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.*;

@Table(name = "LIST")
@NoArgsConstructor
@Getter @Setter
@Entity
public class ListEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "list_id")
    private Long id;

    @Column(length = 20)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY) @NotNull
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @OneToMany(mappedBy = "list", cascade = CascadeType.REMOVE)
    List<TaskEntity> taskList = new ArrayList<>();

    // Constructor
    public ListEntity(String title, MemberEntity member) {
        this.title = title;
        this.member = member;
    }

    // 연관관계 편의 메서드
    public void setMember(MemberEntity member) {
        this.member = member;
        member.getListList().add(this);
    }
}
