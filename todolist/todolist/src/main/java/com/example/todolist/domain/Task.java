package com.example.todolist.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity @Setter @Getter
@NoArgsConstructor
@Table(name="Task_Table")
public class Task {

    @Id
    @SequenceGenerator(name="T_WD_APLY_APLYSN_GENERATOR", sequenceName="T_WD_APLY_APLY_SN_SEQ", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="T_WD_APLY_APLYSN_GENERATOR")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name="task_month")
    private int month;
    @Column(name = "task_day")
    private int day;
    private String title;
    private String content;
    private Boolean complete;
    private Boolean alarm;

    @Builder
    public Task(User user, int month, int day, String title, String content, Boolean complete, Boolean alarm){
        this.user = user;
        this.month = month;
        this.day = day;
        this.title = title;
        this.content = content;
        this.complete = complete;
        this.alarm = alarm;
    }



}