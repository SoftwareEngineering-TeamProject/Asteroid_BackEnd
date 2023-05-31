package com.example.todolist.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter
@Table(name="User_Table")
public class User {
    @Id
    @SequenceGenerator(name="T_WD_APLY_APLYSN_GENERATOR", sequenceName="T_WD_APLY_APLY_SN_SEQ", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="T_WD_APLY_APLYSN_GENERATOR")
    @Column(name="user_id")
    private Long id;
    private String email;
    private String password;
    private String name;
    @OneToMany(mappedBy = "user")
    private List<Task> tasks = new ArrayList<>();
}
