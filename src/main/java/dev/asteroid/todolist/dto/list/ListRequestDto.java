package dev.asteroid.todolist.dto.list;

import dev.asteroid.todolist.domain.list.ListEntity;
import dev.asteroid.todolist.domain.member.MemberEntity;
import lombok.Getter;

@Getter
public class ListRequestDto {

    private String title;
    private MemberEntity member;

    // ListEntity 만들어서 반환
    public ListEntity toEntity() {
        ListEntity listEntity = new ListEntity(title, member);
        listEntity.setMember(member);
        return listEntity;
    }
}
