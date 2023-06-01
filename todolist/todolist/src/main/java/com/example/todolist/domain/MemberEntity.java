package com.example.todolist.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @Entity @NoArgsConstructor @Table(name="MEMBER")
public class MemberEntity {
    @Id
    @SequenceGenerator(name="T_WD_APLY_APLYSN_GENERATOR", sequenceName="T_WD_APLY_APLY_SN_SEQ", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.AUTO, generator="T_WD_APLY_APLYSN_GENERATOR")
    @Column(name="member_id")
    private Long id;
    private  String email;
    private  String password;

}
