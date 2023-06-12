package dev.asteroid.todolist.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @Table(name="list")
public class ListEntity {
    @Id
    @SequenceGenerator(name="T_WD_APLY_APLYSN_GENERATOR", sequenceName="T_WD_APLY_APLY_SN_SEQ", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.AUTO, generator="T_WD_APLY_APLYSN_GENERATOR")
    @Column(name="list_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private MemberEntity member;
    private String title;
    @OneToMany(mappedBy = "list")
    private List<TaskEntity> tasks = new ArrayList<>();
}
