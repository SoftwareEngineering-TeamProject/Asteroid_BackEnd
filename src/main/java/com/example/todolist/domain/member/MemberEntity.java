package com.example.todolist.domain.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table(name = "MEMBER")
@NoArgsConstructor
@Getter
@Setter
@Entity
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 40)
    private String email;

    @Column(length = 20)
    private String password;

    public MemberEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
