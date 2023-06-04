package dev.asteroid.todolist.domain.member;

import dev.asteroid.todolist.domain.list.ListEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table(name = "MEMBER")
@NoArgsConstructor
@Getter @Setter
@Entity
public class MemberEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 40)
    private String email;

    @Column(length = 20)
    private String password;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    List<ListEntity> listList = new ArrayList<>();

    public MemberEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
